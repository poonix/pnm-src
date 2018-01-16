package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKontakModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.CheckDebiturFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnCheckDebiturSelectedListener;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ProspekTabBiodataDetailFragment extends BaseFragment {

    private int formMode;
    private ProspekBiodataModel mBiodataModel;

    private List<ProspekKontakModel> kontakModel = null;

    //private CheckDebiturFactory checkDebiturFactory;

    @BindView(R.id.v_dummy_focus)
    View vDummyFocus;
    @BindView(R.id.spinner_jenis_prospek)
    Spinner spJenisProspek;
    @BindView(R.id.tv_nickname)
    EditText tvNickname;
    @BindView(R.id.tv_fullname)
    EditText tvFullname;
    //@BindView(R.id.spinner_jenis_alamat)
    //Spinner spJenisAlamat;
    //@BindView(R.id.tv_address)
    //EditText tvAddress;
    @BindView(R.id.spinner_gender)
    Spinner spGender;
    @BindView(R.id.spinner_id)
    Spinner spIdType;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_identity_number)
    EditText tvIdentityNumber;
    @BindView(R.id.tv_masa_berlaku)
    TextView tvMasaBerlaku;
    @BindView(R.id.picker_date)
    View vPickerDate;
    @BindView(R.id.tv_mother_name)
    EditText tvMotherName;
    @BindView(R.id.cb_seumur_hidup)
    CheckBox cbSeumurHidup;
    @BindView(R.id.tv_tempat_lahir)
    EditText tvTempatLahir;
    @BindView(R.id.spinner_tgl)
    Spinner spinnerTanggal;
    @BindView(R.id.spinner_bulan)
    Spinner spinnerBulan;
    @BindView(R.id.spinner_tahun)
    Spinner spinnerTahun;

    @BindView(R.id.tv_npwp)
    EditText tvNPWP;
    @BindView(R.id.tv_email)
    EditText tvEmail;
    @BindView(R.id.tv_kewarganegaraan)
    EditText tvKewarganegaraan;

    /*@BindView(R.id.tv_gelar)
    EditText tvGelar;
    @BindView(R.id.tv_pendidikan_terakhir)
    EditText tvPendidikanTerakhir;
    */
    @BindView(R.id.spinner_gelar)
    Spinner spGelar;
    @BindView(R.id.spinner_pendidikan_terakhir)
    Spinner spPendidikanTerakhir;

    @BindView(R.id.tv_suku)
    EditText tvSuku;
    @BindView(R.id.tv_keterangan_pekerjaan)
    EditText tvKeteranganPekerjaan;
    @BindView(R.id.tv_nomor_kk)
    EditText tvNomorKK;
    @BindView(R.id.tv_id_marketing)
    EditText tvIdMarketing;
    @BindView(R.id.tv_nama_marketing)
    EditText tvNamaMarketing;
    //@BindView(R.id.tv_tgl_pembuatan)
    //TextView tvTglPembuatan;
    //@BindView(R.id.picker_date1)
    //ImageView imgPickerPembuatan;

    @BindView(R.id.spinner_agama)
    Spinner spAgama;
    @BindView(R.id.spinner_pekerjaan)
    Spinner spPekerjaan;
    @BindView(R.id.spinner_status)
    Spinner spStatusKawin;
    @BindView(R.id.layout_jumlah_anak)
    View vJumlahAnak;
    @BindView(R.id.spinner_jumlah_anak)
    Spinner spJumlahAnak;

    @BindView(R.id.add_hp)
    ImageView addHp;
    @BindView(R.id.view_hp)
    LinearLayout viewHp;
    @BindView(R.id.view_add_hp)
    LinearLayout viewAddHp;
    @BindView(R.id.v_phone_sparator)
    LinearLayout sparatorHp;

    /*
    @BindView(R.id.view_search_debitur)
    View viewSearchDebitur;
    @BindView(R.id.sp_search_debitur)
    Spinner spSearchDebitur;
    @BindView(R.id.iv_search_debitur)
    View btnSearchDebitur;
    */

    @BindViews({
            R.id.tv_hint_jenis_prospek,
            R.id.tv_hint_nama_panggilan,
            R.id.tv_hint_fullname,
            R.id.tv_hint_jenis_identitas,
            R.id.tv_hint_identity_number,
            R.id.tv_hint_jenis_kelamin,
            R.id.tv_hint_tempat_lahir,
            R.id.tv_hint_tanggal,
            R.id.tv_hint_bulan,
            R.id.tv_hint_tahun,
            R.id.tv_hint_pendidikan_terakhir,
            R.id.tv_hint_nama_ibu,
            R.id.tv_hint_kewarganegaraan,
            R.id.tv_hint_agama,
            //R.id.tv_hint_pekerjaan,
            R.id.tv_hint_nomor_kk,
            R.id.tv_hint_status_pernikahan
    })
    List<TextView> mandatoryHintViews;


    public void setFormMode(int formMode) {
        this.formMode = formMode;
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_biodata_detail;
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
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                if(prospekItemModel.getBiodataModel()!=null && prospekItemModel.getBiodataModel().size() > 0) {
                    mBiodataModel = prospekItemModel.getBiodataModel().get(0);
                }
                kontakModel = prospekItemModel.getKontakModel();
            }
        }
        setupView();
    }

    private void initView() {
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(getContext()));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(getContext()));
        spinnerTanggal.setAdapter(WidgetUtil.createAdapterTanggal(getContext()));

        WidgetUtil.setDataMasterAdapter(spJenisProspek, DataManager.getInstance().getJenisProspekModelList());
        WidgetUtil.setDataMasterAdapter(spPekerjaan, DataManager.getInstance().getJenisPekerjaanModelList());
        WidgetUtil.setDataMasterAdapter(spGelar, DataManager.getInstance().getGelarModelList());
        WidgetUtil.setDataMasterAdapter(spPendidikanTerakhir, DataManager.getInstance().getPendidikanTerakhirModelList());

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

        viewAddHp.removeAllViews();

        /*imgPickerPembuatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WidgetUtil.showDatePicker(getContext(), tvTglPembuatan);
            }
        });*/

        addHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewAddHp.getChildCount() < Constant.MAX_TELEPON) {
                    addViewHp(null);
                }
            }
        });

        tvNPWP.addTextChangedListener(npwpWatcher);

        /*
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
                    //WidgetUtil.showToast(getContext(), "Nasabah Yang dipilih : " + model.getNamaNasabah() + ", " + model.getTanggalLahir());
                    setupFromExistingDebitur(model);
                }
            }
        });*/

    }

    /*private void setupFromExistingDebitur(CheckDebiturModel model) {
        mBiodataModel = model.parseToModel();
        setupView();
    }*/

    /*private void showCheckInputDialog() {
        final int type = spSearchDebitur.getSelectedItemPosition();
        String titleSearch = spSearchDebitur.getSelectedItem().toString();
        checkDebiturFactory.showInputDialog(type, titleSearch);
    }*/

    private void setupView() {
        if (mBiodataModel != null) {
            //int posJenis = WidgetUtil.getSpinnerIndexByLabel(spJenisProspek, mBiodataModel.getJenisProspek());
            //spJenisProspek.setSelection(posJenis);
            WidgetUtil.setSpinnerSelectionById(spJenisProspek, mBiodataModel.getIdJenisProspek());
            tvNickname.setText(mBiodataModel.getNamaPanggilan());
            tvFullname.setText(mBiodataModel.getNamaLengkap());
            //tvAddress.setText(mBiodataModel.getAlamat());
            int posGender = WidgetUtil.getSpinnerIndexByLabel(spGender, mBiodataModel.getJenisKelamin());
            spGender.setSelection(posGender);
            int posJenisId = WidgetUtil.getSpinnerIndexByLabel(spIdType, mBiodataModel.getJenisIdentitas());
            spIdType.setSelection(posJenisId);
            tvIdentityNumber.setText(mBiodataModel.getNoIdentitas());
            //tvMasaBerlaku.setText(DateUtil.convertDateToNormal(mBiodataModel.getMasaBerlaku()));
            if (!TextUtils.isEmpty(mBiodataModel.getMasaBerlaku()) && !mBiodataModel.getMasaBerlaku().equals("1900-01-01")) {
                tvMasaBerlaku.setText(DateUtil.convertDateToNormal(mBiodataModel.getMasaBerlaku()));
            }
            if (mBiodataModel.getIsSeumurHidup() == 1) {
                cbSeumurHidup.setChecked(true);
            } else {
                cbSeumurHidup.setChecked(false);
            }

            tvPhone.setText(mBiodataModel.getNomorTelp());
            tvMotherName.setText(mBiodataModel.getNamaIbuKandung());
            tvTempatLahir.setText(mBiodataModel.getTempatLahir());

            String tgl = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "dd");
            String bln = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "MM");
            String tahun = DateUtil.convertDateString(mBiodataModel.getTanggalLahir(), "yyyy-MM-dd", "yyyy");
            int posTgl = WidgetUtil.getSpinnerIndexByLabel(spinnerTanggal, tgl);
            spinnerTanggal.setSelection(posTgl);
            int posBulan = WidgetUtil.getSpinnerIndexByLabel(spinnerBulan, bln);
            spinnerBulan.setSelection(posBulan);
            int posTahun = WidgetUtil.getSpinnerIndexByLabel(spinnerTahun, tahun);
            spinnerTahun.setSelection(posTahun);

            tvNPWP.setText(mBiodataModel.getNpwp());
            tvEmail.setText(mBiodataModel.getEmail());
            tvKewarganegaraan.setText(mBiodataModel.getKewarganegaraan());
            //tvGelar.setText(mBiodataModel.getGelar());
            spGelar.setSelection(WidgetUtil.getSpinnerIndexByLabel(spGelar, mBiodataModel.getGelar()));
            //tvPendidikanTerakhir.setText(mBiodataModel.getPendidikan_terakhir());
            spPendidikanTerakhir.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPendidikanTerakhir, mBiodataModel.getPendidikan_terakhir()));
            tvSuku.setText(mBiodataModel.getSuku());
            tvKeteranganPekerjaan.setText(mBiodataModel.getKeterangan_pekerjaan());
            tvNomorKK.setText(mBiodataModel.getNomor_kk());
            if (TextUtils.isEmpty(mBiodataModel.getId_marketing())) {
                tvIdMarketing.setText(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
            } else {
                tvIdMarketing.setText(mBiodataModel.getId_marketing());
            }
            if (TextUtils.isEmpty(mBiodataModel.getNama_marketing())) {
                tvNamaMarketing.setText(AppPreference.getInstance().getUserLoggedIn().getFullname());
            } else {
                tvNamaMarketing.setText(mBiodataModel.getNama_marketing());
            }
            //tvTglPembuatan.setText(DateUtil.convertDateToNormal(mBiodataModel.getTgl_pembuatan()));


            int posAgama = WidgetUtil.getSpinnerIndexByLabel(spAgama, mBiodataModel.getAgama());
            spAgama.setSelection(posAgama);

            //int posPekerjaan = WidgetUtil.getSpinnerIndexByLabel(spPekerjaan, mBiodataModel.getNamaPekerjaan());
            //spPekerjaan.setSelection(posPekerjaan);
            WidgetUtil.setSpinnerSelectionById(spPekerjaan, mBiodataModel.getIdPekerjaan());

            spStatusKawin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        vJumlahAnak.setVisibility(View.GONE);
                    } else {
                        vJumlahAnak.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            int posStatusKawin = WidgetUtil.getSpinnerIndexByLabel(spStatusKawin, mBiodataModel.getStatus_kawin());
            spStatusKawin.setSelection(posStatusKawin);
            int posJmlAnak = WidgetUtil.getSpinnerIndexByLabel(spJumlahAnak, mBiodataModel.getJumlah_anak());
            spJumlahAnak.setSelection(posJmlAnak);

            viewAddHp.removeAllViews();
            if(kontakModel!=null && kontakModel.size()>0) {
                for(int i = 0; i< kontakModel.size();i++) {
                    ProspekKontakModel item = kontakModel.get(i);
                    if(i == 0) {
                        tvPhone.setText(item.getNomorTelp());
                        tvPhone.setTag(item.getId());
                    } else {
                        addViewHp(item);
                    }
                }
            }

        }

        setupMode();
    }

    private TextWatcher npwpWatcher = new TextWatcher() {
        int len=0;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            len = tvNPWP.getText().toString().length();
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String str = tvNPWP.getText().toString();
            if(str.length()==2 && len <str.length()){//len check for backspace
                tvNPWP.append(".");
            }else if(str.length()==6 && len <str.length()){//len check for backspace
                tvNPWP.append(".");
            }else if(str.length()==10 && len <str.length()){//len check for backspace
                tvNPWP.append(".");
            }else if(str.length()==12 && len <str.length()){//len check for backspace
                tvNPWP.append("-");
            }else if(str.length()==16 && len <str.length()){//len check for backspace
                tvNPWP.append(".");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void addViewHp(ProspekKontakModel model){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_handphone, null);
        ImageView delete = ButterKnife.findById(view, R.id.delete_hp);
        delete.setTag(view);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View container = (View) view.getTag();
                viewAddHp.removeView(container);
            }
        });
        TextView tvNoHp = ButterKnife.findById(view, R.id.tv_nomor_hp);
        if(model!=null) {
            tvNoHp.setText(model.getNomorTelp());
            tvNoHp.setTag(model.getId());
        }
        tvNoHp.requestFocus();
        viewAddHp.addView(view);
    }

    private void setEnableHP(boolean enable) {
        for (int i = 0; i < viewAddHp.getChildCount(); i++) {
            View view = viewAddHp.getChildAt(i);
            ImageView delete = ButterKnife.findById(view, R.id.delete_hp);
            delete.setVisibility(enable?View.VISIBLE:View.GONE);
            TextView tvNoHp = ButterKnife.findById(view, R.id.tv_nomor_hp);
            tvNoHp.setEnabled(enable);
        }
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                ButterKnife.apply(mandatoryHintViews,WidgetUtil.SET_COLOR,getResources().getColor(R.color.grey_text));
                setEnableItems(false);
                setEnableHP(false);

                /*if (AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
                    viewSearchDebitur.setVisibility(View.GONE);
                } else {
                    viewSearchDebitur.setVisibility(View.VISIBLE);
                }*/
                break;
            default:
                ButterKnife.apply(mandatoryHintViews,WidgetUtil.SET_COLOR,getResources().getColor(R.color.red_text));
                setEnableItems(true);
                setEnableHP(true);
                break;

        }
    }

    private void setEnableItems(boolean enable) {
        spJenisProspek.setEnabled(enable);//not always disable??
        tvNickname.setEnabled(enable);
        tvFullname.setEnabled(enable);
        //spJenisAlamat.setEnabled(false);
        //tvAddress.setEnabled(false);
        spGender.setEnabled(enable);
        spIdType.setEnabled(enable);
        tvIdentityNumber.setEnabled(enable);
        tvMasaBerlaku.setEnabled(enable);
        //vPickerDate.setEnabled(enable);
        if (cbSeumurHidup.isChecked()) {
            vPickerDate.setEnabled(false);
        } else {
            vPickerDate.setEnabled(enable);
        }
        cbSeumurHidup.setEnabled(enable);
        tvPhone.setEnabled(enable);
        tvMotherName.setEnabled(enable);
        tvTempatLahir.setEnabled(enable);
        spinnerTanggal.setEnabled(enable);
        spinnerBulan.setEnabled(enable);
        spinnerTahun.setEnabled(enable);

        tvNPWP.setEnabled(enable);
        tvEmail.setEnabled(enable);
        tvKewarganegaraan.setEnabled(enable);
        //tvGelar.setEnabled(enable);
        //tvPendidikanTerakhir.setEnabled(enable);
        spGelar.setEnabled(enable);
        spPendidikanTerakhir.setEnabled(enable);
        tvSuku.setEnabled(enable);
        tvKeteranganPekerjaan.setEnabled(enable);
        tvNomorKK.setEnabled(enable);
        tvIdMarketing.setEnabled(enable);
        tvNamaMarketing.setEnabled(enable);
        //tvTglPembuatan.setEnabled(false);
        //imgPickerPembuatan.setEnabled(false);

        spAgama.setEnabled(enable);
        spPekerjaan.setEnabled(enable);
        spStatusKawin.setEnabled(enable);
        spJumlahAnak.setEnabled(enable);
        addHp.setEnabled(enable);
        if (enable) {
            addHp.setVisibility(View.VISIBLE);
            sparatorHp.setVisibility(View.VISIBLE);
            //viewSearchDebitur.setVisibility(View.GONE);
        } else {
            addHp.setVisibility(View.GONE);
            sparatorHp.setVisibility(View.GONE);
            //viewSearchDebitur.setVisibility(View.VISIBLE);
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
        /*
         Nama panggilan
-              Nama lengkap
-              Jenis kelamin
-              Tempat lahir
-              Tgl lahir
-              Jenis identitas
-              Masa berlaku
-              Nomor identitas
-              Nama ibu kandung
-              Status perkawinan
-              Pendidikan terakhir
-              Kewarganegaraan
-              Agama
-              Nomor kartu keluarga
-              Pekerjaan
         */
        if(!WidgetUtil.validateField(tvNickname, getString(R.string.field_err_msg, "Nama panggilan"))) {
            return null;
        }

        if(!WidgetUtil.validateField(tvFullname, getString(R.string.field_err_msg, "Nama lengkap"))) {
            return null;
        }

        /*
        if(!WidgetUtil.validateField(spJenisAlamat, getString(R.string.field_err_msg, "Jenis alamat"))) {
            return null;
        }

        if(!WidgetUtil.validateField(tvAddress, getString(R.string.field_err_msg, "Alamat"))) {
            return null;
        }*/

        if(!WidgetUtil.validateField(tvPhone, getString(R.string.field_err_msg, "Nomor telepon"))) {
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

            if(!WidgetUtil.validateField(spinnerTanggal, getString(R.string.field_err_msg, "Tanggal lahir"))) {
                return null;
            }

            if(!WidgetUtil.validateField(spinnerBulan, getString(R.string.field_err_msg, "Bulan lahir"))) {
                return null;
            }

            if(!WidgetUtil.validateField(spinnerTahun, getString(R.string.field_err_msg, "Tahun lahir"))) {
                return null;
            }

            if(!WidgetUtil.validateField(tvKewarganegaraan, getString(R.string.field_err_msg, "Kewarganegaraan"))) {
                return null;
            }

            if(!WidgetUtil.validateField(spPendidikanTerakhir, getString(R.string.field_err_msg, "Pendidikan terakhir"))) {
                return null;
            }

            if(!WidgetUtil.validateField(spAgama, getString(R.string.field_err_msg, "Agama"))) {
                return null;
            }

            /*if(!WidgetUtil.validateField(spPekerjaan, getString(R.string.field_err_msg, "Pekerjaan"))) {
                return null;
            }*/

            if(!WidgetUtil.validateField(tvNomorKK, getString(R.string.field_err_msg, "Nomor Kartu Keluarga"))) {
                return null;
            }

            if(!WidgetUtil.validateField(tvPhone, getString(R.string.field_err_msg, "Nomor Handphone"))) {
                return null;
            }

            List<ProspekKontakModel> newKontak = new ArrayList<>();

            int idPhone = 0;
            try{
                idPhone = (int) tvPhone.getTag();
            }catch (Exception e) {}
            String strPhone = tvPhone.getText().toString();

            ProspekKontakModel modelPhone = new ProspekKontakModel();
            modelPhone.setId(idPhone);
            modelPhone.setJenisTelp("");
            modelPhone.setNomorTelp(strPhone);
            newKontak.add(modelPhone);

            for (int i = 0; i < viewAddHp.getChildCount(); i++) {
                View view = viewAddHp.getChildAt(i);
                TextView tvNoHp = ButterKnife.findById(view, R.id.tv_nomor_hp);
                String sTelp = tvNoHp.getText().toString();
                int id = 0;
                try{
                    id = (int) tvNoHp.getTag();
                }catch (Exception e) {}

                if (!TextUtils.isEmpty(sTelp)) {
                    ProspekKontakModel model = new ProspekKontakModel();
                    model.setId(id);
                    model.setJenisTelp("");
                    model.setNomorTelp(tvNoHp.getText().toString());
                    newKontak.add(model);
                }
            }

            if (kontakModel == null) {
                kontakModel = new ArrayList<>();
            } else {
                kontakModel.clear();
            }
            kontakModel.addAll(newKontak);

        }

        if (mBiodataModel == null) {
            mBiodataModel = new ProspekBiodataModel();
        }

        JenisProspekModel selectedJenisProspek = (JenisProspekModel) spJenisProspek.getSelectedItem();
        if (selectedJenisProspek != null) {
            mBiodataModel.setIdJenisProspek(selectedJenisProspek.getId());
        }
        mBiodataModel.setNamaPanggilan(tvNickname.getText().toString());
        mBiodataModel.setNamaLengkap(tvFullname.getText().toString());
        //mBiodataModel.setIdJenisAlamat(spJenisAlamat.getSelectedItemPosition());
        //mBiodataModel.setAlamat(tvAddress.getText().toString());
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

        boolean isMarried = spStatusKawin.getSelectedItemPosition() > 0;
        int usia = DateUtil.getAge(mBiodataModel.getTanggalLahir());
        if(usia < 0) {
            WidgetUtil.showToast(getContext(), "Lengkapi tanggal lahir dengan benar");
            return null;
        }

        if(!isMarried && usia < 21) {
            WidgetUtil.showToast(getContext(), "Usia minimal 21 tahun dan atau 17 tahun tetapi sudah menikah");
            return null;
        } else if(usia < 17) {
            WidgetUtil.showToast(getContext(), "Usia minimal 17 tahun.");
            return null;
        }

        mBiodataModel.setIdJenisUsaha(0);
        mBiodataModel.setNamaJenisUsaha(null);

        mBiodataModel.setNpwp(tvNPWP.getText().toString());
        mBiodataModel.setEmail(tvEmail.getText().toString());
        mBiodataModel.setKewarganegaraan(tvKewarganegaraan.getText().toString());
        //mBiodataModel.setGelar(tvGelar.getText().toString());
        //mBiodataModel.setPendidikan_terakhir(tvPendidikanTerakhir.getText().toString());
        mBiodataModel.setGelar(spGelar.getSelectedItem().toString());
        mBiodataModel.setPendidikan_terakhir(spPendidikanTerakhir.getSelectedItem().toString());
        mBiodataModel.setSuku(tvSuku.getText().toString());
        mBiodataModel.setKeterangan_pekerjaan(tvKeteranganPekerjaan.getText().toString());
        mBiodataModel.setNomor_kk(tvNomorKK.getText().toString());
        mBiodataModel.setId_marketing(tvIdMarketing.getText().toString());
        mBiodataModel.setNama_marketing(tvNamaMarketing.getText().toString());
        //mBiodataModel.setTgl_pembuatan(DateUtil.convertDateToDB(tvTglPembuatan.getText().toString()));

        mBiodataModel.setAgama(spAgama.getSelectedItem()!=null?spAgama.getSelectedItem().toString():"");
        JenisPekerjaanModel pekerjaanModel = (JenisPekerjaanModel) spPekerjaan.getSelectedItem();
        if (pekerjaanModel != null && pekerjaanModel.getId() > 0) {
            mBiodataModel.setIdPekerjaan(pekerjaanModel.getId());
            mBiodataModel.setNamaPekerjaan(pekerjaanModel.getNamaPekerjaan());
        }
        mBiodataModel.setStatus_kawin(spStatusKawin.getSelectedItem()!=null? spStatusKawin.getSelectedItem().toString():"");
        if (spJumlahAnak.getVisibility() == View.VISIBLE) {
            mBiodataModel.setJumlah_anak(spJumlahAnak.getSelectedItem() != null ? spJumlahAnak.getSelectedItem().toString() : "");
        } else {
            mBiodataModel.setJumlah_anak("");
        }

        return mBiodataModel;
    }

    public List<ProspekKontakModel> getKontakModel() {
        return kontakModel;
    }

}
