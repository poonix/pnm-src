package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyProfilKarakterCallback;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ProfilKarakterRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProfilKarakterResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class SurveyProfilKarakterController {

    private final String LOG_TAG = SurveyProfilKarakterController.class.getSimpleName();

    private SurveyProfilKarakterCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<ProfilKarakterResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyProfilKarakterController(SurveyProfilKarakterCallback callback) {
        this.callback = callback;
    }

    public void getProfilKarakter(String idDebitur, String idTransaksi) {
        call = service.getSurveyProfileKarakter(idDebitur, idTransaksi);
        call.enqueue(new Callback<ProfilKarakterResponse>() {
            @Override
            public void onResponse(Call<ProfilKarakterResponse> call, Response<ProfilKarakterResponse> response) {
                Log.d(LOG_TAG, "getProfilKarakter.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getProfilDanKarakter() != null && response.body().getProfilDanKarakter().size() > 0) {
                                callback.onGetProfilKarakterSuccess(response.body().getProfilDanKarakter().get(0));
                            } else {
                                callback.onGetProfilKarakterSuccess(null);
                            }
                        } else {
                            callback.onGetProfilKarakterFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetProfilKarakterSuccess(null);
                        } else {
                            callback.onGetProfilKarakterFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfilKarakterResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getProfilKarakter.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetProfilKarakterFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveProfilKarakter(SurveyProfilKarakterModel model) {
        ProfilKarakterRequest request = new ProfilKarakterRequest(model);
        callSubmit = service.saveProfilKarakter(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveProfilKarakter.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProfileKrakterSuccess(statusMsg);
                        } else {
                            callback.onSaveProfileKrakterFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveProfileKrakterFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveProfilKarakter.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveProfileKrakterFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
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
