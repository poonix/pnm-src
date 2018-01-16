package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class AtapModel implements BaseMasterModel {

    /*
    "id": 1,
      "atap": "ASBES"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("atap")
    @Expose
    private String atap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtap() {
        return atap;
    }

    public void setAtap(String atap) {
        this.atap = atap;
    }

    @Override
    public String toString() {
        return getAtap();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
