package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.callback.CheckRiwayatAngsuranCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.HistoryAngsuranListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 10/1/17.
 */

public class CheckRiwayatAngsuranController {

    private final String LOG_TAG = CheckRiwayatAngsuranController.class.getSimpleName();

    private CheckRiwayatAngsuranCallback callback;

    private RestService service = RestHelper.getInstanceNoAuth().getRestService();

    //private Call<List<RiwayatAngsuran>> call;
    private Call<HistoryAngsuranListResponse> call;

    public CheckRiwayatAngsuranController(CheckRiwayatAngsuranCallback callback) {
        this.callback = callback;
    }

    public void checkRiwayatAngsuran(final String idNasabahPNM) {
        Log.d(LOG_TAG, "checkRiwayatAngsuran : " + idNasabahPNM);
        //call = service.getListRiwayatAngsuran(ApiConstant.GET_HISTORY_PEMBIAYAAN, noRekDebitur);
        call = service.getListRiwayatAngsuran(idNasabahPNM);
        call.enqueue(new Callback<HistoryAngsuranListResponse>() {
            @Override
            public void onResponse(Call<HistoryAngsuranListResponse> call, Response<HistoryAngsuranListResponse> response) {
                Log.d(LOG_TAG, "checkRiwayatAngsuran.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onCheckRiwayatAngsuranSuccess(response.body().getData());
                    } else {
                        callback.onCheckRiwayatAngsuranFailed(new Throwable("Riwayat Angsuran gagal diambil"));
                    }
                }
            }

            @Override
            public void onFailure(Call<HistoryAngsuranListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "checkRiwayatAngsuran.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckRiwayatAngsuranFailed(new Throwable("Riwayat Angsuran gagal diambil\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
        /*call.enqueue(new Callback<List<RiwayatAngsuran>>() {
            @Override
            public void onResponse(Call<List<RiwayatAngsuran>> call, Response<List<RiwayatAngsuran>> response) {
                Log.d(LOG_TAG, "checkRiwayatAngsuran.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onCheckRiwayatAngsuranSuccess(response.body());
                    } else {
                        callback.onCheckRiwayatAngsuranFailed(new Throwable("Riwayat Angsuran gagal diambil"));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RiwayatAngsuran>> call, Throwable t) {
                Log.d(LOG_TAG, "checkRiwayatAngsuran.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckRiwayatAngsuranFailed(new Throwable("check Riwayat Angsuran\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });*/
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
