package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyDataPinjamanModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeuanganModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public interface SurveyKeuanganCallback {

    void onGetSurveyKeuanganSuccess(List<SurveyKeuanganModel> keuanganModel, List<SurveyDataPinjamanModel> dataPinjamanModels);

    void onGetSurveyKeuanganFailed(Throwable t);

    void onSaveSurveyKeuanganSuccess(String message);

    void onSaveSurveyKeuanganFailed(Throwable t);
}
