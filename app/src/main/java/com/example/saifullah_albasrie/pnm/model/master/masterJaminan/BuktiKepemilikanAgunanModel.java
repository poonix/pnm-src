package com.example.saifullah_albasrie.pnm.model.master.masterJaminan;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class BuktiKepemilikanAgunanModel implements BaseMasterModel {

    /*
        "id": 1,
        "jenis_kepemilikan": "AKTA HIBAH"
     */

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jenis_kepemilikan")
    @Expose
    private String jenisKepemilikan;
    @SerializedName("prosentase_likuidasi")
    @Expose
    private String prosentaseLikuidasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisKepemilikan() {
        return jenisKepemilikan;
    }

    public void setJenisKepemilikan(String jenisKepemilikan) {
        this.jenisKepemilikan = jenisKepemilikan;
    }

    @Override
    public String toString() {
        return getJenisKepemilikan();
    }

    public String getProsentaseLikuidasi() {
        return prosentaseLikuidasi;
    }

    public void setProsentaseLikuidasi(String prosentaseLikuidasi) {
        this.prosentaseLikuidasi = prosentaseLikuidasi;
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
