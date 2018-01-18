package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/18/2018.
 */

public class PinjamanLainModel {

    @SerializedName("SV_INDIVIDU_PINJAMAN_LAIN_ID")
    @Expose
    public int SV_INDIVIDU_PINJAMAN_LAIN_ID;

    @SerializedName("DB_PROSPEK_ID ")
    @Expose
    public int DB_PROSPEK_ID ;

    @SerializedName("MS_BANK_ID ")
    @Expose
    public int MS_BANK_ID ;

    @SerializedName("SV_PLAFOND ")
    @Expose
    private String  SV_PLAFOND ;

    @SerializedName("SV_BAKI_DEBET ")
    @Expose
    private String SV_BAKI_DEBET ;

    @SerializedName("SV_ANGSURAN  ")
    @Expose
    private String SV_ANGSURAN  ;

    @SerializedName("MS_TUJUAN_PEMBIAYAAN_ID  ")
    @Expose
    private int MS_TUJUAN_PEMBIAYAAN_ID ;

    @SerializedName("SV_JATUH_TEMPO  ")
    @Expose
    private String  SV_JATUH_TEMPO ;

    @SerializedName("MS_KOLEKTIBILITAS_ID  ")
    @Expose
    private int MS_KOLEKTIBILITAS_ID ;

    public PinjamanLainModel() {}

    public int getSV_INDIVIDU_PINJAMAN_LAIN_ID() {
        return SV_INDIVIDU_PINJAMAN_LAIN_ID;
    }

    public void setSV_INDIVIDU_PINJAMAN_LAIN_ID(int SV_INDIVIDU_PINJAMAN_LAIN_ID) {
        this.SV_INDIVIDU_PINJAMAN_LAIN_ID = SV_INDIVIDU_PINJAMAN_LAIN_ID;
    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getMS_BANK_ID() {
        return MS_BANK_ID;
    }

    public void setMS_BANK_ID(int MS_BANK_ID) {
        this.MS_BANK_ID = MS_BANK_ID;
    }

    public String getSV_PLAFOND() {
        return SV_PLAFOND;
    }

    public void setSV_PLAFOND(String SV_PLAFOND) {
        this.SV_PLAFOND = SV_PLAFOND;
    }

    public String getSV_BAKI_DEBET() {
        return SV_BAKI_DEBET;
    }

    public void setSV_BAKI_DEBET(String SV_BAKI_DEBET) {
        this.SV_BAKI_DEBET = SV_BAKI_DEBET;
    }

    public String getSV_ANGSURAN() {return SV_ANGSURAN;}

    public void setSV_ANGSURAN(String SV_ANGSURAN) {
        this.SV_ANGSURAN = SV_ANGSURAN;
    }

    public int getMS_TUJUAN_PEMBIAYAAN_ID() {
        return MS_TUJUAN_PEMBIAYAAN_ID;
    }

    public void setMS_TUJUAN_PEMBIAYAAN_ID(int MS_TUJUAN_PEMBIAYAAN_ID) {
        this.MS_TUJUAN_PEMBIAYAAN_ID = MS_TUJUAN_PEMBIAYAAN_ID;
    }

    public String getSV_JATUH_TEMPO() {
        return SV_JATUH_TEMPO;
    }

    public void setSV_JATUH_TEMPO(String SV_JATUH_TEMPO) {
        this.SV_JATUH_TEMPO = SV_JATUH_TEMPO;
    }

    public int getMS_KOLEKTIBILITAS_ID() {
        return MS_KOLEKTIBILITAS_ID;
    }

    public void setMS_KOLEKTIBILITAS_ID(int MS_KOLEKTIBILITAS_ID) {
        this.MS_KOLEKTIBILITAS_ID = MS_KOLEKTIBILITAS_ID;
    }

}
