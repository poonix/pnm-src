package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 5/14/17.
 */

public class CollectionModel implements Parcelable{
    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;
    @SerializedName("id_sdm")
    @Expose
    private String idSdm;
    @SerializedName("kode_cabang")
    @Expose
    private String kodeCabang;
    @SerializedName("kode_unit")
    @Expose
    private String kodeUnit;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("tanggal_penagihan")
    @Expose
    private String tanggalPenagihan;
    @SerializedName("tindak_lanjut")
    @Expose
    private String tindakLanjut;
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

    public CollectionModel() {}

    protected CollectionModel(Parcel in) {
        idDebitur = in.readString();
        idSdm = in.readString();
        kodeCabang = in.readString();
        kodeUnit = in.readString();
        keterangan = in.readString();
        tanggalPenagihan = in.readString();
        tindakLanjut = in.readString();
        createdBy = in.readString();
        createdDate = in.readString();
        modifiedBy = in.readString();
        modifiedDate = in.readString();
        isActive = in.readInt();
    }

    public static final Creator<CollectionModel> CREATOR = new Creator<CollectionModel>() {
        @Override
        public CollectionModel createFromParcel(Parcel in) {
            return new CollectionModel(in);
        }

        @Override
        public CollectionModel[] newArray(int size) {
            return new CollectionModel[size];
        }
    };

    public String getIdDebitur() {
        return idDebitur;
    }

    public void setIdDebitur(String idDebitur) {
        this.idDebitur = idDebitur;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggalPenagihan() {
        return tanggalPenagihan;
    }

    public void setTanggalPenagihan(String tanggalPenagihan) {
        this.tanggalPenagihan = tanggalPenagihan;
    }

    public String getTindakLanjut() {
        return tindakLanjut;
    }

    public void setTindakLanjut(String tindakLanjut) {
        this.tindakLanjut = tindakLanjut;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idDebitur);
        dest.writeString(idSdm);
        dest.writeString(kodeCabang);
        dest.writeString(kodeUnit);
        dest.writeString(keterangan);
        dest.writeString(tanggalPenagihan);
        dest.writeString(tindakLanjut);
        dest.writeString(createdBy);
        dest.writeString(createdDate);
        dest.writeString(modifiedBy);
        dest.writeString(modifiedDate);
        dest.writeInt(isActive);
    }
}
