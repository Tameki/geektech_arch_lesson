package com.geektech.firstarchitecturelesson.data.beer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public class Beer {
    private int id;

    private String name;

    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    public Beer(int id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Beer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + imageUrl;
    }
}
