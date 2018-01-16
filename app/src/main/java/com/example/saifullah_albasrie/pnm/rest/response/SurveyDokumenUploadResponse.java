package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyDokumenUploadResponse extends BaseResponse {
    @SerializedName("data_file")
    @Expose
    private SurveyDokumenModel dokumenModel;

    public SurveyDokumenModel getDokumenModel() {
        return dokumenModel;
    }

    public void setDokumenModel(SurveyDokumenModel dokumenModel) {
        this.dokumenModel = dokumenModel;
    }
}
