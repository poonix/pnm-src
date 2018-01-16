package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PlafonModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterPlafonResponse extends BaseResponse {

    @SerializedName("konstruksi_bangunan")
    @Expose
    private List<PlafonModel> list;

    public List<PlafonModel> getList() {
        return list;
    }

    public void setList(List<PlafonModel> list) {
        this.list = list;
    }
}
