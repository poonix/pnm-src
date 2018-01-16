package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.RiwayatAngsuran;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/27/17.
 */

public class HistoryAngsuranListResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<RiwayatAngsuran> data = null;

    public List<RiwayatAngsuran> getData() {
        return data;
    }

    public void setData(List<RiwayatAngsuran> data) {
        this.data = data;
    }

}
