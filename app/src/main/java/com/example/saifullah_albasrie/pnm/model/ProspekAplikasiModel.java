package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekAplikasiModel implements Parcelable{

    /*
    "aplikasi": [
    {
      "id_produk": null,
      "nama_produk": null,
      "rencana_plafond": null,
      "jangka_waktu": null,
      "angsuran_perbulan": null,
      "tujuan_pembiayaan": null,
      "id_jenis_usaha": 1,
      "nama_jenis_usaha": "perdagangan",
      "lama_usaha_bulan": null,
      "lama_usaha_tahun": null,
      "omset_per_hari": null,
      "nama_usaha": null,
      "jumlah_karyawan": null
    }
     */
    @SerializedName("id_produk")
    @Expose
    private int idProduk;
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
    @SerializedName("id_jenis_usaha")
    @Expose
    private int idJenisUsaha;
    @SerializedName("nama_jenis_usaha")
    @Expose
    private String namaJenisUsaha;
    @SerializedName("lama_usaha_bulan")
    @Expose
    private String lamaUsahaBulan;
    @SerializedName("lama_usaha_tahun")
    @Expose
    private String lamaUsahaTahun;
    @SerializedName("omset_per_hari")
    @Expose
    private String omsetPerHari;
    @SerializedName("alamat_usaha")
    @Expose
    private String alamatUsaha;
    @SerializedName("nama_usaha")
    @Expose
    private String namaUsaha;
    @SerializedName("jumlah_karyawan")
    @Expose
    private String jumlahKaryawan;
    @SerializedName("notelp")
    @Expose
    private String nomorTelp;

    public ProspekAplikasiModel() {
    }

    protected ProspekAplikasiModel(Parcel in) {
        idProduk = in.readInt();
        namaProduk = in.readString();
        rencanaPlafond = in.readString();
        jangkaWaktu = in.readInt();
        angsuranPerbulan = in.readString();
        tujuanPembiayaan = in.readString();
        idJenisUsaha = in.readInt();
        namaJenisUsaha = in.readString();
        lamaUsahaBulan = in.readString();
        lamaUsahaTahun = in.readString();
        omsetPerHari = in.readString();
        alamatUsaha = in.readString();
        namaUsaha = in.readString();
        jumlahKaryawan = in.readString();
        nomorTelp = in.readString();
    }

    public static final Creator<ProspekAplikasiModel> CREATOR = new Creator<ProspekAplikasiModel>() {
        @Override
        public ProspekAplikasiModel createFromParcel(Parcel in) {
            return new ProspekAplikasiModel(in);
        }

        @Override
        public ProspekAplikasiModel[] newArray(int size) {
            return new ProspekAplikasiModel[size];
        }
    };

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
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

    public String getLamaUsahaBulan() {
        return lamaUsahaBulan;
    }

    public void setLamaUsahaBulan(String lamaUsahaBulan) {
        this.lamaUsahaBulan = lamaUsahaBulan;
    }

    public String getLamaUsahaTahun() {
        return lamaUsahaTahun;
    }

    public void setLamaUsahaTahun(String lamaUsahaTahun) {
        this.lamaUsahaTahun = lamaUsahaTahun;
    }

    public String getOmsetPerHari() {
        return omsetPerHari;
    }

    public void setOmsetPerHari(String omsetPerHari) {
        this.omsetPerHari = omsetPerHari;
    }

    public String getAlamatUsaha() {
        return alamatUsaha;
    }

    public void setAlamatUsaha(String alamatUsaha) {
        this.alamatUsaha = alamatUsaha;
    }

    public String getNamaUsaha() {
        return namaUsaha;
    }

    public void setNamaUsaha(String namaUsaha) {
        this.namaUsaha = namaUsaha;
    }

    public String getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public void setJumlahKaryawan(String jumlahKaryawan) {
        this.jumlahKaryawan = jumlahKaryawan;
    }

    public String getNomorTelp() {
        return nomorTelp;
    }

    public void setNomorTelp(String nomorTelp) {
        this.nomorTelp = nomorTelp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idProduk);
        dest.writeString(namaProduk);
        dest.writeString(rencanaPlafond);
        dest.writeInt(jangkaWaktu);
        dest.writeString(angsuranPerbulan);
        dest.writeString(tujuanPembiayaan);
        dest.writeInt(idJenisUsaha);
        dest.writeString(namaJenisUsaha);
        dest.writeString(lamaUsahaBulan);
        dest.writeString(lamaUsahaTahun);
        dest.writeString(omsetPerHari);
        dest.writeString(alamatUsaha);
        dest.writeString(namaUsaha);
        dest.writeString(jumlahKaryawan);
        dest.writeString(nomorTelp);
    }
}
