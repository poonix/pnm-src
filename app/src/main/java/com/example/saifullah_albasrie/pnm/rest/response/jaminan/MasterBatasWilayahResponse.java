package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BatasWilayahModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterBatasWilayahResponse extends BaseResponse {

    @SerializedName("keadaan_tanah")
    @Expose
    private List<BatasWilayahModel> list;

    public List<BatasWilayahModel> getList() {
        return list;
    }

    public void setList(List<BatasWilayahModel> list) {
        this.list = list;
    }
}
