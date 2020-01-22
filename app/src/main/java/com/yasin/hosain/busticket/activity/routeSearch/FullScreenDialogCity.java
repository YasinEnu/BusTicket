package com.yasin.hosain.busticket.activity.routeSearch;

import android.Manifest;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;
import com.yasin.hosain.busticket.AppData;
import com.yasin.hosain.busticket.R;
import com.yasin.hosain.busticket.activity.routeSearch.model.FromOrToCityModel;
import com.yasin.hosain.busticket.activity.routeSearch.model.FromOrToData;
import com.yasin.hosain.busticket.network.ConnApi;
import com.yasin.hosain.busticket.network.MyNetwork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.GridLayout.HORIZONTAL;

/**
 * Created by YASIN on 24,June,2019
 * Email: yasinenubd5@gmail.com
 */
public class FullScreenDialogCity extends DialogFragment implements View.OnClickListener {

    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    public static String TAG = "FullScreenDialog";
    private RecyclerView cityRecyclerView;

    OnCitySet onCitySet;
    private String toOrFrom;
    private Handler handler;
    private EditText citySearchET;
    private TableLayout predefineDataTL;
    static ArrayList<FromOrToData> cityList = new ArrayList<>();
    private CustomAdapter customAdapter;
    LinearLayout progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.from_and_to_cities_layout, container, false);

        cityRecyclerView=view.findViewById(R.id.cityListRV);
        progressBar=view.findViewById(R.id.progressBarLL);
        onCitySet = (OnCitySet) getActivity();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toOrFrom = getArguments().getString(MainActivity.FULLSCREEN_DIALOG_HEADER, "Search Transport");
        toolbar.setTitle(toOrFrom);

        cityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        customAdapter = new CustomAdapter(getActivity(), cityList, onCitySet, toOrFrom, this);
        cityRecyclerView.setAdapter(customAdapter);
        if (toOrFrom.equals(MainActivity.FROM_STRING)){
            getFromStation();
        }else {
            getToStation(new AppData(getActivity()).getFromID());
        }


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onClick(View view) {

    }


    public interface OnCitySet {
        void setCityData(FromOrToData cityData, String toOrFrom);
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

        Context context;
        ArrayList<FromOrToData> cityArrayList;
        OnCitySet onCitySet;
        String toOrFrom;
        FullScreenDialogCity fullScreenDialogCity;

        CustomAdapter(Context context, List<FromOrToData> cityArrayList, OnCitySet onCitySet, String toOrFrom, FullScreenDialogCity fullScreenDialogCity) {
            this.context = context;
            this.cityArrayList = (ArrayList<FromOrToData>) cityArrayList;
            this.onCitySet = onCitySet;
            this.toOrFrom = toOrFrom;
            this.fullScreenDialogCity = fullScreenDialogCity;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            holder.textView.setText(cityArrayList.get(position).getName());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCitySet.setCityData(cityArrayList.get(position), toOrFrom);
                    setCityDataToSharedPref(toOrFrom, cityArrayList.get(position));
                    fullScreenDialogCity.dismiss();
                }
            });

        }


        @Override
        public int getItemCount() {
            return cityArrayList.size();
        }

        public void clear() {
            cityArrayList.clear();
            notifyDataSetChanged();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.cityNameTv);
            }
        }
    }

    void getFromStation(){
        progressBar.setVisibility(View.VISIBLE);
        cityList.clear();
        customAdapter.notifyDataSetChanged();
        MyNetwork.getRetrofit().create(ConnApi.class).getFromStations().enqueue(new Callback<FromOrToCityModel>() {
            @Override
            public void onResponse(Call<FromOrToCityModel> call, Response<FromOrToCityModel> response) {
                FromOrToCityModel fromOrToCityModel=response.body();

                if (fromOrToCityModel!=null){
                    if (fromOrToCityModel.getMessage()!=null&&fromOrToCityModel.getMessage().equals("REQUEST_FAILED")){
                        Toast.makeText(getActivity(), "No data found!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (fromOrToCityModel.getErrors()==null){
                            for (int i=0;i<fromOrToCityModel.getData().size();i++){
                                cityList.add(fromOrToCityModel.getData().get(i));
                                customAdapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getActivity(), "No data found!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(getActivity(), "Unknown error occurred!!!", Toast.LENGTH_SHORT).show();

                }



                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<FromOrToCityModel> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity(), "Network error!!!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });
    }
    void getToStation(String fromId){
        progressBar.setVisibility(View.VISIBLE);
        cityList.clear();
        customAdapter.notifyDataSetChanged();
        MyNetwork.getRetrofit().create(ConnApi.class).getToStation(fromId).enqueue(new Callback<FromOrToCityModel>() {
            @Override
            public void onResponse(Call<FromOrToCityModel> call, Response<FromOrToCityModel> response) {
                FromOrToCityModel fromOrToCityModel=response.body();

                if (fromOrToCityModel!=null){
                    if (fromOrToCityModel.getMessage()!=null&&fromOrToCityModel.getMessage().equals("REQUEST_FAILED")){
                        Toast.makeText(getActivity(), "No data found!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (fromOrToCityModel.getErrors()==null){
                            for (int i=0;i<fromOrToCityModel.getData().size();i++){
                                cityList.add(fromOrToCityModel.getData().get(i));
                                customAdapter.notifyDataSetChanged();
                            }
                            if (cityList.size()<1){
                                Toast.makeText(getActivity(), "No data found!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getActivity(), "No data found!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(getActivity(), "Unknown error occurred!!!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<FromOrToCityModel> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity(), "Network Error!!!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    private void setCityDataToSharedPref(String toOrFrom, FromOrToData cityData) {
        if (toOrFrom.equals(MainActivity.FROM_STRING)) {
            new AppData(getActivity()).setFromData(cityData.getName());
            new AppData(getActivity()).setFromID(cityData.getId());
        } else {
            new AppData(getActivity()).setToData(cityData.getName());
            new AppData(getActivity()).setToID(cityData.getId());
        }
    }

}


