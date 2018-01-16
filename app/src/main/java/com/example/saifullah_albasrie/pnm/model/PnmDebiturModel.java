package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/26/17.
 */

public class PnmDebiturModel implements Parcelable {

    /*@SerializedName("NASABAH_ID")
    @Expose
    private String nasabahId;
    @SerializedName("NO_REKENING")
    @Expose
    private String noRekening;
    @SerializedName("NAMA_NASABAH")
    @Expose
    private String namaNasabah;
    @SerializedName("NAMA_IBU_KANDUNG")
    @Expose
    private String namaIbuKandung;
    @SerializedName("ALAMAT")
    @Expose
    private String alamat;
    @SerializedName("KOTA")
    @Expose
    private String kota;
    @SerializedName("NO_ID")
    @Expose
    private String noId;
    @SerializedName("TGL_REALISASI")
    @Expose
    private String tglRealisasi;
    @SerializedName("TANGGAL")
    @Expose
    private String tanggal;
    @SerializedName("BULAN")
    @Expose
    private String bulan;
    @SerializedName("TAHUN")
    @Expose
    private String tahun;
    @SerializedName("TELPON")
    @Expose
    private String telpon;
    @SerializedName("TANGGAL_LAHIR")
    @Expose
    private String tanggalLahir;
    @SerializedName("TEMPAT_LAHIR")
    @Expose
    private String tempatLahir;
    @SerializedName("KOTA_ID")
    @Expose
    private String kotaId;
    @SerializedName("TIPE_KREDIT")
    @Expose
    private String tipeKredit;
    @SerializedName("PRODUK")
    @Expose
    private String produk;
    @SerializedName("PROGRAM")
    @Expose
    private Object program;
    @SerializedName("NO_REK_SEBELUMNYA")
    @Expose
    private String noRekSebelumnya;
    @SerializedName("TGL_JATUH_TEMPO")
    @Expose
    private String tglJatuhTempo;
    @SerializedName("JML_PINJAMAN")
    @Expose
    private String jmlPinjaman;
    @SerializedName("TENOR")
    @Expose
    private String tenor;
    @SerializedName("NO_PK_BARU")
    @Expose
    private String noPkBaru;
    @SerializedName("NO_PK_LAMA")
    @Expose
    private String noPkLama;
    @SerializedName("SALDO_NOMINATIF")
    @Expose
    private String saldoNominatif;
    @SerializedName("ANGSURAN_TOTAL")
    @Expose
    private String angsuranTotal;
    @SerializedName("FT_POKOK")
    @Expose
    private String ftPokok;
    @SerializedName("FT_BUNGA")
    @Expose
    private String ftBunga;
    @SerializedName("KOLEKTIBILITAS")
    @Expose
    private String kolektibilitas;
    @SerializedName("TGL_ANGSURAN")
    @Expose
    private String tglAngsuran;
    @SerializedName("NILAI_LIKUIDASI")
    @Expose
    private String nilaiLikuidasi;
    @SerializedName("KODE_UNIT")
    @Expose
    private String kodeUnit;
    @SerializedName("NAMA_UNIT")
    @Expose
    private String namaUnit;
    @SerializedName("KODE_CABANG")
    @Expose
    private String kodeCabang;
    @SerializedName("NAMA_CABANG")
    @Expose
    private String namaCabang;
    @SerializedName("BWMP")
    @Expose
    private String bwmp;
    @SerializedName("JENIS_USAHA")
    @Expose
    private String jenisUsaha;
    @SerializedName("SEKTOR_EKONOMI")
    @Expose
    private String sektorEkonomi;*/

    @SerializedName("NO_REKENING")
    @Expose
    private String noRekening;
    @SerializedName("Nama_Debitur")
    @Expose
    private String namaDebitur;
    @SerializedName("ID_Debitur")
    @Expose
    private String iDDebitur;
    @SerializedName("ID_KTP")
    @Expose
    private String idKTP;
    @SerializedName("Tgl_Jatuh_Tempo")
    @Expose
    private String tglJatuhTempo;
    @SerializedName("Saldo_Nominatif")
    @Expose
    private String saldoNominatif;
    @SerializedName("Angsuran_Total")
    @Expose
    private String angsuranTotal;
    @SerializedName("Kode_Golongan")
    @Expose
    private String kodeGolongan;
    @SerializedName("Saldo_DCA")
    @Expose
    private String saldoDCA;
    @SerializedName("Angsuran_Ke")
    @Expose
    private String angsuranKe;
    @SerializedName("Jml_Tunggakan_Hari")
    @Expose
    private String jmlTunggakanHari;
    @SerializedName("Tunggakan_Pokok")
    @Expose
    private String tunggakanPokok;
    @SerializedName("Tunggakan_Bunga")
    @Expose
    private String tunggakanBunga;
    @SerializedName("Tunggakan_Denda")
    @Expose
    private String tunggakanDenda;
    @SerializedName("Total_Tagihan")
    @Expose
    private String totalTagihan;
    @SerializedName("Kode_Unit")
    @Expose
    private String kodeUnit;
    @SerializedName("Nama_Unit")
    @Expose
    private String namaUnit;
    @SerializedName("Kode_Cabang")
    @Expose
    private String kodeCabang;
    @SerializedName("Nama_Cabang")
    @Expose
    private String namaCabang;
    @SerializedName("kolektibilitas")
    @Expose
    private String kolektibilitas;


