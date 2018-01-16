package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.GelarModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisAgunanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 5/13/17.
 */

public class MasterGelarResponse extends BaseResponse {

    @SerializedName("gelar")
    @Expose
    private List<GelarModel> list;

    public List<GelarModel> getList() {
        return list;
    }

    public void setList(List<GelarModel> list) {
        this.list = list;
    }
}
