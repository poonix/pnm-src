package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class PengelolaanKeuanganModel implements BaseMasterModel{

    /*
    "PnegelolaanKeuangan": [
    {
      "id": 1,
      "rincian": " Pembukuan Usaha Sudah Terpisah Dari Pengeluaran Pribadi & Terdapat Pencatatan : Tanggal Transaksi,Persediaan Barang,Penerimaan & Pengeluaraan Tunai, Keuntungan / Kerugian , Piutang & Hutang"
    },
    {
      "id": 2,
      "rincian": "Pembukuan Usaha Sudah Terpisah Dari Pengeluaran Pribadi & Terdapat Pencatatan : Tanggal Transaksi,Persedian Barang,Penerimaan & Pengeluaran Tunai, Piutang & Hutang"
    },
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("rincian")
    @Expose
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return getDetail();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }

}
