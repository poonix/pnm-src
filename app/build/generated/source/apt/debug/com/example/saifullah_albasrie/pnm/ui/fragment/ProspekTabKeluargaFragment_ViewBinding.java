// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabKeluargaFragment_ViewBinding<T extends ProspekTabKeluargaFragment> implements Unbinder {
  protected T target;

  private View view2131689747;

  @UiThread
  public ProspekTabKeluargaFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.spStatusHub = Utils.findRequiredViewAsType(source, R.id.spinner_status_hub, "field 'spStatusHub'", Spinner.class);
    target.tvFullname = Utils.findRequiredViewAsType(source, R.id.tv_fullname, "field 'tvFullname'", EditText.class);
    target.spGender = Utils.findRequiredViewAsType(source, R.id.spinner_gender, "field 'spGender'", Spinner.class);
    target.spIdType = Utils.findRequiredViewAsType(source, R.id.spinner_id, "field 'spIdType'", Spinner.class);
    target.tvIdentityNumber = Utils.findRequiredViewAsType(source, R.id.tv_identity_number, "field 'tvIdentityNumber'", EditText.class);
    target.tvMasaBerlaku = Utils.findRequiredViewAsType(source, R.id.tv_masa_berlaku, "field 'tvMasaBerlaku'", TextView.class);
    target.cbSeumurHidup = Utils.findRequiredViewAsType(source, R.id.cb_seumur_hidup, "field 'cbSeumurHidup'", CheckBox.class);
    view = Utils.findRequiredView(source, R.id.picker_date, "field 'ivPickerDate'");
    target.ivPickerDate = Utils.castView(view, R.id.picker_date, "field 'ivPickerDate'", ImageView.class);
    view2131689747 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tvTempatLahir = Utils.findRequiredViewAsType(source, R.id.tv_tempat_lahir, "field 'tvTempatLahir'", EditText.class);
    target.spinnerTanggal = Utils.findRequiredViewAsType(source, R.id.spinner_tgl, "field 'spinnerTanggal'", Spinner.class);
    target.spinnerBulan = Utils.findRequiredViewAsType(source, R.id.spinner_bulan, "field 'spinnerBulan'", Spinner.class);
    target.spinnerTahun = Utils.findRequiredViewAsType(source, R.id.spinner_tahun, "field 'spinnerTahun'", Spinner.class);
    target.tvPhoneNumber = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhoneNumber'", EditText.class);
    target.tvHandphoneNumber = Utils.findRequiredViewAsType(source, R.id.tv_handphone, "field 'tvHandphoneNumber'", EditText.class);
    target.spPekerjaan = Utils.findRequiredViewAsType(source, R.id.spinner_pekerjaan, "field 'spPekerjaan'", Spinner.class);
    target.tvKetPekerjaan = Utils.findRequiredViewAsType(source, R.id.tv_ket_pekerjaan, "field 'tvKetPekerjaan'", EditText.class);
    target.spPernahPinjam = Utils.findRequiredViewAsType(source, R.id.spinner_pernah_pinjam, "field 'spPernahPinjam'", Spinner.class);
    target.mandatoryHintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_status_hubungan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_fullname, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_identitas, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_identity_number, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_kelamin, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tempat_lahir, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tanggal, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_bulan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_phone, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_handphone, "field 'mandatoryHintViews'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.spStatusHub = null;
    target.tvFullname = null;
    target.spGender = null;
    target.spIdType = null;
    target.tvIdentityNumber = null;
    target.tvMasaBerlaku = null;
    target.cbSeumurHidup = null;
    target.ivPickerDate = null;
    target.tvTempatLahir = null;
    target.spinnerTanggal = null;
    target.spinnerBulan = null;
    target.spinnerTahun = null;
    target.tvPhoneNumber = null;
    target.tvHandphoneNumber = null;
    target.spPekerjaan = null;
    target.tvKetPekerjaan = null;
    target.spPernahPinjam = null;
    target.mandatoryHintViews = null;

    view2131689747.setOnClickListener(null);
    view2131689747 = null;

    this.target = null;
  }
}
