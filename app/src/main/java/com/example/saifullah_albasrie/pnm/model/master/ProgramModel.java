package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/6/17.
 */

public class ProgramModel implements BaseMasterModel{

    /*
    "master_status": [
    {
      "id": 1,
      "kode_program": "REG",
      "nama_program": "REGULAR",
      "deskripsi": "Program Regular sesuai Produk",
      "minimum_plafond": 1000000,
      "maksimum_plafond": 250000000
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("kode_program")
    @Expose
    private String kodeProgram;

    @SerializedName("nama_program")
    @Expose
    private String namaProgram;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("minimum_plafond")
    @Expose
    private double plafondMinimal;

    @SerializedName("maksimum_plafond")
    @Expose
    private double plafondMaksimal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeProgram() {
        return kodeProgram;
    }

    public void setKodeProgram(String kodeProgram) {
        this.kodeProgram = kodeProgram;
    }

    public String getNamaProgram() {
        return namaProgram;
    }

    public void setNamaProgram(String namaProgram) {
        this.namaProgram = namaProgram;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getPlafondMinimal() {
        return plafondMinimal;
    }

    public void setPlafondMinimal(double plafondMinimal) {
        this.plafondMinimal = plafondMinimal;
    }

    public double getPlafondMaksimal() {
        return plafondMaksimal;
    }

    public void setPlafondMaksimal(double plafondMaksimal) {
        this.plafondMaksimal = plafondMaksimal;
    }

    @Override
    public String toString() {
        return getNamaProgram();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
