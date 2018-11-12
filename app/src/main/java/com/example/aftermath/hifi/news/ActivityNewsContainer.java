package com.example.aftermath.hifi.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aftermath.hifi.R;

public class ActivityNewsContainer extends AppCompatActivity {
    public static String status = "";
    public static String state="";
    ModelTourismSpot modelTourismSpot;
    ModelDelicacy modelDelicacy;
    ImageView ivNews;
    TextView tvNewsHeader,tvNewsBody;
    Toolbar toolbar;

    private void initViews(){
        setContentView(R.layout.activity_news_container);
        toolbar = findViewById(R.id.toolbar_container_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//buat munculin back button di custom toolbar/appbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivNews = findViewById(R.id.iv_container_news);
        tvNewsHeader = findViewById(R.id.tv_container_news_head);
        tvNewsBody = findViewById(R.id.tv_container_news_body);

    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        if(state=="TourismSpot") {
            modelTourismSpot = (ModelTourismSpot) bundle.getSerializable("tSpotData");
        }else if(state=="Delicacies"){
            modelDelicacy = (ModelDelicacy) bundle.getSerializable("delicaciesData");
        }
        setLayoutData();
    }

    private void setLayoutData(){
        if(state=="TourismSpot"){
            toolbar.setTitle(modelTourismSpot.getTourismSpotHeader());
            ivNews.setImageResource(modelTourismSpot.getTourismSpotPicture());
            tvNewsHeader.setText(modelTourismSpot.getTourismSpotHeader());
            tvNewsBody.setText(modelTourismSpot.getTourismSpotBody());
        }else if(state=="Delicacies"){
            toolbar.setTitle(modelDelicacy.getDelicacyHeader());
            ivNews.setImageResource(modelDelicacy.getDelicacyPicture());
            tvNewsHeader.setText(modelDelicacy.getDelicacyHeader());
            tvNewsBody.setText(modelDelicacy.getDelicacyBody());
        }
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
