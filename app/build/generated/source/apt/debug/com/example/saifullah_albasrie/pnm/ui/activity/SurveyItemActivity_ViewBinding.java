// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.ui.widget.SlideButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SurveyItemActivity_ViewBinding<T extends SurveyItemActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SurveyItemActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.llContentApproval = Utils.findRequiredViewAsType(source, R.id.ll_content_approval, "field 'llContentApproval'", LinearLayout.class);
    target.btnSlide = Utils.findOptionalViewAsType(source, R.id.btn_slide, "field 'btnSlide'", SlideButton.class);
    target.tvKeterangan = Utils.findRequiredViewAsType(source, R.id.tv_keterangan, "field 'tvKeterangan'", EditText.class);
    target.tvIdSurvey = Utils.findRequiredViewAsType(source, R.id.tv_id_survey, "field 'tvIdSurvey'", TextView.class);
    target.rvSurvey = Utils.findRequiredViewAsType(source, R.id.rv_survey, "field 'rvSurvey'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.llContentApproval = null;
    target.btnSlide = null;
    target.tvKeterangan = null;
    target.tvIdSurvey = null;
    target.rvSurvey = null;

    this.target = null;
  }
}
