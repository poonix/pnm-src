package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/5/17.
 */

public class KecamatanModel implements BaseMasterModel{

    /*
    "kecamatan": [
    {
      "id": 17,
      "id_provinsi": 1,
      "id_kabupaten_kota": 3,
      "nama_kecamatan": "KEBAYORAN BARU"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("id_provinsi")
    @Expose
    private String idProvinsi;

    @SerializedName("id_kabupaten_kota")
    @Expose
    private String idKabupaten;

    @SerializedName("nama_kecamatan")
    @Expose
    private String namaKecamatan;

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

    public String getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(String idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    @Override
    public String toString() {
        return getNamaKecamatan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
