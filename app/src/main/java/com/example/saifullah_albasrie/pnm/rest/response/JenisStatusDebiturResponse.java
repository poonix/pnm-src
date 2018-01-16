package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.StatusDebiturModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class JenisStatusDebiturResponse extends BaseResponse {

    @SerializedName("master_status")
    @Expose
    private List<StatusDebiturModel> list;

    public List<StatusDebiturModel> getList() {
        return list;
    }

    public void setList(List<StatusDebiturModel> list) {
        this.list = list;
    }
}
