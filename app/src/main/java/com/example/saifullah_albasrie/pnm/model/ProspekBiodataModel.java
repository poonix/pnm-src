package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekBiodataModel implements Parcelable {

    /*
    "biodata": [
    {
      "id_debitur": "DEBITUR-1491383432",
      "id_transaksi_debitur": "TRDE-1491383432",
      "nama_panggilan": "yudhi",
      "nama_lengkap": "yudhi prabowo subianto",
      "tempat_lahir": "Jakarta",
      "tanggal_lahir": "1986-06-02",
      "jenis_kelamin": "Laki-laki",
      "jenis_identitas": "KTP",
      "no_identitas": "5472990938190005",
      "masa_berlaku": "1900-01-01",
      "is_seumur_hidup": 1,
      "nama_ibu_kandung": "rina panduwinata",
      "status_perkawinan": null,
      "jumlah_anak": null,
      "pendidikan_terakhir": null,
      "gelar": null,
      "kewarganegaraan": null,
      "agama": null,
      "suku": null,
      "npwp": null,
      "nomor_kartuKeluarga": null,
      "email": null,
      "namaPekerjaan": null,
      "keterangan_pekerjaan": null,
      "nama_marketing": "Feby Arif Rahmani",
      "id_jenis_prospek": 1,
      "id_sdm" : "1DCB599E947F9842B0C4EC6C61C1BCFF"
      "created_date" : "2017-10-22 22:10:24"
    }
     */
    //== For Post/Submit data ==//
    @SerializedName("id_sdm")
    @Expose
    private String idSdm;

    @SerializedName("kode_cabang")
    @Expose
    private String kodeCabang;

    @SerializedName("kode_unit")
    @Expose
    private String kodeUnit;
    //=== END For Post/Submit data ==//

    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;
    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;
    @SerializedName("nama_panggilan")
    @Expose
    private String namaPanggilan;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("jenis_identitas")
    @Expose
    private String jenisIdentitas;
    @SerializedName("no_identitas")
    @Expose
    private String noIdentitas;
    @SerializedName("masa_berlaku")
    @Expose
    private String masaBerlaku;
    @SerializedName("is_seumur_hidup")
    @Expose
    private int isSeumurHidup;
    @SerializedName("nama_ibu_kandung")
    @Expose
    private String namaIbuKandung;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("modified_by")
    @Expose
    private String modifiedBy;
    @SerializedName("modified_date")
    @Expose
    private String modifiedDate;
    @SerializedName("is_active")
    @Expose
    private int isActive;

    @SerializedName("id_alamat")
    @Expose
    private int idAlamat;

    @SerializedName("id_jenis_alamat")
    @Expose
    private int idJenisAlamat;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("id_jenis_prospek")
    @Expose
    private int idJenisProspek;
    @SerializedName("jenis_prospek")
    @Expose
    private String jenisProspek;
    @SerializedName("id_jenis_usaha")
    @Expose
    private int idJenisUsaha;
    @SerializedName("nama_jenis_usaha")
    @Expose
    private String namaJenisUsaha;
    @SerializedName("nomor_telp")
    @Expose
    private String nomorTelp;

    @SerializedName("npwp")
    @Expose
    private String npwp;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("kewarganegaraan")
    @Expose
    private String kewarganegaraan;
    @SerializedName("pendidikan_terakhir")
    @Expose
    private String pendidikan_terakhir;
    @SerializedName("suku")
    @Expose
    private String suku;
    @SerializedName("keterangan_pekerjaan")
    @Expose
    private String keterangan_pekerjaan;
    @SerializedName("nomor_kartuKeluarga")
    @Expose
    private String nomor_kk;
    @SerializedName("id_marketing")
    @Expose
    private String id_marketing;
    @SerializedName("nama_marketing")
    @Expose
    private String nama_marketing;
    @SerializedName("tanggal_pembuatan")
    @Expose
    private String tgl_pembuatan;
    @SerializedName("gelar")
    @Expose
    private String gelar;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("id_pekerjaan")
    @Expose
    private int idPekerjaan;
    @SerializedName("nama_pekerjaan")
    @Expose
    private String namaPekerjaan;
    @SerializedName("status_perkawinan")
    @Expose
    private String status_kawin;
    @SerializedName("jumlah_anak")
    @Expose
    private String jumlah_anak;


    @SerializedName("id_nasabah")
    @Expose
    private String idNasabahPNM;

    public ProspekBiodataModel() {

    }


    protected ProspekBiodataModel(Parcel in) {
        idSdm = in.readString();
        kodeCabang = in.readString();
        kodeUnit = in.readString();
        idDebitur = in.readString();
        idTransaksiDebitur = in.readString();
        namaPanggilan = in.readString();
        namaLengkap = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readString();
        jenisKelamin = in.readString();
        jenisIdentitas = in.readString();
        noIdentitas = in.readString();
        masaBerlaku = in.readString();
        isSeumurHidup = in.readInt();
        namaIbuKandung = in.readString();
        createdBy = in.readString();
        createdDate = in.readString();
        modifiedBy = in.readString();
        modifiedDate = in.readString();
        isActive = in.readInt();
        idAlamat = in.readInt();
        idJenisAlamat = in.readInt();
        alamat = in.readString();
        jenisProspek = in.readString();
        idJenisUsaha = in.readInt();
        namaJenisUsaha = in.readString();
        nomorTelp = in.readString();

        npwp  = in.readString();
        email = in.readString();
        kewarganegaraan = in.readString();
        pendidikan_terakhir = in.readString();
        suku = in.readString();
        keterangan_pekerjaan = in.readString();
        nomor_kk = in.readString();
        id_marketing = in.readString();
        nama_marketing = in.readString();
        tgl_pembuatan = in.readString();
        gelar = in.readString();
        agama = in.readString();
        idPekerjaan = in.readInt();
        namaPekerjaan = in.readString();
        status_kawin = in.readString();
        jumlah_anak = in.readString();

        idNasabahPNM = in.readString();
    }

    public static final Creator<ProspekBiodataModel> CREATOR = new Creator<ProspekBiodataModel>() {
        @Override
        public ProspekBiodataModel createFromParcel(Parcel in) {
            return new ProspekBiodataModel(in);
        }

        @Override
        public ProspekBiodataModel[] newArray(int size) {
            return new ProspekBiodataModel[size];
        }
    };

    public String getIdSdm() {
        return idSdm;
    }

    public void setIdSdm(String idSdm) {
        this.idSdm = idSdm;
    }

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
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

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisIdentitas() {
        return jenisIdentitas;
    }

    public void setJenisIdentitas(String jenisIdentitas) {
        this.jenisIdentitas = jenisIdentitas;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
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

    public String getNamaIbuKandung() {
        return namaIbuKandung;
    }

    public void setNamaIbuKandung(String namaIbuKandung) {
        this.namaIbuKandung = namaIbuKandung;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIdAlamat() {
        return idAlamat;
    }

    public void setIdAlamat(int idAlamat) {
        this.idAlamat = idAlamat;
    }

    public int getIdJenisAlamat() {
        return idJenisAlamat;
    }

    public void setIdJenisAlamat(int jenisAlamat) {
        this.idJenisAlamat = jenisAlamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getIdJenisProspek() {
        return idJenisProspek;
    }

    public void setIdJenisProspek(int idJenisProspek) {
        this.idJenisProspek = idJenisProspek;
    }

    public String getJenisProspek() {
        return jenisProspek;
    }

    public void setJenisProspek(String jenisProspek) {
        this.jenisProspek = jenisProspek;
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

    public String getNomorTelp() {
        return nomorTelp;
    }

    public void setNomorTelp(String nomorTelp) {
        this.nomorTelp = nomorTelp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public String getSuku() {
        return suku;
    }

    public void setSuku(String suku) {
        this.suku = suku;
    }

    public String getKeterangan_pekerjaan() {
        return keterangan_pekerjaan;
    }

    public void setKeterangan_pekerjaan(String keterangan_pekerjaan) {
        this.keterangan_pekerjaan = keterangan_pekerjaan;
    }

    public String getNomor_kk() {
        return nomor_kk;
    }

    public void setNomor_kk(String nomor_kk) {
        this.nomor_kk = nomor_kk;
    }

    public String getId_marketing() {
        return id_marketing;
    }

    public void setId_marketing(String id_marketing) {
        this.id_marketing = id_marketing;
    }

    public String getNama_marketing() {
        return nama_marketing;
    }

    public void setNama_marketing(String nama_marketing) {
        this.nama_marketing = nama_marketing;
    }

    public String getTgl_pembuatan() {
        return tgl_pembuatan;
    }

    public void setTgl_pembuatan(String tgl_pembuatan) {
        this.tgl_pembuatan = tgl_pembuatan;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
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

    public String getStatus_kawin() {
        return status_kawin;
    }

    public void setStatus_kawin(String status_kawin) {
        this.status_kawin = status_kawin;
    }

    public String getJumlah_anak() {
        return jumlah_anak;
    }

    public void setJumlah_anak(String jumlah_anak) {
        this.jumlah_anak = jumlah_anak;
    }

    public String getIdNasabahPNM() {
        return idNasabahPNM;
    }

    public void setIdNasabahPNM(String idNasabahPNM) {
        this.idNasabahPNM = idNasabahPNM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idSdm);
        dest.writeString(kodeCabang);
        dest.writeString(kodeUnit);
        dest.writeString(idDebitur);
        dest.writeString(idTransaksiDebitur);
        dest.writeString(namaPanggilan);
        dest.writeString(namaLengkap);
        dest.writeString(tempatLahir);
        dest.writeString(tanggalLahir);
        dest.writeString(jenisKelamin);
        dest.writeString(jenisIdentitas);
        dest.writeString(noIdentitas);
        dest.writeString(masaBerlaku);
        dest.writeInt(isSeumurHidup);
        dest.writeString(namaIbuKandung);
        dest.writeString(createdBy);
        dest.writeString(createdDate);
        dest.writeString(modifiedBy);
        dest.writeString(modifiedDate);
        dest.writeInt(isActive);
        dest.writeInt(idAlamat);
        dest.writeInt(idJenisAlamat);
        dest.writeString(alamat);
        dest.writeString(jenisProspek);
        dest.writeInt(idJenisUsaha);
        dest.writeString(namaJenisUsaha);
        dest.writeString(nomorTelp);

        dest.writeString(npwp);
        dest.writeString(email);
        dest.writeString(kewarganegaraan);
        dest.writeString(pendidikan_terakhir);
        dest.writeString(suku);
        dest.writeString(keterangan_pekerjaan);
        dest.writeString(nomor_kk);
        dest.writeString(id_marketing);
        dest.writeString(nama_marketing);
        dest.writeString(tgl_pembuatan);
        dest.writeString(gelar);
        dest.writeString(agama);
        dest.writeInt(idPekerjaan);
        dest.writeString(namaPekerjaan);
        dest.writeString(status_kawin);
        dest.writeString(jumlah_anak);

        dest.writeString(idNasabahPNM);
    }
}
