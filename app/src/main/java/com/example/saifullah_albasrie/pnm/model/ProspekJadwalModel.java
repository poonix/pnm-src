package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekJadwalModel implements Parcelable{

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("realisasi_pertemuan")
    @Expose
    private String realisasiPertemuan;

    @SerializedName("keterangan_pertemuan")
    @Expose
    private String keteranganPertemuan;

    public ProspekJadwalModel() {

    }

    protected ProspekJadwalModel(Parcel in) {
        id = in.readInt();
        realisasiPertemuan = in.readString();
        keteranganPertemuan = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(realisasiPertemuan);
        dest.writeString(keteranganPertemuan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProspekJadwalModel> CREATOR = new Creator<ProspekJadwalModel>() {
        @Override
        public ProspekJadwalModel createFromParcel(Parcel in) {
            return new ProspekJadwalModel(in);
        }

        @Override
        public ProspekJadwalModel[] newArray(int size) {
            return new ProspekJadwalModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealisasiPertemuan() {
        return realisasiPertemuan;
    }

    public void setRealisasiPertemuan(String realisasiPertemuan) {
        this.realisasiPertemuan = realisasiPertemuan;
    }

    public String getKeteranganPertemuan() {
        return keteranganPertemuan;
    }

    public void setKeteranganPertemuan(String keteranganPertemuan) {
        this.keteranganPertemuan = keteranganPertemuan;
    }
}
