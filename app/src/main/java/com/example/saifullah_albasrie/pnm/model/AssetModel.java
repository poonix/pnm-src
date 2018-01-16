package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class AssetModel {
    @SerializedName("id_jenis_aset")
    @Expose
    private int idJenisAset;
    @SerializedName("jenis_aset")
    @Expose
    private String jenisAset;
    @SerializedName("jumlah_aset")
    @Expose
    private int jumlahAset;

    public int getIdJenisAset() {
        return idJenisAset;
    }

    public void setIdJenisAset(int idJenisAset) {
        this.idJenisAset = idJenisAset;
    }

    public String getJenisAset() {
        return jenisAset;
    }

    public void setJenisAset(String jenisAset) {
        this.jenisAset = jenisAset;
    }

    public int getJumlahAset() {
        return jumlahAset;
    }

    public void setJumlahAset(int jumlahAset) {
        this.jumlahAset = jumlahAset;
    }
}
