package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKapasitasUsahaCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyKapasitasUsahaController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyAktivitasRekeningModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKapasitasUsahaModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.request.KapasitasUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.response.KapasitasUsahaResponse;
import com.example.saifullah_albasrie.pnm.ui.adapter.HartaAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by aldhiramdan on 3/31/17.
 */

public class FormSurveyKapasitasUsahaActivity extends BaseFormActivity implements SurveyKapasitasUsahaCallback {

    private ProspekListItemModel mDataModel;
    private List<SurveyKapasitasUsahaModel> kapasitasUsahaModels;
    private List<SurveyAktivitasRekeningModel> aktivitasRekeningModels;

    private List<JenisHartaModel> hartaModels;
    private HartaAdapter mAdapter;

    private SurveyKapasitasUsahaController controller;

    @BindView(R.id.spinner_pekerjaan)
    Spinner spPekerjaan;

    @BindView(R.id.rv_harta)
    RecyclerView rvHarta;

    /*
    @BindView(R.id.cb_perhiasan)
    CheckBox cbPerhiasan;
    @BindView(R.id.cb_tanah_dan_bangunan)
    CheckBox cbTanahaDanBangunan;
    @BindView(R.id.cb_mobil)
    CheckBox cbMobil;
    @BindView(R.id.cb_motor)
    CheckBox cbMotor;
    @BindView(R.id.cb_lainnya)
    CheckBox cbLainnya;
    */
    @BindView(R.id.et_lama_bekerja)
    EditText etLamaBekerja;
    @BindView(R.id.spinner_jenis_rekening)
    Spinner spJenisTabungan;
    @BindView(R.id.spinner_tahun_rekening)
    Spinner spTahunRekening;

    @BindView(R.id.tv_bank_activity)
    TextView tvTitleAktivitasBank;
    @BindView(R.id.ll_container_aktivitas_bank)
    LinearLayout vAktivitasBank;

    @BindView(R.id.ll_btn_tambah)
    View btnTambah;

