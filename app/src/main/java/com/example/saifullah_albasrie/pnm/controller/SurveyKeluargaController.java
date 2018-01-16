package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKeluargaCallback;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaDetailModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.CheckSIDRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeluargaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class SurveyKeluargaController {

    private final String LOG_TAG = SurveyKeluargaController.class.getSimpleName();

    private SurveyKeluargaCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyKeluargaResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyKeluargaController(SurveyKeluargaCallback callback) {
        this.callback = callback;
    }

    public void getSurveyKeluarga(String idDebitur, String idTransaksi) {
        call = service.getSurveyKeluarga(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyKeluargaResponse>() {
            @Override
            public void onResponse(Call<SurveyKeluargaResponse> call, Response<SurveyKeluargaResponse> response) {
                Log.d(LOG_TAG, "getSurveyKeluarga.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyKeluargaSuccess(response.body());
                        } else {
                            callback.onGetSurveyKeluargaFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyKeluargaSuccess(null);
                        } else {
                            callback.onGetSurveyKeluargaFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyKeluargaResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyKeluarga.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyKeluargaFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveSurveyKeluarga(BiodataModel biodataModel, SurveyKeluargaModel dataModel, List<SurveyKeluargaDetailModel> detailModels) {
        SurveyKeluargaRequest request = new SurveyKeluargaRequest(biodataModel, dataModel, detailModels);
        callSubmit = service.saveSurveyKeluarga(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveSurveyKeluarga.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyKeluargaSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyKeluargaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyKeluargaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveSurveyKeluarga.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveSurveyKeluargaFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void submitCheckSIDKeluarga(final BiodataModel model) {
        CheckSIDRequest request = new CheckSIDRequest(model);
        Call callSaveData = service.sendCheckSIDKeluarga(request);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "submitCheckSID.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onCheckSIDKeluargaSuccess(statusMsg);
                        } else {
                            callback.onCheckSIDKeluargaFailed(new Throwable("Check SID Failed\n" + statusMsg));
                        }
                    } else {
                        callback.onCheckSIDKeluargaFailed(new Throwable("Check SID Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "submitCheckSID.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckSIDKeluargaFailed(new Throwable("Check SID Failed\n" + (t != null ? t.getMessage() : "")));
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
