// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyActivity_ViewBinding<T extends FormSurveyActivity> implements Unbinder {
  protected T target;

  private View view2131689759;

  private View view2131689747;

  @UiThread
  public FormSurveyActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.sv_form_survey, "field 'scrollView'", ScrollView.class);
    target.spRencanaProduk = Utils.findRequiredViewAsType(source, R.id.spinner_rencana_produk, "field 'spRencanaProduk'", Spinner.class);
    target.tvRencanaPlafond = Utils.findRequiredViewAsType(source, R.id.tv_rencana_plafond, "field 'tvRencanaPlafond'", EditText.class);
    target.tvJangkaWaktu = Utils.findRequiredViewAsType(source, R.id.tv_jangka_waktu, "field 'tvJangkaWaktu'", EditText.class);
    target.tvKemampuanAngsuran = Utils.findRequiredViewAsType(source, R.id.tv_kemampuan_angsuran, "field 'tvKemampuanAngsuran'", EditText.class);
    target.spTujuanPembiayaan = Utils.findRequiredViewAsType(source, R.id.spinner_tujuan_pembiayaan, "field 'spTujuanPembiayaan'", Spinner.class);
    target.alamatView = Utils.findRequiredViewAsType(source, R.id.ll_container_alamat, "field 'alamatView'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'vButtonTambah'");
    target.vButtonTambah = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickAddAlamat();
      }
    });
    target.tvExum = Utils.findRequiredViewAsType(source, R.id.tv_executive_summary, "field 'tvExum'", EditText.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_pilih_tanggal, "field 'tvDate'", TextView.class);
    view = Utils.findRequiredView(source, R.id.picker_date, "field 'ivPickerDate' and method 'onCLick'");
    target.ivPickerDate = view;
    view2131689747 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCLick(p0);
      }
    });
    target.mandatoryHintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tanggal_survey, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_rencana_plafon, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jangka_waktu, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kemampuan_angsuran, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tujuan_pembiayaan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_executive_summary, "field 'mandatoryHintViews'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.scrollView = null;
    target.spRencanaProduk = null;
    target.tvRencanaPlafond = null;
    target.tvJangkaWaktu = null;
    target.tvKemampuanAngsuran = null;
    target.spTujuanPembiayaan = null;
    target.alamatView = null;
    target.vButtonTambah = null;
    target.tvExum = null;
    target.tvDate = null;
    target.ivPickerDate = null;
    target.mandatoryHintViews = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;
    view2131689747.setOnClickListener(null);
    view2131689747 = null;

    this.target = null;
  }
}
