package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/17/2018.
 */

public class SurveyAssetModel {

    @SerializedName("SV_INDIVIDU_ASSET_ID")
    @Expose
    public int SV_INDIVIDU_ASSET_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("MS_JENIS_ASSET_ID ")
    @Expose
    public int MS_JENIS_ASSET_ID ;

    @SerializedName("SV_NILAI_ASSET ")
    @Expose
    private String  SV_NILAI_ASSET ;

    @SerializedName("CREATED_BY_ID ")
    @Expose
    private int CREATED_BY_ID ;

    @SerializedName("CREATED_BY_NAME  ")
    @Expose
    private String CREATED_BY_NAME  ;

    public SurveyAssetModel() {}

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

    public int getMS_JENIS_ASSET_ID() {
        return MS_JENIS_ASSET_ID;
    }

    public void setMS_JENIS_ASSET_ID(int MS_JENIS_ASSET_ID) {
        this.MS_JENIS_ASSET_ID = MS_JENIS_ASSET_ID;
    }

    public String getSV_NILAI_ASSET() {
        return SV_NILAI_ASSET;
    }

    public void setSV_NILAI_ASSET(String SV_NILAI_ASSET) {
        this.SV_NILAI_ASSET = SV_NILAI_ASSET;
    }

    public int getCREATED_BY_ID() {
        return CREATED_BY_ID;
    }

    public void setCREATED_BY_ID(int CREATED_BY_ID) {
        this.CREATED_BY_ID = CREATED_BY_ID;
    }

    public String getCREATED_BY_NAME() {
        return CREATED_BY_NAME;
    }

    public void setCREATED_BY_NAME(String CREATED_BY_NAME) {
        this.CREATED_BY_NAME = CREATED_BY_NAME;
    }
}
