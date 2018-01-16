package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.LantaiModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterLantaiResponse extends BaseResponse {

    @SerializedName("konstruksi_bangunan")
    @Expose
    private List<LantaiModel> list;

    public List<LantaiModel> getList() {
        return list;
    }

    public void setList(List<LantaiModel> list) {
        this.list = list;
    }
}
