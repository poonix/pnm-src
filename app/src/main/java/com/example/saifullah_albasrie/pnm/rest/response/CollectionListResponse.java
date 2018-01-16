package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/26/17.
 */

public class CollectionListResponse {

    @SerializedName("Status")
    @Expose
    private int status;

    @SerializedName("Data")
    @Expose
    private List<PnmDebiturModel> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<PnmDebiturModel> getData() {
        return data;
    }

    public void setData(List<PnmDebiturModel> data) {
        this.data = data;
    }
}
