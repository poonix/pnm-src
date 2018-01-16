// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyProfileActivity_ViewBinding<T extends FormSurveyProfileActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FormSurveyProfileActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvUsia = Utils.findRequiredViewAsType(source, R.id.tv_usia, "field 'tvUsia'", TextView.class);
    target.tvKewarganegaraan = Utils.findRequiredViewAsType(source, R.id.tv_kewarganegaraan, "field 'tvKewarganegaraan'", EditText.class);
    target.tvPendidikanTerakhir = Utils.findRequiredViewAsType(source, R.id.tv_pendidikan_terakhir, "field 'tvPendidikanTerakhir'", EditText.class);
    target.tvNamaOrganisasi = Utils.findRequiredViewAsType(source, R.id.tv_nama_organisasi, "field 'tvNamaOrganisasi'", EditText.class);
    target.spStatusKawin = Utils.findRequiredViewAsType(source, R.id.spinner_status_perkawinan, "field 'spStatusKawin'", Spinner.class);
    target.spKerjasamaPemohon = Utils.findRequiredViewAsType(source, R.id.spinner_kerjasama_pemohon, "field 'spKerjasamaPemohon'", Spinner.class);
    target.spTrackRecord = Utils.findRequiredViewAsType(source, R.id.spinner_track_record, "field 'spTrackRecord'", Spinner.class);
    target.spMengenalUlamm = Utils.findRequiredViewAsType(source, R.id.spinner_calon_debitur_mengenal_ulamm, "field 'spMengenalUlamm'", Spinner.class);
    target.tvNamaSumber = Utils.findRequiredViewAsType(source, R.id.tv_nama_sumber, "field 'tvNamaSumber'", EditText.class);
    target.tvStatusSumber = Utils.findRequiredViewAsType(source, R.id.tv_status_hubungan, "field 'tvStatusSumber'", EditText.class);
    target.tvHubunganLainnya = Utils.findRequiredViewAsType(source, R.id.tv_hubungan_lainnya, "field 'tvHubunganLainnya'", EditText.class);
    target.tvPhoneSumber = Utils.findRequiredViewAsType(source, R.id.tv_phone_sumber, "field 'tvPhoneSumber'", EditText.class);
    target.spPenilaianReputasi = Utils.findRequiredViewAsType(source, R.id.spinner_peniaian_reputasi, "field 'spPenilaianReputasi'", Spinner.class);
    target.spJenisDokumen = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_dokumen, "field 'spJenisDokumen'", Spinner.class);
    target.tvExum = Utils.findRequiredViewAsType(source, R.id.tv_executive_summary, "field 'tvExum'", EditText.class);
    target.rvReputasiPemohon = Utils.findRequiredViewAsType(source, R.id.rv_reputasi, "field 'rvReputasiPemohon'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvUsia = null;
    target.tvKewarganegaraan = null;
    target.tvPendidikanTerakhir = null;
    target.tvNamaOrganisasi = null;
    target.spStatusKawin = null;
    target.spKerjasamaPemohon = null;
    target.spTrackRecord = null;
    target.spMengenalUlamm = null;
    target.tvNamaSumber = null;
    target.tvStatusSumber = null;
    target.tvHubunganLainnya = null;
    target.tvPhoneSumber = null;
    target.spPenilaianReputasi = null;
    target.spJenisDokumen = null;
    target.tvExum = null;
    target.rvReputasiPemohon = null;

    this.target = null;
  }
}
