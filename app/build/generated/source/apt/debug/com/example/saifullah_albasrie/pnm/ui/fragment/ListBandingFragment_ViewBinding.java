// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListBandingFragment_ViewBinding<T extends ListBandingFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ListBandingFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.mSwipeContainer = Utils.findRequiredViewAsType(source, R.id.swipeContainer, "field 'mSwipeContainer'", SwipeRefreshLayout.class);
    target.rvProspek = Utils.findRequiredViewAsType(source, R.id.rv_prospek, "field 'rvProspek'", RecyclerView.class);
    target.fabAdd = Utils.findRequiredViewAsType(source, R.id.fab_add, "field 'fabAdd'", FloatingActionButton.class);
    target.tvMessage = Utils.findRequiredViewAsType(source, R.id.tv_message, "field 'tvMessage'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mSwipeContainer = null;
    target.rvProspek = null;
    target.fabAdd = null;
    target.tvMessage = null;

    this.target = null;
  }
}
