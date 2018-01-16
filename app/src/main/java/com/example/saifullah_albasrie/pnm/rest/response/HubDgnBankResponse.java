package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganBankModel;
import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganPNMModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class HubDgnBankResponse extends BaseResponse {

    @SerializedName("master_hubungan_bank")
    @Expose
    private List<HubunganDenganBankModel> list;

    public List<HubunganDenganBankModel> getList() {
        return list;
    }

    public void setList(List<HubunganDenganBankModel> list) {
        this.list = list;
    }
}
