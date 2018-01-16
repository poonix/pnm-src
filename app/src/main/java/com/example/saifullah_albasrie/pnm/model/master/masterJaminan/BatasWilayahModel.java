package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class BatasWilayahModel implements BaseMasterModel {

    /*
    "id": 1,
      "batas_wilayah": "BANGUNAN PEMERINTAHAN"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("batas_wilayah")
    @Expose
    private String batasWilayah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatasWilayah() {
        return batasWilayah;
    }

    public void setBatasWilayah(String batasWilayah) {
        this.batasWilayah = batasWilayah;
    }

    @Override
    public String toString() {
        return getBatasWilayah();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
