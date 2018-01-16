package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CheckRiwayatAngsuranCallback;
import com.example.saifullah_albasrie.pnm.controller.CheckRiwayatAngsuranController;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.RiwayatAngsuran;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.adapter.RiwayatAngsuranAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProspekTabHistoryPembiayaanFragment extends BaseFragment implements CheckRiwayatAngsuranCallback {

    private final String TAG = ProspekTabHistoryPembiayaanFragment.class.getSimpleName();

    private int formMode;
    private ProspekListItemModel mDataModel;
    private CheckRiwayatAngsuranController controller;

    private List<RiwayatAngsuran> mListRiwayat;
    RiwayatAngsuranAdapter mAdapter;

    @BindView(R.id.rv_riwayat_angsuran)
    RecyclerView rvRiwayatAngsuran;

    /*@BindView(R.id.tv_fullname)
    EditText tvFullname;
    @BindView(R.id.tv_plafond)
    EditText tvPlafond;
    @BindView(R.id.tv_bunga)
    EditText tvBunga;
    @BindView(R.id.tv_angsuran)
    EditText tvAngsuran;
    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;
    */

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_history_pembiayaan;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
        }
        setupView();
    }

    private void initView() {
        controller = new CheckRiwayatAngsuranController(this);
        mListRiwayat = new ArrayList<>();
        mAdapter = new RiwayatAngsuranAdapter(mListRiwayat);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvRiwayatAngsuran.setHasFixedSize(true);
        rvRiwayatAngsuran.setItemAnimator(new DefaultItemAnimator());
        rvRiwayatAngsuran.setAdapter(mAdapter);
        rvRiwayatAngsuran.setLayoutManager(mLayoutManager);

        //mAdapter.setOnItemClickListener(this);
    }

    private void setupView() {
        if (mDataModel != null && mDataModel.getBiodataModel() != null && mDataModel.getBiodataModel().size() > 0) {
            String idNasabah = mDataModel.getBiodataModel().get(0).getIdNasabahPNM();
            if (TextUtils.isEmpty(idNasabah)) {
                idNasabah = mDataModel.getIdNasabahPNM();
            }

            Log.d(TAG, "setupView " + idNasabah);
            if (!TextUtils.isEmpty(idNasabah)) {
                controller.checkRiwayatAngsuran(idNasabah);
            }

            //controller.checkRiwayatAngsuran("LB.000021");
        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            //case FormMode.VIEW:
                //btnCheckSID.setEnabled(false);
            //    break;
            default:
                //btnCheckSID.setEnabled(true);
                /*tvFullname.setEnabled(false);
                tvPlafond.setEnabled(false);
                tvBunga.setEnabled(false);
                tvAngsuran.setEnabled(false);
                tvKeterangan.setEnabled(false);*/
                break;
        }

    }

    /**
     * Auto bind with event bus using subscribe annotation
     *
     * @param stateChanged
     */
    @Subscribe
    public void onFormModeChanged(FormModeStateChanged stateChanged) {
        if (stateChanged != null) {
            formMode = stateChanged.getFormMode();
            if (stateChanged.isResetView()) {
                setupView();
            } else {
                setupMode();
            }
        }
    }

    @Override
    public void onCheckRiwayatAngsuranSuccess(List<RiwayatAngsuran> data) {
        DialogFactory.dismissProgress();
        //DialogFactory.showAlert(getContext(), message);
        mListRiwayat.clear();
        if (data != null) {
            mListRiwayat.addAll(data);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCheckRiwayatAngsuranFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(getContext(), t.getMessage());
    }


}
