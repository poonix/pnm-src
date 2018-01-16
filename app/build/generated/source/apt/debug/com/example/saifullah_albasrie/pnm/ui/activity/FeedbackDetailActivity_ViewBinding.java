// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedbackDetailActivity_ViewBinding<T extends FeedbackDetailActivity> implements Unbinder {
  protected T target;

  private View view2131689640;

  @UiThread
  public FeedbackDetailActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvNama = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvNama'", TextView.class);
    target.tvTaggal = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvTaggal'", TextView.class);
    target.tvDeskripsi = Utils.findRequiredViewAsType(source, R.id.tv_deskripsi, "field 'tvDeskripsi'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_revisi_survey, "method 'onClickRevisi'");
    view2131689640 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickRevisi();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvNama = null;
    target.tvTaggal = null;
    target.tvDeskripsi = null;

    view2131689640.setOnClickListener(null);
    view2131689640 = null;

    this.target = null;
  }
}
