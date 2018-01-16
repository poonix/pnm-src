package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 16-Jan-18.
 */

public class KunjunganAomModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("PR_TGL_REALISASI_KUNJUNGAN ")
    @Expose
    public String PR_TGL_REALISASI_KUNJUNGAN ;

    @SerializedName("PR_KETERANGAN_KUNJUNGAN ")
    @Expose
    public String PR_KETERANGAN_KUNJUNGAN ;

    public KunjunganAomModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }
    public String getPR_TGL_REALISASI_KUNJUNGAN() {
        return PR_TGL_REALISASI_KUNJUNGAN;
    }

    public void setPR_TGL_REALISASI_KUNJUNGAN(String PR_TGL_REALISASI_KUNJUNGAN) {
        this.PR_TGL_REALISASI_KUNJUNGAN = PR_TGL_REALISASI_KUNJUNGAN;
    }
    public String getPR_KETERANGAN_KUNJUNGAN() {
        return PR_KETERANGAN_KUNJUNGAN;
    }

    public void setPR_KETERANGAN_KUNJUNGAN(String PR_KETERANGAN_KUNJUNGAN) {
        this.PR_KETERANGAN_KUNJUNGAN = PR_KETERANGAN_KUNJUNGAN;
    }

}
