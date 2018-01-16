package com.example.saifullah_albasrie.pnm.utils;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/22/17.
 */

public class PermissionUtil {

    public static final int REQUEST_PERMISSION_GPS = 500;
    public static final int REQUEST_READ_EXTERNAL_STORAGE = 501;


    public static void requestPermission(Activity activity, String[] permission, int code){
        ActivityCompat.requestPermissions(activity,permission, code);
    }

    public static void addPermission(Activity activity, String permission,List<String> permissionsList) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
        }
    }

    public static boolean isPermissionGpsGranted(Context context) {
        if (context == null)
            return true;

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return false;
        }
        return true;
    }

    public static boolean checkGPSPermission(Activity activity){
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            List<String> permissionsList = new ArrayList<>();
            addPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION, permissionsList);
            addPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION, permissionsList);
            if (permissionsList.size() > 0) {
                requestPermission(activity, permissionsList.toArray(new String[permissionsList.size()]), REQUEST_PERMISSION_GPS);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean checkPermissionStorage(final Context context)
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion >= android.os.Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("External storage permission is necessary");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static boolean isPermissionStorageGranted (Context context) {
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }



}