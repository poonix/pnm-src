// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CollectionTabKolektibilitasFragment_ViewBinding<T extends CollectionTabKolektibilitasFragment> implements Unbinder {
  protected T target;

  @UiThread
  public CollectionTabKolektibilitasFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tvDataKolektibilitas = Utils.findRequiredViewAsType(source, R.id.tv_data_kolektibilitas, "field 'tvDataKolektibilitas'", EditText.class);
    target.tvHintDataKolektibilitas = Utils.findRequiredViewAsType(source, R.id.tv_hint_data_kolektibilitas, "field 'tvHintDataKolektibilitas'", TextView.class);
    target.tvHintTindakLanjut = Utils.findRequiredViewAsType(source, R.id.tv_hint_tindak_lanjut, "field 'tvHintTindakLanjut'", TextView.class);
    target.tvTindakLanjut = Utils.findRequiredViewAsType(source, R.id.tv_tindak_lanjut, "field 'tvTindakLanjut'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvDataKolektibilitas = null;
    target.tvHintDataKolektibilitas = null;
    target.tvHintTindakLanjut = null;
    target.tvTindakLanjut = null;

    this.target = null;
  }
}
