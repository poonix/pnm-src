package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKebutuhanModalKerjaCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyKebutuhanModalKerjaController;
import com.example.saifullah_albasrie.pnm.model.AssetModel;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.KebutuhanModalKerjaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.response.KebutuhanModalKerjaResponse;
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
 * Created by aldhiramdan on 3/26/17.
 */

public class FormSurveyKebutuhanModalKerjaActivity extends BaseFormActivity implements SurveyKebutuhanModalKerjaCallback{

    private ProspekListItemModel mDataModel;
    private KebutuhanModalKerjaModel modalKerjaModel;
    private List<AssetModel> assetModel;

    private SurveyKebutuhanModalKerjaController controller;

    @BindView(R.id.tv_posisi_akhir_bulan)
    TextView tvDate;
    @BindView(R.id.picker_date)
    View ivPickerDate;

    @BindView(R.id.tv_persediaan_dagang)
    EditText tvPersediaanDagang;
    @BindView(R.id.tv_persediaan_lainnya)
    EditText tvPersediaanLainnya;
    @BindView(R.id.tv_total_persediaan_dagang)
    EditText tvPersediaanTotal;

    @BindView(R.id.tv_piutang_dagang)
    EditText tvPiutangDagang;
    @BindView(R.id.tv_piutang_lainnya)
    EditText tvPiutangLain;
    @BindView(R.id.tv_total_piutang_dagang)
    EditText tvPiutangDagangTotal;

    @BindView(R.id.tv_hutang_dagang)
    EditText tvHutangDagang;
    @BindView(R.id.tv_hutang_lainnya)
    EditText tvHutangLain;
    @BindView(R.id.tv_total_hutang_dagang)
    EditText tvHutangDagangTotal;

    @BindView(R.id.tv_modal_kerja)
    EditText tvModalKerja;

    @BindView(R.id.tv_investasi)
    EditText tvInvestasi;

    /*
    @BindView(R.id.tv_perputaran_barang_per_hari)
    EditText tvPerputaranBarangPerhari;
    @BindView(R.id.tv_piutang_perhari)
    EditText tvPiutangPerhari;
    @BindView(R.id.tv_hutang_dagang_per_hari)
    EditText tvHutangDagangPerhari;
    @BindView(R.id.tv_modal_perhari)
    EditText tvModalPerhari;
    */

    @BindView(R.id.tv_trend_keuangan)
    EditText tvTrendKeuangan;
    @BindView(R.id.tv_pendapatan_tahun_lalu)
    EditText tvPendapatanTahunLalu;
    @BindView(R.id.tv_penghasilan_tahun_lalu)
    EditText tvPenghasilanTahunLalu;
    @BindView(R.id.tv_modal_tahun_lallu)
    EditText tvModalTahunLalu;
    //@BindView(R.id.tv_total_uang)
    //EditText tvTotalUang;
    @BindView(R.id.tv_executive_summary_persediaan)
    EditText tvExumPersediaan;
    @BindView(R.id.tv_executive_summary_omzet)
    EditText tvExumOmzet;
    @BindView(R.id.ll_btn_tambah)
    View vButtonTambah;

