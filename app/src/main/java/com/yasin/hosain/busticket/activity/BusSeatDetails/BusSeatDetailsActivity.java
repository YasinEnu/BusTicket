package com.yasin.hosain.busticket.activity.BusSeatDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yasin.hosain.busticket.R;
import com.yasin.hosain.busticket.activity.BusSeatDetails.model.SeatData;
import com.yasin.hosain.busticket.network.ConnApi;
import com.yasin.hosain.busticket.network.MyNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusSeatDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    public static String KEY="seatKey";
    HorizontalScrollView seatContainerView;
    private int seatGaping=20;
    private int seatSize=100;
    private final String seatAvailable="Available";
    private final String seatBlocked="Blocked";
    private final String seatSold="Sold";
    SeatData seatData=new SeatData();
    private LinearLayout seatViewLL,progressbarLL;
    String coachId="";

    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_seat_details);
        seatContainerView=findViewById(R.id.seatContainerView);
        seatViewLL=findViewById(R.id.seatViewLL);
        progressbarLL=findViewById(R.id.progressBarLL);
        coachId=getIntent().getStringExtra(BusSeatDetailsActivity.KEY);
        getSeatDataFromServer(coachId);

    }

    void getSeatDataFromServer(String coach_id){

        seatViewLL.setVisibility(View.GONE);
        progressbarLL.setVisibility(View.VISIBLE);

        MyNetwork.getRetrofit().create(ConnApi.class).getSeatDetails(coach_id).enqueue(new Callback<SeatData>() {
            @Override
            public void onResponse(Call<SeatData> call, Response<SeatData> response) {
                seatViewLL.setVisibility(View.VISIBLE);
                progressbarLL.setVisibility(View.GONE);
                seatData=response.body();
                if (seatData!=null){
                    if (seatData.getMessage()!=null&&seatData.getMessage().equals("REQUEST_FAILED")){
                        Toast.makeText(BusSeatDetailsActivity.this, "Data not Found!!!", Toast.LENGTH_SHORT).show();
                    }else {

                        if (seatData.getErrors() == null){
                            generateSeatView(seatData);

                        }else {
                            Toast.makeText(BusSeatDetailsActivity.this, "Data not Found!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(BusSeatDetailsActivity.this, "Unknown error occurred!!!", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<SeatData> call, Throwable t) {
                seatViewLL.setVisibility(View.VISIBLE);
                progressbarLL.setVisibility(View.GONE);
                t.printStackTrace();
                Toast.makeText(BusSeatDetailsActivity.this, "Network Error!!!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    void generateSeatView(SeatData seatData){
        int count=0;
        LinearLayout linearLayoutVertical=new LinearLayout(this);
        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayoutVertical.setOrientation(LinearLayout.VERTICAL);
        linearLayoutVertical.setLayoutParams(params);
        linearLayoutVertical.setGravity(Gravity.CENTER);
        seatContainerView.addView(linearLayoutVertical);
        for (int i=0;i<seatData.getData().getSeatRow()+1;i++){
            LinearLayout linearLayoutHorizontal=new LinearLayout(this);
            LinearLayout.LayoutParams params1 =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            linearLayoutHorizontal.setLayoutParams(params1);
            linearLayoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutHorizontal.setGravity(Gravity.CENTER);
            linearLayoutVertical.addView(linearLayoutHorizontal);
            for (int j=0;j<seatData.getData().getSeatCol()+2;j++){
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setGravity(  Gravity.CENTER);
                view.setTextColor(Color.BLACK);
                view.setTag(i+""+ j);
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9f);
                linearLayoutHorizontal.addView(view);

            }
        }
        for (int i=0;i<seatData.getData().getSeats().size();i++){
            String x=seatData.getData().getSeats().get(i).getXaxis().toString();
            String y=seatData.getData().getSeats().get(i).getYaxis().toString();
            TextView textView=seatContainerView.findViewWithTag(x+""+y);
            String seatStatus=seatData.getData().getSeats().get(i).getStatus();
            if(textView!=null){
                if (seatStatus.equals(seatAvailable)){
                    textView.setBackgroundResource(R.drawable.ic_seat_avaliable);
                }else if (seatStatus.equals(seatBlocked)){
                    textView.setBackgroundResource(R.drawable.ic_seat_booked);
                }else if (seatStatus.equals(seatSold)){
                    textView.setBackgroundResource(R.drawable.ic_seat_booked);
                }
                textView.setText(seatData.getData().getSeats().get(i).getSeatNo());
            }
            textView.setId(count);
            textView.setOnClickListener(this);
            count++;
        }

    }

    @Override
    public void onClick(View v) {

        String seatStatus=seatData.getData().getSeats().get(v.getId()).getStatus();
        if (seatStatus.equals(seatAvailable)){
            if (seatData.getData().getSeats().get(v.getId()).isUserSelected()){

                seatData.getData().getSeats().get(v.getId()).setUserSelected(false);
                v.setBackgroundResource(R.drawable.ic_seat_avaliable);

            }else {

                seatData.getData().getSeats().get(v.getId()).setUserSelected(true);
                v.setBackgroundResource(R.drawable.ic_seat_seleted);
            }
        }else {
            Toast.makeText(this, "Seat Booked!!", Toast.LENGTH_SHORT).show();
        }
    }
}
