package com.example.saifullah_albasrie.pnm.firebase;

import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.request.FirebaseIDRequest;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 4/7/17.
 */

public class AppFirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = AppFirebaseIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        Log.d(TAG, "onTokenRefresh");
        FirebaseInstanceId instanceId = FirebaseInstanceId.getInstance();
        if (instanceId != null) {
            String fcmId = instanceId.getToken();
            AppPreference.getInstance().setFcmId(fcmId);
            sendFirebaseIdToServer(fcmId);
        }
    }

    private static void sendFirebaseIdToServer(final String fcmId) {
        final AppPreference preference = AppPreference.getInstance();
        if (preference.getUserLoggedIn() == null) {
            Log.e(TAG, "sendFirebaseIdToServer failed. User not login yet ");
            AppPreference.getInstance().setFcmNeedToResend(true);
            return;
        }

        String idSdm = preference.getUserLoggedIn().getIdsdm();
        FirebaseIDRequest request = new FirebaseIDRequest(idSdm, fcmId);
        Call<BaseResponse> call = RestHelper.getInstance().getRestService().sendFcmId(request);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(TAG, "sendFirebaseIdToServer.onResponse : " + response.body());
                if (response != null && response.body() != null && response.body().isSuccessResponse()) {
                    preference.setFcmNeedToResend(false);
                } else {
                    preference.setFcmNeedToResend(true);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(TAG, "sendFirebaseIdToServer.onFailure : " + t.getMessage());
                preference.setFcmNeedToResend(true);
            }
        });
    }

    private static String getDeviceFcmId() {
        final AppPreference preference = AppPreference.getInstance();
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        String olFcmId = preference.getInstance().getFcmId();
        if (instance != null) {
            String newFcmId = instance.getToken();
            if (TextUtils.isEmpty(olFcmId) || (!TextUtils.isEmpty(newFcmId) && !newFcmId.equals(olFcmId))) {
                preference.setFcmId(newFcmId);
                preference.setFcmNeedToResend(true);
                return newFcmId;
            }

            return olFcmId;
        }

        return olFcmId;
    }

    public static void resendFcmId() {
        final AppPreference preference = AppPreference.getInstance();
        String fcmId = getDeviceFcmId();
        if (!TextUtils.isEmpty(fcmId) && preference.getFcmNeedToResend()) {
            sendFirebaseIdToServer(fcmId);
        }
    }

}