    @BindViews({
            R.id.tv_hint_pekerjaan,
            R.id.tv_hint_harta_benda,
            R.id.tv_hint_lama_bekerja,
            R.id.tv_hint_jenis_rekening,
            R.id.tv_hint_tahun_rekening
    })
    List<TextView> mandatoryHintViews;


    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyKapasitasUsahaActivity.class);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_kapasitas_usaha;
    }

    @Override
    protected void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getKapasitasUsaha(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    @Override
    protected void initData() {
        controller = new SurveyKapasitasUsahaController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }
        WidgetUtil.setDataMasterAdapter(spPekerjaan, DataManager.getInstance().getJenisPekerjaanModelList());
        spTahunRekening.setAdapter(WidgetUtil.createAdapterTahunFromNow(this));

        setupRecylcerView();

        if (vAktivitasBank.getChildCount() == 0) {
            addAktivitasItem(null);
        }

        spJenisTabungan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spJenisTabungan.getSelectedItemPosition() == 1) {
                    tvTitleAktivitasBank.setVisibility(View.VISIBLE);
                    vAktivitasBank.setVisibility(View.VISIBLE);
                    if (formMode == FormMode.VIEW) {
                        btnTambah.setVisibility(View.GONE);
                    } else {
                        btnTambah.setVisibility(View.VISIBLE);
                    }
                } else {
                    tvTitleAktivitasBank.setVisibility(View.GONE);
                    vAktivitasBank.setVisibility(View.GONE);
                    btnTambah.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setupRecylcerView() {
        hartaModels = new ArrayList<>();
        hartaModels.addAll(DataManager.getInstance().getJenisHartaModelList());
        mAdapter = new HartaAdapter(hartaModels);

        rvHarta.setHasFixedSize(true);
        rvHarta.setItemAnimator(new DefaultItemAnimator());
        rvHarta.setAdapter(mAdapter);
        rvHarta.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void changeToEditMode() {
        super.changeToEditMode();
        ButterKnife.apply(mandatoryHintViews, WidgetUtil.SET_COLOR, getResources().getColor(R.color.red_text));
    }

    @Override
    public void changeToViewMode() {
        super.changeToViewMode();
        ButterKnife.apply(mandatoryHintViews, WidgetUtil.SET_COLOR, getResources().getColor(R.color.grey_text));
    }

    @Override
    public void setEnableItems(boolean enableItems) {
        spPekerjaan.setEnabled(enableItems);
        mAdapter.setEnable(enableItems);
        /*
        cbPerhiasan.setEnabled(enableItems);
        cbTanahaDanBangunan.setEnabled(enableItems);
        cbMobil.setEnabled(enableItems);
        cbMotor.setEnabled(enableItems);
        cbLainnya.setEnabled(enableItems);
        */
        etLamaBekerja.setEnabled(enableItems);
        spJenisTabungan.setEnabled(enableItems);
        spTahunRekening.setEnabled(enableItems);
        spTahunRekening.setEnabled(enableItems);
        //vAktivitasBank.setVisibility(enableItems ? View.VISIBLE : View.GONE);
        if (spJenisTabungan.getSelectedItemPosition() == 1) {
            vAktivitasBank.setVisibility(View.VISIBLE);
            btnTambah.setVisibility(enableItems ? View.VISIBLE : View.GONE);
        } else {
            vAktivitasBank.setVisibility(View.GONE);
            btnTambah.setVisibility(View.GONE);
        }

        for (int i = 0; i < vAktivitasBank.getChildCount(); i++) {
            View view = vAktivitasBank.getChildAt(i);

            EditText etNamaBank = ButterKnife.findById(view, R.id.et_nama_bank);
            etNamaBank.setEnabled(enableItems);
            Spinner spMonth = ButterKnife.findById(view, R.id.spinner_month);
            spMonth.setEnabled(enableItems);
            final EditText etDebit = ButterKnife.findById(view, R.id.et_debit);
            etDebit.setEnabled(enableItems);
            final EditText etKredit = ButterKnife.findById(view, R.id.et_kredit);
            etKredit.setEnabled(enableItems);
            final EditText etFrekuensi = ButterKnife.findById(view, R.id.et_frekuensi_debit);
            etFrekuensi.setEnabled(enableItems);
            final EditText etFrekuensi1 = ButterKnife.findById(view, R.id.et_frekuensi_kredit);
            etFrekuensi1.setEnabled(enableItems);

            View ivDelete = ButterKnife.findById(view, R.id.delete_aktivitas_rek);
            if (formMode == FormMode.VIEW || i == 0) {
                ivDelete.setVisibility(View.GONE);
            } else {
                ivDelete.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void setupView() {
        if (kapasitasUsahaModels != null && kapasitasUsahaModels.size() > 0) {
            SurveyKapasitasUsahaModel model = kapasitasUsahaModels.get(0);
            spPekerjaan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPekerjaan, model.getNamaPekerjaan()));
            etLamaBekerja.setText(String.valueOf(model.getLamaBekerja()));
            spTahunRekening.setSelection(WidgetUtil.getSpinnerIndexByLabel(spTahunRekening, model.getTahunRekening()));
            spJenisTabungan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJenisTabungan, model.getJenisTabungan()));
            String sHarta = kapasitasUsahaModels.get(0).getIdHartaBenda();
            if (!TextUtils.isEmpty(sHarta)) {
                String[] sCheckedList = sHarta.split(";");
                mAdapter.setCheckedItems(sCheckedList);
            }
        }

        if (aktivitasRekeningModels != null) {
            vAktivitasBank.removeAllViews();
            for (SurveyAktivitasRekeningModel aktivitasRekeningModel : aktivitasRekeningModels) {
                addAktivitasItem(aktivitasRekeningModel);
            }
        }

        setupMode();
    }

    @Override
    protected void saveData() {
        if (!WidgetUtil.validateField(spPekerjaan, getString(R.string.field_err_msg, "Pekerjaan"))) {
            return;
        }
        if (!WidgetUtil.validateField(etLamaBekerja, getString(R.string.field_err_msg, "Lama Bekerja"))) {
            return;
        }
        if (!WidgetUtil.validateField(spJenisTabungan, getString(R.string.field_err_msg, "Jenis Tabungan"))) {
            return;
        }
        if (!WidgetUtil.validateField(spTahunRekening, getString(R.string.field_err_msg, "Tahun Rekening"))) {
            return;
        }

        SurveyKapasitasUsahaModel kapasitasUsahaModel = new SurveyKapasitasUsahaModel();
        JenisPekerjaanModel jenisPekerjaanModel = null;
        if (spPekerjaan.getSelectedItem() != null && spPekerjaan.getSelectedItem() instanceof JenisPekerjaanModel) {
            jenisPekerjaanModel = (JenisPekerjaanModel) spPekerjaan.getSelectedItem();
            kapasitasUsahaModel.setIdPekerjaan(jenisPekerjaanModel.getId());
        }

        if (jenisPekerjaanModel == null) {
            WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Pekerjaan"));
            return;
        }

        //List<JenisHartaModel> checkedHarta = mAdapter.getCheckedItems();
        List checkedHarta = mAdapter.getCheckedItemsId();
        String sCheckedHarta = android.text.TextUtils.join(";", checkedHarta);
        kapasitasUsahaModel.setIdHartaBenda(sCheckedHarta);
        kapasitasUsahaModel.setLamaBekerja(Integer.parseInt(etLamaBekerja.getText().toString()));
        kapasitasUsahaModel.setJenisTabungan(spJenisTabungan.getSelectedItem().toString());
        kapasitasUsahaModel.setTahunRekening(spTahunRekening.getSelectedItem().toString());

        //validate aktivitas usaha
        List<SurveyAktivitasRekeningModel> aktivitasRekening = null;
        if (spJenisTabungan.getSelectedItemPosition() == 1) {
            aktivitasRekening = validateAktivitasRekening();
            if (aktivitasRekening == null || aktivitasRekening.size() == 0) {
                return;
            }
        }

        kapasitasUsahaModels = new ArrayList<>();
        kapasitasUsahaModels.add(kapasitasUsahaModel);

        aktivitasRekeningModels = new ArrayList<>();
        if (aktivitasRekening != null) {
            aktivitasRekeningModels.addAll(aktivitasRekening);
        }

        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());

        //request api
        KapasitasUsahaRequest request = new KapasitasUsahaRequest(kapasitasUsahaModels, aktivitasRekeningModels, biodataModel);
        DialogFactory.showProgress(this);
        controller.saveKapasitasUsaha(request);
    }

    private List<SurveyAktivitasRekeningModel> validateAktivitasRekening() {
        List<SurveyAktivitasRekeningModel> mAktivitasRekeningModel = new ArrayList<>();
        int count = vAktivitasBank.getChildCount();
        ArrayList arrAktivitasRek = new ArrayList();
        for (int i = 0; i < count; i++) {
            View view = vAktivitasBank.getChildAt(i);

            Spinner spBulan = ButterKnife.findById(view, R.id.spinner_month);
            int bulan = spBulan.getSelectedItemPosition();
            if (bulan <= 0 && !WidgetUtil.validateField(spBulan, getString(R.string.field_err_msg, "Bulan"))) {
                return null;
            }

            if (arrAktivitasRek.contains(bulan)) {
                WidgetUtil.showToast(this, "Pilihan Bulan tidak boleh sama");
                return null;
            }
            arrAktivitasRek.add(bulan);

            final EditText etNamabank = ButterKnife.findById(view, R.id.et_nama_bank);
            if (!WidgetUtil.validateField(etNamabank, getString(R.string.field_err_msg, "Nama Bank"))) {
                return null;
            }

            final EditText etDebit = ButterKnife.findById(view, R.id.et_debit);
            if (!WidgetUtil.validateField(etDebit, getString(R.string.field_err_msg, "Debit"))) {
                return null;
            }
            final EditText etFrekuensiDebit = ButterKnife.findById(view, R.id.et_frekuensi_debit);
            if (!WidgetUtil.validateField(etFrekuensiDebit, getString(R.string.field_err_msg, "Frekuensi Debit"))) {
                return null;
            }
            final EditText etKredit = ButterKnife.findById(view, R.id.et_kredit);
            if (!WidgetUtil.validateField(etKredit, getString(R.string.field_err_msg, "Kredit"))) {
                return null;
            }
            final EditText etFrekuensiKredit = ButterKnife.findById(view, R.id.et_frekuensi_kredit);
            if (!WidgetUtil.validateField(etFrekuensiDebit, getString(R.string.field_err_msg, "Frekuensi Kredit"))) {
                return null;
            }

            SurveyAktivitasRekeningModel model = new SurveyAktivitasRekeningModel();
            model.setNama_bank(etNamabank.getText().toString());
            model.setBulan(spBulan.getSelectedItem().toString());
            model.setJumlahDebit(WidgetUtil.getNumberFromField(etDebit));
            model.setJumlahKredit(WidgetUtil.getNumberFromField(etKredit));
            model.setFrekuensiDebit(WidgetUtil.getNumberFromField(etFrekuensiDebit));
            model.setFrekuensiKredit(WidgetUtil.getNumberFromField(etFrekuensiKredit));

            mAktivitasRekeningModel.add(model);
        }

        return mAktivitasRekeningModel;
    }

    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickTambahAktivitas() {
        int count = vAktivitasBank.getChildCount();
        if (count < Constant.MAX_AKTIVITAS_REKENING) {
            addAktivitasItem(null);
        }
    }

    private void addAktivitasItem(final SurveyAktivitasRekeningModel model) {
        int rowNum = vAktivitasBank.getChildCount();
        View view = LayoutInflater.from(this).inflate(R.layout.item_aktivitas_rek_bank, null);
        EditText etNamaBank = ButterKnife.findById(view, R.id.et_nama_bank);

        Spinner spinnerBulan = ButterKnife.findById(view, R.id.spinner_month);
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(this));
        TextView tvNumber = ButterKnife.findById(view, R.id.tv_count_number);
        tvNumber.setText(String.valueOf(rowNum + 1));
        final EditText etDebit = ButterKnife.findById(view, R.id.et_debit);
        WidgetUtil.setTextWatcherCurrency(etDebit);
        final EditText etKredit = ButterKnife.findById(view, R.id.et_kredit);
        WidgetUtil.setTextWatcherCurrency(etKredit);
        final EditText etFrekuensiDebit = ButterKnife.findById(view, R.id.et_frekuensi_debit);
        WidgetUtil.setTextWatcherCurrency(etFrekuensiDebit);
        final EditText etFrekuensiKredit = ButterKnife.findById(view, R.id.et_frekuensi_kredit);
        WidgetUtil.setTextWatcherCurrency(etFrekuensiKredit);
        View ivDelete = ButterKnife.findById(view, R.id.delete_aktivitas_rek);
        if (formMode == FormMode.VIEW || rowNum == 0) {
            ivDelete.setVisibility(View.GONE);
        } else {
            ivDelete.setVisibility(View.VISIBLE);
        }
        ivDelete.setTag(view);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (vAktivitasBank.getChildCount() > 1) {
                    DialogFactory.showConfirmation(FormSurveyKapasitasUsahaActivity.this, "", "Hapus Aktivitas?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View container = (View) v.getTag();
                            vAktivitasBank.removeView(container);
                            resetAktivitasNumber();
                        }
                    });
                } else {
                    DialogFactory.showAlert(FormSurveyKapasitasUsahaActivity.this, "Aktivitas tidak bisa di hapus, minimal harus ada satu");
                }

            }
        });

        if (model != null) {
            spinnerBulan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spinnerBulan, model.getBulan()));
            etNamaBank.setText(model.getNama_bank());
            etDebit.setText(model.getJumlahDebit());
            etKredit.setText(model.getJumlahKredit());
            etFrekuensiDebit.setText(model.getFrekuensiDebit());
            etFrekuensiKredit.setText(model.getFrekuensiKredit());
        }

        vAktivitasBank.addView(view);

    }

    private void resetAktivitasNumber() {
        int rowNum = vAktivitasBank.getChildCount();
        for (int i = 0; i < rowNum; i++) {
            View view = vAktivitasBank.getChildAt(i);
            TextView tvNumber = ButterKnife.findById(view, R.id.tv_count_number);
            tvNumber.setText(String.valueOf(i + 1));
        }
    }

    @Override
    public void onGetKapasitasUsahaSuccess(KapasitasUsahaResponse response) {
        if (response != null) {
            kapasitasUsahaModels = response.getSurveyKapasitasUsahaModelList();
            aktivitasRekeningModels = response.getAktivitasRekeningModelList();
        }
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetKapsitasUsahaFailure(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveKapasitasUsahaSuccess(String message) {
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
    public void onSaveKapasitasUsahaFailure(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
