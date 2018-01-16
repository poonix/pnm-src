package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PlafonModel implements BaseMasterModel {

    /*
    "id": 1,
      "plafon": "ASBES"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("plafon")
    @Expose
    private String plafon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlafon() {
        return plafon;
    }

    public void setPlafon(String plafon) {
        this.plafon = plafon;
    }

    @Override
    public String toString() {
        return getPlafon();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
