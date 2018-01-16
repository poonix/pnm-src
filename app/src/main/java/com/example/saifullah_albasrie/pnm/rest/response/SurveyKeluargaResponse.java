package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaDetailModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyKeluargaResponse extends BaseResponse{

    @SerializedName("data_keluarga")
    @Expose
    private List<SurveyKeluargaModel> keluargaModels;

    @SerializedName("data_rincian_keluarga")
    @Expose
    private List<SurveyKeluargaDetailModel> keluargaDetailModels;

    public List<SurveyKeluargaModel> getKeluargaModels() {
        return keluargaModels;
    }

    public void setKeluargaModels(List<SurveyKeluargaModel> keluargaModels) {
        this.keluargaModels = keluargaModels;
    }

    public List<SurveyKeluargaDetailModel> getKeluargaDetailModels() {
        return keluargaDetailModels;
    }

    public void setKeluargaDetailModels(List<SurveyKeluargaDetailModel> keluargaDetailModels) {
        this.keluargaDetailModels = keluargaDetailModels;
    }
}
