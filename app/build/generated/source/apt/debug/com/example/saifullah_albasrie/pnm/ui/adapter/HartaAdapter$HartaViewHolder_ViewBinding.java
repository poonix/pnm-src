// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HartaAdapter$HartaViewHolder_ViewBinding<T extends HartaAdapter.HartaViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HartaAdapter$HartaViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mContainer = Utils.findRequiredView(source, R.id.ll_content, "field 'mContainer'");
    target.cbHarta = Utils.findRequiredViewAsType(source, R.id.cb_harta, "field 'cbHarta'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mContainer = null;
    target.cbHarta = null;

    this.target = null;
  }
}
