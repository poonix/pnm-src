// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyKeluargaActivity_ViewBinding<T extends FormSurveyKeluargaActivity> implements Unbinder {
  protected T target;

  private View view2131689759;

  @UiThread
  public FormSurveyKeluargaActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTanggunganIstri = Utils.findRequiredViewAsType(source, R.id.tv_tanggungan_istri, "field 'tvTanggunganIstri'", EditText.class);
    target.tvTanggunganAnak = Utils.findRequiredViewAsType(source, R.id.tv_tanggungan_anak, "field 'tvTanggunganAnak'", EditText.class);
    target.tvTanggunganLain = Utils.findRequiredViewAsType(source, R.id.tv_tanggungan_lainnya, "field 'tvTanggunganLain'", EditText.class);
    target.tvJumlahTanggungan = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_tanggungan, "field 'tvJumlahTanggungan'", EditText.class);
    target.spPasanganBekerja = Utils.findRequiredViewAsType(source, R.id.spinner_apakah_pasangan_bekerja, "field 'spPasanganBekerja'", Spinner.class);
    target.spAnakBekerja = Utils.findRequiredViewAsType(source, R.id.spinner_anak_yang_bekerja, "field 'spAnakBekerja'", Spinner.class);
    target.spOrangTuaBekerja = Utils.findRequiredViewAsType(source, R.id.spinner_orang_tua_bekerja, "field 'spOrangTuaBekerja'", Spinner.class);
    target.spPernahPinjam = Utils.findRequiredViewAsType(source, R.id.spinner_pernah_pinjam, "field 'spPernahPinjam'", Spinner.class);
    target.vContainerDataKeluarga = Utils.findRequiredViewAsType(source, R.id.ll_container_data_keluarga, "field 'vContainerDataKeluarga'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'btnTambah'");
    target.btnTambah = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTambahKeluarga();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTanggunganIstri = null;
    target.tvTanggunganAnak = null;
    target.tvTanggunganLain = null;
    target.tvJumlahTanggungan = null;
    target.spPasanganBekerja = null;
    target.spAnakBekerja = null;
    target.spOrangTuaBekerja = null;
    target.spPernahPinjam = null;
    target.vContainerDataKeluarga = null;
    target.btnTambah = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
