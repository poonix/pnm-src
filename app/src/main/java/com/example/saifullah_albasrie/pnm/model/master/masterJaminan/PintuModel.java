package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PintuModel implements BaseMasterModel {

    /*
    "id": 1,
      "pintu": "DOUBLE TEAKWOOD"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pintu")
    @Expose
    private String pintu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPintu() {
        return pintu;
    }

    public void setPintu(String pintu) {
        this.pintu = pintu;
    }

    @Override
    public String toString() {
        return getPintu();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
