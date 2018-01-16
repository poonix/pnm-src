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

public class CollectionTabLainnyaFragment_ViewBinding<T extends CollectionTabLainnyaFragment> implements Unbinder {
  protected T target;

  @UiThread
  public CollectionTabLainnyaFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tvAngsuranTotal = Utils.findRequiredViewAsType(source, R.id.tv_angsuran_total, "field 'tvAngsuranTotal'", EditText.class);
    target.tvKodeGolongan = Utils.findRequiredViewAsType(source, R.id.tv_kode_golongan, "field 'tvKodeGolongan'", EditText.class);
    target.tvSaldoDCA = Utils.findRequiredViewAsType(source, R.id.tv_saldo_dca, "field 'tvSaldoDCA'", EditText.class);
    target.tvAngsuranKe = Utils.findRequiredViewAsType(source, R.id.tv_angsuran_ke, "field 'tvAngsuranKe'", EditText.class);
    target.tvJumlahTunggakanHari = Utils.findRequiredViewAsType(source, R.id.tv_jml_tunggakan_hari, "field 'tvJumlahTunggakanHari'", EditText.class);
    target.tvTunggakanPokok = Utils.findRequiredViewAsType(source, R.id.tv_tunggakan_pokok, "field 'tvTunggakanPokok'", EditText.class);
    target.tvTunggakanBunga = Utils.findRequiredViewAsType(source, R.id.tv_tunggakan_bunga, "field 'tvTunggakanBunga'", EditText.class);
    target.tvTunggakanDenda = Utils.findRequiredViewAsType(source, R.id.tv_tunggakan_denda, "field 'tvTunggakanDenda'", EditText.class);
    target.tvTotalTagihan = Utils.findRequiredViewAsType(source, R.id.tv_total_tagihan, "field 'tvTotalTagihan'", EditText.class);
    target.hintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_angsuran_total, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kode_golongan, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_saldo_dca, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_angsuran_ke, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jml_tunggakan_hari, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tunggakan_pokok, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tunggakan_bunga, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tunggakan_denda, "field 'hintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_total_tagihan, "field 'hintViews'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvAngsuranTotal = null;
    target.tvKodeGolongan = null;
    target.tvSaldoDCA = null;
    target.tvAngsuranKe = null;
    target.tvJumlahTunggakanHari = null;
    target.tvTunggakanPokok = null;
    target.tvTunggakanBunga = null;
    target.tvTunggakanDenda = null;
    target.tvTotalTagihan = null;
    target.hintViews = null;

    this.target = null;
  }
}
