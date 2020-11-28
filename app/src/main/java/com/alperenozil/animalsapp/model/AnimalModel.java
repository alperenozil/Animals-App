package com.alperenozil.animalsapp.model;

import com.google.gson.annotations.SerializedName;

public class AnimalModel {
    public String name;
    public String location;
    public String diet;
    public String lifespan;
    @SerializedName("image")
    public String imageUrl;
    public Speed speed;
    public Taxonomy taxonomy;

    public AnimalModel(String name) {
        this.name = name;
    }
}
