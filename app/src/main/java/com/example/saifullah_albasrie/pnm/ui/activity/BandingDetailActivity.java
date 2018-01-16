package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.BandingDetailCallback;
import com.example.saifullah_albasrie.pnm.controller.BandingDetailController;
import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import butterknife.BindView;
import butterknife.OnClick;

public class BandingDetailActivity extends BaseActivity implements BandingDetailCallback{

    private FeedbackItemModel mDataModel;
    private BandingDetailController controller;

    @BindView(R.id.tv_title)
    TextView tvNama;
    @BindView(R.id.tv_date)
    TextView tvTaggal;
    @BindView(R.id.tv_deskripsi)
    TextView tvDeskripsi;

    @BindView(R.id.btn_slide)
    SlideButton btnSlide;
    @BindView(R.id.tv_keterangan)
    EditText tvKeterangan;

    @OnClick(R.id.btn_lihat_survey)
    void onClickShowSurvey() {
        showSurvey();
    }

    public static void navigate(Activity activity, FeedbackItemModel model) {
        Intent intent = new Intent(activity, BandingDetailActivity.class);
        intent.putExtra(Constant.BUNDLE_DATA, model);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        loadData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_banding_detail;
    }

    private void initData() {
        setTitle(getString(R.string.banding));
        if (getIntent() != null) {
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        controller = new BandingDetailController(this);

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

    private void loadData() {
        if (mDataModel != null) {
            tvNama.setText(mDataModel.getNamaPanggilan());
            tvTaggal.setText(DateUtil.convertDateToNormal(mDataModel.getModifiedDate()));
            tvDeskripsi.setText(mDataModel.getKeterangan());
        }
    }

    private void showSurvey() {
        if (mDataModel != null) {
            ProspekListItemModel prospekModel = new ProspekListItemModel();
            prospekModel.setIdDebitur(mDataModel.getIdDebitur());
            prospekModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
            Intent intent = new Intent(this, SurveyItemActivity.class);
            intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.READ_ONLY);
            intent.putExtra(Constant.BUNDLE_DATA, prospekModel);
            startActivity(intent);
        }
    }

    private void doSubmitApproval(final boolean approve) {
        String confirmMsg = "Anda yakin menolak banding ini?";
        if (approve) {
            confirmMsg = "Anda yakin menyetujui banding ini?";
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
                    model.setStatusDebitur("8");
                    model.setProgress(80);
                } else {
                    model.setStatusDebitur("9");
                    model.setProgress(90);
                }

                DialogFactory.showProgress(BandingDetailActivity.this);
                controller.sendApprovalBanding(model);
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
}
