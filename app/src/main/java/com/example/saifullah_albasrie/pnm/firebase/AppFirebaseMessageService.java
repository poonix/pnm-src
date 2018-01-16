package com.example.saifullah_albasrie.pnm.firebase;

import android.util.Log;

import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by saifullahalbasrie on 4/7/17.
 */

public class AppFirebaseMessageService extends FirebaseMessagingService {

    private static final String TAG = AppFirebaseMessageService.class.getSimpleName();
    public static final String TYPE_PROSPEK = "detail_prospek";
    public static final String TYPE_SURVEY = "survey";
    public static final String TYPE_FORCE_LOGOUT = "force_logout";

    private static final String HEADER_TAG = "tag";
    private static final String HEADER_TITLE = "title";
    private static final String HEADER_MESSAGE = "message";
    private static final String HEADER_ITEM_PROSPEK = "prospek";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived \n" + remoteMessage);
        if (remoteMessage.getData().size() > 0) {
            String tag = remoteMessage.getData().get(HEADER_TAG);
            String title = remoteMessage.getData().get(HEADER_TITLE);
            String msg = remoteMessage.getData().get(HEADER_MESSAGE);
            String sJson = remoteMessage.getData().get(HEADER_ITEM_PROSPEK);
            AppNotificationManager.showNotification(this, tag, title, msg, sJson);

        }
    }
}
