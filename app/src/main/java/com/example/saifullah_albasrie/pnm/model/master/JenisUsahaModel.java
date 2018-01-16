package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class JenisUsahaModel implements BaseMasterModel{

    /*
    "jenis_usaha": [
    {
      "id": 1,
      "nama_jenis_usaha": "perdagangan"
    },
    {
      "id": 2,
      "nama_jenis_usaha": "produksi"
    },
    {
      "id": 3,
      "nama_jenis_usaha": "jasa"
    },
    {
      "id": 4,
      "nama_jenis_usaha": "pertanian, perkebunan"
    },
    {
      "id": 5,
      "nama_jenis_usaha": "perikanan, perternakan"
    }
  ],
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama_jenis_usaha")
    @Expose
    private String namaJenisUsaha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJenisUsaha() {
        return namaJenisUsaha;
    }

    public void setNamaJenisUsaha(String namaJenisUsaha) {
        this.namaJenisUsaha = namaJenisUsaha;
    }

    @Override
    public String toString() {
        return getNamaJenisUsaha();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
