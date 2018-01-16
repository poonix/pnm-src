package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 5/13/17.
 */

public class PendidikanTerakhirModel implements BaseMasterModel{

    /*
    {
      "id": 1,
      "pendidikan": "S1"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("pendidikan")
    @Expose
    private String pendidikan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    @Override
    public String toString() {
        return getPendidikan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
