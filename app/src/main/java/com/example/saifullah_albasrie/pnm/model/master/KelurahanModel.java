package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/5/17.
 */

public class KelurahanModel implements BaseMasterModel{

    /*
    "kecamatan": [
    {
      "id": 111,
      "id_provinsi": 1,
      "id_kabupaten_kota": 3,
      "id_kecamatan": 18,
      "nama_kelurahan": "GROGOL UTARA"
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

    @SerializedName("id_kecamatan")
    @Expose
    private String idKecamatan;

    @SerializedName("nama_kelurahan")
    @Expose
    private String namaKelurahan;

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

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    @Override
    public String toString() {
        return getNamaKelurahan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
