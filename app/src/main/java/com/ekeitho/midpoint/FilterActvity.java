package com.ekeitho.midpoint;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.json.JSONObject;

import java.util.Calendar;

/**
 * Created by ekeitho on 4/9/16.
 */
public class FilterActvity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FilterActvity";
    private FilterActvity activity;
    private Button tomorrow, today, submit;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        activity = this;


        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, null)
                .build();

        AppCompatSpinner spinner = (AppCompatSpinner) findViewById(R.id.radius_spinner);
        Integer nums[] = {5, 15, 20, 25, 50, 100};
        ArrayAdapter<Integer> adapterNum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nums);
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AppCompatSpinner loc_spinner = (AppCompatSpinner) findViewById(R.id.location_spinner);
        String strings[] = {"Current Location", "Customize Location..."};
        ArrayAdapter<String> adapterString = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strings);
        adapterString.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        loc_spinner.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        loc_spinner.setAdapter(adapterString);

        // for less than: number dropdown
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        spinner.setAdapter(adapterNum);

        tomorrow = (Button) findViewById(R.id.tomorrow);
        tomorrow.setOnClickListener(this);

        today = (Button) findViewById(R.id.today);
        today.setOnClickListener(this);


        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(this);





        final Button choose = (Button) findViewById(R.id.chooseDate);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog dpd = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                        if (hourOfDay > 12) {
                            choose.setText((hourOfDay-12)+":"+minute + "PM");
                        } else {
                            choose.setText(hourOfDay+":"+minute + "PM");
                        }

                    }
                }, now.get(Calendar.HOUR), now.get(Calendar.MINUTE), now.get(Calendar.SECOND), false);
                dpd.show(getFragmentManager(),  "time picker");
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.today:
                break;
            case R.id.tomorrow:
                break;
            case R.id.submit_button:
                finish();
                break;
        }
    }
}
