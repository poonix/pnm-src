package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisDokumenModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisProdukUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/18/17.
 */

public class JenisDokumenResponse extends BaseResponse {

    @SerializedName("jenis_dokumen")
    @Expose
    private List<JenisDokumenModel> list;

    public List<JenisDokumenModel> getList() {
        return list;
    }

    public void setList(List<JenisDokumenModel> list) {
        this.list = list;
    }
}
