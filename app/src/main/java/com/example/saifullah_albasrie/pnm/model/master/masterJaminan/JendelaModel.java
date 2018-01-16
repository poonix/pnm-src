package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class JendelaModel implements BaseMasterModel {

    /*
     "id": 1,
      "jendela": "ALUMUNIUM"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jendela")
    @Expose
    private String jendela;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJendela() {
        return jendela;
    }

    public void setJendela(String jendela) {
        this.jendela = jendela;
    }

    @Override
    public String toString() {
        return getJendela();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }


}
