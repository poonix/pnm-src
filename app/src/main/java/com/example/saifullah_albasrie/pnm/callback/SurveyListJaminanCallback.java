package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyListJaminanModel;

import java.util.List;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public interface SurveyListJaminanCallback {

    void onGetSurveyListJaminanSuccess(List<SurveyListJaminanModel> listJaminanModel);

    void onGetSurveyListJaminanFailure(Throwable t);
}
