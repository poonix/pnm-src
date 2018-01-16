package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyJenisUsahaCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyKebutuhanModalKerjaCallback;
import com.example.saifullah_albasrie.pnm.model.AssetModel;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.KebutuhanModalKerjaModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.KebutuhanModalKerjaRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyJenisUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KebutuhanModalKerjaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJenisUsahaResponse;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class SurveyKebutuhanModalKerjaController {

    private final String LOG_TAG = SurveyKebutuhanModalKerjaController.class.getSimpleName();

    private SurveyKebutuhanModalKerjaCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<KebutuhanModalKerjaResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyKebutuhanModalKerjaController(SurveyKebutuhanModalKerjaCallback callback) {
        this.callback = callback;
    }

    public void getSurveyKMK(String idDebitur, String idTransaksi) {
        call = service.getSurveyKMK(idDebitur, idTransaksi);
        call.enqueue(new Callback<KebutuhanModalKerjaResponse>() {
            @Override
            public void onResponse(Call<KebutuhanModalKerjaResponse> call, Response<KebutuhanModalKerjaResponse> response) {
                Log.d(LOG_TAG, "getSurveyKMK.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyKMKSuccess(response.body());
                        } else {
                            callback.onGetSurveyKMKFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyKMKSuccess(null);
                        } else {
                            callback.onGetSurveyKMKFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<KebutuhanModalKerjaResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyKMK.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyKMKFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveKMK(BiodataModel biodataModel, KebutuhanModalKerjaModel dataModel, List<AssetModel> assetModels) {
        KebutuhanModalKerjaRequest request = new KebutuhanModalKerjaRequest(biodataModel, dataModel, assetModels);
        callSubmit = service.saveSurveyKMK(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveKMK.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveSurveyKMKSuccess(statusMsg);
                        } else {
                            callback.onSaveSurveyKMKFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveSurveyKMKFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveKMK.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveSurveyKMKFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
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
