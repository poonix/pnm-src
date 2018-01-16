package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyDataPinjamanModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeuanganModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class SurveyKeuanganResponse extends BaseResponse{

    @SerializedName("data_keuangan")
    @Expose
    private List<SurveyKeuanganModel> keuanganModels;

    @SerializedName("data_pinjaman")
    @Expose
    private List<SurveyDataPinjamanModel> dataPinjamanModels;

    public List<SurveyKeuanganModel> getKeuanganModels() {
        return keuanganModels;
    }

    public void setKeuanganModels(List<SurveyKeuanganModel> keuanganModels) {
        this.keuanganModels = keuanganModels;
    }

    public List<SurveyDataPinjamanModel> getDataPinjamanModels() {
        return dataPinjamanModels;
    }

    public void setDataPinjamanModels(List<SurveyDataPinjamanModel> dataPinjamanModels) {
        this.dataPinjamanModels = dataPinjamanModels;
    }
}
