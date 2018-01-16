package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekRencanaAgunanModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisAgunanModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProspekTabRencanaAgunanFragment extends BaseFragment {


    private int formMode;
    private List<ProspekRencanaAgunanModel> rencanaAgunanModel;

    @BindView(R.id.spinner_jenis_rencana_agunan)
    Spinner spJenisRencanaAgunan;

    @BindView(R.id.tv_no_dokumen)
    EditText tvNoDokumen;
    @BindView(R.id.tv_kolektibilitas)
    EditText tvKolektibilitas;
    @BindView(R.id.tv_hint_jenis_rencana_agunan)
    TextView tvHintJenisAgunan;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_rencana_agunan;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                rencanaAgunanModel = prospekItemModel.getRencanaAgunanModel();
            }
        }
        setupView();
    }

    private void initView() {
        WidgetUtil.setDataMasterAdapter(spJenisRencanaAgunan, DataManager.getInstance().getJenisAgunanModelList());
    }

    private void setupView() {
        if (rencanaAgunanModel != null && rencanaAgunanModel.size() > 0) {
            int posJenisAgunan = WidgetUtil.getSpinnerIndexByLabel(spJenisRencanaAgunan, rencanaAgunanModel.get(0).getJenisAgunan());
            spJenisRencanaAgunan.setSelection(posJenisAgunan);
            tvNoDokumen.setText(rencanaAgunanModel.get(0).getRencanaNoDokumen());
            tvKolektibilitas.setText(rencanaAgunanModel.get(0).getRencanaKeterangan());
        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                tvHintJenisAgunan.setTextColor(getResources().getColor(R.color.grey_text));
                spJenisRencanaAgunan.setEnabled(false);
                tvNoDokumen.setEnabled(false);
                tvKolektibilitas.setEnabled(false);
                break;
            default:
                tvHintJenisAgunan.setTextColor(getResources().getColor(R.color.red_text));
                spJenisRencanaAgunan.setEnabled(true);
                tvNoDokumen.setEnabled(true);
                tvKolektibilitas.setEnabled(true);
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

    public List<ProspekRencanaAgunanModel> saveData() {
        if (!WidgetUtil.validateField(spJenisRencanaAgunan, getString(R.string.field_err_msg, "Jenis Rencana Agunan"))) {
            return null;
        }

        if (rencanaAgunanModel == null) {
            rencanaAgunanModel = new ArrayList<>();
        } else {
            rencanaAgunanModel.clear();
        }

        ProspekRencanaAgunanModel model = new ProspekRencanaAgunanModel();
        JenisAgunanModel jenisAgunanModel = (JenisAgunanModel) spJenisRencanaAgunan.getSelectedItem();
        if (jenisAgunanModel != null) {
            model.setIdJenisAgunan(jenisAgunanModel.getId());
            model.setJenisAgunan(jenisAgunanModel.getJenisAgunan());
        } else {
            WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Jenis Rencana Agunan"));
        }

        model.setRencanaNoDokumen(tvNoDokumen.getText().toString());
        model.setRencanaKeterangan(tvKolektibilitas.getText().toString());
        rencanaAgunanModel.add(model);

        return rencanaAgunanModel;
    }

}
