package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenListResponse;

/**
 * Created by saifullahalbasrie on 4/11/17.
 */

public interface SurveyDokumenChecklistCallback {

    void onGetSurveyDokumenChecklistSuccess(SurveyDokumenListResponse response);

    void onGetSurveyDokumenChecklistFailed(Throwable t);
}
