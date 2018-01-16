package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PeruntukanLokasiModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterPeruntukanLokasiResponse extends BaseResponse {

    @SerializedName("agunan")
    @Expose
    private List<PeruntukanLokasiModel> list;

    public List<PeruntukanLokasiModel> getList() {
        return list;
    }

    public void setList(List<PeruntukanLokasiModel> list) {
        this.list = list;
    }
}
