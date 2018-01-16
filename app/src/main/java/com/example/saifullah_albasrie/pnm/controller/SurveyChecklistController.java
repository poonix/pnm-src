package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
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
 * Created by saifullahalbasrie on 3/29/17.
 */

public class SurveyChecklistController {

    private final String LOG_TAG = SurveyChecklistController.class.getSimpleName();

    private SurveyChecklistCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyChecklistResponse> call;

    public SurveyChecklistController(SurveyChecklistCallback callback) {
        this.callback = callback;
    }

    public void getSurveyChecklist(String idDebitur, String idTransaksi) {
        call = service.getSurveyChecklist(idDebitur, idTransaksi);
        call.enqueue(new Callback<SurveyChecklistResponse>() {
            @Override
            public void onResponse(Call<SurveyChecklistResponse> call, Response<SurveyChecklistResponse> response) {
                Log.d(LOG_TAG, "getSurveyChecklist.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getList() != null && response.body().getList().size() > 0) {
                                callback.onGetSurveyChecklistSuccess(response.body().getList().get(0));
                            } else {
                                callback.onGetSurveyChecklistSuccess(null);
                            }
                        } else {
                            callback.onGetSurveyChecklistFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyChecklistSuccess(null);
                        } else {
                            callback.onGetSurveyChecklistFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyChecklistResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyChecklist.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyChecklistFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void submitCheckSID(final BiodataModel model) {
        CheckSIDRequest request = new CheckSIDRequest(model);
        Call callSaveData = service.sendCheckSID(request);
        callSaveData.enqueue(new Callback<BaseResponse>() {
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

    public void submitPengajuanSurvey(final BiodataModel model) {
        SurveyPengajuanRequest request = new SurveyPengajuanRequest(model);
        Call callSaveData = service.sendPengajuanSurvey(request);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "submitPengajuan.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSendPengajuanSuccess(statusMsg);
                        } else {
                            callback.onSendPengajuanFailed(new Throwable("Pengajuan Failed\n" + statusMsg));
                        }
                    } else {
                        callback.onSendPengajuanFailed(new Throwable("Pengajuan Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "submitPengajuan.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSendPengajuanFailed(new Throwable("Pengajuan Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void submitApprovalPengajuan(final ApprovalProspekModel model) {
        ApprovalPengajuanRequest request = new ApprovalPengajuanRequest();
        List<ApprovalProspekModel> list = new ArrayList();
        list.add(model);
        request.setApprovalProspekModelList(list);
        Call callSaveData = service.sendApprovalPengajuan(request);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "submitApprovalPengajuan.onResponse " + (response != null ? response.body():""));
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
                Log.d(LOG_TAG, "submitApprovalPengajuan.onFailure " + (t != null ? t.getMessage():""));
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
