package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class SurveyJenisUsahaResponse extends BaseResponse {

    @SerializedName("jenis_usaha")
    @Expose
    private List<SurveyJenisUsahaModel> jenisUsahaModels;

    public List<SurveyJenisUsahaModel> getJenisUsahaModels() {
        return jenisUsahaModels;
    }

    public void setJenisUsahaModels(List<SurveyJenisUsahaModel> jenisUsahaModels) {
        this.jenisUsahaModels = jenisUsahaModels;
    }
}
