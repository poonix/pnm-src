package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PondasiModel implements BaseMasterModel {

    /*
    "id": 1,
      "pondasi": "BETON DAN BATU KALI"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pondasi")
    @Expose
    private String pondasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPondasi() {
        return pondasi;
    }

    public void setPondasi(String pondasi) {
        this.pondasi = pondasi;
    }

    @Override
    public String toString() {
        return getPondasi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
