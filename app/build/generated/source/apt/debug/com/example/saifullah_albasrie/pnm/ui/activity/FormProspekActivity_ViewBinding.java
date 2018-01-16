// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormProspekActivity_ViewBinding<T extends FormProspekActivity> implements Unbinder {
  protected T target;

  private View view2131689628;

  private View view2131689630;

  @UiThread
  public FormProspekActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mAppBarLayout = Utils.findRequiredViewAsType(source, R.id.appbar, "field 'mAppBarLayout'", AppBarLayout.class);
    target.llDetailContent = Utils.findRequiredViewAsType(source, R.id.ll_detail_content, "field 'llDetailContent'", LinearLayout.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'mViewPager'", ViewPager.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.llContentApproval = Utils.findRequiredViewAsType(source, R.id.ll_content_approval, "field 'llContentApproval'", LinearLayout.class);
    target.btnSlide = Utils.findOptionalViewAsType(source, R.id.btn_slide, "field 'btnSlide'", SlideButton.class);
    target.tvKeterangan = Utils.findRequiredViewAsType(source, R.id.tv_keterangan, "field 'tvKeterangan'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_call, "field 'btnCall' and method 'onClick'");
    target.btnCall = Utils.castView(view, R.id.btn_call, "field 'btnCall'", Button.class);
    view2131689628 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_message, "field 'btnSms' and method 'onClick'");
    target.btnSms = Utils.castView(view, R.id.btn_message, "field 'btnSms'", Button.class);
    view2131689630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tabs = Utils.findRequiredViewAsType(source, R.id.tabs, "field 'tabs'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mAppBarLayout = null;
    target.llDetailContent = null;
    target.mViewPager = null;
    target.toolbar = null;
    target.llContentApproval = null;
    target.btnSlide = null;
    target.tvKeterangan = null;
    target.btnCall = null;
    target.btnSms = null;
    target.tabs = null;

    view2131689628.setOnClickListener(null);
    view2131689628 = null;
    view2131689630.setOnClickListener(null);
    view2131689630 = null;

    this.target = null;
  }
}
