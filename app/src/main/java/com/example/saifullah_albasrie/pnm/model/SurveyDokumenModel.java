package com.example.saifullah_albasrie.pnm.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/21/17.
 */

public class SurveyDokumenModel {

    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;
    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("jenis_dokumen")
    @Expose
    private String jenisDokumen;
    @SerializedName("tipe_file")
    @Expose
    private String tipeFile;
    @SerializedName("nama_file")
    @Expose
    private String namaFile;
    @SerializedName("url_file")
    @Expose
    private String urlFile;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    private String localFile;
    private Bitmap bitmap;
    private boolean hasUploaded = true;

    public SurveyDokumenModel() {}

    public SurveyDokumenModel(SurveyDokumenModel clone) {
        this.id = clone.getId();
        this.idDebitur = clone.getIdDebitur();
        this.idTransaksiDebitur = clone.getIdTransaksiDebitur();
        this.jenisDokumen = clone.getJenisDokumen();
        this.tipeFile = clone.getTipeFile();
        this.namaFile = clone.getNamaFile();
        this.urlFile = clone.getUrlFile();
        this.keterangan = clone.getKeterangan();
        this.localFile = clone.getLocalFile();
        this.bitmap = clone.getBitmap();
        this.hasUploaded = clone.hasUploaded;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisDokumen() {
        return jenisDokumen;
    }

    public void setJenisDokumen(String jenisDokumen) {
        this.jenisDokumen = jenisDokumen;
    }

    public String getTipeFile() {
        return tipeFile;
    }

    public void setTipeFile(String tipeFile) {
        this.tipeFile = tipeFile;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap image) {
        this.bitmap = image;
    }

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public boolean isHasUploaded() {
        return hasUploaded;
    }

    public void setHasUploaded(boolean hasUploaded) {
        this.hasUploaded = hasUploaded;
    }
}
