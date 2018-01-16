package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PenggunaanTanahModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterPenggunaanTanahResponse extends BaseResponse {

    @SerializedName("keadaan_tanah")
    @Expose
    private List<PenggunaanTanahModel> list;

    public List<PenggunaanTanahModel> getList() {
        return list;
    }

    public void setList(List<PenggunaanTanahModel> list) {
        this.list = list;
    }
}
