package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProspekTabReferensiFragment extends BaseFragment {

    private int formMode;
    private List<ProspekReferensiModel> mReferensiModel;

    @BindView(R.id.v_dummy_focus)
    View vDummyFocus;
    @BindView(R.id.tv_nama_referensi)
    EditText tvNamaReferensi;
    @BindView(R.id.tv_telp_referensi)
    EditText tvTelpReferensi;
    @BindView(R.id.sp_jenis_referensi)
    Spinner spJenisReferensi;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_referensi;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                mReferensiModel = prospekItemModel.getRefferenceModel();
            }
        }
        WidgetUtil.setDataMasterAdapter(spJenisReferensi, DataManager.getInstance().getMasterJenisRefensiNew());
        setupView();
    }

    private void setupView() {
        if (mReferensiModel != null && mReferensiModel.size() > 0) {
            tvNamaReferensi.setText(mReferensiModel.get(0).getNamaReferensi());
            tvTelpReferensi.setText(mReferensiModel.get(0).getTelpReferensi());
            spJenisReferensi.setSelection(mReferensiModel.get(0).getJenisReferensi());
            //WidgetUtil.setSpinnerSelectionById(spJenisReferensi, mReferensiModel.get(0).getJenisReferensi());
        }

        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                vDummyFocus.requestFocus();
                tvNamaReferensi.setEnabled(false);
                tvNamaReferensi.setFocusable(false);
                tvNamaReferensi.setFocusableInTouchMode(false);
                tvTelpReferensi.setEnabled(false);
                tvTelpReferensi.setFocusable(false);
                tvTelpReferensi.setFocusableInTouchMode(false);
                spJenisReferensi.setEnabled(false);
                break;
            default:
                tvNamaReferensi.setEnabled(true);
                tvNamaReferensi.setFocusable(true);
                tvNamaReferensi.setFocusableInTouchMode(true);
                tvTelpReferensi.setEnabled(true);
                tvTelpReferensi.setFocusable(true);
                tvTelpReferensi.setFocusableInTouchMode(true);
                spJenisReferensi.setEnabled(true);
                break;
        }
    }

    /**
     * Auto bind with event bus using subscribe annotation
     * @param stateChanged
     */
    @Subscribe
    public void onFormModeChanged(FormModeStateChanged stateChanged) {
        if (stateChanged != null) {
            formMode = stateChanged.getFormMode();
            if(stateChanged.isResetView()) {
                setupView();
            } else {
                setupMode();
            }
        }
    }

    public List<ProspekReferensiModel> saveData() {
        return saveData(true);
    }

    public List<ProspekReferensiModel> saveData(boolean withValidation) {
        if(mReferensiModel == null) {
            mReferensiModel = new ArrayList<>();
        } else {
            mReferensiModel.clear();
        }

        ProspekReferensiModel model = new ProspekReferensiModel();
        model.setNamaReferensi(tvNamaReferensi.getText().toString());
        model.setTelpReferensi(tvTelpReferensi.getText().toString());
        model.setJenisReferensi(spJenisReferensi.getSelectedItemPosition());
        if (!TextUtils.isEmpty(model.getNamaReferensi()) || !TextUtils.isEmpty(model.getTelpReferensi()))
        {
            mReferensiModel.add(model);
        }

        return mReferensiModel;
    }
}
