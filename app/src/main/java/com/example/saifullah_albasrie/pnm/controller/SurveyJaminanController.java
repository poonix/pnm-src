package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyJaminanCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyKeluargaCallback;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJaminanModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaDetailModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyJaminanRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeluargaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJaminanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterBuktiKepemilikanAgunanResponse;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyJaminanController {

    private final String LOG_TAG = SurveyJaminanController.class.getSimpleName();

    private SurveyJaminanCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyJaminanResponse> call;
    private Call<BaseResponse> callSubmit;
    private Call<MasterBuktiKepemilikanAgunanResponse> callBukti;

    public SurveyJaminanController(SurveyJaminanCallback callback) {
        this.callback = callback;
    }

    public void getSurveyJaminan(int idJaminan) {
        call = service.getSurveyJaminan(idJaminan);
        call.enqueue(new Callback<SurveyJaminanResponse>() {
            @Override
            public void onResponse(Call<SurveyJaminanResponse> call, Response<SurveyJaminanResponse> response) {
                Log.d(LOG_TAG, "getSurveyJaminan.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getJaminanModelList()!= null && response.body().getJaminanModelList().size() > 0) {
                                callback.onGetSurveyJaminanSuccess(response.body().getJaminanModelList().get(0));
                            } else {
                                callback.onGetSurveyJaminanSuccess(null);
                            }
                        } else {
                            callback.onGetSurveyJaminanFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyJaminanSuccess(null);
                        } else {
                            callback.onGetSurveyJaminanFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyJaminanResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyJaminan.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyJaminanFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveSurveyJaminan(BiodataModel biodataModel, SurveyJaminanModel dataModel) {
        SurveyJaminanRequest request = new SurveyJaminanRequest(biodataModel, dataModel);
        callSubmit = service.saveSurveyJaminan(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveSurveyJaminan.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyJaminanSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyJaminanFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyJaminanFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveSurveyJaminan.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveSurveyJaminanFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void getBuktiKepemilikanAgunan(int idJenis) {
        callBukti = service.getMasterBuktiKepemilikanAngunanResponse(idJenis);
        callBukti.enqueue(new Callback<MasterBuktiKepemilikanAgunanResponse>() {
            @Override
            public void onResponse(Call<MasterBuktiKepemilikanAgunanResponse> call, Response<MasterBuktiKepemilikanAgunanResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetBuktiKepemilikanSuccess(response.body().getList());
                        } else {
                            callback.onGetBuktiKepemilikanFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onGetBuktiKepemilikanFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<MasterBuktiKepemilikanAgunanResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                if (callback != null) {
                    callback.onGetBuktiKepemilikanFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
        if (callSubmit != null)
            callSubmit.cancel();
        if (callBukti != null)
            callBukti.cancel();
    }
}
