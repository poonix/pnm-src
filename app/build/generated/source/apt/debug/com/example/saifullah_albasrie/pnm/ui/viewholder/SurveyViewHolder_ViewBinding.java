// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SurveyViewHolder_ViewBinding<T extends SurveyViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public SurveyViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mContainer = Utils.findRequiredView(source, R.id.ll_content, "field 'mContainer'");
    target.tvSubItemSurvey = Utils.findRequiredViewAsType(source, R.id.btnSubmit, "field 'tvSubItemSurvey'", TextView.class);
    target.ivStatusSurvey = Utils.findRequiredViewAsType(source, R.id.iv_statusSurvey, "field 'ivStatusSurvey'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mContainer = null;
    target.tvSubItemSurvey = null;
    target.ivStatusSurvey = null;

    this.target = null;
  }
}
