package com.example.saifullah_albasrie.pnm.controller;

import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.callback.CheckDebiturCallback;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CheckDebiturResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class CheckDebiturController {

    private final String LOG_TAG = CheckDebiturController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private CheckDebiturCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<CheckDebiturResponse> call;

    public CheckDebiturController(CheckDebiturCallback callback) {
        this.callback = callback;
    }

    public void checkDebitur(int type, String keyword) {
        String url;
        switch (type) {
            case  1:
                url = appPreference.getString(AppPreference.API_CHECK_DEBITUR_BY_NAME);
                if (TextUtils.isEmpty(url)) {
                    url = ApiConstant.CHECK_DEBITUR_BY_NAME;
                }
                break;
            case  2:
                url = appPreference.getString(AppPreference.API_CHECK_DEBITUR_BY_NOMOR_REKEKING);
                if (TextUtils.isEmpty(url)) {
                    url = ApiConstant.CHECK_DEBITUR_BY_NOMOR_REKEKING;
                }
                break;
            case  3:
                url = appPreference.getString(AppPreference.API_CHECK_DEBITUR_BY_IBU_KANDUNG);
                if (TextUtils.isEmpty(url)) {
                    url = ApiConstant.CHECK_DEBITUR_BY_IBU_KANDUNG;
                }
                break;
            case  4:
                url = appPreference.getString(AppPreference.API_CHECK_DEBITUR_BY_TANGGAL_LAHIR);
                if (TextUtils.isEmpty(url)) {
                    url = ApiConstant.CHECK_DEBITUR_BY_TANGGAL_LAHIR;
                }
                break;
            default:
                url = appPreference.getString(AppPreference.API_CHECK_DEBITUR_BY_NAME);
                if (TextUtils.isEmpty(url)) {
                    url = ApiConstant.CHECK_DEBITUR_BY_NAME;
                }
                break;
        }
        call = service.checkDebitur(url, keyword);
        call.enqueue(new Callback<CheckDebiturResponse>() {
            @Override
            public void onResponse(Call<CheckDebiturResponse> call, Response<CheckDebiturResponse> response) {
                Log.d(LOG_TAG, "checkDebitur.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        if (response.body().getStatus() == 1 && response.body().getDebiturModelList().size() > 0) {
                            callback.onCheckDebiturSuccess(response.body().getDebiturModelList());
                        } else {
                            callback.onCheckDebiturFailed(new Throwable("Data tidak ditemukan"));
                        }
                    } else {
                        callback.onCheckDebiturFailed(new Throwable("Check Debitur Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckDebiturResponse> call, Throwable t) {
                Log.d(LOG_TAG, "checkDebitur.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckDebiturFailed(new Throwable("Check Debitur Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }





    public void checkIDI(String nama,String ibu,String tgl_lahir,String tempat_lahir,String jenis_kelamin,String jenis_identitas,String nomor_identitas) {
        String url;
        url = ApiConstant.CHECK_IDI;
        call = service.checkIDI(url, nama,ibu,tgl_lahir,tempat_lahir,jenis_kelamin,jenis_identitas,nomor_identitas);
        call.enqueue(new Callback<CheckDebiturResponse>() {
            @Override
            public void onResponse(Call<CheckDebiturResponse> call, Response<CheckDebiturResponse> response) {
                Log.d(LOG_TAG, "checkDebitur.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        if (response.body().getStatus() == 1 && response.body().getDebiturModelList().size() > 0) {
                            callback.onCheckDebiturSuccess(response.body().getDebiturModelList());
                        } else {
                            callback.onCheckDebiturFailed(new Throwable("Data tidak ditemukan"));
                        }
                    } else {
                        callback.onCheckDebiturFailed(new Throwable("Check Debitur Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckDebiturResponse> call, Throwable t) {
                Log.d(LOG_TAG, "checkDebitur.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckDebiturFailed(new Throwable("Check Debitur Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }





    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
