package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/17/2018.
 */

public class KunjunganUsahaModel {

    @SerializedName("SV_INDIVIDU_KUNJUNGAN_USAHA_ID")
    @Expose
    public int SV_INDIVIDU_KUNJUNGAN_USAHA_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("SV_TGL_SURVEY ")
    @Expose
    public String SV_TGL_SURVEY ;

    @SerializedName("MS_LOKASI_KUNJUNGAN_ID ")
    @Expose
    private int  MS_LOKASI_KUNJUNGAN_ID ;

    @SerializedName("SV_NAMA_DITEMUI ")
    @Expose
    private String SV_NAMA_DITEMUI ;

    @SerializedName("MS_HUBUNGAN_PEMOHON_ID  ")
    @Expose
    private int MS_HUBUNGAN_PEMOHON_ID  ;

    @SerializedName("SV_KETERANGAN  ")
    @Expose
    private String SV_KETERANGAN  ;

    @SerializedName("CREATED_BY_ID  ")
    @Expose
    private int CREATED_BY_ID  ;

    @SerializedName("CREATED_BY_NAME  ")
    @Expose
    private String CREATED_BY_NAME  ;



    public KunjunganUsahaModel () {}

    public int getSV_INDIVIDU_KUNJUNGAN_USAHA_ID() {
        return SV_INDIVIDU_KUNJUNGAN_USAHA_ID;
    }

    public void setSV_INDIVIDU_KUNJUNGAN_USAHA_ID(int SV_INDIVIDU_KUNJUNGAN_USAHA_ID) {
        this.SV_INDIVIDU_KUNJUNGAN_USAHA_ID = SV_INDIVIDU_KUNJUNGAN_USAHA_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getSV_TGL_SURVEY() {
        return SV_TGL_SURVEY;
    }

    public void setSV_TGL_SURVEY(String  SV_TGL_SURVEY) {
        this.SV_TGL_SURVEY = SV_TGL_SURVEY;
    }

    public int getMS_LOKASI_KUNJUNGAN_ID() {
        return MS_LOKASI_KUNJUNGAN_ID;
    }
    public void setMS_LOKASI_KUNJUNGAN_ID(int  MS_LOKASI_KUNJUNGAN_ID) {
        this.MS_LOKASI_KUNJUNGAN_ID = MS_LOKASI_KUNJUNGAN_ID;
    }

    public String getSV_NAMA_DITEMUI() {
        return SV_NAMA_DITEMUI;
    }
    public void setSV_NAMA_DITEMUI(String  SV_NAMA_DITEMUI) {
        this.SV_NAMA_DITEMUI = SV_NAMA_DITEMUI;
    }

    public int getMS_HUBUNGAN_PEMOHON_ID() {
        return MS_HUBUNGAN_PEMOHON_ID;
    }
    public void setMS_HUBUNGAN_PEMOHON_ID(int  MS_HUBUNGAN_PEMOHON_ID) {
        this.MS_HUBUNGAN_PEMOHON_ID = MS_HUBUNGAN_PEMOHON_ID;
    }

    public int getCREATED_BY_ID() {
        return CREATED_BY_ID;
    }

    public void setCREATED_BY_ID(int  CREATED_BY_ID) {
        this.CREATED_BY_ID = CREATED_BY_ID;
    }

    public String getCREATED_BY_NAME() {
        return CREATED_BY_NAME;
    }
    public void setCREATED_BY_NAME(String  CREATED_BY_NAME) {
        this.CREATED_BY_NAME = CREATED_BY_NAME;
    }



}
