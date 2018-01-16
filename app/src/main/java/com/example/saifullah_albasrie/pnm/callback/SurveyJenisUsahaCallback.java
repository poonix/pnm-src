package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public interface SurveyJenisUsahaCallback {

    void onGetSurveyJenisUsahaSuccess(SurveyJenisUsahaModel surveyJenisUsahaModel);

    void onGetSurveyJenisUsahaFailed(Throwable t);

    void onSaveSurveyJenisUsahaSuccess(String message);

    void onSaveSurveyJenisUsahaFailed(Throwable t);
}
