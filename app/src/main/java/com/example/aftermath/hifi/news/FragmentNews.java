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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rvHighlight = view.findViewById(R.id.rv_highlight);
        rvTourismSpot = view.findViewById(R.id.rv_tourism_spot);
        rvDelicacies = view.findViewById(R.id.rv_delicacy);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //test data
        for(int i=0;i<10;i++) {
            ModelHighlight modelHighlight = new ModelHighlight("", "Highlight", R.color.textWhite);
            listModelHighlight.add(modelHighlight);

            ModelTourismSpot modelTourismSpot = new ModelTourismSpot("MONUMEN NASIONAL", "blablabla blablaabl", R.color.colorPrimary);
            listModelTourismSpot.add(modelTourismSpot);

            ModelDelicacy modelDelicacy = new ModelDelicacy("HEADER MAKANAN", "blablalba",R.color.colorPrimaryDark);
            listModelDelicacy.add(modelDelicacy);
        }
        //

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
