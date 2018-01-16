package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekAlamatModel implements Parcelable{

    /*

    "alamat": [
    {
      "id": 48,
      "jenis_alamat": "1",
      "alamat": "jalan melawai v",
      "RT": null,
      "RW": null,
      "provinsi": null,
      "nama_provinsi": null,
      "kabKota": null,
      "nama_kabupatenKota": null,
      "kecamatan": null,
      "nama_kecamatan": null,
      "kelurahan": null,
      "nama_kelurahan": null,
      "kodepos": null,
      "lama_menempati_tahun": null,
      "lama_menempati_bulan": null

      "lokasi_longitude":null,
"lokasi_latitude":null,
"lokasi_real_longitude":null,
"lokasi_real_latitude":null,
    }
     */
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("alamat_prioritas")
    @Expose
    private int prioritas;
    @SerializedName("id_jenis_alamat")
    @Expose
    private int jenisAlamat;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("RT")
    @Expose
    private String rt;
    @SerializedName("RW")
    @Expose
    private String rw;
    @SerializedName("id_provinsi")
    @Expose
    private int idProvinsi;
    @SerializedName("nama_provinsi")
    @Expose
    private String namaProvinsi;
    @SerializedName("id_kabupaten_kota")
    @Expose
    private int idKabupatenKota;
    @SerializedName("nama_kabupatenKota")
    @Expose
    private String namaKabupatenKota;
    @SerializedName("id_kecamatan")
    @Expose
    private int idKecamatan;
    @SerializedName("nama_kecamatan")
    @Expose
    private String namaKecamatan;
    @SerializedName("id_kelurahan")
    @Expose
    private int idKelurahan;
    @SerializedName("nama_kelurahan")
    @Expose
    private String namaKelurahan;
    @SerializedName("kodepos")
    @Expose
    private String kodepos;
    @SerializedName("lama_menempati_tahun")
    @Expose
    private int lamaMenempatiTahun;
    @SerializedName("lama_menempati_bulan")
    @Expose
    private int lamaMenempatiBulan;

    @SerializedName("lokasi_longitude")
    @Expose
    private double lokasiLongitude;
    @SerializedName("lokasi_latitude")
    @Expose
    private double lokasiLatitude;
    @SerializedName("lokasi_real_longitude")
    @Expose
    private double lokasiRealLongitude;
    @SerializedName("lokasi_real_latitude")
    @Expose
    private double lokasiRealLatitude;

    public ProspekAlamatModel() {

    }

    protected ProspekAlamatModel(Parcel in) {
        id = in.readInt();
        prioritas = in.readInt();
        jenisAlamat = in.readInt();
        alamat = in.readString();
        rt = in.readString();
        rw = in.readString();
        idProvinsi = in.readInt();
        namaProvinsi = in.readString();
        idKabupatenKota = in.readInt();
        namaKabupatenKota = in.readString();
        idKecamatan = in.readInt();
        namaKecamatan = in.readString();
        idKelurahan = in.readInt();
        namaKelurahan = in.readString();
        kodepos = in.readString();
        lamaMenempatiTahun = in.readInt();
        lamaMenempatiBulan = in.readInt();

        lokasiLongitude = in.readDouble();
        lokasiLatitude = in.readDouble();
        lokasiRealLongitude = in.readDouble();
        lokasiRealLatitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(prioritas);
        dest.writeInt(jenisAlamat);
        dest.writeString(alamat);
        dest.writeString(rt);
        dest.writeString(rw);
        dest.writeInt(idProvinsi);
        dest.writeString(namaProvinsi);
        dest.writeInt(idKabupatenKota);
        dest.writeString(namaKabupatenKota);
        dest.writeInt(idKecamatan);
        dest.writeString(namaKecamatan);
        dest.writeInt(idKelurahan);
        dest.writeString(namaKelurahan);
        dest.writeString(kodepos);
        dest.writeInt(lamaMenempatiTahun);
        dest.writeInt(lamaMenempatiBulan);

        dest.writeDouble(lokasiLongitude);
        dest.writeDouble(lokasiLatitude);
        dest.writeDouble(lokasiRealLongitude);
        dest.writeDouble(lokasiRealLatitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProspekAlamatModel> CREATOR = new Creator<ProspekAlamatModel>() {
        @Override
        public ProspekAlamatModel createFromParcel(Parcel in) {
            return new ProspekAlamatModel(in);
        }

        @Override
        public ProspekAlamatModel[] newArray(int size) {
            return new ProspekAlamatModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(int prioritas) {
        this.prioritas = prioritas;
    }

    public int getJenisAlamat() {
        return jenisAlamat;
    }

    public void setJenisAlamat(int jenisAlamat) {
        this.jenisAlamat = jenisAlamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public int getIdKabupatenKota() {
        return idKabupatenKota;
    }

    public void setIdKabupatenKota(int idKabupatenKota) {
        this.idKabupatenKota = idKabupatenKota;
    }

    public String getNamaKabupatenKota() {
        return namaKabupatenKota;
    }

    public void setNamaKabupatenKota(String namaKabupatenKota) {
        this.namaKabupatenKota = namaKabupatenKota;
    }

    public int getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(int idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public int getLamaMenempatiTahun() {
        return lamaMenempatiTahun;
    }

    public void setLamaMenempatiTahun(int lamaMenempatiTahun) {
        this.lamaMenempatiTahun = lamaMenempatiTahun;
    }

    public int getLamaMenempatiBulan() {
        return lamaMenempatiBulan;
    }

    public void setLamaMenempatiBulan(int lamaMenempatiBulan) {
        this.lamaMenempatiBulan = lamaMenempatiBulan;
    }

    public double getLokasiLongitude() {
        return lokasiLongitude;
    }

    public void setLokasiLongitude(double lokasiLongitude) {
        this.lokasiLongitude = lokasiLongitude;
    }

    public double getLokasiLatitude() {
        return lokasiLatitude;
    }

    public void setLokasiLatitude(double lokasiLatitude) {
        this.lokasiLatitude = lokasiLatitude;
    }

    public double getLokasiRealLongitude() {
        return lokasiRealLongitude;
    }

    public void setLokasiRealLongitude(double lokasiRealLongitude) {
        this.lokasiRealLongitude = lokasiRealLongitude;
    }

    public double getLokasiRealLatitude() {
        return lokasiRealLatitude;
    }

    public void setLokasiRealLatitude(double lokasiRealLatitude) {
        this.lokasiRealLatitude = lokasiRealLatitude;
    }
}
