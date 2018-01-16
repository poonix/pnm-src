// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.adapter;

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

public class FeedbackItemAdapter$ItemViewHolder_ViewBinding<T extends FeedbackItemAdapter.ItemViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public FeedbackItemAdapter$ItemViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivIcon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivIcon = null;
    target.tvTitle = null;
    target.tvDate = null;

    this.target = null;
  }
}
