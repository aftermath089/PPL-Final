package com.example.aftermath.hifi.news;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aftermath.hifi.R;

public class ActivityNewsContainer extends AppCompatActivity {
    public static String status = "";

    private void initViews(){
        setContentView(R.layout.activity_news_container);
        Toolbar toolbar = findViewById(R.id.toolbar_container_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//buat munculin back button di custom toolbar/appbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView ivNews = findViewById(R.id.iv_container_news);
        TextView tvNewsHeader = findViewById(R.id.tv_container_news_head);
        TextView tvNewsBody = findViewById(R.id.tv_container_news_body);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    public boolean onSupportNavigateUp() { //method yg aktif ketika supportaction toolbar is true
        onBackPressed();
        return true;
    }
}
