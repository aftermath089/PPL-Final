package com.example.aftermath.hifi.schedule;

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

public class AdapterSchedule extends RecyclerView.Adapter<AdapterSchedule.ViewHolder> {
    private ArrayList<ModelSchedule> modelSchedules;
    private Context context;
    private int i;

    private void sendData(int position, Intent intent){
        Bundle bundle = new Bundle();
        bundle.putSerializable("scheduleData", modelSchedules.get(position));
        bundle.putInt("schedulePosition",position);
        intent.putExtras(bundle);
        notifyDataSetChanged();
    }

    public AdapterSchedule(ArrayList<ModelSchedule> modelSchedules, Context context){
        this.modelSchedules=modelSchedules;
        this.context=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAthleteName, tvAthleteNation, tvVenue, tvTime;
        ImageView ivAthlete;

        public ViewHolder(View v) {
            super(v);
            tvAthleteName=v.findViewById(R.id.tv_athlete_name);
            tvAthleteNation=v.findViewById(R.id.tv_athlete_nation);
            tvVenue=v.findViewById(R.id.tv_schedule_venue);
            tvTime=v.findViewById(R.id.tv_schedule_time);
            ivAthlete=v.findViewById(R.id.iv_athlete_photo);
        }
    }

    @NonNull
    @Override
    public AdapterSchedule.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;
        view = layoutInflater.inflate(R.layout.cardview_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSchedule.ViewHolder holder,final int position) {
        holder.ivAthlete.setImageResource(modelSchedules.get(position).getPicture());
        holder.tvAthleteName.setText(modelSchedules.get(position).getName());
        holder.tvAthleteNation.setText(modelSchedules.get(position).getNation());
        holder.tvVenue.setText(modelSchedules.get(position).getLocation());
        holder.tvTime.setText(modelSchedules.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, ActivitySchedule.class);
                        sendData(position, intent);
                        ActivitySchedule.status="update";
                        context.startActivity(intent);
                    }
                }, 300);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelSchedules.size();
    }
}
