package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class ProspekKontakModel implements Parcelable{

    /*
    "kontak": [
    {
      "id": 1,
      "nomor_telp": "0218441437",
      "jenis_telp": null
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nomor_telp")
    @Expose
    private String nomorTelp;

    @SerializedName("jenis_telp")
    @Expose
    private String jenisTelp;

    public ProspekKontakModel() {

    }

    protected ProspekKontakModel(Parcel in) {
        id = in.readInt();
        nomorTelp = in.readString();
        jenisTelp = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nomorTelp);
        dest.writeString(jenisTelp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProspekKontakModel> CREATOR = new Creator<ProspekKontakModel>() {
        @Override
        public ProspekKontakModel createFromParcel(Parcel in) {
            return new ProspekKontakModel(in);
        }

        @Override
        public ProspekKontakModel[] newArray(int size) {
            return new ProspekKontakModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomorTelp() {
        return nomorTelp;
    }

    public void setNomorTelp(String nomorTelp) {
        this.nomorTelp = nomorTelp;
    }

    public String getJenisTelp() {
        return jenisTelp;
    }

    public void setJenisTelp(String jenisTelp) {
        this.jenisTelp = jenisTelp;
    }
}
