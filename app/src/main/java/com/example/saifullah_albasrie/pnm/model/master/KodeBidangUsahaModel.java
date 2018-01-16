package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class KodeBidangUsahaModel implements BaseMasterModel{

    /*
    "kodeBidangUsaha": [
    {
      "id": "SE5-0001",
      "deskripsi": "SEMUA SEKTOR EKONOMI-------SEMUA SEKTOR EKONOMI"
    },
    {
      "id": "SE5-111101",
      "deskripsi": "Padi-Tanaman Pangan - Padi-Tanaman Pangan-Kehutanan-PERTANIAN, PERBURUAN, PERIKANAN DAN KEHUTANAN"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("kode")
    @Expose
    private String kode;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return getDeskripsi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
