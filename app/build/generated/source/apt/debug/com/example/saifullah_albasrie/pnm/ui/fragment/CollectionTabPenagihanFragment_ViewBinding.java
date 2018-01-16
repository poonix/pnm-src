// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CollectionTabPenagihanFragment_ViewBinding<T extends CollectionTabPenagihanFragment> implements Unbinder {
  protected T target;

  private View view2131689747;

  @UiThread
  public CollectionTabPenagihanFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvHintRencanaPenagihan = Utils.findRequiredViewAsType(source, R.id.tv_hint_rencana_penagihan, "field 'tvHintRencanaPenagihan'", TextView.class);
    target.tvRencanaPenagihan = Utils.findRequiredViewAsType(source, R.id.tv_rencana_penagihan, "field 'tvRencanaPenagihan'", TextView.class);
    target.tvHintPersonalDebitur = Utils.findRequiredViewAsType(source, R.id.tv_hint_personal_debitur, "field 'tvHintPersonalDebitur'", TextView.class);
    target.tvPersonalDebitur = Utils.findRequiredViewAsType(source, R.id.tv_personal_debitur, "field 'tvPersonalDebitur'", EditText.class);
    target.tvHintTanggalPenagihan = Utils.findRequiredViewAsType(source, R.id.tv_hint_tgl_penagihan, "field 'tvHintTanggalPenagihan'", TextView.class);
    target.tvTanggalPenagihan = Utils.findRequiredViewAsType(source, R.id.tv_tgl_penagihan, "field 'tvTanggalPenagihan'", TextView.class);
    view = Utils.findRequiredView(source, R.id.picker_date, "field 'vPickerDate' and method 'onClickDate'");
    target.vPickerDate = view;
    view2131689747 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickDate();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvHintRencanaPenagihan = null;
    target.tvRencanaPenagihan = null;
    target.tvHintPersonalDebitur = null;
    target.tvPersonalDebitur = null;
    target.tvHintTanggalPenagihan = null;
    target.tvTanggalPenagihan = null;
    target.vPickerDate = null;

    view2131689747.setOnClickListener(null);
    view2131689747 = null;

    this.target = null;
  }
}
