package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class SurveyProfilKarakterModel implements Parcelable{

    /*
    "ProfildanKarakter": [
    {
      "id_debitur": "DEBITUR-1491721209",
      "id_transaksi_debitur": "TRDE-1491721209",
      "tanggal_lahir": "1996-06-06",
      "status_perkawinan": "Belum Kawin",
      "pendidikan_terakhir": "S1",
      "kewarganegaraan": "Indonesia",
      "nama_organisasi": null,
      "track_record": null,
      "kerjasama_pemohon": null,
      "mengenal_ulamm": null,
      "reputasi": null,
      "nama_sumber": null,
      "status_sumber": null,
      "hubungan_lain_sumber": null,
      "handphone_sumber": null,
      "penilaian_reputasi_sumber": null,
      "keterangan_sumber": null,
      "id_jenis_dokumen": null,
      "nama_jenis_dokumen": null,
      "exum": null,
      "status_debitur": "3",
      "status_modul": "detail_prospek",
      "status_name": "PROSPEK-MENUNGGU"
    }
  ],
     */

    @SerializedName("id_debitur")
    @Expose
    public String idDebitur;
    @SerializedName("id_transaksi_debitur")
    @Expose
    public String idTransaksiDebitur;
    @SerializedName("tanggal_lahir")
    @Expose
    public String tanggalLahir;
    @SerializedName("status_perkawinan")
    @Expose
    public String statusPerkawinan;
    @SerializedName("pendidikan_terakhir")
    @Expose
    public String pendidikanTerakhir;
    @SerializedName("kewarganegaraan")
    @Expose
    public String kewarganegaraan;
    @SerializedName("nama_organisasi")
    @Expose
    public String namaOrganisasi;
    @SerializedName("track_record")
    @Expose
    public String trackRecord;
    @SerializedName("kerjasama_pemohon")
    @Expose
    public String kerjasamaPemohon;
    @SerializedName("mengenal_ulamm")
    @Expose
    public String mengenalUlamm;
    @SerializedName("reputasi")
    @Expose
    public String reputasi;
    @SerializedName("nama_sumber")
    @Expose
    public String namaSumber;
    @SerializedName("status_sumber")
    @Expose
    public String statusSumber;
    @SerializedName("hubungan_lain_sumber")
    @Expose
    public String hubunganLainSumber;
    @SerializedName("handphone_sumber")
    @Expose
    public String handphoneSumber;
    @SerializedName("penilaian_reputasi_sumber")
    @Expose
    public String penilaianReputasiSumber;
    @SerializedName("keterangan_sumber")
    @Expose
    public String keteranganSumber;
    @SerializedName("id_jenis_dokumen")
    @Expose
    public String idJenisDokumen;
    @SerializedName("nama_jenis_dokumen")
    @Expose
    public String namaJenisDokumen;
    @SerializedName("exum")
    @Expose
    public String exum;
    @SerializedName("status_debitur")
    @Expose
    public String statusDebitur;
    @SerializedName("status_modul")
    @Expose
    public String statusModul;
    @SerializedName("status_name")
    @Expose
    public String statusName;

    public SurveyProfilKarakterModel() {

    }

    protected SurveyProfilKarakterModel(Parcel in) {
        idDebitur = in.readString();
        idTransaksiDebitur = in.readString();
        tanggalLahir = in.readString();
        statusPerkawinan = in.readString();
        pendidikanTerakhir = in.readString();
        kewarganegaraan = in.readString();
        namaOrganisasi = in.readString();
        trackRecord = in.readString();
        kerjasamaPemohon = in.readString();
        mengenalUlamm = in.readString();
        reputasi = in.readString();
        namaSumber = in.readString();
        statusSumber = in.readString();
        hubunganLainSumber = in.readString();
        handphoneSumber = in.readString();
        penilaianReputasiSumber = in.readString();
        keteranganSumber = in.readString();
        idJenisDokumen = in.readString();
        namaJenisDokumen = in.readString();
        exum = in.readString();
        statusDebitur = in.readString();
        statusModul = in.readString();
        statusName = in.readString();
    }

    public static final Creator<SurveyProfilKarakterModel> CREATOR = new Creator<SurveyProfilKarakterModel>() {
        @Override
        public SurveyProfilKarakterModel createFromParcel(Parcel in) {
            return new SurveyProfilKarakterModel(in);
        }

        @Override
        public SurveyProfilKarakterModel[] newArray(int size) {
            return new SurveyProfilKarakterModel[size];
        }
    };

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

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
    }

    public String getTrackRecord() {
        return trackRecord;
    }

    public void setTrackRecord(String trackRecord) {
        this.trackRecord = trackRecord;
    }

    public String getKerjasamaPemohon() {
        return kerjasamaPemohon;
    }

    public void setKerjasamaPemohon(String kerjasamaPemohon) {
        this.kerjasamaPemohon = kerjasamaPemohon;
    }

    public String getMengenalUlamm() {
        return mengenalUlamm;
    }

    public void setMengenalUlamm(String mengenalUlamm) {
        this.mengenalUlamm = mengenalUlamm;
    }

    public String getReputasi() {
        return reputasi;
    }

    public void setReputasi(String reputasi) {
        this.reputasi = reputasi;
    }

    public String getNamaSumber() {
        return namaSumber;
    }

    public void setNamaSumber(String namaSumber) {
        this.namaSumber = namaSumber;
    }

    public String getStatusSumber() {
        return statusSumber;
    }

    public void setStatusSumber(String statusSumber) {
        this.statusSumber = statusSumber;
    }

    public String getHubunganLainSumber() {
        return hubunganLainSumber;
    }

    public void setHubunganLainSumber(String hubunganLainSumber) {
        this.hubunganLainSumber = hubunganLainSumber;
    }

    public String getHandphoneSumber() {
        return handphoneSumber;
    }

    public void setHandphoneSumber(String handphoneSumber) {
        this.handphoneSumber = handphoneSumber;
    }

    public String getPenilaianReputasiSumber() {
        return penilaianReputasiSumber;
    }

    public void setPenilaianReputasiSumber(String penilaianReputasiSumber) {
        this.penilaianReputasiSumber = penilaianReputasiSumber;
    }

    public String getKeteranganSumber() {
        return keteranganSumber;
    }

    public void setKeteranganSumber(String keteranganSumber) {
        this.keteranganSumber = keteranganSumber;
    }

    public String getIdJenisDokumen() {
        return idJenisDokumen;
    }

    public void setIdJenisDokumen(String idJenisDokumen) {
        this.idJenisDokumen = idJenisDokumen;
    }

    public String getNamaJenisDokumen() {
        return namaJenisDokumen;
    }

    public void setNamaJenisDokumen(String namaJenisDokumen) {
        this.namaJenisDokumen = namaJenisDokumen;
    }

    public String getExum() {
        return exum;
    }

    public void setExum(String exum) {
        this.exum = exum;
    }

    public String getStatusDebitur() {
        return statusDebitur;
    }

    public void setStatusDebitur(String statusDebitur) {
        this.statusDebitur = statusDebitur;
    }

    public String getStatusModul() {
        return statusModul;
    }

    public void setStatusModul(String statusModul) {
        this.statusModul = statusModul;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idDebitur);
        dest.writeString(idTransaksiDebitur);
        dest.writeString(tanggalLahir);
        dest.writeString(statusPerkawinan);
        dest.writeString(pendidikanTerakhir);
        dest.writeString(kewarganegaraan);
        dest.writeString(namaOrganisasi);
        dest.writeString(trackRecord);
        dest.writeString(kerjasamaPemohon);
        dest.writeString(mengenalUlamm);
        dest.writeString(reputasi);
        dest.writeString(namaSumber);
        dest.writeString(statusSumber);
        dest.writeString(hubunganLainSumber);
        dest.writeString(handphoneSumber);
        dest.writeString(penilaianReputasiSumber);
        dest.writeString(keteranganSumber);
        dest.writeString(idJenisDokumen);
        dest.writeString(namaJenisDokumen);
        dest.writeString(exum);
        dest.writeString(statusDebitur);
        dest.writeString(statusModul);
        dest.writeString(statusName);
    }

    @Override
    public String toString() {
        return "SurveyProfilKarakterModel{" +
                "idDebitur='" + idDebitur + '\'' +
                ", idTransaksiDebitur='" + idTransaksiDebitur + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", statusPerkawinan='" + statusPerkawinan + '\'' +
                ", pendidikanTerakhir='" + pendidikanTerakhir + '\'' +
                ", kewarganegaraan='" + kewarganegaraan + '\'' +
                ", namaOrganisasi='" + namaOrganisasi + '\'' +
                ", trackRecord='" + trackRecord + '\'' +
                ", kerjasamaPemohon='" + kerjasamaPemohon + '\'' +
                ", mengenalUlamm='" + mengenalUlamm + '\'' +
                ", reputasi='" + reputasi + '\'' +
                ", namaSumber='" + namaSumber + '\'' +
                ", statusSumber='" + statusSumber + '\'' +
                ", hubunganLainSumber='" + hubunganLainSumber + '\'' +
                ", handphoneSumber='" + handphoneSumber + '\'' +
                ", penilaianReputasiSumber='" + penilaianReputasiSumber + '\'' +
                ", keteranganSumber='" + keteranganSumber + '\'' +
                ", idJenisDokumen='" + idJenisDokumen + '\'' +
                ", namaJenisDokumen='" + namaJenisDokumen + '\'' +
                ", exum='" + exum + '\'' +
                ", statusDebitur='" + statusDebitur + '\'' +
                ", statusModul='" + statusModul + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
