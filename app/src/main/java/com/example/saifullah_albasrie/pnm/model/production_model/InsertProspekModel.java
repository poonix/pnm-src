package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/12/2018.
 */

public class InsertProspekModel {

    @SerializedName("PR_NAMA_LENGKAP")
    @Expose
    public String PR_NAMA_LENGKAP;

    @SerializedName("PR_NAMA_PANGGILAN")
    @Expose
    public String PR_NAMA_PANGGILAN;

    @SerializedName("MS_JENIS_IDENTITAS_ID")
    @Expose
    public int MS_JENIS_IDENTITAS_ID;

    @SerializedName("PR_NO_IDENTITAS")
    @Expose
    private String PR_NO_IDENTITAS;

    @SerializedName("PR_MASA_BERLAKU_IDENTITAS")
    @Expose
    private String PR_MASA_BERLAKU_IDENTITAS;

    @SerializedName("PR_TEMPAT_LAHIR")
    @Expose
    private String PR_TEMPAT_LAHIR;

    @SerializedName("MS_JENIS_KELAMIN_ID")
    @Expose
    private int MS_JENIS_KELAMIN_ID;

    @SerializedName("PR_NAMA_IBU_KANDUNG")
    @Expose
    private String PR_NAMA_IBU_KANDUNG;

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

    @SerializedName("MS_KODE_CABANG")
    @Expose
    private String MS_KODE_CABANG;

    @SerializedName("MS_KODE_UNIT")
    @Expose
    private String MS_KODE_UNIT;

    @SerializedName("MS_JENIS_PEMBIAYAAN_ID")
    @Expose
    private int MS_JENIS_PEMBIAYAAN_ID;

    @SerializedName("PR_TGL_REALISASI_KUNJUNGAN")
    @Expose
    private String PR_TGL_REALISASI_KUNJUNGAN;

    @SerializedName("PR_KETERANGAN_KUNJUNGAN")
    @Expose
    private String PR_KETERANGAN_KUNJUNGAN;

    @SerializedName("PR_KONTAK_UTAMA")
    @Expose
    private String PR_KONTAK_UTAMA;

    @SerializedName("MS_TIPE_KONTAK")
    @Expose
    private String MS_TIPE_KONTAK   ;

    @SerializedName("PR_KONTAK")
    @Expose
    private String PR_KONTAK;

    @SerializedName("MS_JENIS_ALAMAT_ID")
    @Expose
    private int MS_JENIS_ALAMAT_ID;

    @SerializedName("PR_ALAMAT")
    @Expose
    private String PR_ALAMAT;

    @SerializedName("CREATED_BY_ID")
    @Expose
    private int CREATED_BY_ID;

    @SerializedName("CREATED_BY_NAME")
    @Expose
    private String CREATED_BY_NAME;


    public InsertProspekModel() {

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

    public int getMS_JENIS_USAHA_ID() {
        return MS_JENIS_USAHA_ID;
    }

    public void setMS_JENIS_USAHA_ID(int MS_JENIS_USAHA_ID) {
        this.MS_JENIS_USAHA_ID = MS_JENIS_USAHA_ID;
    }

    public int getMS_JENIS_REFERENSI_ID()  {
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

    public String getMS_KODE_CABANG() {
        return MS_KODE_CABANG;
    }

    public void setMS_KODE_CABANG(String MS_KODE_CABANG) {
        this.MS_KODE_CABANG = MS_KODE_CABANG;
    }

    public String getMS_KODE_UNIT() {
        return MS_KODE_UNIT;
    }

    public void setMS_KODE_UNIT(String MS_KODE_UNIT) {
        this.MS_KODE_UNIT = MS_KODE_UNIT;
    }

    public int getMS_JENIS_PEMBIAYAAN_ID() {
        return MS_JENIS_PEMBIAYAAN_ID;
    }

    public void setMS_JENIS_PEMBIAYAAN_ID(int MS_JENIS_PEMBIAYAAN_ID) {
        this.MS_JENIS_PEMBIAYAAN_ID = MS_JENIS_PEMBIAYAAN_ID;
    }

    public String getPR_TGL_REALISASI_KUNJUNGAN() {
        return PR_TGL_REALISASI_KUNJUNGAN;
    }

        public void setPR_TGL_REALISASI_KUNJUNGAN(String PR_TGL_REALISASI_KUNJUNGAN) {
        this.PR_TGL_REALISASI_KUNJUNGAN = PR_TGL_REALISASI_KUNJUNGAN;
    }

    public String getPR_KETERANGAN_KUNJUNGAN() {
        return PR_KETERANGAN_KUNJUNGAN;
    }

    public void setPR_KETERANGAN_KUNJUNGAN(String PR_KETERANGAN_KUNJUNGAN) {
        this.PR_KETERANGAN_KUNJUNGAN = PR_KETERANGAN_KUNJUNGAN;
    }

    public String getPR_KONTAK_UTAMA() {
        return PR_KONTAK_UTAMA;
    }

    public void setPR_KONTAK_UTAMA(String PR_KONTAK_UTAMA) {
        this.PR_KONTAK_UTAMA = PR_KONTAK_UTAMA;
    }

    public String getMS_TIPE_KONTAK() {
        return MS_TIPE_KONTAK;
    }

    public void setMS_TIPE_KONTAK(String MS_TIPE_KONTAK) {
        this.MS_TIPE_KONTAK = MS_TIPE_KONTAK;
    }

    public String getPR_KONTAK() {
        return PR_KONTAK;
    }

    public void setPR_KONTAK(String PR_KONTAK) {
        this.PR_KONTAK = PR_KONTAK;
    }

    public int getMS_JENIS_ALAMAT_ID() {
        return MS_JENIS_ALAMAT_ID;
    }

    public void setPMS_JENIS_ALAMAT_ID(int MS_JENIS_ALAMAT_ID) {
        this.MS_JENIS_ALAMAT_ID = MS_JENIS_ALAMAT_ID;
    }


    public String getPR_ALAMAT() {
        return PR_ALAMAT;
    }

    public void setPR_ALAMAT(String PR_ALAMAT) {
        this.PR_ALAMAT = PR_ALAMAT;
    }

    public int CREATED_BY_ID() {
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
