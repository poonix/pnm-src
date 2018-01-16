package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class SaluranTeleponModel implements BaseMasterModel {

    /*
    "id": 1,
      "saluran_telepon": "1"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("saluran_telepon")
    @Expose
    private String saluranTelepon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaluranTelepon() {
        return saluranTelepon;
    }

    public void setSaluranTelepon(String saluranTelepon) {
        this.saluranTelepon = saluranTelepon;
    }

    @Override
    public String toString() {
        return getSaluranTelepon();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
