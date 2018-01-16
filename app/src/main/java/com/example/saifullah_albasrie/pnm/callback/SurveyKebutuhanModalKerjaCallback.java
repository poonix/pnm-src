package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.KebutuhanModalKerjaModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.rest.response.KebutuhanModalKerjaResponse;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public interface SurveyKebutuhanModalKerjaCallback {

    void onGetSurveyKMKSuccess(KebutuhanModalKerjaResponse response);

    void onGetSurveyKMKFailed(Throwable t);

    void onSaveSurveyKMKSuccess(String message);

    void onSaveSurveyKMKFailed(Throwable t);
}
