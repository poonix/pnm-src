// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabJadwalFragment_ViewBinding<T extends ProspekTabJadwalFragment> implements Unbinder {
  protected T target;

  private View view2131689845;

  @UiThread
  public ProspekTabJadwalFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnTambahJadwal, "field 'btnTambahJadwal'");
    target.btnTambahJadwal = Utils.castView(view, R.id.btnTambahJadwal, "field 'btnTambahJadwal'", Button.class);
    view2131689845 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickAddJadwal();
      }
    });
    target.jadwalView = Utils.findRequiredViewAsType(source, R.id.view_jadwal, "field 'jadwalView'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnTambahJadwal = null;
    target.jadwalView = null;

    view2131689845.setOnClickListener(null);
    view2131689845 = null;

    this.target = null;
  }
}
