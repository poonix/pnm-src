package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJaminanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyJaminanRequest {
    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("survey_agunan")
    @Expose
    private List<SurveyJaminanModel> jaminanModelList;

    public SurveyJaminanRequest(BiodataModel biodataModel, SurveyJaminanModel model) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
        jaminanModelList = new ArrayList<>();
        jaminanModelList.add(model);
    }
}
