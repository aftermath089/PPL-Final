package com.example.aftermath.hifi.news;

import java.util.ArrayList;

public class DataHighlight {
    ArrayList<String> highlightHeader = new ArrayList<>();
    ArrayList<String> highlightLink= new ArrayList<>();
    ArrayList<Integer> highlightImage = new ArrayList<>();

    public void addData(String highlightHeader, String highlightLink, Integer highlightImage){
        this.highlightHeader.add(highlightHeader);
        this.highlightLink.add(highlightLink);
        this.highlightImage.add(highlightImage);
    }
}
