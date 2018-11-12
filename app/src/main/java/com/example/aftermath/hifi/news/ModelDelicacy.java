package com.example.aftermath.hifi.news;

import java.io.Serializable;

public class ModelDelicacy implements Serializable {
    String delicacyHeader, delicacyBody;
    int delicacyPicture;

    public ModelDelicacy(String delicacyHeader, String delicacyBody, int delicacyPicture) {
        this.delicacyHeader = delicacyHeader;
        this.delicacyBody = delicacyBody;
        this.delicacyPicture = delicacyPicture;
    }

    public String getDelicacyHeader() {
        return delicacyHeader;
    }

    public void setDelicacyHeader(String delicacyHeader) {
        this.delicacyHeader = delicacyHeader;
    }

    public String getDelicacyBody() {
        return delicacyBody;
    }

    public void setDelicacyBody(String delicacyBody) {
        this.delicacyBody = delicacyBody;
    }

    public int getDelicacyPicture() {
        return delicacyPicture;
    }

    public void setDelicacyPicture(int delicacyPicture) {
        this.delicacyPicture = delicacyPicture;
    }
}
