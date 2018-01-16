package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/12/17.
 */

public interface CheckDebiturCallback {

    void onCheckDebiturSuccess(List<CheckDebiturModel> debiturModels);

    void onCheckDebiturFailed(Throwable t);
}
