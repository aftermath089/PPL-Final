package com.example.aftermath.hifi.schedule;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aftermath.hifi.R;

import java.util.ArrayList;

public class FragmentSchedule extends Fragment {
    public FragmentSchedule(){}
    private RecyclerView rvSchedule;
    private ArrayList<ModelSchedule> listModelSchedule = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        rvSchedule = view.findViewById(R.id.rv_matches);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //test data
        for(int i=0;i<10;i++) {
            ModelSchedule modelSchedule = new ModelSchedule("JOTA THE JETSKI", "INDONESIA", "TENNIS INDOOR SENAYAN", "SELASA, 12 OKTOBER 2099", R.color.colorPrimary, "about player");
            listModelSchedule.add(modelSchedule);
        }
        //
        rvSchedule.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSchedule.setLayoutManager(layoutManager);
        rvSchedule.setAdapter(new AdapterSchedule(listModelSchedule,getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}
