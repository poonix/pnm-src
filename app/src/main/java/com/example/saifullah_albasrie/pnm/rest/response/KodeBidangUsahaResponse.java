package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.KodeBidangUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class KodeBidangUsahaResponse extends BaseResponse {

    @SerializedName("kodeBidangUsaha")
    @Expose
    private List<KodeBidangUsahaModel> list;

    public List<KodeBidangUsahaModel> getList() {
        return list;
    }

    public void setList(List<KodeBidangUsahaModel> list) {
        this.list = list;
    }
}
