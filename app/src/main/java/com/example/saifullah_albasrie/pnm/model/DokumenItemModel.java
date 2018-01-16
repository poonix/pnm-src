package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class DokumenItemModel {
    @SerializedName("jumlah_foto")
    @Expose
    private int jumlahFoto;

    public int getJumlahFoto() {
        return jumlahFoto;
    }

    public void setJumlahFoto(int jumlahFoto) {
        this.jumlahFoto = jumlahFoto;
    }
}
