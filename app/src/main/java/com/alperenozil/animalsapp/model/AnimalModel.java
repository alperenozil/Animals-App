package com.alperenozil.animalsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AnimalModel implements Parcelable {
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

    protected AnimalModel(Parcel in) {
        name = in.readString();
        location = in.readString();
        diet = in.readString();
        lifespan = in.readString();
        imageUrl = in.readString();
        speed = in.readParcelable(Speed.class.getClassLoader());
        taxonomy = in.readParcelable(Taxonomy.class.getClassLoader());
    }

    public static final Creator<AnimalModel> CREATOR = new Creator<AnimalModel>() {
        @Override
        public AnimalModel createFromParcel(Parcel in) {
            return new AnimalModel(in);
        }

        @Override
        public AnimalModel[] newArray(int size) {
            return new AnimalModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(diet);
        dest.writeString(lifespan);
        dest.writeString(imageUrl);
        dest.writeParcelable(speed, flags);
        dest.writeParcelable(taxonomy, flags);
    }
}
