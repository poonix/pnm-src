package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyAktivitasRekeningModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKapasitasUsahaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public class KapasitasUsahaResponse extends BaseResponse {

    @SerializedName("kapasitas_usaha")
    @Expose
    public List<SurveyKapasitasUsahaModel> surveyKapasitasUsahaModelList;
    @SerializedName("aktivitas_rekening")
    @Expose
    public List<SurveyAktivitasRekeningModel> aktivitasRekeningModelList;

    public List<SurveyKapasitasUsahaModel> getSurveyKapasitasUsahaModelList() {
        return surveyKapasitasUsahaModelList;
    }

    public void setSurveyKapasitasUsahaModelList(List<SurveyKapasitasUsahaModel> surveyKapasitasUsahaModelList) {
        this.surveyKapasitasUsahaModelList = surveyKapasitasUsahaModelList;
    }

    public List<SurveyAktivitasRekeningModel> getAktivitasRekeningModelList() {
        return aktivitasRekeningModelList;
    }

    public void setAktivitasRekeningModelList(List<SurveyAktivitasRekeningModel> aktivitasRekeningModelList) {
        this.aktivitasRekeningModelList = aktivitasRekeningModelList;
    }


}
