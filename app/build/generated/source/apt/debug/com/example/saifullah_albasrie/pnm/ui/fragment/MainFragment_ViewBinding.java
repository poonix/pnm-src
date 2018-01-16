// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainFragment_ViewBinding<T extends MainFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MainFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvJabatan = Utils.findRequiredViewAsType(source, R.id.tv_jabatan, "field 'tvJabatan'", TextView.class);
    target.tvArea = Utils.findRequiredViewAsType(source, R.id.tv_area, "field 'tvArea'", TextView.class);
    target.tvLastLogin = Utils.findRequiredViewAsType(source, R.id.tv_last_login, "field 'tvLastLogin'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvName = null;
    target.tvJabatan = null;
    target.tvArea = null;
    target.tvLastLogin = null;

    this.target = null;
  }
}
