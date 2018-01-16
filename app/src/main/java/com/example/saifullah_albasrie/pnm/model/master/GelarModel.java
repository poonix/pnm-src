package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 5/13/17.
 */

public class GelarModel implements BaseMasterModel{

    /*
    {
      "id": 1,
      "gelar": "Sarjana Ekonomi"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("gelar")
    @Expose
    private String gelar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    @Override
    public String toString() {
        return getGelar();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
