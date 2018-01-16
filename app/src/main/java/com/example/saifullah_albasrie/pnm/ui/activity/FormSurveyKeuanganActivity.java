package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyKeuanganCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyKeuanganController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDataPinjamanModel;
import com.example.saifullah_albasrie.pnm.model.SurveyKeuanganModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeuanganRequest;
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
 * Created by aldhiramdan on 3/31/17.
 */

public class FormSurveyKeuanganActivity extends BaseFormActivity implements SurveyKeuanganCallback {

    //private int formMode;
    private ProspekListItemModel mDataModel;
    private SurveyKeuanganModel keuanganModel;
    private List<SurveyDataPinjamanModel> pinjamanModels;

    private SurveyKeuanganController controller;

    @BindView(R.id.tv_pendapatan)
    EditText tvPendapatan;
    @BindView(R.id.tv_harga_pokok)
    EditText tvHargaPokok;
    @BindView(R.id.tv_upah_tenaga)
    EditText tvUpahTenaga;
    @BindView(R.id.tv_sewa_tempat)
    EditText tvSewaTempat;
    @BindView(R.id.tv_sewa_lainnya)
    EditText tvSewaLainnya;
    @BindView(R.id.tv_biaya_listrik)
    EditText tvBiayaListrik;
    @BindView(R.id.tv_biaya_lainnya)
    EditText tvBiayaLainnya;
    @BindView(R.id.tv_pendapatan_usaha_lain_1)
    EditText tvPendapatanLain1;
    @BindView(R.id.tv_pendapatan_usaha_lain_2)
    EditText tvPendapatanLain2;
    @BindView(R.id.tv_gaji_debitur)
    EditText tvGajiDebitur;
    @BindView(R.id.tv_gaji_pasangan)
    EditText tvGajiPasangan;
    @BindView(R.id.tv_biaya_orangtua)
    EditText tvBiayaOrangtua;
    @BindView(R.id.tv_biaya_anak)
    EditText tvBiayaAnak;
    @BindView(R.id.tv_biaya_tanggungan_lain)
    EditText tvBiayaTanggunganLain;
    @BindView(R.id.spinner_other_business)
    Spinner spAdaUsahaLain;
    @BindView(R.id.spinner_mentioned_of_business)
    Spinner spUsahaLian;
    @BindView(R.id.spinner_other_salary_income)
    Spinner spAdaPendapatanLain;

    @BindView(R.id.tv_executive_summary)
    EditText tvExum;

    @BindView(R.id.ll_btn_tambah)
    View vButtonTambah;

    @BindView(R.id.ll_container_data_pinjaman)
    LinearLayout vContainerDataPinjaman;

