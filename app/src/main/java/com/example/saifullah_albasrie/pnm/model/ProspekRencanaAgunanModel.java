package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekRencanaAgunanModel implements Parcelable{

    @SerializedName("id_jenis_agunan")
    @Expose
    private int idJenisAgunan;
    @SerializedName("jenis_agunan")
    @Expose
    private String jenisAgunan;

    @SerializedName("rencana_no_dokumen")
    @Expose
    private String rencanaNoDokumen;
    @SerializedName("rencana_keterangan")
    @Expose
    private String rencanaKeterangan;

    public ProspekRencanaAgunanModel() {
    }

    protected ProspekRencanaAgunanModel(Parcel in) {
        idJenisAgunan = in.readInt();
        jenisAgunan = in.readString();
        rencanaNoDokumen = in.readString();
        rencanaKeterangan = in.readString();
    }

    public static final Creator<ProspekRencanaAgunanModel> CREATOR = new Creator<ProspekRencanaAgunanModel>() {
        @Override
        public ProspekRencanaAgunanModel createFromParcel(Parcel in) {
            return new ProspekRencanaAgunanModel(in);
        }

        @Override
        public ProspekRencanaAgunanModel[] newArray(int size) {
            return new ProspekRencanaAgunanModel[size];
        }
    };

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

    public String getRencanaNoDokumen() {
        return rencanaNoDokumen;
    }

    public void setRencanaNoDokumen(String rencanaNoDokumen) {
        this.rencanaNoDokumen = rencanaNoDokumen;
    }

    public String getRencanaKeterangan() {
        return rencanaKeterangan;
    }

    public void setRencanaKeterangan(String rencanaKeterangan) {
        this.rencanaKeterangan = rencanaKeterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idJenisAgunan);
        dest.writeString(jenisAgunan);
        dest.writeString(rencanaNoDokumen);
        dest.writeString(rencanaKeterangan);
    }
}
