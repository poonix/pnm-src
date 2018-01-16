package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public interface SurveyDokumenCallback {

    void onGetSurveyDokumenSuccess(List<SurveyDokumenModel> dokumenModels);

    void onGetSurveyDokumenFailed(Throwable t);

    void onUploadSurveyDokumenSuccess(SurveyDokumenModel model);

    void onUploadSurveyDokumenFailed(Throwable t);

    void onUploadSurveyDokumenCompleted(String message);

    void onDeleteSurveyDokumenSuccess(int position, SurveyDokumenModel model);

    void onDeleteSurveyDokumenFailed(Throwable t);
}
