package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class KondisiPermukaanTanahModel implements BaseMasterModel {

    /*
    "id": 1,
      "kondisi_tanah": "BERKONTUR"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("kondisi_tanah")
    @Expose
    private String kondisiTanah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKondisiTanah() {
        return kondisiTanah;
    }

    public void setKondisiTanah(String kondisiTanah) {
        this.kondisiTanah = kondisiTanah;
    }

    @Override
    public String toString() {
        return getKondisiTanah();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
