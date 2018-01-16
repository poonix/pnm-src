package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullah_albasrie on 4/18/17.
 */

public class FeedbackItemModel implements Parcelable{

    /*
    "id_debitur": "DEBITUR-1490265675",
      "nama_panggilan": "Reza",
      "jenis_identitas": "KTP",
      "no_identitas": "527520010390005",
      "created_by": "1DCB599E947F9842B0C4EC6C61C1BCFF",
      "created_date": "2017-03-21 00:00:00.000",
      "modified_by": null,
      "modified_date": null,
      "is_active": 1,
      "visit": 3,
      "status_debitur": "1",
      "progress": "20        "
     */


    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;

    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;

    @SerializedName("nama_panggilan")
    @Expose
    private String namaPanggilan;

    @SerializedName("jenis_identitas")
    @Expose
    private String jenisIdentitas;

    @SerializedName("no_identitas")
    @Expose
    private String noIdentitas;

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

    @SerializedName("visit")
    @Expose
    private int visit;

    @SerializedName("status_debitur")
    @Expose
    private int statusDebitur;

    @SerializedName("status_modul")
    @Expose
    private String statusModul;

    @SerializedName("status_name")
    @Expose
    private String statusName;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    @SerializedName("is_read")
    @Expose
    private boolean isRead = false;

    public FeedbackItemModel() {

    }

    protected FeedbackItemModel(Parcel in) {
        idDebitur = in.readString();
        idTransaksiDebitur = in.readString();
        namaPanggilan = in.readString();
        jenisIdentitas = in.readString();
        noIdentitas = in.readString();
        createdBy = in.readString();
        createdDate = in.readString();
        modifiedBy = in.readString();
        modifiedDate = in.readString();
        isActive = in.readInt();
        visit = in.readInt();
        statusDebitur = in.readInt();
        statusModul = in.readString();
        statusName = in.readString();
        keterangan = in.readString();
        isRead = in.readByte() != 0;
    }

    public static final Creator<FeedbackItemModel> CREATOR = new Creator<FeedbackItemModel>() {
        @Override
        public FeedbackItemModel createFromParcel(Parcel in) {
            return new FeedbackItemModel(in);
        }

        @Override
        public FeedbackItemModel[] newArray(int size) {
            return new FeedbackItemModel[size];
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

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
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

    public Object getModifiedBy() {
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

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public int getStatusDebitur() {
        return statusDebitur;
    }

    public void setStatusDebitur(int statusDebitur) {
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idDebitur);
        dest.writeString(idTransaksiDebitur);
        dest.writeString(namaPanggilan);
        dest.writeString(jenisIdentitas);
        dest.writeString(noIdentitas);
        dest.writeString(createdBy);
        dest.writeString(createdDate);
        dest.writeString(modifiedBy);
        dest.writeString(modifiedDate);
        dest.writeInt(isActive);
        dest.writeInt(visit);
        dest.writeInt(statusDebitur);
        dest.writeString(statusModul);
        dest.writeString(statusName);
        dest.writeString(keterangan);
        dest.writeByte((byte) (isRead ? 1 : 0));
    }
}
