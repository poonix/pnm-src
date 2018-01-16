package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekLainnyaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganBankModel;
import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganPNMModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeBidangUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeUsahaModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ProspekTabLainnyaFragment extends BaseFragment {


    private int formMode;
    private List<ProspekLainnyaModel> lainnyaModel;

    @BindView(R.id.spinner_kode_usaha)
    Spinner spKodeUsaha;
    @BindView(R.id.spinner_kode_bidang_usaha)
    Spinner spKodeBidangUsaha;
    @BindView(R.id.spinner_hub_debitur_pnm)
    Spinner spHubDebiturPnm;
    @BindView(R.id.spinner_hub_debitur_bank)
    Spinner spHubDebiturBank;

    @BindViews({R.id.tv_hint_kode_usaha,R.id.tv_hint_bidang_usaha,R.id.tv_hint_hub_debitur_pnm,R.id.tv_hint_hub_debitur_bank})
    List<TextView> mandatoryView;


    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_lainnya;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                lainnyaModel = prospekItemModel.getLainnyaModel();
            }
        }
        setupView();
    }

    private void initView() {
        /*List<KodeUsahaModel> arrKodeUsaha = DataManager.getInstance().getKodeUsahaModelList();
        if (arrKodeUsaha != null && arrKodeUsaha.size() > 0) {
            ArrayAdapter<KodeUsahaModel> adapterKodeUsaha = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrKodeUsaha);
            adapterKodeUsaha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spKodeUsaha.setAdapter(adapterKodeUsaha);
        }*/
        WidgetUtil.setDataMasterAdapter(spKodeUsaha, DataManager.getInstance().getKodeUsahaModelList());

        /*List<KodeBidangUsahaModel> arrKodeBidangUsaha = DataManager.getInstance().getKodeBidangUsahaModelList();
        if (arrKodeBidangUsaha != null && arrKodeBidangUsaha.size() > 0) {
            ArrayAdapter<KodeBidangUsahaModel> adapterKodeBidangUsaha = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrKodeBidangUsaha);
            adapterKodeBidangUsaha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spKodeBidangUsaha.setAdapter(adapterKodeBidangUsaha);
        }*/
        WidgetUtil.setDataMasterAdapter(spKodeBidangUsaha, DataManager.getInstance().getKodeBidangUsahaModelList());

        /*List<HubunganDenganBankModel> arrHubBank = DataManager.getInstance().getHubunganDenganBankModelList();
        if (arrHubBank != null && arrHubBank.size() > 0) {
            ArrayAdapter<HubunganDenganBankModel> adapterHubunganBank = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrHubBank);
            adapterHubunganBank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spHubDebiturBank.setAdapter(adapterHubunganBank);
        }*/
        WidgetUtil.setDataMasterAdapter(spHubDebiturBank, DataManager.getInstance().getHubunganDenganBankModelList());

        /*List<HubunganDenganPNMModel> arrHubPNM = DataManager.getInstance().getHubunganDenganPNMModelList();
        if (arrHubPNM != null && arrHubPNM.size() > 0) {
            ArrayAdapter<HubunganDenganPNMModel> adapterHubunganPNM = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrHubPNM);
            adapterHubunganPNM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spHubDebiturPnm.setAdapter(adapterHubunganPNM);
        }*/
        WidgetUtil.setDataMasterAdapter(spHubDebiturPnm, DataManager.getInstance().getHubunganDenganPNMModelList());
    }

    private void setupView() {
        if (lainnyaModel != null && lainnyaModel.size() > 0) {
            ProspekLainnyaModel model = lainnyaModel.get(0);
            int posKodeUsaha = WidgetUtil.getSpinnerIndexByLabel(spKodeUsaha, model.getKodeUsaha());
            spKodeUsaha.setSelection(posKodeUsaha);

            int posBidangUsaha = WidgetUtil.getSpinnerIndexByLabel(spKodeBidangUsaha, model.getKodeBidangUsaha());
            spKodeBidangUsaha.setSelection(posBidangUsaha);

            int posHubBank = WidgetUtil.getSpinnerIndexByLabel(spHubDebiturBank, model.getHubunganDenganBANK());
            spHubDebiturBank.setSelection(posHubBank);

            int posHubPNM = WidgetUtil.getSpinnerIndexByLabel(spHubDebiturPnm, model.getHubunganDenganPNM());
            spHubDebiturPnm.setSelection(posHubPNM);

        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                ButterKnife.apply(mandatoryView,WidgetUtil.SET_COLOR,getResources().getColor(R.color.grey_text));
                spKodeUsaha.setEnabled(false);
                spKodeBidangUsaha.setEnabled(false);
                spHubDebiturPnm.setEnabled(false);
                spHubDebiturBank.setEnabled(false);
                break;
            default:
                ButterKnife.apply(mandatoryView,WidgetUtil.SET_COLOR,getResources().getColor(R.color.red_text));
                spKodeUsaha.setEnabled(true);
                spKodeBidangUsaha.setEnabled(true);
                spHubDebiturPnm.setEnabled(true);
                spHubDebiturBank.setEnabled(true);
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

    public List<ProspekLainnyaModel> saveData() {
        if (!WidgetUtil.validateField(spKodeUsaha, getString(R.string.field_err_msg, "Kode Usaha"))) {
            return null;
        }

        if (!WidgetUtil.validateField(spKodeBidangUsaha, getString(R.string.field_err_msg, "Kode Bidang Usaha"))) {
            return null;
        }

        if (!WidgetUtil.validateField(spHubDebiturBank, getString(R.string.field_err_msg, "Hubungan dengan Bank"))) {
            return null;
        }

        if (!WidgetUtil.validateField(spHubDebiturPnm, getString(R.string.field_err_msg, "Hubungan dengan PNM"))) {
            return null;
        }

        ProspekLainnyaModel model = new ProspekLainnyaModel();

        if (spKodeUsaha.getSelectedItem() != null && spKodeUsaha.getSelectedItem() instanceof KodeUsahaModel) {
            KodeUsahaModel kodeUsahaModel = (KodeUsahaModel) spKodeUsaha.getSelectedItem();
            model.setIdKodeUsaha(kodeUsahaModel.getId());
            model.setKodeUsaha(kodeUsahaModel.getDeskripsi());
        }

        if (spKodeBidangUsaha.getSelectedItem() != null && spKodeBidangUsaha.getSelectedItem() instanceof KodeBidangUsahaModel) {
            KodeBidangUsahaModel bidangUsahaModel = (KodeBidangUsahaModel) spKodeBidangUsaha.getSelectedItem();
            model.setIdKodeBidangUsaha(bidangUsahaModel.getId());
            model.setKodeUsaha(bidangUsahaModel.getDeskripsi());
        }

        if (spHubDebiturBank.getSelectedItem() != null && spHubDebiturBank.getSelectedItem() instanceof HubunganDenganBankModel) {
            HubunganDenganBankModel hubunganDenganBankModel = (HubunganDenganBankModel) spHubDebiturBank.getSelectedItem();
            model.setIdHubunganDenganBANK(hubunganDenganBankModel.getId());
            model.setHubunganDenganBANK(hubunganDenganBankModel.getDeskripsi());
        }

        if (spHubDebiturPnm.getSelectedItem() != null && spHubDebiturPnm.getSelectedItem() instanceof HubunganDenganPNMModel) {
            HubunganDenganPNMModel hubunganDenganPNMModel = (HubunganDenganPNMModel) spHubDebiturPnm.getSelectedItem();
            model.setIdHubunganDenganPNM(hubunganDenganPNMModel.getId());
            model.setHubunganDenganPNM(hubunganDenganPNMModel.getDeskripsi());
        }

        if (lainnyaModel == null) {
            lainnyaModel = new ArrayList<>();
        } else {
            lainnyaModel.clear();
        }
        lainnyaModel.add(model);
        return lainnyaModel;
    }

}
