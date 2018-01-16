package com.example.saifullah_albasrie.pnm.controller;

import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CollectionDetailCallback;
import com.example.saifullah_albasrie.pnm.callback.CollectionListCallback;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.request.CollectionRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/26/17.
 */

public class CollectionDetailController {

    private final String LOG_TAG = CollectionDetailController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private CollectionDetailCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<CollectionResponse> call;
    private Call<BaseResponse> callSubmit;

    public CollectionDetailController(CollectionDetailCallback callback) {
        this.callback = callback;
    }

    public void getCollectionDetail(String idDebitur) {
        call = service.getCollectionDetail(idDebitur);
        call.enqueue(new Callback<CollectionResponse>() {
            @Override
            public void onResponse(Call<CollectionResponse> call, Response<CollectionResponse> response) {
                Log.d(LOG_TAG, "getCollectionDetail.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = MyApplication.getContext().getString(R.string.data_failed);
                        if (response.body().isSuccessResponse()) {
                            if (response.body().getCollectionModels() != null && response.body().getCollectionModels().size() > 0) {
                                callback.onGetCollectionDetailSuccess(response.body().getCollectionModels().get(0));
                            } else {
                                callback.onGetCollectionDetailSuccess(null);
                            }
                        } else {
                            callback.onGetCollectionDetailFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetCollectionDetailSuccess(null);
                        } else {
                            callback.onGetCollectionDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CollectionResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getCollectionDetail.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetCollectionDetailFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void saveCollectionDetail(CollectionRequest request) {
        callSubmit = service.saveCollectionDetail(request);
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "saveCollectionDetail.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveCollectionSuccess(statusMsg);
                        } else {
                            callback.onSaveCollectionFailed(new Throwable(statusMsg));
                        }
                    } else {
                        callback.onSaveCollectionFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveCollectionDetail.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveCollectionFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }
    
    public void cancel() {
        if (call != null) {
            call.cancel();
        }
        if (callSubmit != null) {
            callSubmit.cancel();
        }
    }
}
