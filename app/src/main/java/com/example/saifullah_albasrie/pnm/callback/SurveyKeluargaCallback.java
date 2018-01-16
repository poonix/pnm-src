package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.rest.response.KebutuhanModalKerjaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public interface SurveyKeluargaCallback {

    void onGetSurveyKeluargaSuccess(SurveyKeluargaResponse response);

    void onGetSurveyKeluargaFailed(Throwable t);

    void onSaveSurveyKeluargaSuccess(String message);

    void onSaveSurveyKeluargaFailed(Throwable t);

    void onCheckSIDKeluargaSuccess(String message);

    void onCheckSIDKeluargaFailed(Throwable t);
}
