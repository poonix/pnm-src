package com.example.saifullah_albasrie.pnm.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.GeneralProspekDetailCallback;
import com.example.saifullah_albasrie.pnm.controller.GeneralProspekDetailController;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAplikasiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKontakModel;
import com.example.saifullah_albasrie.pnm.model.ProspekLainnyaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekRencanaAgunanModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.TabIndexProspek;
import com.example.saifullah_albasrie.pnm.model.annotation.TabIndexProspekDetail;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekDetailResponse;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabAlamatFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabAplikasiFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabBiodataDetailFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabCheckSIDFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabHistoryPembiayaanFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabJadwalFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabKeluargaFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabLainnyaFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabReferensiFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabRencanaAgunanFragment;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FormProspekDetailActivity extends BaseActivity implements GeneralProspekDetailCallback{

    private int formMode = 0;
    private ProspekListItemModel mDataModel;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private GeneralProspekDetailController controller;
    private AppPreference preference = AppPreference.getInstance();

    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ll_detail_content)
    LinearLayout llDetailContent;
    @BindView(R.id.ll_content_approval)
    LinearLayout llContentApproval;
    @Nullable
    @BindView(R.id.btn_slide)
    SlideButton btnSlide;

    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_email)
    Button btnEmail;
    @BindView(R.id.btn_message)
    Button btnSms;

    @BindView(R.id.tabs)
    TabLayout tabs;



    @OnClick({R.id.btn_call, R.id.btn_message, R.id.btn_email})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call:
                CommonUtil.makeCall(this, CommonUtil.getPhoneNumberFromProspekDetail(mDataModel));
                break;
            case R.id.btn_message:
                CommonUtil.sendSms(this, CommonUtil.getPhoneNumberFromProspekDetail(mDataModel));
                break;
            case R.id.btn_email:
                CommonUtil.sendEmail(this, CommonUtil.getEmailFromProspekDetail(mDataModel));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        setupToolbar(toolbar, "");
        setupTab();

        controller = new GeneralProspekDetailController(this);

    }

    /*@OnClick({R.id.btn_Reject, R.id.btn_Accept})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Reject:
                doSubmitApproval(false);
                break;
            case R.id.btn_Accept:
                doSubmitApproval(true);
                break;
        }
    }*/

    private void doSubmitApproval(final boolean approve) {
        String confirmMsg = "Anda yakin menolak prospek ini?";
        if (approve) {
            confirmMsg = "Anda yakin menyetujui prospek ini?";
        }
        DialogFactory.showConfirmation(this, getString(R.string.app_name), confirmMsg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DialogFactory.showProgress(FormProspekDetailActivity.this);
                final ApprovalProspekModel model = new ApprovalProspekModel();
                UserModel userModel = preference.getUserLoggedIn();
                model.setIdSdm(userModel.getIdsdm());
                model.setIdAo(mDataModel.getCreatedBy());
                model.setIdDebitur(mDataModel.getIdDebitur());
                model.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                model.setKodeUnit(userModel.getKodeUnit());
                model.setKodeCabang(userModel.getKodeCabang());
                model.setKeterangan(tvKeterangan.getText().toString());
                if (approve) {
                    model.setStatusDebitur("6");
                    model.setProgress(40);
                } else {
                    model.setStatusDebitur("5");
                    model.setProgress(30);
                }

                controller.submitApproval(model);
            }
        }, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                btnSlide.setCenterPosition();
            }
        });
    }

    private void setupTab() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(8);
        tabs.setupWithViewPager(mViewPager);
        if(mSectionsPagerAdapter.getCount() > 3)
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        else
            tabs.setTabMode(TabLayout.MODE_FIXED);

        if (preference.getUserType() == UserType.MANAGER_UNIT) {
            llContentApproval.setVisibility(View.VISIBLE);
            llDetailContent.setVisibility(View.GONE);
        } else {
            llContentApproval.setVisibility(View.GONE);
            llDetailContent.setVisibility(View.VISIBLE);
        }

        if (btnSlide != null) {
            btnSlide.setSlideButtonListener(new SlideButton.SlideButtonListener() {
                @Override
                public void handleSlide(int slideType) {
                    if (slideType == SlideButton.SLIDE_RIGHT) {
                        doSubmitApproval(true);
                    } else if (slideType == SlideButton.SLIDE_LEFT) {
                        doSubmitApproval(false);
                    } else {
                        //btnSlide.setThumb(getResources().getDrawable(R.drawable.ic_slider_thumb));
                    }
                }
            });
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupForm();
        requestData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_prospek_detail;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (preference.getUserType() != UserType.MANAGER_UNIT) {
            switch (formMode) {
                case FormMode.VIEW:
                    getMenuInflater().inflate(R.menu.menu_view_prospek, menu);
                    return true;
                default: //edit or new
                    getMenuInflater().inflate(R.menu.menu_add_prospek, menu);
                    return true;
            }
        }

        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.action_edit) {
            changeToEditMode();
            return true;
        } else if (id == R.id.action_done) {
            saveData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupForm() {
        mViewPager.setCurrentItem(0);
        String sTitle = getString(R.string.title_activity_add_prospek);
        if (mDataModel != null) {
            sTitle = mDataModel.getNamaPanggilan();
        }

        switch (formMode) {
            case FormMode.VIEW:
                setTitle(sTitle);
                changeToViewMode();
                break;
            case FormMode.EDIT:
                setTitle(sTitle);
                changeToEditMode();
                break;
            default:
                setTitle(sTitle);
                changeToNewMode();
                break;
        }
    }

    private void requestData() {
        if (mDataModel != null && formMode == FormMode.VIEW) {
            DialogFactory.showProgress(this);
            controller.getGeneralProspekDetail(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    private void changeToViewMode() {
        changeToViewMode(false);
    }

    private void changeToViewMode(boolean resetView) {
        formMode = FormMode.VIEW;
        if (preference.getUserType() == UserType.MANAGER_UNIT) {
            llContentApproval.setVisibility(View.VISIBLE);
            llDetailContent.setVisibility(View.GONE);
        } else {
            llContentApproval.setVisibility(View.GONE);
            llDetailContent.setVisibility(View.VISIBLE);
        }
        //llDetailContent.setVisibility(View.VISIBLE);
        mAppBarLayout.setExpanded(true, true);
        invalidateOptionsMenu();

        //send event bus
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode, resetView));

        setupTopView();

        int curr = mViewPager.getCurrentItem();
        if(curr > mSectionsPagerAdapter.getCount()){
            curr = mSectionsPagerAdapter.getCount()-1;
            mViewPager.setCurrentItem(curr);
        }
        mViewPager.setCurrentItem(curr);
    }

    private void changeToEditMode() {
        formMode = FormMode.EDIT;
        llDetailContent.setVisibility(View.GONE);
        invalidateOptionsMenu();
        //mViewPager.setCurrentItem(0);

        //send event bus
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    private void changeToNewMode() {
        llDetailContent.setVisibility(View.GONE);
        formMode = FormMode.NEW;
        invalidateOptionsMenu();
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    private void setupTopView() {
        btnCall.setEnabled(false);
        btnEmail.setEnabled(false);
        btnSms.setEnabled(false);
        if(mDataModel!=null) {
            ProspekBiodataModel biodataModel = null;
            List<ProspekBiodataModel> biodataModelList = mDataModel.getBiodataModel();
            if (biodataModelList != null && biodataModelList.size() > 0) {
                biodataModel = biodataModelList.get(0);
                if (biodataModel != null && !TextUtils.isEmpty(biodataModel.getEmail())) {
                    btnEmail.setEnabled(true);
                }
            }

            if ( mDataModel.getKontakModel() != null &&  mDataModel.getKontakModel().size()>0) {
                if (!TextUtils.isEmpty(mDataModel.getKontakModel().get(0).getNomorTelp())) {
                    btnCall.setEnabled(true);
                    btnSms.setEnabled(true);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (formMode == FormMode.EDIT) {
            changeToViewMode(true);
        } else {
            super.onBackPressed();
        }
    }

    private boolean saveData() {
        if (mDataModel == null) {
            mDataModel = new ProspekListItemModel();
        }
        //validate biodata
        ProspekTabBiodataDetailFragment biodataFragment = (ProspekTabBiodataDetailFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.BIODATA);
        ProspekBiodataModel biodataModel = biodataFragment.saveData();
        List<ProspekKontakModel> kontakModel = biodataFragment.getKontakModel();
        if (biodataModel != null && kontakModel != null) {
            List<ProspekBiodataModel> biodataModelList = new ArrayList<>();
            biodataModelList.add(biodataModel);
            mDataModel.setBiodataModel(biodataModelList);
            mDataModel.setKontakModel(kontakModel);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi biodata");
            mViewPager.setCurrentItem(TabIndexProspekDetail.BIODATA);
            return false;
        }

        //validate Referensi
        ProspekTabReferensiFragment referensiFragment = (ProspekTabReferensiFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.REFERENSI);
        List<ProspekReferensiModel> referensiModelList = referensiFragment.saveData();
        if (referensiModelList != null) {
            mDataModel.setRefferenceModel(referensiModelList);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi data referensi");
            mViewPager.setCurrentItem(TabIndexProspekDetail.REFERENSI);
            return false;
        }


        //validate Jadwal
        ProspekTabJadwalFragment jadwalFragment = (ProspekTabJadwalFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.JADWAL);
        List<ProspekJadwalModel> jadwalModelList = jadwalFragment.saveData();
        if (jadwalModelList != null) {
            mDataModel.setJadwalModel(jadwalModelList);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi data jadwal");
            mViewPager.setCurrentItem(TabIndexProspekDetail.JADWAL);
            return false;
        }

        //validate alamat
        ProspekTabAlamatFragment alamatFragment = (ProspekTabAlamatFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.ALAMAT);
        List<ProspekAlamatModel> alamatModelList = alamatFragment.saveData();
        if (alamatModelList != null) {
            mDataModel.setAlamatModel(alamatModelList);
        } else {
            mViewPager.setCurrentItem(TabIndexProspekDetail.ALAMAT);
            return false;
        }

        ProspekTabKeluargaFragment keluargaFragment = (ProspekTabKeluargaFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.KELUARGA);
        List<ProspekKeluargaModel> keluargaModelList = keluargaFragment.saveData();
        if (keluargaModelList != null) {
            mDataModel.setKeluargaModel(keluargaModelList);
        } else {
            mViewPager.setCurrentItem(TabIndexProspekDetail.KELUARGA);
            return false;
        }

        ProspekTabAplikasiFragment aplikasiFragment = (ProspekTabAplikasiFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.APLIKASI);
        List<ProspekAplikasiModel> aplikasiModelList = aplikasiFragment.saveData();
        if (aplikasiModelList != null) {
            mDataModel.setAplikasiModel(aplikasiModelList);
        } else {
            mViewPager.setCurrentItem(TabIndexProspekDetail.APLIKASI);
            return false;
        }

        ProspekTabRencanaAgunanFragment rencanaAgunanFragment = (ProspekTabRencanaAgunanFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.RENCANA_AGUNAN);
        List<ProspekRencanaAgunanModel> rencanaAgunanModelList = rencanaAgunanFragment.saveData();
        if (rencanaAgunanModelList != null) {
            mDataModel.setRencanaAgunanModel(rencanaAgunanModelList);
        } else {
            mViewPager.setCurrentItem(TabIndexProspekDetail.RENCANA_AGUNAN);
            return false;
        }

        ProspekTabLainnyaFragment lainnyaFragment = (ProspekTabLainnyaFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspekDetail.LAINNYA);
        List<ProspekLainnyaModel> lainnyaModelList = lainnyaFragment.saveData();
        if (lainnyaModelList != null) {
            mDataModel.setLainnyaModel(lainnyaModelList);
        } else {
            mViewPager.setCurrentItem(TabIndexProspekDetail.LAINNYA);
            return false;
        }

        int rencanaPlafond = 0;
        try {
            rencanaPlafond = Integer.parseInt(aplikasiModelList.get(0).getRencanaPlafond());
        }catch (Exception e){}
        if (rencanaPlafond >= Constant.PLAFOND_MUST_FILL_NPWP && TextUtils.isEmpty(biodataModel.getNpwp())) {
            WidgetUtil.showToast(this, "NPWP harus diisi jika plafond lebih dari Rp 50.000.000");
            mViewPager.setCurrentItem(TabIndexProspekDetail.BIODATA);
            return false;
        }

        int usia = DateUtil.getAge(biodataModel.getTanggalLahir());
        if(usia < 0) {
            WidgetUtil.showToast(this, "Lengkapi tanggal lahir dengan benar");
            return false;
        }

        int jangkaWaktu = aplikasiModelList.get(0).getJangkaWaktu();
        if (usia + (jangkaWaktu/12) > 65) {
            WidgetUtil.showToast(this, "Jangka waktu tidak boleh melebihi usia 65 tahun");
            mViewPager.setCurrentItem(TabIndexProspekDetail.APLIKASI);
            return false;
        }
        DialogFactory.showProgress(this);
        GeneralProspekDetailResponse postData = new GeneralProspekDetailResponse();
        postData.setBiodata(mDataModel.getBiodataModel());
        postData.setKontakModelList(mDataModel.getKontakModel());
        postData.setReferensi(mDataModel.getRefferenceModel());
        postData.setJadwal(mDataModel.getJadwalModel());
        postData.setAlamatModelList(mDataModel.getAlamatModel());
        postData.setKeluargaModelList(mDataModel.getKeluargaModel());
        postData.setAplikasiModelList(mDataModel.getAplikasiModel());
        postData.setRencanaAgunanModelList(mDataModel.getRencanaAgunanModel());
        postData.setLainnyaModelList(mDataModel.getLainnyaModel());

        if (formMode == FormMode.EDIT) {
            controller.editProspekDetail(postData);
        }
         else {
            WidgetUtil.showToast(this, "Data tidak dapat diproses!");
            return false;
        }
        return true;
    }

    @Override
    public void onGetGeneralProspekDetailSuccess(List<ProspekBiodataModel> biodataModels, List<ProspekKontakModel> kontakModels,
                                                 List<ProspekReferensiModel> refferenceModels,
                                                 List<ProspekJadwalModel> jadwalModels, List<ProspekAlamatModel> alamatModels,
                                                 List<ProspekKeluargaModel> keluargaModels, List<ProspekAplikasiModel> aplikasiModels,
                                                 List<ProspekRencanaAgunanModel> rencanaAgunanModels,
                                                 List<ProspekLainnyaModel> lainnyaModels) {
        if(mDataModel!=null) {
            if(biodataModels != null && biodataModels.size() > 0) {
                mDataModel.setBiodataModel(biodataModels);
            }

            if (kontakModels != null && kontakModels.size() > 0) {
                mDataModel.setKontakModel(kontakModels);
            }

            if (refferenceModels != null && refferenceModels.size() > 0) {
                mDataModel.setRefferenceModel(refferenceModels);
            }

            if (jadwalModels != null && jadwalModels.size() > 0) {
                mDataModel.setJadwalModel(jadwalModels);
            }


            if (alamatModels != null && alamatModels.size() > 0) {
                mDataModel.setAlamatModel(alamatModels);
            }

            if (keluargaModels != null && keluargaModels.size() > 0) {
                mDataModel.setKeluargaModel(keluargaModels);
            }

            if (aplikasiModels != null && aplikasiModels.size() > 0) {
                mDataModel.setAplikasiModel(aplikasiModels);
            }

            if (rencanaAgunanModels != null && rencanaAgunanModels.size() > 0) {
                mDataModel.setRencanaAgunanModel(rencanaAgunanModels);
            }

            if (lainnyaModels != null && lainnyaModels.size() > 0) {
                mDataModel.setLainnyaModel(lainnyaModels);
            }
        }

        setupTopView();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetGeneralProspekDetailFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveProspekDetailSuccess(String message) {

        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, !TextUtils.isEmpty(message) ? message : "Data berhasil disimpan", new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (formMode == FormMode.EDIT) {
                    MyApplication.getEventBus().post(new DataStateChanged(true));
                    changeToViewMode();
                }
                else {
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });

    }

    @Override
    public void onSaveProspekDetailFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSendApprovalSuccess(String message) {
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
    public void onSendApprovalFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter { // FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = null;
            try {
                switch (position) {
                    case TabIndexProspekDetail.BIODATA:
                        fragment = ProspekTabBiodataDetailFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.REFERENSI:
                        fragment = ProspekTabReferensiFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.JADWAL:
                        fragment = ProspekTabJadwalFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.ALAMAT:
                        fragment = ProspekTabAlamatFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.KELUARGA:
                        fragment = ProspekTabKeluargaFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.APLIKASI:
                        fragment = ProspekTabAplikasiFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.RENCANA_AGUNAN:
                        fragment = ProspekTabRencanaAgunanFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.LAINNYA:
                        fragment = ProspekTabLainnyaFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.CHECK_SID:
                        fragment = ProspekTabCheckSIDFragment.class.newInstance();
                        break;
                    case TabIndexProspekDetail.HISTORY_PEMBIAYAAN:
                        fragment = ProspekTabHistoryPembiayaanFragment.class.newInstance();
                        break;

                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (fragment != null) {
                Bundle args = new Bundle();
                args.putInt(Constant.BUNDLE_FORM_MODE, formMode);
                args.putParcelable(Constant.BUNDLE_DATA, mDataModel);
                fragment.setArguments(args);
            }

            return fragment;
        }

        @Override
        public int getCount() {
            try {
                if (mDataModel != null && mDataModel.getBiodataModel().get(0).getIdJenisProspek() > 1) {
                    return 10;
                }
            }catch (Exception e) {
                Log.w("TAG", "getCount TAB count error " + e.getMessage());
            }
            //return 8; //tab check SID move to prospek
            return 9; //tab check SID balik lagi ke prospek detail

        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case TabIndexProspekDetail.BIODATA:
                    return getString(R.string.tab_biodata);
                case TabIndexProspekDetail.REFERENSI:
                    return getString(R.string.tab_referensi);
                case TabIndexProspekDetail.JADWAL:
                    return getString(R.string.tab_jadwal);
                case TabIndexProspekDetail.ALAMAT:
                    return "Alamat";
                case TabIndexProspekDetail.KELUARGA:
                    return "Keluarga";
                case TabIndexProspekDetail.APLIKASI:
                    return "Aplikasi";
                case TabIndexProspekDetail.RENCANA_AGUNAN:
                    return "Rencana\nAgunan";
                case TabIndexProspekDetail.LAINNYA:
                    return "Lainnya";
                case TabIndexProspekDetail.CHECK_SID:
                    return getString(R.string.tab_check_sid);
                case TabIndexProspekDetail.HISTORY_PEMBIAYAAN:
                    return getString(R.string.tab_history_pembiayaan);
                /*case TabIndexProspek.CHECK_SID:
                    return "Check SID";
                */
            }
            return null;
        }
    }

}
