package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.AtapModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.DindingModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterDindingResponse extends BaseResponse {

    @SerializedName("konstruksi_bangunan")
    @Expose
    private List<DindingModel> list;

    public List<DindingModel> getList() {
        return list;
    }

    public void setList(List<DindingModel> list) {
        this.list = list;
    }

}
