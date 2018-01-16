// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabLainnyaFragment_ViewBinding<T extends ProspekTabLainnyaFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekTabLainnyaFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.spKodeUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_kode_usaha, "field 'spKodeUsaha'", Spinner.class);
    target.spKodeBidangUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_kode_bidang_usaha, "field 'spKodeBidangUsaha'", Spinner.class);
    target.spHubDebiturPnm = Utils.findRequiredViewAsType(source, R.id.spinner_hub_debitur_pnm, "field 'spHubDebiturPnm'", Spinner.class);
    target.spHubDebiturBank = Utils.findRequiredViewAsType(source, R.id.spinner_hub_debitur_bank, "field 'spHubDebiturBank'", Spinner.class);
    target.mandatoryView = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kode_usaha, "field 'mandatoryView'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_bidang_usaha, "field 'mandatoryView'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_hub_debitur_pnm, "field 'mandatoryView'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_hub_debitur_bank, "field 'mandatoryView'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.spKodeUsaha = null;
    target.spKodeBidangUsaha = null;
    target.spHubDebiturPnm = null;
    target.spHubDebiturBank = null;
    target.mandatoryView = null;

    this.target = null;
  }
}
