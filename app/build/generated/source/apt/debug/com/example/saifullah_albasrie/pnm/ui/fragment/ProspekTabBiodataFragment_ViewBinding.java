// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabBiodataFragment_ViewBinding<T extends ProspekTabBiodataFragment> implements Unbinder {
  protected T target;

  private View view2131689807;

  @UiThread
  public ProspekTabBiodataFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.vCheckDebiturLayout = Utils.findRequiredView(source, R.id.include_search_debitur, "field 'vCheckDebiturLayout'");
    target.spJenisProspek = Utils.findRequiredViewAsType(source, R.id.sp_jenis_prospek, "field 'spJenisProspek'", Spinner.class);
    target.tvHintJenisProspek = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_prospek, "field 'tvHintJenisProspek'", TextView.class);
    target.tvHintNamaPanggilan = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_panggilan, "field 'tvHintNamaPanggilan'", TextView.class);
    target.tvNickname = Utils.findRequiredViewAsType(source, R.id.tv_nickname, "field 'tvNickname'", EditText.class);
    target.tvHintNamaLengkap = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_lengkap, "field 'tvHintNamaLengkap'", TextView.class);
    target.tvFullname = Utils.findRequiredViewAsType(source, R.id.tv_fullname, "field 'tvFullname'", EditText.class);
    target.tvHintJenisAlamat = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_alamat, "field 'tvHintJenisAlamat'", TextView.class);
    target.spJenisAlamat = Utils.findRequiredViewAsType(source, R.id.sp_jenis_alamat, "field 'spJenisAlamat'", Spinner.class);
    target.tvHintAlamat = Utils.findRequiredViewAsType(source, R.id.tv_hint_alamat, "field 'tvHintAlamat'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvAddress'", EditText.class);
    target.tvHintJenisKelamin = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_kelamin, "field 'tvHintJenisKelamin'", TextView.class);
    target.spGender = Utils.findRequiredViewAsType(source, R.id.spinner_gender, "field 'spGender'", Spinner.class);
    target.tvHintJenisIdentitas = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_identitas, "field 'tvHintJenisIdentitas'", TextView.class);
    target.spIdType = Utils.findRequiredViewAsType(source, R.id.spinner_id, "field 'spIdType'", Spinner.class);
    target.tvHintNomorTelp = Utils.findRequiredViewAsType(source, R.id.tv_hint_nomor_telp, "field 'tvHintNomorTelp'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", EditText.class);
    target.tvHintNomorIdentitas = Utils.findRequiredViewAsType(source, R.id.tv_hint_nomor_identitas, "field 'tvHintNomorIdentitas'", TextView.class);
    target.tvIdentityNumber = Utils.findRequiredViewAsType(source, R.id.tv_identity_number, "field 'tvIdentityNumber'", EditText.class);
    target.tvHintMasaBerlaku = Utils.findRequiredViewAsType(source, R.id.tv_hint_masa_berlaku, "field 'tvHintMasaBerlaku'", TextView.class);
    target.tvMasaBerlaku = Utils.findRequiredViewAsType(source, R.id.tv_masa_berlaku, "field 'tvMasaBerlaku'", TextView.class);
    target.vPickerDate = Utils.findRequiredView(source, R.id.picker_date, "field 'vPickerDate'");
    target.tvHintNamaIbuKandung = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_ibu_kandung, "field 'tvHintNamaIbuKandung'", TextView.class);
    target.tvMotherName = Utils.findRequiredViewAsType(source, R.id.tv_mother_name, "field 'tvMotherName'", EditText.class);
    target.cbSeumurHidup = Utils.findRequiredViewAsType(source, R.id.cb_seumur_hidup, "field 'cbSeumurHidup'", CheckBox.class);
    target.tvHintTempatLahir = Utils.findRequiredViewAsType(source, R.id.tv_hint_tempat_lahir, "field 'tvHintTempatLahir'", TextView.class);
    target.tvTempatLahir = Utils.findRequiredViewAsType(source, R.id.tv_tempat_lahir, "field 'tvTempatLahir'", EditText.class);
    target.tvHintTanggal = Utils.findRequiredViewAsType(source, R.id.tv_hint_tanggal, "field 'tvHintTanggal'", TextView.class);
    target.spinnerTanggal = Utils.findRequiredViewAsType(source, R.id.spinner_tgl, "field 'spinnerTanggal'", Spinner.class);
    target.tvHintBulan = Utils.findRequiredViewAsType(source, R.id.tv_hint_bulan, "field 'tvHintBulan'", TextView.class);
    target.spinnerBulan = Utils.findRequiredViewAsType(source, R.id.spinner_bulan, "field 'spinnerBulan'", Spinner.class);
    target.tvHintTahun = Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun, "field 'tvHintTahun'", TextView.class);
    target.spinnerTahun = Utils.findRequiredViewAsType(source, R.id.spinner_tahun, "field 'spinnerTahun'", Spinner.class);
    target.tvHintJenisUsaha = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_usaha, "field 'tvHintJenisUsaha'", TextView.class);
    target.spJenisUsaha = Utils.findRequiredViewAsType(source, R.id.sp_jenis_usaha, "field 'spJenisUsaha'", Spinner.class);
    target.spSearchDebitur = Utils.findRequiredViewAsType(source, R.id.sp_search_debitur, "field 'spSearchDebitur'", Spinner.class);
    target.btnSearchDebitur = Utils.findRequiredView(source, R.id.iv_search_debitur, "field 'btnSearchDebitur'");
    view = Utils.findRequiredView(source, R.id.btn_check_idi, "field 'btnCekIDI' and method 'onClickCheckIDI'");
    target.btnCekIDI = Utils.castView(view, R.id.btn_check_idi, "field 'btnCekIDI'", Button.class);
    view2131689807 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickCheckIDI();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.vCheckDebiturLayout = null;
    target.spJenisProspek = null;
    target.tvHintJenisProspek = null;
    target.tvHintNamaPanggilan = null;
    target.tvNickname = null;
    target.tvHintNamaLengkap = null;
    target.tvFullname = null;
    target.tvHintJenisAlamat = null;
    target.spJenisAlamat = null;
    target.tvHintAlamat = null;
    target.tvAddress = null;
    target.tvHintJenisKelamin = null;
    target.spGender = null;
    target.tvHintJenisIdentitas = null;
    target.spIdType = null;
    target.tvHintNomorTelp = null;
    target.tvPhone = null;
    target.tvHintNomorIdentitas = null;
    target.tvIdentityNumber = null;
    target.tvHintMasaBerlaku = null;
    target.tvMasaBerlaku = null;
    target.vPickerDate = null;
    target.tvHintNamaIbuKandung = null;
    target.tvMotherName = null;
    target.cbSeumurHidup = null;
    target.tvHintTempatLahir = null;
    target.tvTempatLahir = null;
    target.tvHintTanggal = null;
    target.spinnerTanggal = null;
    target.tvHintBulan = null;
    target.spinnerBulan = null;
    target.tvHintTahun = null;
    target.spinnerTahun = null;
    target.tvHintJenisUsaha = null;
    target.spJenisUsaha = null;
    target.spSearchDebitur = null;
    target.btnSearchDebitur = null;
    target.btnCekIDI = null;

    view2131689807.setOnClickListener(null);
    view2131689807 = null;

    this.target = null;
  }
}
