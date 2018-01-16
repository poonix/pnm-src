package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisAgunanModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterJenisAgunanResponse extends BaseResponse {

    @SerializedName("jenis_usaha")
    @Expose
    private List<JenisAgunanModel> list;

    public List<JenisAgunanModel> getList() {
        return list;
    }

    public void setList(List<JenisAgunanModel> list) {
        this.list = list;
    }
}
