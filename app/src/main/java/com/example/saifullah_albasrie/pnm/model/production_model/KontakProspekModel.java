package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 14-Jan-18.
 */

public class KontakProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("PR_INDIVIDU_KONTAK_ID")
    @Expose
    public int PR_INDIVIDU_KONTAK_ID;

    @SerializedName("PR_KONTAK_UTAMA")
    @Expose
    public String PR_KONTAK_UTAMA;

    @SerializedName("MS_TIPE_KONTAK")
    @Expose
    private String  MS_TIPE_KONTAK;

    @SerializedName("PR_KONTAK")
    @Expose
    private String PR_KONTAK;

    public KontakProspekModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getPR_INDIVIDU_KONTAK_ID() {
        return PR_INDIVIDU_KONTAK_ID;
    }

    public void setPR_INDIVIDU_KONTAK_ID(int PR_INDIVIDU_KONTAK_ID) {
        this.PR_INDIVIDU_KONTAK_ID = PR_INDIVIDU_KONTAK_ID;
    }

    public String getPR_KONTAK_UTAMA() {
        return PR_KONTAK_UTAMA;
    }

    public void setPR_KONTAK_UTAMA(String PR_KONTAK_UTAMA) {
        this.PR_KONTAK_UTAMA = PR_KONTAK_UTAMA;
    }

    public String getMS_TIPE_KONTAKD() {
        return MS_TIPE_KONTAK;
    }

    public void setMS_TIPE_KONTAK(String  MS_TIPE_KONTAK) {
        this.MS_TIPE_KONTAK = MS_TIPE_KONTAK;
    }

    public String getPR_KONTAK() {
        return PR_KONTAK;
    }

    public void setPR_KONTAK(String PR_KONTAK) {
        this.PR_KONTAK = PR_KONTAK;
    }
}
