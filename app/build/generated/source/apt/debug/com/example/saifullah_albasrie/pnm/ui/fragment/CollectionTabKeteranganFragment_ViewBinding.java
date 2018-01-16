// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CollectionTabKeteranganFragment_ViewBinding<T extends CollectionTabKeteranganFragment> implements Unbinder {
  protected T target;

  @UiThread
  public CollectionTabKeteranganFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tvHintKeterangan = Utils.findRequiredViewAsType(source, R.id.tv_hint_keterangan, "field 'tvHintKeterangan'", TextView.class);
    target.tvKeterangan = Utils.findRequiredViewAsType(source, R.id.tv_keterangan, "field 'tvKeterangan'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvHintKeterangan = null;
    target.tvKeterangan = null;

    this.target = null;
  }
}
