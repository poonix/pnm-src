package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyListJaminanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class SurveyJaminanListResponse extends BaseResponse {

    @SerializedName("list_agunan")
    @Expose
    private List<SurveyListJaminanModel> listJaminan;

    public SurveyJaminanListResponse() {

    }

    public List<SurveyListJaminanModel> getSurveyListJaminanModel() {
        return listJaminan;
    }

    public void setSurveyListJaminanModel(List<SurveyListJaminanModel> surveyListJaminanModel) {
        this.listJaminan = surveyListJaminanModel;
    }
}
