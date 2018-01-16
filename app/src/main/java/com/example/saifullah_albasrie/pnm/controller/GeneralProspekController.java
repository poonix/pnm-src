package com.example.saifullah_albasrie.pnm.controller;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.GeneralProspekCallback;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalProspekRequest;
import com.example.saifullah_albasrie.pnm.rest.response.AutoSaveResponse;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class GeneralProspekController {

    private final String LOG_TAG = GeneralProspekController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private GeneralProspekCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<GeneralProspekResponse> callGeneral;
    private Call<BaseResponse> callSaveData;
    private Call<AutoSaveResponse> callAutosave;

    public GeneralProspekController(GeneralProspekCallback callback) {
        this.callback = callback;
    }

    public void getGeneralProspek(String idDebitur, String idTransaksi) {
        Log.d(LOG_TAG, "getGeneralProspek : " + idDebitur + " ; " + idTransaksi);

        callGeneral = service.getGeneralProspek(idDebitur, idTransaksi);
        callGeneral.enqueue(new Callback<GeneralProspekResponse>() {
            @Override
            public void onResponse(Call<GeneralProspekResponse> call, Response<GeneralProspekResponse> response) {
                Log.d(LOG_TAG, "getGeneralProspek.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetGeneralProspekSuccess(response.body().getBiodata(), response.body().getReferensi(), response.body().getJadwal());
                        } else {
                            callback.onGetGeneralProspekFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetGeneralProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.data_not_found)));
                        } else {
                            callback.onGetGeneralProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + response.message()));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GeneralProspekResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getGeneralProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetGeneralProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveProspek(GeneralProspekResponse model) {
        if(model != null && model.getBiodata() != null && model.getBiodata().size() > 0) {
            model.getBiodata().get(0).setIdSdm(appPreference.getUserLoggedIn().getIdsdm());
            model.getBiodata().get(0).setKodeCabang(appPreference.getUserLoggedIn().getKodeCabang());
            model.getBiodata().get(0).setKodeUnit(appPreference.getUserLoggedIn().getKodeUnit());
        }
        callSaveData = service.saveProspek(model);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
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
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    //callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                    callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }

    public void editProspek(GeneralProspekResponse model) {
        if(model != null && model.getBiodata() != null && model.getBiodata().size() > 0) {
            model.getBiodata().get(0).setIdSdm(appPreference.getUserLoggedIn().getIdsdm());
            model.getBiodata().get(0).setKodeCabang(appPreference.getUserLoggedIn().getKodeCabang());
            model.getBiodata().get(0).setKodeUnit(appPreference.getUserLoggedIn().getKodeUnit());
        }
        callSaveData = service.editProspek(model);
        callSaveData.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "editProspek.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProspekSuccess(statusMsg);
                        } else {
                            callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "editProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    //callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                    callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }

    public void autosaveProspek(GeneralProspekResponse model) {
        cancelAutosave();

        if(model != null && model.getBiodata() != null && model.getBiodata().size() > 0) {
            model.getBiodata().get(0).setIdSdm(appPreference.getUserLoggedIn().getIdsdm());
            model.getBiodata().get(0).setKodeCabang(appPreference.getUserLoggedIn().getKodeCabang());
            model.getBiodata().get(0).setKodeUnit(appPreference.getUserLoggedIn().getKodeUnit());
        }
        callAutosave = service.autosaveProspek(model);
        callAutosave.enqueue(new Callback<AutoSaveResponse>() {
            @Override
            public void onResponse(Call<AutoSaveResponse> call, Response<AutoSaveResponse> response) {
                Log.d(LOG_TAG, "autosaveProspek.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onAutoSaveProspekSuccess(response.body().getIdDebitur(), response.body().getIdTransaksiDebitur());
                        } else {
                            callback.onAutoSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onAutoSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<AutoSaveResponse> call, Throwable t) {
                Log.d(LOG_TAG, "autosaveProspek.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null && !call.isCanceled()) {
                    callback.onAutoSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }

    public void cancelAutosave() {
        if (callAutosave != null) {
            callAutosave.cancel();
        }
    }
    public void cancel() {
        if (callGeneral != null)
            callGeneral.cancel();
        if (callSaveData != null)
            callSaveData.cancel();
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
}
