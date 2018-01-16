package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 3/23/17.
 */

public class UserModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("idsdm")
    @Expose
    private String idsdm;
    @SerializedName("id_userGroup")
    @Expose
    private int idUserGroup;
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("posisi")
    @Expose
    private String posisi;
    @SerializedName("cabang")
    @Expose
    private String cabang;
    @SerializedName("kode_cabang")
    @Expose
    private String kodeCabang;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("kode_unit")
    @Expose
    private String kodeUnit;
    @SerializedName("fcm")
    @Expose
    private String fcmId;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
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
    @SerializedName("organisasi_name")
    @Expose
    private String organisasiName;
    @SerializedName("organisasi_desc")
    @Expose
    private String organisasiDesc;

    public UserModel() {

    }


    protected UserModel(Parcel in) {
        id = in.readInt();
        idsdm = in.readString();
        idUserGroup = in.readInt();
        nik = in.readString();
        username = in.readString();
        fullname = in.readString();
        email = in.readString();
        posisi = in.readString();
        cabang = in.readString();
        kodeCabang = in.readString();
        unit = in.readString();
        kodeUnit = in.readString();
        fcmId = in.readString();
        lastLogin = in.readString();
        createdBy = in.readString();
        createdDate = in.readString();
        modifiedBy = in.readString();
        modifiedDate = in.readString();
        isActive = in.readInt();
        organisasiName = in.readString();
        organisasiDesc = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdsdm() {
        return idsdm;
    }

    public void setIdsdm(String idsdm) {
        this.idsdm = idsdm;
    }

    public Integer getIdUserGroup() {
        return idUserGroup;
    }

    public void setIdUserGroup(int idUserGroup) {
        this.idUserGroup = idUserGroup;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
    }

    public String getOrganisasiName() {
        return organisasiName;
    }

    public void setOrganisasiName(String organisasiName) {
        this.organisasiName = organisasiName;
    }

    public String getOrganisasiDesc() {
        return organisasiDesc;
    }

    public void setOrganisasiDesc(String organisasiDesc) {
        this.organisasiDesc = organisasiDesc;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public String getFcmId() {
        return fcmId;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(idsdm);
        dest.writeInt(idUserGroup);
        dest.writeString(nik);
        dest.writeString(username);
        dest.writeString(fullname);
        dest.writeString(email);
        dest.writeString(posisi);
        dest.writeString(cabang);
        dest.writeString(kodeCabang);
        dest.writeString(unit);
        dest.writeString(kodeUnit);
        dest.writeString(fcmId);
        dest.writeString(lastLogin);
        dest.writeString(createdBy);
        dest.writeString(createdDate);
        dest.writeString(modifiedBy);
        dest.writeString(modifiedDate);
        dest.writeInt(isActive);
        dest.writeString(organisasiName);
        dest.writeString(organisasiDesc);
    }
}