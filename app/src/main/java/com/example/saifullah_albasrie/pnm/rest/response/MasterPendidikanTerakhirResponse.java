package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.GelarModel;
import com.example.saifullah_albasrie.pnm.model.master.PendidikanTerakhirModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 5/13/17.
 */

public class MasterPendidikanTerakhirResponse extends BaseResponse {

    @SerializedName("pendidikan")
    @Expose
    private List<PendidikanTerakhirModel> list;

    public List<PendidikanTerakhirModel> getList() {
        return list;
    }

    public void setList(List<PendidikanTerakhirModel> list) {
        this.list = list;
    }
}
