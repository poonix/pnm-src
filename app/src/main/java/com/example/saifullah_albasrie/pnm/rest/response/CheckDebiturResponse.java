package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class CheckDebiturResponse {
    @SerializedName("Status")
    @Expose
    private int status;

    @SerializedName("Data")
    @Expose
    private List<CheckDebiturModel> debiturModelList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CheckDebiturModel> getDebiturModelList() {
        return debiturModelList;
    }

    public void setDebiturModelList(List<CheckDebiturModel> debiturModelList) {
        this.debiturModelList = debiturModelList;
    }
}
