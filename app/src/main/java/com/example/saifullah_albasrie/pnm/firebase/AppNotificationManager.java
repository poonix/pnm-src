package com.example.saifullah_albasrie.pnm.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.ui.activity.MainActivity;
import com.google.gson.Gson;

/**
 * Created by saifullahalbasrie on 4/7/17.
 */

//Example
    /*
    {
    "to" : "fhYz1LTW5QY:APA91bGdVEMqmQeDkkeMRj9cUotQSWDPoOJ9zb9u6Qzsa13QfIv4ZgTpifvACLNmHNA1pRmIOoqaQBsf_4uK3g18mkOu3gy340bwHuxAFQGSKhLeBU72cwzObflfWNnTiyhylz9Z6mu_",
    "notification" : {
      "body" : "Ada prospek yang butuh approval dari anda",
      "title" : "Need Approval",
      "icon" : "myicon"
    },
    "data" : {
      "tag" : "approval",
      "message" : "Ada prospek yang butuh approval dari anda"
    }
  }
     */

public class AppNotificationManager {

    public static final int INFO_NOTIFICATION_ID = 12345;
    public static final String EXTRA_TAG = "extra_tag";
    public static final String EXTRA_DATA = "extra_prospek";

    public static void showNotification(Context context, String tag, String title, String message, String sJson) {
        Intent notificationIntent = new Intent(context, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TAG, tag);
        try {
            if (!TextUtils.isEmpty(sJson)) {
                ProspekListItemModel model = new Gson().fromJson(sJson, ProspekListItemModel.class);
                bundle.putParcelable(EXTRA_DATA, model);
            }
        }catch (Exception e) {
            Log.e("", e.getMessage());
        }
        notificationIntent.putExtras(bundle);
        PendingIntent contentIntent = PendingIntent.getActivity(context, INFO_NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (TextUtils.isEmpty(title)) {
            title = tag;
        }

        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setTicker(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(contentIntent)
                .setPriority(Notification.PRIORITY_HIGH) // this is will pop up immediately the notification
                .setDefaults(Notification.DEFAULT_ALL);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(INFO_NOTIFICATION_ID, builder.build());
    }


}
