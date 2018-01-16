package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class SurveyJenisUsahaRequest {

    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("jenis_usaha")
    @Expose
    private List<SurveyJenisUsahaModel> jenisUsahaModels;

    public SurveyJenisUsahaRequest(BiodataModel biodataModel, SurveyJenisUsahaModel model) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
        jenisUsahaModels = new ArrayList<>();
        jenisUsahaModels.add(model);
    }

    public List<SurveyJenisUsahaModel> getJenisUsahaModels() {
        return jenisUsahaModels;
    }

    public void setJenisUsahaModels(List<SurveyJenisUsahaModel> jenisUsahaModels) {
        this.jenisUsahaModels = jenisUsahaModels;
    }
}
