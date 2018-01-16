package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class KusenModel implements BaseMasterModel {

    /*
    "id": 1,
      "kusen": "ALUMUNIUM"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("kusen")
    @Expose
    private String kusen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKusen() {
        return kusen;
    }

    public void setKusen(String kusen) {
        this.kusen = kusen;
    }

    @Override
    public String toString() {
        return getKusen();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
