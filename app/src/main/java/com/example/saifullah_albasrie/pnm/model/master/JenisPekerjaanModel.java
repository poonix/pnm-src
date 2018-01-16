package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisPekerjaanModel implements BaseMasterModel{

    /*
    "jenisPekerjaan": [
    {
      "id": 1,
      "nama_pekerjaan": "akunting"
    },
    {
      "id": 2,
      "nama_pekerjaan": "Enginnering"
    },
    {
      "id": 3,
      "nama_pekerjaan": "Customer Service"
    },
    {
      "id": 4,
      "nama_pekerjaan": "Administrasi Umum"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama_pekerjaan")
    @Expose
    private String namaPekerjaan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    @Override
    public String toString() {
        return getNamaPekerjaan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
