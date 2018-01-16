// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CollectionItemAdapter$ItemViewHolder_ViewBinding<T extends CollectionItemAdapter.ItemViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public CollectionItemAdapter$ItemViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvIdentity = Utils.findRequiredViewAsType(source, R.id.tv_identity_number, "field 'tvIdentity'", TextView.class);
    target.tvTglJatuhTempo = Utils.findRequiredViewAsType(source, R.id.tv_tanggal_jatuh_tempo, "field 'tvTglJatuhTempo'", TextView.class);
    target.tvAging = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvAging'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvName = null;
    target.tvIdentity = null;
    target.tvTglJatuhTempo = null;
    target.tvAging = null;

    this.target = null;
  }
}