    public PnmDebiturModel() { }


    protected PnmDebiturModel(Parcel in) {
        noRekening = in.readString();
        namaDebitur = in.readString();
        iDDebitur = in.readString();
        idKTP = in.readString();
        tglJatuhTempo = in.readString();
        saldoNominatif = in.readString();
        angsuranTotal = in.readString();
        kodeGolongan = in.readString();
        saldoDCA = in.readString();
        angsuranKe = in.readString();
        jmlTunggakanHari = in.readString();
        tunggakanPokok = in.readString();
        tunggakanBunga = in.readString();
        tunggakanDenda = in.readString();
        totalTagihan = in.readString();
        kodeUnit = in.readString();
        namaUnit = in.readString();
        kodeCabang = in.readString();
        namaCabang = in.readString();
        kolektibilitas = in.readString();
    }

    public static final Creator<PnmDebiturModel> CREATOR = new Creator<PnmDebiturModel>() {
        @Override
        public PnmDebiturModel createFromParcel(Parcel in) {
            return new PnmDebiturModel(in);
        }

        @Override
        public PnmDebiturModel[] newArray(int size) {
            return new PnmDebiturModel[size];
        }
    };

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getNamaDebitur() {
        return namaDebitur;
    }

    public void setNamaDebitur(String namaDebitur) {
        this.namaDebitur = namaDebitur;
    }

    public String getiDDebitur() {
        return iDDebitur;
    }

    public void setiDDebitur(String iDDebitur) {
        this.iDDebitur = iDDebitur;
    }

    public String getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(String idKTP) {
        this.idKTP = idKTP;
    }

    public String getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(String tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public String getSaldoNominatif() {
        return saldoNominatif;
    }

    public void setSaldoNominatif(String saldoNominatif) {
        this.saldoNominatif = saldoNominatif;
    }

    public String getAngsuranTotal() {
        return angsuranTotal;
    }

    public void setAngsuranTotal(String angsuranTotal) {
        this.angsuranTotal = angsuranTotal;
    }

    public String getKodeGolongan() {
        return kodeGolongan;
    }

    public void setKodeGolongan(String kodeGolongan) {
        this.kodeGolongan = kodeGolongan;
    }

    public String getSaldoDCA() {
        return saldoDCA;
    }

    public void setSaldoDCA(String saldoDCA) {
        this.saldoDCA = saldoDCA;
    }

    public String getAngsuranKe() {
        return angsuranKe;
    }

    public void setAngsuranKe(String angsuranKe) {
        this.angsuranKe = angsuranKe;
    }

    public String getJmlTunggakanHari() {
        return jmlTunggakanHari;
    }

    public void setJmlTunggakanHari(String jmlTunggakanHari) {
        this.jmlTunggakanHari = jmlTunggakanHari;
    }

    public String getTunggakanPokok() {
        return tunggakanPokok;
    }

    public void setTunggakanPokok(String tunggakanPokok) {
        this.tunggakanPokok = tunggakanPokok;
    }

    public String getTunggakanBunga() {
        return tunggakanBunga;
    }

    public void setTunggakanBunga(String tunggakanBunga) {
        this.tunggakanBunga = tunggakanBunga;
    }

    public String getTunggakanDenda() {
        return tunggakanDenda;
    }

    public void setTunggakanDenda(String tunggakanDenda) {
        this.tunggakanDenda = tunggakanDenda;
    }

    public String getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(String totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
    }

    public String getNamaUnit() {
        return namaUnit;
    }

    public void setNamaUnit(String namaUnit) {
        this.namaUnit = namaUnit;
    }

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getNamaCabang() {
        return namaCabang;
    }

    public void setNamaCabang(String namaCabang) {
        this.namaCabang = namaCabang;
    }

    public String getKolektibilitas() {
        return kolektibilitas;
    }

    public void setKolektibilitas(String kolektibilitas) {
        this.kolektibilitas = kolektibilitas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noRekening);
        dest.writeString(namaDebitur);
        dest.writeString(iDDebitur);
        dest.writeString(idKTP);
        dest.writeString(tglJatuhTempo);
        dest.writeString(saldoNominatif);
        dest.writeString(angsuranTotal);
        dest.writeString(kodeGolongan);
        dest.writeString(saldoDCA);
        dest.writeString(angsuranKe);
        dest.writeString(jmlTunggakanHari);
        dest.writeString(tunggakanPokok);
        dest.writeString(tunggakanBunga);
        dest.writeString(tunggakanDenda);
        dest.writeString(totalTagihan);
        dest.writeString(kodeUnit);
        dest.writeString(namaUnit);
        dest.writeString(kodeCabang);
        dest.writeString(namaCabang);
        dest.writeString(kolektibilitas);
    }
}
