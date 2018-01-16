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

public class FormSurveyKeuanganActivity_ViewBinding<T extends FormSurveyKeuanganActivity> implements Unbinder {
  protected T target;

  private View view2131689759;

  @UiThread
  public FormSurveyKeuanganActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvPendapatan = Utils.findRequiredViewAsType(source, R.id.tv_pendapatan, "field 'tvPendapatan'", EditText.class);
    target.tvHargaPokok = Utils.findRequiredViewAsType(source, R.id.tv_harga_pokok, "field 'tvHargaPokok'", EditText.class);
    target.tvUpahTenaga = Utils.findRequiredViewAsType(source, R.id.tv_upah_tenaga, "field 'tvUpahTenaga'", EditText.class);
    target.tvSewaTempat = Utils.findRequiredViewAsType(source, R.id.tv_sewa_tempat, "field 'tvSewaTempat'", EditText.class);
    target.tvSewaLainnya = Utils.findRequiredViewAsType(source, R.id.tv_sewa_lainnya, "field 'tvSewaLainnya'", EditText.class);
    target.tvBiayaListrik = Utils.findRequiredViewAsType(source, R.id.tv_biaya_listrik, "field 'tvBiayaListrik'", EditText.class);
    target.tvBiayaLainnya = Utils.findRequiredViewAsType(source, R.id.tv_biaya_lainnya, "field 'tvBiayaLainnya'", EditText.class);
    target.tvPendapatanLain1 = Utils.findRequiredViewAsType(source, R.id.tv_pendapatan_usaha_lain_1, "field 'tvPendapatanLain1'", EditText.class);
    target.tvPendapatanLain2 = Utils.findRequiredViewAsType(source, R.id.tv_pendapatan_usaha_lain_2, "field 'tvPendapatanLain2'", EditText.class);
    target.tvGajiDebitur = Utils.findRequiredViewAsType(source, R.id.tv_gaji_debitur, "field 'tvGajiDebitur'", EditText.class);
    target.tvGajiPasangan = Utils.findRequiredViewAsType(source, R.id.tv_gaji_pasangan, "field 'tvGajiPasangan'", EditText.class);
    target.tvBiayaOrangtua = Utils.findRequiredViewAsType(source, R.id.tv_biaya_orangtua, "field 'tvBiayaOrangtua'", EditText.class);
    target.tvBiayaAnak = Utils.findRequiredViewAsType(source, R.id.tv_biaya_anak, "field 'tvBiayaAnak'", EditText.class);
    target.tvBiayaTanggunganLain = Utils.findRequiredViewAsType(source, R.id.tv_biaya_tanggungan_lain, "field 'tvBiayaTanggunganLain'", EditText.class);
    target.spAdaUsahaLain = Utils.findRequiredViewAsType(source, R.id.spinner_other_business, "field 'spAdaUsahaLain'", Spinner.class);
    target.spUsahaLian = Utils.findRequiredViewAsType(source, R.id.spinner_mentioned_of_business, "field 'spUsahaLian'", Spinner.class);
    target.spAdaPendapatanLain = Utils.findRequiredViewAsType(source, R.id.spinner_other_salary_income, "field 'spAdaPendapatanLain'", Spinner.class);
    target.tvExum = Utils.findRequiredViewAsType(source, R.id.tv_executive_summary, "field 'tvExum'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'vButtonTambah'");
    target.vButtonTambah = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTambahDataPinjaman();
      }
    });
    target.vContainerDataPinjaman = Utils.findRequiredViewAsType(source, R.id.ll_container_data_pinjaman, "field 'vContainerDataPinjaman'", LinearLayout.class);
    target.tvTotalBiaya = Utils.findRequiredViewAsType(source, R.id.tv_total_biaya, "field 'tvTotalBiaya'", EditText.class);
    target.tvTotalKeuntungan = Utils.findRequiredViewAsType(source, R.id.tv_total_keuntungan, "field 'tvTotalKeuntungan'", EditText.class);
    target.tvTotalPenghasilanBersihUsahaLain = Utils.findRequiredViewAsType(source, R.id.tv_total_penghasilan_bersih_lain, "field 'tvTotalPenghasilanBersihUsahaLain'", EditText.class);
    target.tvTotalGaji = Utils.findRequiredViewAsType(source, R.id.tv_total_gaji, "field 'tvTotalGaji'", EditText.class);
    target.tvTotalPenghasilan = Utils.findRequiredViewAsType(source, R.id.tv_total_penghasilan, "field 'tvTotalPenghasilan'", EditText.class);
    target.tvTotalBiayaRT = Utils.findRequiredViewAsType(source, R.id.tv_total_biaya_rt, "field 'tvTotalBiayaRT'", EditText.class);
    target.tvSisaPenghasilan = Utils.findRequiredViewAsType(source, R.id.tv_sisa_penghasilan, "field 'tvSisaPenghasilan'", EditText.class);
    target.tvPenghasilanBersih = Utils.findRequiredViewAsType(source, R.id.tv_penghasilan_bersih, "field 'tvPenghasilanBersih'", EditText.class);
    target.tvTotalAngsuranSaatIni = Utils.findRequiredViewAsType(source, R.id.tv_total_angsuran, "field 'tvTotalAngsuranSaatIni'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvPendapatan = null;
    target.tvHargaPokok = null;
    target.tvUpahTenaga = null;
    target.tvSewaTempat = null;
    target.tvSewaLainnya = null;
    target.tvBiayaListrik = null;
    target.tvBiayaLainnya = null;
    target.tvPendapatanLain1 = null;
    target.tvPendapatanLain2 = null;
    target.tvGajiDebitur = null;
    target.tvGajiPasangan = null;
    target.tvBiayaOrangtua = null;
    target.tvBiayaAnak = null;
    target.tvBiayaTanggunganLain = null;
    target.spAdaUsahaLain = null;
    target.spUsahaLian = null;
    target.spAdaPendapatanLain = null;
    target.tvExum = null;
    target.vButtonTambah = null;
    target.vContainerDataPinjaman = null;
    target.tvTotalBiaya = null;
    target.tvTotalKeuntungan = null;
    target.tvTotalPenghasilanBersihUsahaLain = null;
    target.tvTotalGaji = null;
    target.tvTotalPenghasilan = null;
    target.tvTotalBiayaRT = null;
    target.tvSisaPenghasilan = null;
    target.tvPenghasilanBersih = null;
    target.tvTotalAngsuranSaatIni = null;

    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
