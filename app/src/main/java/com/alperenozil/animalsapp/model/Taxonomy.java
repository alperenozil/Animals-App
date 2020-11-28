package com.alperenozil.animalsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Taxonomy implements Parcelable {
    String kingdom;
    String order;
    String family;

    protected Taxonomy(Parcel in) {
        kingdom = in.readString();
        order = in.readString();
        family = in.readString();
    }

    public static final Creator<Taxonomy> CREATOR = new Creator<Taxonomy>() {
        @Override
        public Taxonomy createFromParcel(Parcel in) {
            return new Taxonomy(in);
        }

        @Override
        public Taxonomy[] newArray(int size) {
            return new Taxonomy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kingdom);
        dest.writeString(order);
        dest.writeString(family);
    }
}
