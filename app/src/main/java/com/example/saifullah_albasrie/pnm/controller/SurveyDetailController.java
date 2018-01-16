package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyDetailCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyProfilKarakterCallback;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ProfilKarakterRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyDetailRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProfilKarakterResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class SurveyDetailController {

    private final String LOG_TAG = SurveyDetailController.class.getSimpleName();

    private SurveyDetailCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyDetailResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyDetailController(SurveyDetailCallback callback) {
        this.callback = callback;
    }

    public void getSurveyDetail(String idDebitur, String idTransaksi) {
        call = service.getSurveyDetail(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyDetailResponse>() {
            @Override
            public void onResponse(Call<SurveyDetailResponse> call, Response<SurveyDetailResponse> response) {
                Log.d(LOG_TAG, "getSurveyDetail.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyDetailSuccess(response.body());
                        } else {
                            callback.onGetSurveyDetailFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyDetailSuccess(null);
                        } else {
                            callback.onGetSurveyDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyDetailResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyDetail.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveSurveyDetail(SurveyDetailRequest request) {
        callSubmit = service.saveSurveyDetail(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveSurveyDetail.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyDetailSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveSurveyDetail.onFailure " + (t != null ? t.getMessage() : ""));

                if (callback != null) {
                    String message = t != null ? t.getMessage() : "";
                    if (t instanceof IllegalStateException) {
                        message = MyApplication.getContext().getString(R.string.internal_server_error);
                    }
                    callback.onSaveSurveyDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + message));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
        if (callSubmit != null)
            callSubmit.cancel();
    }
}
