package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKeluargaCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyKeluargaController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaDetailModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by aldhiramdan on 4/2/17.
 */

public class FormSurveyKeluargaActivity extends BaseFormActivity implements SurveyKeluargaCallback {

    private ProspekListItemModel mDataModel;
    private SurveyKeluargaModel keluargaModel;
    private List<SurveyKeluargaDetailModel> detailModels;

    private SurveyKeluargaController controller;

    @BindView(R.id.tv_tanggungan_istri)
    EditText tvTanggunganIstri;
    @BindView(R.id.tv_tanggungan_anak)
    EditText tvTanggunganAnak;
    @BindView(R.id.tv_tanggungan_lainnya)
    EditText tvTanggunganLain;
    @BindView(R.id.tv_jumlah_tanggungan)
    EditText tvJumlahTanggungan;

    @BindView(R.id.spinner_apakah_pasangan_bekerja)
    Spinner spPasanganBekerja;
    @BindView(R.id.spinner_anak_yang_bekerja)
    Spinner spAnakBekerja;
    @BindView(R.id.spinner_orang_tua_bekerja)
    Spinner spOrangTuaBekerja;
    @BindView(R.id.spinner_pernah_pinjam)
    Spinner spPernahPinjam;


    @BindView(R.id.ll_container_data_keluarga)
    LinearLayout vContainerDataKeluarga;

