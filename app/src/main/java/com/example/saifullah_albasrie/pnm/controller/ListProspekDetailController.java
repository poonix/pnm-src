package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.ListProspekDetailCallback;
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

public class ListProspekDetailController {

    private final String LOG_TAG = ListProspekDetailController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private ListProspekDetailCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<ProspekListResponse> call;

    public ListProspekDetailController(ListProspekDetailCallback callback) {
        this.callback = callback;
    }

    public void getProspekDetailList(int page) {
        UserModel userModel = appPreference.getUserLoggedIn();
        if (userModel == null) {
            return;
        }

        if (appPreference.getUserType() == UserType.MANAGER_UNIT) {
            call = service.getListProspekDetailForMU(userModel.getKodeCabang(), userModel.getKodeUnit(), page);
        } else {
            call = service.getListProspekDetail(userModel.getIdsdm(), page);
        }
        //call = service.getListProspekDetail(ApiConstant.GET_LIST_PROSPEK_DETAIL, appPreference.getUserLoggedIn().getIdsdm());
        call.enqueue(new Callback<ProspekListResponse>() {
            @Override
            public void onResponse(Call<ProspekListResponse> call, Response<ProspekListResponse> response) {
                Log.d(LOG_TAG, "getProspekDetailList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListProspekDetailSuccess(response.body().getListItems());
                        } else {
                            callback.onGetListProspekDetailFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListProspekDetailSuccess(null);
                        } else {
                            callback.onGetListProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProspekListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getProspekDetailList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
