package com.example.saifullah_albasrie.pnm.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyChecklistCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyChecklistController;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.MenuModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyChecklistModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.MenuType;
import com.example.saifullah_albasrie.pnm.model.annotation.SurveyItemType;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.adapter.MenuAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by aldhiramdan on 3/21/17.
 */

public class SurveyItemActivity extends BaseActivity implements OnItemClickListener, SurveyChecklistCallback {

    private int formMode;

    @BindView(R.id.ll_content_approval)
    LinearLayout llContentApproval;
    @Nullable
    @BindView(R.id.btn_slide)
    SlideButton btnSlide;
    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;

    @BindView(R.id.tv_id_survey)
    TextView tvIdSurvey;

    @BindView(R.id.rv_survey)
    RecyclerView rvSurvey;

    private MenuAdapter mAdapter;
    private List<MenuModel> subItem;

    //private int formMode = 0;
    private ProspekListItemModel mDataModel;
    private SurveyChecklistModel checklistModel;
    private SurveyChecklistController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInstance();
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_survey;
    }


    private void initInstance() {
        controller = new SurveyChecklistController(this);
        subItem = new ArrayList<>();
        //mAdapter = new SurveyAdapter(subItem);
        mAdapter = new MenuAdapter(subItem);
        mAdapter.setOnItemClickListener(this);
        setupRecylcerView();


        /*if (AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            llContentApproval.setVisibility(View.VISIBLE);
        } else {
            llContentApproval.setVisibility(View.GONE);
        }*/

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
        setupData();
    }

    private void setupData() {
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            if (formMode == FormMode.READ_ONLY) {
                llContentApproval.setVisibility(View.GONE);
            } else {
                if (AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
                    llContentApproval.setVisibility(View.VISIBLE);
                } else {
                    llContentApproval.setVisibility(View.GONE);
                }
            }

            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
            if (mDataModel != null) {
                String sTitle = mDataModel.getNamaPanggilan();
                setTitle(sTitle);
                loadChecklist(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
            }
        }

    }

    private void setupRecylcerView() {
        rvSurvey.setHasFixedSize(true);
        rvSurvey.setItemAnimator(new DefaultItemAnimator());
        rvSurvey.setAdapter(mAdapter);
        rvSurvey.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvSurvey.getRecycledViewPool().setMaxRecycledViews(MenuType.BUTTON_MENU, 20);
    }

    @Subscribe
    public void onDataChanged(DataStateChanged event) {
        if (event != null && event.isRefresh()) {
            loadChecklist(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        MenuModel menuModel = subItem.get(position);
        int newFormMode = menuModel.getStatus();
        if (this.formMode == FormMode.READ_ONLY || AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            newFormMode = FormMode.READ_ONLY;
        }

        int type = menuModel.getId();
        switch (type) {
            case SurveyItemType.SURVEY:
                FormSurveyActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.PROFILE_AND_KARAKTER:
                FormSurveyProfileActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.JENIS_USAHA:
                FormSurveyJenisUsahaActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.KAPASITAS_USAHA:
                FormSurveyKapasitasUsahaActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.KEUANGAN:
                FormSurveyKeuanganActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.KEBUTUHAN_MODAL_KERJA:
                FormSurveyKebutuhanModalKerjaActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.KELUARGA:
                FormSurveyKeluargaActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.JAMINAN:
                FormSurveyListJaminanActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.DOKUMEN_LAINNYA:
                FormSurveyDokumenActivity.navigate(this, newFormMode, mDataModel);
                break;
            case SurveyItemType.BTN_CHECK_SID:
                if (checklistModel != null && checklistModel.isFormCompleted()) {
                    doCheckSID();
                } else {
                    WidgetUtil.showToast(this, "Data belum lengkap!");
                }
                break;
            case SurveyItemType.BTN_KIRIM_PENGAJUAN:
                if (checklistModel != null && checklistModel.isFormCompleted()) {
                    //doSendPengajuan();

                    if (checklistModel.getIsCheckSID() == 1) {
                        doSendPengajuan();
                    } else {
                        WidgetUtil.showToast(this, "Cek SID terlebih dahulu");
                    }
                } else {
                    WidgetUtil.showToast(this, "Data belum lengkap!");
                }
                break;
        }
    }

    private void loadChecklist(String idDebitur, String idTransaksi) {
        DialogFactory.showProgress(this);
        controller.getSurveyChecklist(idDebitur, idTransaksi);
    }

    private void setupCheklistItems(SurveyChecklistModel checklistModel) {
        this.checklistModel = checklistModel;

        if (checklistModel != null && tvIdSurvey != null) {
            tvIdSurvey.setText(checklistModel.getIdSurvey());
        }

        int menuType = MenuType.SURVEY_MENU;
        if (AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            menuType = MenuType.BUTTON_MENU;
        }

        subItem.clear();

        if (mDataModel != null && mDataModel.getBiodataModel() != null
                && mDataModel.getBiodataModel().size() > 0
                && mDataModel.getBiodataModel().get(0).getIdJenisProspek() > 1) {
            MenuModel modelHistory = new MenuModel(SurveyItemType.SURVEY, menuType, getString(R.string.tab_history_pembiayaan));
            if (checklistModel != null) {
                //modelHistory.setStatus(checklistModel.getSurvey());
            }
            subItem.add(modelHistory);
        }

        MenuModel model = new MenuModel(SurveyItemType.SURVEY, menuType, getString(R.string.survey_survey));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getSurvey());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.PROFILE_AND_KARAKTER, menuType, getString(R.string.profile_karakter));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getProfileKarakter());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.KAPASITAS_USAHA, menuType, getString(R.string.capital_capacity));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getKapasitasUsaha());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.JENIS_USAHA, menuType, getString(R.string.kind_of_business));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getJenisUsaha());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.KEUANGAN, menuType, getString(R.string.finance));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getKeuangan());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.KEBUTUHAN_MODAL_KERJA, menuType, getString(R.string.working_capital_requirement));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getKebutuhanModalKerja());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.KELUARGA, menuType, getString(R.string.family));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getKeluarga());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.JAMINAN, menuType, getString(R.string.security));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getAgunan());
        }
        subItem.add(model);

        model = new MenuModel(SurveyItemType.DOKUMEN_LAINNYA, menuType, getString(R.string.other_document));
        if (checklistModel != null) {
            model.setStatus(checklistModel.getDokumenLainnya());
        }
        subItem.add(model);

        //button
        if (AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            /*
            model = new MenuModel(SurveyItemType.BTN_CHECK_SID, MenuType.BUTTON_MENU, getString(R.string.btn_check_sid));
            model.setBackground(getResources().getDrawable(R.drawable.button_green_selector));
            subItem.add(model);
            */

        } else {
            /*
            model = new MenuModel(SurveyItemType.BTN_CHECK_SID, MenuType.BUTTON_MENU, getString(R.string.btn_check_sid));
            if (checklistModel.isFormCompleted()) {
                if (checklistModel != null && checklistModel.getIsCheckSID() == 1) {
                    model.setBackground(getResources().getDrawable(R.drawable.button_green_selector));
                } else {
                    model.setBackground(getResources().getDrawable(R.drawable.button_blue_selector));
                }
            } else {
                model.setBackground(getResources().getDrawable(R.drawable.button_grey_selector));
            }
            subItem.add(model);*/

            if (formMode != FormMode.READ_ONLY) {

                model = new MenuModel(SurveyItemType.BTN_CHECK_SID, MenuType.BUTTON_MENU, getString(R.string.btn_check_sid));
                if (checklistModel != null && checklistModel.isFormCompleted()) {
                    if (checklistModel != null && checklistModel.getIsCheckSID() == 1) {
                        model = new MenuModel(SurveyItemType.BTN_CHECK_SID, MenuType.BUTTON_MENU, getString(R.string.btn_check_sid_result));
                        model.setBackground(getResources().getDrawable(R.drawable.button_green_selector));
                    } else {
                        model.setBackground(getResources().getDrawable(R.drawable.button_blue_selector));
                    }
                } else {
                    model.setBackground(getResources().getDrawable(R.drawable.button_grey_selector));
                }
                subItem.add(model);

                model = new MenuModel(SurveyItemType.BTN_KIRIM_PENGAJUAN, MenuType.BUTTON_MENU, "Kirim Pengajuan");
                if (checklistModel != null && checklistModel.isFormCompleted()) {
                    model.setBackground(getResources().getDrawable(R.drawable.button_blue_selector));
                } else {
                    model.setBackground(getResources().getDrawable(R.drawable.button_grey_selector));
                }
                subItem.add(model);
            }
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetSurveyChecklistSuccess(SurveyChecklistModel checklistModel) {
        DialogFactory.dismissProgress();
        setupCheklistItems(checklistModel);
    }

    @Override
    public void onGetSurveyChecklistFailed(Throwable t) {
        DialogFactory.dismissProgress();
        setupCheklistItems(null);
    }

    private void doCheckSID() {
        DialogFactory.showConfirmation(this, getString(R.string.app_name), getString(R.string.check_sid_title), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
                DialogFactory.showProgress(SurveyItemActivity.this);
                BiodataModel biodataModel = new BiodataModel();
                biodataModel.setIdSdm(userModel.getIdsdm());
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                biodataModel.setKodeUnit(userModel.getKodeUnit());
                biodataModel.setKodeCabang(userModel.getKodeCabang());
                biodataModel.setCreatedDate(DateUtil.getCurrentDateTimeAsString("yyyy-MM-dd hh:mm:ss"));
                controller.submitCheckSID(biodataModel);

            }
        });
    }

    private void doSendPengajuan() {
        DialogFactory.showConfirmation(this, getString(R.string.app_name), "Kirim Pengajuan?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
                DialogFactory.showProgress(SurveyItemActivity.this);
                BiodataModel biodataModel = new BiodataModel();
                biodataModel.setIdSdm(userModel.getIdsdm());
                biodataModel.setIdDebitur(mDataModel.getIdDebitur());
                biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                biodataModel.setKodeUnit(userModel.getKodeUnit());
                biodataModel.setKodeCabang(userModel.getKodeCabang());
                controller.submitPengajuanSurvey(biodataModel);

            }
        });
    }

    private void doSubmitApproval(final boolean approve) {
        String confirmMsg = "Anda yakin menolak pengajuan ini?";
        if (approve) {
            confirmMsg = "Anda yakin menyetujui pengajuan ini?";
        }
        DialogFactory.showConfirmation(this, getString(R.string.app_name), confirmMsg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final ApprovalProspekModel model = new ApprovalProspekModel();
                UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
                model.setIdSdm(userModel.getIdsdm());
                model.setIdAo(mDataModel.getCreatedBy());
                model.setIdDebitur(mDataModel.getIdDebitur());
                model.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
                model.setKodeUnit(userModel.getKodeUnit());
                model.setKodeCabang(userModel.getKodeCabang());
                model.setKeterangan(tvKeterangan.getText().toString());
                if (approve) {
                    model.setStatusDebitur("10");
                    model.setProgress(100);
                } else {
                    model.setStatusDebitur("9");
                    model.setProgress(90);
                }

                DialogFactory.showProgress(SurveyItemActivity.this);
                controller.submitApprovalPengajuan(model);
            }
        }, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                btnSlide.setCenterPosition();
            }
        });
    }

    @Override
    public void onCheckSIDSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (mDataModel != null) {
                    loadChecklist(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
                }
            }
        });
    }

    @Override
    public void onCheckSIDFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSendPengajuanSuccess(String message) {
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
    public void onSendPengajuanFailed(Throwable t) {
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
}
