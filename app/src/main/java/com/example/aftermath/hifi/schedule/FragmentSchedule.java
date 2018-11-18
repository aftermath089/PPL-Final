package com.example.aftermath.hifi.schedule;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aftermath.hifi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FragmentSchedule extends Fragment {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    public FragmentSchedule(){}
    private RecyclerView rvSchedule;
    private ArrayList<ModelSchedule> listModelSchedule = new ArrayList<>();




    private static final String TAG = "Fragment Schedule";
    private void showData(DataSnapshot dataSnapshot){
        listModelSchedule.clear();

        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
            ModelSchedule modelSchedule = new ModelSchedule();
            modelSchedule.setName(dataSnapshot1.getValue(ModelSchedule.class).getName());
            modelSchedule.setNation(dataSnapshot1.getValue(ModelSchedule.class).getNation());

            modelSchedule.setPictureUrl(dataSnapshot1.getValue(ModelSchedule.class).getPictureUrl());
            Log.d(TAG, "showData: "+modelSchedule.getNation()+ modelSchedule.getPictureUrl());

            modelSchedule.setPicture(dataSnapshot1.getValue(ModelSchedule.class).getPicture());
            modelSchedule.setTime(dataSnapshot1.getValue(ModelSchedule.class).getTime());
            modelSchedule.setLocation(dataSnapshot1.getValue(ModelSchedule.class).getLocation());
            modelSchedule.setAbout(dataSnapshot1.getValue(ModelSchedule.class).getAbout());
            listModelSchedule.add(modelSchedule);
        }

        rvSchedule.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSchedule.setLayoutManager(layoutManager);
        rvSchedule.setAdapter(new AdapterSchedule(listModelSchedule,getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        rvSchedule = view.findViewById(R.id.rv_matches);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        databaseReference = FirebaseDatabase.getInstance().getReference("opponents");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //test data
//        for(int i=0;i<10;i++) {
//            ModelSchedule modelSchedule = new ModelSchedule("JOTA THE JETSKI", "INDONESIA", "TENNIS INDOOR SENAYAN", "SELASA, 12 OKTOBER 2099", R.color.colorPrimary, "about player");
//            listModelSchedule.add(modelSchedule);
//        }
        //

        super.onViewCreated(view, savedInstanceState);
    }
}
