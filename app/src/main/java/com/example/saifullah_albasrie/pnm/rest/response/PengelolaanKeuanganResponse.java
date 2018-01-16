package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.example.saifullah_albasrie.pnm.model.master.PengelolaanKeuanganModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class PengelolaanKeuanganResponse extends BaseResponse {

    @SerializedName("PnegelolaanKeuangan")
    @Expose
    private List<PengelolaanKeuanganModel> list;

    public List<PengelolaanKeuanganModel> getList() {
        return list;
    }

    public void setList(List<PengelolaanKeuanganModel> list) {
        this.list = list;
    }
}
