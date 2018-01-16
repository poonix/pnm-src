package com.example.saifullah_albasrie.pnm.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by saifullahalbasrie on 4/12/17.
 */

public class CommonUtil {

    public static void makeCall(Context context, String phoneNumber) {
        try {
            Uri number = Uri.parse("tel:" + phoneNumber);
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            context.startActivity(callIntent);
        }catch (Exception e) {
            WidgetUtil.showToast(context, e.getMessage());
        }
    }

    public static void sendSms(Context context, String phoneNumber) {
        try {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber, null));
            context.startActivity(smsIntent);
        }catch (Exception e) {
            WidgetUtil.showToast(context, e.getMessage());
        }
    }

    public static void sendEmail(Context context, String emailAddress) {
        try {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", emailAddress, null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }catch (Exception e) {
            WidgetUtil.showToast(context, e.getMessage());
        }
    }

    public static String getPhoneNumberFromProspek(ProspekListItemModel mDataModel) {
        if(mDataModel!=null) {
            ProspekBiodataModel biodataModel = null;
            List<ProspekBiodataModel> biodataModelList = mDataModel.getBiodataModel();
            if (biodataModelList != null && biodataModelList.size() > 0) {
                biodataModel = biodataModelList.get(0);
                if (biodataModel != null) {
                    if (!TextUtils.isEmpty(biodataModel.getNomorTelp())) {
                        return biodataModel.getNomorTelp();
                    }
                }
            }
        }

        return "";
    }

    public static String getPhoneNumberFromProspekDetail(ProspekListItemModel mDataModel) {
        if(mDataModel!=null) {
            if ( mDataModel.getKontakModel() != null &&  mDataModel.getKontakModel().size()>0) {
                if (!TextUtils.isEmpty(mDataModel.getKontakModel().get(0).getNomorTelp())) {
                    return mDataModel.getKontakModel().get(0).getNomorTelp();
                }
            }
        }

        return "";
    }

    public static String getEmailFromProspekDetail(ProspekListItemModel mDataModel) {
        if(mDataModel!=null) {
            ProspekBiodataModel biodataModel = null;
            List<ProspekBiodataModel> biodataModelList = mDataModel.getBiodataModel();
            if (biodataModelList != null && biodataModelList.size() > 0) {
                biodataModel = biodataModelList.get(0);
                if (biodataModel != null && !TextUtils.isEmpty(biodataModel.getEmail())) {
                    return biodataModel.getEmail();
                }
            }
        }

        return "";
    }

    public static void updateLastActive() {
        AppPreference.getInstance().setLastActive(System.currentTimeMillis());
    }

    public static boolean shouldLogin() {
        //long deltaActive = Math.abs(System.currentTimeMillis() - AppPreference.getInstance().getLastActive());
        if (AppPreference.getInstance().getUserLoggedIn() == null ) {
                //|| deltaActive > Constant.SESSION_EXIPRED_TIME) {
            return true;
        }

        return false;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    public static void checkInternet(Context context) {
        if (!isConnected(context)) {
            DialogFactory.showAlert(context, "Tidak tersambung internet!\nHarap aktifkan internet anda");
        }
    }

    public static boolean isGPSEnable(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void checkGPSEnable(final Context context){
        if(!isGPSEnable(context)){
            DialogFactory.showConfirmation(context, context.getResources().getString(R.string.app_name), "GPS tidak aktif!\nHarap aktifkan GPS anda", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    context.startActivity(intent);
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public static String createFotoFileName(String prefix) {
        //return UUID.randomUUID() + "_" + DateUtil.getCurrentDateTimeAsString("yyyyMMddhhmmss") + ".jpg";
        return prefix + "_" + DateUtil.getCurrentDateTimeAsString("yyyyMMdd_hhmmss") + ".jpg";
    }

    public static File getOrCreateFotoFolder() {
        File f = new File(Environment.getExternalStorageDirectory(), "PNM_Mobile");
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    public static void showKeyboard(EditText editText) {
        try {
            final InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        }catch (Exception e) {}
    }

    public static void saveFotoToDisk(Bitmap bmp, String filePath) {
        //File file = new File(filePath);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {}
        }
    }

    public static void deleteFoto(String path) {
        try {
            File f = new File(path);
            if (f.exists()) {
                f.delete();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * Generate a value suitable for use in {@link #setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
