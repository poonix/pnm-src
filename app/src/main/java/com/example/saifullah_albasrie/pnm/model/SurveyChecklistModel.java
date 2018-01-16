package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/12/17.
 */

public class SurveyChecklistModel {
    /*
    {
      "survey": 1,
      "profileKarakter": 1,
      "kapasitasUsaha": null,
      "jenisUsaha": null,
      "keuangan": null,
      "kebutuhanModalKerja": null,
      "keluarga": null,
      "agunan": null,
      "dokumen_lainnya": null
    }
     */

    @SerializedName("id_survey")
    @Expose
    private String idSurvey;
    @SerializedName("survey")
    @Expose
    private int survey;
    @SerializedName("profileKarakter")
    @Expose
    private int profileKarakter;
    @SerializedName("kapasitasUsaha")
    @Expose
    private int kapasitasUsaha;
    @SerializedName("jenisUsaha")
    @Expose
    private int jenisUsaha;
    @SerializedName("keuangan")
    @Expose
    private int keuangan;
    @SerializedName("kebutuhanModalKerja")
    @Expose
    private int kebutuhanModalKerja;
    @SerializedName("keluarga")
    @Expose
    private int keluarga;
    @SerializedName("agunan")
    @Expose
    private int agunan;
    @SerializedName("dokumen_lainnya")
    @Expose
    private int dokumenLainnya;

    @SerializedName("is_cek_sid")
    @Expose
    private int isCheckSID;

    public SurveyChecklistModel() {

    }

    public String getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(String idSurvey) {
        this.idSurvey = idSurvey;
    }

    public int getSurvey() {
        return survey;
    }

    public void setSurvey(int survey) {
        this.survey = survey;
    }

    public int getProfileKarakter() {
        return profileKarakter;
    }

    public void setProfileKarakter(int profileKarakter) {
        this.profileKarakter = profileKarakter;
    }

    public int getKapasitasUsaha() {
        return kapasitasUsaha;
    }

    public void setKapasitasUsaha(int kapasitasUsaha) {
        this.kapasitasUsaha = kapasitasUsaha;
    }

    public int getJenisUsaha() {
        return jenisUsaha;
    }

    public void setJenisUsaha(int jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
    }

    public int getKeuangan() {
        return keuangan;
    }

    public void setKeuangan(int keuangan) {
        this.keuangan = keuangan;
    }

    public int getKebutuhanModalKerja() {
        return kebutuhanModalKerja;
    }

    public void setKebutuhanModalKerja(int kebutuhanModalKerja) {
        this.kebutuhanModalKerja = kebutuhanModalKerja;
    }

    public int getKeluarga() {
        return keluarga;
    }

    public void setKeluarga(int keluarga) {
        this.keluarga = keluarga;
    }

    public int getAgunan() {
        return agunan;
    }

    public void setAgunan(int agunan) {
        this.agunan = agunan;
    }

    public int getDokumenLainnya() {
        return dokumenLainnya;
    }

    public void setDokumenLainnya(int dokumenLainnya) {
        this.dokumenLainnya = dokumenLainnya;
    }

    public int getIsCheckSID() {
        return isCheckSID;
    }

    public void setIsCheckSID(int isCheckSID) {
        this.isCheckSID = isCheckSID;
    }

    public boolean isFormCompleted() {
        return getSurvey() == 1
                && getProfileKarakter() == 1
                && getKapasitasUsaha() == 1
                && getJenisUsaha() == 1
                && getKeuangan() == 1
                && getKebutuhanModalKerja() == 1
                && getKeluarga() == 1
                && getAgunan() == 1
                && getDokumenLainnya() == 1;
    }
}
