package com.example.saifullah_albasrie.pnm.model;

import android.widget.EditText;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class SurveyDataPinjamanModel {

    /*@SerializedName("id_produk")
    @Expose
    private int idProduk;
    @SerializedName("nama_produk")
    @Expose
    private String namaProduk;
    @SerializedName("id_program")
    @Expose
    private int idProgram;
    @SerializedName("nama_program")
    @Expose
    private String namaProgram;
    @SerializedName("jangka_waktu")
    @Expose
    private int jangkaWaktu;
    @SerializedName("plafond")
    @Expose
    private String plafond;
    @SerializedName("bunga")
    @Expose
    private String bunga;
    @SerializedName("angsuran")
    @Expose
    private String angsuran;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;*/

    //revisi
    /*
    "data_pinjaman": [
        {
            "bank": "Bank Bca",
            "plafond": "200000000.00",
            "outstanding": "100000000.00",
            "angsuran": "20000.00",
            "tujuan_pembiayaan": "investasi",
            "jatuh_tempo": "2017-02-21",
            "kolektibilitas": "Lancar"
        },
    */

    @SerializedName("bank")
    @Expose
    private String namaBank;
    @SerializedName("plafond")
    @Expose
    private String plafond;
    @SerializedName("angsuran")
    @Expose
    private String angsuran;
    @SerializedName("outstanding")
    @Expose
    private String outstanding;
    @SerializedName("tujuan_pembiayaan")
    @Expose
    private String tujuanPembiayaan;
    @SerializedName("kolektibilitas")
    @Expose
    private String kolektibilitas;
    @SerializedName("jatuh_tempo")
    @Expose
    private String jatuhTempo;


    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getPlafond() {
        return plafond;
    }

    public void setPlafond(String plafond) {
        this.plafond = plafond;
    }

    public String getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(String angsuran) {
        this.angsuran = angsuran;
    }

    public String getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    public String getTujuanPembiayaan() {
        return tujuanPembiayaan;
    }

    public void setTujuanPembiayaan(String tujuanPembiayaan) {
        this.tujuanPembiayaan = tujuanPembiayaan;
    }

    public String getKolektibilitas() {
        return kolektibilitas;
    }

    public void setKolektibilitas(String kolektibilitas) {
        this.kolektibilitas = kolektibilitas;
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }
}
