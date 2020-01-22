package com.yasin.hosain.busticket.activity.busList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yasin.hosain.busticket.AppData;
import com.yasin.hosain.busticket.R;
import com.yasin.hosain.busticket.activity.busList.model.BusData;
import com.yasin.hosain.busticket.activity.busList.model.BusListRequestPOJO;
import com.yasin.hosain.busticket.network.ConnApi;
import com.yasin.hosain.busticket.network.MyNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusListActivity extends AppCompatActivity {

    private RecyclerView busListRV;
    private BusListAdapter busListAdapter;
    private BusData busData=new BusData();
    private AppData appData;
    private LinearLayout progressBarLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        busListRV=findViewById(R.id.busListRV);
        progressBarLL=findViewById(R.id.progressBarLL);
        appData=new AppData(this);
        busListRV.setLayoutManager(new LinearLayoutManager(this));
        busListAdapter=new BusListAdapter(this,busData);
        busListRV.setAdapter(busListAdapter);
        getBusList();
    }

    void getBusList(){

        progressBarLL.setVisibility(View.VISIBLE);

        BusListRequestPOJO busListRequestPOJO=new BusListRequestPOJO();
        busListRequestPOJO.setDate(appData.getJourneyDate());
        busListRequestPOJO.setFromStationId(appData.getFromID());
        busListRequestPOJO.setToStationId(appData.getToID());

        MyNetwork.getRetrofit().create(ConnApi.class).getBusListFromServer(busListRequestPOJO).enqueue(new Callback<BusData>() {
            @Override
            public void onResponse(Call<BusData> call, Response<BusData> response) {
                busData=response.body();
                if (busData!=null){
                    if (busData.getMessage()!=null && busData.getMessage().equals("REQUEST_FAILED")){
                        Toast.makeText(BusListActivity.this, "NO data found!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (busData.getErrors()==null){
                            busListAdapter=new BusListAdapter(BusListActivity.this,busData);
                            busListRV.setAdapter(busListAdapter);
                            if (busData.getData().size()<1){
                                Toast.makeText(BusListActivity.this, "No data found!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(BusListActivity.this, "NO data found!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(BusListActivity.this, "Unknown error occurred!!!", Toast.LENGTH_SHORT).show();

                }



                progressBarLL.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<BusData> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(BusListActivity.this, "Network Error!!!", Toast.LENGTH_SHORT).show();
                progressBarLL.setVisibility(View.GONE);


            }
        });
    }
}
