package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class SurveyChecklistResponse extends BaseResponse {

    @SerializedName("list_checklist")
    @Expose
    private List<SurveyChecklistModel> list;

    public List<SurveyChecklistModel> getList() {
        return list;
    }

    public void setList(List<SurveyChecklistModel> list) {
        this.list = list;
    }
}
