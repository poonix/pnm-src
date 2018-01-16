package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 10/2/17.
 */

public class RiwayatAngsuran {

    /*
    "NASABAH_ID":"LB.000021",
"NO_REKENING":"LB.017.000009",
"NO_ALTERNATIF":"",
"JML_PINJAMAN":"50000000.00",
"JML_ANGSURAN":36,
"angsuran_total":"1853400.00",
"TGL_REALISASI":{
"date":"2013-10-18 00:00:00.000000",
"timezone_type":3,
"timezone":"America\/Los_Angeles"
},
"TGL_JATUH_TEMPO":{
"date":"2016-10-18 00:00:00.000000",
"timezone_type":3,
"timezone":"America\/Los_Angeles"
},
"POKOK_SALDO_AKHIR":".00",
"BUNGA_SALDO_AKHIR":".00",
"OUTSTANDING":".00",
"POSISI_CICILAN_KE":"36",
"TGL_LUNAS":{
"date":"2016-10-18 00:00:00.000000",
"timezone_type":3,
"timezone":"America\/Los_Angeles"
},
"KOLEKTIBILITAS":"L",
"FLAG_TOLERANSI":"SESUAI JADWAL",
"TIPE_KREDIT":1,
"STATUS_AKTIF":3
     */

    @SerializedName("NASABAH_ID")
    @Expose
    private String nasabahId;
    @SerializedName("NO_REKENING")
    @Expose
    private String noRekening;
    @SerializedName("NO_ALTERNATIF")
    @Expose
    private String noAlternatif;
    @SerializedName("JML_PINJAMAN")
    @Expose
    private String jmlPinjaman;
    @SerializedName("JML_ANGSURAN")
    @Expose
    private int jmlAngsuran;
    @SerializedName("angsuran_total")
    @Expose
    private String angsuranTotal;
    @SerializedName("TGL_REALISASI")
    @Expose
    private TanggalModel tglRealisasi;
    @SerializedName("TGL_JATUH_TEMPO")
    @Expose
    private TanggalModel tglJatuhTempo;
    @SerializedName("POKOK_SALDO_AKHIR")
    @Expose
    private String pokokSaldoAkhir;
    @SerializedName("BUNGA_SALDO_AKHIR")
    @Expose
    private String bungaSaldoAkhir;
    @SerializedName("OUTSTANDING")
    @Expose
    private String outstanding;
    @SerializedName("POSISI_CICILAN_KE")
    @Expose
    private String posisiCicilanKe;
    @SerializedName("TGL_LUNAS")
    @Expose
    private TanggalModel tglLunas;
    @SerializedName("KOLEKTIBILITAS")
    @Expose
    private String kolektibilitas;
    @SerializedName("FLAG_TOLERANSI")
    @Expose
    private String flagToleransi;
    @SerializedName("TIPE_KREDIT")
    @Expose
    private int tipekredit;
    @SerializedName("STATUS_AKTIF")
    @Expose
    private int statusAktif;

    public String getNasabahId() {
        return nasabahId;
    }

