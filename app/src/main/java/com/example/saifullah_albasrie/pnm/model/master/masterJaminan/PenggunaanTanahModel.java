package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PenggunaanTanahModel implements BaseMasterModel {

    /*
    "id": 1,
      "penggunaan_tanah": "GUDANG"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("penggunaan_tanah")
    @Expose
    private String penggunaanTanah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenggunaanTanah() {
        return penggunaanTanah;
    }

    public void setPenggunaanTanah(String penggunaanTanah) {
        this.penggunaanTanah = penggunaanTanah;
    }

    @Override
    public String toString() {
        return getPenggunaanTanah();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
