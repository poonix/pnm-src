package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyDokumenChecklistCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyDokumenChecklistController;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.DocumentType;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenListResponse;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by aldhiramdan on 3/26/17.
 */

public class FormSurveyDokumenActivity extends BaseActivity implements SurveyDokumenChecklistCallback{

    private int formMode;
    private ProspekListItemModel mDataModel;
    private SurveyDokumenListResponse dokumenListResponse;

    private SurveyDokumenChecklistController controller;

    @BindView(R.id.tv_jumlah_dok_pribadi)
    TextView tvJumlahDokPribadi;
    @BindView(R.id.tv_jumlah_dok_keluarga)
    TextView tvJumlahDokKeluarga;
    @BindView(R.id.tv_jumlah_dok_pembiayaan)
    TextView tvJumlahDokPembiayaan;
    @BindView(R.id.tv_jumlah_dok_pinjaman)
    TextView tvJumlahDokPinjaman;
    @BindView(R.id.tv_jumlah_dok_agunan)
    TextView tvJumlahDokAgunan;

    @OnClick({
            R.id.rl_dokumen_pribadi,
            R.id.rl_dokumen_keluarga,
            R.id.rl_dokumen_pembiayaan,
            R.id.rl_dokumen_pinjaman,
            R.id.rl_dokumen_agunan
    })
    void onClickItem(View v) {
        switch (v.getId()) {
            case R.id.rl_dokumen_pribadi:
                showDocument(DocumentType.PRIBADI);
                break;
            case R.id.rl_dokumen_keluarga:
                showDocument(DocumentType.KELUARGA);
                break;
            case R.id.rl_dokumen_pembiayaan:
                showDocument(DocumentType.PEMBIAYAAN);
                break;
            case R.id.rl_dokumen_pinjaman:
                showDocument(DocumentType.PINJAMAN);
                break;
            case R.id.rl_dokumen_agunan:
                showDocument(DocumentType.AGUNAN);
                break;
        }
    }
    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyDokumenActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        return R.layout.layout_dokumen_lainnya;
    }

    public void initData() {
        controller = new SurveyDokumenChecklistController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }
    }

    private void loadData() {
        if (mDataModel !=null) {
            DialogFactory.showProgress(this);
            controller.getSurveyDokumenChecklist(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    private void setupView() {
        if (dokumenListResponse != null) {
            tvJumlahDokPribadi.setText(String.valueOf(dokumenListResponse.getDokumenPribadi().getJumlahFoto()) + " Foto");
            tvJumlahDokKeluarga.setText(String.valueOf(dokumenListResponse.getDokumenKeluarga().getJumlahFoto()) + " Foto");
            tvJumlahDokPembiayaan.setText(String.valueOf(dokumenListResponse.getDokumenPembiayaan().getJumlahFoto()) + " Foto");
            tvJumlahDokPinjaman.setText(String.valueOf(dokumenListResponse.getDokumenPinjaman().getJumlahFoto()) + " Foto");
            tvJumlahDokAgunan.setText(String.valueOf(dokumenListResponse.getDokumenAgunan().getJumlahFoto()) + " Foto");
        }
    }

    @Subscribe
    public void onDataChanged(DataStateChanged event) {
        if (event != null && event.isRefresh()) {
            loadData();
        }
    }

    private void showDocument(@DocumentType String type) {
        FormSurveyAddDokumenActivity.navigate(this, formMode, mDataModel, type);
    }

    @Override
    public void onGetSurveyDokumenChecklistSuccess(SurveyDokumenListResponse response) {
        DialogFactory.dismissProgress();
        dokumenListResponse = response;
        setupView();
    }

    @Override
    public void onGetSurveyDokumenChecklistFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
