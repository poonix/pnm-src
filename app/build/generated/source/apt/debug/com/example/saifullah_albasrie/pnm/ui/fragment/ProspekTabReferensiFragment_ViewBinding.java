// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabReferensiFragment_ViewBinding<T extends ProspekTabReferensiFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekTabReferensiFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.vDummyFocus = Utils.findRequiredView(source, R.id.v_dummy_focus, "field 'vDummyFocus'");
    target.tvNamaReferensi = Utils.findRequiredViewAsType(source, R.id.tv_nama_referensi, "field 'tvNamaReferensi'", EditText.class);
    target.tvTelpReferensi = Utils.findRequiredViewAsType(source, R.id.tv_telp_referensi, "field 'tvTelpReferensi'", EditText.class);
    target.spJenisReferensi = Utils.findRequiredViewAsType(source, R.id.sp_jenis_referensi, "field 'spJenisReferensi'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.vDummyFocus = null;
    target.tvNamaReferensi = null;
    target.tvTelpReferensi = null;
    target.spJenisReferensi = null;

    this.target = null;
  }
}
