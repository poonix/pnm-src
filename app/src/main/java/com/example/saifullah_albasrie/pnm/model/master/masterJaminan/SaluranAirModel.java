package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class SaluranAirModel implements BaseMasterModel {

    /*
    "id": 1,
      "saluran_air": "AIR SUMUR"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("saluran_air")
    @Expose
    private String saluranAir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaluranAir() {
        return saluranAir;
    }

    public void setSaluranAir(String saluranAir) {
        this.saluranAir = saluranAir;
    }

    @Override
    public String toString() {
        return getSaluranAir();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
