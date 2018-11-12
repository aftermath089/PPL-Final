package com.example.aftermath.hifi.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class AdapterHighlight extends RecyclerView.Adapter<AdapterHighlight.ViewHolder> {
    private ArrayList<ModelHighlight> modelHighlights;
    private Context context;
    private int i;

    public AdapterHighlight(ArrayList<ModelHighlight> modelHighlights, Context context){
        this.modelHighlights=modelHighlights;
        this.context=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeaderHighlight;
        ImageView ivHighlight;
        public ViewHolder(View view){
            super(view);
            tvHeaderHighlight = view.findViewById(R.id.tv_container_news);
            ivHighlight = view.findViewById(R.id.iv_container_news);
        }
    }

    @NonNull
    @Override
    public AdapterHighlight.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;
        view = layoutInflater.inflate(R.layout.cardview_container_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHighlight.ViewHolder holder, final int position) {
        holder.ivHighlight.setImageResource(modelHighlights.get(position).getHighlightPicture());
        holder.tvHeaderHighlight.setText(modelHighlights.get(position).getHighlightName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //lempar ke youtube]
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(modelHighlights.get(position).getHighlightLink()));
                        context.startActivity(intent);
                    }
                }, 300);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelHighlights.size();
    }

    private void sendData(int position, Intent intent){
        Bundle bundle = new Bundle();
        bundle.putSerializable("highlightData", modelHighlights.get(position));
        bundle.putInt("highlightPosition",position);
        intent.putExtras(bundle);
        notifyDataSetChanged();
    }
}
