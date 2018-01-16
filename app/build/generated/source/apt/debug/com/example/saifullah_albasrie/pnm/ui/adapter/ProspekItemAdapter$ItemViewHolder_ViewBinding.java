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

public class ProspekItemAdapter$ItemViewHolder_ViewBinding<T extends ProspekItemAdapter.ItemViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekItemAdapter$ItemViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivIcon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvIdentity = Utils.findRequiredViewAsType(source, R.id.tv_identity_number, "field 'tvIdentity'", TextView.class);
    target.tvVisit = Utils.findRequiredViewAsType(source, R.id.tv_visit, "field 'tvVisit'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    target.tvIdDebitur = Utils.findRequiredViewAsType(source, R.id.tv_id_debitur, "field 'tvIdDebitur'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivIcon = null;
    target.tvName = null;
    target.tvIdentity = null;
    target.tvVisit = null;
    target.tvStatus = null;
    target.tvIdDebitur = null;

    this.target = null;
  }
}
