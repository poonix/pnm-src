package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisDokumenModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisHartaResponse extends BaseResponse {

    @SerializedName("harta_benda")
    @Expose
    private List<JenisHartaModel> list;

    public List<JenisHartaModel> getList() {
        return list;
    }

    public void setList(List<JenisHartaModel> list) {
        this.list = list;
    }
}
