package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.ListProspekCallback;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.ProspekListResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class ListProspekController {

    private final String LOG_TAG = ListProspekController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private ListProspekCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<ProspekListResponse> call;

    public ListProspekController(ListProspekCallback callback) {
        this.callback = callback;
    }

    public void getProspekList(int page) {
        UserModel userModel = appPreference.getUserLoggedIn();
        if (userModel == null) {
            return;
        }

        if (appPreference.getUserType() == UserType.MANAGER_UNIT) {
            call = service.getListProspekDetailForMU(userModel.getKodeCabang(), userModel.getKodeUnit(), page);
        } else {
            call = service.getListProspek(userModel.getIdsdm(), page);
        }
        //call = service.getListProspek(userModel.getIdsdm(), page);
        call.enqueue(new Callback<ProspekListResponse>() {
            @Override
            public void onResponse(Call<ProspekListResponse> call, Response<ProspekListResponse> response) {
                Log.d(LOG_TAG, "getProspekList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListProspekSuccess(response.body().getListItems());
                        } else {
                            callback.onGetListProspekFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListProspekSuccess(null);
                        } else {
                            callback.onGetListProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProspekListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getProspekList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
