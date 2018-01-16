package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyJaminanModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BuktiKepemilikanAgunanModel;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public interface SurveyJaminanCallback {

    void onGetSurveyJaminanSuccess(SurveyJaminanModel model);

    void onGetSurveyJaminanFailed(Throwable t);

    void onGetBuktiKepemilikanSuccess(List<BuktiKepemilikanAgunanModel> list);

    void onGetBuktiKepemilikanFailed(Throwable t);

    void onSaveSurveyJaminanSuccess(String message);

    void onSaveSurveyJaminanFailed(Throwable t);
}
