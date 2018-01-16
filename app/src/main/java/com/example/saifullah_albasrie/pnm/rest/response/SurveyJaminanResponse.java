package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyJaminanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyJaminanResponse extends BaseResponse {
    @SerializedName("survey_agunan")
    @Expose
    private List<SurveyJaminanModel> jaminanModelList;

    public List<SurveyJaminanModel> getJaminanModelList() {
        return jaminanModelList;
    }

    public void setJaminanModelList(List<SurveyJaminanModel> jaminanModelList) {
        this.jaminanModelList = jaminanModelList;
    }
}
