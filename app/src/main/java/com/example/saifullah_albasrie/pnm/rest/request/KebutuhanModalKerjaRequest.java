package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.AssetModel;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.KebutuhanModalKerjaModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class KebutuhanModalKerjaRequest {
    @SerializedName("biodata")
    @Expose
    private List<BiodataModel> biodata;
    @SerializedName("data_kmk")
    @Expose
    private List<KebutuhanModalKerjaModel> dataKmk = null;
    @SerializedName("data_aset")
    @Expose
    private List<AssetModel> dataAset = null;

    public KebutuhanModalKerjaRequest(BiodataModel biodataModel, KebutuhanModalKerjaModel kebutuhanModalKerjaModel, List<AssetModel> assetModels) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
        dataKmk = new ArrayList<>();
        dataKmk.add(kebutuhanModalKerjaModel);
        dataAset = assetModels;
    }
}
