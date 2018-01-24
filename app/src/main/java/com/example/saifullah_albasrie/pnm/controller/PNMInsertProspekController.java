package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.GeneralProspekCallback;
import com.example.saifullah_albasrie.pnm.callback.PNMInsertProspekCallback;
import com.example.saifullah_albasrie.pnm.model.production_model.InsertProspekModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.BasePostPNMResponse;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by indri on 1/24/18.
 */

public class PNMInsertProspekController {
    private final String LOG_TAG = GeneralProspekController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private PNMInsertProspekCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<BasePostPNMResponse> callSaveData;

    public PNMInsertProspekController(PNMInsertProspekCallback callback) {
        this.callback = callback;
    }

    public void saveProspek(InsertProspekModel model) {
        callSaveData = service.PostProspek(model);
        callSaveData.enqueue(new Callback<BasePostPNMResponse>() {
            @Override
            public void onResponse(Call<BasePostPNMResponse> call, Response<BasePostPNMResponse> response) {
                Log.d(LOG_TAG, "saveProspek.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProspekSuccess(statusMsg);
                        } else {
                            callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BasePostPNMResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    //callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                    callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }
}
