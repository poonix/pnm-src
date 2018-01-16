package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProspekTabJadwalFragment extends BaseFragment {

    private int formMode;
    private List<ProspekJadwalModel> mJadwalModel;

    @BindView(R.id.btnTambahJadwal)
    Button btnTambahJadwal;

    @BindView(R.id.view_jadwal)
    LinearLayout jadwalView;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_jadwal;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                mJadwalModel = prospekItemModel.getJadwalModel();
            }
        }
        setupView();
    }

    @Optional
    @OnClick(R.id.btnTambahJadwal)
    public void clickAddJadwal() {
        int count = jadwalView.getChildCount();
        if (count < Constant.MAX_JADWAL) {
            addJadwal(null);
        }
    }

    private void addJadwal(ProspekJadwalModel model) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_jadwal, null);
        final TextView txtDate = ButterKnife.findById(view, R.id.date_jadwal);
        final TextView txtKeterangan = ButterKnife.findById(view, R.id.keterangan_jadwal);
        ImageView img = ButterKnife.findById(view, R.id.picker_jadwal);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WidgetUtil.showDatePicker(getContext(), txtDate);
            }
        });

        ImageView ivDelete = ButterKnife.findById(view, R.id.delete_jadwal);
        if (formMode == FormMode.VIEW) {
            ivDelete.setVisibility(View.GONE);
        } else {
            ivDelete.setVisibility(View.VISIBLE);
        }
        ivDelete.setTag(view);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (jadwalView.getChildCount() > 1) {
                    DialogFactory.showConfirmation(getContext(), "", "Hapus jadwal?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View container = (View) v.getTag();
                            jadwalView.removeView(container);
                        }
                    });
                } else {
                    DialogFactory.showAlert(getContext(), "Jadwal tidak bisa di hapus, minimal harus ada satu jadwal");
                }

            }
        });

        if (model != null) {
            txtDate.setText(DateUtil.convertDateToNormal(model.getRealisasiPertemuan()));
            txtDate.setTag(model.getId());
            txtKeterangan.setText(model.getKeteranganPertemuan());
        }

        if(jadwalView.getChildCount() == 0) {
            ivDelete.setVisibility(View.GONE);
        }

        jadwalView.addView(view);
    }

    private void setupView() {
        jadwalView.removeAllViews();
        if (mJadwalModel != null) {
            for (ProspekJadwalModel item : mJadwalModel) {
                addJadwal(item);
            }
        }

        if (jadwalView.getChildCount() == 0) {
            addJadwal(null);
        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                setEnableItems(false);
                btnTambahJadwal.setEnabled(false);
                btnTambahJadwal.setVisibility(View.GONE);
                break;
            case FormMode.EDIT:
                setEnableItems(true);
                btnTambahJadwal.setEnabled(true);
                btnTambahJadwal.setVisibility(View.VISIBLE);
                break;
            default:
                setEnableItems(true);
                btnTambahJadwal.setEnabled(false);
                btnTambahJadwal.setVisibility(View.GONE);
                break;
        }

    }

    private void setEnableItems(boolean enable) {
        for (int i = 0; i < jadwalView.getChildCount(); i++) {
            View view = jadwalView.getChildAt(i);
            TextView txtDate = ButterKnife.findById(view, R.id.date_jadwal);
            txtDate.setEnabled(enable);
            ImageView imgCal = ButterKnife.findById(view, R.id.picker_jadwal);
            imgCal.setEnabled(enable);
            imgCal.setClickable(enable);
            TextView txtKeterangan = ButterKnife.findById(view, R.id.keterangan_jadwal);
            txtKeterangan.setEnabled(enable);

            ImageView ivDelete = ButterKnife.findById(view, R.id.delete_jadwal);
            if (enable && i > 0) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }
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

    public List<ProspekJadwalModel> saveData() {
        return saveData(true);
    }

    public List<ProspekJadwalModel> saveData(boolean withValidation) {
        if (mJadwalModel == null) {
            mJadwalModel = new ArrayList<>();
        } else {
            mJadwalModel.clear();
        }

        for (int i = 0; i < jadwalView.getChildCount(); i++) {
            ProspekJadwalModel model = new ProspekJadwalModel();
            View view = jadwalView.getChildAt(i);
            TextView txtDate = ButterKnife.findById(view, R.id.date_jadwal);
            TextView txtKeterangan = ButterKnife.findById(view, R.id.keterangan_jadwal);

            if (!TextUtils.isEmpty(txtDate.getText().toString()) && !TextUtils.isEmpty(txtKeterangan.getText().toString()))
            {
                int idPertemuan = 0;
                try {
                    idPertemuan = Integer.parseInt(txtDate.getTag().toString());
                }catch (Exception e){}
                model.setId(idPertemuan);
                model.setRealisasiPertemuan(DateUtil.convertDateToDB(txtDate.getText().toString()));
                model.setKeteranganPertemuan(txtKeterangan.getText().toString());
                mJadwalModel.add(model);
            }
        }
        return mJadwalModel;
    }
}
