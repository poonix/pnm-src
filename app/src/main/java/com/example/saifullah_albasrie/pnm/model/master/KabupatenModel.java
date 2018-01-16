package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/5/17.
 */

public class KabupatenModel implements BaseMasterModel{

    /*
    "kabupatenKota": [
    {
      "id": 7,
      "id_provinsi": 2,
      "nama_kabupatenKota": "TANGERANG"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("id_provinsi")
    @Expose
    private String idProvinsi;

    @SerializedName("nama_kabupatenKota")
    @Expose
    private String namaKabupaten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    @Override
    public String toString() {
        return getNamaKabupaten();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
