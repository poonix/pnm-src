package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class JenisProspekResponse extends BaseResponse {

    @SerializedName("JenisProspek")
    @Expose
    private List<JenisProspekModel> list;

    public List<JenisProspekModel> getList() {
        return list;
    }

    public void setList(List<JenisProspekModel> list) {
        this.list = list;
    }
}
