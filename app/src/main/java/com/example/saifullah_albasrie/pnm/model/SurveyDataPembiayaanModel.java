package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class SurveyDataPembiayaanModel implements Parcelable{

    @SerializedName("rencana_produk")
    @Expose
    private int rencanaProduk;
    @SerializedName("nama_produk")
    @Expose
    private String namaProduk;
    @SerializedName("rencana_plafond")
    @Expose
    private String rencanaPlafond;
    @SerializedName("jangka_waktu")
    @Expose
    private int jangkaWaktu;
    @SerializedName("angsuran_perbulan")
    @Expose
    private String angsuranPerbulan;
    @SerializedName("tujuan_pembiayaan")
    @Expose
    private String tujuanPembiayaan;

    public SurveyDataPembiayaanModel() {

    }

    protected SurveyDataPembiayaanModel(Parcel in) {
        rencanaProduk = in.readInt();
        namaProduk = in.readString();
        rencanaPlafond = in.readString();
        jangkaWaktu = in.readInt();
        angsuranPerbulan = in.readString();
        tujuanPembiayaan = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rencanaProduk);
        dest.writeString(namaProduk);
        dest.writeString(rencanaPlafond);
        dest.writeInt(jangkaWaktu);
        dest.writeString(angsuranPerbulan);
        dest.writeString(tujuanPembiayaan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SurveyDataPembiayaanModel> CREATOR = new Creator<SurveyDataPembiayaanModel>() {
        @Override
        public SurveyDataPembiayaanModel createFromParcel(Parcel in) {
            return new SurveyDataPembiayaanModel(in);
        }

        @Override
        public SurveyDataPembiayaanModel[] newArray(int size) {
            return new SurveyDataPembiayaanModel[size];
        }
    };

    public int getRencanaProduk() {
        return rencanaProduk;
    }

    public void setRencanaProduk(int rencanaProduk) {
        this.rencanaProduk = rencanaProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getRencanaPlafond() {
        return rencanaPlafond;
    }

    public void setRencanaPlafond(String rencanaPlafond) {
        this.rencanaPlafond = rencanaPlafond;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public void setJangkaWaktu(int jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }

    public String getAngsuranPerbulan() {
        return angsuranPerbulan;
    }

    public void setAngsuranPerbulan(String angsuranPerbulan) {
        this.angsuranPerbulan = angsuranPerbulan;
    }

    public String getTujuanPembiayaan() {
        return tujuanPembiayaan;
    }

    public void setTujuanPembiayaan(String tujuanPembiayaan) {
        this.tujuanPembiayaan = tujuanPembiayaan;
    }

}

