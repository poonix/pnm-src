package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekLainnyaModel implements Parcelable{

    /*
  "lainnya": [
    {
      "id_kode_usaha": null,
      "id_bidang_usaha": null,
      "id_hubungan_dengan_pnm": null,
      "id_hubungan_dengan_bank": null,
      "deskripsi_kode_usaha": null,
      "deskripsi_bidang_usaha": null,
      "deskripsi_hubungan_dengan_pnm": null,
      "deskripsi_hubungan_dengan_bank": null
    }
     */

    @SerializedName("id_kode_usaha")
    @Expose
    private int idKodeUsaha;
    @SerializedName("id_bidang_usaha")
    @Expose
    private int IdKodeBidangUsaha;
    @SerializedName("id_hubungan_dengan_pnm")
    @Expose
    private int idHubunganDenganPNM;
    @SerializedName("id_hubungan_dengan_bank")
    @Expose
    private int idHubunganDenganBANK;

    @SerializedName("deskripsi_kode_usaha")
    @Expose
    private String kodeUsaha;
    @SerializedName("deskripsi_bidang_usaha")
    @Expose
    private String kodeBidangUsaha;
    @SerializedName("deskripsi_hubungan_dengan_pnm")
    @Expose
    private String hubunganDenganPNM;
    @SerializedName("deskripsi_hubungan_dengan_bank")
    @Expose
    private String hubunganDenganBANK;


    public ProspekLainnyaModel() {
    }


    protected ProspekLainnyaModel(Parcel in) {
        idKodeUsaha = in.readInt();
        IdKodeBidangUsaha = in.readInt();
        idHubunganDenganPNM = in.readInt();
        idHubunganDenganBANK = in.readInt();
        kodeUsaha = in.readString();
        kodeBidangUsaha = in.readString();
        hubunganDenganPNM = in.readString();
        hubunganDenganBANK = in.readString();
    }

    public static final Creator<ProspekLainnyaModel> CREATOR = new Creator<ProspekLainnyaModel>() {
        @Override
        public ProspekLainnyaModel createFromParcel(Parcel in) {
            return new ProspekLainnyaModel(in);
        }

        @Override
        public ProspekLainnyaModel[] newArray(int size) {
            return new ProspekLainnyaModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idKodeUsaha);
        dest.writeInt(IdKodeBidangUsaha);
        dest.writeInt(idHubunganDenganPNM);
        dest.writeInt(idHubunganDenganBANK);
        dest.writeString(kodeUsaha);
        dest.writeString(kodeBidangUsaha);
        dest.writeString(hubunganDenganPNM);
        dest.writeString(hubunganDenganBANK);
    }

    public int getIdKodeUsaha() {
        return idKodeUsaha;
    }

    public void setIdKodeUsaha(int idKodeUsaha) {
        this.idKodeUsaha = idKodeUsaha;
    }

    public int getIdKodeBidangUsaha() {
        return IdKodeBidangUsaha;
    }

    public void setIdKodeBidangUsaha(int idKodeBidangUsaha) {
        IdKodeBidangUsaha = idKodeBidangUsaha;
    }

    public int getIdHubunganDenganPNM() {
        return idHubunganDenganPNM;
    }

    public void setIdHubunganDenganPNM(int idHubunganDenganPNM) {
        this.idHubunganDenganPNM = idHubunganDenganPNM;
    }

    public int getIdHubunganDenganBANK() {
        return idHubunganDenganBANK;
    }

    public void setIdHubunganDenganBANK(int idHubunganDenganBANK) {
        this.idHubunganDenganBANK = idHubunganDenganBANK;
    }

    public String getKodeUsaha() {
        return kodeUsaha;
    }

    public void setKodeUsaha(String kodeUsaha) {
        this.kodeUsaha = kodeUsaha;
    }

    public String getKodeBidangUsaha() {
        return kodeBidangUsaha;
    }

    public void setKodeBidangUsaha(String kodeBidangUsaha) {
        this.kodeBidangUsaha = kodeBidangUsaha;
    }

    public String getHubunganDenganPNM() {
        return hubunganDenganPNM;
    }

    public void setHubunganDenganPNM(String hubunganDenganPNM) {
        this.hubunganDenganPNM = hubunganDenganPNM;
    }

    public String getHubunganDenganBANK() {
        return hubunganDenganBANK;
    }

    public void setHubunganDenganBANK(String hubunganDenganBANK) {
        this.hubunganDenganBANK = hubunganDenganBANK;
    }
}
