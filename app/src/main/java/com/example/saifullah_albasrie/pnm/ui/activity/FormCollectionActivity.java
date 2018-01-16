package com.example.saifullah_albasrie.pnm.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.CollectionDetailCallback;
import com.example.saifullah_albasrie.pnm.controller.CollectionDetailController;
import com.example.saifullah_albasrie.pnm.model.CollectionModel;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.TabIndexCollection;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.rest.request.CollectionRequest;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.fragment.CollectionTabKeteranganFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.CollectionTabKolektibilitasFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.CollectionTabLainnyaFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.CollectionTabPenagihanFragment;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import butterknife.BindView;
import butterknife.OnClick;

public class FormCollectionActivity extends BaseFormActivity implements CollectionDetailCallback{

    public static final String BUNDLE_DATA_COLLECTION = "bundle_data_collection_model";
    private PnmDebiturModel mDataModel;
    private CollectionModel collectionModel;
    private String phoneNumber;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private CollectionDetailController controller;

    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ll_detail_content)
    LinearLayout llDetailContent;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_message)
    Button btnSms;
    @BindView(R.id.btn_email)
    Button btnEmail;
    @BindView(R.id.tabs)
    TabLayout tabs;

    @OnClick({R.id.btn_call, R.id.btn_message})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call:
                CommonUtil.makeCall(this, phoneNumber);
                break;
            case R.id.btn_message:
                CommonUtil.sendSms(this, phoneNumber);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }


    private void setupTab() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        tabs.setupWithViewPager(mViewPager);
        if(mSectionsPagerAdapter.getCount() > 3)
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        else
            tabs.setTabMode(TabLayout.MODE_FIXED);
    }


    @Override
    public void initData() {
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        setupToolbar(toolbar, getString(R.string.collection));
        setupTab();

        controller = new CollectionDetailController(this);
        btnCall.setEnabled(false);
        btnSms.setEnabled(false);
        btnEmail.setEnabled(false);

        String sTitle = getString(R.string.collection);
        if (mDataModel != null) {
            sTitle = mDataModel.getNamaDebitur();
            /*if(!TextUtils.isEmpty(mDataModel.getTelpon())) {
                btnCall.setEnabled(true);
                btnSms.setEnabled(true);
                phoneNumber = mDataModel.getTelpon();
            }*/
        }

        setTitle(sTitle);
        setupMode();
    }

    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getCollectionDetail(mDataModel.getiDDebitur());
        }
    }

    @Override
    public void changeToViewMode() {
        super.changeToViewMode();
        llDetailContent.setVisibility(View.VISIBLE);
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    @Override
    public void changeToEditMode() {
        super.changeToEditMode();
        llDetailContent.setVisibility(View.GONE);
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    @Override
    public void changeToNewMode() {
        super.changeToNewMode();
        llDetailContent.setVisibility(View.GONE);
        MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }


    public void setupView() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mSectionsPagerAdapter.notifyDataSetChanged();

    }

    @Override
    protected void setEnableItems(boolean enable) {

    }

    @Override
    public void saveData() {
        if (mDataModel == null) {
            mDataModel = new PnmDebiturModel();
        }

        CollectionModel model = new CollectionModel();
        //validate Penagihan
        CollectionTabPenagihanFragment penagihanFragment = (CollectionTabPenagihanFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexCollection.PENAGIHAN);
        CollectionModel modelTab1 = penagihanFragment.saveData();
        if (modelTab1 != null) {
            model.setTanggalPenagihan(modelTab1.getTanggalPenagihan());
        } else {
            mViewPager.setCurrentItem(TabIndexCollection.PENAGIHAN);
            return;
        }

        //validate Kolektibilitas
        CollectionTabKolektibilitasFragment kolektibilitasFragment = (CollectionTabKolektibilitasFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexCollection.KOLEKTIBILITAS);
        CollectionModel modelTab2 = kolektibilitasFragment.saveData();
        if (modelTab2 != null) {
            model.setTindakLanjut(modelTab2.getTindakLanjut());
        } else {
            mViewPager.setCurrentItem(TabIndexCollection.KOLEKTIBILITAS);
            return;
        }


        //validate Keterangan
        CollectionTabKeteranganFragment keteranganFragment = (CollectionTabKeteranganFragment) mSectionsPagerAdapter.instantiateItem(mViewPager, TabIndexCollection.KETERANGAN);
        CollectionModel modelTab3 = keteranganFragment.saveData();
        if (modelTab3 != null) {
            model.setKeterangan(modelTab3.getKeterangan());
        } else {
            mViewPager.setCurrentItem(TabIndexCollection.KETERANGAN);
            return;
        }


        UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
        model.setIdSdm(userModel.getIdsdm());
        model.setKodeUnit(userModel.getKodeUnit());
        model.setKodeCabang(userModel.getKodeCabang());
        model.setIdDebitur(mDataModel.getiDDebitur());
        DialogFactory.showProgress(this);
        CollectionRequest request = new CollectionRequest(model);
        controller.saveCollectionDetail(request);
    }

    @Override
    public void onGetCollectionDetailSuccess(CollectionModel model) {
        this.collectionModel = model;
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetCollectionDetailFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveCollectionSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });

    }

    @Override
    public void onSaveCollectionFailed(Throwable t) {
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
                    case TabIndexCollection.PENAGIHAN:
                        fragment = CollectionTabPenagihanFragment.class.newInstance();
                        break;
                    case TabIndexCollection.KOLEKTIBILITAS:
                        fragment = CollectionTabKolektibilitasFragment.class.newInstance();
                        break;
                    case TabIndexCollection.KETERANGAN:
                        fragment = CollectionTabKeteranganFragment.class.newInstance();
                        break;
                    case TabIndexCollection.DETAIL:
                        //fragment = CollectionTabJatuhTempoFragment.class.newInstance();
                        fragment = CollectionTabLainnyaFragment.class.newInstance();
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
                args.putParcelable(BUNDLE_DATA_COLLECTION, collectionModel);
                fragment.setArguments(args);
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case TabIndexCollection.PENAGIHAN:
                    return getString(R.string.tab_penagihan);
                case TabIndexCollection.KOLEKTIBILITAS:
                    return getString(R.string.tab_kolektibilitas);
                case TabIndexCollection.KETERANGAN:
                    return getString(R.string.tab_keterangan);
                case TabIndexCollection.DETAIL:
                    return getString(R.string.tab_detail);

            }
            return null;
        }
    }

}
