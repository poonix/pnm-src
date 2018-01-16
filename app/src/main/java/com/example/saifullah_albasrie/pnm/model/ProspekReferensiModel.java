package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekReferensiModel implements Parcelable{

    /*
            "id": 1,
            "jenis_referensi": "1",
            "nama_referensi": "Rendy Kurniawan",
            "telp_referensi": "0219223231"
    */

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("jenis_referensi")
    @Expose
    private int jenisReferensi;

    @SerializedName("nama_referensi")
    @Expose
    private String namaReferensi;
    @SerializedName("telp_referensi")
    @Expose
    private String telpReferensi;

    public ProspekReferensiModel() {

    }

    protected ProspekReferensiModel(Parcel in) {
        id = in.readString();
        jenisReferensi = in.readInt();
        namaReferensi = in.readString();
        telpReferensi = in.readString();
    }

    public static final Creator<ProspekReferensiModel> CREATOR = new Creator<ProspekReferensiModel>() {
        @Override
        public ProspekReferensiModel createFromParcel(Parcel in) {
            return new ProspekReferensiModel(in);
        }

        @Override
        public ProspekReferensiModel[] newArray(int size) {
            return new ProspekReferensiModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJenisReferensi() {
        return jenisReferensi;
    }

    public void setJenisReferensi(int jenisReferensi) {
        this.jenisReferensi = jenisReferensi;
    }

    public String getNamaReferensi() {
        return namaReferensi;
    }

    public void setNamaReferensi(String namaReferensi) {
        this.namaReferensi = namaReferensi;
    }

    public String getTelpReferensi() {
        return telpReferensi;
    }

    public void setTelpReferensi(String telpReferensi) {
        this.telpReferensi = telpReferensi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(jenisReferensi);
        dest.writeString(namaReferensi);
        dest.writeString(telpReferensi);
    }
}
