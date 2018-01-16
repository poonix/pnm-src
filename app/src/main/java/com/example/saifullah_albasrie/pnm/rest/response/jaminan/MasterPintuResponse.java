package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PintuModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterPintuResponse extends BaseResponse {

    @SerializedName("konstruksi_bangunan")
    @Expose
    private List<PintuModel> list;

    public List<PintuModel> getList() {
        return list;
    }

    public void setList(List<PintuModel> list) {
        this.list = list;
    }
}
