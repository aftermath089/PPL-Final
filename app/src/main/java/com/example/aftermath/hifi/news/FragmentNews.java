package com.example.aftermath.hifi.news;


import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aftermath.hifi.R;

import java.util.ArrayList;

public class FragmentNews extends Fragment {
    public FragmentNews(){}
    private RecyclerView rvHighlight, rvTourismSpot, rvDelicacies;
    private ArrayList<ModelHighlight> listModelHighlight = new ArrayList<>();
    private ArrayList<ModelTourismSpot> listModelTourismSpot = new ArrayList<>();
    private ArrayList<ModelDelicacy> listModelDelicacy = new ArrayList<>();
    DataDelicacies dataDelicacies = new DataDelicacies();
    DataTourismSpot dataTourismSpot = new DataTourismSpot();
    DataHighlight dataHighlight = new DataHighlight();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rvHighlight = view.findViewById(R.id.rv_highlight);
        rvTourismSpot = view.findViewById(R.id.rv_tourism_spot);
        rvDelicacies = view.findViewById(R.id.rv_delicacy);

        return view;
    }

    private void prepareData(){
        dataHighlight.addData("HEADER 1", "LINK", R.color.colorAccent);
        dataHighlight.addData("HEADER 2", "LINK2", R.color.textOrange);
        dataHighlight.addData("HEADER 3", "LINK", R.color.colorPrimaryDark);

        dataDelicacies.addData("KETOPRAK","Ketoprak adalah . . . .",R.color.colorPrimaryDark);
        dataDelicacies.addData("KERAK TELOR","Kerak Telor adalah . . . ",R.color.colorPrimary);

        dataTourismSpot.addData("MONUMEN NASIONAL", "Monumen Nasional adalah . . .",R.color.colorAccent);
        dataTourismSpot.addData("BUNDARAN HI","Bundaran HI adalah . . .", R.color.textOrange);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //test data, bakal diisi static data saja(?)
        prepareData();
        for(int i=0;i<dataHighlight.highlightHeader.size();i++) {
            ModelHighlight modelHighlight = new ModelHighlight(dataHighlight.highlightLink.get(i), dataHighlight.highlightHeader.get(i), dataHighlight.highlightImage.get(i));
            listModelHighlight.add(modelHighlight);
        }
        //
        for(int i=0;i<dataTourismSpot.tourismSpotHeader.size();i++){
            ModelTourismSpot modelTourismSpot = new ModelTourismSpot(dataTourismSpot.tourismSpotHeader.get(i), dataTourismSpot.tourismSpotBody.get(i), dataTourismSpot.tourismSpotImage.get(i));
            listModelTourismSpot.add(modelTourismSpot);
        }

        for(int i=0;i<dataDelicacies.delicacyHeader.size();i++){
            ModelDelicacy modelDelicacy = new ModelDelicacy(dataDelicacies.delicacyHeader.get(i), dataDelicacies.delicacyBody.get(i),dataDelicacies.delicacyImage.get(i));
            listModelDelicacy.add(modelDelicacy);
        }

        rvHighlight.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHighlight.setLayoutManager(layoutManager);
        rvHighlight.setAdapter(new AdapterHighlight(listModelHighlight,getContext()));

        rvTourismSpot.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTourismSpot.setLayoutManager(layoutManager2);
        rvTourismSpot.setAdapter(new AdapterTourismSpot(listModelTourismSpot,getContext()));


        rvDelicacies.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDelicacies.setLayoutManager(linearLayoutManager3);
        rvDelicacies.setAdapter(new AdapterDelicacy(listModelDelicacy, getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}
