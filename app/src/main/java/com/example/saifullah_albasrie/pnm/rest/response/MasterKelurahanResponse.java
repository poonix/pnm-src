package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.example.saifullah_albasrie.pnm.model.master.KelurahanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterKelurahanResponse extends BaseResponse {

    @SerializedName("kecamatan")
    @Expose
    private List<KelurahanModel> list;

    public List<KelurahanModel> getList() {
        return list;
    }

    public void setList(List<KelurahanModel> list) {
        this.list = list;
    }
}
