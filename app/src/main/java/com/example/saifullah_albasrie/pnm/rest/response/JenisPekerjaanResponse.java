package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisPekerjaanResponse extends BaseResponse {

    @SerializedName("jenisPekerjaan")
    @Expose
    private List<JenisPekerjaanModel> list;

    public List<JenisPekerjaanModel> getList() {
        return list;
    }

    public void setList(List<JenisPekerjaanModel> list) {
        this.list = list;
    }
}
