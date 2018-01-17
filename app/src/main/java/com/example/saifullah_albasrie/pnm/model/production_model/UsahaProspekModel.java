package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 16-Jan-18.
 */

public class UsahaProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("PR_PRIORITY_USAHA ")
    @Expose
    public String PR_PRIORITY_USAHA ;

    @SerializedName("MS_JENIS_USAHA_ID ")
    @Expose
    public int MS_JENIS_USAHA_ID ;

    @SerializedName("PR_LAMA_USAHA ")
    @Expose
    private String  PR_LAMA_USAHA ;

    @SerializedName("PR_NO_TELP_USAHA ")
    @Expose
    private String PR_NO_TELP_USAHA ;

    @SerializedName("PR_OMSET_HARIAN  ")
    @Expose
    private String PR_OMSET_HARIAN  ;

    @SerializedName("PR_NAMA_USAHA  ")
    @Expose
    private String PR_NAMA_USAHA  ;

    @SerializedName("PR_JUMLAH_KARYAWAN  ")
    @Expose
    private String PR_JUMLAH_KARYAWAN  ;

    @SerializedName("PR_ALAMAT  ")
    @Expose
    private String PR_ALAMAT  ;

    @SerializedName("PR_RT  ")
    @Expose
    private String PR_RT  ;

    @SerializedName("PR_RW  ")
    @Expose
    private String PR_RW  ;

    @SerializedName("MS_PROVINSI_ID  ")
    @Expose
    private int MS_PROVINSI_ID  ;

    @SerializedName("MS_KABKOT_ID  ")
    @Expose
    private int MS_KABKOT_ID  ;

    @SerializedName("MS_KECAMATAN_ID  ")
    @Expose
    private int MS_KECAMATAN_ID  ;

    @SerializedName("MS_KELDES_ID  ")
    @Expose
    private int MS_KELDES_ID  ;

    @SerializedName("MS_KODE_POS_ID  ")
    @Expose
    private int MS_KODE_POS_ID  ;

    @SerializedName("PR_LAMA_MENEMPATI  ")
    @Expose
    private String PR_LAMA_MENEMPATI  ;

    @SerializedName("MS_STATUS_TEMPAT_ID  ")
    @Expose
    private int MS_STATUS_TEMPAT_ID ;

    public UsahaProspekModel() {}


    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getPR_PRIORITY_USAHA() {
        return PR_PRIORITY_USAHA;
    }

    public void setPR_PRIORITY_USAHA(String PR_PRIORITY_USAHA) {
        this.PR_PRIORITY_USAHA = PR_PRIORITY_USAHA;
    }

    public int getMS_JENIS_USAHA_ID() {
        return MS_JENIS_USAHA_ID;
    }

    public void setMS_JENIS_USAHA_ID(int MS_JENIS_USAHA_ID) {
        this.MS_JENIS_USAHA_ID = MS_JENIS_USAHA_ID;
    }

    public String getPR_LAMA_USAHA() {
        return PR_LAMA_USAHA;
    }

    public void setPR_LAMA_USAHA(String PR_LAMA_USAHA) {
        this.PR_LAMA_USAHA = PR_LAMA_USAHA;
    }

    public String getPR_NO_TELP_USAHA() {
        return PR_NO_TELP_USAHA;
    }

    public void setPR_NO_TELP_USAHA(String PR_NO_TELP_USAHA) {
        this.PR_NO_TELP_USAHA = PR_NO_TELP_USAHA;
    }

    public String getPR_OMSET_HARIAN() {
        return PR_OMSET_HARIAN;
    }

    public void setPR_OMSET_HARIAN(String PR_OMSET_HARIAN) {
        this.PR_OMSET_HARIAN = PR_OMSET_HARIAN;
    }

    public String getPR_NAMA_USAHA() {
        return PR_NAMA_USAHA;
    }

    public void setPR_NAMA_USAHA(String PR_NAMA_USAHA) {
        this.PR_NAMA_USAHA = PR_NAMA_USAHA;
    }

    public String getPR_JUMLAH_KARYAWAN() {
        return PR_JUMLAH_KARYAWAN;
    }

    public void setPR_JUMLAH_KARYAWAN(String PR_JUMLAH_KARYAWAN) {
        this.PR_JUMLAH_KARYAWAN = PR_JUMLAH_KARYAWAN;
    }

    public String getPR_ALAMAT() {
        return PR_ALAMAT;
    }

    public void setPR_ALAMAT(String PR_ALAMAT) {
        this.PR_ALAMAT = PR_ALAMAT;
    }

    public String getPR_RT() {
        return PR_RT;
    }

    public void setPR_RT(String PR_RT) {
        this.PR_RT = PR_RT;
    }

    public String getPR_RW() {
        return PR_RW;
    }

    public void setPR_RW(String PR_RW) {
        this.PR_RW = PR_RW;
    }

    public int getMS_PROVINSI_ID() {
        return MS_PROVINSI_ID;
    }

    public void setMS_PROVINSI_ID(int MS_PROVINSI_ID) {
        this.MS_PROVINSI_ID = MS_PROVINSI_ID;
    }

    public int getMS_KABKOT_ID() {
        return MS_KABKOT_ID;
    }

    public void setMS_KABKOT_ID(int MS_KABKOT_ID) {
        this.MS_KABKOT_ID = MS_KABKOT_ID;
    }

    public int getMS_KELDES_ID() {
        return MS_KELDES_ID;
    }

    public void setMS_KELDES_ID(int MS_KELDES_ID) {
        this.MS_KELDES_ID = MS_KELDES_ID;
    }

    public int getMS_KODE_POS_ID() {
        return MS_KODE_POS_ID;
    }

    public void setMS_KODE_POS_ID(int MS_KODE_POS_ID) {
        this.MS_KODE_POS_ID = MS_KODE_POS_ID;
    }

    public String getPR_LAMA_MENEMPATI() {
        return PR_LAMA_MENEMPATI;
    }

    public void setPR_LAMA_MENEMPATI(String PR_LAMA_MENEMPATI) {
        this.PR_LAMA_MENEMPATI = PR_LAMA_MENEMPATI;
    }

    public int getMS_STATUS_TEMPAT_ID() {
        return MS_STATUS_TEMPAT_ID;
    }

    public void setMS_STATUS_TEMPAT_ID(int MS_STATUS_TEMPAT_ID) {
        this.MS_STATUS_TEMPAT_ID = MS_STATUS_TEMPAT_ID;
    }





}
