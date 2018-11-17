package com.example.aftermath.hifi.schedule;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aftermath.hifi.R;


public class ActivitySchedule extends AppCompatActivity {
    private static final String TAG = "ActivitySchedule";
    public static String status="";
    ModelSchedule modelSchedule;
    ImageView ivAthlete, ivMatchVenue;
    TextView tvAthleteName, tvAtlheteNation, tvAthleteAbout, tvMatchDate, tvMatchVenue;

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        modelSchedule = (ModelSchedule)bundle.getSerializable("scheduleData");
        setLayoutData();
    }

    private void setLayoutData(){

        tvAthleteName.setText(modelSchedule.getName());
        tvAtlheteNation.setText(modelSchedule.getNation());
        tvAthleteAbout.setText(modelSchedule.getAbout());
        tvMatchDate.setText(modelSchedule.getTime());
        tvMatchVenue.setText(modelSchedule.getLocation());
        ivAthlete.setImageResource(modelSchedule.getPicture());
        ivMatchVenue.setImageResource(modelSchedule.getPicture());

        Log.i(TAG, "get location: "+modelSchedule.getLocation());
    }

    private void initViews(){
        setContentView(R.layout.activity_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar_schedule);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//buat munculin back button di custom toolbar/appbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivAthlete = findViewById(R.id.iv_schedule_athlete_photo);
        tvAthleteName = findViewById(R.id.tv_schedule_name);
        tvAtlheteNation = findViewById(R.id.tv_schedule_nation);
        tvAthleteAbout = findViewById(R.id.tv_schedule_about);
        tvMatchDate = findViewById(R.id.tv_schedule_date);
        tvMatchVenue = findViewById(R.id.tv_schedule_venue_name);
        ivMatchVenue = findViewById(R.id.iv_schedule_venue_photo);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        getData();
    }

    @Override
    public boolean onSupportNavigateUp() { //method yg aktif ketika supportaction toolbar is true
        onBackPressed();
        return true;
    }
}
