package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class KodeUsahaResponse extends BaseResponse {

    @SerializedName("kodeUsaha")
    @Expose
    private List<KodeUsahaModel> list;

    public List<KodeUsahaModel> getList() {
        return list;
    }

    public void setList(List<KodeUsahaModel> list) {
        this.list = list;
    }
}
