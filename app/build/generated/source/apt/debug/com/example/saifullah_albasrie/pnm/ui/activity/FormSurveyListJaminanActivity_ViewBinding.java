// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyListJaminanActivity_ViewBinding<T extends FormSurveyListJaminanActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FormSurveyListJaminanActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rvJaminan = Utils.findRequiredViewAsType(source, R.id.rv_jaminan, "field 'rvJaminan'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rvJaminan = null;

    this.target = null;
  }
}
