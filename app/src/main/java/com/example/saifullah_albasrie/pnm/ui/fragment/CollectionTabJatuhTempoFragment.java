package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionTabJatuhTempoFragment extends BaseFragment {

    private int formMode;
    private List<ProspekReferensiModel> mReferensiModel;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_collection_jatuh_tempo;
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
        setupView();
    }

    private void setupView() {
        if (mReferensiModel != null && mReferensiModel.size() > 0) {
            //tvNamaReferensi.setText(mReferensiModel.get(0).getNamaReferensi());
            //tvTelpReferensi.setText(mReferensiModel.get(0).getTelpReferensi());
            //spJenisReferensi.setSelection(mReferensiModel.getJenisReferensi());
        }

        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:

                break;
            default:

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

    /*
    public boolean saveData(boolean withValidation) {
        boolean result = false;
        if (!withValidation) {
            result = true;
        } else {

        }

        return result;
    }*/
}
