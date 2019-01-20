package com.geektech.firstarchitecturelesson.presentation.images.model;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class ImageEntity {
    private String url;

    public ImageEntity(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
