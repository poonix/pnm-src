package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.HistoricalListCallback;
import com.example.saifullah_albasrie.pnm.callback.ListProspekCallback;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.HistoricalListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProspekListResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class HistoricalListController {

    private final String LOG_TAG = HistoricalListController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private HistoricalListCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<HistoricalListResponse> call;

    public HistoricalListController(HistoricalListCallback callback) {
        this.callback = callback;
    }

    public void getHistoricalList(int page) {
        if (appPreference.getUserType() == UserType.MANAGER_UNIT) {
            call = service.getListHistoricalForMU(appPreference.getUserLoggedIn().getKodeUnit(), appPreference.getUserLoggedIn().getKodeCabang(), page);
        } else {
            call = service.getListHistorical(appPreference.getUserLoggedIn().getIdsdm(), page);
        }
        call.enqueue(new Callback<HistoricalListResponse>() {
            @Override
            public void onResponse(Call<HistoricalListResponse> call, Response<HistoricalListResponse> response) {
                Log.d(LOG_TAG, "getHistoricalList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListHistoricalSuccess(response.body().getListItems());
                        } else {
                            callback.onGetListHistoricalFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListHistoricalSuccess(null);
                        } else {
                            callback.onGetListHistoricalFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<HistoricalListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getHistoricalList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListHistoricalFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
