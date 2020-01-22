package com.yasin.hosain.busticket.activity.routeSearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.yasin.hosain.busticket.AppData;
import com.yasin.hosain.busticket.R;
import com.yasin.hosain.busticket.activity.busList.BusListActivity;
import com.yasin.hosain.busticket.activity.routeSearch.model.FromOrToData;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import mehdi.sakout.fancybuttons.FancyButton;


public class MainActivity extends AppCompatActivity implements FullScreenDialogCity.OnCitySet {

    public static final String FULLSCREEN_DIALOG_HEADER = "header";


    private LinearLayout fromLL,toLL,dateLL;
    public static final String FROM_STRING="From";
    public static final String TO_STRING="To";
    private TextSwitcher fromTS, toTS;
    private String fromString, toString;
    private ImageView textSwitchIV;
    String fromData="";
    String toData="";
    private Calendar myCalender;
    private SimpleDateFormat simpleDateFormat;
    private TextView dateTV,monthTV,dayTV;
    private FancyButton search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromLL=findViewById(R.id.fromLL);
        toLL=findViewById(R.id.toLL);

        textSwitchIV = findViewById(R.id.textSwitchIV);
        fromTS = findViewById(R.id.busFromCityTS);
        toTS = findViewById(R.id.busToCityTS);
        fromLL = findViewById(R.id.fromLL);
        toLL = findViewById(R.id.toLL);
        dateLL = findViewById(R.id.dateLL);
        myCalender = Calendar.getInstance();
        dateTV = findViewById(R.id.dateTV);
        monthTV = findViewById(R.id.monthTV);
        dayTV = findViewById(R.id.dayTV);
        search=findViewById(R.id.btn_search);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateTV.setText(String.valueOf(myCalender.get(Calendar.DAY_OF_MONTH)));
        monthTV.setText(new DateFormatSymbols().getMonths()[myCalender.get(Calendar.MONTH)]);
        dayTV.setText(new DateFormatSymbols().getWeekdays()[myCalender.get(Calendar.DAY_OF_WEEK)]);

        new AppData(this).setJourneyDate(simpleDateFormat.format(myCalender.getTime()));

        fromTS.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                TextView switcherTextView = new TextView(getApplicationContext());
                switcherTextView.setTextSize(18);
                switcherTextView.setTextColor(Color.BLACK);
                return switcherTextView;
            }
        });
        toTS.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                TextView switcherTextView = new TextView(getApplicationContext());
                switcherTextView.setTextSize(18);
                switcherTextView.setTextColor(Color.BLACK);
                return switcherTextView;
            }
        });

        dateLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        myCalender.set(i, i1, i2);
                        dateTV.setText(String.valueOf(myCalender.get(Calendar.DAY_OF_MONTH)));
                        monthTV.setText(new DateFormatSymbols().getMonths()[myCalender.get(Calendar.MONTH)]);
                        dayTV.setText(new DateFormatSymbols().getWeekdays()[myCalender.get(Calendar.DAY_OF_WEEK)]);
                        new AppData(MainActivity.this).setJourneyDate(simpleDateFormat.format(myCalender.getTime()));
                    }
                }, myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 10000);
                datePickerDialog.show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = ((TextView) fromTS.getCurrentView()).getText().toString();
                String to = ((TextView) toTS.getCurrentView()).getText().toString();
                if (!from.isEmpty() && !(from.equals(FROM_STRING)) && !to.isEmpty() && !(to.equals(TO_STRING))) {

                    if (!from.equals(to) && (!to.equals(from))) {

                        startActivity(new Intent(MainActivity.this, BusListActivity.class));

                    } else {
                        Toast.makeText(MainActivity.this, "It seems your selected same data for both field", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please enter all the data first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        fromString = FROM_STRING;
        toString = TO_STRING;
         fromData= new AppData(this).getFromData();
         toData= new AppData(this).getToData();
        if (fromData != null && !(fromData.isEmpty()) && !fromData.equals("null")) {
            fromTS.setText(fromData);
            fromString = fromData;
        } else {
            fromTS.setText(fromString);
        }
        if (toData != null && !(toData.isEmpty()) && !toData.equals("null")) {
            toTS.setText(toData);
            toString = toData;
        } else {
            toTS.setText(toString);
        }

        Animation inAnim = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation outAnim = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        inAnim.setDuration(200);
        outAnim.setDuration(200);
        fromTS.setInAnimation(inAnim);
        fromTS.setOutAnimation(outAnim);
        toTS.setInAnimation(inAnim);
        toTS.setOutAnimation(outAnim);
        textSwitchIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toTS.setText(fromString);
                fromTS.setText(toString);
                String from = toString;
                toString = fromString;
                fromString = from;

            }
        });

        fromLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullScreenDialogCity dialog = new FullScreenDialogCity();
                Bundle b = new Bundle();
                b.putString(FULLSCREEN_DIALOG_HEADER, FROM_STRING);
                dialog.setArguments(b);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, FullScreenDialogCity.TAG);
            }
        });
        toLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fromData != null && !(fromData.isEmpty()) && !fromData.equals("null")){
                    FullScreenDialogCity dialog = new FullScreenDialogCity();
                    Bundle b = new Bundle();
                    b.putString(FULLSCREEN_DIALOG_HEADER, TO_STRING);
                    dialog.setArguments(b);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, FullScreenDialogCity.TAG);
                }else {
                    Toast.makeText(MainActivity.this, "Select from station first.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void setCityData(FromOrToData cityData, String toOrFrom) {

        if (toOrFrom.equals(TO_STRING)) {
            toTS.setText(cityData.getName());
            toString = cityData.getName();
            toData=toString;
        } else if (toOrFrom.equals(FROM_STRING)) {
            fromTS.setText(cityData.getName());
            fromString = cityData.getName();
            fromData=fromString;
        }

    }
}