    @BindView(R.id.ll_btn_tambah)
    View btnTambah;

    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickTambahKeluarga() {
        int count = vContainerDataKeluarga.getChildCount();
        if (count < Constant.MAX_DATA_KELUARGA) {
            addKeluargaItem(null);
        }
    }

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyKeluargaActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_keluarga;
    }


    @Override
    public void initData() {
        controller = new SurveyKeluargaController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        if (vContainerDataKeluarga.getChildCount() == 0) {
            addKeluargaItem(null);
        }

    }

    @Override
    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyKeluarga(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }

    }


    @Override
    public void setupView() {
        if (keluargaModel != null) {
            tvTanggunganIstri.setText(keluargaModel.getJumlahTanggunganIstri());
            tvTanggunganAnak.setText(keluargaModel.getJumlahTanggunganAnak());
            tvTanggunganLain.setText(keluargaModel.getJumlahTanggunganLain());
            tvJumlahTanggungan.setText(keluargaModel.getJumlahTanggungan());
            spPasanganBekerja.setSelection(keluargaModel.getIsPasanganBekerja());
            spAnakBekerja.setSelection(keluargaModel.getIsAnakBekerja());
            spOrangTuaBekerja.setSelection(keluargaModel.getIsOrangtuaBekerja());
        }

        vContainerDataKeluarga.removeAllViews();
        if (detailModels != null && detailModels.size() > 0) {
            for (SurveyKeluargaDetailModel model : detailModels) {
                addKeluargaItem(model);
            }
        }

        if (vContainerDataKeluarga.getChildCount() == 0) {
            addKeluargaItem(null);
        }

        setupMode();
    }

    @Override
    public void setEnableItems(boolean enable) {
        tvTanggunganIstri.setEnabled(enable);
        tvTanggunganAnak.setEnabled(enable);
        tvTanggunganLain.setEnabled(enable);
        tvJumlahTanggungan.setEnabled(enable);
        spPasanganBekerja.setEnabled(enable);
        spAnakBekerja.setEnabled(enable);
        spOrangTuaBekerja.setEnabled(enable);
        spPernahPinjam.setEnabled(enable);

        btnTambah.setVisibility(enable ? View.VISIBLE : View.GONE);

        for (int i = 0; i < vContainerDataKeluarga.getChildCount(); i++) {
            View view = vContainerDataKeluarga.getChildAt(i);
            final CheckBox cbPernahMeminjam = ButterKnife.findById(view, R.id.cb_pernah_meminjam);
            Spinner spStatusHubungan = ButterKnife.findById(view, R.id.spinner_status_hubungan);
            EditText tvNamaLengkap = ButterKnife.findById(view, R.id.tv_nama_lengkap);
            Spinner spJenisID = ButterKnife.findById(view, R.id.spinner_id);
            EditText tvNomorID = ButterKnife.findById(view, R.id.tv_identity_number);
            Spinner spGender = ButterKnife.findById(view, R.id.spinner_gender);

            EditText tvTempatLahir = ButterKnife.findById(view, R.id.tv_tempat_lahir);
            Spinner spinnerTanggal = ButterKnife.findById(view, R.id.spinner_tgl);
            Spinner spinnerBulan = ButterKnife.findById(view, R.id.spinner_bulan);
            Spinner spinnerTahun = ButterKnife.findById(view, R.id.spinner_tahun);

            final TextView tvMasaBerlaku = ButterKnife.findById(view, R.id.tv_masa_berlaku);
            final CheckBox cbSeumurHidup = ButterKnife.findById(view, R.id.cb_seumur_hidup);
            final ImageView vPickerDate = ButterKnife.findById(view, R.id.picker_date);

            Spinner spPekerjaan = ButterKnife.findById(view, R.id.spinner_pekerjaan);
            EditText tvKetPekerjaan = ButterKnife.findById(view, R.id.tv_keterangan_pekerjaan);
            EditText tvPhone = ButterKnife.findById(view, R.id.tv_phone);
            EditText tvHandphone = ButterKnife.findById(view, R.id.tv_handphone);
            Spinner spPernahPinjam = ButterKnife.findById(view, R.id.spinner_pernah_pinjam);

            View vBIChecking = ButterKnife.findById(view, R.id.rl_bi_checking);

            View ivDelete = ButterKnife.findById(view, R.id.delete_keluarga);
            if (i > 0 && formMode != FormMode.VIEW)
                ivDelete.setVisibility(View.VISIBLE);
            else
                ivDelete.setVisibility(View.GONE);

            cbPernahMeminjam.setEnabled(enable);
            spStatusHubungan.setEnabled(enable);
            tvNamaLengkap.setEnabled(enable);
            spJenisID.setEnabled(enable);
            tvNomorID.setEnabled(enable);
            spGender.setEnabled(enable);
            tvTempatLahir.setEnabled(enable);
            spinnerTanggal.setEnabled(enable);
            spinnerBulan.setEnabled(enable);
            spinnerTahun.setEnabled(enable);
            //tvMasaBerlaku.setEnabled(enable);
            cbSeumurHidup.setEnabled(enable);
            //vPickerDate.setEnabled(enable);
            if (cbSeumurHidup.isChecked()) {
                vPickerDate.setEnabled(false);
            } else {
                vPickerDate.setEnabled(enable);
            }
            spPekerjaan.setEnabled(enable);
            tvKetPekerjaan.setEnabled(enable);
            tvPhone.setEnabled(enable);
            tvHandphone.setEnabled(enable);
            //spPernahPinjam.setEnabled(enable);

            //vBIChecking.setVisibility(enable ? View.VISIBLE : View.GONE);

        }
    }


    private void addKeluargaItem(SurveyKeluargaDetailModel model) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_detail_keluarga, null);
        final CheckBox cbPrnahMeminjam = ButterKnife.findById(view, R.id.cb_pernah_meminjam);
        Spinner spStatusHubungan = ButterKnife.findById(view, R.id.spinner_status_hubungan);
        final EditText tvNamaLengkap = ButterKnife.findById(view, R.id.tv_nama_lengkap);
        Spinner spJenisID = ButterKnife.findById(view, R.id.spinner_id);
        EditText tvNomorID = ButterKnife.findById(view, R.id.tv_identity_number);
        Spinner spGender = ButterKnife.findById(view, R.id.spinner_gender);

        EditText tvTempatLahir = ButterKnife.findById(view, R.id.tv_tempat_lahir);
        Spinner spinnerTanggal = ButterKnife.findById(view, R.id.spinner_tgl);
        Spinner spinnerBulan = ButterKnife.findById(view, R.id.spinner_bulan);
        Spinner spinnerTahun = ButterKnife.findById(view, R.id.spinner_tahun);

        spinnerTanggal.setAdapter(WidgetUtil.createAdapterTanggal(this));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(this));
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(this));

        final TextView tvMasaBerlaku = ButterKnife.findById(view, R.id.tv_masa_berlaku);
        final CheckBox cbSeumurHidup = ButterKnife.findById(view, R.id.cb_seumur_hidup);
        final ImageView vPickerDate = ButterKnife.findById(view, R.id.picker_date);

        Spinner spPekerjaan = ButterKnife.findById(view, R.id.spinner_pekerjaan);
        EditText tvKetPekerjaan = ButterKnife.findById(view, R.id.tv_keterangan_pekerjaan);
        EditText tvPhone = ButterKnife.findById(view, R.id.tv_phone);
        EditText tvHandphone = ButterKnife.findById(view, R.id.tv_handphone);
        //Spinner spPernahPinjam = ButterKnife.findById(view, R.id.spinner_pernah_pinjam);

        WidgetUtil.setDataMasterAdapter(spPekerjaan, DataManager.getInstance().getJenisPekerjaanModelList());

        cbSeumurHidup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vPickerDate.setEnabled(false);
                    vPickerDate.setClickable(false);
                    tvMasaBerlaku.setText("");
                } else {
                    vPickerDate.setEnabled(true);
                    vPickerDate.setClickable(true);
                }
            }
        });

        vPickerDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WidgetUtil.showDatePicker(FormSurveyKeluargaActivity.this, tvMasaBerlaku);
            }
        });

        View ivDelete = ButterKnife.findById(view, R.id.delete_keluarga);
        if (ivDelete != null) {
            if (formMode == FormMode.VIEW || vContainerDataKeluarga.getChildCount() == 0) {
                ivDelete.setVisibility(View.GONE);
            } else {
                ivDelete.setVisibility(View.VISIBLE);
            }
            ivDelete.setTag(view);
            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (vContainerDataKeluarga.getChildCount() > 1) {
                        DialogFactory.showConfirmation(FormSurveyKeluargaActivity.this, "", "Hapus Data Keluarga?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View container = (View) v.getTag();
                                vContainerDataKeluarga.removeView(container);
                            }
                        });
                    } else {
                        DialogFactory.showAlert(FormSurveyKeluargaActivity.this, "Data Keluarga tidak bisa di hapus, minimal harus ada satu");
                    }

                }
            });
        }

        TextView tvBIChecking = ButterKnife.findById(view, R.id.tv_bi_checking);
        tvBIChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkap = tvNamaLengkap.getText().toString();
                if (!TextUtils.isEmpty(namaLengkap)) {
                    doCheckSID(namaLengkap);
                } else {
                    WidgetUtil.showToast(FormSurveyKeluargaActivity.this, getString(R.string.field_err_msg, "Nama Lengkap"));
                }
            }
        });

        if (model != null) {
            if (model.getKeluargaMeminjamKePnm() != null && model.getKeluargaMeminjamKePnm().equalsIgnoreCase("Ya")) {
                cbPrnahMeminjam.setChecked(true);
            }
            spStatusHubungan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spStatusHubungan, model.getStatusHubungan()));
            tvNamaLengkap.setText(model.getNamaLengkap());
            spJenisID.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJenisID, model.getJenisIdentitas()));
            tvNomorID.setText(model.getNomorIdentitas());
            spGender.setSelection(WidgetUtil.getSpinnerIndexByLabel(spGender, model.getJenisKelamin()));
            tvMasaBerlaku.setText(DateUtil.convertDateToNormal(model.getMasaBerlaku()));
            cbSeumurHidup.setChecked(model.getIsSeumurHidup() == 1 ? true : false);
            vPickerDate.setEnabled(model.getIsSeumurHidup() == 1 ? false : true);
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
            WidgetUtil.setSpinnerSelectionById(spPekerjaan, model.getIdPekerjaan());
            tvKetPekerjaan.setText(model.getKeteranganPekerjaan());
            tvPhone.setText(model.getTelepon());
            tvHandphone.setText(model.getHandphone());
            //spPernahPinjam.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPernahPinjam, model.getKeluargaMeminjamKePnm()));
        }

        vContainerDataKeluarga.addView(view);

    }

    private void doCheckSID(final String namaLengkap) {
        DialogFactory.showConfirmation(this, getString(R.string.app_name), "BI Checking ?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
                DialogFactory.showProgress(FormSurveyKeluargaActivity.this);
                BiodataModel biodataModel = new BiodataModel();
                biodataModel.setIdSdm(userModel.getIdsdm());
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                biodataModel.setNamaLengkap(namaLengkap);
                biodataModel.setKodeUnit(userModel.getKodeUnit());
                biodataModel.setKodeCabang(userModel.getKodeCabang());
                biodataModel.setCreatedDate(DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));
                controller.submitCheckSIDKeluarga(biodataModel);

            }
        });
    }

    @Override
    public void saveData() {
        SurveyKeluargaModel newModel = new SurveyKeluargaModel();
        newModel.setJumlahTanggunganIstri(WidgetUtil.getNumberFromField(tvTanggunganIstri));
        newModel.setJumlahTanggunganAnak(WidgetUtil.getNumberFromField(tvTanggunganAnak));
        newModel.setJumlahTanggunganLain(WidgetUtil.getNumberFromField(tvTanggunganLain));
        newModel.setJumlahTanggungan(WidgetUtil.getNumberFromField(tvJumlahTanggungan));
        newModel.setIsPasanganBekerja(spPasanganBekerja.getSelectedItemPosition());
        newModel.setIsAnakBekerja(spAnakBekerja.getSelectedItemPosition());
        newModel.setIsOrangtuaBekerja(spOrangTuaBekerja.getSelectedItemPosition());

        List<SurveyKeluargaDetailModel> details = validateDetail();

        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());

        keluargaModel = newModel;
        detailModels = details;
        DialogFactory.showProgress(this);
        controller.saveSurveyKeluarga(biodataModel, keluargaModel, detailModels);
    }

    private List<SurveyKeluargaDetailModel> validateDetail() {
        List<SurveyKeluargaDetailModel> details = new ArrayList<>();
        for (int i = 0; i < vContainerDataKeluarga.getChildCount(); i++) {
            View view = vContainerDataKeluarga.getChildAt(i);
            CheckBox cbPernahPinjam = ButterKnife.findById(view, R.id.cb_pernah_meminjam);
            Spinner spStatusHubungan = ButterKnife.findById(view, R.id.spinner_status_hubungan);
            EditText tvNamaLengkap = ButterKnife.findById(view, R.id.tv_nama_lengkap);
            Spinner spJenisID = ButterKnife.findById(view, R.id.spinner_id);
            EditText tvNomorID = ButterKnife.findById(view, R.id.tv_identity_number);
            Spinner spGender = ButterKnife.findById(view, R.id.spinner_gender);

            EditText tvTempatLahir = ButterKnife.findById(view, R.id.tv_tempat_lahir);
            Spinner spinnerTanggal = ButterKnife.findById(view, R.id.spinner_tgl);
            Spinner spinnerBulan = ButterKnife.findById(view, R.id.spinner_bulan);
            Spinner spinnerTahun = ButterKnife.findById(view, R.id.spinner_tahun);

            TextView tvMasaBerlaku = ButterKnife.findById(view, R.id.tv_masa_berlaku);
            CheckBox cbSeumurHidup = ButterKnife.findById(view, R.id.cb_seumur_hidup);

            Spinner spPekerjaan = ButterKnife.findById(view, R.id.spinner_pekerjaan);
            EditText tvKetPekerjaan = ButterKnife.findById(view, R.id.tv_keterangan_pekerjaan);
            EditText tvPhone = ButterKnife.findById(view, R.id.tv_phone);
            EditText tvHandphone = ButterKnife.findById(view, R.id.tv_handphone);
            //Spinner spPernahPinjam = ButterKnife.findById(view, R.id.spinner_pernah_pinjam);

            SurveyKeluargaDetailModel model = new SurveyKeluargaDetailModel();
            model.setStatusHubungan(spStatusHubungan.getSelectedItem().toString());
            model.setNamaLengkap(tvNamaLengkap.getText().toString());
            model.setJenisIdentitas(spJenisID.getSelectedItem().toString());
            model.setNomorIdentitas(tvNomorID.getText().toString());
            model.setJenisKelamin(spGender.getSelectedItem().toString());
            model.setTempatLahir(tvTempatLahir.getText().toString());

            if (spinnerTanggal.getSelectedItemPosition() > 0 && spinnerBulan.getSelectedItemPosition() > 0 && spinnerTahun.getSelectedItemPosition() > 0) {
                String tgl = spinnerTanggal.getSelectedItem() != null ? spinnerTanggal.getSelectedItem().toString() : "";
                String bln = spinnerBulan.getSelectedItem() != null ? spinnerBulan.getSelectedItem().toString() : "";
                String thn = spinnerTahun.getSelectedItem() != null ? spinnerTahun.getSelectedItem().toString() : "";
                model.setTanggalLahir(thn + "-" + bln + "-" + tgl);
            } else {
                model.setTanggalLahir("");
            }
            model.setMasaBerlaku(tvMasaBerlaku.getText().toString());
            model.setIsSeumurHidup(cbSeumurHidup.isChecked() ? 1 : 0);
            JenisPekerjaanModel pekerjaanModel = (JenisPekerjaanModel) spPekerjaan.getSelectedItem();
            if (pekerjaanModel != null) {
                model.setIdPekerjaan(pekerjaanModel.getId());
                //model.setNamaPekerjaan(pekerjaanModel.getNamaPekerjaan());
            }
            model.setKeteranganPekerjaan(tvKetPekerjaan.getText().toString());
            model.setTelepon(tvPhone.getText().toString());
            model.setHandphone(tvHandphone.getText().toString());
            model.setKeluargaMeminjamKePnm(cbPernahPinjam.isChecked() ? "Ya" : "Tidak");

            details.add(model);
        }

        return details;
    }


    @Override
    public void onGetSurveyKeluargaSuccess(SurveyKeluargaResponse response) {
        if (response != null) {
            if (response.getKeluargaModels() != null && response.getKeluargaModels().size() > 0) {
                keluargaModel = response.getKeluargaModels().get(0);
            }
            detailModels = response.getKeluargaDetailModels();
            setupView();
        }
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyKeluargaFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveSurveyKeluargaSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });
    }

    @Override
    public void onSaveSurveyKeluargaFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onCheckSIDKeluargaSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message);
    }

    @Override
    public void onCheckSIDKeluargaFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
