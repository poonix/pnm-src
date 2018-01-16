// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyJenisUsahaActivity_ViewBinding<T extends FormSurveyJenisUsahaActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FormSurveyJenisUsahaActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.scrollViewMain = Utils.findRequiredViewAsType(source, R.id.sv_form_jenis_usaha, "field 'scrollViewMain'", ScrollView.class);
    target.spBidangUsahaDebitur = Utils.findRequiredViewAsType(source, R.id.spinner_bidang_usaha_debitur, "field 'spBidangUsahaDebitur'", Spinner.class);
    target.spJenisProduk = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_produk, "field 'spJenisProduk'", Spinner.class);
    target.spKegiatanTempatUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_kegiatan_tempat_usaha, "field 'spKegiatanTempatUsaha'", Spinner.class);
    target.tvJumlahTenagaKerja = Utils.findRequiredViewAsType(source, R.id.tv_jumlah_tenaga_kerja, "field 'tvJumlahTenagaKerja'", EditText.class);
    target.spSuratKetUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_surat_keterangan_usaha, "field 'spSuratKetUsaha'", Spinner.class);
    target.spBahanBaku = Utils.findRequiredViewAsType(source, R.id.spinner_bahan_baku, "field 'spBahanBaku'", Spinner.class);
    target.spJumlahPemasok = Utils.findRequiredViewAsType(source, R.id.spinner_jumlah_pemasok, "field 'spJumlahPemasok'", Spinner.class);
    target.spPersainganUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_persaingan_usaha, "field 'spPersainganUsaha'", Spinner.class);
    target.spKondisiUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_kondisi_usaha, "field 'spKondisiUsaha'", Spinner.class);
    target.spPengelolaanKeuangan = Utils.findRequiredViewAsType(source, R.id.spinner_pengelolaan_keuangan, "field 'spPengelolaanKeuangan'", Spinner.class);
    target.tvLokasiUsaha = Utils.findRequiredViewAsType(source, R.id.tv_lokasi_usaha, "field 'tvLokasiUsaha'", EditText.class);
    target.spPengelolaanUsaha = Utils.findRequiredViewAsType(source, R.id.spinner_pengelolaan_usaha, "field 'spPengelolaanUsaha'", Spinner.class);
    target.tvAspekPemasaran = Utils.findRequiredViewAsType(source, R.id.tv_aspek_pemasaran, "field 'tvAspekPemasaran'", EditText.class);
    target.tvExum = Utils.findRequiredViewAsType(source, R.id.tv_exum, "field 'tvExum'", EditText.class);
    target.ll_btn_search = Utils.findRequiredViewAsType(source, R.id.ll_btn_search, "field 'll_btn_search'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.scrollViewMain = null;
    target.spBidangUsahaDebitur = null;
    target.spJenisProduk = null;
    target.spKegiatanTempatUsaha = null;
    target.tvJumlahTenagaKerja = null;
    target.spSuratKetUsaha = null;
    target.spBahanBaku = null;
    target.spJumlahPemasok = null;
    target.spPersainganUsaha = null;
    target.spKondisiUsaha = null;
    target.spPengelolaanKeuangan = null;
    target.tvLokasiUsaha = null;
    target.spPengelolaanUsaha = null;
    target.tvAspekPemasaran = null;
    target.tvExum = null;
    target.ll_btn_search = null;

    this.target = null;
  }
}
