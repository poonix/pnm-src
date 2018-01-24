package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master_new.BaseResponseNew;
import com.example.saifullah_albasrie.pnm.model.state.CheckIDIStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.CheckDebiturFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnCheckDebiturSelectedListener;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class ProspekTabBiodataFragment extends BaseFragment {

    private int formMode;
    private ProspekListItemModel mDataModel;
    private ProspekBiodataModel mBiodataModel;
    //public String checkIDIDone="0" ;
    private CheckDebiturFactory checkDebiturFactory;

    @BindView(R.id.include_search_debitur)
    View vCheckDebiturLayout;

    @BindView(R.id.sp_jenis_prospek)
    Spinner spJenisProspek;
    @BindView(R.id.tv_hint_jenis_prospek)
    TextView tvHintJenisProspek;
    @BindView(R.id.tv_hint_nama_panggilan)
    TextView tvHintNamaPanggilan;
    @BindView(R.id.tv_nickname)
    EditText tvNickname;
    @BindView(R.id.tv_hint_nama_lengkap)
    TextView tvHintNamaLengkap;
    @BindView(R.id.tv_fullname)
    EditText tvFullname;
    @BindView(R.id.tv_hint_jenis_alamat)
    TextView tvHintJenisAlamat;
    @BindView(R.id.sp_jenis_alamat)
    Spinner spJenisAlamat;
    @BindView(R.id.tv_hint_alamat)
    TextView tvHintAlamat;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    @BindView(R.id.tv_hint_jenis_kelamin)
    TextView tvHintJenisKelamin;
    @BindView(R.id.spinner_gender)
    Spinner spGender;
    @BindView(R.id.tv_hint_jenis_identitas)
    TextView tvHintJenisIdentitas;
    @BindView(R.id.spinner_id)
    Spinner spIdType;
    @BindView(R.id.tv_hint_nomor_telp)
    TextView tvHintNomorTelp;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_hint_nomor_identitas)
    TextView tvHintNomorIdentitas;
    @BindView(R.id.tv_identity_number)
    EditText tvIdentityNumber;
    @BindView(R.id.tv_hint_masa_berlaku)
    TextView tvHintMasaBerlaku;
    @BindView(R.id.tv_masa_berlaku)
    TextView tvMasaBerlaku;
    @BindView(R.id.picker_date)
    View vPickerDate;
    @BindView(R.id.tv_hint_nama_ibu_kandung)
    TextView tvHintNamaIbuKandung;
    @BindView(R.id.tv_mother_name)
    EditText tvMotherName;
    @BindView(R.id.cb_seumur_hidup)
    CheckBox cbSeumurHidup;
    @BindView(R.id.tv_hint_tempat_lahir)
    TextView tvHintTempatLahir;
    @BindView(R.id.tv_tempat_lahir)
    EditText tvTempatLahir;
    @BindView(R.id.tv_hint_tanggal)
    TextView tvHintTanggal;
    @BindView(R.id.spinner_tgl)
    Spinner spinnerTanggal;
    @BindView(R.id.tv_hint_bulan)
    TextView tvHintBulan;
    @BindView(R.id.spinner_bulan)
    Spinner spinnerBulan;
    @BindView(R.id.tv_hint_tahun)
    TextView tvHintTahun;
    @BindView(R.id.spinner_tahun)
    Spinner spinnerTahun;
    @BindView(R.id.tv_hint_jenis_usaha)
    TextView tvHintJenisUsaha;
    @BindView(R.id.sp_jenis_usaha)
    Spinner spJenisUsaha;

    @BindView(R.id.sp_search_debitur)
    Spinner spSearchDebitur;
    @BindView(R.id.iv_search_debitur)
    View btnSearchDebitur;

    @BindView(R.id.btn_check_idi)
    Button btnCekIDI;

    @OnClick(R.id.btn_check_idi)
    void onClickCheckIDI() {
        showCheckIDI();
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_biodata;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (mDataModel != null && mDataModel.getBiodataModel()!=null && mDataModel.getBiodataModel().size() > 0) {
                mBiodataModel = mDataModel.getBiodataModel().get(0);
            }
        }
        setupView();
    }

    private void initView() {
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(getContext()));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(getContext()));
        spinnerTanggal.setAdapter(WidgetUtil.createAdapterTanggal(getContext()));

        WidgetUtil.setDataMasterAdapter(spJenisProspek, DataManager.getInstance().getJenisProspekModelList());
        WidgetUtil.setDataMasterAdapter(spJenisUsaha, DataManager.getInstance().getMasterUsahaNew());
        WidgetUtil.setDataMasterAdapter(spJenisAlamat, DataManager.getInstance().getMasterJenisAlamatNew());
        WidgetUtil.setDataMasterAdapter(spIdType, DataManager.getInstance().getJenisIdentitasNew());
        WidgetUtil.setDataMasterAdapter(spGender, DataManager.getInstance().getJenisKelaminNew());
        /*
        spJenisProspek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 1) {
                    if (formMode == FormMode.VIEW) {
                        //vCheckDebiturLayout.setVisibility(View.GONE);
                        btnCekIDI.setVisibility(View.GONE);
                    } else {
                        //vCheckDebiturLayout.setVisibility(View.VISIBLE);
                        btnCekIDI.setVisibility(View.VISIBLE);
                    }
                } else {
                    //vCheckDebiturLayout.setVisibility(View.GONE);
                    btnCekIDI.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

        cbSeumurHidup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked) {
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
                WidgetUtil.showDatePicker(getContext(), tvMasaBerlaku);
            }
        });

        spSearchDebitur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    showCheckInputDialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSearchDebitur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spSearchDebitur.getSelectedItemPosition() > 0) {
                    showCheckInputDialog();
                }
            }
        });

        checkDebiturFactory = new CheckDebiturFactory(getContext());
        checkDebiturFactory.setSelectedListener(new OnCheckDebiturSelectedListener() {
            @Override
            public void onSelected(CheckDebiturModel model) {
                if (model != null) {
                    setupFromExistingDebitur(model);
                }
            }

            @Override
            public void onCheckCompleted() {
                MyApplication.getEventBus().post(new CheckIDIStateChanged(1));
            }
        });

    }

    private void setupFromExistingDebitur(CheckDebiturModel model) {
        if (model == null)
            return;

        if (mDataModel == null) {
            mDataModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (mDataModel == null) {
                mDataModel = new ProspekListItemModel();
            }
        }

        mDataModel.setIdNasabahPNM(model.getIdNasabah());
        mDataModel.setHasilCekIdi(1);
        mBiodataModel = model.parseToModel();
        JenisProspekModel selectedJenisProspek = (JenisProspekModel) spJenisProspek.getSelectedItem();
        if (selectedJenisProspek != null) {
            mBiodataModel.setIdJenisProspek(selectedJenisProspek.getId());
        }

        setupView();

        MyApplication.getEventBus().post(new CheckIDIStateChanged(mDataModel, mBiodataModel));
    }

    private void showCheckInputDialog() {
        final int type = spSearchDebitur.getSelectedItemPosition();
        String titleSearch = spSearchDebitur.getSelectedItem().toString();
        checkDebiturFactory.showInputDialog(type, titleSearch);
    }


    private void showCheckIDI() {

        String nama=tvFullname.getText().toString();
        String ibu=tvMotherName.getText().toString();
        String tgl_lahir;
        String tempat_lahir=tvTempatLahir.getText().toString();
        String jenis_kelamin=spGender.getSelectedItemPosition() == 0 ? "Laki-laki":"Perempuan";
        String jenis_identitas=spIdType.getSelectedItem() != null ? spIdType.getSelectedItem().toString() : "";
        String nomor_identitas=tvIdentityNumber.getText().toString();

        if(spinnerTanggal.getSelectedItemPosition() > 0 && spinnerBulan.getSelectedItemPosition() > 0 && spinnerTahun.getSelectedItemPosition() > 0) {
            String tgl = spinnerTanggal.getSelectedItem() != null ? spinnerTanggal.getSelectedItem().toString() : "";
            String bln = spinnerBulan.getSelectedItem() != null ? spinnerBulan.getSelectedItem().toString() : "";
            String thn = spinnerTahun.getSelectedItem() != null ? spinnerTahun.getSelectedItem().toString() : "";
            tgl_lahir=thn + "-" + bln + "-" + tgl;
        } else {
            tgl_lahir="1900-01-01";
        }
        if(tgl_lahir.equalsIgnoreCase("1900-01-01")||nama.equalsIgnoreCase("") || ibu.equalsIgnoreCase("") || tempat_lahir.equalsIgnoreCase("")||jenis_kelamin.equalsIgnoreCase("")|| jenis_identitas.equalsIgnoreCase("") || nomor_identitas.equalsIgnoreCase("")) {
            WidgetUtil.showToast(view.getContext(), "Tempat Tanggal Lahir, Nama Lengkap, Nama Ibu Kandung, Jenis Kelamin, Nomor Identitas, Jenis Identitas Harus diisi");
        } else{
            //checkIDIDone="1";
            checkDebiturFactory.doCheckIDI(nama,ibu,tgl_lahir,tempat_lahir,jenis_kelamin,jenis_identitas,nomor_identitas);
        }
    }


    private void setupView() {
        if (mBiodataModel != null) {
            //int posJenisProspek = WidgetUtil.getSpinnerIndexByLabel(spJenisProspek, mBiodataModel.getJenisProspek());
            //spJenisProspek.setSelection(posJenisProspek);
            WidgetUtil.setSpinnerSelectionById(spJenisProspek, mBiodataModel.getIdJenisProspek());
            tvNickname.setText(mBiodataModel.getNamaPanggilan());
            tvFullname.setText(mBiodataModel.getNamaLengkap());
            spJenisAlamat.setSelection(mBiodataModel.getIdJenisAlamat());
            tvAddress.setText(mBiodataModel.getAlamat());
            int posGender = WidgetUtil.getSpinnerIndexByLabel(spGender, mBiodataModel.getJenisKelamin());
            spGender.setSelection(posGender);
            int posJenisId = WidgetUtil.getSpinnerIndexByLabel(spIdType, mBiodataModel.getJenisIdentitas());
            spIdType.setSelection(posJenisId);
            tvIdentityNumber.setText(mBiodataModel.getNoIdentitas());
            if (!TextUtils.isEmpty(mBiodataModel.getMasaBerlaku()) && !mBiodataModel.getMasaBerlaku().equals("1900-01-01")) {
                tvMasaBerlaku.setText(DateUtil.convertDateToNormal(mBiodataModel.getMasaBerlaku()));
            }
            if (mBiodataModel.getIsSeumurHidup() == 1) {
                cbSeumurHidup.setChecked(true);
                vPickerDate.setEnabled(false);
                vPickerDate.setClickable(false);
            } else {
                cbSeumurHidup.setChecked(false);
                vPickerDate.setEnabled(true);
                vPickerDate.setClickable(true);
            }

            tvPhone.setText(mBiodataModel.getNomorTelp());
            tvMotherName.setText(mBiodataModel.getNamaIbuKandung());
            tvTempatLahir.setText(mBiodataModel.getTempatLahir());

            if (!TextUtils.isEmpty(mBiodataModel.getTanggalLahir()) && !mBiodataModel.getTanggalLahir().equals("1900-01-01")) {
                String tgl = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "dd");
                String bln = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "MM");
                String tahun = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "yyyy");
                int posTgl = WidgetUtil.getSpinnerIndexByLabel(spinnerTanggal, tgl);
                spinnerTanggal.setSelection(posTgl);
                int posBulan = WidgetUtil.getSpinnerIndexByLabel(spinnerBulan, bln);
                spinnerBulan.setSelection(posBulan);
                int posTahun = WidgetUtil.getSpinnerIndexByLabel(spinnerTahun, tahun);
                spinnerTahun.setSelection(posTahun);
            }

            WidgetUtil.setSpinnerSelectionById(spJenisUsaha, mBiodataModel.getIdJenisUsaha());

        }

        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                spJenisProspek.setEnabled(false);
                tvNickname.setEnabled(false);
                tvFullname.setEnabled(false);
                spJenisAlamat.setEnabled(false);
                tvAddress.setEnabled(false);
                spGender.setEnabled(false);
                spIdType.setEnabled(false);
                tvIdentityNumber.setEnabled(false);
                tvMasaBerlaku.setEnabled(false);
                vPickerDate.setEnabled(false);
                vPickerDate.setClickable(false);
                cbSeumurHidup.setEnabled(false);
                tvPhone.setEnabled(false);
                tvMotherName.setEnabled(false);
                tvTempatLahir.setEnabled(false);
                spinnerTanggal.setEnabled(false);
                spinnerBulan.setEnabled(false);
                spinnerTahun.setEnabled(false);
                spJenisUsaha.setEnabled(false);
                vCheckDebiturLayout.setVisibility(View.GONE);
                btnCekIDI.setVisibility(View.GONE);
                break;
            default:
                spJenisProspek.setEnabled(true);
                tvNickname.setEnabled(true);
                tvFullname.setEnabled(true);
                spJenisAlamat.setEnabled(true);
                tvAddress.setEnabled(true);
                spGender.setEnabled(true);
                spIdType.setEnabled(true);
                tvIdentityNumber.setEnabled(true);
                tvMasaBerlaku.setEnabled(true);
                vPickerDate.setEnabled(true);
                vPickerDate.setClickable(true);
                cbSeumurHidup.setEnabled(true);
                if (cbSeumurHidup.isChecked()) {
                    vPickerDate.setEnabled(false);
                    vPickerDate.setClickable(false);
                } else {
                    vPickerDate.setEnabled(true);
                    vPickerDate.setClickable(true);
                }
                tvPhone.setEnabled(true);
                tvMotherName.setEnabled(true);
                tvTempatLahir.setEnabled(true);
                spinnerTanggal.setEnabled(true);
                spinnerBulan.setEnabled(true);
                spinnerTahun.setEnabled(true);
                spJenisUsaha.setEnabled(true);

                //vCheckDebiturLayout.setVisibility(View.VISIBLE);
                btnCekIDI.setVisibility(View.VISIBLE);
                /*
                if (spJenisProspek.getSelectedItemPosition() > 1) {
                    //vCheckDebiturLayout.setVisibility(View.VISIBLE);
                    btnCekIDI.setVisibility(View.VISIBLE);
                } else {
                    //vCheckDebiturLayout.setVisibility(View.GONE);
                    btnCekIDI.setVisibility(View.GONE);
                }*/
                break;

        }

        setupHintColor();
    }

    private void setupHintColor() {

        if (formMode == FormMode.EDIT) {
            tvHintJenisProspek.setTextColor(getResources().getColor(R.color.red_text));
            tvHintNamaPanggilan.setTextColor(getResources().getColor(R.color.red_text));
            tvHintNamaLengkap.setTextColor(getResources().getColor(R.color.red_text));
            tvHintJenisAlamat.setTextColor(getResources().getColor(R.color.red_text));
            tvHintAlamat.setTextColor(getResources().getColor(R.color.red_text));
            tvHintNomorTelp.setTextColor(getResources().getColor(R.color.red_text));
            tvHintNamaIbuKandung.setTextColor(getResources().getColor(R.color.red_text));
            tvHintJenisKelamin.setTextColor(getResources().getColor(R.color.red_text));
            tvHintJenisIdentitas.setTextColor(getResources().getColor(R.color.red_text));
            tvHintMasaBerlaku.setTextColor(getResources().getColor(R.color.red_text));
            tvHintTempatLahir.setTextColor(getResources().getColor(R.color.red_text));
            tvHintNomorIdentitas.setTextColor(getResources().getColor(R.color.red_text));
            tvHintTanggal.setTextColor(getResources().getColor(R.color.red_text));
            tvHintBulan.setTextColor(getResources().getColor(R.color.red_text));
            tvHintTahun.setTextColor(getResources().getColor(R.color.red_text));
            tvHintJenisUsaha.setTextColor(getResources().getColor(R.color.red_text));
        } else {
            if( formMode == FormMode.NEW) {
                /*tvHintJenisProspek.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNamaPanggilan.setTextColor(getResources().getColor(R.color.red_text));
                tvHintJenisAlamat.setTextColor(getResources().getColor(R.color.red_text));
                tvHintAlamat.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNomorTelp.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNamaIbuKandung.setTextColor(getResources().getColor(R.color.red_text));*/
                tvHintJenisProspek.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNamaPanggilan.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNamaLengkap.setTextColor(getResources().getColor(R.color.red_text));
                tvHintJenisAlamat.setTextColor(getResources().getColor(R.color.red_text));
                tvHintAlamat.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNomorTelp.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNamaIbuKandung.setTextColor(getResources().getColor(R.color.red_text));
                tvHintJenisKelamin.setTextColor(getResources().getColor(R.color.red_text));
                tvHintJenisIdentitas.setTextColor(getResources().getColor(R.color.red_text));
                tvHintMasaBerlaku.setTextColor(getResources().getColor(R.color.red_text));
                tvHintTempatLahir.setTextColor(getResources().getColor(R.color.red_text));
                tvHintNomorIdentitas.setTextColor(getResources().getColor(R.color.red_text));
                tvHintTanggal.setTextColor(getResources().getColor(R.color.red_text));
                tvHintBulan.setTextColor(getResources().getColor(R.color.red_text));
                tvHintTahun.setTextColor(getResources().getColor(R.color.red_text));
                tvHintJenisUsaha.setTextColor(getResources().getColor(R.color.red_text));
            } else {
                tvHintJenisProspek.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintNamaPanggilan.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintNamaLengkap.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintJenisAlamat.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintAlamat.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintNomorTelp.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintNamaIbuKandung.setTextColor(getResources().getColor(R.color.grey_text));

                tvHintJenisKelamin.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintJenisIdentitas.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintMasaBerlaku.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintTempatLahir.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintNomorIdentitas.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintTanggal.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintBulan.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintTahun.setTextColor(getResources().getColor(R.color.grey_text));
                tvHintJenisUsaha.setTextColor(getResources().getColor(R.color.grey_text));
            }

            /*tvHintJenisKelamin.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintJenisIdentitas.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintMasaBerlaku.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintTempatLahir.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintNomorIdentitas.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintTanggal.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintBulan.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintTahun.setTextColor(getResources().getColor(R.color.grey_text));
            tvHintJenisUsaha.setTextColor(getResources().getColor(R.color.grey_text));*/
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

    public ProspekBiodataModel saveData() {
        if (mDataModel != null && mDataModel.getHasilCekIdi() == 1) {
            checkDebiturFactory.setAlreadyChecked(true);
        }

        if(formMode == FormMode.NEW && !checkDebiturFactory.isAlreadyChecked()) {
            WidgetUtil.showToast(view.getContext(), "Silahkan Melakukan Check IDI Terlebih Dahulu");
            return null;
        }else{
            return saveData(true);
        }
    }

    public ProspekBiodataModel saveData(boolean withValidation) {
        if (withValidation) {
            if (!WidgetUtil.validateField(spJenisProspek, getString(R.string.field_err_msg, "Jenis Prospek"))) {
                return null;
            }

            if (!WidgetUtil.validateField(tvNickname, getString(R.string.field_err_msg, "Nama panggilan"))) {
                return null;
            }

            if (!WidgetUtil.validateField(spJenisAlamat, getString(R.string.field_err_msg, "Jenis alamat"))) {
                return null;
            }

            if (!WidgetUtil.validateField(tvAddress, getString(R.string.field_err_msg, "Alamat"))) {
                return null;
            }

            if (!WidgetUtil.validateField(tvPhone, getString(R.string.field_err_msg, "Nomor telepon"))) {
                return null;
            }

            if (!WidgetUtil.validateField(tvMotherName, getString(R.string.field_err_msg, "Nama ibu kandung"))) {
                return null;
            }

            if (formMode == FormMode.EDIT) {
                //if(!WidgetUtil.validateField(spIdType, getString(R.string.field_err_msg, "Jenis identitas"))) {
                //    return null;
                //}

                if (!WidgetUtil.validateField(tvIdentityNumber, getString(R.string.field_err_msg, "Nomor identitas"))) {
                    return null;
                }

                if (!cbSeumurHidup.isChecked()) {
                    if (!WidgetUtil.validateField(tvMasaBerlaku, getString(R.string.field_err_msg, "Masa berlaku"))) {
                        return null;
                    }
                }

                if (!WidgetUtil.validateField(tvTempatLahir, getString(R.string.field_err_msg, "Tempat lahir"))) {
                    return null;
                }

                if (!WidgetUtil.validateField(spinnerTanggal, getString(R.string.field_err_msg, "Tanggal lahir"))) {
                    return null;
                }

                if (!WidgetUtil.validateField(spinnerBulan, getString(R.string.field_err_msg, "Bulan lahir"))) {
                    return null;
                }

                if (!WidgetUtil.validateField(spinnerTahun, getString(R.string.field_err_msg, "Tahun lahir"))) {
                    return null;
                }

                if (!WidgetUtil.validateField(spJenisUsaha, getString(R.string.field_err_msg, "Jenis Usaha"))) {
                    return null;
                }

            }
        }

        if (mBiodataModel == null) {
            mBiodataModel = new ProspekBiodataModel();
        }

        if (spJenisProspek == null || spJenisProspek.getSelectedItem() == null) {
            return null;
        }

        JenisProspekModel selectedJenisProspek = (JenisProspekModel) spJenisProspek.getSelectedItem();
        if (selectedJenisProspek != null) {
            mBiodataModel.setIdJenisProspek(selectedJenisProspek.getId());
        }
        mBiodataModel.setNamaPanggilan(tvNickname.getText().toString());
        mBiodataModel.setNamaLengkap(tvFullname.getText().toString());
        mBiodataModel.setIdJenisAlamat(spJenisAlamat.getSelectedItemPosition());
        mBiodataModel.setAlamat(tvAddress.getText().toString());
        mBiodataModel.setJenisKelamin(spGender.getSelectedItemPosition() == 0 ? "Laki-laki":"Perempuan");
        mBiodataModel.setJenisIdentitas(spIdType.getSelectedItem() != null ? spIdType.getSelectedItem().toString() : "");
        mBiodataModel.setNoIdentitas(tvIdentityNumber.getText().toString());
        mBiodataModel.setMasaBerlaku(DateUtil.convertDateToDB(tvMasaBerlaku.getText().toString()));
        mBiodataModel.setIsSeumurHidup(cbSeumurHidup.isChecked()?1:0);
        mBiodataModel.setNomorTelp(tvPhone.getText().toString());
        mBiodataModel.setNamaIbuKandung(tvMotherName.getText().toString());
        mBiodataModel.setTempatLahir(tvTempatLahir.getText().toString());
        if(spinnerTanggal.getSelectedItemPosition() > 0 && spinnerBulan.getSelectedItemPosition() > 0 && spinnerTahun.getSelectedItemPosition() > 0) {
            String tgl = spinnerTanggal.getSelectedItem() != null ? spinnerTanggal.getSelectedItem().toString() : "";
            String bln = spinnerBulan.getSelectedItem() != null ? spinnerBulan.getSelectedItem().toString() : "";
            String thn = spinnerTahun.getSelectedItem() != null ? spinnerTahun.getSelectedItem().toString() : "";
            mBiodataModel.setTanggalLahir(thn + "-" + bln + "-" + tgl);
        } else {
            mBiodataModel.setTanggalLahir("1900-01-01");
        }

        if (withValidation) {
            int usia = DateUtil.getAge(mBiodataModel.getTanggalLahir());
            if (usia < 0) {
                WidgetUtil.showToast(getContext(), "Lengkapi tanggal lahir dengan benar");
                return null;
            }

            if (usia < 17) {
                WidgetUtil.showToast(getContext(), "Usia minimal 17 tahun.");
                return null;
            }
        }

        BaseResponseNew selectedJenisUsaha = (BaseResponseNew) spJenisUsaha.getSelectedItem();
        if (selectedJenisUsaha != null) {
            mBiodataModel.setIdJenisUsaha(selectedJenisUsaha.getId());
            mBiodataModel.setNamaJenisUsaha(selectedJenisUsaha.getDeskripsi());
        }

        return mBiodataModel;
    }
}
