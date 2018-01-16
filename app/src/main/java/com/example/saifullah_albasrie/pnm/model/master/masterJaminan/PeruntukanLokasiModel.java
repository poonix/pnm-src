package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class PeruntukanLokasiModel implements BaseMasterModel {

    /*
    "id": 1,
      "peruntukan_lokasi": "KOMERSIL"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("peruntukan_lokasi")
    @Expose
    private String peruntukanLokasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeruntukanLokasi() {
        return peruntukanLokasi;
    }

    public void setPeruntukanLokasi(String peruntukanLokasi) {
        this.peruntukanLokasi = peruntukanLokasi;
    }

    @Override
    public String toString() {
        return getPeruntukanLokasi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
