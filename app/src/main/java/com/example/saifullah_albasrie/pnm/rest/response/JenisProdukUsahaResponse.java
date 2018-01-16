package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisProdukUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisProdukUsahaResponse extends BaseResponse {

    @SerializedName("JenisProdukUsaha")
    @Expose
    private List<JenisProdukUsahaModel> list;

    public List<JenisProdukUsahaModel> getList() {
        return list;
    }

    public void setList(List<JenisProdukUsahaModel> list) {
        this.list = list;
    }
}
