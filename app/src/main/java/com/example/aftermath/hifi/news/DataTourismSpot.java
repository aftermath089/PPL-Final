package com.example.aftermath.hifi.news;

import java.util.ArrayList;

public class DataTourismSpot {
    ArrayList<String> tourismSpotHeader = new ArrayList<>();
    ArrayList<String> tourismSpotBody = new ArrayList<>();
    ArrayList<Integer> tourismSpotImage = new ArrayList<>();

    public void addData(String tourismSpotHeader, String tourismSpotBody, Integer tourismSpotImage){
        this.tourismSpotHeader.add(tourismSpotHeader);
        this.tourismSpotBody.add(tourismSpotBody);
        this.tourismSpotImage.add(tourismSpotImage);
    }

}
