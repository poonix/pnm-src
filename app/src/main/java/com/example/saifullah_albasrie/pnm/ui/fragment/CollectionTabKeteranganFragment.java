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
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionTabKeteranganFragment extends BaseFragment {

    private int formMode;
    private PnmDebiturModel mDataModel;
    private CollectionModel mCollectionModel;

    @BindView(R.id.tv_hint_keterangan)
    TextView tvHintKeterangan;

    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_collection_keterangan;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            mCollectionModel = getArguments().getParcelable(FormCollectionActivity.BUNDLE_DATA_COLLECTION);
        }
        setupView();
    }

    private void setupView() {
        if (mDataModel != null) {
            //tvKeterangan.setText(mReferensiModel.get(0).getNamaReferensi());
        }

        if (mCollectionModel != null) {
            tvKeterangan.setText(mCollectionModel.getKeterangan());
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
        tvHintKeterangan.setEnabled(enable);
        tvKeterangan.setEnabled(enable);
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
        model.setKeterangan(tvKeterangan.getText().toString());
        return model;
    }
}
