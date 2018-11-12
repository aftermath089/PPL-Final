package com.example.aftermath.hifi.news;

import java.io.Serializable;

public class ModelTourismSpot implements Serializable {
    String tourismSpotHeader, tourismSpotBody;
    int tourismSpotPicture;

    public ModelTourismSpot(String tourismSpotHeader, String tourismSpotBody, int tourismSpotPicture){
        this.tourismSpotHeader = tourismSpotHeader;
        this.tourismSpotBody = tourismSpotBody;
        this.tourismSpotPicture = tourismSpotPicture;
    }

    public String getTourismSpotHeader() {
        return tourismSpotHeader;
    }

    public void setTourismSpotHeader(String tourismSpotHeader) {
        this.tourismSpotHeader = tourismSpotHeader;
    }

    public String getTourismSpotBody() {
        return tourismSpotBody;
    }

    public void setTourismSpotBody(String tourismSpotBody) {
        this.tourismSpotBody = tourismSpotBody;
    }

    public int getTourismSpotPicture() {
        return tourismSpotPicture;
    }

    public void setTourismSpotPicture(int tourismSpotPicture) {
        this.tourismSpotPicture = tourismSpotPicture;
    }
}
