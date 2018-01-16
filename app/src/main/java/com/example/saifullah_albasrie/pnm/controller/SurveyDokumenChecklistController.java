package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyChecklistCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyDokumenChecklistCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyChecklistResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenListResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class SurveyDokumenChecklistController {

    private final String LOG_TAG = SurveyDokumenChecklistController.class.getSimpleName();

    private SurveyDokumenChecklistCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyDokumenListResponse> call;

    public SurveyDokumenChecklistController(SurveyDokumenChecklistCallback callback) {
        this.callback = callback;
    }

    public void getSurveyDokumenChecklist(String idDebitur, String idTransaksi) {
        call = service.getSurveyDokumenChecklist(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyDokumenListResponse>() {
            @Override
            public void onResponse(Call<SurveyDokumenListResponse> call, Response<SurveyDokumenListResponse> response) {
                Log.d(LOG_TAG, "getSurveyDokumenChecklist.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyDokumenChecklistSuccess(response.body());
                        } else {
                            callback.onGetSurveyDokumenChecklistFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyDokumenChecklistSuccess(null);
                        } else {
                            callback.onGetSurveyDokumenChecklistFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyDokumenListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyDokumenChecklist.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyDokumenChecklistFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
