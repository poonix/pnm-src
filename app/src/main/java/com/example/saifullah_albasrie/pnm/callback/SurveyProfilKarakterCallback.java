package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public interface SurveyProfilKarakterCallback {

    void onGetProfilKarakterSuccess(SurveyProfilKarakterModel profileKarakterModel);

    void onGetProfilKarakterFailed(Throwable t);

    void onSaveProfileKrakterSuccess(String message);

    void onSaveProfileKrakterFailed(Throwable t);
}
