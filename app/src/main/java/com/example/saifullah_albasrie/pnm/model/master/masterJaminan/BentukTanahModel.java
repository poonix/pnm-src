package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class BentukTanahModel implements BaseMasterModel {

    /*
    "id": 1,
      "bentuk_tanah": "TIDAK BERATURAN"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("bentuk_tanah")
    @Expose
    private String bentukTanah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBentukTanah() {
        return bentukTanah;
    }

    public void setBentukTanah(String bentukTanah) {
        this.bentukTanah = bentukTanah;
    }

    @Override
    public String toString() {
        return getBentukTanah();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
