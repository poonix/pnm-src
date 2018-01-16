package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class JenisProspekModel implements BaseMasterModel{

    /*
    "JenisProspek": [
    {
        "id": 1,
            "jenis_prospek": "baru"
    },
    {
        "id": 2,
            "jenis_prospek": "Top Up"
    },
    {
        "id": 3,
            "jenis_prospek": "3R"
    }
  ],
    */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_prospek")
    @Expose
    private String jenisProspek;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisProspek() {
        return jenisProspek;
    }

    public void setJenisProspek(String jenisProspek) {
        this.jenisProspek = jenisProspek;
    }

    @Override
    public String toString() {
        return getJenisProspek();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
