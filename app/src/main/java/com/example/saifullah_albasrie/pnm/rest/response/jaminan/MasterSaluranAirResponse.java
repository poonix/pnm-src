package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.SaluranAirModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterSaluranAirResponse {

    @SerializedName("agunan")
    @Expose
    private List<SaluranAirModel> list;

    public List<SaluranAirModel> getList() {
        return list;
    }

    public void setList(List<SaluranAirModel> list) {
        this.list = list;
    }
}
