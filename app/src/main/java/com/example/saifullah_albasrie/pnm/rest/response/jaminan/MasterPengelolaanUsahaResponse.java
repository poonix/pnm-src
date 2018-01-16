package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PengelolaanUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PeruntukanLokasiModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterPengelolaanUsahaResponse extends BaseResponse {

    @SerializedName("jenis_pengelolaan")
    @Expose
    private List<PengelolaanUsahaModel> list;

    public List<PengelolaanUsahaModel> getList() {
        return list;
    }

    public void setList(List<PengelolaanUsahaModel> list) {
        this.list = list;
    }
}
