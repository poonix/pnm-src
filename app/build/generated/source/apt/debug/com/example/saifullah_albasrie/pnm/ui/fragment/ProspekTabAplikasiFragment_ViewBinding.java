// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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

public class ProspekTabAplikasiFragment_ViewBinding<T extends ProspekTabAplikasiFragment> implements Unbinder {
  protected T target;

  private View view2131689759;

  @UiThread
  public ProspekTabAplikasiFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvRencanaPlafond = Utils.findRequiredViewAsType(source, R.id.tv_rencana_plafond, "field 'tvRencanaPlafond'", EditText.class);
    target.tvJangkaWaktu = Utils.findRequiredViewAsType(source, R.id.tv_jangka_waktu, "field 'tvJangkaWaktu'", EditText.class);
    target.tvKemampuan = Utils.findRequiredViewAsType(source, R.id.tv_kemampuan, "field 'tvKemampuan'", EditText.class);
    target.spTujuanPembiayaan = Utils.findRequiredViewAsType(source, R.id.spinner_tujuan_pembiayaan, "field 'spTujuanPembiayaan'", Spinner.class);
    target.spRencanaProduk = Utils.findRequiredViewAsType(source, R.id.spinner_rencana_produk, "field 'spRencanaProduk'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'layoutBtnTambahUsaha'");
    target.layoutBtnTambahUsaha = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickAddAplikasi();
      }
    });
    target.aplikasiView = Utils.findRequiredViewAsType(source, R.id.view_aplikasi, "field 'aplikasiView'", LinearLayout.class);
    target.mandatoryHintMaster = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_rencana_plafond, "field 'mandatoryHintMaster'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_rencana_produk, "field 'mandatoryHintMaster'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kemampuan_ansuran, "field 'mandatoryHintMaster'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tujuan_pembiayaan, "field 'mandatoryHintMaster'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvRencanaPlafond = null;
    target.tvJangkaWaktu = null;
    target.tvKemampuan = null;
    target.spTujuanPembiayaan = null;
    target.spRencanaProduk = null;
    target.layoutBtnTambahUsaha = null;
    target.aplikasiView = null;
    target.mandatoryHintMaster = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
