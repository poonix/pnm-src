package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisHartaModel implements BaseMasterModel{

    /*
    "harta_benda": [
    {
      "id": 1,
      "jenis_harta_benda": "perhiasan"
    },
    {
      "id": 2,
      "jenis_harta_benda": "emas"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_harta_benda")
    @Expose
    private String namaHartaBenda;

    private boolean isChecked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaHartaBenda() {
        return namaHartaBenda;
    }

    public void setNamaHartaBenda(String namaHartaBenda) {
        this.namaHartaBenda = namaHartaBenda;
    }

    @Override
    public String toString() {
        return getNamaHartaBenda();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
