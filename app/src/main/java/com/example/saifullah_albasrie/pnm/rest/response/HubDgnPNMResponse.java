package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganPNMModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeBidangUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class HubDgnPNMResponse extends BaseResponse {

    @SerializedName("master_hubungan_pnm")
    @Expose
    private List<HubunganDenganPNMModel> list;

    public List<HubunganDenganPNMModel> getList() {
        return list;
    }

    public void setList(List<HubunganDenganPNMModel> list) {
        this.list = list;
    }
}
