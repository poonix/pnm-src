package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CheckSIDCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyChecklistCallback;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalPengajuanRequest;
import com.example.saifullah_albasrie.pnm.rest.request.CheckSIDRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyPengajuanRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyChecklistResponse;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 5/13/17.
 */

public class CheckSIDController {

    private final String LOG_TAG = CheckSIDController.class.getSimpleName();

    private CheckSIDCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<BaseResponse> call;

    public CheckSIDController(CheckSIDCallback callback) {
        this.callback = callback;
    }

    public void submitCheckSID(final BiodataModel model) {
        CheckSIDRequest request = new CheckSIDRequest(model);
        call = service.sendCheckSID(request);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "submitCheckSID.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onCheckSIDSuccess(statusMsg);
                        } else {
                            callback.onCheckSIDFailed(new Throwable("Check SID Failed\n" + statusMsg));
                        }
                    } else {
                        callback.onCheckSIDFailed(new Throwable("Check SID Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "submitCheckSID.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onCheckSIDFailed(new Throwable("Check SID Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
