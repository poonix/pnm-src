// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabHistoryPembiayaanFragment_ViewBinding<T extends ProspekTabHistoryPembiayaanFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekTabHistoryPembiayaanFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.rvRiwayatAngsuran = Utils.findRequiredViewAsType(source, R.id.rv_riwayat_angsuran, "field 'rvRiwayatAngsuran'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rvRiwayatAngsuran = null;

    this.target = null;
  }
}
