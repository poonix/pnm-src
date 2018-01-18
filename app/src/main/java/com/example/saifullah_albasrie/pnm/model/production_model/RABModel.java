package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/18/2018.
 */

public class RABModel {

    @SerializedName("SV_INDIVIDU_RAB_ID")
    @Expose
    public int SV_INDIVIDU_RAB_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("MS_TUJUAN_PEMBIAYAAN_ID ")
    @Expose
    public int MS_TUJUAN_PEMBIAYAAN_ID ;

    @SerializedName("SV_JML_RAB ")
    @Expose
    private String  SV_JML_RAB ;

    @SerializedName("SV_KETERANGAN ")
    @Expose
    private String SV_KETERANGAN ;

    public RABModel() {}

    public int getSV_INDIVIDU_RAB_ID() {
        return SV_INDIVIDU_RAB_ID;
    }

    public void setSV_INDIVIDU_RAB_ID(int SV_INDIVIDU_RAB_ID) {
        this.SV_INDIVIDU_RAB_ID = SV_INDIVIDU_RAB_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getMS_TUJUAN_PEMBIAYAAN_ID() {
        return MS_TUJUAN_PEMBIAYAAN_ID;
    }

    public void setMS_TUJUAN_PEMBIAYAAN_ID(int MS_TUJUAN_PEMBIAYAAN_ID) {
        this.MS_TUJUAN_PEMBIAYAAN_ID = MS_TUJUAN_PEMBIAYAAN_ID;
    }

    public String getSV_JML_RAB() {return SV_JML_RAB;}

    public void setSV_JML_RAB(String SV_JML_RAB) {
        this.SV_JML_RAB = SV_JML_RAB;
    }

    public String getSV_KETERANGAN() {
        return SV_KETERANGAN;
    }

    public void setSV_KETERANGAN(String SV_KETERANGAN) {
        this.SV_KETERANGAN = SV_KETERANGAN;
    }



}
