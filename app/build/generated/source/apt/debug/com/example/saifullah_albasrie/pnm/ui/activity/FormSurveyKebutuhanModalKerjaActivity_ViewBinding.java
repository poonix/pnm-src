// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyKebutuhanModalKerjaActivity_ViewBinding<T extends FormSurveyKebutuhanModalKerjaActivity> implements Unbinder {
  protected T target;

  private View view2131689747;

  private View view2131689759;

  @UiThread
  public FormSurveyKebutuhanModalKerjaActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_posisi_akhir_bulan, "field 'tvDate'", TextView.class);
    view = Utils.findRequiredView(source, R.id.picker_date, "field 'ivPickerDate' and method 'onCLick'");
    target.ivPickerDate = view;
    view2131689747 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCLick(p0);
      }
    });
    target.tvPersediaanDagang = Utils.findRequiredViewAsType(source, R.id.tv_persediaan_dagang, "field 'tvPersediaanDagang'", EditText.class);
    target.tvPersediaanLainnya = Utils.findRequiredViewAsType(source, R.id.tv_persediaan_lainnya, "field 'tvPersediaanLainnya'", EditText.class);
    target.tvPersediaanTotal = Utils.findRequiredViewAsType(source, R.id.tv_total_persediaan_dagang, "field 'tvPersediaanTotal'", EditText.class);
    target.tvPiutangDagang = Utils.findRequiredViewAsType(source, R.id.tv_piutang_dagang, "field 'tvPiutangDagang'", EditText.class);
    target.tvPiutangLain = Utils.findRequiredViewAsType(source, R.id.tv_piutang_lainnya, "field 'tvPiutangLain'", EditText.class);
    target.tvPiutangDagangTotal = Utils.findRequiredViewAsType(source, R.id.tv_total_piutang_dagang, "field 'tvPiutangDagangTotal'", EditText.class);
    target.tvHutangDagang = Utils.findRequiredViewAsType(source, R.id.tv_hutang_dagang, "field 'tvHutangDagang'", EditText.class);
    target.tvHutangLain = Utils.findRequiredViewAsType(source, R.id.tv_hutang_lainnya, "field 'tvHutangLain'", EditText.class);
    target.tvHutangDagangTotal = Utils.findRequiredViewAsType(source, R.id.tv_total_hutang_dagang, "field 'tvHutangDagangTotal'", EditText.class);
    target.tvModalKerja = Utils.findRequiredViewAsType(source, R.id.tv_modal_kerja, "field 'tvModalKerja'", EditText.class);
    target.tvInvestasi = Utils.findRequiredViewAsType(source, R.id.tv_investasi, "field 'tvInvestasi'", EditText.class);
    target.tvTrendKeuangan = Utils.findRequiredViewAsType(source, R.id.tv_trend_keuangan, "field 'tvTrendKeuangan'", EditText.class);
    target.tvPendapatanTahunLalu = Utils.findRequiredViewAsType(source, R.id.tv_pendapatan_tahun_lalu, "field 'tvPendapatanTahunLalu'", EditText.class);
    target.tvPenghasilanTahunLalu = Utils.findRequiredViewAsType(source, R.id.tv_penghasilan_tahun_lalu, "field 'tvPenghasilanTahunLalu'", EditText.class);
    target.tvModalTahunLalu = Utils.findRequiredViewAsType(source, R.id.tv_modal_tahun_lallu, "field 'tvModalTahunLalu'", EditText.class);
    target.tvExumPersediaan = Utils.findRequiredViewAsType(source, R.id.tv_executive_summary_persediaan, "field 'tvExumPersediaan'", EditText.class);
    target.tvExumOmzet = Utils.findRequiredViewAsType(source, R.id.tv_executive_summary_omzet, "field 'tvExumOmzet'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ll_btn_tambah, "field 'vButtonTambah'");
    target.vButtonTambah = view;
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTambahDataAset();
      }
    });
    target.vContainerAset = Utils.findRequiredViewAsType(source, R.id.layout_asset, "field 'vContainerAset'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvDate = null;
    target.ivPickerDate = null;
    target.tvPersediaanDagang = null;
    target.tvPersediaanLainnya = null;
    target.tvPersediaanTotal = null;
    target.tvPiutangDagang = null;
    target.tvPiutangLain = null;
    target.tvPiutangDagangTotal = null;
    target.tvHutangDagang = null;
    target.tvHutangLain = null;
    target.tvHutangDagangTotal = null;
    target.tvModalKerja = null;
    target.tvInvestasi = null;
    target.tvTrendKeuangan = null;
    target.tvPendapatanTahunLalu = null;
    target.tvPenghasilanTahunLalu = null;
    target.tvModalTahunLalu = null;
    target.tvExumPersediaan = null;
    target.tvExumOmzet = null;
    target.vButtonTambah = null;
    target.vContainerAset = null;

    view2131689747.setOnClickListener(null);
    view2131689747 = null;
    view2131689759.setOnClickListener(null);
    view2131689759 = null;

    this.target = null;
  }
}
