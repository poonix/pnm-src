package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.ListSurveyCallback;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyListResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class ListSurveyController {

    private final String LOG_TAG = ListSurveyController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private ListSurveyCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyListResponse> call;

    public ListSurveyController(ListSurveyCallback callback) {
        this.callback = callback;
    }

    public void getSurveyList(int page) {
        UserModel userModel = appPreference.getUserLoggedIn();
        if (userModel == null) {
            return;
        }

        if (appPreference.getUserType() == UserType.MANAGER_UNIT) {
            call = service.getListPengajuan(userModel.getKodeCabang(), userModel.getKodeUnit(), page);
        } else {
            call = service.getListSurvey(userModel.getIdsdm(), page);
        }

        call.enqueue(new Callback<SurveyListResponse>() {
            @Override
            public void onResponse(Call<SurveyListResponse> call, Response<SurveyListResponse> response) {
                Log.d(LOG_TAG, "getSurveyList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetListSurveySuccess(response.body().getListItems());
                        } else {
                            callback.onGetListSurveyFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListSurveySuccess(null);
                        } else {
                            callback.onGetListSurveyFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListSurveyFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
