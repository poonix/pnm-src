package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;

/**
 * Created by saifullahalbasrie on 4/11/17.
 */

public interface SurveyChecklistCallback {

    void onGetSurveyChecklistSuccess(SurveyChecklistModel checklistModel);

    void onGetSurveyChecklistFailed(Throwable t);

    void onCheckSIDSuccess(String message);

    void onCheckSIDFailed(Throwable t);

    void onSendPengajuanSuccess(String message);

    void onSendPengajuanFailed(Throwable t);

    void onSendApprovalSuccess(String message);

    void onSendApprovalFailed(Throwable t);
}
