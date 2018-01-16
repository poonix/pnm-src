package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterKabupatenResponse extends BaseResponse {

    @SerializedName("kabupatenKota")
    @Expose
    private List<KabupatenModel> list;

    public List<KabupatenModel> getList() {
        return list;
    }

    public void setList(List<KabupatenModel> list) {
        this.list = list;
    }
}
