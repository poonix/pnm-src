package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 15-Jan-18.
 */

public class AgunanProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("MS_JENIS_AGUNAN_ID")
    @Expose
    public int MS_JENIS_AGUNAN_ID;

    @SerializedName("PR_NO_DOKUMEN")
    @Expose
    public String PR_NO_DOKUMEN;

    @SerializedName("PR_KETERANGAN_AGUNAN")
    @Expose
    private String  PR_KETERANGAN_AGUNAN;

    public AgunanProspekModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getMS_JENIS_AGUNAN_ID() {
        return MS_JENIS_AGUNAN_ID;
    }

    public void setMS_JENIS_AGUNAN_ID(int MS_JENIS_AGUNAN_ID) {
        this.MS_JENIS_AGUNAN_ID = MS_JENIS_AGUNAN_ID;
    }

    public String getPR_NO_DOKUMEN() {
        return PR_NO_DOKUMEN;
    }

    public void setPR_NO_DOKUMEN(String PR_NO_DOKUMEN) {
        this.PR_NO_DOKUMEN = PR_NO_DOKUMEN;
    }

    public String getPR_KETERANGAN_AGUNAN() {
        return PR_KETERANGAN_AGUNAN;
    }

    public void setPR_KETERANGAN_AGUNAN(String PR_KETERANGAN_AGUNAN) {
        this.PR_KETERANGAN_AGUNAN = PR_KETERANGAN_AGUNAN;
    }



}
