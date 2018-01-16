package com.example.saifullah_albasrie.pnm.ui.factory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.ui.adapter.CheckDebiturAdapter;
import com.example.saifullah_albasrie.pnm.ui.listener.OnCheckDebiturSelectedListener;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class DialogFactory {

    private static ProgressDialog progressDialog;
    private static Dialog dialog;

    public static void showProgress(Context context, String message) {
        dismissProgress();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    public static void showProgress(Context context) {
        dismissProgress();

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_progressbar);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public static void dismissProgress() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }catch (Exception e) {}

        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }catch (Exception e) {}
    }

    public static void showAlert(Context context, String msg) {
        showAlert(context, msg, null);
    }

    public static void showAlert(Context context, String msg, final DialogInterface.OnDismissListener closeListener) {
        if (context == null)
            return;

        if (context instanceof Activity && ((Activity) context).isFinishing()) {
            return;
        }

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.app_name))
                .setMessage(msg)
                .setPositiveButton(context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .create();

        dialog.show();
    }

    public static void showConfirmation(Context context, String title, String message, final DialogInterface.OnClickListener onOKListener) {
        showConfirmation(context, title, message, onOKListener, null);
    }

    public static void showConfirmation(Context context, String title, String message, final DialogInterface.OnClickListener onOKListener, final DialogInterface.OnDismissListener closeListener) {
        AlertDialog confirmDialog = new AlertDialog.Builder(context)
                .setTitle(TextUtils.isEmpty(title) ? context.getString(R.string.app_name) : title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (onOKListener != null) {
                            onOKListener.onClick(dialog, whichButton);
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .create();
        confirmDialog.show();
    }

    public static void showInputDialog(Context context, String title, final SearchView.OnQueryTextListener queryListener) {
        LayoutInflater li = LayoutInflater.from(context);
        final View container = li.inflate(R.layout.input_dialog, null);
        final TextView label = ButterKnife.findById(container, R.id.tv_label);
        label.setText(title);
        final TextView txt = ButterKnife.findById(container, R.id.tv_text1);
        label.setText(title);

        AlertDialog confirmDialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.app_name))
                .setPositiveButton(context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (queryListener != null) {
                            queryListener.onQueryTextSubmit(txt.getText().toString());
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setView(container)
                .create();

        confirmDialog.show();
    }

    public static void showTakePictureDialog(Context context, final AdapterView.OnItemSelectedListener listener) {
        final CharSequence[] items = {"Camera", "Gallery"};
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onItemSelected(null, null, which, 0);
                        }
                    }
                })
                .setPositiveButton(context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .create();

        dialog.show();
    }
}
