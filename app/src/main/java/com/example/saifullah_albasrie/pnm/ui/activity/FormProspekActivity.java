package com.example.saifullah_albasrie.pnm.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.saifullah_albasrie.pnm.callback.GeneralProspekCallback;
import com.example.saifullah_albasrie.pnm.controller.GeneralProspekController;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.TabIndexProspek;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.state.CheckIDIStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.DataProspekModelStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekResponse;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabBiodataFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabHistoryPembiayaanFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabJadwalFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ProspekTabReferensiFragment;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FormProspekActivity extends BaseActivity implements GeneralProspekCallback{

    private final String TAG = FormProspekActivity.class.getSimpleName();

    private int formMode = 0;
    private ProspekListItemModel mDataModel;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int lastTabPosition = 0;
    private boolean dataChangeAutosavedSuccess;
    private boolean isNormalSaveRunning;
    private boolean isAutoSaveRunning;
    private Handler handlerAutoSave = new Handler();

    private GeneralProspekController controller;
    private AppPreference preference = AppPreference.getInstance();

    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ll_detail_content)
    LinearLayout llDetailContent;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ll_content_approval)
    LinearLayout llContentApproval;
    @Nullable
    @BindView(R.id.btn_slide)
    SlideButton btnSlide;
    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;

    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_message)
    Button btnSms;
    @BindView(R.id.tabs)
    TabLayout tabs;

    @OnClick({R.id.btn_call, R.id.btn_message})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call:
                CommonUtil.makeCall(this, CommonUtil.getPhoneNumberFromProspek(mDataModel));
                break;
            case R.id.btn_message:
                CommonUtil.sendSms(this, CommonUtil.getPhoneNumberFromProspek(mDataModel));
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

        setupToolbar(toolbar, getString(R.string.title_activity_add_prospek));
        setupTab();

        controller = new GeneralProspekController(this);

    }

    private void setupTab() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mSectionsPagerAdapter.setCount(getTabCount());
        mSectionsPagerAdapter.notifyDataSetChanged();

        mViewPager.setOffscreenPageLimit(3);
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

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("TAG_VIEWPAGER", "onPageScrolled " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("TAG_VIEWPAGER", "onPageSelected " + position);
                if (lastTabPosition != position) {
                    if (formMode == FormMode.NEW || formMode == FormMode.EDIT) {
                        executeAutoSave();
                    }
                }
                lastTabPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("TAG_VIEWPAGER", "onPageScrollStateChanged " + state);
            }
        });
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupForm();
        requestData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_prospek;
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
            controller.getGeneralProspek(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
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
        if (btnCall != null && btnSms != null) {
            btnCall.setEnabled(false);
            btnSms.setEnabled(false);
            if (mDataModel != null) {
                String phoneNumber = CommonUtil.getPhoneNumberFromProspek(mDataModel);
                if (!TextUtils.isEmpty(phoneNumber)) {
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
            if (dataChangeAutosavedSuccess && formMode == FormMode.NEW) {
                MyApplication.getEventBus().post(new DataStateChanged(true));
            }
        }
    }

    private boolean saveData() {
        if (mDataModel == null) {
            mDataModel = new ProspekListItemModel();
        }
        Log.d(TAG, "saveData " + DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));

        //validate biodata
        ProspekTabBiodataFragment biodataFragment = (ProspekTabBiodataFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.BIODATA);
        ProspekBiodataModel biodataModel = biodataFragment.saveData();
        if (biodataModel != null) {
            if (!TextUtils.isEmpty(mDataModel.getIdDebitur())) {
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
            }
            if (!TextUtils.isEmpty(mDataModel.getIdTransaksiDebitur())) {
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
            }
            biodataModel.setCreatedDate(DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));
            List<ProspekBiodataModel> biodataModelList = new ArrayList<>();
            biodataModelList.add(biodataModel);
            mDataModel.setBiodataModel(biodataModelList);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi biodata");
            lastTabPosition = TabIndexProspek.BIODATA;
            mViewPager.setCurrentItem(TabIndexProspek.BIODATA);
            return false;
        }

        //validate Referensi
        ProspekTabReferensiFragment referensiFragment = (ProspekTabReferensiFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.REFERENSI);
        List<ProspekReferensiModel> referensiModelList = referensiFragment.saveData();
        if (referensiModelList != null) {
            if (referensiModelList.size() > 0)
                mDataModel.setRefferenceModel(referensiModelList);
            else
                mDataModel.setRefferenceModel(null);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi data referensi");
            lastTabPosition = TabIndexProspek.REFERENSI;
            mViewPager.setCurrentItem(TabIndexProspek.REFERENSI);
            return false;
        }


        //validate Jadwal
        ProspekTabJadwalFragment jadwalFragment = (ProspekTabJadwalFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.JADWAL);
        List<ProspekJadwalModel> jadwalModelList = jadwalFragment.saveData();
        if (jadwalModelList != null) {
            if (jadwalModelList.size() > 0)
                mDataModel.setJadwalModel(jadwalModelList);
            else
                mDataModel.setJadwalModel(null);
        } else {
            //DialogFactory.showAlert(this, "Silahkan lengkapi data jadwal");
            lastTabPosition = TabIndexProspek.JADWAL;
            mViewPager.setCurrentItem(TabIndexProspek.JADWAL);
            return false;
        }

        DialogFactory.showProgress(this);
        GeneralProspekResponse postData = new GeneralProspekResponse();
        postData.setBiodata(mDataModel.getBiodataModel());
        postData.setReferensi(mDataModel.getRefferenceModel());
        postData.setJadwal(mDataModel.getJadwalModel());

        isNormalSaveRunning = true;
        if (formMode == FormMode.EDIT || (formMode == FormMode.NEW && !TextUtils.isEmpty(mDataModel.getIdDebitur()) && !TextUtils.isEmpty(mDataModel.getIdTransaksiDebitur()))) {
            controller.editProspek(postData);
        } else {
            controller.saveProspek(postData);
        }
        return true;
    }

    @Override
    public void onGetGeneralProspekSuccess(List<ProspekBiodataModel> biodataModels, List<ProspekReferensiModel> refferenceModels, List<ProspekJadwalModel> jadwalModels) {
        DialogFactory.dismissProgress();
        if(mDataModel!=null) {
            if(biodataModels != null && biodataModels.size() > 0) {
                mDataModel.setBiodataModel(biodataModels);
            }

            if (refferenceModels != null && refferenceModels.size() > 0) {
                mDataModel.setRefferenceModel(refferenceModels);
            }

            if (jadwalModels != null && jadwalModels.size() > 0) {
                mDataModel.setJadwalModel(jadwalModels);
            }
        }

        if (!isFinishing()) {
            setupTopView();
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mSectionsPagerAdapter.setCount(getTabCount());
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onGetGeneralProspekFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveProspekSuccess(String message) {
        isNormalSaveRunning = false;
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
    public void onSaveProspekFailed(Throwable t) {
        isNormalSaveRunning = false;
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }


    private void executeAutoSave() {
        handlerAutoSave.removeCallbacks(runAutoSave);
        handlerAutoSave.postDelayed(runAutoSave, 2000);
    }

    private Runnable runAutoSave = new Runnable() {
        @Override
        public void run() {
            autosaveData();
        }
    };

    private boolean autosaveData() {
        if (isAutoSaveRunning || isNormalSaveRunning) {
            Log.d(TAG, "autosaveData is still running");
            return false;
        }

        Log.d(TAG, "autosaveData " + DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));

        if (mDataModel == null) {
            mDataModel = new ProspekListItemModel();
        }

        //get biodata
        ProspekTabBiodataFragment biodataFragment = (ProspekTabBiodataFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.BIODATA);
        ProspekBiodataModel biodataModel = biodataFragment.saveData(false);
        if (biodataModel != null) {
            if (formMode == FormMode.NEW && TextUtils.isEmpty(biodataModel.getNamaPanggilan())) {
                return false;
            }

            if (!TextUtils.isEmpty(mDataModel.getIdDebitur())) {
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
            }
            if (!TextUtils.isEmpty(mDataModel.getIdTransaksiDebitur())) {
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
            }
            biodataModel.setCreatedDate(DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));

            List<ProspekBiodataModel> biodataModelList = new ArrayList<>();
            biodataModelList.add(biodataModel);
            mDataModel.setBiodataModel(biodataModelList);
        }

        //get Referensi
        ProspekTabReferensiFragment referensiFragment = (ProspekTabReferensiFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.REFERENSI);
        List<ProspekReferensiModel> referensiModelList = referensiFragment.saveData(false);
        if (referensiModelList != null) {
            if (referensiModelList.size() > 0)
                mDataModel.setRefferenceModel(referensiModelList);
            else
                mDataModel.setRefferenceModel(null);
        }

        //get Jadwal
        ProspekTabJadwalFragment jadwalFragment = (ProspekTabJadwalFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexProspek.JADWAL);
        List<ProspekJadwalModel> jadwalModelList = jadwalFragment.saveData(false);
        if (jadwalModelList != null) {
            if (jadwalModelList.size() > 0)
                mDataModel.setJadwalModel(jadwalModelList);
            else
                mDataModel.setJadwalModel(null);
        }

        //DialogFactory.showProgress(this);
        GeneralProspekResponse postData = new GeneralProspekResponse();
        postData.setBiodata(mDataModel.getBiodataModel());
        postData.setReferensi(mDataModel.getRefferenceModel());
        postData.setJadwal(mDataModel.getJadwalModel());

        isAutoSaveRunning = true;
        controller.autosaveProspek(postData);

        return true;
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks whether a hardware keyboard is available
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
            Toast.makeText(this, "keyboard visible", Toast.LENGTH_SHORT).show();
        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
            Toast.makeText(this, "keyboard hidden", Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public void onAutoSaveProspekSuccess(String idDebitur, String idTransaksiDebitur) {
        isAutoSaveRunning = false;
        if (mDataModel == null) {
            mDataModel = new ProspekListItemModel();
        }
        if (!TextUtils.isEmpty(idDebitur)) {
            mDataModel.setIdDebitur(idDebitur);
        }
        if (!TextUtils.isEmpty(idTransaksiDebitur)) {
            mDataModel.setIdTransaksiDebitur(idTransaksiDebitur);
        }

        dataChangeAutosavedSuccess = true;
        MyApplication.getEventBus().post(new DataProspekModelStateChanged(mDataModel, formMode));
    }

    @Override
    public void onAutoSaveProspekFailed(Throwable t) {
        isAutoSaveRunning = false;
        //DialogFactory.dismissProgress();
        //DialogFactory.showAlert(this, t.getMessage());
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
                    case TabIndexProspek.BIODATA:
                        fragment = ProspekTabBiodataFragment.class.newInstance();
                        break;
                    case TabIndexProspek.REFERENSI:
                        fragment = ProspekTabReferensiFragment.class.newInstance();
                        break;
                    case TabIndexProspek.JADWAL:
                        fragment = ProspekTabJadwalFragment.class.newInstance();
                        break;
                    //case TabIndexProspek.CHECK_SID:
                    //    fragment = ProspekTabCheckSIDFragment.class.newInstance();
                    //    break;
                    case TabIndexProspek.HISTORY_PEMBIAYAAN:
                        fragment = ProspekTabHistoryPembiayaanFragment.class.newInstance();
                        break;
                    /*case TabIndexProspek.ALAMAT:
                        fragment = ProspekTabAlamatFragment.class.newInstance();
                        break;
                    case TabIndexProspek.KELUARGA:
                        fragment = ProspekTabKeluargaFragment.class.newInstance();
                        break;
                    case TabIndexProspek.APLIKASI:
                        fragment = ProspekTabAplikasiFragment.class.newInstance();
                        break;*/
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

        private int count = 4;

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int getCount() {
            return count;
        }

        /*@Override
        public int getCount() {
            try {
                // Show 3 total pages + 1 for check SID + 1 history pembiayaan.
                if (mDataModel != null && mDataModel.getBiodataModel().get(0).getIdJenisProspek() > 1) {
                    return 5;
                }
            }catch (Exception e) {
                Log.w(TAG, "getCount TAB count error " + e.getMessage());
            }
            // Show 3 total pages + 1 for check SID.
            return 4;
        }*/

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case TabIndexProspek.BIODATA:
                    return getString(R.string.tab_biodata);
                case TabIndexProspek.REFERENSI:
                    return getString(R.string.tab_referensi);
                case TabIndexProspek.JADWAL:
                    return getString(R.string.tab_jadwal);
                //case TabIndexProspek.CHECK_SID:
                //    return getString(R.string.tab_check_sid);
                case TabIndexProspek.HISTORY_PEMBIAYAAN:
                    return getString(R.string.tab_history_pembiayaan);
                /*
                case TabIndexProspek.ALAMAT:
                    return "Alamat";
                case TabIndexProspek.KELUARGA:
                    return "Keluarga";
                case TabIndexProspek.APLIKASI:
                    return "Aplikasi";*/
            }
            return null;
        }
    }

    private void doSubmitApproval(final boolean approve) {
        String confirmMsg = "Anda yakin menolak prospek ini?";
        if (approve) {
            confirmMsg = "Anda yakin menyetujui prospek ini?";
        }
        DialogFactory.showConfirmation(this, getString(R.string.app_name), confirmMsg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

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

                DialogFactory.showProgress(FormProspekActivity.this);
                controller.submitApproval(model);
            }
        }, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                btnSlide.setCenterPosition();
            }
        });
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

    @Subscribe
    public void onCheckIDIStateChanged(CheckIDIStateChanged event) {
        if (event != null && event.getDataModel() != null) {
            mDataModel = event.getDataModel();
            List<ProspekBiodataModel> biodataModels = new ArrayList<>();
            biodataModels.add(event.getBiodataModel());
            mDataModel.setBiodataModel(biodataModels);
            if (!isFinishing()) {
                setupTopView();
                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                mViewPager.setAdapter(mSectionsPagerAdapter);
                mSectionsPagerAdapter.setCount(getTabCount());
                mSectionsPagerAdapter.notifyDataSetChanged();
            }
        } else if (event != null && event.getIsChekStatus() == 1) {
            if (mDataModel == null) {
                mDataModel = new ProspekListItemModel();
            }
            mDataModel.setHasilCekIdi(1);
        }
    }

    public int getTabCount() {
        try {
            // Show 3 total pages + 1 for check SID + 1 history pembiayaan.
            if (mDataModel != null && mDataModel.getBiodataModel().get(0).getIdJenisProspek() > 1) {
                return 4;
            }
        }catch (Exception e) {
            Log.w(TAG, "getCount TAB count error " + e.getMessage());
        }
        // Show 3 total pages + 1 for check SID.
        return 3;
    }
}
