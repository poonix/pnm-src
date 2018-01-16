package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaDetailModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyKeluargaRequest {
    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("data_keluarga")
    @Expose
    private List<SurveyKeluargaModel> keluargaModels;

    @SerializedName("data_rincian_keluarga")
    @Expose
    private List<SurveyKeluargaDetailModel> keluargaDetailModels;

    public SurveyKeluargaRequest(BiodataModel biodataModel, SurveyKeluargaModel model, List<SurveyKeluargaDetailModel> detailModels) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
        keluargaModels = new ArrayList<>();
        keluargaModels.add(model);
        keluargaDetailModels = new ArrayList<>();
        keluargaDetailModels.addAll(detailModels);
    }

}
