package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/18/2018.
 */

public class SumberReputasiModel {

    @SerializedName("SV_INDIVIDU_REPUTASI_ID")
    @Expose
    public int SV_INDIVIDU_REPUTASI_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("SV_NAMA ")
    @Expose
    public String SV_NAMA ;

    @SerializedName("MS_HUBUNGAN_PEMOHON_ID ")
    @Expose
    private int  MS_HUBUNGAN_PEMOHON_ID ;

    @SerializedName("SV_HUBUNGAN_LAIN ")
    @Expose
    private String SV_HUBUNGAN_LAIN ;

    @SerializedName("SV_NO_HP  ")
    @Expose
    private String SV_NO_HP  ;

    @SerializedName("MS_REPUTASI_ID  ")
    @Expose
    private int MS_REPUTASI_ID  ;

    @SerializedName("SV_KETERANGAN  ")
    @Expose
    private String SV_KETERANGAN  ;


    public SumberReputasiModel() {}

    public int getSV_INDIVIDU_REPUTASI_ID() {
        return SV_INDIVIDU_REPUTASI_ID;
    }

    public void setSV_INDIVIDU_REPUTASI_ID(int SV_INDIVIDU_REPUTASI_ID) {
        this.SV_INDIVIDU_REPUTASI_ID = SV_INDIVIDU_REPUTASI_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getSV_NAMA() {
        return SV_NAMA;
    }

    public void setSV_NAMA(String SV_NAMA) {
        this.SV_NAMA = SV_NAMA;
    }

    public int getMS_HUBUNGAN_PEMOHON_ID() {
        return MS_HUBUNGAN_PEMOHON_ID;
    }

    public void setMS_HUBUNGAN_PEMOHON_ID(int MS_HUBUNGAN_PEMOHON_ID) {
        this.MS_HUBUNGAN_PEMOHON_ID = MS_HUBUNGAN_PEMOHON_ID;
    }

    public String getSV_HUBUNGAN_LAIN () {
        return SV_HUBUNGAN_LAIN;
    }

    public void setSV_HUBUNGAN_LAIN(String SV_HUBUNGAN_LAIN) {
        this.SV_HUBUNGAN_LAIN = SV_HUBUNGAN_LAIN;
    }

    public String getSV_NO_HP() {
        return SV_NO_HP;
    }

    public void setSV_NO_HP(String SV_NO_HP) {
        this.SV_NO_HP = SV_NO_HP;
    }

    public int getMS_REPUTASI_ID() {
        return MS_REPUTASI_ID;
    }

    public void setMS_REPUTASI_ID(int MS_REPUTASI_ID) {
        this.MS_REPUTASI_ID = MS_REPUTASI_ID;
    }

    public String getSV_KETERANGAN() {
        return SV_KETERANGAN;
    }

    public void setSV_KETERANGAN(String SV_KETERANGAN) {
        this.SV_KETERANGAN = SV_KETERANGAN;
    }
}
