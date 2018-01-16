package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/17/17.
 */

public class BiodataModel{

    @SerializedName("id_sdm")
    @Expose
    public String idSdm;
    @SerializedName("id_debitur")
    @Expose
    public String idDebitur;
    @SerializedName("id_transaksi_debitur")
    @Expose
    public String idTransaksiDebitur;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;

    @SerializedName("kode_unit")
    @Expose
    private String kodeUnit;
    @SerializedName("kode_cabang")
    @Expose
    private String kodeCabang;

    @SerializedName("created_date")
    @Expose
    private String createdDate;

    public BiodataModel() {

    }

    public String getIdSdm() {
        return idSdm;
    }

    public void setIdSdm(String idSdm) {
        this.idSdm = idSdm;
    }

    public String getIdDebitur() {
        return idDebitur;
    }

    public void setIdDebitur(String idDebitur) {
        this.idDebitur = idDebitur;
    }

    public String getIdTransaksiDebitur() {
        return idTransaksiDebitur;
    }

    public void setIdTransaksiDebitur(String idTransaksiDebitur) {
        this.idTransaksiDebitur = idTransaksiDebitur;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
    }

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
