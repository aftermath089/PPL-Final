package com.example.aftermath.hifi.news;

import java.util.ArrayList;

public class DataDelicacies {
    ArrayList<String> delicacyHeader = new ArrayList<>();
    ArrayList<String> delicacyBody = new ArrayList<>();
    ArrayList<Integer> delicacyImage = new ArrayList<>();

    public void addData(String delicacyHeader, String delicacyBody, Integer delicacyImage){
        this.delicacyHeader.add(delicacyHeader);
        this.delicacyBody.add(delicacyBody);
        this.delicacyImage.add(delicacyImage);
    }


}
