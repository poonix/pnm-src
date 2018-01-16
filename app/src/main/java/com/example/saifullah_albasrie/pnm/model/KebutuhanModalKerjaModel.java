package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class KebutuhanModalKerjaModel {
    @SerializedName("posisi_akhir")
    @Expose
    private String posisiAkhir;
    @SerializedName("persediaan_dagang")
    @Expose
    private String persediaanDagang;
    @SerializedName("persediaan_lain")
    @Expose
    private String persediaanLain;
    @SerializedName("total_persediaan")
    @Expose
    private String totalPersediaan;
    @SerializedName("piutang_dagang")
    @Expose
    private String piutangDagang;
    @SerializedName("piutang_lain")
    @Expose
    private String piutangLain;
    @SerializedName("total_piutang")
    @Expose
    private String totalPiutang;
    @SerializedName("utang_dagang")
    @Expose
    private String utangDagang;
    @SerializedName("utang_lain")
    @Expose
    private String utangLain;
    @SerializedName("total_utang")
    @Expose
    private String totalUtang;
    @SerializedName("modal_kerja")
    @Expose
    private String modalKerja;
    @SerializedName("investasi")
    @Expose
    private String investasi;
    @SerializedName("perputaran_persediaan")
    @Expose
    private String perputaranPersediaan;
    @SerializedName("perputaran_piutang")
    @Expose
    private String perputaranPiutang;
    @SerializedName("perputaran_utang")
    @Expose
    private String perputaranUtang;
    @SerializedName("perputaran_modal")
    @Expose
    private String perputaranModal;
    @SerializedName("trend_keuangan")
    @Expose
    private String trendKeuangan;
    @SerializedName("omzet")
    @Expose
    private String omzet;
    @SerializedName("laba_rugi_tahunLalu")
    @Expose
    private String labaRugiTahunLalu;
    @SerializedName("modal_bersih_tahunLalu")
    @Expose
    private String modalBersihTahunLalu;
    @SerializedName("executive_summary_omzet")
    @Expose
    private String executiveSummaryOmzet;
    @SerializedName("executive_summary_aspek")
    @Expose
    private String executiveSummaryAspek;

    @SerializedName("hpp")
    @Expose
    private String hpp;
    @SerializedName("penjualan")
    @Expose
    private String penjualan;

    public String getPosisiAkhir() {
        return posisiAkhir;
    }

    public void setPosisiAkhir(String posisiAkhir) {
        this.posisiAkhir = posisiAkhir;
    }

    public String getPersediaanDagang() {
        return persediaanDagang;
    }

    public void setPersediaanDagang(String persediaanDagang) {
        this.persediaanDagang = persediaanDagang;
    }

    public String getPersediaanLain() {
        return persediaanLain;
    }

    public void setPersediaanLain(String persediaanLain) {
        this.persediaanLain = persediaanLain;
    }

    public String getTotalPersediaan() {
        return totalPersediaan;
    }

    public void setTotalPersediaan(String totalPersediaan) {
        this.totalPersediaan = totalPersediaan;
    }

    public String getPiutangDagang() {
        return piutangDagang;
    }

    public void setPiutangDagang(String piutangDagang) {
        this.piutangDagang = piutangDagang;
    }

    public String getPiutangLain() {
        return piutangLain;
    }

    public void setPiutangLain(String piutangLain) {
        this.piutangLain = piutangLain;
    }

    public String getTotalPiutang() {
        return totalPiutang;
    }

    public void setTotalPiutang(String totalPiutang) {
        this.totalPiutang = totalPiutang;
    }

    public String getUtangDagang() {
        return utangDagang;
    }

    public void setUtangDagang(String utangDagang) {
        this.utangDagang = utangDagang;
    }

    public String getUtangLain() {
        return utangLain;
    }

    public void setUtangLain(String utangLain) {
        this.utangLain = utangLain;
    }

    public String getModalKerja() {
        return modalKerja;
    }

    public void setModalKerja(String modalKerja) {
        this.modalKerja = modalKerja;
    }

    public String getInvestasi() {
        return investasi;
    }

    public void setInvestasi(String investasi) {
        this.investasi = investasi;
    }

    public String getPerputaranPersediaan() {
        return perputaranPersediaan;
    }

    public void setPerputaranPersediaan(String perputaranPersediaan) {
        this.perputaranPersediaan = perputaranPersediaan;
    }

    public String getPerputaranPiutang() {
        return perputaranPiutang;
    }

    public void setPerputaranPiutang(String perputaranPiutang) {
        this.perputaranPiutang = perputaranPiutang;
    }

    public String getPerputaranUtang() {
        return perputaranUtang;
    }

    public void setPerputaranUtang(String perputaranUtang) {
        this.perputaranUtang = perputaranUtang;
    }

    public String getPerputaranModal() {
        return perputaranModal;
    }

    public void setPerputaranModal(String perputaranModal) {
        this.perputaranModal = perputaranModal;
    }

    public String getTrendKeuangan() {
        return trendKeuangan;
    }

    public void setTrendKeuangan(String trendKeuangan) {
        this.trendKeuangan = trendKeuangan;
    }

    public String getOmzet() {
        return omzet;
    }

    public void setOmzet(String omzet) {
        this.omzet = omzet;
    }

    public String getLabaRugiTahunLalu() {
        return labaRugiTahunLalu;
    }

    public void setLabaRugiTahunLalu(String labaRugiTahunLalu) {
        this.labaRugiTahunLalu = labaRugiTahunLalu;
    }

    public String getModalBersihTahunLalu() {
        return modalBersihTahunLalu;
    }

    public void setModalBersihTahunLalu(String modalBersihTahunLalu) {
        this.modalBersihTahunLalu = modalBersihTahunLalu;
    }

    public String getTotalUtang() {
        return totalUtang;
    }

    public void setTotalUtang(String totalUtang) {
        this.totalUtang = totalUtang;
    }

    public String getExecutiveSummaryOmzet() {
        return executiveSummaryOmzet;
    }

    public void setExecutiveSummaryOmzet(String executiveSummaryOmzet) {
        this.executiveSummaryOmzet = executiveSummaryOmzet;
    }

    public String getExecutiveSummaryAspek() {
        return executiveSummaryAspek;
    }

    public void setExecutiveSummaryAspek(String executiveSummaryAspek) {
        this.executiveSummaryAspek = executiveSummaryAspek;
    }

    public String getHpp() {
        return hpp;
    }

    public void setHpp(String hpp) {
        this.hpp = hpp;
    }

    public String getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(String penjualan) {
        this.penjualan = penjualan;
    }
}
