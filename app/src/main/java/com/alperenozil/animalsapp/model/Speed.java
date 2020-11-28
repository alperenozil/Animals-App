package com.alperenozil.animalsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Speed implements Parcelable {
    String metric;
    String imperial;

    protected Speed(Parcel in) {
        metric = in.readString();
        imperial = in.readString();
    }

    public static final Creator<Speed> CREATOR = new Creator<Speed>() {
        @Override
        public Speed createFromParcel(Parcel in) {
            return new Speed(in);
        }

        @Override
        public Speed[] newArray(int size) {
            return new Speed[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(metric);
        dest.writeString(imperial);
    }
}
