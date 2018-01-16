package com.example.saifullah_albasrie.pnm.controller;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyListJaminanCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJaminanListResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class SurveyListJaminanController {

    private final String LOG_TAG = SurveyListJaminanController.class.getSimpleName();

    private SurveyListJaminanCallback callback;
    private RestService service = RestHelper.getInstance().getRestService();
    private Call<SurveyJaminanListResponse> call;

    public SurveyListJaminanController(SurveyListJaminanCallback jaminanCallback) {
        this.callback = jaminanCallback;
    }

    public void getJaminanList(String idDebitur, String idTransaksi) {
        call = service.getSurveyJaminanList(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyJaminanListResponse>() {
            @Override
            public void onResponse(Call<SurveyJaminanListResponse> call, Response<SurveyJaminanListResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getSurveyListJaminanModel() != null && response.body().getSurveyListJaminanModel().size() > 0) {
                                callback.onGetSurveyListJaminanSuccess(response.body().getSurveyListJaminanModel());
                            } else {
                                callback.onGetSurveyListJaminanSuccess(null);
                            }
                        } else {
                            callback.onGetSurveyListJaminanFailure(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyListJaminanSuccess(null);
                        } else {
                            callback.onGetSurveyListJaminanFailure(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyJaminanListResponse> call, Throwable t) {
                if (callback != null) {
                    callback.onGetSurveyListJaminanFailure(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }

}
