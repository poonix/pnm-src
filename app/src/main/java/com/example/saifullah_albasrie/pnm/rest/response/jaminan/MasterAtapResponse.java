package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.AtapModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterAtapResponse extends BaseResponse {

    @SerializedName("konstruksi_bangunan")
    @Expose
    private List<AtapModel> list;

    public List<AtapModel> getList() {
        return list;
    }

    public void setList(List<AtapModel> list) {
        this.list = list;
    }
}
