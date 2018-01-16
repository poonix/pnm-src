package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class SurveyListJaminanModel implements Parcelable {
    /*
    * "id": 3,
      "id_jenis_agunan": 2,
      "jenis_agunan": "TANAH DAN BANGUNAN"
    * */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_jenis_agunan")
    @Expose
    private int idJenisAgunan;
    @SerializedName("jenis_agunan")
    @Expose
    private String jenisAgunan;

    public SurveyListJaminanModel() {

    }

    protected SurveyListJaminanModel(Parcel in) {
        id = in.readInt();
        idJenisAgunan = in.readInt();
        jenisAgunan = in.readString();
    }

    public static final Creator<SurveyListJaminanModel> CREATOR = new Creator<SurveyListJaminanModel>() {
        @Override
        public SurveyListJaminanModel createFromParcel(Parcel in) {
            return new SurveyListJaminanModel(in);
        }

        @Override
        public SurveyListJaminanModel[] newArray(int size) {
            return new SurveyListJaminanModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJenisAgunan() {
        return idJenisAgunan;
    }

    public void setIdJenisAgunan(int idJenisAgunan) {
        this.idJenisAgunan = idJenisAgunan;
    }

    public String getJenisAgunan() {
        return jenisAgunan;
    }

    public void setJenisAgunan(String jenisAgunan) {
        this.jenisAgunan = jenisAgunan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(idJenisAgunan);
        dest.writeString(jenisAgunan);
    }
}
