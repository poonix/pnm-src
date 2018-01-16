package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.BandingDetailCallback;
import com.example.saifullah_albasrie.pnm.callback.BandingListCallback;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalBandingRequest;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalPengajuanRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BandingListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class BandingDetailController {

    private final String LOG_TAG = BandingDetailController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private BandingDetailCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<BaseResponse> call;

    public BandingDetailController(BandingDetailCallback callback) {
        this.callback = callback;
    }

    public void sendApprovalBanding(ApprovalProspekModel model) {
        ApprovalBandingRequest request = new ApprovalBandingRequest();
        List<ApprovalProspekModel> list = new ArrayList();
        list.add(model);
        request.setApprovalProspekModelList(list);
        call = service.sendApprovalBanding(request);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "sendApprovalBanding.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSendApprovalSuccess(statusMsg);
                        } else {
                            callback.onSendApprovalFailed(new Throwable("Approval Failed\n" + statusMsg));
                        }
                    } else {
                        callback.onSendApprovalFailed(new Throwable("Approval Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "sendApprovalBanding.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSendApprovalFailed(new Throwable("Approval Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
