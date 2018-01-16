// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabAlamatFragment_ViewBinding<T extends ProspekTabAlamatFragment> implements Unbinder {
  protected T target;

  private View view2131689759;

  @UiThread
  public ProspekTabAlamatFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvHintAlamatPrioritas = Utils.findRequiredViewAsType(source, R.id.tv_hint_alamat_prioritas, "field 'tvHintAlamatPrioritas'", TextView.class);
    target.spAlamatPrioritas = Utils.findRequiredViewAsType(source, R.id.sp_alamat_prioritas, "field 'spAlamatPrioritas'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'layoutBtnTambahAlamat'");
    target.layoutBtnTambahAlamat = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickAddAlamat();
      }
    });
    target.alamatView = Utils.findRequiredViewAsType(source, R.id.view_alamat, "field 'alamatView'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvHintAlamatPrioritas = null;
    target.spAlamatPrioritas = null;
    target.layoutBtnTambahAlamat = null;
    target.alamatView = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
