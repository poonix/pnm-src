// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131689679;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.rvMenu = Utils.findRequiredViewAsType(source, R.id.rv_menu, "field 'rvMenu'", RecyclerView.class);
    target.tvLogout = Utils.findRequiredViewAsType(source, R.id.tvLogout, "field 'tvLogout'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ivLogout, "field 'ivLogout' and method 'setOnClick'");
    target.ivLogout = Utils.castView(view, R.id.ivLogout, "field 'ivLogout'", ImageView.class);
    view2131689679 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setOnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.drawer = null;
    target.rvMenu = null;
    target.tvLogout = null;
    target.ivLogout = null;

    view2131689679.setOnClickListener(null);
    view2131689679 = null;

    this.target = null;
  }
}
