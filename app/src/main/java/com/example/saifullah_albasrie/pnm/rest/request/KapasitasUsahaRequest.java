package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyAktivitasRekeningModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKapasitasUsahaModel;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public class KapasitasUsahaRequest {

    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;
    @SerializedName("kapasitas_usaha")
    @Expose
    public List<SurveyKapasitasUsahaModel> kapasitasUsahaModel;
    @SerializedName("aktivitas_rekening")
    @Expose
    public List<SurveyAktivitasRekeningModel> aktivitasRekeningModel;

    public KapasitasUsahaRequest(List<SurveyKapasitasUsahaModel> kapasitasUsahaModel, List<SurveyAktivitasRekeningModel> aktivitasRekeningModel, BiodataModel biodataModel) {
        setupRequest(kapasitasUsahaModel, aktivitasRekeningModel, biodataModel);
    }

    private void setupRequest(List<SurveyKapasitasUsahaModel> kapasitasUsaha, List<SurveyAktivitasRekeningModel> aktivitasRekening, BiodataModel biodataModel) {
        if (kapasitasUsaha != null && aktivitasRekening != null && AppPreference.getInstance().getUserLoggedIn() != null) {
            biodata = new ArrayList<>();
            biodata.add(biodataModel);
            kapasitasUsahaModel = kapasitasUsaha;
            aktivitasRekeningModel = aktivitasRekening;
        }
    }

    public List<BiodataModel> getBiodata() {
        return biodata;
    }

    public void setBiodata(List<BiodataModel> biodata) {
        this.biodata = biodata;
    }

    public List<SurveyKapasitasUsahaModel> getKapasitasUsahaModel() {
        return kapasitasUsahaModel;
    }

    public void setKapasitasUsahaModel(List<SurveyKapasitasUsahaModel> kapasitasUsahaModel) {
        this.kapasitasUsahaModel = kapasitasUsahaModel;
    }

    public List<SurveyAktivitasRekeningModel> getAktivitasRekeningModel() {
        return aktivitasRekeningModel;
    }

    public void setAktivitasRekeningModel(List<SurveyAktivitasRekeningModel> aktivitasRekeningModel) {
        this.aktivitasRekeningModel = aktivitasRekeningModel;
    }
}
