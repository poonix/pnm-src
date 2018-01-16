package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class JenisAgunanModel implements BaseMasterModel{

    /*
    "jenis_usaha": [
    {
      "id": 1,
      "jenis_agunan": "TANAH"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_agunan")
    @Expose
    private String jenisAgunan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisAgunan() {
        return jenisAgunan;
    }

    public void setJenisAgunan(String jenisAgunan) {
        this.jenisAgunan = jenisAgunan;
    }

    @Override
    public String toString() {
        return getJenisAgunan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
