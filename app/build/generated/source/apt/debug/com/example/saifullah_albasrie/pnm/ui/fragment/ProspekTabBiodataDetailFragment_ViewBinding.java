// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProspekTabBiodataDetailFragment_ViewBinding<T extends ProspekTabBiodataDetailFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ProspekTabBiodataDetailFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.vDummyFocus = Utils.findRequiredView(source, R.id.v_dummy_focus, "field 'vDummyFocus'");
    target.spJenisProspek = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_prospek, "field 'spJenisProspek'", Spinner.class);
    target.tvNickname = Utils.findRequiredViewAsType(source, R.id.tv_nickname, "field 'tvNickname'", EditText.class);
    target.tvFullname = Utils.findRequiredViewAsType(source, R.id.tv_fullname, "field 'tvFullname'", EditText.class);
    target.spGender = Utils.findRequiredViewAsType(source, R.id.spinner_gender, "field 'spGender'", Spinner.class);
    target.spIdType = Utils.findRequiredViewAsType(source, R.id.spinner_id, "field 'spIdType'", Spinner.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", EditText.class);
    target.tvIdentityNumber = Utils.findRequiredViewAsType(source, R.id.tv_identity_number, "field 'tvIdentityNumber'", EditText.class);
    target.tvMasaBerlaku = Utils.findRequiredViewAsType(source, R.id.tv_masa_berlaku, "field 'tvMasaBerlaku'", TextView.class);
    target.vPickerDate = Utils.findRequiredView(source, R.id.picker_date, "field 'vPickerDate'");
    target.tvMotherName = Utils.findRequiredViewAsType(source, R.id.tv_mother_name, "field 'tvMotherName'", EditText.class);
    target.cbSeumurHidup = Utils.findRequiredViewAsType(source, R.id.cb_seumur_hidup, "field 'cbSeumurHidup'", CheckBox.class);
    target.tvTempatLahir = Utils.findRequiredViewAsType(source, R.id.tv_tempat_lahir, "field 'tvTempatLahir'", EditText.class);
    target.spinnerTanggal = Utils.findRequiredViewAsType(source, R.id.spinner_tgl, "field 'spinnerTanggal'", Spinner.class);
    target.spinnerBulan = Utils.findRequiredViewAsType(source, R.id.spinner_bulan, "field 'spinnerBulan'", Spinner.class);
    target.spinnerTahun = Utils.findRequiredViewAsType(source, R.id.spinner_tahun, "field 'spinnerTahun'", Spinner.class);
    target.tvNPWP = Utils.findRequiredViewAsType(source, R.id.tv_npwp, "field 'tvNPWP'", EditText.class);
    target.tvEmail = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'tvEmail'", EditText.class);
    target.tvKewarganegaraan = Utils.findRequiredViewAsType(source, R.id.tv_kewarganegaraan, "field 'tvKewarganegaraan'", EditText.class);
    target.spGelar = Utils.findRequiredViewAsType(source, R.id.spinner_gelar, "field 'spGelar'", Spinner.class);
    target.spPendidikanTerakhir = Utils.findRequiredViewAsType(source, R.id.spinner_pendidikan_terakhir, "field 'spPendidikanTerakhir'", Spinner.class);
    target.tvSuku = Utils.findRequiredViewAsType(source, R.id.tv_suku, "field 'tvSuku'", EditText.class);
    target.tvKeteranganPekerjaan = Utils.findRequiredViewAsType(source, R.id.tv_keterangan_pekerjaan, "field 'tvKeteranganPekerjaan'", EditText.class);
    target.tvNomorKK = Utils.findRequiredViewAsType(source, R.id.tv_nomor_kk, "field 'tvNomorKK'", EditText.class);
    target.tvIdMarketing = Utils.findRequiredViewAsType(source, R.id.tv_id_marketing, "field 'tvIdMarketing'", EditText.class);
    target.tvNamaMarketing = Utils.findRequiredViewAsType(source, R.id.tv_nama_marketing, "field 'tvNamaMarketing'", EditText.class);
    target.spAgama = Utils.findRequiredViewAsType(source, R.id.spinner_agama, "field 'spAgama'", Spinner.class);
    target.spPekerjaan = Utils.findRequiredViewAsType(source, R.id.spinner_pekerjaan, "field 'spPekerjaan'", Spinner.class);
    target.spStatusKawin = Utils.findRequiredViewAsType(source, R.id.spinner_status, "field 'spStatusKawin'", Spinner.class);
    target.vJumlahAnak = Utils.findRequiredView(source, R.id.layout_jumlah_anak, "field 'vJumlahAnak'");
    target.spJumlahAnak = Utils.findRequiredViewAsType(source, R.id.spinner_jumlah_anak, "field 'spJumlahAnak'", Spinner.class);
    target.addHp = Utils.findRequiredViewAsType(source, R.id.add_hp, "field 'addHp'", ImageView.class);
    target.viewHp = Utils.findRequiredViewAsType(source, R.id.view_hp, "field 'viewHp'", LinearLayout.class);
    target.viewAddHp = Utils.findRequiredViewAsType(source, R.id.view_add_hp, "field 'viewAddHp'", LinearLayout.class);
    target.sparatorHp = Utils.findRequiredViewAsType(source, R.id.v_phone_sparator, "field 'sparatorHp'", LinearLayout.class);
    target.mandatoryHintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_prospek, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_panggilan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_fullname, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_identitas, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_identity_number, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_kelamin, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tempat_lahir, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tanggal, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_bulan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_pendidikan_terakhir, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_ibu, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kewarganegaraan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_agama, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nomor_kk, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_status_pernikahan, "field 'mandatoryHintViews'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.vDummyFocus = null;
    target.spJenisProspek = null;
    target.tvNickname = null;
    target.tvFullname = null;
    target.spGender = null;
    target.spIdType = null;
    target.tvPhone = null;
    target.tvIdentityNumber = null;
    target.tvMasaBerlaku = null;
    target.vPickerDate = null;
    target.tvMotherName = null;
    target.cbSeumurHidup = null;
    target.tvTempatLahir = null;
    target.spinnerTanggal = null;
    target.spinnerBulan = null;
    target.spinnerTahun = null;
    target.tvNPWP = null;
    target.tvEmail = null;
    target.tvKewarganegaraan = null;
    target.spGelar = null;
    target.spPendidikanTerakhir = null;
    target.tvSuku = null;
    target.tvKeteranganPekerjaan = null;
    target.tvNomorKK = null;
    target.tvIdMarketing = null;
    target.tvNamaMarketing = null;
    target.spAgama = null;
    target.spPekerjaan = null;
    target.spStatusKawin = null;
    target.vJumlahAnak = null;
    target.spJumlahAnak = null;
    target.addHp = null;
    target.viewHp = null;
    target.viewAddHp = null;
    target.sparatorHp = null;
    target.mandatoryHintViews = null;

    this.target = null;
  }
}
