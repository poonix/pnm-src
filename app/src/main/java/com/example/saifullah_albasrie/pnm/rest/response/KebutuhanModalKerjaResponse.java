package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.AssetModel;
import com.example.saifullah_albasrie.pnm.model.KebutuhanModalKerjaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class KebutuhanModalKerjaResponse extends BaseResponse {
    @SerializedName("data_kmk")
    @Expose
    private List<KebutuhanModalKerjaModel> dataKmk = null;
    @SerializedName("data_aset")
    @Expose
    private List<AssetModel> dataAset = null;

    public List<KebutuhanModalKerjaModel> getDataKmk() {
        return dataKmk;
    }

    public void setDataKmk(List<KebutuhanModalKerjaModel> dataKmk) {
        this.dataKmk = dataKmk;
    }

    public List<AssetModel> getDataAset() {
        return dataAset;
    }

    public void setDataAset(List<AssetModel> dataAset) {
        this.dataAset = dataAset;
    }
}
