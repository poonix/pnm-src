// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FilterActivity_ViewBinding<T extends FilterActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FilterActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.vLayoutFilterByStatus = Utils.findRequiredView(source, R.id.layout_filter_status_survey, "field 'vLayoutFilterByStatus'");
    target.vLayoutFilterByDate = Utils.findRequiredView(source, R.id.layout_filter_by_date, "field 'vLayoutFilterByDate'");
    target.vLayoutFilterByJatuhTempo = Utils.findRequiredView(source, R.id.layout_filter_jatuh_dempo, "field 'vLayoutFilterByJatuhTempo'");
    target.rbAscending = Utils.findRequiredViewAsType(source, R.id.rbAscending, "field 'rbAscending'", RadioButton.class);
    target.viewStatus = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.status_all, "field 'viewStatus'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.status_survey, "field 'viewStatus'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.status_revisi, "field 'viewStatus'", TextView.class));
    target.viewCreated = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.created_in_any, "field 'viewCreated'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.created_in_today, "field 'viewCreated'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.created_in_7, "field 'viewCreated'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.created_in_30, "field 'viewCreated'", TextView.class));
    target.viewJatuhTempo = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.jatuh_tempo_all, "field 'viewJatuhTempo'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.jatuh_tempo_h7, "field 'viewJatuhTempo'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.jatuh_tempo_h3, "field 'viewJatuhTempo'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.jatuh_tempo_h1, "field 'viewJatuhTempo'", TextView.class));
    target.viewSortby = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.sort_default, "field 'viewSortby'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.sort_aging, "field 'viewSortby'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.sort_os, "field 'viewSortby'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.vLayoutFilterByStatus = null;
    target.vLayoutFilterByDate = null;
    target.vLayoutFilterByJatuhTempo = null;
    target.rbAscending = null;
    target.viewStatus = null;
    target.viewCreated = null;
    target.viewJatuhTempo = null;
    target.viewSortby = null;

    this.target = null;
  }
}
