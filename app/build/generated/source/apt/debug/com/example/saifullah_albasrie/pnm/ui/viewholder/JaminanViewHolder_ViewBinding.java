// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class JaminanViewHolder_ViewBinding<T extends JaminanViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public JaminanViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mContainer = Utils.findRequiredView(source, R.id.ll_content, "field 'mContainer'");
    target.tvSubJaminan = Utils.findRequiredViewAsType(source, R.id.btnSubmit, "field 'tvSubJaminan'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mContainer = null;
    target.tvSubJaminan = null;

    this.target = null;
  }
}
