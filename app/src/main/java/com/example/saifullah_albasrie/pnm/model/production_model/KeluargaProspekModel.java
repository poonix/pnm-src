package com.example.saifullah_albasrie.pnm.model.production_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by The Sarino's on 14-Jan-18.
 */

public class KeluargaProspekModel {

    @SerializedName("DB_PROSPEK_ID")
    @Expose
    public int DB_PROSPEK_ID;

    @SerializedName("MS_STATUS_HUBUNGAN_KELUARGA_ID")
    @Expose
    public int MS_STATUS_HUBUNGAN_KELUARGA_ID;

    @SerializedName("PR_NAMA_LENGKAP")
    @Expose
    public String PR_NAMA_LENGKAP;

    @SerializedName("MS_JENIS_IDENTITAS_ID")
    @Expose
    private int  MS_JENIS_IDENTITAS_ID;

    @SerializedName("PR_NO_IDENTITAS")
    @Expose
    private String PR_NO_IDENTITAS;

    @SerializedName("PR_MASA_BERLAKU_IDENTITAS")
    @Expose
    private String PR_MASA_BERLAKU_IDENTITAS;

    @SerializedName("MS_JENIS_KELAMIN_ID")
    @Expose
    private int MS_JENIS_KELAMIN_ID;

    @SerializedName("PR_TANGGAL_LAHIR")
    @Expose
    private String PR_TANGGAL_LAHIR;

    @SerializedName("PR_TEMPAT_LAHIR")
    @Expose
    private String 	PR_TEMPAT_LAHIR;

    @SerializedName("MS_PEKERJAAN_ID")
    @Expose
    private int MS_PEKERJAAN_ID;

    @SerializedName("PR_NO_TELP")
    @Expose
    private String PR_NO_TELP;

    @SerializedName("PR_NO_HP")
    @Expose
    private String PR_NO_HP;

    public KeluargaProspekModel() {}

    public int getDB_PROSPEK_ID() {
        return DB_PROSPEK_ID;
    }

    public void setDB_PROSPEK_ID(int DB_PROSPEK_ID) {
        this.DB_PROSPEK_ID = DB_PROSPEK_ID;
    }

    public int getMS_STATUS_HUBUNGAN_KELUARGA_ID() {
        return MS_STATUS_HUBUNGAN_KELUARGA_ID;
    }

    public void setMS_STATUS_HUBUNGAN_KELUARGA_ID(int MS_STATUS_HUBUNGAN_KELUARGA_ID) {
        this.MS_STATUS_HUBUNGAN_KELUARGA_ID = MS_STATUS_HUBUNGAN_KELUARGA_ID;
    }

    public int getMS_JENIS_IDENTITAS_ID() {
        return MS_JENIS_IDENTITAS_ID;
    }

    public void setPR_NAMA_LENGKAP(int MS_JENIS_IDENTITAS_ID) {
        this.MS_JENIS_IDENTITAS_ID = MS_JENIS_IDENTITAS_ID;
    }

    public String getPR_NO_IDENTITAS() {
        return PR_NO_IDENTITAS;
    }

    public void setPR_NO_IDENTITAS(String PR_NO_IDENTITAS) {
        this.PR_NO_IDENTITAS = PR_NO_IDENTITAS;
    }

    public String getPR_MASA_BERLAKU_IDENTITAS() {
        return PR_MASA_BERLAKU_IDENTITAS;
    }

    public void setMS_STATUS_TEMPAT_ID(String MS_STATUS_TEMPAT_ID) {
        this.PR_MASA_BERLAKU_IDENTITAS = PR_MASA_BERLAKU_IDENTITAS;
    }

    public int getMS_JENIS_KELAMIN_ID() {
        return MS_JENIS_KELAMIN_ID;
    }

    public void setMS_JENIS_KELAMIN_ID(int MS_JENIS_KELAMIN_ID) {
        this.MS_JENIS_KELAMIN_ID = MS_JENIS_KELAMIN_ID;
    }

    public String getPR_TANGGAL_LAHIR() {
        return PR_TANGGAL_LAHIR;
    }

    public void setPR_TANGGAL_LAHIR(String PR_TANGGAL_LAHIR) {
        this.PR_TANGGAL_LAHIR = PR_TANGGAL_LAHIR;
    }

    public String getPR_TEMPAT_LAHIR() {
        return PR_TEMPAT_LAHIR;
    }

    public void setPR_TEMPAT_LAHIR(String PR_TEMPAT_LAHIR) {
        this.PR_TEMPAT_LAHIR = PR_TEMPAT_LAHIR;
    }

    public int getMS_PEKERJAAN_ID() {
        return MS_PEKERJAAN_ID;
    }

    public void setMS_PEKERJAAN_ID(int MS_PEKERJAAN_ID) {
        this.MS_PEKERJAAN_ID = MS_PEKERJAAN_ID;
    }

    public String getPR_NO_TELP() {
        return PR_NO_TELP;
    }

    public void setPR_NO_TELP(String PR_NO_TELP) {
        this.PR_NO_TELP = PR_NO_TELP;
    }

    public String getPR_NO_HP() {
        return PR_NO_HP;
    }

    public void setPR_NO_HP(String PR_NO_HP) {
        this.PR_NO_HP = PR_NO_HP;
    }


}
