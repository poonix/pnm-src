package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.callback.AlamatCallback;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKabupatenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKecamatanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKelurahanResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class AlamatController {

    private final String LOG_TAG = AlamatController.class.getSimpleName();

    //private AppPreference appPreference = AppPreference.getInstance();
    //private DataManager dataManager = DataManager.getInstance();

    private AlamatCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    public AlamatController(AlamatCallback callback) {
        this.callback = callback;
    }

    public AlamatController() { }

    public void setCallback(AlamatCallback callback) {
        this.callback = callback;
    }

    private Call<MasterKabupatenResponse> callKabupaten;
    private Call<MasterKecamatanResponse> callKecamatan;
    private Call<MasterKelurahanResponse> callKelurahan;

    public void getKabupaten(int idProvinsi) {
        callKabupaten = service.getMasterKabupaten(idProvinsi);
        callKabupaten.enqueue(new Callback<MasterKabupatenResponse>() {
            @Override
            public void onResponse(Call<MasterKabupatenResponse> call, Response<MasterKabupatenResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        callback.onGetKabupatenSuccess(response.body().getList());
                    } else {
                        callback.onGetKabupatenFailed(new Throwable("getKabupaten failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<MasterKabupatenResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getKabupaten.onFailure " + t.getMessage());
                if (callback != null) {
                    callback.onGetKabupatenFailed(new Throwable("getKabupaten failed\n" + t.getMessage()));
                }
            }
        });
    }

    public void getKecamatan(int idProvinsi, int idKabupaten) {
        callKecamatan = service.getMasterKecamatan(idProvinsi, idKabupaten);
        callKecamatan.enqueue(new Callback<MasterKecamatanResponse>() {
            @Override
            public void onResponse(Call<MasterKecamatanResponse> call, Response<MasterKecamatanResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        callback.onGetKecamatanSuccess(response.body().getList());
                    } else {
                        callback.onGetKecamatanFailed(new Throwable("getKecamatan failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<MasterKecamatanResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getKecamatan.onFailure " + t.getMessage());
                if (callback != null) {
                    callback.onGetKecamatanFailed(new Throwable("getKecamatan failed\n" + t.getMessage()));
                }
            }
        });
    }

    public void getKelurahan(int idProvinsi, int idKabupaten, int idKecamatan) {
        callKelurahan = service.getMasterKelurahan(idProvinsi, idKabupaten, idKecamatan);
        callKelurahan.enqueue(new Callback<MasterKelurahanResponse>() {
            @Override
            public void onResponse(Call<MasterKelurahanResponse> call, Response<MasterKelurahanResponse> response) {
                if (callback != null) {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        callback.onGetKelurahanSuccess(response.body().getList());
                    } else {
                        callback.onGetKelurahanFailed(new Throwable("getKelurahan failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<MasterKelurahanResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getKelurahan.onFailure " + t.getMessage());
                if (callback != null) {
                    callback.onGetKelurahanFailed(new Throwable("getKelurahan failed\n" + t.getMessage()));
                }
            }
        });
    }

    public void cancelAll() {
        if (callKabupaten != null) {
            callKabupaten.cancel();
        }
        if (callKecamatan != null) {
            callKecamatan.cancel();
        }
        if (callKelurahan != null) {
            callKelurahan.cancel();
        }
    }

}
