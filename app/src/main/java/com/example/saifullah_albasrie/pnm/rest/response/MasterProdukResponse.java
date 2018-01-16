package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.ProdukModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterProdukResponse extends BaseResponse {

    @SerializedName("master_status")
    @Expose
    private List<ProdukModel> list;

    public List<ProdukModel> getList() {
        return list;
    }

    public void setList(List<ProdukModel> list) {
        this.list = list;
    }
}
