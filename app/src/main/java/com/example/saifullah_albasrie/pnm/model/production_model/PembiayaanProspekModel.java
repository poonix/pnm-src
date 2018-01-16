package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 15-Jan-18.
 */

public class PembiayaanProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("MS_PRODUK_ID")
    @Expose
    public int MS_PRODUK_ID;

    @SerializedName("PR_RENCANA_PLAFOND")
    @Expose
    public String PR_RENCANA_PLAFOND;

    @SerializedName("PR_JANGKA_WAKTU")
    @Expose
    private String  PR_JANGKA_WAKTU;

    @SerializedName("PR_KEMAMPUAN_ANGSURAN")
    @Expose
    private String PR_KEMAMPUAN_ANGSURAN;

    @SerializedName("MS_TUJUAN_PEMBIAYAAN_ID")
    @Expose
    private int MS_TUJUAN_PEMBIAYAAN_ID;

    public PembiayaanProspekModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }


    public int getMS_PRODUK_ID() {
        return MS_PRODUK_ID;
    }

    public void setMS_PRODUK_ID(int MS_PRODUK_ID) {
        this.MS_PRODUK_ID = MS_PRODUK_ID;
    }


    public String getPR_RENCANA_PLAFOND() {
        return PR_RENCANA_PLAFOND;
    }

    public void setPR_RENCANA_PLAFOND(String PR_RENCANA_PLAFOND) {
        this.PR_RENCANA_PLAFOND = PR_RENCANA_PLAFOND;
    }


    public String getPR_JANGKA_WAKTU() {
        return PR_JANGKA_WAKTU;
    }

    public void setPR_JANGKA_WAKTU(String PR_JANGKA_WAKTU) {
        this.PR_JANGKA_WAKTU = PR_JANGKA_WAKTU;
    }


    public String gePR_KEMAMPUAN_ANGSURAN() {
        return PR_KEMAMPUAN_ANGSURAN;
    }

    public void setPR_KEMAMPUAN_ANGSURAN(String PR_KEMAMPUAN_ANGSURAN) {
        this.PR_KEMAMPUAN_ANGSURAN = PR_KEMAMPUAN_ANGSURAN;
    }

    public int geMS_TUJUAN_PEMBIAYAAN_ID() {
        return MS_TUJUAN_PEMBIAYAAN_ID;
    }

    public void setMS_TUJUAN_PEMBIAYAAN_ID(int MS_TUJUAN_PEMBIAYAAN_ID) {
        this.MS_TUJUAN_PEMBIAYAAN_ID = MS_TUJUAN_PEMBIAYAAN_ID;
    }

}
