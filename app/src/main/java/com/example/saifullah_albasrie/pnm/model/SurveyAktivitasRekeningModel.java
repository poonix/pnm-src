package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public class SurveyAktivitasRekeningModel implements Parcelable {

            /*"bulan": "12",
                    "frekuensi_debit": "debit",
                    "frekuensi_kredit": 2,
                    "jumlah_debit": "1009010400476244.12",
                    "jumlah_kredit": null*/

    @SerializedName("nama_bank")
    @Expose
    String nama_bank;
    @SerializedName("bulan")
    @Expose
    public String bulan;
    @SerializedName("frekuensi_debit")
    @Expose
    public String frekuensiDebit;
    @SerializedName("frekuensi_kredit")
    @Expose
    public String frekuensiKredit;
    @SerializedName("jumlah_debit")
    @Expose
    public String jumlahDebit;
    @SerializedName("jumlah_kredit")
    @Expose
    public String jumlahKredit;

    public SurveyAktivitasRekeningModel() {

    }

    protected SurveyAktivitasRekeningModel(Parcel in) {
        nama_bank = in.readString();
        bulan = in.readString();
        frekuensiDebit = in.readString();
        frekuensiKredit = in.readString();
        jumlahDebit = in.readString();
        jumlahKredit = in.readString();
    }

    public static final Creator<SurveyAktivitasRekeningModel> CREATOR = new Creator<SurveyAktivitasRekeningModel>() {
        @Override
        public SurveyAktivitasRekeningModel createFromParcel(Parcel in) {
            return new SurveyAktivitasRekeningModel(in);
        }

        @Override
        public SurveyAktivitasRekeningModel[] newArray(int size) {
            return new SurveyAktivitasRekeningModel[size];
        }
    };

    @Override
    public String toString() {
        return "SurveyAktivitasRekeningModel{" +
                "nama_bank='" + nama_bank + '\''+
                ", bulan='" + bulan + '\'' +
                ", frekuensiDebit='" + frekuensiDebit + '\'' +
                ", frekuensiKredit='" + frekuensiKredit + '\'' +
                ", jumlahDebit='" + jumlahDebit + '\'' +
                ", jumlahKredit='" + jumlahKredit + '\'' +
                '}';
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getFrekuensiDebit() {
        return frekuensiDebit;
    }

    public void setFrekuensiDebit(String frekuensiDebit) {
        this.frekuensiDebit = frekuensiDebit;
    }

    public String getFrekuensiKredit() {
        return frekuensiKredit;
    }

    public void setFrekuensiKredit(String frekuensiKredit) {
        this.frekuensiKredit = frekuensiKredit;
    }

    public String getJumlahDebit() {
        return jumlahDebit;
    }

    public void setJumlahDebit(String jumlahDebit) {
        this.jumlahDebit = jumlahDebit;
    }

    public String getJumlahKredit() {
        return jumlahKredit;
    }

    public void setJumlahKredit(String jumlahKredit) {
        this.jumlahKredit = jumlahKredit;
    }

    public String getNama_bank() {
        return nama_bank;
    }

    public void setNama_bank(String nama_bank) {
        this.nama_bank = nama_bank;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama_bank);
        dest.writeString(bulan);
        dest.writeString(frekuensiDebit);
        dest.writeString(frekuensiKredit);
        dest.writeString(jumlahDebit);
        dest.writeString(jumlahKredit);
    }
}
