package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisDokumenModel implements BaseMasterModel{

    /*
    {
  "jenis_dokumen": [
    {
      "id": 7,
      "jenis_dokumen": "Covernote"
    },
    {
      "id": 8,
      "jenis_dokumen": "KTP"
    },
    {
      "id": 9,
      "jenis_dokumen": "SIM"
    },
    {
      "id": 10,
      "jenis_dokumen": "KK"
    }
  ]
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_dokumen")
    @Expose
    private String jenisDokumen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisDokumen() {
        return jenisDokumen;
    }

    public void setJenisDokumen(String jenisDokumen) {
        this.jenisDokumen = jenisDokumen;
    }

    @Override
    public String toString() {
        return getJenisDokumen();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