    @BindView(R.id.layout_asset)
    LinearLayout vContainerAset;


    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyKebutuhanModalKerjaActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_kebutuhan_modal_kerja;
    }


    @Override
    public void initData() {
        controller = new SurveyKebutuhanModalKerjaController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        WidgetUtil.setTextWatcherCurrency(tvPersediaanDagang);
        WidgetUtil.setTextWatcherCurrency(tvPersediaanLainnya);
        WidgetUtil.setTextWatcherCurrency(tvPersediaanTotal);

        WidgetUtil.setTextWatcherCurrency(tvPiutangDagang);
        WidgetUtil.setTextWatcherCurrency(tvPiutangLain);
        WidgetUtil.setTextWatcherCurrency(tvPiutangDagangTotal);

        WidgetUtil.setTextWatcherCurrency(tvHutangDagang);
        WidgetUtil.setTextWatcherCurrency(tvHutangLain);
        WidgetUtil.setTextWatcherCurrency(tvHutangDagangTotal);

        WidgetUtil.setTextWatcherCurrency(tvModalKerja);
        WidgetUtil.setTextWatcherCurrency(tvInvestasi);

        WidgetUtil.setTextWatcherCurrency(tvPendapatanTahunLalu);
        WidgetUtil.setTextWatcherCurrency(tvPenghasilanTahunLalu);
        WidgetUtil.setTextWatcherCurrency(tvModalTahunLalu);
        //WidgetUtil.setTextWatcherCurrency(tvTotalUang);

        tvPersediaanDagang.addTextChangedListener(textWatcherPersediaanDagang);
        tvPersediaanLainnya.addTextChangedListener(textWatcherPersediaanDagang);
        tvPiutangDagang.addTextChangedListener(textWatcherPiutang);
        tvPiutangLain.addTextChangedListener(textWatcherPiutang);
        tvHutangDagang.addTextChangedListener(textWatcherHutang);
        tvHutangLain.addTextChangedListener(textWatcherHutang);

        if (vContainerAset.getChildCount() == 0) {
            addDataAsset(null);
        }
    }

    private TextWatcher textWatcherPersediaanDagang = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculatePersediaanDagang();
        }
    };

    private TextWatcher textWatcherPiutang = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculatePiutang();
        }
    };

    private TextWatcher textWatcherHutang = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateHutang();
        }
    };

    private void calculatePersediaanDagang() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPersediaanDagang);
        double d2 = WidgetUtil.getNumberValueFromField(tvPersediaanLainnya);
        double dTotal = d1 + d2;
        tvPersediaanTotal.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateModalKerja();
        //calculatePerputaranPersediaan();
    }

    private void calculatePiutang() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPiutangDagang);
        double d2 = WidgetUtil.getNumberValueFromField(tvPiutangLain);
        double dTotal = d1 + d2;
        tvPiutangDagangTotal.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateModalKerja();
        //calculatePerputaranPiutang();
    }

    private void calculateHutang() {
        double d1 = WidgetUtil.getNumberValueFromField(tvHutangDagang);
        double d2 = WidgetUtil.getNumberValueFromField(tvHutangLain);
        double dTotal = d1 + d2;
        tvHutangDagangTotal.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateModalKerja();
        //calculatePerputaranHutang();
    }

    private void calculateModalKerja() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPersediaanTotal);
        double d2 = WidgetUtil.getNumberValueFromField(tvPiutangDagangTotal);
        double d3 = WidgetUtil.getNumberValueFromField(tvHutangDagangTotal);
        double dModal = (d1 + d2) - d3;
        tvModalKerja.setText(WidgetUtil.convertToLocalCurrency(dModal));
    }

    /*
    private void calculatePerputaranPersediaan() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPersediaanTotal);
        double d2 = WidgetUtil.getNumberValueFromModel(modalKerjaModel.getHpp());
        if (d2 == 0) d2 = 1;
        double dTotal = d1 / d2 * 30;
        tvPerputaranBarangPerhari.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculatePerputaranModalKerja();
    }

    private void calculatePerputaranPiutang() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPiutangDagangTotal);
        double d2 = WidgetUtil.getNumberValueFromModel(modalKerjaModel.getPenjualan());
        if (d2 == 0) d2 = 1;
        double dTotal = d1 / d2 * 30;
        tvPiutangPerhari.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculatePerputaranModalKerja();
    }

    private void calculatePerputaranHutang() {
        double d1 = WidgetUtil.getNumberValueFromField(tvHutangDagangTotal);
        double d2 = WidgetUtil.getNumberValueFromModel(modalKerjaModel.getHpp());
        if (d2 == 0) d2 = 1;
        double dTotal = d1 / d2 * 30;
        tvHutangDagangPerhari.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculatePerputaranModalKerja();
    }

    private void calculatePerputaranModalKerja() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPerputaranBarangPerhari);
        double d2 = WidgetUtil.getNumberValueFromField(tvPiutangPerhari);
        double d3 = WidgetUtil.getNumberValueFromField(tvHutangDagangPerhari);
        double dModal = d1 + d2 - d3;
        tvModalPerhari.setText(WidgetUtil.convertToLocalCurrency(dModal));
    }*/


    @Override
    public void loadData() {
        if(mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyKMK(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    @Override
    public void setEnableItems(boolean enable) {
        tvDate.setEnabled(enable);
        ivPickerDate.setEnabled(enable);

        tvPersediaanDagang.setEnabled(enable);
        tvPersediaanLainnya.setEnabled(enable);
        tvPersediaanTotal.setEnabled(false);

        tvPiutangDagang.setEnabled(enable);
        tvPiutangLain.setEnabled(enable);
        tvPiutangDagangTotal.setEnabled(false);

        tvHutangDagang.setEnabled(enable);
        tvHutangLain.setEnabled(enable);
        tvHutangDagangTotal.setEnabled(false);

        tvModalKerja.setEnabled(false);

        tvInvestasi.setEnabled(enable);
        /*tvPerputaranBarangPerhari.setEnabled(enable);
        tvPiutangPerhari.setEnabled(enable);
        tvHutangDagangPerhari.setEnabled(enable);
        tvModalPerhari.setEnabled(enable);*/
        /*
        tvPerputaranBarangPerhari.setEnabled(false);
        tvPiutangPerhari.setEnabled(false);
        tvHutangDagangPerhari.setEnabled(false);
        tvModalPerhari.setEnabled(false);
        */
        tvTrendKeuangan.setEnabled(enable);
        tvPendapatanTahunLalu.setEnabled(enable);
        tvPenghasilanTahunLalu.setEnabled(enable);
        tvModalTahunLalu.setEnabled(enable);
        //tvTotalUang.setEnabled(enable);
        tvExumPersediaan.setEnabled(enable);
        tvExumOmzet.setEnabled(enable);


        vButtonTambah.setVisibility(enable ? View.VISIBLE : View.GONE);

        for (int i = 0; i < vContainerAset.getChildCount(); i++) {
            View view = vContainerAset.getChildAt(i);

            View ivDelete = ButterKnife.findById(view, R.id.delete_asset);
            if (enable && i > 0) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }

            Spinner spAsset = ButterKnife.findById(view, R.id.spinner_asset);
            EditText tvJumlah = ButterKnife.findById(view, R.id.tv_jumlah);
            spAsset.setEnabled(enable);
            tvJumlah.setEnabled(enable);
        }

    }

    @Override
    public void saveData() {
        //get and validate model
        KebutuhanModalKerjaModel modalKerja = new KebutuhanModalKerjaModel();
        modalKerja.setPosisiAkhir(DateUtil.convertDateToDB(tvDate.getText().toString()));
        modalKerja.setPersediaanDagang(WidgetUtil.getNumberFromField(tvPersediaanDagang));
        modalKerja.setPersediaanLain(WidgetUtil.getNumberFromField(tvPersediaanLainnya));
        modalKerja.setTotalPersediaan(WidgetUtil.getNumberFromField(tvPersediaanTotal));
        modalKerja.setPiutangDagang(WidgetUtil.getNumberFromField(tvPiutangDagang));
        modalKerja.setPiutangLain(WidgetUtil.getNumberFromField(tvPiutangLain));
        modalKerja.setTotalPiutang(WidgetUtil.getNumberFromField(tvPiutangDagangTotal));
        modalKerja.setUtangDagang(WidgetUtil.getNumberFromField(tvHutangDagang));
        modalKerja.setUtangLain(WidgetUtil.getNumberFromField(tvHutangLain));
        modalKerja.setTotalUtang(WidgetUtil.getNumberFromField(tvHutangDagangTotal));
        modalKerja.setModalKerja(WidgetUtil.getNumberFromField(tvModalKerja));
        modalKerja.setInvestasi(WidgetUtil.getNumberFromField(tvInvestasi));
        /*
        modalKerja.setPerputaranPersediaan(WidgetUtil.getNumberFromField(tvPerputaranBarangPerhari));
        modalKerja.setPerputaranPiutang(WidgetUtil.getNumberFromField(tvPiutangPerhari));
        modalKerja.setPerputaranUtang(WidgetUtil.getNumberFromField(tvHutangDagangPerhari));
        modalKerja.setPerputaranModal(WidgetUtil.getNumberFromField(tvModalPerhari));
        */
        modalKerja.setTrendKeuangan(WidgetUtil.getNumberFromField(tvTrendKeuangan));
        modalKerja.setOmzet(WidgetUtil.getNumberFromField(tvPendapatanTahunLalu));
        modalKerja.setLabaRugiTahunLalu(WidgetUtil.getNumberFromField(tvPenghasilanTahunLalu));
        modalKerja.setModalBersihTahunLalu(WidgetUtil.getNumberFromField(tvModalTahunLalu));
        //modalKerja.setTotalUtang(WidgetUtil.getNumberFromField(tvTotalUang));
        modalKerja.setExecutiveSummaryAspek(tvExumPersediaan.getText().toString());
        modalKerja.setExecutiveSummaryOmzet(tvExumOmzet.getText().toString());

        //get and validate asset model
        List<AssetModel> asset = validateAsset();

        modalKerjaModel = modalKerja;
        assetModel = asset;

        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());

        DialogFactory.showProgress(this);
        controller.saveKMK(biodataModel, modalKerjaModel, assetModel);
    }

    private List<AssetModel> validateAsset() {
        List<AssetModel> assets = new ArrayList<>();
        for (int i = 0; i < vContainerAset.getChildCount(); i++) {
            View view = vContainerAset.getChildAt(i);
            Spinner spAsset = ButterKnife.findById(view, R.id.spinner_asset);
            EditText tvJumlah = ButterKnife.findById(view, R.id.tv_jumlah);
            AssetModel model = new AssetModel();
            model.setIdJenisAset(spAsset.getSelectedItemPosition());
            model.setJenisAset(spAsset.getSelectedItem().toString());
            model.setJumlahAset(Integer.parseInt(WidgetUtil.getNumberFromField(tvJumlah)));
            assets.add(model);
        }
        return assets;
    }

    @OnClick(R.id.picker_date)
    void onCLick(View v) {
        switch (v.getId()) {
            case R.id.picker_date:
                WidgetUtil.showDatePicker(this, tvDate);
                break;
        }
    }

    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickTambahDataAset() {
        int count = vContainerAset.getChildCount();
        if (count < Constant.MAX_DATA_ASSET) {
            addDataAsset(null);
        }
    }

    private void addDataAsset(AssetModel model) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_data_asset, null);
        TextView tvNumber = ButterKnife.findById(view, R.id.tv_nomor_asset);
        tvNumber.setText(String.valueOf(vContainerAset.getChildCount() + 1));

        View ivDelete = ButterKnife.findById(view, R.id.delete_asset);
        if (ivDelete != null) {
            if (vContainerAset.getChildCount() > 0 && formMode != FormMode.VIEW) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }

            ivDelete.setTag(view);
            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (vContainerAset.getChildCount() > 1) {
                        DialogFactory.showConfirmation(FormSurveyKebutuhanModalKerjaActivity.this, "", "Hapus Data Aset?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View container = (View) v.getTag();
                                vContainerAset.removeView(container);
                                resetNumber();
                            }
                        });
                    }

                }
            });
        }

        Spinner spAsset = ButterKnife.findById(view, R.id.spinner_asset);
        EditText tvJumlah = ButterKnife.findById(view, R.id.tv_jumlah);
        WidgetUtil.setTextWatcherCurrency(tvJumlah);
        if (model != null) {
            //spAsset.setSelection(WidgetUtil.getSpinnerIndexByLabel(spAsset, model.getJenisAset()));
            int posJenisAsset = model.getIdJenisAset();
            if (posJenisAsset >= 0 && posJenisAsset < spAsset.getAdapter().getCount()) {
                spAsset.setSelection(posJenisAsset);
            }
            tvJumlah.setText(String.valueOf(model.getJumlahAset()));
        }

        vContainerAset.addView(view);

    }

    private void resetNumber() {
        for (int i = 0; i < vContainerAset.getChildCount(); i++) {
            View view = vContainerAset.getChildAt(i);
            TextView tvNumber = ButterKnife.findById(view, R.id.tv_nomor_asset);
            tvNumber.setText(String.valueOf(i + 1));
        }
    }

    @Override
    public void setupView() {
        if (modalKerjaModel != null) {
            tvDate.setText(DateUtil.convertDateToNormal(modalKerjaModel.getPosisiAkhir()));
            tvPersediaanDagang.setText(modalKerjaModel.getPersediaanDagang());
            tvPersediaanLainnya.setText(modalKerjaModel.getPersediaanLain());
            tvPersediaanTotal.setText(modalKerjaModel.getTotalPersediaan());
            tvPiutangDagang.setText(modalKerjaModel.getPiutangDagang());
            tvPiutangLain.setText(modalKerjaModel.getPiutangLain());
            tvPiutangDagangTotal.setText(modalKerjaModel.getTotalPiutang());
            tvHutangDagang.setText(modalKerjaModel.getUtangDagang());
            tvHutangLain.setText(modalKerjaModel.getUtangLain());
            tvHutangDagangTotal.setText(modalKerjaModel.getTotalUtang());
            tvModalKerja.setText(modalKerjaModel.getModalKerja());
            tvInvestasi.setText(modalKerjaModel.getInvestasi());

            /*tvPerputaranBarangPerhari.setText(modalKerjaModel.getPerputaranPersediaan());
            tvPiutangPerhari.setText(modalKerjaModel.getPerputaranPiutang());
            tvHutangDagangPerhari.setText(modalKerjaModel.getPerputaranUtang());
            tvModalPerhari.setText(modalKerjaModel.getPerputaranModal());
            */
            tvTrendKeuangan.setText(modalKerjaModel.getTrendKeuangan());
            tvPendapatanTahunLalu.setText(modalKerjaModel.getOmzet());
            tvPenghasilanTahunLalu.setText(modalKerjaModel.getLabaRugiTahunLalu());
            tvModalTahunLalu.setText(modalKerjaModel.getModalBersihTahunLalu());
            //tvTotalUang.setText(modalKerjaModel.getTotalUtang());
            tvExumPersediaan.setText(modalKerjaModel.getExecutiveSummaryAspek());
            tvExumOmzet.setText(modalKerjaModel.getExecutiveSummaryOmzet());
        }

        vContainerAset.removeAllViews();
        if (assetModel != null && assetModel.size() > 0) {
            for (AssetModel model : assetModel) {
                addDataAsset(model);
            }
        }

        setupMode();
    }

    @Override
    public void onGetSurveyKMKSuccess(KebutuhanModalKerjaResponse response) {
        if (response.getDataKmk() != null && response.getDataKmk().size() > 0) {
            modalKerjaModel = response.getDataKmk().get(0);
        }
        assetModel = response.getDataAset();
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyKMKFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());

    }

    @Override
    public void onSaveSurveyKMKSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //changeToViewMode();
                //setResult(RESULT_OK);
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });
    }

    @Override
    public void onSaveSurveyKMKFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
