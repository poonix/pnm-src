package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public class SurveyKapasitasUsahaModel implements Parcelable {

            /*"id_pekerjaan": 1,
            "id_harta_benda": 2,
            "lama_bekerja": 12,
            "jenis_rekening": "tabungan",
            "tahun_rekening": "2014",
            "exum": "asdasdwqeqwadsd asd asd asd asd ",
            "jenis_harta_benda": "emas",
            "nama_pekerjaan": "akunting"*/

    @SerializedName("id_pekerjaan")
    @Expose
    public int idPekerjaan;
    @SerializedName("id_harta_benda")
    @Expose
    public String idHartaBenda;
    @SerializedName("lama_bekerja")
    @Expose
    public int lamaBekerja;
    @SerializedName("jenis_rekening")
    @Expose
    public String jenisTabungan;
    @SerializedName("tahun_rekening")
    @Expose
    public String tahunRekening;
    @SerializedName("exum")
    @Expose
    public String exum;
    @SerializedName("jenis_harta_benda")
    @Expose
    public String jenisHartaBenda;
    @SerializedName("nama_pekerjaan")
    @Expose
    public String namaPekerjaan;

    public SurveyKapasitasUsahaModel() {

    }

    protected SurveyKapasitasUsahaModel(Parcel in) {
        idPekerjaan = in.readInt();
        idHartaBenda = in.readString();
        lamaBekerja = in.readInt();
        jenisTabungan = in.readString();
        tahunRekening = in.readString();
        exum = in.readString();
        jenisHartaBenda = in.readString();
        namaPekerjaan = in.readString();
    }

    public static final Creator<SurveyKapasitasUsahaModel> CREATOR = new Creator<SurveyKapasitasUsahaModel>() {
        @Override
        public SurveyKapasitasUsahaModel createFromParcel(Parcel in) {
            return new SurveyKapasitasUsahaModel(in);
        }

        @Override
        public SurveyKapasitasUsahaModel[] newArray(int size) {
            return new SurveyKapasitasUsahaModel[size];
        }
    };

    public int getIdPekerjaan() {
        return idPekerjaan;
    }

    public void setIdPekerjaan(int idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public String getIdHartaBenda() {
        return idHartaBenda;
    }

    public void setIdHartaBenda(String idHartaBenda) {
        this.idHartaBenda = idHartaBenda;
    }

    public int getLamaBekerja() {
        return lamaBekerja;
    }

    public void setLamaBekerja(int lamaBekerja) {
        this.lamaBekerja = lamaBekerja;
    }

    public String getJenisTabungan() {
        return jenisTabungan;
    }

    public void setJenisTabungan(String jenisTabungan) {
        this.jenisTabungan = jenisTabungan;
    }

    public String getTahunRekening() {
        return tahunRekening;
    }

    public void setTahunRekening(String tahunRekening) {
        this.tahunRekening = tahunRekening;
    }

    public String getExum() {
        return exum;
    }

    public void setExum(String exum) {
        this.exum = exum;
    }

    public String getJenisHartaBenda() {
        return jenisHartaBenda;
    }

    public void setJenisHartaBenda(String jenisHartaBenda) {
        this.jenisHartaBenda = jenisHartaBenda;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPekerjaan);
        dest.writeString(idHartaBenda);
        dest.writeInt(lamaBekerja);
        dest.writeString(jenisTabungan);
        dest.writeString(tahunRekening);
        dest.writeString(exum);
        dest.writeString(jenisHartaBenda);
        dest.writeString(namaPekerjaan);
    }

    @Override
    public String toString() {
        return "SurveyKapasitasUsahaModel{" +
                "idPekerjaan=" + idPekerjaan +
                ", idHartaBenda=" + idHartaBenda +
                ", jenisTabungan='" + jenisTabungan + '\'' +
                ", lamaBekera='" + lamaBekerja + '\'' +
                ", tahunRekening='" + tahunRekening + '\'' +
                ", exum='" + exum + '\'' +
                ", jenisHartaBenda='" + jenisHartaBenda + '\'' +
                ", namaPekerjaan='" + namaPekerjaan + '\'' +
                '}';
    }
}
