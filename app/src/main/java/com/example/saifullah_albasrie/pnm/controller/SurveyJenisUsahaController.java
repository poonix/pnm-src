package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyJenisUsahaCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyProfilKarakterCallback;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ProfilKarakterRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyJenisUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProfilKarakterResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJenisUsahaResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class SurveyJenisUsahaController {

    private final String LOG_TAG = SurveyJenisUsahaController.class.getSimpleName();

    private SurveyJenisUsahaCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyJenisUsahaResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyJenisUsahaController(SurveyJenisUsahaCallback callback) {
        this.callback = callback;
    }

    public void getSurveyJenisUsaha(String idDebitur, String idTransaksi) {
        call = service.getSurveyJenisUsaha(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyJenisUsahaResponse>() {
            @Override
            public void onResponse(Call<SurveyJenisUsahaResponse> call, Response<SurveyJenisUsahaResponse> response) {
                Log.d(LOG_TAG, "getSurveyJenisUsaha.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getJenisUsahaModels() != null && response.body().getJenisUsahaModels().size() > 0) {
                                callback.onGetSurveyJenisUsahaSuccess(response.body().getJenisUsahaModels().get(0));
                            } else {
                                callback.onGetSurveyJenisUsahaSuccess(null);
                            }
                        } else {
                            callback.onGetSurveyJenisUsahaFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyJenisUsahaSuccess(null);
                        } else {
                            callback.onGetSurveyJenisUsahaFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyJenisUsahaResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyJenisUsaha.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyJenisUsahaFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveSurveyJenisUsaha(BiodataModel biodataModel, SurveyJenisUsahaModel model) {
        SurveyJenisUsahaRequest request = new SurveyJenisUsahaRequest(biodataModel, model);
        callSubmit = service.saveSurveyJenisUsaha(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveSurveyJenisUsaha.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyJenisUsahaSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyJenisUsahaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyJenisUsahaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveSurveyJenisUsaha.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveSurveyJenisUsahaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
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
