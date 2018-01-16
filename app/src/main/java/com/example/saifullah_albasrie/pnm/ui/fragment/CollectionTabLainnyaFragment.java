package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionTabLainnyaFragment extends BaseFragment {

    private int formMode;
    private PnmDebiturModel mDataModel;

    @BindView(R.id.tv_angsuran_total)
    EditText tvAngsuranTotal;
    @BindView(R.id.tv_kode_golongan)
    EditText tvKodeGolongan;
    @BindView(R.id.tv_saldo_dca)
    EditText tvSaldoDCA;
    @BindView(R.id.tv_angsuran_ke)
    EditText tvAngsuranKe;
    @BindView(R.id.tv_jml_tunggakan_hari)
    EditText tvJumlahTunggakanHari;
    @BindView(R.id.tv_tunggakan_pokok)
    EditText tvTunggakanPokok;
    @BindView(R.id.tv_tunggakan_bunga)
    EditText tvTunggakanBunga;
    @BindView(R.id.tv_tunggakan_denda)
    EditText tvTunggakanDenda;
    @BindView(R.id.tv_total_tagihan)
    EditText tvTotalTagihan;

    @BindViews({
            R.id.tv_hint_angsuran_total,
            R.id.tv_hint_kode_golongan,
            R.id.tv_hint_saldo_dca,
            R.id.tv_hint_angsuran_ke,
            R.id.tv_hint_jml_tunggakan_hari,
            R.id.tv_hint_tunggakan_pokok,
            R.id.tv_hint_tunggakan_bunga,
            R.id.tv_hint_tunggakan_denda,
            R.id.tv_hint_total_tagihan
    })
    List<TextView> hintViews;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_collection_lainnya;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
        }
        setupView();
    }

    private void setupView() {
        if (mDataModel != null) {
            tvAngsuranTotal.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getAngsuranTotal()));
            tvKodeGolongan.setText(mDataModel.getKodeGolongan());
            tvSaldoDCA.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getSaldoDCA()));
            tvAngsuranKe.setText(mDataModel.getAngsuranKe());
            tvJumlahTunggakanHari.setText(mDataModel.getJmlTunggakanHari());
            tvTunggakanPokok.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getTunggakanPokok()));
            tvTunggakanBunga.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getTunggakanBunga()));
            tvTunggakanDenda.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getTunggakanDenda()));
            tvTotalTagihan.setText(WidgetUtil.convertToLocalCurrency(mDataModel.getTotalTagihan()));
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
        //always disable
        tvAngsuranTotal.setEnabled(false);
        tvKodeGolongan.setEnabled(false);
        tvSaldoDCA.setEnabled(false);
        tvAngsuranKe.setEnabled(false);
        tvJumlahTunggakanHari.setEnabled(false);
        tvTunggakanPokok.setEnabled(false);
        tvTunggakanBunga.setEnabled(false);
        tvTunggakanDenda.setEnabled(false);
        tvTotalTagihan.setEnabled(false);

        for (View v:hintViews) {
            v.setEnabled(false);
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

    /*public PnmDebiturModel saveData() {


        return mDataModel;
    }*/
}
