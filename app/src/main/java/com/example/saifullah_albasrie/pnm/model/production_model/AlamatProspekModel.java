package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 14-Jan-18.
 */

public class AlamatProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("MS_JENIS_ALAMAT_ID")
    @Expose
    public int MS_JENIS_ALAMAT_ID;

    @SerializedName("PR_ALAMAT")
    @Expose
    public String PR_ALAMAT;

    @SerializedName("PR_RT")
    @Expose
    private String  PR_RT;

    @SerializedName("PR_RW")
    @Expose
    private String PR_RW;

    @SerializedName("MS_PROVINSI_ID")
    @Expose
    private int MS_PROVINSI_ID;

    @SerializedName("MS_KABKOT_ID")
    @Expose
    private int MS_KABKOT_ID;

    @SerializedName("MS_KECAMATAN_ID")
    @Expose
    private int MS_KECAMATAN_ID;

    @SerializedName("MS_KELDES_ID")
    @Expose
    private int MS_KELDES_ID;

    @SerializedName("MS_KODE_POS_ID")
    @Expose
    private int MS_KODE_POS_ID;

    @SerializedName("PR_LAMA_MENEMPATI")
    @Expose
    private String PR_LAMA_MENEMPATI;

    @SerializedName("MS_STATUS_TEMPAT_ID")
    @Expose
    private int MS_STATUS_TEMPAT_ID;

    public AlamatProspekModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getMS_JENIS_ALAMAT_ID() {
        return MS_JENIS_ALAMAT_ID;
    }

    public void setMS_JENIS_ALAMAT_ID(int MS_JENIS_ALAMAT_ID) {
        this.MS_JENIS_ALAMAT_ID = MS_JENIS_ALAMAT_ID;
    }

    public String getPR_ALAMAT() {
        return PR_ALAMAT;
    }

    public void sePR_ALAMAT_ID(String PR_ALAMAT) {
        this.PR_ALAMAT = PR_ALAMAT;
    }

    public String getPR_RT() { return PR_RT;
    }

    public void setPR_RT(String PR_RT) {
        this.PR_RT = PR_RT;
    }

    public String getPR_RW() {
        return PR_RW;
    }

    public void setPR_RW(String PR_RW) {
        this.PR_RW = PR_RW;
    }

    public int getMS_PROVINSI_ID() {
        return MS_PROVINSI_ID;
    }

    public void setMS_PROVINSI_ID(int MS_PROVINSI_ID) {
        this.MS_PROVINSI_ID = MS_PROVINSI_ID;
    }

    public int getMS_KABKOT_ID() {
        return MS_KABKOT_ID;
    }

    public void setMS_KABKOT_ID(int MS_KABKOT_ID) {
        this.MS_KABKOT_ID = MS_KABKOT_ID;
    }

    public int getMS_KECAMATAN_ID() {
        return MS_KECAMATAN_ID;
    }

    public void setMS_KECAMATAN_ID(int MS_KECAMATAN_ID) {
        this.MS_KECAMATAN_ID = MS_KECAMATAN_ID;
    }

    public int getMS_KELDES_ID() {
        return MS_KELDES_ID;
    }

    public void setMS_KELDES_ID(int MS_KELDES_ID) {
        this.MS_KELDES_ID = MS_KELDES_ID;
    }

    public int getMS_KODE_POS_ID() {
        return MS_KODE_POS_ID;
    }

    public void setMS_KODE_POS_ID(int MS_KODE_POS_ID) {
        this.MS_KODE_POS_ID = MS_KODE_POS_ID;
    }

    public String  getPR_LAMA_MENEMPATI() {
        return PR_LAMA_MENEMPATI;
    }

    public void setPR_LAMA_MENEMPATI(String PR_LAMA_MENEMPATI) {
        this.PR_LAMA_MENEMPATI = PR_LAMA_MENEMPATI;
    }

    public int getMS_STATUS_TEMPAT_ID() {
        return MS_STATUS_TEMPAT_ID;
    }

    public void setMS_STATUS_TEMPAT_ID(int MS_STATUS_TEMPAT_ID) {
        this.MS_STATUS_TEMPAT_ID = MS_STATUS_TEMPAT_ID;
    }


}
