package com.example.saifullah_albasrie.pnm.ui.factory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SearchView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CheckDebiturCallback;
import com.example.saifullah_albasrie.pnm.controller.CheckDebiturController;
import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.ui.adapter.CheckDebiturAdapter;
import com.example.saifullah_albasrie.pnm.ui.listener.OnCheckDebiturSelectedListener;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class CheckDebiturFactory implements CheckDebiturCallback{

    private Context context;
    private CheckDebiturController checkDebiturController;
    private OnCheckDebiturSelectedListener selectedListener;
    private boolean isAlreadyChecked = false;

    public CheckDebiturFactory(Context context) {
        this.context = context;
        checkDebiturController = new CheckDebiturController(this);
    }

    public boolean isAlreadyChecked() {
        return isAlreadyChecked;
    }

    public void setAlreadyChecked(boolean alreadyChecked) {
        isAlreadyChecked = alreadyChecked;
    }

    public void setSelectedListener(OnCheckDebiturSelectedListener listener) {
        this.selectedListener = listener;
    }

    public void showInputDialog(final int type, String titleSearch) {
        if (type == 4) {
            titleSearch += " (DD/MM/YYYY)";
        }

        DialogFactory.showInputDialog(context, titleSearch, new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!TextUtils.isEmpty(query)) {
                    doSearchDebitur(type, query);
                    return true;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void doSearchDebitur(int type, String query) {
        Log.d("", "doSearchDebitur -> " + type + " : " + query);
        String msg = "Mencari data internal debitur";
        DialogFactory.showProgress(context, msg);
        checkDebiturController.checkDebitur(type, query);
        /*
        //dummy searching
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogFactory.dismissProgress();
                WidgetUtil.showToast(context, "Data tidak ditemukan");
            }
        }, 2000);*/
    }



    public void doCheckIDI(String nama,String ibu,String tgl_lahir,String tempat_lahir,String jenis_kelamin,String jenis_identitas,String nomor_identitas) {
        Log.d("", "doSearchDebitur ->");
        String msg = "Mencari data internal debitur";
        DialogFactory.showProgress(context, msg);
        checkDebiturController.checkIDI(nama,ibu,tgl_lahir,tempat_lahir,jenis_kelamin,jenis_identitas,nomor_identitas);
        /*
        //dummy searching
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogFactory.dismissProgress();
                WidgetUtil.showToast(context, "Data tidak ditemukan");
            }
        }, 2000);*/
    }

    @Override
    public void onCheckDebiturSuccess(List<CheckDebiturModel> debiturModels) {
        DialogFactory.dismissProgress();
        if (debiturModels != null && debiturModels.size() > 0) {
            showSearchResultDialog(context, "", debiturModels, selectedListener);
        } else {
            DialogFactory.showAlert(context, context.getString(R.string.data_not_found));
        }
        isAlreadyChecked = true;
        if (selectedListener != null) {
            selectedListener.onCheckCompleted();
        }
    }

    @Override
    public void onCheckDebiturFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(context, t.getMessage());
    }

    private void showSearchResultDialog(Context context, String title, final List<CheckDebiturModel> data, final OnCheckDebiturSelectedListener listener) {
        final LayoutInflater li = LayoutInflater.from(context);
        final View container = li.inflate(R.layout.search_result_dialog, null);
        final RecyclerView rvResult = ButterKnife.findById(container, R.id.rv_result);
        final CheckDebiturAdapter adapter = new CheckDebiturAdapter(data);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        rvResult.setHasFixedSize(true);
        rvResult.setItemAnimator(new DefaultItemAnimator());
        rvResult.setAdapter(adapter);
        rvResult.setLayoutManager(mLayoutManager);

        /*adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, View view, int position, long id) {
                if (listener != null) {
                    listener.onSelected(data.get(position));
                }
            }
        });*/

        AlertDialog confirmDialog = new AlertDialog.Builder(context)
                //.setTitle(context.getString(R.string.app_name))
                .setPositiveButton(context.getString(R.string.btn_submit), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (listener != null) {
                            CheckDebiturModel model = null;
                            if (adapter.getSelectedIndex() >= 0 && adapter.getSelectedIndex() < data.size()) {
                                model = data.get(adapter.getSelectedIndex());
                            }
                            listener.onSelected(model);
                        }
                        dialog.dismiss();
                    }
                })
                .setView(container)
                .setCancelable(true)
                .create();

        confirmDialog.show();
    }
}
