package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;

/**
 * Created by saifullahalbasrie on 4/11/17.
 */

public interface CheckSIDCallback {

    void onCheckSIDSuccess(String message);

    void onCheckSIDFailed(Throwable t);

}
