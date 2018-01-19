package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/19/2018.
 */

public class DeleteAssetModel {

    @SerializedName("SV_INDIVIDU_ASSET_ID")
    @Expose
    public int SV_INDIVIDU_ASSET_ID;

    @SerializedName("LOGID")
    @Expose
    public int LOGID;

    @SerializedName("MODIFIED_BY_ID")
    @Expose
    public int MODIFIED_BY_ID;

    @SerializedName("MODIFIED_BY_NAME")
    @Expose
    private String  MODIFIED_BY_NAME;

    public DeleteAssetModel () {}

    public int getSV_INDIVIDU_ASSET_ID() {
        return SV_INDIVIDU_ASSET_ID;
    }

    public void setSV_INDIVIDU_ASSET_ID(int SV_INDIVIDU_ASSET_ID) {
        this.SV_INDIVIDU_ASSET_ID = SV_INDIVIDU_ASSET_ID;
    }

    public int getLOGID() {return LOGID;}
    public void setLOGID(int LOGID) {
        this.LOGID = LOGID;
    }


    public int getMODIFIED_BY_ID() {
        return MODIFIED_BY_ID;
    }

    public void setMODIFIED_BY_ID(int MODIFIED_BY_ID) {
        this.MODIFIED_BY_ID = MODIFIED_BY_ID;
    }

    public String getMODIFIED_BY_NAME() {
        return MODIFIED_BY_NAME;
    }

    public void setMODIFIED_BY_NAME(String MODIFIED_BY_NAME) {
        this.MODIFIED_BY_NAME = MODIFIED_BY_NAME;
    }


}
