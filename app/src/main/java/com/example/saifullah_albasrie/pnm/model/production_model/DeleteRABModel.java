package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/19/2018.
 */

public class DeleteRABModel {

    @SerializedName("SV_INDIVIDU_RAB_ID")
    @Expose
    public int SV_INDIVIDU_RAB_ID;

    @SerializedName("LOGID")
    @Expose
    public int LOGID;

    @SerializedName("MODIFIED_BY_ID")
    @Expose
    public int MODIFIED_BY_ID;

    @SerializedName("MODIFIED_BY_NAME")
    @Expose
    private String  MODIFIED_BY_NAME;

    public DeleteRABModel() {}

    public int getSV_INDIVIDU_RAB_ID() {
        return SV_INDIVIDU_RAB_ID;
    }

    public void setSV_INDIVIDU_RAB_ID(int SV_INDIVIDU_RAB_ID) {
        this.SV_INDIVIDU_RAB_ID = SV_INDIVIDU_RAB_ID;
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
