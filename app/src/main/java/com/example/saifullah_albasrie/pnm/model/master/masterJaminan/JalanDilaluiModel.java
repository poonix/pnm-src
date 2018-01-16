package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class JalanDilaluiModel implements BaseMasterModel {

    /*
    "id": 1,
      "jalan_dilalui": "BUNTU"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jalan_dilalui")
    @Expose
    private String jalanDilalui;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJalanDilalui() {
        return jalanDilalui;
    }

    public void setJalanDilalui(String jalanDilalui) {
        this.jalanDilalui = jalanDilalui;
    }

    @Override
    public String toString() {
        return getJalanDilalui();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
