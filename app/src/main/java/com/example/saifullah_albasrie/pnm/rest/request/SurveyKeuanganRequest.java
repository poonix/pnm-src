package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDataPinjamanModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeuanganModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class SurveyKeuanganRequest {

    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("data_keuangan")
    @Expose
    private List<SurveyKeuanganModel> keuanganModels;

    @SerializedName("data_pinjaman")
    @Expose
    private List<SurveyDataPinjamanModel> dataPinjamanModels;

    public SurveyKeuanganRequest(BiodataModel biodataModel, SurveyKeuanganModel model, List<SurveyDataPinjamanModel> dataPinjaman) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
        keuanganModels = new ArrayList<>();
        keuanganModels.add(model);
        dataPinjamanModels = new ArrayList<>();
        dataPinjamanModels.addAll(dataPinjaman);
    }


}
