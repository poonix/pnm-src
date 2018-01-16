package com.example.saifullah_albasrie.pnm.controller;

import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CollectionListCallback;
import com.example.saifullah_albasrie.pnm.callback.ListProspekCallback;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProspekListResponse;
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

public class CollectionListController {

    private final String LOG_TAG = CollectionListController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private CollectionListCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<CollectionListResponse> call;

    public CollectionListController(CollectionListCallback callback) {
        this.callback = callback;
    }

    public void getCollectionList(int page) {
        String url = appPreference.getString(AppPreference.API_GET_LIST_COLLECTION);
        if (TextUtils.isEmpty(url)) {
            url = ApiConstant.GET_LIST_COLLECTION;
        }
        call = service.getCollectionList(url, AppPreference.getInstance().getUserLoggedIn().getKodeUnit(), page);
        call.enqueue(new Callback<CollectionListResponse>() {
            @Override
            public void onResponse(Call<CollectionListResponse> call, Response<CollectionListResponse> response) {
                Log.d(LOG_TAG, "getCollectionList.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = MyApplication.getContext().getString(R.string.data_failed);
                        if (response.body().getStatus() == 1) {
                            callback.onGetListCollectionSuccess(response.body().getData());
                        } else {
                            callback.onGetListCollectionFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetListCollectionSuccess(null);
                        } else {
                            callback.onGetListCollectionFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CollectionListResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getCollectionList.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onGetListCollectionFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n"  + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    private List<PnmDebiturModel> filterData(List<PnmDebiturModel> models) {
        List<PnmDebiturModel> filtered = new ArrayList<>();

        return filtered;
    }
    
    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
