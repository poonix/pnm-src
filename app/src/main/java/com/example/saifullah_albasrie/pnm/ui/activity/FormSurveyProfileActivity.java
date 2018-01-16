package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyProfilKarakterCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyProfilKarakterController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisDokumenModel;
import com.example.saifullah_albasrie.pnm.model.master.ReputasiPemohonModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.adapter.ReputasiPemohonAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by aldhiramdan on 3/21/17.
 */

public class FormSurveyProfileActivity extends BaseFormActivity implements SurveyProfilKarakterCallback {

    private final String LOG_TAG = FormSurveyProfileActivity.class.getSimpleName();

    private ProspekListItemModel mDataModel;
    private SurveyProfilKarakterModel profilKarakterModel;
    private List<ReputasiPemohonModel> reputasiModel = new ArrayList<>();
    private ReputasiPemohonAdapter mAdapter;

    private SurveyProfilKarakterController controller;

    @BindView(R.id.tv_usia)
    TextView tvUsia;
    @BindView(R.id.tv_kewarganegaraan)
    EditText tvKewarganegaraan;
    @BindView(R.id.tv_pendidikan_terakhir)
    EditText tvPendidikanTerakhir;
    @BindView(R.id.tv_nama_organisasi)
    EditText tvNamaOrganisasi;

    @BindView(R.id.spinner_status_perkawinan)
    Spinner spStatusKawin;
    @BindView(R.id.spinner_kerjasama_pemohon)
    Spinner spKerjasamaPemohon;
    @BindView(R.id.spinner_track_record)
    Spinner spTrackRecord;
    @BindView(R.id.spinner_calon_debitur_mengenal_ulamm)
    Spinner spMengenalUlamm;
    //@BindView(R.id.spinner_reputasi_pemohon)
    //Spinner spReputasiPemohon;
    @BindView(R.id.tv_nama_sumber)
    EditText tvNamaSumber;
    @BindView(R.id.tv_status_hubungan)
    EditText tvStatusSumber;
    @BindView(R.id.tv_hubungan_lainnya)
    EditText tvHubunganLainnya;
    @BindView(R.id.tv_phone_sumber)
    EditText tvPhoneSumber;
    @BindView(R.id.spinner_peniaian_reputasi)
    Spinner spPenilaianReputasi;
    @BindView(R.id.spinner_jenis_dokumen)
    Spinner spJenisDokumen;
    @BindView(R.id.tv_executive_summary)
    EditText tvExum;

