package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.ProdukModel;
import com.example.saifullah_albasrie.pnm.model.master.ProgramModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class MasterProgramResponse extends BaseResponse {

    @SerializedName("master_status")
    @Expose
    private List<ProgramModel> list;

    public List<ProgramModel> getList() {
        return list;
    }

    public void setList(List<ProgramModel> list) {
        this.list = list;
    }
}
