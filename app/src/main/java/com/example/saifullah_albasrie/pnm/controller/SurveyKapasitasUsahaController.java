package com.example.saifullah_albasrie.pnm.controller;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKapasitasUsahaCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.KapasitasUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KapasitasUsahaResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public class SurveyKapasitasUsahaController {

    private final String LOG_TAG = SurveyKapasitasUsahaController.class.getSimpleName();

    private SurveyKapasitasUsahaCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<KapasitasUsahaResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyKapasitasUsahaController(SurveyKapasitasUsahaCallback callback) {
        this.callback = callback;
    }

    public void getKapasitasUsaha(String idDebitur, String idTransaksi) {
        call = service.getSurveyKapasitasUsaha(idDebitur, idTransaksi);
        call.enqueue(new Callback<KapasitasUsahaResponse>() {
            @Override
            public void onResponse(Call<KapasitasUsahaResponse> call, Response<KapasitasUsahaResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getSurveyKapasitasUsahaModelList() != null && response.body().getSurveyKapasitasUsahaModelList().size() > 0) {
                                callback.onGetKapasitasUsahaSuccess(response.body());
                            } else {
                                callback.onGetKapasitasUsahaSuccess(null);
                            }
                        } else {
                            callback.onGetKapsitasUsahaFailure(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetKapasitasUsahaSuccess(null);
                        } else {
                            callback.onGetKapsitasUsahaFailure(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<KapasitasUsahaResponse> call, Throwable t) {
                if (callback != null) {
                    callback.onGetKapsitasUsahaFailure(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveKapasitasUsaha(KapasitasUsahaRequest request) {
        callSubmit = service.saveKapasitasUsaha(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveKapasitasUsahaSuccess(statusMsg);
                        } else {
                            callback.onSaveKapasitasUsahaFailure(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + statusMsg));
                        }
                    } else {
                        callback.onSaveKapasitasUsahaFailure(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                if (callback != null) {
                    callback.onSaveKapasitasUsahaFailure(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
        if (callSubmit != null) {
            callSubmit.cancel();
        }
    }

}
