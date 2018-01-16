package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyKeluargaModel {
    /*
    {
      "jumlah_tanggungan_istri": null,
      "jumlah_tanggungan_anak": null,
      "jumlah_tanggungan_lain": null,
      "jumlah_tanggungan": null,
      "is_pasangan_bekerja": null,
      "is_anak_bekerja": null,
      "is_orangtua_bekerja": null
    }
     */

    @SerializedName("jumlah_tanggungan_istri")
    @Expose
    private String jumlahTanggunganIstri;
    @SerializedName("jumlah_tanggungan_anak")
    @Expose
    private String jumlahTanggunganAnak;
    @SerializedName("jumlah_tanggungan_lain")
    @Expose
    private String jumlahTanggunganLain;
    @SerializedName("jumlah_tanggungan")
    @Expose
    private String jumlahTanggungan;
    @SerializedName("is_pasangan_bekerja")
    @Expose
    private int isPasanganBekerja;
    @SerializedName("is_anak_bekerja")
    @Expose
    private int isAnakBekerja;
    @SerializedName("is_orangtua_bekerja")
    @Expose
    private int isOrangtuaBekerja;

    public String getJumlahTanggunganIstri() {
        return jumlahTanggunganIstri;
    }

    public void setJumlahTanggunganIstri(String jumlahTanggunganIstri) {
        this.jumlahTanggunganIstri = jumlahTanggunganIstri;
    }

    public String getJumlahTanggunganAnak() {
        return jumlahTanggunganAnak;
    }

    public void setJumlahTanggunganAnak(String jumlahTanggunganAnak) {
        this.jumlahTanggunganAnak = jumlahTanggunganAnak;
    }

    public String getJumlahTanggunganLain() {
        return jumlahTanggunganLain;
    }

    public void setJumlahTanggunganLain(String jumlahTanggunganLain) {
        this.jumlahTanggunganLain = jumlahTanggunganLain;
    }

    public String getJumlahTanggungan() {
        return jumlahTanggungan;
    }

    public void setJumlahTanggungan(String jumlahTanggungan) {
        this.jumlahTanggungan = jumlahTanggungan;
    }

    public int getIsPasanganBekerja() {
        return isPasanganBekerja;
    }

    public void setIsPasanganBekerja(int isPasanganBekerja) {
        this.isPasanganBekerja = isPasanganBekerja;
    }

    public int getIsAnakBekerja() {
        return isAnakBekerja;
    }

    public void setIsAnakBekerja(int isAnakBekerja) {
        this.isAnakBekerja = isAnakBekerja;
    }

    public int getIsOrangtuaBekerja() {
        return isOrangtuaBekerja;
    }

    public void setIsOrangtuaBekerja(int isOrangtuaBekerja) {
        this.isOrangtuaBekerja = isOrangtuaBekerja;
    }
}
