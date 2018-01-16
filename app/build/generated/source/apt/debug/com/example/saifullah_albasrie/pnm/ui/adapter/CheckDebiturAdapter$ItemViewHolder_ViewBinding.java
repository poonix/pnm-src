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

public class CheckDebiturAdapter$ItemViewHolder_ViewBinding<T extends CheckDebiturAdapter.ItemViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public CheckDebiturAdapter$ItemViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tvNama = Utils.findRequiredViewAsType(source, R.id.tv_nama, "field 'tvNama'", TextView.class);
    target.tvID = Utils.findRequiredViewAsType(source, R.id.tv_id, "field 'tvID'", TextView.class);
    target.tvTanggalLahir = Utils.findRequiredViewAsType(source, R.id.tv_tanggal_lahir, "field 'tvTanggalLahir'", TextView.class);
    target.tvIbuKandung = Utils.findRequiredViewAsType(source, R.id.tv_ibu_kandung, "field 'tvIbuKandung'", TextView.class);
    target.tvTelp = Utils.findRequiredViewAsType(source, R.id.tv_telp, "field 'tvTelp'", TextView.class);
    target.tvUnit = Utils.findRequiredViewAsType(source, R.id.tv_unit, "field 'tvUnit'", TextView.class);
    target.tvCabang = Utils.findRequiredViewAsType(source, R.id.tv_cabang, "field 'tvCabang'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvNama = null;
    target.tvID = null;
    target.tvTanggalLahir = null;
    target.tvIbuKandung = null;
    target.tvTelp = null;
    target.tvUnit = null;
    target.tvCabang = null;

    this.target = null;
  }
}
