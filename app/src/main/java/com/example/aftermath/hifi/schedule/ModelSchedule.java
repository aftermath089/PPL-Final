package com.example.aftermath.hifi.schedule;

import java.io.Serializable;

public class ModelSchedule implements Serializable {
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    private String name, nation, location, time, about;
    private int picture;

    public String getPictureUrl() {
        return pictureurl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureurl = pictureUrl;
    }

    private String pictureurl;

    public ModelSchedule(){

    }
//    public ModelSchedule(String name, String nation, String location, String time, int picture, String about){
//        this.name=name;
//        this.nation=nation;
//        this.location=location;
//        this.time=time;
//        this.picture=picture;
//        this.about=about;
//    }
}
