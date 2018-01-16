// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabRencanaAgunanFragment_ViewBinding<T extends ProspekTabRencanaAgunanFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekTabRencanaAgunanFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.spJenisRencanaAgunan = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_rencana_agunan, "field 'spJenisRencanaAgunan'", Spinner.class);
    target.tvNoDokumen = Utils.findRequiredViewAsType(source, R.id.tv_no_dokumen, "field 'tvNoDokumen'", EditText.class);
    target.tvKolektibilitas = Utils.findRequiredViewAsType(source, R.id.tv_kolektibilitas, "field 'tvKolektibilitas'", EditText.class);
    target.tvHintJenisAgunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_rencana_agunan, "field 'tvHintJenisAgunan'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.spJenisRencanaAgunan = null;
    target.tvNoDokumen = null;
    target.tvKolektibilitas = null;
    target.tvHintJenisAgunan = null;

    this.target = null;
  }
}
