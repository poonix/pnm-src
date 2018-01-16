package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.FeedbackListCallback;
import com.example.saifullah_albasrie.pnm.rest.response.FeedbackListResponse;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class FeedbackListController {

    private final String LOG_TAG = FeedbackListController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private FeedbackListCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<FeedbackListResponse> call;

    public FeedbackListController(FeedbackListCallback callback) {
        this.callback = callback;
    }

    public void getFeedbackList(int page) {
        call = service.getListFeedback(appPreference.getUserLoggedIn().getKodeCabang(), appPreference.getUserLoggedIn().getKodeUnit(), page);
        call.enqueue(new Callback<FeedbackListResponse>() {
            @Override
            public void onResponse(Call<FeedbackListResponse> call, Response<FeedbackListResponse> response) {
                Log.d(LOG_TAG, "getFeedbackList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListFeedbackSuccess(response.body().getFeedbackItemModels());
                        } else {
                            callback.onGetListFeedbackFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListFeedbackSuccess(null);
                        } else {
                            callback.onGetListFeedbackFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<FeedbackListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getFeedbackList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListFeedbackFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
