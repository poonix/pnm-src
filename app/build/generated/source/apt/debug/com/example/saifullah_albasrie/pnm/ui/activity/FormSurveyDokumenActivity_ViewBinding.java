// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyDokumenActivity_ViewBinding<T extends FormSurveyDokumenActivity> implements Unbinder {
  protected T target;

  private View view2131690160;

  private View view2131690163;

  private View view2131690166;

  private View view2131690169;

  private View view2131690172;

  @UiThread
  public FormSurveyDokumenActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvJumlahDokPribadi = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_dok_pribadi, "field 'tvJumlahDokPribadi'", TextView.class);
    target.tvJumlahDokKeluarga = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_dok_keluarga, "field 'tvJumlahDokKeluarga'", TextView.class);
    target.tvJumlahDokPembiayaan = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_dok_pembiayaan, "field 'tvJumlahDokPembiayaan'", TextView.class);
    target.tvJumlahDokPinjaman = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_dok_pinjaman, "field 'tvJumlahDokPinjaman'", TextView.class);
    target.tvJumlahDokAgunan = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_dok_agunan, "field 'tvJumlahDokAgunan'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_dokumen_pribadi, "method 'onClickItem'");
    view2131690160 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickItem(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_dokumen_keluarga, "method 'onClickItem'");
    view2131690163 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickItem(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_dokumen_pembiayaan, "method 'onClickItem'");
    view2131690166 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickItem(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_dokumen_pinjaman, "method 'onClickItem'");
    view2131690169 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickItem(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_dokumen_agunan, "method 'onClickItem'");
    view2131690172 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickItem(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvJumlahDokPribadi = null;
    target.tvJumlahDokKeluarga = null;
    target.tvJumlahDokPembiayaan = null;
    target.tvJumlahDokPinjaman = null;
    target.tvJumlahDokAgunan = null;

    view2131690160.setOnClickListener(null);
    view2131690160 = null;
    view2131690163.setOnClickListener(null);
    view2131690163 = null;
    view2131690166.setOnClickListener(null);
    view2131690166 = null;
    view2131690169.setOnClickListener(null);
    view2131690169 = null;
    view2131690172.setOnClickListener(null);
    view2131690172 = null;

    this.target = null;
  }
}
