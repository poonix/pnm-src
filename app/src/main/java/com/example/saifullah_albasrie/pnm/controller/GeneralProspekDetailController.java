package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.GeneralProspekDetailCallback;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalProspekRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekDetailResponse;
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

public class GeneralProspekDetailController {

    private final String LOG_TAG = GeneralProspekDetailController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private GeneralProspekDetailCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<GeneralProspekDetailResponse> callGeneral;
    private Call<BaseResponse> callSaveData;

    public GeneralProspekDetailController(GeneralProspekDetailCallback callback) {
        this.callback = callback;
    }

    public void getGeneralProspekDetail(String idDebitur, String idTransaksi) {
        Log.d(LOG_TAG, "getGeneralProspekDetail : " + idDebitur + " ; " + idTransaksi);

        if (appPreference.getUserType() == UserType.MANAGER_UNIT) {
            callGeneral = service.getGeneralProspekDetailForMU(idDebitur, idTransaksi);
        } else {
            callGeneral = service.getGeneralProspekDetail(idDebitur, idTransaksi);
        }
        //callGeneral = service.getGeneralProspekDetail(ApiConstant.GET_GENERAL_PROSPEK_DETAIL, idDebitur, idTransaksi);
        callGeneral.enqueue(new Callback<GeneralProspekDetailResponse>() {
            @Override
            public void onResponse(Call<GeneralProspekDetailResponse> call, Response<GeneralProspekDetailResponse> response) {
                Log.d(LOG_TAG, "getGeneralProspekDetail.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetGeneralProspekDetailSuccess(response.body().getBiodata(),
                                    response.body().getKontakModelList(),
                                    response.body().getReferensi(),
                                    response.body().getJadwal(),
                                    response.body().getAlamatModelList(),
                                    response.body().getKeluargaModelList(),
                                    response.body().getAplikasiModelList(),
                                    response.body().getRencanaAgunanModelList(),
                                    response.body().getLainnyaModelList()
                            );
                        } else {
                            callback.onGetGeneralProspekDetailFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetGeneralProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_not_found)));
                        } else {
                            callback.onGetGeneralProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + response.message()));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GeneralProspekDetailResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getGeneralProspekDetail.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetGeneralProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    /*
    public void saveProspekDetail(GeneralProspekDetailResponse model) {
        if(model != null && model.getBiodata() != null && model.getBiodata().size() > 0) {
            model.getBiodata().get(0).setIdSdm(appPreference.getUserLoggedIn().getIdsdm());
        }
        callSaveData = service.saveProspekDetail(ApiConstant.SAVE_PROSPEK, model);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveProspekDetail.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProspekSuccess(statusMsg);
                        } else {
                            callback.onSaveProspekFailed(new Throwable("Save Prospek Detail Failed\n" + statusMsg));
                        }
                    } else {
                        callback.onGetGeneralProspekFailed(new Throwable("Save Prospek Detail Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveProspekFailed(new Throwable("Save Prospek Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }*/

    public void editProspekDetail(GeneralProspekDetailResponse model) {
        if(model != null && model.getBiodata() != null && model.getBiodata().size() > 0) {
            model.getBiodata().get(0).setIdSdm(appPreference.getUserLoggedIn().getIdsdm());
            model.getBiodata().get(0).setKodeCabang(appPreference.getUserLoggedIn().getKodeCabang());
            model.getBiodata().get(0).setKodeUnit(appPreference.getUserLoggedIn().getKodeUnit());
        }
        callSaveData = service.saveProspekDetail(model);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "editProspek.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProspekDetailSuccess(statusMsg);
                        } else {
                            callback.onSaveProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + statusMsg));
                        }
                    } else {
                        callback.onGetGeneralProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "editProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    //callback.onSaveProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                    callback.onSaveProspekDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }

    public void submitApproval(final ApprovalProspekModel model) {
        ApprovalProspekRequest request = new ApprovalProspekRequest();
        List<ApprovalProspekModel> list = new ArrayList();
        list.add(model);
        request.setApprovalProspekModelList(list);
        callSaveData = service.sendApproval(request);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "submitApproval.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSendApprovalSuccess(statusMsg);
                        } else {
                            callback.onSendApprovalFailed(new Throwable("Approval gagal\n" + statusMsg));
                        }
                    } else {
                        callback.onSendApprovalFailed(new Throwable("Approval gagal"));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "submitApproval.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    //callback.onSendApprovalFailed(new Throwable("Approval gagal\n" + (t != null ? t.getMessage() : "")));
                    callback.onSendApprovalFailed(new Throwable("Approval gagal!"));
                }
            }
        });
    }

    public void cancel() {
        if (callGeneral != null)
            callGeneral.cancel();
    }
}
