package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class HubunganDenganBankModel implements BaseMasterModel {

    /*
    "master_hubungan_bank": [
    {
      "id": 1,
      "deskripsi": "Terkait Dgn Bank"
    },
    {
      "id": 2,
      "deskripsi": "Tidak Terkait Dgn Bank"
    }
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return getDeskripsi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
