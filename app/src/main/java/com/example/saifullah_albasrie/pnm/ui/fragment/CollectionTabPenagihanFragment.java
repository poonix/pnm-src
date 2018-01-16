package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.CollectionModel;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.activity.FormCollectionActivity;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionTabPenagihanFragment extends BaseFragment {

    private int formMode;
    private PnmDebiturModel mDataModel;
    private CollectionModel mCollectionModel;

    @BindView(R.id.tv_hint_rencana_penagihan)
    TextView tvHintRencanaPenagihan;
    @BindView(R.id.tv_rencana_penagihan)
    TextView tvRencanaPenagihan;

//    @BindView(R.id.tv_hint_aging_tunggakan)
//    TextView tvHintAgingTunggakan;
//    @BindView(R.id.tv_aging_tunggakan)
//    EditText tvAgingTunggakan;

    @BindView(R.id.tv_hint_personal_debitur)
    TextView tvHintPersonalDebitur;
    @BindView(R.id.tv_personal_debitur)
    EditText tvPersonalDebitur;

    @BindView(R.id.tv_hint_tgl_penagihan)
    TextView tvHintTanggalPenagihan;
    @BindView(R.id.tv_tgl_penagihan)
    TextView tvTanggalPenagihan;

    @BindView(R.id.picker_date)
    View vPickerDate;

    @OnClick(R.id.picker_date)
    void onClickDate() {
        WidgetUtil.showDatePicker(getContext(), tvTanggalPenagihan);
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_collection_penagihan;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            mCollectionModel = getArguments().getParcelable(FormCollectionActivity.BUNDLE_DATA_COLLECTION);
        }
        //WidgetUtil.setTextWatcherCurrency(tvAgingTunggakan);
        setupView();
    }

    private void setupView() {
        if (mDataModel != null) {
            tvRencanaPenagihan.setText(DateUtil.convertDateString(mDataModel.getTglJatuhTempo(), "dd/MM/yyyy", "dd-MM-yyyy"));
            //tvAgingTunggakan.setText(mDataModel.getNilaiLikuidasi());
            tvPersonalDebitur.setText(mDataModel.getNamaDebitur());
        }
        if (mCollectionModel != null) {
            tvTanggalPenagihan.setText(DateUtil.convertDateToNormal(mCollectionModel.getTanggalPenagihan()));
        }

        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                setEnableItems(false);
                break;
            default:
                setEnableItems(true);
                break;
        }
    }

    private void setEnableItems(boolean enable) {
        tvHintRencanaPenagihan.setEnabled(false);
        tvRencanaPenagihan.setEnabled(false);
        //tvHintAgingTunggakan.setEnabled(enable);
        //tvAgingTunggakan.setEnabled(enable);
        tvHintPersonalDebitur.setEnabled(false);
        tvPersonalDebitur.setEnabled(false);
        tvHintTanggalPenagihan.setEnabled(enable);
        tvTanggalPenagihan.setEnabled(enable);
        vPickerDate.setEnabled(enable);
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

    public CollectionModel saveData() {
        CollectionModel model = new CollectionModel();
        model.setTanggalPenagihan(DateUtil.convertDateToDB(tvTanggalPenagihan.getText().toString()));
        return model;
    }
}
