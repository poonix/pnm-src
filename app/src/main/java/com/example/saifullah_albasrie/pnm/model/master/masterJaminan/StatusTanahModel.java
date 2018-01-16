package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class StatusTanahModel implements BaseMasterModel {

    /*
    "id": 1,
      "status_tanah": "KOS"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("status_tanah")
    @Expose
    private String statusTanah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusTanah() {
        return statusTanah;
    }

    public void setStatusTanah(String statusTanah) {
        this.statusTanah = statusTanah;
    }

    @Override
    public String toString() {
        return getStatusTanah();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
