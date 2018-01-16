package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyDetailCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyKeuanganCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyDetailRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeuanganRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeuanganResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class SurveyKeuanganController {

    private final String LOG_TAG = SurveyKeuanganController.class.getSimpleName();

    private SurveyKeuanganCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyKeuanganResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyKeuanganController(SurveyKeuanganCallback callback) {
        this.callback = callback;
    }

    public void getSurveyKeuangan(String idDebitur, String idTransaksi) {
        call = service.getSurveyKeuangan(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyKeuanganResponse>() {
            @Override
            public void onResponse(Call<SurveyKeuanganResponse> call, Response<SurveyKeuanganResponse> response) {
                Log.d(LOG_TAG, "getSurveyKeuangan.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyKeuanganSuccess(response.body().getKeuanganModels(), response.body().getDataPinjamanModels());
                        } else {
                            callback.onGetSurveyKeuanganFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyKeuanganSuccess(null, null);
                        } else {
                            callback.onGetSurveyKeuanganFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyKeuanganResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyKeuangan.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyKeuanganFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveSurveyKeuangan(SurveyKeuanganRequest request) {
        callSubmit = service.saveSurveyKeuangan(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveSurveyKeuangan.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyKeuanganSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyKeuanganFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyKeuanganFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveSurveyKeuangan.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveSurveyKeuanganFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
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
