package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 17-Jan-18.
 */

public class NilaiAgunanModel {

    @SerializedName("DB_INDIVIDU_NILAI_AGUNAN_ID")
    @Expose
    public int DB_INDIVIDU_NILAI_AGUNAN_ID;

    @SerializedName("DB_INDIVIDU_AGUNAN_ID ")
    @Expose
    public int DB_INDIVIDU_AGUNAN_ID ;

    @SerializedName("MS_STATUS_PENILAIAN_ID ")
    @Expose
    public int MS_STATUS_PENILAIAN_ID ;

    @SerializedName("DB_TGL_PENILAIAN ")
    @Expose
    private String  DB_TGL_PENILAIAN ;

    @SerializedName("DB_NAMA_PENILAI ")
    @Expose
    private String DB_NAMA_PENILAI ;

    @SerializedName("DB_JABATAN  ")
    @Expose
    private String DB_JABATAN  ;

    @SerializedName("DB_NILAI_PASAR_1  ")
    @Expose
    private String DB_NILAI_PASAR_1  ;

    @SerializedName("DB_NILAI_PASAR_2  ")
    @Expose
    private String DB_NILAI_PASAR_2  ;

    @SerializedName("DB_NILAI_PASAR_3  ")
    @Expose
    private String DB_NILAI_PASAR_3  ;

    @SerializedName("DB_NILAI_PASAR  ")
    @Expose
    private String DB_NILAI_PASAR  ;

    @SerializedName("DB_PERSENTASE_LIKUIDASI  ")
    @Expose
    private String DB_PERSENTASE_LIKUIDASI  ;

    @SerializedName("DB_NILAI_LIKUIDASI  ")
    @Expose
    private String DB_NILAI_LIKUIDASI  ;

    @SerializedName("CREATED_BY_ID  ")
    @Expose
    private int CREATED_BY_ID  ;

    @SerializedName("CREATED_BY_NAME  ")
    @Expose
    private String CREATED_BY_NAME  ;

    public NilaiAgunanModel() {}

    public int getDB_INDIVIDU_NILAI_AGUNAN_ID() {
        return DB_INDIVIDU_NILAI_AGUNAN_ID;
    }

    public void setDB_INDIVIDU_NILAI_AGUNAN_ID(int DB_INDIVIDU_NILAI_AGUNAN_ID) {
        this.DB_INDIVIDU_NILAI_AGUNAN_ID = DB_INDIVIDU_NILAI_AGUNAN_ID;
    }


    public int getDB_INDIVIDU_AGUNAN_ID() {
        return DB_INDIVIDU_AGUNAN_ID;
    }

    public void setDB_INDIVIDU_AGUNAN_ID(int DB_INDIVIDU_AGUNAN_ID) {
        this.DB_INDIVIDU_AGUNAN_ID = DB_INDIVIDU_AGUNAN_ID;
    }


    public int getMS_STATUS_PENILAIAN_ID() {
        return MS_STATUS_PENILAIAN_ID;
    }

    public void setMS_STATUS_PENILAIAN_ID(int MS_STATUS_PENILAIAN_ID) {
        this.MS_STATUS_PENILAIAN_ID = MS_STATUS_PENILAIAN_ID;
    }


    public String  getDB_TGL_PENILAIAN() {
        return DB_TGL_PENILAIAN;
    }

    public void setDB_TGL_PENILAIAN(String DB_TGL_PENILAIAN) {
        this.DB_TGL_PENILAIAN = DB_TGL_PENILAIAN;
    }


    public String getDB_NAMA_PENILAI() {
        return DB_NAMA_PENILAI;
    }

    public void setDB_NAMA_PENILAI(String DB_NAMA_PENILAI) {
        this.DB_NAMA_PENILAI = DB_NAMA_PENILAI;
    }


    public String getDB_JABATAN() {
        return DB_JABATAN;
    }

    public void setDB_JABATAN(String DB_JABATAN) {
        this.DB_JABATAN = DB_JABATAN;
    }


    public String getDB_NILAI_PASAR_1() {
        return DB_NILAI_PASAR_1;
    }

    public void setDB_NILAI_PASAR_1(String DB_NILAI_PASAR_1) {
        this.DB_NILAI_PASAR_1 = DB_NILAI_PASAR_1;
    }


    public String getDB_NILAI_PASAR_2() {
        return DB_NILAI_PASAR_2;
    }

    public void setDB_NILAI_PASAR_2(String DB_NILAI_PASAR_2) {
        this.DB_NILAI_PASAR_2 = DB_NILAI_PASAR_2;
    }


    public String getDB_NILAI_PASAR_3() {
        return DB_NILAI_PASAR_3;
    }

    public void setDB_NILAI_PASAR_3(String DB_NILAI_PASAR_3) {
        this.DB_NILAI_PASAR_3 = DB_NILAI_PASAR_3;
    }


    public String getDB_NILAI_PASAR() {
        return DB_NILAI_PASAR;
    }

    public void setDB_NILAI_PASAR(String DB_NILAI_PASAR) {
        this.DB_NILAI_PASAR = DB_NILAI_PASAR;
    }

    public String getDB_PERSENTASE_LIKUIDASI() {
        return DB_PERSENTASE_LIKUIDASI;
    }

    public void setDB_PERSENTASE_LIKUIDASI(String DB_PERSENTASE_LIKUIDASI) {
        this.DB_PERSENTASE_LIKUIDASI = DB_PERSENTASE_LIKUIDASI;
    }

    public String getDB_NILAI_LIKUIDASI() {
        return DB_NILAI_LIKUIDASI;
    }

    public void setDB_NILAI_LIKUIDASI(String DB_NILAI_LIKUIDASI) {
        this.DB_NILAI_LIKUIDASI = DB_NILAI_LIKUIDASI;
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
