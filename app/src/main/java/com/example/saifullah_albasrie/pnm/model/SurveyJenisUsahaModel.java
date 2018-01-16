package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/20/17.
 */

public class SurveyJenisUsahaModel implements Parcelable{

    @SerializedName("id_jenis_usaha")
    @Expose
    private int idJenisUsaha;
    @SerializedName("nama_jenis_usaha")
    @Expose
    private String namaJenisUsaha;
    @SerializedName("id_jenis_produk_usaha")
    @Expose
    private int idJenisProdukUsaha;
    @SerializedName("nama_jenis_produk_usaha")
    @Expose
    private String namaJenisProdukUsaha;
    @SerializedName("kegiatan_tempat")
    @Expose
    private String kegiatanTempat;
    @SerializedName("jumlah_tenaga_kerja")
    @Expose
    private int jumlahTenagaKerja;
    @SerializedName("jarak_usaha_ulamm")
    @Expose
    private float jarakUsahaUlamm;
    @SerializedName("is_miliki_sku")
    @Expose
    private int isMilikiSku;
    @SerializedName("ketersediaan_bahan_baku")
    @Expose
    private String ketersediaanBahanBaku;
    @SerializedName("jumlah_pemasok")
    @Expose
    private String jumlahPemasok;
    @SerializedName("persaingan_usaha")
    @Expose
    private String persainganUsaha;
    @SerializedName("gambaran_kondisi")
    @Expose
    private String gambaranKondisi;
    @SerializedName("id_pengelolaan_keuangan")
    @Expose
    private int idPengelolaanKeuangan;
    @SerializedName("nama_pengelolaan_keuangan")
    @Expose
    private String namaPengelolaanKeuangan;
    @SerializedName("exum")
    @Expose
    private String exum;
    @SerializedName("alamat_lokasi_usaha")
    @Expose
    private String alamatLokasi;
    @SerializedName("lokasi_usaha_longitude")
    @Expose
    private double lokasiUsahaLongitude;
    @SerializedName("lokasi_usaha_latitude")
    @Expose
    private double lokasiUsahaLatitude;
    @SerializedName("lokasi_usaha_real_longitude")
    @Expose
    private double lokasiUsahaRealLongitude;
    @SerializedName("lokasi_usaha_real_latitude")
    @Expose
    private double lokasiUsahaRealLatitude;
    @SerializedName("pengelolaan_usaha")
    @Expose
    private String pengelolaanUsaha;
    @SerializedName("aspek_pemasaran")
    @Expose
    private String aspekPemasaran;

    public SurveyJenisUsahaModel() {

    }

    protected SurveyJenisUsahaModel(Parcel in) {
        idJenisUsaha = in.readInt();
        namaJenisUsaha = in.readString();
        idJenisProdukUsaha = in.readInt();
        namaJenisProdukUsaha = in.readString();
        kegiatanTempat = in.readString();
        jumlahTenagaKerja = in.readInt();
        jarakUsahaUlamm = in.readFloat();
        isMilikiSku = in.readInt();
        ketersediaanBahanBaku = in.readString();
        jumlahPemasok = in.readString();
        persainganUsaha = in.readString();
        gambaranKondisi = in.readString();
        idPengelolaanKeuangan = in.readInt();
        namaPengelolaanKeuangan = in.readString();
        exum = in.readString();
        alamatLokasi = in.readString();
        lokasiUsahaLongitude = in.readDouble();
        lokasiUsahaLatitude = in.readDouble();
        lokasiUsahaRealLongitude = in.readDouble();
        lokasiUsahaRealLatitude = in.readDouble();
        pengelolaanUsaha = in.readString();
        aspekPemasaran = in.readString();
    }

    public static final Creator<SurveyJenisUsahaModel> CREATOR = new Creator<SurveyJenisUsahaModel>() {
        @Override
        public SurveyJenisUsahaModel createFromParcel(Parcel in) {
            return new SurveyJenisUsahaModel(in);
        }

        @Override
        public SurveyJenisUsahaModel[] newArray(int size) {
            return new SurveyJenisUsahaModel[size];
        }
    };

    public int getIdJenisUsaha() {
        return idJenisUsaha;
    }

    public void setIdJenisUsaha(int idJenisUsaha) {
        this.idJenisUsaha = idJenisUsaha;
    }

    public String getNamaJenisUsaha() {
        return namaJenisUsaha;
    }

    public void setNamaJenisUsaha(String namaJenisUsaha) {
        this.namaJenisUsaha = namaJenisUsaha;
    }

    public int getIdJenisProdukUsaha() {
        return idJenisProdukUsaha;
    }

    public void setIdJenisProdukUsaha(int idJenisProdukUsaha) {
        this.idJenisProdukUsaha = idJenisProdukUsaha;
    }

    public String getNamaJenisProdukUsaha() {
        return namaJenisProdukUsaha;
    }

    public void setNamaJenisProdukUsaha(String namaJenisProdukUsaha) {
        this.namaJenisProdukUsaha = namaJenisProdukUsaha;
    }

    public String getKegiatanTempat() {
        return kegiatanTempat;
    }

