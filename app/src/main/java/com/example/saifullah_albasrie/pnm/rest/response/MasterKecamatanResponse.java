package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterKecamatanResponse extends BaseResponse {

    @SerializedName("kecamatan")
    @Expose
    private List<KecamatanModel> list;

    public List<KecamatanModel> getList() {
        return list;
    }

    public void setList(List<KecamatanModel> list) {
        this.list = list;
    }
}