    @BindView(R.id.tv_total_biaya)
    EditText tvTotalBiaya;
    @BindView(R.id.tv_total_keuntungan)
    EditText tvTotalKeuntungan;
    @BindView(R.id.tv_total_penghasilan_bersih_lain)
    EditText tvTotalPenghasilanBersihUsahaLain;
    @BindView(R.id.tv_total_gaji)
    EditText tvTotalGaji;
    @BindView(R.id.tv_total_penghasilan)
    EditText tvTotalPenghasilan;
    @BindView(R.id.tv_total_biaya_rt)
    EditText tvTotalBiayaRT;
    @BindView(R.id.tv_sisa_penghasilan)
    EditText tvSisaPenghasilan;
    @BindView(R.id.tv_penghasilan_bersih)
    EditText tvPenghasilanBersih;
    @BindView(R.id.tv_total_angsuran)
    EditText tvTotalAngsuranSaatIni;

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyKeuanganActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_keuangan;
    }


    @Override
    public void initData() {
        controller = new SurveyKeuanganController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        WidgetUtil.setTextWatcherCurrency(tvPendapatan);
        WidgetUtil.setTextWatcherCurrency(tvHargaPokok);
        WidgetUtil.setTextWatcherCurrency(tvUpahTenaga);
        WidgetUtil.setTextWatcherCurrency(tvSewaTempat);
        WidgetUtil.setTextWatcherCurrency(tvSewaLainnya);
        WidgetUtil.setTextWatcherCurrency(tvBiayaListrik);
        WidgetUtil.setTextWatcherCurrency(tvBiayaLainnya);
        WidgetUtil.setTextWatcherCurrency(tvPendapatanLain1);
        WidgetUtil.setTextWatcherCurrency(tvPendapatanLain2);
        WidgetUtil.setTextWatcherCurrency(tvGajiDebitur);
        WidgetUtil.setTextWatcherCurrency(tvGajiPasangan);
        WidgetUtil.setTextWatcherCurrency(tvBiayaOrangtua);
        WidgetUtil.setTextWatcherCurrency(tvBiayaAnak);
        WidgetUtil.setTextWatcherCurrency(tvBiayaTanggunganLain);

        WidgetUtil.setTextWatcherCurrency(tvTotalAngsuranSaatIni);

        WidgetUtil.setDataMasterAdapter(spUsahaLian, DataManager.getInstance().getJenisUsahaModelList());

        tvPendapatan.addTextChangedListener(textWatcherKeuntungan);
        tvHargaPokok.addTextChangedListener(textWatcherKeuntungan);
        tvUpahTenaga.addTextChangedListener(textWatcherBiaya);
        tvSewaTempat.addTextChangedListener(textWatcherBiaya);
        tvSewaLainnya.addTextChangedListener(textWatcherBiaya);
        tvBiayaListrik.addTextChangedListener(textWatcherBiaya);
        tvBiayaLainnya.addTextChangedListener(textWatcherBiaya);

        tvPendapatanLain1.addTextChangedListener(textWatcherPenghasilanBersih);
        tvPendapatanLain2.addTextChangedListener(textWatcherPenghasilanBersih);

        tvGajiDebitur.addTextChangedListener(textWatcherGaji);
        tvGajiPasangan.addTextChangedListener(textWatcherGaji);

        tvBiayaOrangtua.addTextChangedListener(textWatcherBiayaRT);
        tvBiayaAnak.addTextChangedListener(textWatcherBiayaRT);
        tvBiayaTanggunganLain.addTextChangedListener(textWatcherBiayaRT);

        tvTotalAngsuranSaatIni.addTextChangedListener(textWatcherAngsuran);

        spAdaUsahaLain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spUsahaLian.setEnabled(false);
                    spUsahaLian.setSelection(0);
                    tvPendapatanLain1.setText("");
                    tvPendapatanLain1.setEnabled(false);
                    tvPendapatanLain2.setText("");
                    tvPendapatanLain2.setEnabled(false);
                } else {
                    spUsahaLian.setEnabled(true);
                    tvPendapatanLain1.setEnabled(true);
                    tvPendapatanLain2.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spAdaPendapatanLain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    tvGajiDebitur.setText("");
                    tvGajiDebitur.setEnabled(false);
                    tvGajiPasangan.setText("");
                    tvGajiPasangan.setEnabled(false);
                } else {
                    tvGajiDebitur.setEnabled(true);
                    tvGajiPasangan.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        if (vContainerDataPinjaman.getChildCount() == 0) {
            addDataPinjaman(null);
        }

    }


    @Override
    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyKeuangan(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }


    @Override
    public void setupView() {
        if (keuanganModel != null) {
            tvPendapatan.setText(keuanganModel.getJumlahPendapatan());
            tvHargaPokok.setText(keuanganModel.getHargaPokok());
            tvUpahTenaga.setText(keuanganModel.getBiayaTenagaKerja());
            tvSewaTempat.setText(keuanganModel.getBiayaSewaUsaha());
            tvSewaLainnya.setText(keuanganModel.getBiayaSewaLain());
            tvBiayaListrik.setText(keuanganModel.getBiayaOperasional());
            tvBiayaLainnya.setText(keuanganModel.getBiayaLain());
            tvPendapatanLain1.setText(keuanganModel.getPenghasilanBersihUsaha1());
            tvPendapatanLain2.setText(keuanganModel.getPenghasilanBersihUsaha2());
            tvGajiDebitur.setText(keuanganModel.getGajiDebitur());
            tvGajiPasangan.setText(keuanganModel.getGajiPasangan());
            tvBiayaOrangtua.setText(keuanganModel.getBiayaRtPasangan());
            tvBiayaAnak.setText(keuanganModel.getBiayaRtAnak());
            tvBiayaTanggunganLain.setText(keuanganModel.getBiayaRtTanggungan());
            spUsahaLian.setSelection(WidgetUtil.getSpinnerIndexByLabel(spUsahaLian, keuanganModel.getNamaUsahaLainnya()));
            spAdaUsahaLain.setSelection(keuanganModel.getIsUsahaLain());
            spAdaPendapatanLain.setSelection(keuanganModel.getIsGajiPasangan());
            tvExum.setText(keuanganModel.getExum());

            /*
            tvTotalBiaya.setText(keuanganModel.getTotalBiayaUsaha());
            tvTotalKeuntungan.setText(keuanganModel.getKeuntunganUsaha());
            tvTotalPenghasilanBersihUsahaLain.setText(keuanganModel.getTotalPenghasilanBersihUsahaLain());
            tvTotalGaji.setText(keuanganModel.getTotalGaji());
            tvTotalPenghasilan.setText(keuanganModel.getTotalPenghasilan());
            tvTotalBiayaRT.setText(keuanganModel.getTotalBiayaRT());
            tvSisaPenghasilan.setText(keuanganModel.getSisaPenghasilan());
            tvPenghasilanBersih.setText(keuanganModel.getTotalPenghasilanBersih());
            */
            tvTotalAngsuranSaatIni.setText(keuanganModel.getTotalAngsuranSaatIni());

        }

        vContainerDataPinjaman.removeAllViews();
        if (pinjamanModels != null && pinjamanModels.size() > 0) {
            for (SurveyDataPinjamanModel model : pinjamanModels) {
                addDataPinjaman(model);
            }
        }

        if (vContainerDataPinjaman.getChildCount() == 0) {
            addDataPinjaman(null);
        }

        setupMode();
    }

    @Override
    public void setEnableItems(boolean enable) {
        tvPendapatan.setEnabled(enable);
        tvHargaPokok.setEnabled(enable);
        tvUpahTenaga.setEnabled(enable);
        tvSewaTempat.setEnabled(enable);
        tvSewaLainnya.setEnabled(enable);
        tvBiayaListrik.setEnabled(enable);
        tvBiayaLainnya.setEnabled(enable);
        spAdaUsahaLain.setEnabled(enable);
        if (spAdaUsahaLain.getSelectedItemPosition() == 0) {
            spUsahaLian.setEnabled(false);
            tvPendapatanLain1.setEnabled(false);
            tvPendapatanLain2.setEnabled(false);
        } else {
            spUsahaLian.setEnabled(enable);
            tvPendapatanLain1.setEnabled(enable);
            tvPendapatanLain2.setEnabled(enable);
        }
        //spUsahaLian.setEnabled(enable);
        //tvPendapatanLain1.setEnabled(enable);
        //tvPendapatanLain2.setEnabled(enable);

        tvGajiDebitur.setEnabled(enable);
        tvGajiPasangan.setEnabled(enable);
        tvBiayaOrangtua.setEnabled(enable);
        tvBiayaAnak.setEnabled(enable);
        tvBiayaTanggunganLain.setEnabled(enable);

        spAdaPendapatanLain.setEnabled(enable);
        if (spAdaPendapatanLain.getSelectedItemPosition() == 0) {
            tvGajiDebitur.setEnabled(false);
            tvGajiPasangan.setEnabled(false);
        } else {
            tvGajiDebitur.setEnabled(enable);
            tvGajiPasangan.setEnabled(enable);
        }
        tvExum.setEnabled(enable);

        tvTotalAngsuranSaatIni.setEnabled(enable);

        vButtonTambah.setVisibility(enable ? View.VISIBLE : View.GONE);

        for (int i = 0; i < vContainerDataPinjaman.getChildCount(); i++) {
            View view = vContainerDataPinjaman.getChildAt(i);
            View ivDelete = ButterKnife.findById(view, R.id.delete_pinjaman);
            if (enable && i > 0) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }

            /*Spinner spProduk = ButterKnife.findById(view, R.id.spinner_product);
            Spinner spProgram = ButterKnife.findById(view, R.id.spinner_program);
            EditText tvBunga = ButterKnife.findById(view, R.id.tv_bunga);
            //EditText tvTenor = ButterKnife.findById(view, R.id.tv_tennor);
            EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
            EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
            EditText tvKeterangan = ButterKnife.findById(view, R.id.tv_keterangan);
            spProduk.setEnabled(enable);
            spProgram.setEnabled(enable);
            tvBunga.setEnabled(enable);
            //tvTenor.setEnabled(enable);
            tvPlafond.setEnabled(enable);
            tvAngsuran.setEnabled(enable);
            tvKeterangan.setEnabled(enable);*/

            EditText tvNamaBank = ButterKnife.findById(view, R.id.tv_nama_bank);
            EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
            EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
            EditText tvOutstanding = ButterKnife.findById(view, R.id.tv_outstanding_pinjaman);
            EditText tvKolektibilitas = ButterKnife.findById(view, R.id.tv_kolektibilitas);
            EditText tvTujuan = ButterKnife.findById(view, R.id.tv_tujuan_pinjaman);
            ImageView picketDateJatuhTempo = ButterKnife.findById(view, R.id.picker_date);

            tvNamaBank.setEnabled(enable);
            tvPlafond.setEnabled(enable);
            tvAngsuran.setEnabled(enable);
            tvOutstanding.setEnabled(enable);
            tvKolektibilitas.setEnabled(enable);
            tvTujuan.setEnabled(enable);
            picketDateJatuhTempo.setEnabled(enable);
        }
    }

    private TextWatcher textWatcherKeuntungan = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateKeuntunganUsaha();
        }
    };

    private TextWatcher textWatcherBiaya = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateTotalBiayaUsaha();
        }
    };

    private TextWatcher textWatcherPenghasilanBersih = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculatePenghasilanBersihUsahaLain();
        }
    };

    private TextWatcher textWatcherGaji = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateGaji();
        }
    };

    private TextWatcher textWatcherBiayaRT = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateTotalBiayaRumahTangga();
        }
    };

    private TextWatcher textWatcherAngsuran = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateTotalPenghasilanBersih();
        }
    };

    private void calculateTotalBiayaUsaha() {
        double d1 = WidgetUtil.getNumberValueFromField(tvUpahTenaga);
        double d2 = WidgetUtil.getNumberValueFromField(tvSewaTempat);
        double d3 = WidgetUtil.getNumberValueFromField(tvSewaLainnya);
        double d4 = WidgetUtil.getNumberValueFromField(tvBiayaListrik);
        double d5 = WidgetUtil.getNumberValueFromField(tvBiayaLainnya);
        double dTotal = d1 + d2 + d3 + d4 + d5;
        tvTotalBiaya.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateKeuntunganUsaha();
    }

    private void calculateKeuntunganUsaha() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPendapatan);
        double d2 = WidgetUtil.getNumberValueFromField(tvHargaPokok);
        double d3 = WidgetUtil.getNumberValueFromField(tvTotalBiaya);
        double dTotal = d1 - d2 - d3;
        tvTotalKeuntungan.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateTotalPenghasilan();
    }

    private void calculatePenghasilanBersihUsahaLain() {
        double d1 = WidgetUtil.getNumberValueFromField(tvPendapatanLain1);
        double d2 = WidgetUtil.getNumberValueFromField(tvPendapatanLain2);
        double dTotal = d1 + d2;
        tvTotalPenghasilanBersihUsahaLain.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateTotalPenghasilan();
    }

    private void calculateGaji() {
        double d1 = WidgetUtil.getNumberValueFromField(tvGajiDebitur);
        double d2 = WidgetUtil.getNumberValueFromField(tvGajiPasangan);
        double dTotal = d1 + d2;
        tvTotalGaji.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateTotalPenghasilan();
    }

    private void calculateTotalPenghasilan() {
        double d1 = WidgetUtil.getNumberValueFromField(tvTotalKeuntungan);
        double d2 = WidgetUtil.getNumberValueFromField(tvTotalPenghasilanBersihUsahaLain);
        double d3 = WidgetUtil.getNumberValueFromField(tvTotalGaji);
        double dTotal = d1 + d2 + d3;
        tvTotalPenghasilan.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateSisaPenghasilan();
    }

    private void calculateTotalBiayaRumahTangga() {
        double d1 = WidgetUtil.getNumberValueFromField(tvBiayaOrangtua);
        double d2 = WidgetUtil.getNumberValueFromField(tvBiayaAnak);
        double d3 = WidgetUtil.getNumberValueFromField(tvBiayaTanggunganLain);
        double dTotal = d1 + d2 + d3;
        tvTotalBiayaRT.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateSisaPenghasilan();
    }

    private void calculateSisaPenghasilan() {
        double d1 = WidgetUtil.getNumberValueFromField(tvTotalPenghasilan);
        double d2 = WidgetUtil.getNumberValueFromField(tvTotalBiayaRT);
        double dTotal = d1 - d2;
        tvSisaPenghasilan.setText(WidgetUtil.convertToLocalCurrency(dTotal));
        calculateTotalPenghasilanBersih();
    }

    private void calculateTotalPenghasilanBersih() {
        double d1 = WidgetUtil.getNumberValueFromField(tvSisaPenghasilan);
        double d2 = WidgetUtil.getNumberValueFromField(tvTotalAngsuranSaatIni);
        double dTotal = d1 - d2;
        tvPenghasilanBersih.setText(WidgetUtil.convertToLocalCurrency(dTotal));
    }


    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickTambahDataPinjaman() {
        int count = vContainerDataPinjaman.getChildCount();
        if (count < Constant.MAX_DATA_PINJAMAN) {
            addDataPinjaman(null);
        }
    }

    private void addDataPinjaman(SurveyDataPinjamanModel model) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_data_pinjaman2, null);
        TextView tvNumber = ButterKnife.findById(view, R.id.tv_nomor_pinjaman);
        tvNumber.setText(String.valueOf(vContainerDataPinjaman.getChildCount() + 1));

        View ivDelete = ButterKnife.findById(view, R.id.delete_pinjaman);
        if (ivDelete != null) {
            if (vContainerDataPinjaman.getChildCount() > 0 && formMode != FormMode.VIEW) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }

            ivDelete.setTag(view);
            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (vContainerDataPinjaman.getChildCount() > 1) {
                        DialogFactory.showConfirmation(FormSurveyKeuanganActivity.this, "", "Hapus Data Pinjaman?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View container = (View) v.getTag();
                                vContainerDataPinjaman.removeView(container);
                                resetNumber();
                            }
                        });
                    }

                }
            });
        }

        /*Spinner spProduk = ButterKnife.findById(view, R.id.spinner_product);
        Spinner spProgram = ButterKnife.findById(view, R.id.spinner_program);
        EditText tvBunga = ButterKnife.findById(view, R.id.tv_bunga);
        EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
        EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
        EditText tvKeterangan = ButterKnife.findById(view, R.id.tv_keterangan);
        WidgetUtil.setDataMasterAdapter(spProduk, DataManager.getInstance().getProdukModelList());
        WidgetUtil.setDataMasterAdapter(spProgram, DataManager.getInstance().getProgramModelList());

        WidgetUtil.setTextWatcherCurrency(tvPlafond);
        WidgetUtil.setTextWatcherCurrency(tvAngsuran);
        */

        EditText tvNamaBank = ButterKnife.findById(view, R.id.tv_nama_bank);
        EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
        EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
        EditText tvOutstanding = ButterKnife.findById(view, R.id.tv_outstanding_pinjaman);
        EditText tvKolektibilitas = ButterKnife.findById(view, R.id.tv_kolektibilitas);
        EditText tvTujuan = ButterKnife.findById(view, R.id.tv_tujuan_pinjaman);
        final TextView tvJatuhTempo = ButterKnife.findById(view, R.id.tv_tgl_jatuh_tempo);
        ImageView pickerDateJatuhTempo = ButterKnife.findById(view, R.id.picker_date);
        pickerDateJatuhTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WidgetUtil.showDatePicker(FormSurveyKeuanganActivity.this, tvJatuhTempo);
            }
        });

        WidgetUtil.setTextWatcherCurrency(tvPlafond, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvAngsuran, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvOutstanding, Constant.MAX_PLAFOND_VALUE);

        if (model != null) {
            tvNamaBank.setText(model.getNamaBank());
            tvPlafond.setText(WidgetUtil.convertToLocalCurrency(model.getPlafond()));
            tvAngsuran.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuran()));
            tvOutstanding.setText(WidgetUtil.convertToLocalCurrency(model.getOutstanding()));
            tvTujuan.setText(model.getTujuanPembiayaan());
            tvKolektibilitas.setText(model.getKolektibilitas());
            tvJatuhTempo.setText(DateUtil.convertDateToNormal(model.getJatuhTempo()));
        }

        vContainerDataPinjaman.addView(view);

    }

    private void resetNumber() {
        for (int i = 0; i < vContainerDataPinjaman.getChildCount(); i++) {
            View view = vContainerDataPinjaman.getChildAt(i);
            TextView tvNumber = ButterKnife.findById(view, R.id.tv_nomor_pinjaman);
            tvNumber.setText(String.valueOf(i + 1));
        }
    }

    private List<SurveyDataPinjamanModel> validatePinjaman() {
        List<SurveyDataPinjamanModel> data = new ArrayList();
        for (int i = 0; i < vContainerDataPinjaman.getChildCount(); i++) {
            View view = vContainerDataPinjaman.getChildAt(i);

            /*Spinner spProduk = ButterKnife.findById(view, R.id.spinner_product);
            Spinner spProgram = ButterKnife.findById(view, R.id.spinner_program);
            EditText tvBunga = ButterKnife.findById(view, R.id.tv_bunga);
            //EditText tvTenor = ButterKnife.findById(view, R.id.tv_tennor);
            EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
            EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
            EditText tvKeterangan = ButterKnife.findById(view, R.id.tv_keterangan);*/

            EditText tvNamaBank = ButterKnife.findById(view, R.id.tv_nama_bank);
            EditText tvPlafond = ButterKnife.findById(view, R.id.tv_plafond);
            EditText tvAngsuran = ButterKnife.findById(view, R.id.tv_angsuran);
            EditText tvOutstanding = ButterKnife.findById(view, R.id.tv_outstanding_pinjaman);
            EditText tvKolektibilitas = ButterKnife.findById(view, R.id.tv_kolektibilitas);
            EditText tvTujuan = ButterKnife.findById(view, R.id.tv_tujuan_pinjaman);
            TextView tvJatuhTempo = ButterKnife.findById(view, R.id.tv_tgl_jatuh_tempo);

            SurveyDataPinjamanModel model = new SurveyDataPinjamanModel();
            model.setNamaBank(tvNamaBank.getText().toString());
            model.setPlafond(WidgetUtil.getNumberFromField(tvPlafond));
            model.setAngsuran(WidgetUtil.getNumberFromField(tvAngsuran));
            model.setOutstanding(WidgetUtil.getNumberFromField(tvOutstanding));
            model.setKolektibilitas(tvKolektibilitas.getText().toString());
            model.setTujuanPembiayaan(tvTujuan.getText().toString());
            model.setJatuhTempo(DateUtil.convertDateToDB(tvJatuhTempo.getText().toString()));

            data.add(model);
        }
        return data;
    }

    @Override
    public void saveData() {
        SurveyKeuanganModel newModel = new SurveyKeuanganModel();
        newModel.setJumlahPendapatan(WidgetUtil.getNumberFromField(tvPendapatan));
        newModel.setHargaPokok(WidgetUtil.getNumberFromField(tvHargaPokok));
        newModel.setBiayaTenagaKerja(WidgetUtil.getNumberFromField(tvUpahTenaga));
        newModel.setBiayaSewaUsaha(WidgetUtil.getNumberFromField(tvSewaTempat));
        newModel.setBiayaSewaLain(WidgetUtil.getNumberFromField(tvSewaLainnya));
        newModel.setBiayaOperasional(WidgetUtil.getNumberFromField(tvBiayaListrik));
        newModel.setBiayaLain(WidgetUtil.getNumberFromField(tvBiayaLainnya));
        newModel.setPenghasilanBersihUsaha1(WidgetUtil.getNumberFromField(tvPendapatanLain1));
        newModel.setPenghasilanBersihUsaha2(WidgetUtil.getNumberFromField(tvPendapatanLain2));
        newModel.setGajiDebitur(WidgetUtil.getNumberFromField(tvGajiDebitur));
        newModel.setGajiPasangan(WidgetUtil.getNumberFromField(tvGajiPasangan));
        newModel.setBiayaRtPasangan(WidgetUtil.getNumberFromField(tvBiayaOrangtua));
        newModel.setBiayaRtAnak(WidgetUtil.getNumberFromField(tvBiayaAnak));
        newModel.setBiayaRtTanggungan(WidgetUtil.getNumberFromField(tvBiayaTanggunganLain));

        newModel.setTotalBiayaUsaha(WidgetUtil.getNumberFromField(tvTotalBiaya));
        newModel.setKeuntunganUsaha(WidgetUtil.getNumberFromField(tvTotalKeuntungan));
        newModel.setTotalPenghasilanBersihUsahaLain(WidgetUtil.getNumberFromField(tvTotalPenghasilanBersihUsahaLain));
        newModel.setTotalGaji(WidgetUtil.getNumberFromField(tvTotalGaji));
        newModel.setTotalPenghasilan(WidgetUtil.getNumberFromField(tvTotalPenghasilan));
        newModel.setTotalBiayaRT(WidgetUtil.getNumberFromField(tvTotalBiayaRT));
        newModel.setSisaPenghasilan(WidgetUtil.getNumberFromField(tvSisaPenghasilan));
        newModel.setTotalAngsuranSaatIni(WidgetUtil.getNumberFromField(tvTotalAngsuranSaatIni));
        newModel.setTotalPenghasilanBersih(WidgetUtil.getNumberFromField(tvPenghasilanBersih));

        JenisUsahaModel jenisUsahaModel = (JenisUsahaModel) spUsahaLian.getSelectedItem();
        if (jenisUsahaModel != null) {
            newModel.setBidangUsahaLain(jenisUsahaModel.getId());
            newModel.setNamaUsahaLainnya(jenisUsahaModel.getNamaJenisUsaha());
        }

        newModel.setIsUsahaLain(spAdaUsahaLain.getSelectedItemPosition());
        newModel.setIsGajiPasangan(spAdaPendapatanLain.getSelectedItemPosition());
        newModel.setExum(tvExum.getText().toString());

        List<SurveyDataPinjamanModel> dataPinjaman = validatePinjaman();
        if (dataPinjaman == null) {
            return;
        }

        keuanganModel = newModel;
        pinjamanModels = new ArrayList<>();
        pinjamanModels.addAll(dataPinjaman);

        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());

        SurveyKeuanganRequest request = new SurveyKeuanganRequest(biodataModel, keuanganModel, pinjamanModels);
        DialogFactory.showProgress(this);
        controller.saveSurveyKeuangan(request);
    }

    @Override
    public void onGetSurveyKeuanganSuccess(List<SurveyKeuanganModel> keuanganModel, List<SurveyDataPinjamanModel> dataPinjamanModels) {
        if (keuanganModel != null && keuanganModel.size() > 0) {
            this.keuanganModel = keuanganModel.get(0);
        }

        if (dataPinjamanModels != null) {
            this.pinjamanModels = dataPinjamanModels;
        }

        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyKeuanganFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveSurveyKeuanganSuccess(String message) {
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
    public void onSaveSurveyKeuanganFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
