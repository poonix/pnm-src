package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class FeedbackDetailActivity extends BaseActivity {

    private FeedbackItemModel mDataModel;

    @BindView(R.id.tv_title)
    TextView tvNama;
    @BindView(R.id.tv_date)
    TextView tvTaggal;
    @BindView(R.id.tv_deskripsi)
    TextView tvDeskripsi;

    @OnClick(R.id.btn_revisi_survey)
    void onClickRevisi() {
        showSurvey();
    }

    public static void navigate(Activity activity, FeedbackItemModel model) {
        Intent intent = new Intent(activity, FeedbackDetailActivity.class);
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
        return R.layout.activity_feedback_detail;
    }

    private void initData() {
        setTitle(getString(R.string.feedback));
        if (getIntent() != null) {
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
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
            intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
            intent.putExtra(Constant.BUNDLE_DATA, prospekModel);
            startActivity(intent);
        }
    }
}
