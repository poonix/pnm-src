package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class LantaiModel implements BaseMasterModel {

    /*
    "id": 1,
      "lantai": "BETON"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("lantai")
    @Expose
    private String lantai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLantai() {
        return lantai;
    }

    public void setLantai(String lantai) {
        this.lantai = lantai;
    }

    @Override
    public String toString() {
        return getLantai();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
