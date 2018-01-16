package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class JenisBuktiKepemilikanModel implements BaseMasterModel {

    /*
        {
      "id": 1,
      "jenis_bukti": "Sertifikat"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jenis_bukti")
    @Expose
    private String jenisBukti;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisBukti() {
        return jenisBukti;
    }

    public void setJenisBukti(String jenisBukti) {
        this.jenisBukti = jenisBukti;
    }

    @Override
    public String toString() {
        return getJenisBukti();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
