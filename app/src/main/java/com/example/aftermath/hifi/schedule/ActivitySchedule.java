package com.example.aftermath.hifi.schedule;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aftermath.hifi.R;
import com.squareup.picasso.Picasso;


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

        Picasso.with(this).load(modelSchedule.getPictureUrl()).into(ivAthlete);


        tvAthleteName.setText(modelSchedule.getName());
        tvAtlheteNation.setText(modelSchedule.getNation());
        tvAthleteAbout.setText(modelSchedule.getAbout());
        tvMatchDate.setText(modelSchedule.getTime());
        tvMatchVenue.setText(modelSchedule.getLocation());
        //ivAthlete.setImageResource(modelSchedule.getPicture());
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

        tvMatchVenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.id/maps/place/Istora+Stadium/@-6.2202283,106.8034752,17z/data=!3m1!4b1!4m5!3m4!1s0x2e69f14d81ff223b:0x7f2d1c6db9fe661f!8m2!3d-6.2202283!4d106.8056639") );
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() { //method yg aktif ketika supportaction toolbar is true
        onBackPressed();
        return true;
    }
}
