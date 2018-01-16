package com.example.saifullah_albasrie.pnm.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class AutoSaveResponse extends BaseResponse{

    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;

    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;

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
}
