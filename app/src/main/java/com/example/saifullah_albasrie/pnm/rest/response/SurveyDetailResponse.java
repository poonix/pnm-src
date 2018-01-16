package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.ExumModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDataPembiayaanModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class SurveyDetailResponse extends BaseResponse {

    @SerializedName("data_pembiayaan")
    @Expose
    private List<SurveyDataPembiayaanModel> dataPembiayaanModels;

    @SerializedName("jadwal")
    @Expose
    private List<ProspekJadwalModel> jadwalModels;

    @SerializedName("alamat")
    @Expose
    private List<ProspekAlamatModel> alamatModels;

    @SerializedName("exum")
    @Expose
    private List<ExumModel> exumModel;

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
