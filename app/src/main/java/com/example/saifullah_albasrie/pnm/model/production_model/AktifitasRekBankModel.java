package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/17/2018.
 */

public class AktifitasRekBankModel {

    @SerializedName("SV_INDIVIDU_AKTIVITAS_REK_ID")
    @Expose
    public int SV_INDIVIDU_AKTIVITAS_REK_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("SV_BULAN_KE ")
    @Expose
    public String  SV_BULAN_KE ;

    @SerializedName("MS_BULAN_ID ")
    @Expose
    private int  MS_BULAN_ID ;

    @SerializedName("SV_KREDIT_RIBUAN ")
    @Expose
    private String SV_KREDIT_RIBUAN ;

    @SerializedName("SV_FREQ_KREDIT  ")
    @Expose
    private String SV_FREQ_KREDIT  ;

    @SerializedName("SV_DEBIT_RIBUAN  ")
    @Expose
    private String SV_DEBIT_RIBUAN  ;

    @SerializedName("SV_FREQ_DEBIT  ")
    @Expose
    private String SV_FREQ_DEBIT  ;

    @SerializedName("CREATED_BY_ID  ")
    @Expose
    private int CREATED_BY_ID  ;

    @SerializedName("CREATED_BY_NAME  ")
    @Expose
    private String CREATED_BY_NAME  ;

    public AktifitasRekBankModel () {}


    public int getSV_INDIVIDU_AKTIVITAS_REK_ID() {
        return SV_INDIVIDU_AKTIVITAS_REK_ID;
    }

    public void setSV_INDIVIDU_AKTIVITAS_REK_ID(int SV_INDIVIDU_AKTIVITAS_REK_ID) {
        this.SV_INDIVIDU_AKTIVITAS_REK_ID = SV_INDIVIDU_AKTIVITAS_REK_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getSV_BULAN_KE() {
        return SV_BULAN_KE;
    }

    public void setSV_BULAN_KE(String SV_BULAN_KE) {
        this.SV_BULAN_KE = SV_BULAN_KE;
    }

    public int getMS_BULAN_ID() {
        return MS_BULAN_ID;
    }

    public void setMS_BULAN_ID(int MS_BULAN_ID) {
        this.MS_BULAN_ID = MS_BULAN_ID;
    }

    public String  getSV_KREDIT_RIBUAN() {
        return SV_KREDIT_RIBUAN;
    }

    public void setSV_KREDIT_RIBUAN(String SV_KREDIT_RIBUAN) {
        this.SV_KREDIT_RIBUAN = SV_KREDIT_RIBUAN;
    }

    public String  getSV_FREQ_KREDIT() {
        return SV_FREQ_KREDIT;
    }

    public void setSV_FREQ_KREDIT(String SV_FREQ_KREDIT) {
        this.SV_FREQ_KREDIT = SV_FREQ_KREDIT;
    }

    public String  getSV_DEBIT_RIBUAN() {
        return SV_DEBIT_RIBUAN;
    }

    public void setSV_DEBIT_RIBUAN(String SV_DEBIT_RIBUAN) {
        this.SV_DEBIT_RIBUAN = SV_DEBIT_RIBUAN;
    }

    public String  getSV_FREQ_DEBIT() {
        return SV_FREQ_DEBIT;
    }

    public void setSV_FREQ_DEBIT(String SV_FREQ_DEBIT) {
        this.SV_FREQ_DEBIT = SV_FREQ_DEBIT;
    }

    public int  getCREATED_BY_ID() {
        return CREATED_BY_ID;
    }

    public void setCREATED_BY_ID(int CREATED_BY_ID) {
        this.CREATED_BY_ID = CREATED_BY_ID;
    }

    public String  getCREATED_BY_NAME() {
        return CREATED_BY_NAME;
    }

    public void setCREATED_BY_NAME(String CREATED_BY_NAME) {
        this.CREATED_BY_NAME = CREATED_BY_NAME;
    }




}
