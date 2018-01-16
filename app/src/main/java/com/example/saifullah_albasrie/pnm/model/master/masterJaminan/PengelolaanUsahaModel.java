package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PengelolaanUsahaModel implements BaseMasterModel {

    /*
    {
      "id": 1,
      "jenis_pengelolaan": "Dummy Pengelolaan Usaha"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jenis_pengelolaan")
    @Expose
    private String jenisPengelolaan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisPengelolaan() {
        return jenisPengelolaan;
    }

    public void setJenisPengelolaan(String jenisPengelolaan) {
        this.jenisPengelolaan = jenisPengelolaan;
    }

    @Override
    public String toString() {
        return getJenisPengelolaan();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
