package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.callback.ListProspekCallback;
import com.example.saifullah_albasrie.pnm.callback.LogoutCallback;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProspekListResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class LogoutController {

    private final String LOG_TAG = LogoutController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private LogoutCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<BaseResponse> call;

    public LogoutController(LogoutCallback callback) {
        this.callback = callback;
    }

    public void logout() {
        UserModel userModel = appPreference.getUserLoggedIn();
        if (userModel == null) {
            if (callback != null) {
                callback.onLogoutSuccess();
            }
            return;
        }
        call = service.logout(appPreference.getUserLoggedIn().getIdsdm());
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "logout.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onLogoutSuccess();
                        } else {
                            callback.onLogoutFailed(new Throwable("Logout Failed\n" + errMsg));
                        }
                    } else {
                        callback.onLogoutFailed(new Throwable("Logout Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "logout.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onLogoutFailed(new Throwable("Logout Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
