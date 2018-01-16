package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public interface SurveyDetailCallback {

    void onGetSurveyDetailSuccess(SurveyDetailResponse response);

    void onGetSurveyDetailFailed(Throwable t);

    void onSaveSurveyDetailSuccess(String message);

    void onSaveSurveyDetailFailed(Throwable t);
}
