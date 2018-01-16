package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class DindingModel implements BaseMasterModel {

    /*
    "id": 1,
      "dinding": "ASBES"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("dinding")
    @Expose
    private String dinding;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDinding() {
        return dinding;
    }

    public void setDinding(String dinding) {
        this.dinding = dinding;
    }

    @Override
    public String toString() {
        return getDinding();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
