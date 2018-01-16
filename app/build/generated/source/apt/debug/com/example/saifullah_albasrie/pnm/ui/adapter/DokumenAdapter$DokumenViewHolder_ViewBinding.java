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

public class DokumenAdapter$DokumenViewHolder_ViewBinding<T extends DokumenAdapter.DokumenViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public DokumenAdapter$DokumenViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mContainer = Utils.findRequiredView(source, R.id.ll_content, "field 'mContainer'");
    target.ivImage = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'ivImage'", ImageView.class);
    target.tvKeterangan = Utils.findRequiredViewAsType(source, R.id.tv_keterangan, "field 'tvKeterangan'", TextView.class);
    target.ivDelete = Utils.findRequiredViewAsType(source, R.id.iv_delete, "field 'ivDelete'", ImageView.class);
    target.ivEdit = Utils.findRequiredViewAsType(source, R.id.iv_edit, "field 'ivEdit'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mContainer = null;
    target.ivImage = null;
    target.tvKeterangan = null;
    target.ivDelete = null;
    target.ivEdit = null;

    this.target = null;
  }
}