    public void setKegiatanTempat(String kegiatanTempat) {
        this.kegiatanTempat = kegiatanTempat;
    }

    public int getJumlahTenagaKerja() {
        return jumlahTenagaKerja;
    }

    public void setJumlahTenagaKerja(int jumlahTenagaKerja) {
        this.jumlahTenagaKerja = jumlahTenagaKerja;
    }

    public float getJarakUsahaUlamm() {
        return jarakUsahaUlamm;
    }

    public void setJarakUsahaUlamm(float jarakUsahaUlamm) {
        this.jarakUsahaUlamm = jarakUsahaUlamm;
    }

    public int getIsMilikiSku() {
        return isMilikiSku;
    }

    public void setIsMilikiSku(int isMilikiSku) {
        this.isMilikiSku = isMilikiSku;
    }

    public String getKetersediaanBahanBaku() {
        return ketersediaanBahanBaku;
    }

    public void setKetersediaanBahanBaku(String ketersediaanBahanBaku) {
        this.ketersediaanBahanBaku = ketersediaanBahanBaku;
    }

    public String getJumlahPemasok() {
        return jumlahPemasok;
    }

    public void setJumlahPemasok(String jumlahPemasok) {
        this.jumlahPemasok = jumlahPemasok;
    }

    public String getPersainganUsaha() {
        return persainganUsaha;
    }

    public void setPersainganUsaha(String persainganUsaha) {
        this.persainganUsaha = persainganUsaha;
    }

    public String getGambaranKondisi() {
        return gambaranKondisi;
    }

    public void setGambaranKondisi(String gambaranKondisi) {
        this.gambaranKondisi = gambaranKondisi;
    }

    public int getIdPengelolaanKeuangan() {
        return idPengelolaanKeuangan;
    }

    public void setIdPengelolaanKeuangan(int idPengelolaanKeuangan) {
        this.idPengelolaanKeuangan = idPengelolaanKeuangan;
    }

    public String getNamaPengelolaanKeuangan() {
        return namaPengelolaanKeuangan;
    }

    public void setNamaPengelolaanKeuangan(String namaPengelolaanKeuangan) {
        this.namaPengelolaanKeuangan = namaPengelolaanKeuangan;
    }

    public String getExum() {
        return exum;
    }

    public void setExum(String exum) {
        this.exum = exum;
    }

    public String getAlamatLokasi() {
        return alamatLokasi;
    }

    public void setAlamatLokasi(String alamatLokasi) {
        this.alamatLokasi = alamatLokasi;
    }

    public double getLokasiUsahaLongitude() {
        return lokasiUsahaLongitude;
    }

    public void setLokasiUsahaLongitude(double lokasiUsahaLongitude) {
        this.lokasiUsahaLongitude = lokasiUsahaLongitude;
    }

    public double getLokasiUsahaLatitude() {
        return lokasiUsahaLatitude;
    }

    public void setLokasiUsahaLatitude(double lokasiUsahaLatitude) {
        this.lokasiUsahaLatitude = lokasiUsahaLatitude;
    }

    public double getLokasiUsahaRealLongitude() {
        return lokasiUsahaRealLongitude;
    }

    public void setLokasiUsahaRealLongitude(double lokasiUsahaRealLongitude) {
        this.lokasiUsahaRealLongitude = lokasiUsahaRealLongitude;
    }

    public double getLokasiUsahaRealLatitude() {
        return lokasiUsahaRealLatitude;
    }

    public void setLokasiUsahaRealLatitude(double lokasiUsahaRealLatitude) {
        this.lokasiUsahaRealLatitude = lokasiUsahaRealLatitude;
    }

    public String getPengelolaanUsaha() {
        return pengelolaanUsaha;
    }

    public void setPengelolaanUsaha(String pengelolaanUsaha) {
        this.pengelolaanUsaha = pengelolaanUsaha;
    }

    public String getAspekPemasaran() {
        return aspekPemasaran;
    }

    public void setAspekPemasaran(String aspekPemasaran) {
        this.aspekPemasaran = aspekPemasaran;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idJenisUsaha);
        dest.writeString(namaJenisUsaha);
        dest.writeInt(idJenisProdukUsaha);
        dest.writeString(namaJenisProdukUsaha);
        dest.writeString(kegiatanTempat);
        dest.writeInt(jumlahTenagaKerja);
        dest.writeFloat(jarakUsahaUlamm);
        dest.writeInt(isMilikiSku);
        dest.writeString(ketersediaanBahanBaku);
        dest.writeString(jumlahPemasok);
        dest.writeString(persainganUsaha);
        dest.writeString(gambaranKondisi);
        dest.writeInt(idPengelolaanKeuangan);
        dest.writeString(namaPengelolaanKeuangan);
        dest.writeString(exum);
        dest.writeString(alamatLokasi);
        dest.writeDouble(lokasiUsahaLongitude);
        dest.writeDouble(lokasiUsahaLatitude);
        dest.writeDouble(lokasiUsahaRealLongitude);
        dest.writeDouble(lokasiUsahaRealLatitude);
        dest.writeString(pengelolaanUsaha);
        dest.writeString(aspekPemasaran);
    }
}
