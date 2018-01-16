package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class SurveyKeuanganModel {
    @SerializedName("jumlah_pendapatan")
    @Expose
    private String jumlahPendapatan;
    @SerializedName("harga_pokok")
    @Expose
    private String hargaPokok;
    @SerializedName("biaya_tenaga_kerja")
    @Expose
    private String biayaTenagaKerja;
    @SerializedName("biaya_sewa_usaha")
    @Expose
    private String biayaSewaUsaha;
    @SerializedName("biaya_sewa_lain")
    @Expose
    private String biayaSewaLain;
    @SerializedName("biaya_operasional")
    @Expose
    private String biayaOperasional;
    @SerializedName("biaya_lain")
    @Expose
    private String biayaLain;
    @SerializedName("is_usaha_lain")
    @Expose
    private int isUsahaLain;
    @SerializedName("bidang_usaha_lain")
    @Expose
    private int bidangUsahaLain;
    @SerializedName("nama_usaha_lainnya")
    @Expose
    private String namaUsahaLainnya;
    @SerializedName("penghasilan_bersih_usaha1")
    @Expose
    private String penghasilanBersihUsaha1;
    @SerializedName("penghasilan_bersih_usaha2")
    @Expose
    private String penghasilanBersihUsaha2;
    @SerializedName("is_gaji_pasangan")
    @Expose
    private int isGajiPasangan;
    @SerializedName("gaji_debitur")
    @Expose
    private String gajiDebitur;
    @SerializedName("gaji_pasangan")
    @Expose
    private String gajiPasangan;
    @SerializedName("biaya_rt_pasangan")
    @Expose
    private String biayaRtPasangan;
    @SerializedName("biaya_rt_anak")
    @Expose
    private String biayaRtAnak;
    @SerializedName("biaya_rt_tanggungan")
    @Expose
    private String biayaRtTanggungan;
    @SerializedName("exum")
    @Expose
    private String exum;

    /*
    "total_biaya_usaha": "2312313.00",
    "keuntungan_usaha": null,
total_penghasilan_bersih_usaha_lain
total_gaji
total_penghasilan
total_biaya_rumah_tangga
sisa_penghasilan
total_penghasilan_bersih

    */

    @SerializedName("total_biaya_usaha")
    @Expose
    private String totalBiayaUsaha;
    @SerializedName("keuntungan_usaha")
    @Expose
    private String keuntunganUsaha;
    @SerializedName("total_penghasilan_bersih_usaha_lain")
    @Expose
    private String totalPenghasilanBersihUsahaLain;
    @SerializedName("total_gaji")
    @Expose
    private String totalGaji;
    @SerializedName("total_penghasilan")
    @Expose
    private String totalPenghasilan;
    @SerializedName("total_biaya_rumah_tangga")
    @Expose
    private String totalBiayaRT;
    @SerializedName("total_angsuran")
    @Expose
    private String totalAngsuranSaatIni;
    @SerializedName("sisa_penghasilan")
    @Expose
    private String sisaPenghasilan;
    @SerializedName("total_penghasilan_bersih")
    @Expose
    private String totalPenghasilanBersih;



    public String getJumlahPendapatan() {
        return jumlahPendapatan;
    }

    public void setJumlahPendapatan(String jumlahPendapatan) {
        this.jumlahPendapatan = jumlahPendapatan;
    }

    public String getHargaPokok() {
        return hargaPokok;
    }

    public void setHargaPokok(String hargaPokok) {
        this.hargaPokok = hargaPokok;
    }

    public String getBiayaTenagaKerja() {
        return biayaTenagaKerja;
    }

    public void setBiayaTenagaKerja(String biayaTenagaKerja) {
        this.biayaTenagaKerja = biayaTenagaKerja;
    }

    public String getBiayaSewaUsaha() {
        return biayaSewaUsaha;
    }

    public void setBiayaSewaUsaha(String biayaSewaUsaha) {
        this.biayaSewaUsaha = biayaSewaUsaha;
    }

    public String getBiayaSewaLain() {
        return biayaSewaLain;
    }

    public void setBiayaSewaLain(String biayaSewaLain) {
        this.biayaSewaLain = biayaSewaLain;
    }

    public String getBiayaOperasional() {
        return biayaOperasional;
    }

    public void setBiayaOperasional(String biayaOperasional) {
        this.biayaOperasional = biayaOperasional;
    }

    public String getBiayaLain() {
        return biayaLain;
    }

    public void setBiayaLain(String biayaLain) {
        this.biayaLain = biayaLain;
    }

    public int getIsUsahaLain() {
        return isUsahaLain;
    }

    public void setIsUsahaLain(int isUsahaLain) {
        this.isUsahaLain = isUsahaLain;
    }

    public int getBidangUsahaLain() {
        return bidangUsahaLain;
    }

    public void setBidangUsahaLain(int bidangUsahaLain) {
        this.bidangUsahaLain = bidangUsahaLain;
    }

    public String getNamaUsahaLainnya() {
        return namaUsahaLainnya;
    }

    public void setNamaUsahaLainnya(String namaUsahaLainnya) {
        this.namaUsahaLainnya = namaUsahaLainnya;
    }

    public String getPenghasilanBersihUsaha1() {
        return penghasilanBersihUsaha1;
    }

    public void setPenghasilanBersihUsaha1(String penghasilanBersihUsaha1) {
        this.penghasilanBersihUsaha1 = penghasilanBersihUsaha1;
    }

    public String getPenghasilanBersihUsaha2() {
        return penghasilanBersihUsaha2;
    }

    public void setPenghasilanBersihUsaha2(String penghasilanBersihUsaha2) {
        this.penghasilanBersihUsaha2 = penghasilanBersihUsaha2;
    }

    public int getIsGajiPasangan() {
        return isGajiPasangan;
    }

    public void setIsGajiPasangan(int isGajiPasangan) {
        this.isGajiPasangan = isGajiPasangan;
    }

    public String getGajiDebitur() {
        return gajiDebitur;
    }

    public void setGajiDebitur(String gajiDebitur) {
        this.gajiDebitur = gajiDebitur;
    }

    public String getGajiPasangan() {
        return gajiPasangan;
    }

    public void setGajiPasangan(String gajiPasangan) {
        this.gajiPasangan = gajiPasangan;
    }

    public String getBiayaRtPasangan() {
        return biayaRtPasangan;
    }

    public void setBiayaRtPasangan(String biayaRtPasangan) {
        this.biayaRtPasangan = biayaRtPasangan;
    }

    public String getBiayaRtAnak() {
        return biayaRtAnak;
    }

    public void setBiayaRtAnak(String biayaRtAnak) {
        this.biayaRtAnak = biayaRtAnak;
    }

    public String getBiayaRtTanggungan() {
        return biayaRtTanggungan;
    }

    public void setBiayaRtTanggungan(String biayaRtTanggungan) {
        this.biayaRtTanggungan = biayaRtTanggungan;
    }

    public String getExum() {
        return exum;
    }

    public void setExum(String exum) {
        this.exum = exum;
    }

    public String getTotalBiayaUsaha() {
        return totalBiayaUsaha;
    }

    public void setTotalBiayaUsaha(String totalBiayaUsaha) {
        this.totalBiayaUsaha = totalBiayaUsaha;
    }

    public String getKeuntunganUsaha() {
        return keuntunganUsaha;
    }

    public void setKeuntunganUsaha(String keuntunganUsaha) {
        this.keuntunganUsaha = keuntunganUsaha;
    }

    public String getTotalPenghasilanBersihUsahaLain() {
        return totalPenghasilanBersihUsahaLain;
    }

    public void setTotalPenghasilanBersihUsahaLain(String totalPenghasilanBersihUsahaLain) {
        this.totalPenghasilanBersihUsahaLain = totalPenghasilanBersihUsahaLain;
    }

    public String getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(String totalGaji) {
        this.totalGaji = totalGaji;
    }

    public String getTotalPenghasilan() {
        return totalPenghasilan;
    }

    public void setTotalPenghasilan(String totalPenghasilan) {
        this.totalPenghasilan = totalPenghasilan;
    }

    public String getTotalBiayaRT() {
        return totalBiayaRT;
    }

    public void setTotalBiayaRT(String totalBiayaRT) {
        this.totalBiayaRT = totalBiayaRT;
    }

    public String getTotalAngsuranSaatIni() {
        return totalAngsuranSaatIni;
    }

    public void setTotalAngsuranSaatIni(String totalAngsuranSaatIni) {
        this.totalAngsuranSaatIni = totalAngsuranSaatIni;
    }

    public String getSisaPenghasilan() {
        return sisaPenghasilan;
    }

    public void setSisaPenghasilan(String sisaPenghasilan) {
        this.sisaPenghasilan = sisaPenghasilan;
    }

    public String getTotalPenghasilanBersih() {
        return totalPenghasilanBersih;
    }

    public void setTotalPenghasilanBersih(String totalPenghasilanBersih) {
        this.totalPenghasilanBersih = totalPenghasilanBersih;
    }
}
