package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class ExumModel implements Parcelable{

    @SerializedName("exum")
    @Expose
    public String exum;

    public ExumModel() {

    }

    protected ExumModel(Parcel in) {
        exum = in.readString();
    }

    public static final Creator<ExumModel> CREATOR = new Creator<ExumModel>() {
        @Override
        public ExumModel createFromParcel(Parcel in) {
            return new ExumModel(in);
        }

        @Override
        public ExumModel[] newArray(int size) {
            return new ExumModel[size];
        }
    };

    public String getExum() {
        return exum;
    }

    public void setExum(String exum) {
        this.exum = exum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(exum);
    }
}
