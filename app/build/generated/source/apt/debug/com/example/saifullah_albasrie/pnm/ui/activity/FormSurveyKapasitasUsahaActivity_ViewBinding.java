// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyKapasitasUsahaActivity_ViewBinding<T extends FormSurveyKapasitasUsahaActivity> implements Unbinder {
  protected T target;

  private View view2131689759;

  @UiThread
  public FormSurveyKapasitasUsahaActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.spPekerjaan = Utils.findRequiredViewAsType(source, R.id.spinner_pekerjaan, "field 'spPekerjaan'", Spinner.class);
    target.rvHarta = Utils.findRequiredViewAsType(source, R.id.rv_harta, "field 'rvHarta'", RecyclerView.class);
    target.etLamaBekerja = Utils.findRequiredViewAsType(source, R.id.et_lama_bekerja, "field 'etLamaBekerja'", EditText.class);
    target.spJenisTabungan = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_rekening, "field 'spJenisTabungan'", Spinner.class);
    target.spTahunRekening = Utils.findRequiredViewAsType(source, R.id.spinner_tahun_rekening, "field 'spTahunRekening'", Spinner.class);
    target.tvTitleAktivitasBank = Utils.findRequiredViewAsType(source, R.id.tv_bank_activity, "field 'tvTitleAktivitasBank'", TextView.class);
    target.vAktivitasBank = Utils.findRequiredViewAsType(source, R.id.ll_container_aktivitas_bank, "field 'vAktivitasBank'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'btnTambah'");
    target.btnTambah = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTambahAktivitas();
      }
    });
    target.mandatoryHintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_pekerjaan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_harta_benda, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lama_bekerja, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_rekening, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun_rekening, "field 'mandatoryHintViews'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.spPekerjaan = null;
    target.rvHarta = null;
    target.etLamaBekerja = null;
    target.spJenisTabungan = null;
    target.spTahunRekening = null;
    target.tvTitleAktivitasBank = null;
    target.vAktivitasBank = null;
    target.btnTambah = null;
    target.mandatoryHintViews = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
