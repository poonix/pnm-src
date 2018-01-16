package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/5/17.
 */

public class ProvinsiModel implements BaseMasterModel{

    /*
    "provinsi": [
    {
      "id": 1,
      "nama_provinsi": "DKI JAKARTA"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama_provinsi")
    @Expose
    private String namaProvinsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @Override
    public String toString() {
        return getNamaProvinsi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
