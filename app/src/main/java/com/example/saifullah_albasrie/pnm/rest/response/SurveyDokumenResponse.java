package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class SurveyDokumenResponse extends BaseResponse {
    @SerializedName("foto")
    @Expose
    private List<SurveyDokumenModel> dokumenModelList;

    public List<SurveyDokumenModel> getDokumenModelList() {
        return dokumenModelList;
    }

    public void setDokumenModelList(List<SurveyDokumenModel> dokumenModelList) {
        this.dokumenModelList = dokumenModelList;
    }
}
