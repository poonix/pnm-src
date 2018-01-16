package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterProvinsiResponse extends BaseResponse {

    @SerializedName("provinsi")
    @Expose
    private List<ProvinsiModel> list;

    public List<ProvinsiModel> getList() {
        return list;
    }

    public void setList(List<ProvinsiModel> list) {
        this.list = list;
    }
}
