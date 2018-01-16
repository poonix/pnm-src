package com.example.saifullah_albasrie.pnm.rest.response.jaminan;

import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JalanDilaluiModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/25/17.
 */

public class MasterJalanDilaluiResponse extends BaseResponse {

    @SerializedName("agunan")
    @Expose
    private List<JalanDilaluiModel> list;

    public List<JalanDilaluiModel> getList() {
        return list;
    }

    public void setList(List<JalanDilaluiModel> list) {
        this.list = list;
    }
}
