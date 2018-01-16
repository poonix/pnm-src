// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabCheckSIDFragment_ViewBinding<T extends ProspekTabCheckSIDFragment> implements Unbinder {
  protected T target;

  private View view2131689843;

  @UiThread
  public ProspekTabCheckSIDFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_check_sid, "field 'btnCheckSID' and method 'onClickCheckSID'");
    target.btnCheckSID = Utils.castView(view, R.id.btn_check_sid, "field 'btnCheckSID'", Button.class);
    view2131689843 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickCheckSID();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnCheckSID = null;

    view2131689843.setOnClickListener(null);
    view2131689843 = null;

    this.target = null;
  }
}
