package com.example.aftermath.hifi.news;

import java.io.Serializable;

public class ModelHighlight implements Serializable {
    String highlightLink, highlightName;
    int highlightPicture;

    public ModelHighlight(String highlightLink, String highlightName, int highlightPicture){
        this.highlightLink = highlightLink;
        this.highlightName = highlightName;
        this.highlightPicture = highlightPicture;
    }

    public String getHighlightLink() {
        return highlightLink;
    }

    public void setHighlightLink(String highlightLink) {
        this.highlightLink = highlightLink;
    }

    public String getHighlightName() {
        return highlightName;
    }

    public void setHighlightName(String highlightName) {
        this.highlightName = highlightName;
    }

    public int getHighlightPicture() {
        return highlightPicture;
    }

    public void setHighlightPicture(int highlightPicture) {
        this.highlightPicture = highlightPicture;
    }
}