    @BindView(R.id.rv_reputasi)
    RecyclerView rvReputasiPemohon;

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyProfileActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_profil_dan_karakter;
    }

    @Override
    public void initData() {
        controller = new SurveyProfilKarakterController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }
        WidgetUtil.setDataMasterAdapter(spJenisDokumen, DataManager.getInstance().getJenisDokumenModelList());

        setupRecyclerView();
        loadDataReputasi();
    }

    @Override
    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getProfilKarakter(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }

    }

    @Override
    public void setEnableItems(boolean enable) {
        tvKewarganegaraan.setEnabled(enable);
        tvPendidikanTerakhir.setEnabled(enable);
        tvNamaOrganisasi.setEnabled(enable);
        spStatusKawin.setEnabled(enable);
        spKerjasamaPemohon.setEnabled(enable);
        spTrackRecord.setEnabled(enable);
        spMengenalUlamm.setEnabled(enable);
        mAdapter.setEnable(enable);
        //spReputasiPemohon.setEnabled(enable);
        tvNamaSumber.setEnabled(enable);
        tvStatusSumber.setEnabled(enable);
        tvHubunganLainnya.setEnabled(enable);
        tvPhoneSumber.setEnabled(enable);
        spPenilaianReputasi.setEnabled(enable);
        spJenisDokumen.setEnabled(enable);
        tvExum.setEnabled(enable);
    }

    @Override
    public void setupView() {
        if (profilKarakterModel != null) {
            tvUsia.setText(String.valueOf(DateUtil.getAge(profilKarakterModel.getTanggalLahir()) + " Tahun"));
            tvKewarganegaraan.setText(profilKarakterModel.getKewarganegaraan());
            tvPendidikanTerakhir.setText(profilKarakterModel.getPendidikanTerakhir());
            tvNamaOrganisasi.setText(profilKarakterModel.getNamaOrganisasi());
            spStatusKawin.setSelection(WidgetUtil.getSpinnerIndexByLabel(spStatusKawin, profilKarakterModel.getStatusPerkawinan()));
            spKerjasamaPemohon.setSelection(WidgetUtil.getSpinnerIndexByLabel(spKerjasamaPemohon, profilKarakterModel.getKerjasamaPemohon()));
            spTrackRecord.setSelection(WidgetUtil.getSpinnerIndexByLabel(spTrackRecord, profilKarakterModel.getTrackRecord()));
            spMengenalUlamm.setSelection(WidgetUtil.getSpinnerIndexByLabel(spMengenalUlamm, profilKarakterModel.getMengenalUlamm()));
            //spReputasiPemohon.setSelection(WidgetUtil.getSpinnerIndexByLabel(spReputasiPemohon, profilKarakterModel.getReputasi()));
            String sReputasi = profilKarakterModel.getReputasi();
            if (!TextUtils.isEmpty(sReputasi)) {
                String[] sChecked = sReputasi.split(";");
                mAdapter.setCheckedItems(sChecked);
            }
            tvNamaSumber.setText(profilKarakterModel.getNamaSumber());
            tvStatusSumber.setText(profilKarakterModel.getStatusSumber());
            tvHubunganLainnya.setText(profilKarakterModel.getHubunganLainSumber());
            tvPhoneSumber.setText(profilKarakterModel.getHandphoneSumber());
            spPenilaianReputasi.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPenilaianReputasi, profilKarakterModel.getPenilaianReputasiSumber()));
            spJenisDokumen.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJenisDokumen, profilKarakterModel.getNamaJenisDokumen()));
            tvExum.setText(profilKarakterModel.getExum());
        }
    }

    @Override
    public void saveData() {
        if (profilKarakterModel == null)
            profilKarakterModel = new SurveyProfilKarakterModel();

        profilKarakterModel.setKewarganegaraan(tvKewarganegaraan.getText().toString());
        profilKarakterModel.setPendidikanTerakhir(tvPendidikanTerakhir.getText().toString());
        profilKarakterModel.setNamaOrganisasi(tvNamaOrganisasi.getText().toString());
        profilKarakterModel.setStatusPerkawinan(spStatusKawin.getSelectedItem().toString());
        if (spKerjasamaPemohon.getSelectedItemPosition() > 0) {
            profilKarakterModel.setKerjasamaPemohon(spKerjasamaPemohon.getSelectedItem().toString());
        }
        if (spTrackRecord.getSelectedItemPosition() > 0) {
            profilKarakterModel.setTrackRecord(spTrackRecord.getSelectedItem().toString());
        }
        profilKarakterModel.setMengenalUlamm(spMengenalUlamm.getSelectedItem().toString());
        /*if (spReputasiPemohon.getSelectedItemPosition() > 0) {
            profilKarakterModel.setReputasi(spReputasiPemohon.getSelectedItem().toString());
        }*/
        List checkedReputasi = mAdapter.getCheckedItemsId();
        String sCheckedReputasi = android.text.TextUtils.join(";", checkedReputasi);
        profilKarakterModel.setReputasi(sCheckedReputasi);
        profilKarakterModel.setNamaSumber(tvNamaSumber.getText().toString());
        profilKarakterModel.setStatusSumber(tvStatusSumber.getText().toString());
        profilKarakterModel.setHubunganLainSumber(tvHubunganLainnya.getText().toString());
        profilKarakterModel.setHandphoneSumber(tvPhoneSumber.getText().toString());
        if (spPenilaianReputasi.getSelectedItemPosition() > 0) {
            profilKarakterModel.setPenilaianReputasiSumber(spPenilaianReputasi.getSelectedItem().toString());
        }
        JenisDokumenModel dokumenModel = (JenisDokumenModel) spJenisDokumen.getSelectedItem();
        if (spJenisDokumen.getSelectedItemPosition() > 0 && dokumenModel != null) {
            profilKarakterModel.setIdJenisDokumen(String.valueOf(dokumenModel.getId()));
            profilKarakterModel.setNamaJenisDokumen(dokumenModel.getJenisDokumen());
        }
        profilKarakterModel.setExum(tvExum.getText().toString());

        DialogFactory.showProgress(this);
        controller.saveProfilKarakter(profilKarakterModel);
    }

    @Override
    public void onGetProfilKarakterSuccess(SurveyProfilKarakterModel profileKarakterModel) {
        Log.d(LOG_TAG, "onGetProfilKarakterSuccess -> " + (profileKarakterModel != null ? profileKarakterModel.toString() : ""));
        DialogFactory.dismissProgress();
        this.profilKarakterModel = profileKarakterModel;
        setupView();
    }

    @Override
    public void onGetProfilKarakterFailed(Throwable t) {
        Log.d(LOG_TAG, "onGetProfilKarakterFailed -> " + t.getMessage());
        DialogFactory.dismissProgress();
    }

    @Override
    public void onSaveProfileKrakterSuccess(String message) {
        Log.d(LOG_TAG, "onSaveProfileKrakterSuccess -> " + message);
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //changeToViewMode();
                //setResult(RESULT_OK);
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });

    }

    @Override
    public void onSaveProfileKrakterFailed(Throwable t) {
        Log.d(LOG_TAG, "onSaveProfileKrakterFailed -> " + t.getMessage());
        DialogFactory.dismissProgress();
    }

    private void setupRecyclerView() {
        mAdapter = new ReputasiPemohonAdapter(reputasiModel);

        rvReputasiPemohon.setHasFixedSize(true);
        rvReputasiPemohon.setItemAnimator(new DefaultItemAnimator());
        rvReputasiPemohon.setAdapter(mAdapter);
        rvReputasiPemohon.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void loadDataReputasi() {
        reputasiModel.clear();
        String[] listReputasi = getResources().getStringArray(R.array.applicant_reputation);
        for (int i = 0; i < listReputasi.length; i++) {
            ReputasiPemohonModel model = new ReputasiPemohonModel();
            model.setText(listReputasi[i]);
            reputasiModel.add(model);
        }
        mAdapter.notifyDataSetChanged();
    }

}
