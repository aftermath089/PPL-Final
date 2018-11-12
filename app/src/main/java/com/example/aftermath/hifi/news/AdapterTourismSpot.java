package com.example.aftermath.hifi.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aftermath.hifi.R;

import java.util.ArrayList;

public class AdapterTourismSpot extends RecyclerView.Adapter<AdapterTourismSpot.ViewHolder> {
    private ArrayList<ModelTourismSpot> modelTourismSpots;
    private Context context;
    private int i;

    public AdapterTourismSpot(ArrayList<ModelTourismSpot> modelTourismSpots, Context context){
        this.modelTourismSpots=modelTourismSpots;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeaderTourismSpot;
        ImageView ivTourismSpot;
        public ViewHolder(View view){
            super(view);
            tvHeaderTourismSpot = view.findViewById(R.id.tv_container_news);
            ivTourismSpot = view.findViewById(R.id.iv_container_news);
        }
    }

    @NonNull
    @Override
    public AdapterTourismSpot.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;
        view = layoutInflater.inflate(R.layout.cardview_container_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTourismSpot.ViewHolder holder, final int position) {
        holder.ivTourismSpot.setImageResource(modelTourismSpots.get(position).getTourismSpotPicture());
        holder.tvHeaderTourismSpot.setText(modelTourismSpots.get(position).getTourismSpotHeader());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, ActivityNewsContainer.class);
                        sendData(position, intent);
                        ActivityNewsContainer.status="update";
                        context.startActivity(intent);
                    }
                }, 300);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelTourismSpots.size();
    }

    private void sendData(int position, Intent intent){
        Bundle bundle = new Bundle();
        bundle.putSerializable("tSpotData", modelTourismSpots.get(position));
        bundle.putInt("tSpotPosition",position);
        intent.putExtras(bundle);
        notifyDataSetChanged();
    }
}
