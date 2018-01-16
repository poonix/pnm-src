package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 15-Jan-18.
 */

public class UploadDokumenModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("DB_HEADER ")
    @Expose
    public String DB_HEADER ;

    @SerializedName("DB_HEADER_ID ")
    @Expose
    public int DB_HEADER_ID ;

    @SerializedName("MS_JENIS_DOKUMEN_ID ")
    @Expose
    private int  MS_JENIS_DOKUMEN_ID ;

    @SerializedName("PR_NOMOR_DOKUMEN ")
    @Expose
    private String PR_NOMOR_DOKUMEN ;

    @SerializedName("PR_DOKUMEN  ")
    @Expose
    private String PR_DOKUMEN  ;

    public UploadDokumenModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getDB_HEADER() {
        return DB_HEADER;
    }

    public void setDB_HEADER(String DB_HEADER) {
        this.DB_HEADER = DB_HEADER;
    }

    public int getDB_HEADER_ID() {
        return DB_HEADER_ID;
    }

    public void setDB_HEADER_ID(int DB_HEADER_ID) {
        this.DB_HEADER_ID = DB_HEADER_ID;
    }

    public int getMS_JENIS_DOKUMEN_ID() {
        return MS_JENIS_DOKUMEN_ID;
    }

    public void setMS_JENIS_DOKUMEN_ID(int MS_JENIS_DOKUMEN_ID) {
        this.MS_JENIS_DOKUMEN_ID = MS_JENIS_DOKUMEN_ID;
    }

    public String getPR_NOMOR_DOKUMEN() {
        return PR_NOMOR_DOKUMEN;
    }

    public void setPR_NOMOR_DOKUMEN(String PR_NOMOR_DOKUMEN) {
        this.PR_NOMOR_DOKUMEN = PR_NOMOR_DOKUMEN;
    }


}


