// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReputasiPemohonAdapter$ReputasiPemohonVIewHolder_ViewBinding<T extends ReputasiPemohonAdapter.ReputasiPemohonVIewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ReputasiPemohonAdapter$ReputasiPemohonVIewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.rlContent = Utils.findRequiredViewAsType(source, R.id.ll_content, "field 'rlContent'", RelativeLayout.class);
    target.cbReputasi = Utils.findRequiredViewAsType(source, R.id.cb_reputasi, "field 'cbReputasi'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rlContent = null;
    target.cbReputasi = null;

    this.target = null;
  }
}
