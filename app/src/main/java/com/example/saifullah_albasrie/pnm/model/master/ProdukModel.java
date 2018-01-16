package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/6/17.
 */

public class ProdukModel implements BaseMasterModel{

    /*
    "master_status": [
    {
      "id": 1,
      "jenis_produk": 2,
      "nama_produk": "MIKRO MADANI 10- TNR12",
      "inisial_produk": "MM 10- TNR12",
      "plafond_minimal": "75000000",
      "plafond_maksimal": "250000000",
      "tenor_min": 1,
      "tenor_max": 12
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("jenis_produk")
    @Expose
    private String jenisProduk;

    @SerializedName("nama_produk")
    @Expose
    private String namaProduk;

    @SerializedName("inisial_produk")
    @Expose
    private String inisialProduk;

    @SerializedName("plafond_minimal")
    @Expose
    private int plafondMinimal;

    @SerializedName("plafond_maksimal")
    @Expose
    private int plafondMaksimal;

    @SerializedName("tenor_min")
    @Expose
    private int tenorMin;

    @SerializedName("tenor_max")
    @Expose
    private int tenorMax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getInisialProduk() {
        return inisialProduk;
    }

    public void setInisialProduk(String inisialProduk) {
        this.inisialProduk = inisialProduk;
    }

    public int getPlafondMinimal() {
        return plafondMinimal;
    }

    public void setPlafondMinimal(int plafondMinimal) {
        this.plafondMinimal = plafondMinimal;
    }

    public int getPlafondMaksimal() {
        return plafondMaksimal;
    }

    public void setPlafondMaksimal(int plafondMaksimal) {
        this.plafondMaksimal = plafondMaksimal;
    }

    public int getTenorMin() {
        return tenorMin;
    }

    public void setTenorMin(int tenorMin) {
        this.tenorMin = tenorMin;
    }

    public int getTenorMax() {
        return tenorMax;
    }

    public void setTenorMax(int tenorMax) {
        this.tenorMax = tenorMax;
    }

    @Override
    public String toString() {
        return getNamaProduk();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
