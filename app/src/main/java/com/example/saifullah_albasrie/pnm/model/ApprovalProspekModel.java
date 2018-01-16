package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/8/17.
 */

public class ApprovalProspekModel implements Parcelable{

    /*
    "approval_prospek" :[
  {
    "id_debitur" : "DEBITUR-1491383432",
    "id_transaksi_debitur"  : "TRDE-1491383432",
    "id_ao"	: "1DCB599E947F9842B0C4EC6C61C1BCFF",
    "id_sdm" : "253258929D51420C2458E3F584E96BA4",
    "kode_cabang" : "TGR",
    "kode_unit" : "CKPA",
    "status_debitur": "6",
    "progress": "40"
  }
     */

    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;
    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;
    @SerializedName("id_ao")
    @Expose
    private String idAo;
    @SerializedName("id_sdm")
    @Expose
    private String idSdm;
    @SerializedName("kode_cabang")
    @Expose
    private String kodeCabang;
    @SerializedName("kode_unit")
    @Expose
    private String kodeUnit;
    @SerializedName("status_debitur")
    @Expose
    private String statusDebitur;
    @SerializedName("progress")
    @Expose
    private int progress;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    public ApprovalProspekModel() { }

    protected ApprovalProspekModel(Parcel in) {
        idDebitur = in.readString();
        idTransaksiDebitur = in.readString();
        idAo = in.readString();
        idSdm = in.readString();
        kodeCabang = in.readString();
        kodeUnit = in.readString();
        statusDebitur = in.readString();
        progress = in.readInt();
        keterangan = in.readString();
    }

    public static final Creator<ApprovalProspekModel> CREATOR = new Creator<ApprovalProspekModel>() {
        @Override
        public ApprovalProspekModel createFromParcel(Parcel in) {
            return new ApprovalProspekModel(in);
        }

        @Override
        public ApprovalProspekModel[] newArray(int size) {
            return new ApprovalProspekModel[size];
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

    public String getIdAo() {
        return idAo;
    }

    public void setIdAo(String idAo) {
        this.idAo = idAo;
    }

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

    public String getStatusDebitur() {
        return statusDebitur;
    }

    public void setStatusDebitur(String statusDebitur) {
        this.statusDebitur = statusDebitur;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idDebitur);
        dest.writeString(idTransaksiDebitur);
        dest.writeString(idAo);
        dest.writeString(idSdm);
        dest.writeString(kodeCabang);
        dest.writeString(kodeUnit);
        dest.writeString(statusDebitur);
        dest.writeInt(progress);
        dest.writeString(keterangan);
    }
}
