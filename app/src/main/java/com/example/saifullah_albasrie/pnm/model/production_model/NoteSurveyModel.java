package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/18/2018.
 */

public class NoteSurveyModel {

    @SerializedName("SV_INDIVIDU_ASSET_ID")
    @Expose
    public int SV_INDIVIDU_ASSET_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("SV_PEMBERI_NOTE ")
    @Expose
    public String SV_PEMBERI_NOTE ;

    @SerializedName("MS_JENIS_CATATAN_ID ")
    @Expose
    private int  MS_JENIS_CATATAN_ID ;

    @SerializedName("SV_NOTE ")
    @Expose
    private String SV_NOTE ;

    public NoteSurveyModel() {}

    public int getSV_INDIVIDU_ASSET_ID() {
        return SV_INDIVIDU_ASSET_ID;
    }

    public void setSV_INDIVIDU_ASSET_ID(int SV_INDIVIDU_ASSET_ID) {
        this.SV_INDIVIDU_ASSET_ID = SV_INDIVIDU_ASSET_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getSV_PEMBERI_NOTE() {
        return SV_PEMBERI_NOTE;
    }

    public void setSV_PEMBERI_NOTE(String SV_PEMBERI_NOTE) {
        this.SV_PEMBERI_NOTE = SV_PEMBERI_NOTE;
    }

    public int getMS_JENIS_CATATAN_ID() {
        return MS_JENIS_CATATAN_ID;
    }

    public void setMS_JENIS_CATATAN_ID(int MS_JENIS_CATATAN_ID) {
        this.MS_JENIS_CATATAN_ID = MS_JENIS_CATATAN_ID;
    }

    public String getSV_NOTE() {
        return SV_NOTE;
    }

    public void setSV_NOTE(String SV_NOTE) {
        this.SV_NOTE = SV_NOTE;
    }
}
