package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekKeluargaModel implements Parcelable{

    /*
    "keluarga": [
    {
      "id_survey_keluarga": null,
      "status_hubungan": null,
      "nama_lengkap": null,
      "jenis_kelamin": null,
      "tempat_lahir": null,
      "tanggal_lahir": null,
      "jenis_identitas": null,
      "nomor_identitas": null,
      "masa_berlaku": null,
      "is_seumur_hidup": null,
      "id_pekerjaan": null,
      "keterangan_pekerjaan": null,
      "telepon": null,
      "handphone": null
      "keluarga_meminjam_ke_pnm":null
    }
     */
    @SerializedName("id_survey_keluarga")
    @Expose
    private int idKeluarga;

    @SerializedName("status_hubungan")
    @Expose
    private String statusHubungan;

    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;

    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;

    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;

    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;

    @SerializedName("jenis_identitas")
    @Expose
    private String jenisIdentitas;

    @SerializedName("nomor_identitas")
    @Expose
    private String nomorIdentitas;

    @SerializedName("masa_berlaku")
    @Expose
    private String masaBerlaku;

    @SerializedName("is_seumur_hidup")
    @Expose
    private int isSeumurHidup;

    @SerializedName("id_pekerjaan")
    @Expose
    private int idPekerjaan;

    @SerializedName("nama_pekerjaan")
    @Expose
    private String namaPekerjaan;

    @SerializedName("keterangan_pekerjaan")
    @Expose
    private String keteranganPekerjaan;

    @SerializedName("telepon")
    @Expose
    private String telepon;

    @SerializedName("handphone")
    @Expose
    private String handphone;

    @SerializedName("keluarga_meminjam_ke_pnm")
    @Expose
    private String keluargaMeminjamKePnm;

    public ProspekKeluargaModel() {

    }

    protected ProspekKeluargaModel(Parcel in) {
        idKeluarga = in.readInt();
        statusHubungan = in.readString();
        namaLengkap = in.readString();
        jenisKelamin = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readString();
        jenisIdentitas = in.readString();
        nomorIdentitas = in.readString();
        masaBerlaku = in.readString();
        isSeumurHidup = in.readInt();
        idPekerjaan = in.readInt();
        namaPekerjaan = in.readString();
        keteranganPekerjaan = in.readString();
        telepon = in.readString();
        handphone = in.readString();
        keluargaMeminjamKePnm = in.readString();
    }

    public static final Creator<ProspekKeluargaModel> CREATOR = new Creator<ProspekKeluargaModel>() {
        @Override
        public ProspekKeluargaModel createFromParcel(Parcel in) {
            return new ProspekKeluargaModel(in);
        }

        @Override
        public ProspekKeluargaModel[] newArray(int size) {
            return new ProspekKeluargaModel[size];
        }
    };

    public int getIdKeluarga() {
        return idKeluarga;
    }

    public void setIdKeluarga(int idKeluarga) {
        this.idKeluarga = idKeluarga;
    }

    public String getStatusHubungan() {
        return statusHubungan;
    }

    public void setStatusHubungan(String statusHubungan) {
        this.statusHubungan = statusHubungan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisIdentitas() {
        return jenisIdentitas;
    }

    public void setJenisIdentitas(String jenisIdentitas) {
        this.jenisIdentitas = jenisIdentitas;
    }

    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void setNomorIdentitas(String nomorIdentitas) {
        this.nomorIdentitas = nomorIdentitas;
    }

    public String getMasaBerlaku() {
        return masaBerlaku;
    }

    public void setMasaBerlaku(String masaBerlaku) {
        this.masaBerlaku = masaBerlaku;
    }

    public int getIsSeumurHidup() {
        return isSeumurHidup;
    }

    public void setIsSeumurHidup(int isSeumurHidup) {
        this.isSeumurHidup = isSeumurHidup;
    }

    public int getIdPekerjaan() {
        return idPekerjaan;
    }

    public void setIdPekerjaan(int idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public String getKeteranganPekerjaan() {
        return keteranganPekerjaan;
    }

    public void setKeteranganPekerjaan(String keteranganPekerjaan) {
        this.keteranganPekerjaan = keteranganPekerjaan;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public String getKeluargaMeminjamKePnm() {
        return keluargaMeminjamKePnm;
    }

    public void setKeluargaMeminjamKePnm(String keluargaMeminjamKePnm) {
        this.keluargaMeminjamKePnm = keluargaMeminjamKePnm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idKeluarga);
        dest.writeString(statusHubungan);
        dest.writeString(namaLengkap);
        dest.writeString(jenisKelamin);
        dest.writeString(tempatLahir);
        dest.writeString(tanggalLahir);
        dest.writeString(jenisIdentitas);
        dest.writeString(nomorIdentitas);
        dest.writeString(masaBerlaku);
        dest.writeInt(isSeumurHidup);
        dest.writeInt(idPekerjaan);
        dest.writeString(namaPekerjaan);
        dest.writeString(keteranganPekerjaan);
        dest.writeString(telepon);
        dest.writeString(handphone);
        dest.writeString(keluargaMeminjamKePnm);
    }
}
