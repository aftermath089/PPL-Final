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

public class AdapterDelicacy extends RecyclerView.Adapter<AdapterDelicacy.ViewHolder> {
    private ArrayList<ModelDelicacy> modelDelicacies;
    private Context context;
    private int i;

    public AdapterDelicacy(ArrayList<ModelDelicacy> modelDelicacies, Context context){
        this.modelDelicacies=modelDelicacies;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeaderDelicacy;
        ImageView ivDelicacy;
        public ViewHolder(View view){
            super(view);
            tvHeaderDelicacy = view.findViewById(R.id.tv_container_news);
            ivDelicacy = view.findViewById(R.id.iv_container_news);
        }
    }

    @NonNull
    @Override
    public AdapterDelicacy.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;
        view = layoutInflater.inflate(R.layout.cardview_container_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDelicacy.ViewHolder holder, final int position) {
        holder.ivDelicacy.setImageResource(modelDelicacies.get(position).getDelicacyPicture());
        holder.tvHeaderDelicacy.setText(modelDelicacies.get(position).getDelicacyHeader());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityNewsContainer.state="Delicacies";
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
        return modelDelicacies.size();
    }

    private void sendData(int position, Intent intent){
        Bundle bundle = new Bundle();
        bundle.putSerializable("delicaciesData", modelDelicacies.get(position));
        bundle.putInt("delicaciesPosition",position);
        intent.putExtras(bundle);
        notifyDataSetChanged();
    }
}
