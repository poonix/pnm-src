package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CheckSIDCallback;
import com.example.saifullah_albasrie.pnm.controller.CheckSIDController;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.DataProspekModelStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class ProspekTabCheckSIDFragment extends BaseFragment implements CheckSIDCallback {


    private int formMode;
    private ProspekListItemModel mDataModel;
    private CheckSIDController controller;

    @BindView(R.id.btn_check_sid)
    Button btnCheckSID;

    @OnClick(R.id.btn_check_sid)
    void onClickCheckSID() {
        if (mDataModel != null) {
            doCheckSID();
        } else {
            DialogFactory.showAlert(getContext(), getString(R.string.check_sid_failed));
        }
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_check_sid;
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
        controller = new CheckSIDController(this);
    }

    private void setupView() {
        if (mDataModel != null) {

        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                btnCheckSID.setEnabled(false);
                break;
            default:
                btnCheckSID.setEnabled(true);
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

    public boolean saveData() {

        return true;
    }

    private void doCheckSID() {
        DialogFactory.showConfirmation(getContext(), getString(R.string.app_name), getString(R.string.check_sid_title), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserModel userModel = AppPreference.getInstance().getUserLoggedIn();

                BiodataModel biodataModel = new BiodataModel();
                biodataModel.setIdSdm(userModel.getIdsdm());
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                biodataModel.setKodeUnit(userModel.getKodeUnit());
                biodataModel.setKodeCabang(userModel.getKodeCabang());

                DialogFactory.showProgress(getContext());
                controller.submitCheckSID(biodataModel);

            }
        });
    }

    @Override
    public void onCheckSIDSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(getContext(), message);
    }

    @Override
    public void onCheckSIDFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(getContext(), t.getMessage());
    }

    @Subscribe
    public void onDataProspekChanged(DataProspekModelStateChanged event) {
        if (event != null && event.getDataModel() != null) {
            mDataModel = event.getDataModel();
        }
    }
}
