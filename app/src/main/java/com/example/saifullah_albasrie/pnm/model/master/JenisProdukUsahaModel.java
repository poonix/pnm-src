package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisProdukUsahaModel implements BaseMasterModel{

    /*
    JenisProdukUsaha": [
    {
      "id": 1,
      "jenis_produk": "Kebutuhan Pokok"
    },
    {
      "id": 2,
      "jenis_produk": "Perlengkapan Rumah Tangga"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_produk")
    @Expose
    private String namaProdukUsaha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaProdukUsaha() {
        return namaProdukUsaha;
    }

    public void setNamaProdukUsaha(String namaProdukUsaha) {
        this.namaProdukUsaha = namaProdukUsaha;
    }

    @Override
    public String toString() {
        return getNamaProdukUsaha();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
