package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ExumModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDataPembiayaanModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class SurveyDetailRequest {

    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("data_pembiayaan")
    @Expose
    public List<SurveyDataPembiayaanModel> dataPembiayaanModels;

    @SerializedName("jadwal")
    @Expose
    public List<ProspekJadwalModel> jadwalModels;

    @SerializedName("alamat")
    @Expose
    public List<ProspekAlamatModel> alamatModels;

    @SerializedName("exum")
    @Expose
    private List<ExumModel> exumModel;

    public SurveyDetailRequest(BiodataModel biodataModel) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
    }

    public List<SurveyDataPembiayaanModel> getDataPembiayaanModels() {
        return dataPembiayaanModels;
    }

    public void setDataPembiayaanModels(List<SurveyDataPembiayaanModel> dataPembiayaanModels) {
        this.dataPembiayaanModels = dataPembiayaanModels;
    }

    public List<ProspekJadwalModel> getJadwalModels() {
        return jadwalModels;
    }

    public void setJadwalModels(List<ProspekJadwalModel> jadwalModels) {
        this.jadwalModels = jadwalModels;
    }

    public List<ProspekAlamatModel> getAlamatModels() {
        return alamatModels;
    }

    public void setAlamatModels(List<ProspekAlamatModel> alamatModels) {
        this.alamatModels = alamatModels;
    }

    public List<ExumModel> getExumModel() {
        return exumModel;
    }

    public void setExumModel(List<ExumModel> exumModel) {
        this.exumModel = exumModel;
    }
}
