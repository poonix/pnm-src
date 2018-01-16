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

public class RiwayatAngsuranAdapter$ItemViewHolder_ViewBinding<T extends RiwayatAngsuranAdapter.ItemViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public RiwayatAngsuranAdapter$ItemViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tvNoRekening = Utils.findRequiredViewAsType(source, R.id.tv_no_rekening, "field 'tvNoRekening'", TextView.class);
    target.tvOutstanding = Utils.findRequiredViewAsType(source, R.id.tv_outstanding, "field 'tvOutstanding'", TextView.class);
    target.tvJmlPinjaman = Utils.findRequiredViewAsType(source, R.id.tv_jml_pinjaman, "field 'tvJmlPinjaman'", TextView.class);
    target.tvJmlAngsuran = Utils.findRequiredViewAsType(source, R.id.tv_jml_angsuran, "field 'tvJmlAngsuran'", TextView.class);
    target.tvPosisiCicilan = Utils.findRequiredViewAsType(source, R.id.tv_posisi_cicilan, "field 'tvPosisiCicilan'", TextView.class);
    target.tvTglJatuhTempo = Utils.findRequiredViewAsType(source, R.id.tv_tgl_jatuh_tempo, "field 'tvTglJatuhTempo'", TextView.class);
    target.tvKolektibilitas = Utils.findRequiredViewAsType(source, R.id.tv_kolektibilitas, "field 'tvKolektibilitas'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvNoRekening = null;
    target.tvOutstanding = null;
    target.tvJmlPinjaman = null;
    target.tvJmlAngsuran = null;
    target.tvPosisiCicilan = null;
    target.tvTglJatuhTempo = null;
    target.tvKolektibilitas = null;

    this.target = null;
  }
}