    public void setNasabahId(String nasabahId) {
        this.nasabahId = nasabahId;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getNoAlternatif() {
        return noAlternatif;
    }

    public void setNoAlternatif(String noAlternatif) {
        this.noAlternatif = noAlternatif;
    }

    public String getJmlPinjaman() {
        return jmlPinjaman;
    }

    public void setJmlPinjaman(String jmlPinjaman) {
        this.jmlPinjaman = jmlPinjaman;
    }

    public int getJmlAngsuran() {
        return jmlAngsuran;
    }

    public void setJmlAngsuran(int jmlAngsuran) {
        this.jmlAngsuran = jmlAngsuran;
    }

    public String getAngsuranTotal() {
        return angsuranTotal;
    }

    public void setAngsuranTotal(String angsuranTotal) {
        this.angsuranTotal = angsuranTotal;
    }

    public TanggalModel getTglRealisasi() {
        return tglRealisasi;
    }

    public void setTglRealisasi(TanggalModel tglRealisasi) {
        this.tglRealisasi = tglRealisasi;
    }

    public TanggalModel getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(TanggalModel tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public String getPokokSaldoAkhir() {
        return pokokSaldoAkhir;
    }

    public void setPokokSaldoAkhir(String pokokSaldoAkhir) {
        this.pokokSaldoAkhir = pokokSaldoAkhir;
    }

    public String getBungaSaldoAkhir() {
        return bungaSaldoAkhir;
    }

    public void setBungaSaldoAkhir(String bungaSaldoAkhir) {
        this.bungaSaldoAkhir = bungaSaldoAkhir;
    }

    public String getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    public String getPosisiCicilanKe() {
        return posisiCicilanKe;
    }

    public void setPosisiCicilanKe(String posisiCicilanKe) {
        this.posisiCicilanKe = posisiCicilanKe;
    }

    public TanggalModel getTglLunas() {
        return tglLunas;
    }

    public void setTglLunas(TanggalModel tglLunas) {
        this.tglLunas = tglLunas;
    }

    public String getKolektibilitas() {
        return kolektibilitas;
    }

    public void setKolektibilitas(String kolektibilitas) {
        this.kolektibilitas = kolektibilitas;
    }

    public String getFlagToleransi() {
        return flagToleransi;
    }

    public void setFlagToleransi(String flagtoleransi) {
        this.flagToleransi = flagtoleransi;
    }

    public int getTipekredit() {
        return tipekredit;
    }

    public void setTipekredit(int tipekredit) {
        this.tipekredit = tipekredit;
    }

    public int getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(int statusAktif) {
        this.statusAktif = statusAktif;
    }

    /*@SerializedName("ANGSURAN_KE")
    @Expose
    private int angsuranKe;
    @SerializedName("TGL_TRANS")
    @Expose
    private TanggalModel tglTrans;
    @SerializedName("POKOK_DIBAYAR")
    @Expose
    private String pokokDibayar;
    @SerializedName("BUNGA_DIBAYAR")
    @Expose
    private String bungaDibayar;
    @SerializedName("DENDA_DIBAYAR")
    @Expose
    private String dendaDibayar;
    @SerializedName("ANGSURAN_POKOK")
    @Expose
    private String angsuranPokok;
    @SerializedName("ANGSURAN_BUNGA")
    @Expose
    private String angsuranBunga;
    @SerializedName("TOTAL_DIBAYAR")
    @Expose
    private int totalDibayar;
    @SerializedName("TOTAL_ANGSURAN")
    @Expose
    private int totalAngsuran;

    public int getAngsuranKe() {
        return angsuranKe;
    }

    public void setAngsuranKe(int angsuranKe) {
        this.angsuranKe = angsuranKe;
    }

    public TanggalModel getTglTrans() {
        return tglTrans;
    }

    public void setTglTrans(TanggalModel tglTrans) {
        this.tglTrans = tglTrans;
    }

    public String getPokokDibayar() {
        return pokokDibayar;
    }

    public void setPokokDibayar(String pokokDibayar) {
        this.pokokDibayar = pokokDibayar;
    }

    public String getBungaDibayar() {
        return bungaDibayar;
    }

    public void setBungaDibayar(String bungaDibayar) {
        this.bungaDibayar = bungaDibayar;
    }

    public String getDendaDibayar() {
        return dendaDibayar;
    }

    public void setDendaDibayar(String dendaDibayar) {
        this.dendaDibayar = dendaDibayar;
    }

    public String getAngsuranPokok() {
        return angsuranPokok;
    }

    public void setAngsuranPokok(String angsuranPokok) {
        this.angsuranPokok = angsuranPokok;
    }

    public String getAngsuranBunga() {
        return angsuranBunga;
    }

    public void setAngsuranBunga(String angsuranBunga) {
        this.angsuranBunga = angsuranBunga;
    }

    public int getTotalDibayar() {
        return totalDibayar;
    }

    public void setTotalDibayar(int totalDibayar) {
        this.totalDibayar = totalDibayar;
    }

    public int getTotalAngsuran() {
        return totalAngsuran;
    }

    public void setTotalAngsuran(int totalAngsuran) {
        this.totalAngsuran = totalAngsuran;
    }

    public static class TanggalTrans {

        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private int timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezoneType() {
            return timezoneType;
        }

        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

    }*/

    public static class TanggalModel {

        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private int timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezoneType() {
            return timezoneType;
        }

        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

    }

}


