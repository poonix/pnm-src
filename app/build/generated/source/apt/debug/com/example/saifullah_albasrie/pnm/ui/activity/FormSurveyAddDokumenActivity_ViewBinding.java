// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyAddDokumenActivity_ViewBinding<T extends FormSurveyAddDokumenActivity> implements Unbinder {
  protected T target;

  private View view2131689618;

  private View view2131689616;

  private View view2131689617;

  @UiThread
  public FormSurveyAddDokumenActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.layoutGallery = Utils.findRequiredView(source, R.id.layout_Gallery, "field 'layoutGallery'");
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.button_add_foto, "field 'btnAddPhoto' and method 'OnClick'");
    target.btnAddPhoto = view;
    view2131689618 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_left, "method 'OnClick'");
    view2131689616 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_right, "method 'OnClick'");
    view2131689617 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.layoutGallery = null;
    target.viewPager = null;
    target.btnAddPhoto = null;

    view2131689618.setOnClickListener(null);
    view2131689618 = null;
    view2131689616.setOnClickListener(null);
    view2131689616 = null;
    view2131689617.setOnClickListener(null);
    view2131689617 = null;

    this.target = null;
  }
}
