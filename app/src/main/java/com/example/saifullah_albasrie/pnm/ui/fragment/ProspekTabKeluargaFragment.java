package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProspekTabKeluargaFragment extends BaseFragment {

    private int formMode;
    private List<ProspekKeluargaModel> mKeluargaModel;

    //@BindView(R.id.v_dummy_focus)
    //View vDummyFocus;
    @BindView(R.id.spinner_status_hub)
    Spinner spStatusHub;
    @BindView(R.id.tv_fullname)
    EditText tvFullname;
//    @BindView(R.id.tv_nickname)
//    EditText tvNickname;
    @BindView(R.id.spinner_gender)
    Spinner spGender;
//    @BindView(R.id.tv_phone)
//    EditText tvPhone;
    @BindView(R.id.spinner_id)
    Spinner spIdType;
    @BindView(R.id.tv_identity_number)
    EditText tvIdentityNumber;
    @BindView(R.id.tv_masa_berlaku)
    TextView tvMasaBerlaku;
    @BindView(R.id.cb_seumur_hidup)
    CheckBox cbSeumurHidup;
    @BindView(R.id.picker_date)
    ImageView ivPickerDate;
    @BindView(R.id.tv_tempat_lahir)
    EditText tvTempatLahir;
    @BindView(R.id.spinner_tgl)
    Spinner spinnerTanggal;
    @BindView(R.id.spinner_bulan)
    Spinner spinnerBulan;
    @BindView(R.id.spinner_tahun)
    Spinner spinnerTahun;

    @BindView(R.id.tv_phone)
    EditText tvPhoneNumber;
    @BindView(R.id.tv_handphone)
    EditText tvHandphoneNumber;

    @BindView(R.id.spinner_pekerjaan)
    Spinner spPekerjaan;
    @BindView(R.id.tv_ket_pekerjaan)
    EditText tvKetPekerjaan;
    @BindView(R.id.spinner_pernah_pinjam)
    Spinner spPernahPinjam;
    //@BindView(R.id.spinner_hub_dgn_pemohon)
    //Spinner spHubPemohon;

    /*
-             Status hubungan
-              Nama lengkap
-              Jenis kelamin
-              Tempat lahir
-              Tgl lahir
-              Jenis identitas
-              Nomor identitas
-              Masa berlaku
-              Pekerjaan
-              Telepon
-              handphone
     */
    @BindViews({
            R.id.tv_hint_status_hubungan,
            R.id.tv_hint_fullname,
            R.id.tv_hint_jenis_identitas,
            R.id.tv_hint_identity_number,
            R.id.tv_hint_jenis_kelamin,
            R.id.tv_hint_tempat_lahir,
            R.id.tv_hint_tanggal,
            R.id.tv_hint_bulan,
            R.id.tv_hint_tahun,
            //R.id.tv_hint_pekerjaan,
            R.id.tv_hint_phone,
            R.id.tv_hint_handphone
    })
    List<TextView> mandatoryHintViews;

    @Optional
    @OnClick(R.id.picker_date)
    void onClick(View view) {
        if (view.getId() == R.id.picker_date) {
            WidgetUtil.showDatePicker(getContext(), tvMasaBerlaku);
        }
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_keluarga;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                mKeluargaModel = prospekItemModel.getKeluargaModel();
            }
        }
        setupView();
    }

    private void initView() {
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(getContext()));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(getContext()));
        spinnerTanggal.setAdapter(WidgetUtil.createAdapterTanggal(getContext()));

        WidgetUtil.setDataMasterAdapter(spPekerjaan, DataManager.getInstance().getJenisPekerjaanModelList());

        cbSeumurHidup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked) {
                    ivPickerDate.setEnabled(false);
                    ivPickerDate.setClickable(false);
                    tvMasaBerlaku.setText("");
                } else {
                    ivPickerDate.setEnabled(true);
                    ivPickerDate.setClickable(true);
                }
            }
        });

    }

    private void setupView() {
        if (mKeluargaModel != null && mKeluargaModel.size() > 0) {
            ProspekKeluargaModel model = mKeluargaModel.get(0);
            int statuHub = WidgetUtil.getSpinnerIndexByLabel(spStatusHub, model.getStatusHubungan());
            spStatusHub.setSelection(statuHub);
            tvFullname.setText(model.getNamaLengkap());
            //tvNickname.setText(model.getNamaPanggilan());
            tvTempatLahir.setText(model.getTempatLahir());
            if (!TextUtils.isEmpty(model.getTanggalLahir()) && !model.getTanggalLahir().equals("1900-01-01")) {
                String tgl = DateUtil.convertDateString(model.getTanggalLahir(), "yyyy-MM-dd", "dd");
                String bln = DateUtil.convertDateString(model.getTanggalLahir(), "yyyy-MM-dd", "MM");
                String tahun = DateUtil.convertDateString(model.getTanggalLahir(), "yyyy-MM-dd", "yyyy");
                int posTgl = WidgetUtil.getSpinnerIndexByLabel(spinnerTanggal, tgl);
                spinnerTanggal.setSelection(posTgl);
                int posBulan = WidgetUtil.getSpinnerIndexByLabel(spinnerBulan, bln);
                spinnerBulan.setSelection(posBulan);
                int posTahun = WidgetUtil.getSpinnerIndexByLabel(spinnerTahun, tahun);
                spinnerTahun.setSelection(posTahun);
            }
            int posIdType = WidgetUtil.getSpinnerIndexByLabel(spIdType, model.getJenisIdentitas());
            spIdType.setSelection(posIdType);
            tvIdentityNumber.setText(model.getNomorIdentitas());
            if (model.getIsSeumurHidup() == 1) {
                tvMasaBerlaku.setText("");
                cbSeumurHidup.setChecked(true);
            } else {
                tvMasaBerlaku.setText(DateUtil.convertDateToNormal(model.getMasaBerlaku()));
                cbSeumurHidup.setChecked(false);
            }
            int posGender = WidgetUtil.getSpinnerIndexByLabel(spGender, model.getJenisKelamin());
            spGender.setSelection(posGender);
            /*
            int posIdPekerjaan = 0;
            try {
                posIdPekerjaan = Integer.parseInt(model.getIdPekerjaan());
            } catch (Exception e) {}
            spPekerjaan.setSelection(posIdPekerjaan);
            */
            WidgetUtil.setSpinnerSelectionById(spPekerjaan, model.getIdPekerjaan());
            tvKetPekerjaan.setText(model.getKeteranganPekerjaan());
            tvPhoneNumber.setText(model.getTelepon());
            tvHandphoneNumber.setText(model.getHandphone());
            int posPernahPinjam = WidgetUtil.getSpinnerIndexByLabel(spPernahPinjam, model.getKeluargaMeminjamKePnm());
            spPernahPinjam.setSelection(posPernahPinjam);
        }

        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                ButterKnife.apply(mandatoryHintViews,WidgetUtil.SET_COLOR,getResources().getColor(R.color.grey_text));
                setEnableItems(false);
                break;
            default:
                ButterKnife.apply(mandatoryHintViews,WidgetUtil.SET_COLOR,getResources().getColor(R.color.red_text));
                setEnableItems(true);
                break;
        }
    }

    private void setEnableItems(boolean enable) {
        spStatusHub.setEnabled(enable);
        tvFullname.setEnabled(enable);
        spGender.setEnabled(enable);
        spIdType.setEnabled(enable);
        tvIdentityNumber.setEnabled(enable);
        tvMasaBerlaku.setEnabled(enable);
        cbSeumurHidup.setEnabled(enable);
        if (cbSeumurHidup.isChecked()) {
            ivPickerDate.setEnabled(false);
        } else {
            ivPickerDate.setEnabled(enable);
        }
        tvTempatLahir.setEnabled(enable);
        spinnerTanggal.setEnabled(enable);
        spinnerBulan.setEnabled(enable);
        spinnerTahun.setEnabled(enable);
        tvPhoneNumber.setEnabled(enable);
        tvHandphoneNumber.setEnabled(enable);
        spPekerjaan.setEnabled(enable);
        tvKetPekerjaan.setEnabled(enable);
        spPernahPinjam.setEnabled(enable);
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

    public List<ProspekKeluargaModel> saveData() {
        /*
        -              Status hubungan
-              Nama lengkap
-              Jenis kelamin
-              Tempat lahir
-              Tgl lahir
-              Jenis identitas
-              Nomor identitas
-              Masa berlaku
-              Pekerjaan
-              Telepon
-              handphone
-               keluargaMeminjamKePnm
         */

        ProspekKeluargaModel model = new ProspekKeluargaModel();

        if (!WidgetUtil.validateField(spStatusHub, getString(R.string.field_err_msg, "Status Hubungan"))) {
            return null;
        }
        if (!WidgetUtil.validateField(tvFullname, getString(R.string.field_err_msg, "Nama Lengkap"))) {
            return null;
        }

        if (!WidgetUtil.validateField(tvTempatLahir, getString(R.string.field_err_msg, "Tempat Lahir"))) {
            return null;
        }

        if(spinnerTanggal.getSelectedItemPosition() > 0 && spinnerBulan.getSelectedItemPosition() > 0 && spinnerTahun.getSelectedItemPosition() > 0) {
            String tgl = spinnerTanggal.getSelectedItem() != null ? spinnerTanggal.getSelectedItem().toString() : "";
            String bln = spinnerBulan.getSelectedItem() != null ? spinnerBulan.getSelectedItem().toString() : "";
            String thn = spinnerTahun.getSelectedItem() != null ? spinnerTahun.getSelectedItem().toString() : "";
            model.setTanggalLahir(thn + "-" + bln + "-" + tgl);
        } else {
            WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Tanggal Lahir"));
            return null;
        }

        if (!WidgetUtil.validateField(tvIdentityNumber, getString(R.string.field_err_msg, "Nomor Identitas"))) {
            return null;
        }

        if (cbSeumurHidup.isChecked() == false && !WidgetUtil.validateField(tvMasaBerlaku, getString(R.string.field_err_msg, "Masa berlaku"))) {
            return null;
        }

        /*if (!WidgetUtil.validateField(spPekerjaan, getString(R.string.field_err_msg, "Pekerjaan"))) {
            return null;
        }*/

        if (!WidgetUtil.validateField(tvPhoneNumber, getString(R.string.field_err_msg, "Nomor Telepon"))) {
            return null;
        }

        if (!WidgetUtil.validateField(tvHandphoneNumber, getString(R.string.field_err_msg, "Nomor Handphone"))) {
            return null;
        }

        int idSurveyKeluarga = 0;
        if (mKeluargaModel != null && mKeluargaModel.size()>0) {
            idSurveyKeluarga = mKeluargaModel.get(0).getIdKeluarga();
        }
        model.setIdKeluarga(idSurveyKeluarga);
        model.setStatusHubungan(spStatusHub.getSelectedItem().toString());
        model.setNamaLengkap(tvFullname.getText().toString());
        //model.setNamaPanggilan(tvNickname.getText().toString());
        model.setTempatLahir(tvTempatLahir.getText().toString());
        model.setJenisIdentitas(spIdType.getSelectedItem().toString());
        model.setNomorIdentitas(tvIdentityNumber.getText().toString());
        model.setMasaBerlaku(DateUtil.convertDateToDB(tvMasaBerlaku.getText().toString()));
        model.setIsSeumurHidup(cbSeumurHidup.isChecked()?1:0);
        model.setJenisKelamin(spGender.getSelectedItem().toString());
        //model.setIdPekerjaan(String.valueOf(spPekerjaan.getSelectedItemPosition()));
        JenisPekerjaanModel pekerjaanModel = (JenisPekerjaanModel) spPekerjaan.getSelectedItem();
        if (pekerjaanModel != null && pekerjaanModel.getId() > 0) {
            model.setIdPekerjaan(pekerjaanModel.getId());
            model.setNamaPekerjaan(pekerjaanModel.getNamaPekerjaan());
        }
        model.setKeteranganPekerjaan(tvKetPekerjaan.getText().toString());
        model.setTelepon(tvPhoneNumber.getText().toString());
        model.setHandphone(tvHandphoneNumber.getText().toString());
        model.setKeluargaMeminjamKePnm(spPernahPinjam.getSelectedItem().toString());

        if(mKeluargaModel==null) {
            mKeluargaModel = new ArrayList<>();
        } else {
            mKeluargaModel.clear();
        }

        mKeluargaModel.add(model);

        return mKeluargaModel;
    }
}
