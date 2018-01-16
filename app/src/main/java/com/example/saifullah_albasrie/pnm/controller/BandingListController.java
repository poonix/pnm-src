package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.BandingListCallback;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.BandingListResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class BandingListController {

    private final String LOG_TAG = BandingListController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private BandingListCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<BandingListResponse> call;

    public BandingListController(BandingListCallback callback) {
        this.callback = callback;
    }

    public void getBandingList(int page) {
        call = service.getListBanding(appPreference.getUserLoggedIn().getIdsdm(), page);
        call.enqueue(new Callback<BandingListResponse>() {
            @Override
            public void onResponse(Call<BandingListResponse> call, Response<BandingListResponse> response) {
                Log.d(LOG_TAG, "getBandingList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListBandingSuccess(response.body().getFeedbackItemModels());
                        } else {
                            callback.onGetListBandingFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListBandingSuccess(null);
                        } else {
                            callback.onGetListBandingFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BandingListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getBandingList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListBandingFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
