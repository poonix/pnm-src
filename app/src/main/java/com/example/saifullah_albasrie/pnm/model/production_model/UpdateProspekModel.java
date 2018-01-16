package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/14/2018.
 */

public class UpdateProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("PR_NAMA_LENGKAP")
    @Expose
    public String PR_NAMA_LENGKAP;

    @SerializedName("PR_NAMA_PANGGILAN")
    @Expose
    public String PR_NAMA_PANGGILAN;

    @SerializedName("MS_JENIS_IDENTITAS_ID")
    @Expose
    private int MS_JENIS_IDENTITAS_ID;

    @SerializedName("PR_NO_IDENTITAS")
    @Expose
    private String PR_NO_IDENTITAS;

    @SerializedName("PR_MASA_BERLAKU_IDENTITAS")
    @Expose
    private String PR_MASA_BERLAKU_IDENTITAS;

    @SerializedName("PR_TEMPAT_LAHIR")
    @Expose
    private String PR_TEMPAT_LAHIR;

    @SerializedName("PR_TGL_LAHIR")
    @Expose
    private String PR_TGL_LAHIR;

    @SerializedName("MS_JENIS_KELAMIN_ID")
    @Expose
    private int MS_JENIS_KELAMIN_ID;

    @SerializedName("PR_NAMA_IBU_KANDUNG")
    @Expose
    private String PR_NAMA_IBU_KANDUNG;

    @SerializedName("MS_STATUS_KAWIN_ID")
    @Expose
    private int MS_STATUS_KAWIN_ID;

    @SerializedName("PR_JML_ANAK")
    @Expose
    private String PR_JML_ANAK;

    @SerializedName("MS_PENDIDIKAN_ID")
    @Expose
    private int MS_PENDIDIKAN_ID;

    @SerializedName("PR_GELAR")
    @Expose
    private String PR_GELAR;

    @SerializedName("MS_KEWARGANEGARAAN_ID")
    @Expose
    private int MS_KEWARGANEGARAAN_ID;

    @SerializedName("MS_AGAMA_IDv")
    @Expose
    private int MS_AGAMA_ID;

    @SerializedName("PR_NPWP")
    @Expose
    private String PR_NPWP;

    @SerializedName("PR_NO_KK")
    @Expose
    private String PR_NO_KK;

    @SerializedName("MS_PEKERJAAN_ID")
    @Expose
    private int MS_PEKERJAAN_ID   ;

    @SerializedName("PR_KET_PEKERJAAN")
    @Expose
    private String PR_KET_PEKERJAAN;

    @SerializedName("MS_JENIS_USAHA_ID")
    @Expose
    private int MS_JENIS_USAHA_ID;

    @SerializedName("MS_JENIS_REFERENSI_ID")
    @Expose
    private int MS_JENIS_REFERENSI_ID;

    @SerializedName("PR_NAMA_REFERENSI")
    @Expose
    private String PR_NAMA_REFERENSI;

    @SerializedName("PR_NO_HP_REFERENSI")
    @Expose
    private String PR_NO_HP_REFERENSI;

    @SerializedName("MS_KODE_USAHA_SID")
    @Expose
    private String MS_KODE_USAHA_SID;

    @SerializedName("MS_KODE_BIDANG_USAHA")
    @Expose
    private String MS_KODE_BIDANG_USAHA;

    @SerializedName("MS_KODE_GOLONGAN_DEBITUR_SID_ID")
    @Expose
    private int MS_KODE_GOLONGAN_DEBITUR_SID_ID;

    @SerializedName("MS_HUB_DEB_PNM_ID")
    @Expose
    private int MS_HUB_DEB_PNM_ID;

    @SerializedName("MS_HUB_DEB_BANK_ID")
    @Expose
    private int MS_HUB_DEB_BANK_ID;

    public UpdateProspekModel () {

    }

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public String getPR_NAMA_LENGKAP() {
        return PR_NAMA_LENGKAP;
    }

    public void setPR_NAMA_LENGKAP(String PR_NAMA_LENGKAP) {
        this.PR_NAMA_LENGKAP = PR_NAMA_LENGKAP;
    }

    public String getPR_NAMA_PANGGILAN() {
        return PR_NAMA_PANGGILAN;
    }

    public void setPR_NAMA_PANGGILAN(String PR_NAMA_PANGGILAN) {
        this.PR_NAMA_PANGGILAN = PR_NAMA_PANGGILAN;
    }

    public int getMS_JENIS_IDENTITAS_ID() {
        return MS_JENIS_IDENTITAS_ID;
    }

    public void setMS_JENIS_IDENTITAS_ID(int MS_JENIS_IDENTITAS_ID) {
        this.MS_JENIS_IDENTITAS_ID = MS_JENIS_IDENTITAS_ID;
    }

    public String getPR_NO_IDENTITAS() {
        return PR_NO_IDENTITAS;
    }

    public void setPR_NO_IDENTITAS(String PR_NO_IDENTITAS) {
        this.PR_NO_IDENTITAS = PR_NO_IDENTITAS;
    }

    public String getPR_MASA_BERLAKU_IDENTITAS() {
        return PR_MASA_BERLAKU_IDENTITAS;
    }

    public void setPR_MASA_BERLAKU_IDENTITAS(String PR_MASA_BERLAKU_IDENTITAS) {
        this.PR_MASA_BERLAKU_IDENTITAS = PR_MASA_BERLAKU_IDENTITAS;
    }

    public String getPR_TEMPAT_LAHIR() {
        return PR_TEMPAT_LAHIR;
    }

    public void setPR_TEMPAT_LAHIR(String PR_TEMPAT_LAHIR) {
        this.PR_TEMPAT_LAHIR = PR_TEMPAT_LAHIR;
    }

    public String getPR_TGL_LAHIR() {
        return PR_TGL_LAHIR;
    }

    public void setPR_TGL_LAHIR(String PR_TGL_LAHIR) {
        this.PR_TGL_LAHIR = PR_TGL_LAHIR;
    }

    public int getMS_JENIS_KELAMIN_ID() {
        return MS_JENIS_KELAMIN_ID;
    }

    public void setMS_JENIS_KELAMIN_ID(int MS_JENIS_KELAMIN_ID) {
        this.MS_JENIS_KELAMIN_ID = MS_JENIS_KELAMIN_ID;
    }

    public String getPR_NAMA_IBU_KANDUNG() {
        return PR_NAMA_IBU_KANDUNG;
    }

    public void setPR_NAMA_IBU_KANDUNG(String PR_NAMA_IBU_KANDUNG) {
        this.PR_NAMA_IBU_KANDUNG = PR_NAMA_IBU_KANDUNG;
    }

    public int getMS_STATUS_KAWIN_ID() {
        return MS_STATUS_KAWIN_ID;
    }

    public void setMS_STATUS_KAWIN_ID(int MS_STATUS_KAWIN_ID) {
        this.MS_STATUS_KAWIN_ID = MS_STATUS_KAWIN_ID;
    }

    public String getPR_JML_ANAK() {
        return PR_JML_ANAK;
    }

    public void setPR_JML_ANAK(String PR_JML_ANAK) {
        this.PR_JML_ANAK = PR_JML_ANAK;
    }

    public int getMS_PENDIDIKAN_ID() {
        return MS_PENDIDIKAN_ID;
    }

    public void setMS_PENDIDIKAN_ID(int MS_PENDIDIKAN_ID) {
        this.MS_PENDIDIKAN_ID = MS_PENDIDIKAN_ID;
    }

    public String getPR_GELAR() {
        return PR_GELAR;
    }

    public void setPR_GELAR(String PR_GELAR) {
        this.PR_GELAR = PR_GELAR;
    }

    public int getMS_KEWARGANEGARAAN_ID() {
        return MS_KEWARGANEGARAAN_ID;
    }

    public void setMS_KEWARGANEGARAAN_ID(int MS_KEWARGANEGARAAN_ID) {
        this.MS_KEWARGANEGARAAN_ID = MS_KEWARGANEGARAAN_ID;
    }

    public int getMS_AGAMA_ID() {
        return MS_AGAMA_ID;
    }

    public void setMS_AGAMA_ID(int MS_AGAMA_ID) {
        this.MS_AGAMA_ID = MS_AGAMA_ID;
    }

    public String getPR_NPWP() {
        return PR_NPWP;
    }

    public void setPR_NPWP(String PR_NPWP) {
        this.PR_NPWP = PR_NPWP;
    }

    public String getPR_NO_KK() {
        return PR_NO_KK;
    }

    public void setPR_NO_KK(String PR_NO_KK) {
        this.PR_NO_KK = PR_NO_KK;
    }

    public int getMS_PEKERJAAN_ID() {
        return MS_PEKERJAAN_ID;
    }

    public void setMS_PEKERJAAN_ID(int MS_PEKERJAAN_ID) {
        this.MS_PEKERJAAN_ID = MS_PEKERJAAN_ID;
    }

    public String getPR_KET_PEKERJAAN() {
        return PR_KET_PEKERJAAN;
    }

    public void setPR_KET_PEKERJAAN(String PR_KET_PEKERJAAN) {
        this.PR_KET_PEKERJAAN = PR_KET_PEKERJAAN;
    }

    public int getMS_JENIS_USAHA_ID() {
        return MS_JENIS_USAHA_ID;
    }

    public void setMS_JENIS_USAHA_ID(int MS_JENIS_USAHA_ID) {
        this.MS_JENIS_USAHA_ID = MS_JENIS_USAHA_ID;
    }

    public int getMS_JENIS_REFERENSI_ID() {
        return MS_JENIS_REFERENSI_ID;
    }

    public void setMS_JENIS_REFERENSI_ID(int MS_JENIS_REFERENSI_ID) {
        this.MS_JENIS_REFERENSI_ID = MS_JENIS_REFERENSI_ID;
    }

    public String getPR_NAMA_REFERENSI() {
        return PR_NAMA_REFERENSI;
    }

    public void setPR_NAMA_REFERENSI(String PR_NAMA_REFERENSI) {
        this.PR_NAMA_REFERENSI = PR_NAMA_REFERENSI;
    }

    public String getPR_NO_HP_REFERENSI() {
        return PR_NO_HP_REFERENSI;
    }

    public void setPR_NO_HP_REFERENSI(String PR_NO_HP_REFERENSI) {
        this.PR_NO_HP_REFERENSI = PR_NO_HP_REFERENSI;
    }

    public String getMS_KODE_USAHA_SID() {
        return MS_KODE_USAHA_SID;
    }

    public void setMS_KODE_USAHA_SID(String MS_KODE_USAHA_SID) {
        this.MS_KODE_USAHA_SID = MS_KODE_USAHA_SID;
    }

    public String getMS_KODE_BIDANG_USAHA() {
        return MS_KODE_BIDANG_USAHA;
    }

    public void setMS_KODE_BIDANG_USAHA(String MS_KODE_BIDANG_USAHA) {
        this.MS_KODE_BIDANG_USAHA = MS_KODE_BIDANG_USAHA;
    }

    public int getMS_KODE_GOLONGAN_DEBITUR_SID_ID() {
        return MS_KODE_GOLONGAN_DEBITUR_SID_ID;
    }

    public void setMS_KODE_GOLONGAN_DEBITUR_SID_ID(int MS_KODE_GOLONGAN_DEBITUR_SID_ID) {
        this.MS_KODE_GOLONGAN_DEBITUR_SID_ID = MS_KODE_GOLONGAN_DEBITUR_SID_ID;
    }

    public int getMS_HUB_DEB_PNM_ID() {
        return MS_HUB_DEB_PNM_ID;
    }

    public void setMS_HUB_DEB_PNM_ID(int MS_HUB_DEB_PNM_ID) {
        this.MS_HUB_DEB_PNM_ID = MS_HUB_DEB_PNM_ID;
    }

    public int getMS_HUB_DEB_BANK_ID() {
        return MS_HUB_DEB_BANK_ID;
    }

    public void setMS_HUB_DEB_BANK_ID(int MS_HUB_DEB_BANK_ID) {
        this.MS_HUB_DEB_BANK_ID = MS_HUB_DEB_BANK_ID;
    }




}
