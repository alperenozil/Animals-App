package com.alperenozil.animalsapp.model;

public class AnimalModel {
    public String name;
    public String location;
    public String diet;
    public String lifespan;
    public String imageUrl;
    public Speed speed;
    public Taxonomy taxonomy;

    public AnimalModel(String name) {
        this.name = name;
    }
}
