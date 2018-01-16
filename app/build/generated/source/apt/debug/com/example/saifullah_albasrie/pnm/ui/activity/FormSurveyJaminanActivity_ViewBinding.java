// Generated code from Butter Knife. Do not modify!
package com.example.saifullah_albasrie.pnm.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.saifullah_albasrie.pnm.R;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormSurveyJaminanActivity_ViewBinding<T extends FormSurveyJaminanActivity> implements Unbinder {
  protected T target;

  private View view2131690033;

  private View view2131689974;

  private View view2131689983;

  private View view2131690003;

  private View view2131690051;

  private View view2131690067;

  private View view2131690082;

  private View view2131690124;

  private View view2131690101;

  @UiThread
  public FormSurveyJaminanActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvHintNoLpj = Utils.findRequiredViewAsType(source, R.id.tv_hint_no_lpj, "field 'tvHintNoLpj'", TextView.class);
    target.etNomorLpj = Utils.findRequiredViewAsType(source, R.id.et_no_lpj, "field 'etNomorLpj'", EditText.class);
    target.tvHitJenisAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_angunan, "field 'tvHitJenisAngunan'", TextView.class);
    target.spJenisAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_angunan, "field 'spJenisAngunan'", Spinner.class);
    target.tvHintStatusKepemilikan = Utils.findRequiredViewAsType(source, R.id.tv_hint_status_kepemilikan, "field 'tvHintStatusKepemilikan'", TextView.class);
    target.spStatusKepemilikan = Utils.findRequiredViewAsType(source, R.id.spinner_status_kepemilikan, "field 'spStatusKepemilikan'", Spinner.class);
    target.tvHintHubunganPemohon = Utils.findRequiredViewAsType(source, R.id.tv_hint_hubungan_pemohon, "field 'tvHintHubunganPemohon'", TextView.class);
    target.spHubunganPemohon = Utils.findRequiredViewAsType(source, R.id.spinner_hubungan_pemohon, "field 'spHubunganPemohon'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_data_pemilik, "field 'btnDataPemilik' and method 'onClickToggle'");
    target.btnDataPemilik = Utils.castView(view, R.id.btn_data_pemilik, "field 'btnDataPemilik'", ToggleButton.class);
    view2131690033 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expDataPemilik = Utils.findRequiredViewAsType(source, R.id.expandable_data_pemilik, "field 'expDataPemilik'", ExpandableLinearLayout.class);
    target.tvHintDataPemilik = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_pemilik, "field 'tvHintDataPemilik'", TextView.class);
    target.etNamaPemilik = Utils.findRequiredViewAsType(source, R.id.et_nama_pemilik, "field 'etNamaPemilik'", EditText.class);
    target.tvHintJenisBuktiKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_bukti_kepemilikan_angunan, "field 'tvHintJenisBuktiKepemilikanAngunan'", TextView.class);
    target.spJenisBuktiKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_jenis_bukti_kepemilikan_angunan, "field 'spJenisBuktiKepemilikanAngunan'", Spinner.class);
    target.tvHintBuktiKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_bukti_kepemilikan_angunan, "field 'tvHintBuktiKepemilikanAngunan'", TextView.class);
    target.spBuktiKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_bukti_kepemilikan_angunan, "field 'spBuktiKepemilikanAngunan'", Spinner.class);
    target.tvHintNoKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_no_kepemilikan_angunan, "field 'tvHintNoKepemilikanAngunan'", TextView.class);
    target.etNoKepemilikanAngunan = Utils.findRequiredViewAsType(source, R.id.et_no_kepemilikan_angunan, "field 'etNoKepemilikanAngunan'", EditText.class);
    target.tvHintLokasiDikeluarkanSuratTanah = Utils.findRequiredViewAsType(source, R.id.tv_hint_lokasi_surat_tanah, "field 'tvHintLokasiDikeluarkanSuratTanah'", TextView.class);
    target.etLokasiDikeluarkanSuratTanah = Utils.findRequiredViewAsType(source, R.id.et_lokasi_surat_tanah, "field 'etLokasiDikeluarkanSuratTanah'", EditText.class);
    target.tvHintNomorImb = Utils.findRequiredViewAsType(source, R.id.tv_hint_no_imb, "field 'tvHintNomorImb'", TextView.class);
    target.etNomorIMB = Utils.findRequiredViewAsType(source, R.id.et_no_imb, "field 'etNomorIMB'", EditText.class);
    target.spTanggalPemilikAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_tgl, "field 'spTanggalPemilikAngunan'", Spinner.class);
    target.spBulanPemilikAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_bulan, "field 'spBulanPemilikAngunan'", Spinner.class);
    target.spTahunPemilikAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_tahun, "field 'spTahunPemilikAngunan'", Spinner.class);
    target.tvHintNamaIMB = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_imb, "field 'tvHintNamaIMB'", TextView.class);
    target.etNamaIMB = Utils.findRequiredViewAsType(source, R.id.et_nama_imb, "field 'etNamaIMB'", EditText.class);
    target.tvHintPeruntukanIMB = Utils.findRequiredViewAsType(source, R.id.tv_hint_peruntukan_imb, "field 'tvHintPeruntukanIMB'", TextView.class);
    target.etPeruntukanIMB = Utils.findRequiredViewAsType(source, R.id.et_peruntukan_imb, "field 'etPeruntukanIMB'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_ajb, "field 'btnAJB' and method 'onClickToggle'");
    target.btnAJB = Utils.castView(view, R.id.btn_ajb, "field 'btnAJB'", ToggleButton.class);
    view2131689974 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expAJB = Utils.findRequiredViewAsType(source, R.id.expandable_ajb, "field 'expAJB'", ExpandableLinearLayout.class);
    target.tvHintNomorAJB = Utils.findRequiredViewAsType(source, R.id.tv_hint_no_ajb, "field 'tvHintNomorAJB'", TextView.class);
    target.etNomorAJB = Utils.findRequiredViewAsType(source, R.id.et_no_ajb, "field 'etNomorAJB'", EditText.class);
    target.spTanggalAJB = Utils.findRequiredViewAsType(source, R.id.spinner_tgl_ajb, "field 'spTanggalAJB'", Spinner.class);
    target.spBulanAJB = Utils.findRequiredViewAsType(source, R.id.spinner_bulan_ajb, "field 'spBulanAJB'", Spinner.class);
    target.spTahunAJB = Utils.findRequiredViewAsType(source, R.id.spinner_tahun_ajb, "field 'spTahunAJB'", Spinner.class);
    target.tvHintKeluaranAJB = Utils.findRequiredViewAsType(source, R.id.tv_hint_keluaran_ajb, "field 'tvHintKeluaranAJB'", TextView.class);
    target.etKeluaranAJB = Utils.findRequiredViewAsType(source, R.id.et_keluaran_ajb, "field 'etKeluaranAJB'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_alamat_angunan, "field 'btnAlamatAngunan' and method 'onClickToggle'");
    target.btnAlamatAngunan = Utils.castView(view, R.id.btn_alamat_angunan, "field 'btnAlamatAngunan'", ToggleButton.class);
    view2131689983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.expandable_alamat_angunan, "field 'expAlamatAngunan'", ExpandableLinearLayout.class);
    target.tvHintAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_alamat_angunan, "field 'tvHintAlamatAngunan'", TextView.class);
    target.etAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.et_alamat_angunan, "field 'etAlamatAngunan'", EditText.class);
    target.tvHintRt = Utils.findRequiredViewAsType(source, R.id.tv_hint_rt, "field 'tvHintRt'", TextView.class);
    target.etRT = Utils.findRequiredViewAsType(source, R.id.et_rt, "field 'etRT'", EditText.class);
    target.tHintRw = Utils.findRequiredViewAsType(source, R.id.tv_hint_rw, "field 'tHintRw'", TextView.class);
    target.etRW = Utils.findRequiredViewAsType(source, R.id.et_rw, "field 'etRW'", EditText.class);
    target.tvHintProvinsiAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_provinsi_alamat_angunan, "field 'tvHintProvinsiAlamatAngunan'", TextView.class);
    target.spProvinsiAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_provinsi_alamat_angunan, "field 'spProvinsiAlamatAngunan'", Spinner.class);
    target.tvHintKotaAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_kota_alamat_angunan, "field 'tvHintKotaAlamatAngunan'", TextView.class);
    target.spKotaAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_kota_alamat_angunan, "field 'spKotaAlamatAngunan'", Spinner.class);
    target.tvHintKelurahanAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_kelurahan_alamat_angunan, "field 'tvHintKelurahanAlamatAngunan'", TextView.class);
    target.spKelurahanAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_kelurahan_alamat_angunan, "field 'spKelurahanAlamatAngunan'", Spinner.class);
    target.tvHintKecamatanAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_kecamatan_alamat_angunan, "field 'tvHintKecamatanAlamatAngunan'", TextView.class);
    target.spKecamatanAlamatAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_kecamatan_alamat_angunan, "field 'spKecamatanAlamatAngunan'", Spinner.class);
    target.tvHintKodePos = Utils.findRequiredViewAsType(source, R.id.tv_hint_kdoe_pos, "field 'tvHintKodePos'", TextView.class);
    target.etKodePos = Utils.findRequiredViewAsType(source, R.id.et_kode_pos, "field 'etKodePos'", EditText.class);
    target.tvHintPeruntukanLokasi = Utils.findRequiredViewAsType(source, R.id.tv_hint_peruntukan_lokasi, "field 'tvHintPeruntukanLokasi'", TextView.class);
    target.spPeruntukanLokasi = Utils.findRequiredViewAsType(source, R.id.spinner_peruntukan_lokasi, "field 'spPeruntukanLokasi'", Spinner.class);
    target.tvHintJalanYangDilalui = Utils.findRequiredViewAsType(source, R.id.tv_hint_jalan, "field 'tvHintJalanYangDilalui'", TextView.class);
    target.spJalanYangDilalui = Utils.findRequiredViewAsType(source, R.id.spinner_jalan, "field 'spJalanYangDilalui'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_bentuk_tanah, "field 'btnBentukTanah' and method 'onClickToggle'");
    target.btnBentukTanah = Utils.castView(view, R.id.btn_bentuk_tanah, "field 'btnBentukTanah'", ToggleButton.class);
    view2131690003 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expBentukTanah = Utils.findRequiredViewAsType(source, R.id.expandable_bentuk_tanah, "field 'expBentukTanah'", ExpandableLinearLayout.class);
    target.tvHintLuasTanah = Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_tanah, "field 'tvHintLuasTanah'", TextView.class);
    target.etLuasTanah = Utils.findRequiredViewAsType(source, R.id.et_luas_tanah, "field 'etLuasTanah'", EditText.class);
    target.tvHintKondisiTanah = Utils.findRequiredViewAsType(source, R.id.tv_hint_kondisi_tanah, "field 'tvHintKondisiTanah'", TextView.class);
    target.spKondisiTanah = Utils.findRequiredViewAsType(source, R.id.spinner_kondisi_tanah, "field 'spKondisiTanah'", Spinner.class);
    target.tvHintPenggunaanTanah = Utils.findRequiredViewAsType(source, R.id.tv_hint_penggunaan_tanah, "field 'tvHintPenggunaanTanah'", TextView.class);
    target.spPenggunaanTanah = Utils.findRequiredViewAsType(source, R.id.spinner_penggunaan_tanah, "field 'spPenggunaanTanah'", Spinner.class);
    target.tvHintBahayaBanjir = Utils.findRequiredViewAsType(source, R.id.tv_hint_bahaya_banjir, "field 'tvHintBahayaBanjir'", TextView.class);
    target.spBanjir = Utils.findRequiredViewAsType(source, R.id.spinner_banjir, "field 'spBanjir'", Spinner.class);
    target.tvHintBatasUtara = Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_utara, "field 'tvHintBatasUtara'", TextView.class);
    target.spBatasUtara = Utils.findRequiredViewAsType(source, R.id.spinner_batas_utara, "field 'spBatasUtara'", Spinner.class);
    target.tvHintBatasSelatan = Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_selatan, "field 'tvHintBatasSelatan'", TextView.class);
    target.spBatasSelatan = Utils.findRequiredViewAsType(source, R.id.spinner_batas_selatan, "field 'spBatasSelatan'", Spinner.class);
    target.tvHintBatasTimur = Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_timur, "field 'tvHintBatasTimur'", TextView.class);
    target.spBatasTimur = Utils.findRequiredViewAsType(source, R.id.spinner_batas_timur, "field 'spBatasTimur'", Spinner.class);
    target.tvHintBatasBarat = Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_barat, "field 'tvHintBatasBarat'", TextView.class);
    target.spBatasBarat = Utils.findRequiredViewAsType(source, R.id.spinner_batas_barat, "field 'spBatasBarat'", Spinner.class);
    target.tvHintStatusTanah = Utils.findRequiredViewAsType(source, R.id.tv_hint_status_tanah, "field 'tvHintStatusTanah'", TextView.class);
    target.spStatusTanah = Utils.findRequiredViewAsType(source, R.id.spinner_status_tanah, "field 'spStatusTanah'", Spinner.class);
    target.tvHintDasarPenghunian = Utils.findRequiredViewAsType(source, R.id.tv_hint_dasar_penghunian, "field 'tvHintDasarPenghunian'", TextView.class);
    target.etDasarPenghunian = Utils.findRequiredViewAsType(source, R.id.et_dasar_penghunian, "field 'etDasarPenghunian'", EditText.class);
    target.tvHintBiayaSewa = Utils.findRequiredViewAsType(source, R.id.tv_hint_biaya_sewa, "field 'tvHintBiayaSewa'", TextView.class);
    target.etBiayaSewa = Utils.findRequiredViewAsType(source, R.id.et_biaya_sewa, "field 'etBiayaSewa'", EditText.class);
    target.tvHintPenghuniAngunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_penghuni_angunan, "field 'tvHintPenghuniAngunan'", TextView.class);
    target.spPenghuniAngunan = Utils.findRequiredViewAsType(source, R.id.spinner_penghuni_angunan, "field 'spPenghuniAngunan'", Spinner.class);
    target.tvHintJangkaWaktuSewa = Utils.findRequiredViewAsType(source, R.id.tv_hint_jangka_waktu_sewa, "field 'tvHintJangkaWaktuSewa'", TextView.class);
    target.spJangkaWaktuSewa = Utils.findRequiredViewAsType(source, R.id.spinner_jangka_waktu_sewa, "field 'spJangkaWaktuSewa'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_fasilitas, "field 'btnFasilitas' and method 'onClickToggle'");
    target.btnFasilitas = Utils.castView(view, R.id.btn_fasilitas, "field 'btnFasilitas'", ToggleButton.class);
    view2131690051 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expFasilitas = Utils.findRequiredViewAsType(source, R.id.expandable_fasilitas, "field 'expFasilitas'", ExpandableLinearLayout.class);
    target.tvHintKapastitasListrik = Utils.findRequiredViewAsType(source, R.id.tv_hint_kapasitas_listrik, "field 'tvHintKapastitasListrik'", TextView.class);
    target.etKapasitasListrik = Utils.findRequiredViewAsType(source, R.id.et_kapasitas_listrik, "field 'etKapasitasListrik'", EditText.class);
    target.tvHintSaluranTelepon = Utils.findRequiredViewAsType(source, R.id.tv_hint_saluran_telepon, "field 'tvHintSaluranTelepon'", TextView.class);
    target.spSaluranTelepon = Utils.findRequiredViewAsType(source, R.id.spinner_saluran_telepon, "field 'spSaluranTelepon'", Spinner.class);
    target.tvHintTelepon1 = Utils.findRequiredViewAsType(source, R.id.tv_hint_telepon_1, "field 'tvHintTelepon1'", TextView.class);
    target.etTelepon1 = Utils.findRequiredViewAsType(source, R.id.et_telepon_1, "field 'etTelepon1'", EditText.class);
    target.tvHintSaluranAir = Utils.findRequiredViewAsType(source, R.id.tv_hint_saluran_air, "field 'tvHintSaluranAir'", TextView.class);
    target.spSaluranAir = Utils.findRequiredViewAsType(source, R.id.spinner_saluran_air, "field 'spSaluranAir'", Spinner.class);
    target.tvHintAngkutanUmum = Utils.findRequiredViewAsType(source, R.id.tv_hint_angkutan_umum, "field 'tvHintAngkutanUmum'", TextView.class);
    target.spAngkutanUmum = Utils.findRequiredViewAsType(source, R.id.spinner_angkutan_umum, "field 'spAngkutanUmum'", Spinner.class);
    target.tvHintTersediaSekolah = Utils.findRequiredViewAsType(source, R.id.tv_hint_sedia_sekolah, "field 'tvHintTersediaSekolah'", TextView.class);
    target.spTersediaSekolah = Utils.findRequiredViewAsType(source, R.id.spinner_sedia_sekolah, "field 'spTersediaSekolah'", Spinner.class);
    target.tvHintTersediaRumahSakit = Utils.findRequiredViewAsType(source, R.id.tv_hint_sedia_rumah_sakit, "field 'tvHintTersediaRumahSakit'", TextView.class);
    target.spTersediaRumahSakit = Utils.findRequiredViewAsType(source, R.id.spinner_sedia_rumah_sakit, "field 'spTersediaRumahSakit'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_keadaan_bangunan, "field 'btnKeadaanBangunan' and method 'onClickToggle'");
    target.btnKeadaanBangunan = Utils.castView(view, R.id.btn_keadaan_bangunan, "field 'btnKeadaanBangunan'", ToggleButton.class);
    view2131690067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expKeadaanBangunan = Utils.findRequiredViewAsType(source, R.id.expandable_keadaan_bangunan, "field 'expKeadaanBangunan'", ExpandableLinearLayout.class);
    target.tvHintTahunDidirikanBangunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun_bangunan, "field 'tvHintTahunDidirikanBangunan'", TextView.class);
    target.spTahunDidirikanBangunan = Utils.findRequiredViewAsType(source, R.id.spinner_tahun_bangunan, "field 'spTahunDidirikanBangunan'", Spinner.class);
    target.tvHintTahunRenovasi = Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun_renovasi, "field 'tvHintTahunRenovasi'", TextView.class);
    target.spTahunRenovasi = Utils.findRequiredViewAsType(source, R.id.spinner_tahun_renovasi, "field 'spTahunRenovasi'", Spinner.class);
    target.tvHintLuasBangunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_bangunan, "field 'tvHintLuasBangunan'", TextView.class);
    target.etLuasBangunan = Utils.findRequiredViewAsType(source, R.id.et_luas_bangunan, "field 'etLuasBangunan'", EditText.class);
    target.tvHintLuasTanahKeadaanBangunan = Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_tanah_keadaan_bangunan, "field 'tvHintLuasTanahKeadaanBangunan'", TextView.class);
    target.etLuasTanahKeadaanBangunan = Utils.findRequiredViewAsType(source, R.id.et_luas_tanah_keadaan_bangunan, "field 'etLuasTanahKeadaanBangunan'", EditText.class);
    target.tvHintLebarJalan = Utils.findRequiredViewAsType(source, R.id.tv_hint_lebar_jalan, "field 'tvHintLebarJalan'", TextView.class);
    target.etLebarjalan = Utils.findRequiredViewAsType(source, R.id.et_lebar_jalan, "field 'etLebarjalan'", EditText.class);
    target.spJalanAkses = Utils.findRequiredViewAsType(source, R.id.spinner_jalan_akses, "field 'spJalanAkses'", Spinner.class);
    target.spBentukTanah = Utils.findRequiredViewAsType(source, R.id.spinner_bentuk_tanah, "field 'spBentukTanah'", Spinner.class);
    target.spBentukTanahBangunan = Utils.findRequiredViewAsType(source, R.id.spinner_bentuk_tanah_bangunan, "field 'spBentukTanahBangunan'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_konstruksi_bangunan, "field 'btnKonstruksiBangunan' and method 'onClickToggle'");
    target.btnKonstruksiBangunan = Utils.castView(view, R.id.btn_konstruksi_bangunan, "field 'btnKonstruksiBangunan'", ToggleButton.class);
    view2131690082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expKonstruksiBangunan = Utils.findRequiredViewAsType(source, R.id.expandable_konstruksi_bangunan, "field 'expKonstruksiBangunan'", ExpandableLinearLayout.class);
    target.tvHintPondasi = Utils.findRequiredViewAsType(source, R.id.tv_hint_pondasi, "field 'tvHintPondasi'", TextView.class);
    target.spPondasi = Utils.findRequiredViewAsType(source, R.id.spinner_pondasi, "field 'spPondasi'", Spinner.class);
    target.tvHintLantai = Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai, "field 'tvHintLantai'", TextView.class);
    target.spLantai = Utils.findRequiredViewAsType(source, R.id.spinner_lantai, "field 'spLantai'", Spinner.class);
    target.tvHintDinding = Utils.findRequiredViewAsType(source, R.id.tv_hint_dinding, "field 'tvHintDinding'", TextView.class);
    target.spDinding = Utils.findRequiredViewAsType(source, R.id.spinner_dinding, "field 'spDinding'", Spinner.class);
    target.tvHintPlafon = Utils.findRequiredViewAsType(source, R.id.tv_hint_plafon, "field 'tvHintPlafon'", TextView.class);
    target.spPlafon = Utils.findRequiredViewAsType(source, R.id.spinner_plafon, "field 'spPlafon'", Spinner.class);
    target.tvHintKusen = Utils.findRequiredViewAsType(source, R.id.tv_hint_kusen, "field 'tvHintKusen'", TextView.class);
    target.spKusen = Utils.findRequiredViewAsType(source, R.id.spinner_kusen, "field 'spKusen'", Spinner.class);
    target.tvHintAtap = Utils.findRequiredViewAsType(source, R.id.tv_hint_atap, "field 'tvHintAtap'", TextView.class);
    target.spAtap = Utils.findRequiredViewAsType(source, R.id.spinner_atap, "field 'spAtap'", Spinner.class);
    target.tvHintPintu = Utils.findRequiredViewAsType(source, R.id.tv_hint_pintu, "field 'tvHintPintu'", TextView.class);
    target.spPintu = Utils.findRequiredViewAsType(source, R.id.spinner_pintu, "field 'spPintu'", Spinner.class);
    target.tvHintJendela = Utils.findRequiredViewAsType(source, R.id.tv_hint_jendela, "field 'tvHintJendela'", TextView.class);
    target.spJendela = Utils.findRequiredViewAsType(source, R.id.spinner_jendela, "field 'spJendela'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_tata_ruang, "field 'btnTataRuang' and method 'onClickToggle'");
    target.btnTataRuang = Utils.castView(view, R.id.btn_tata_ruang, "field 'btnTataRuang'", ToggleButton.class);
    view2131690124 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expTataRuang = Utils.findRequiredViewAsType(source, R.id.expandable_tata_ruang, "field 'expTataRuang'", ExpandableLinearLayout.class);
    target.tvHintLantai1 = Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_1, "field 'tvHintLantai1'", TextView.class);
    target.etLantai1 = Utils.findRequiredViewAsType(source, R.id.et_lantai_1, "field 'etLantai1'", EditText.class);
    target.tvHintLantai2 = Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_2, "field 'tvHintLantai2'", TextView.class);
    target.etLantai2 = Utils.findRequiredViewAsType(source, R.id.et_lantai_2, "field 'etLantai2'", EditText.class);
    target.tvHintLantai3 = Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_3, "field 'tvHintLantai3'", TextView.class);
    target.etLantai3 = Utils.findRequiredViewAsType(source, R.id.et_lantai_3, "field 'etLantai3'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_penilaian, "field 'btnPenilaian' and method 'onClickToggle'");
    target.btnPenilaian = Utils.castView(view, R.id.btn_penilaian, "field 'btnPenilaian'", ToggleButton.class);
    view2131690101 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickToggle(p0);
      }
    });
    target.expPenilaian = Utils.findRequiredViewAsType(source, R.id.expandable_penilaian, "field 'expPenilaian'", ExpandableLinearLayout.class);
    target.tvHintStatusPenilaian = Utils.findRequiredViewAsType(source, R.id.tv_hint_status_penilaian, "field 'tvHintStatusPenilaian'", TextView.class);
    target.etStatusPenilaian = Utils.findRequiredViewAsType(source, R.id.et_status_penilaian, "field 'etStatusPenilaian'", EditText.class);
    target.spTanggalPenilaian = Utils.findRequiredViewAsType(source, R.id.spinner_tgl_penilaian, "field 'spTanggalPenilaian'", Spinner.class);
    target.spBulanPenilaian = Utils.findRequiredViewAsType(source, R.id.spinner_bulan_penilain, "field 'spBulanPenilaian'", Spinner.class);
    target.spTahunPenilaian = Utils.findRequiredViewAsType(source, R.id.spinner_tahun_penilaian, "field 'spTahunPenilaian'", Spinner.class);
    target.tvHintNamaPenilai = Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_penilai, "field 'tvHintNamaPenilai'", TextView.class);
    target.etNamaPenilai = Utils.findRequiredViewAsType(source, R.id.et_nama_penilai, "field 'etNamaPenilai'", EditText.class);
    target.tvHintJabatan = Utils.findRequiredViewAsType(source, R.id.tv_hint_jabatan, "field 'tvHintJabatan'", TextView.class);
    target.etJabatan = Utils.findRequiredViewAsType(source, R.id.et_jabatan, "field 'etJabatan'", EditText.class);
    target.tvHintNilaiPasar1 = Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_1, "field 'tvHintNilaiPasar1'", TextView.class);
    target.etNilaiPasar1 = Utils.findRequiredViewAsType(source, R.id.et_nilai_pasar_1, "field 'etNilaiPasar1'", EditText.class);
    target.tvHintNilaiPasar2 = Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_2, "field 'tvHintNilaiPasar2'", TextView.class);
    target.etNilaiPasar2 = Utils.findRequiredViewAsType(source, R.id.et_nilai_pasar_2, "field 'etNilaiPasar2'", EditText.class);
    target.tvHintNilaiPasar3 = Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_3, "field 'tvHintNilaiPasar3'", TextView.class);
    target.etNilaiPasar3 = Utils.findRequiredViewAsType(source, R.id.et_nilai_pasar_3, "field 'etNilaiPasar3'", EditText.class);
    target.tvHintNilaiPasar = Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar, "field 'tvHintNilaiPasar'", TextView.class);
    target.etNilaiPasar = Utils.findRequiredViewAsType(source, R.id.et_nilai_pasar, "field 'etNilaiPasar'", EditText.class);
    target.tvHintProsentasiLikuidasi = Utils.findRequiredViewAsType(source, R.id.tv_hint_prosentasi_likuidasi, "field 'tvHintProsentasiLikuidasi'", TextView.class);
    target.etProsentasiLikuidasi = Utils.findRequiredViewAsType(source, R.id.et_prosentasi_likuidasi, "field 'etProsentasiLikuidasi'", EditText.class);
    target.tvHintNilaiLikuidasi = Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_likuidasi, "field 'tvHintNilaiLikuidasi'", TextView.class);
    target.etNilaiLikuidasi = Utils.findRequiredViewAsType(source, R.id.et_nilai_likuidasi, "field 'etNilaiLikuidasi'", EditText.class);
    target.etExum = Utils.findRequiredViewAsType(source, R.id.et_exum, "field 'etExum'", EditText.class);
    target.mandatoryHintViews = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.tv_hint_no_lpj, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_status_kepemilikan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_hubungan_pemohon, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_pemilik, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jenis_bukti_kepemilikan_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_bukti_kepemilikan_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_no_kepemilikan_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lokasi_surat_tanah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_no_imb, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_imb, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_peruntukan_imb, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_no_ajb, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_keluaran_ajb, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_alamat_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_rt, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_rw, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_provinsi_alamat_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kota_alamat_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kelurahan_alamat_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kecamatan_alamat_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kdoe_pos, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_peruntukan_lokasi, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jalan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_tanah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kondisi_tanah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_penggunaan_tanah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_bahaya_banjir, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_utara, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_selatan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_timur, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_batas_barat, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_status_tanah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_dasar_penghunian, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_biaya_sewa, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_penghuni_angunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jangka_waktu_sewa, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kapasitas_listrik, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_saluran_telepon, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_telepon_1, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_saluran_air, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_angkutan_umum, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_sedia_sekolah, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_sedia_rumah_sakit, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun_bangunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_tahun_renovasi, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_bangunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_luas_tanah_keadaan_bangunan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lebar_jalan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_pondasi, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_dinding, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_plafon, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_kusen, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_atap, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_pintu, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jendela, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_1, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_2, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_lantai_3, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_status_penilaian, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nama_penilai, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_jabatan, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_1, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_2, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar_3, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_pasar, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_prosentasi_likuidasi, "field 'mandatoryHintViews'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.tv_hint_nilai_likuidasi, "field 'mandatoryHintViews'", TextView.class));
    target.expandableLinearLayouts = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.expandable_data_pemilik, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_ajb, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_alamat_angunan, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_bentuk_tanah, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_fasilitas, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_keadaan_bangunan, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_konstruksi_bangunan, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_tata_ruang, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class), 
        Utils.findRequiredViewAsType(source, R.id.expandable_penilaian, "field 'expandableLinearLayouts'", ExpandableLinearLayout.class));
    target.toggleButtonList = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.btn_data_pemilik, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_ajb, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_alamat_angunan, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_bentuk_tanah, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_fasilitas, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_keadaan_bangunan, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_konstruksi_bangunan, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_tata_ruang, "field 'toggleButtonList'", ToggleButton.class), 
        Utils.findRequiredViewAsType(source, R.id.btn_penilaian, "field 'toggleButtonList'", ToggleButton.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvHintNoLpj = null;
    target.etNomorLpj = null;
    target.tvHitJenisAngunan = null;
    target.spJenisAngunan = null;
    target.tvHintStatusKepemilikan = null;
    target.spStatusKepemilikan = null;
    target.tvHintHubunganPemohon = null;
    target.spHubunganPemohon = null;
    target.btnDataPemilik = null;
    target.expDataPemilik = null;
    target.tvHintDataPemilik = null;
    target.etNamaPemilik = null;
    target.tvHintJenisBuktiKepemilikanAngunan = null;
    target.spJenisBuktiKepemilikanAngunan = null;
    target.tvHintBuktiKepemilikanAngunan = null;
    target.spBuktiKepemilikanAngunan = null;
    target.tvHintNoKepemilikanAngunan = null;
    target.etNoKepemilikanAngunan = null;
    target.tvHintLokasiDikeluarkanSuratTanah = null;
    target.etLokasiDikeluarkanSuratTanah = null;
    target.tvHintNomorImb = null;
    target.etNomorIMB = null;
    target.spTanggalPemilikAngunan = null;
    target.spBulanPemilikAngunan = null;
    target.spTahunPemilikAngunan = null;
    target.tvHintNamaIMB = null;
    target.etNamaIMB = null;
    target.tvHintPeruntukanIMB = null;
    target.etPeruntukanIMB = null;
    target.btnAJB = null;
    target.expAJB = null;
    target.tvHintNomorAJB = null;
    target.etNomorAJB = null;
    target.spTanggalAJB = null;
    target.spBulanAJB = null;
    target.spTahunAJB = null;
    target.tvHintKeluaranAJB = null;
    target.etKeluaranAJB = null;
    target.btnAlamatAngunan = null;
    target.expAlamatAngunan = null;
    target.tvHintAlamatAngunan = null;
    target.etAlamatAngunan = null;
    target.tvHintRt = null;
    target.etRT = null;
    target.tHintRw = null;
    target.etRW = null;
    target.tvHintProvinsiAlamatAngunan = null;
    target.spProvinsiAlamatAngunan = null;
    target.tvHintKotaAlamatAngunan = null;
    target.spKotaAlamatAngunan = null;
    target.tvHintKelurahanAlamatAngunan = null;
    target.spKelurahanAlamatAngunan = null;
    target.tvHintKecamatanAlamatAngunan = null;
    target.spKecamatanAlamatAngunan = null;
    target.tvHintKodePos = null;
    target.etKodePos = null;
    target.tvHintPeruntukanLokasi = null;
    target.spPeruntukanLokasi = null;
    target.tvHintJalanYangDilalui = null;
    target.spJalanYangDilalui = null;
    target.btnBentukTanah = null;
    target.expBentukTanah = null;
    target.tvHintLuasTanah = null;
    target.etLuasTanah = null;
    target.tvHintKondisiTanah = null;
    target.spKondisiTanah = null;
    target.tvHintPenggunaanTanah = null;
    target.spPenggunaanTanah = null;
    target.tvHintBahayaBanjir = null;
    target.spBanjir = null;
    target.tvHintBatasUtara = null;
    target.spBatasUtara = null;
    target.tvHintBatasSelatan = null;
    target.spBatasSelatan = null;
    target.tvHintBatasTimur = null;
    target.spBatasTimur = null;
    target.tvHintBatasBarat = null;
    target.spBatasBarat = null;
    target.tvHintStatusTanah = null;
    target.spStatusTanah = null;
    target.tvHintDasarPenghunian = null;
    target.etDasarPenghunian = null;
    target.tvHintBiayaSewa = null;
    target.etBiayaSewa = null;
    target.tvHintPenghuniAngunan = null;
    target.spPenghuniAngunan = null;
    target.tvHintJangkaWaktuSewa = null;
    target.spJangkaWaktuSewa = null;
    target.btnFasilitas = null;
    target.expFasilitas = null;
    target.tvHintKapastitasListrik = null;
    target.etKapasitasListrik = null;
    target.tvHintSaluranTelepon = null;
    target.spSaluranTelepon = null;
    target.tvHintTelepon1 = null;
    target.etTelepon1 = null;
    target.tvHintSaluranAir = null;
    target.spSaluranAir = null;
    target.tvHintAngkutanUmum = null;
    target.spAngkutanUmum = null;
    target.tvHintTersediaSekolah = null;
    target.spTersediaSekolah = null;
    target.tvHintTersediaRumahSakit = null;
    target.spTersediaRumahSakit = null;
    target.btnKeadaanBangunan = null;
    target.expKeadaanBangunan = null;
    target.tvHintTahunDidirikanBangunan = null;
    target.spTahunDidirikanBangunan = null;
    target.tvHintTahunRenovasi = null;
    target.spTahunRenovasi = null;
    target.tvHintLuasBangunan = null;
    target.etLuasBangunan = null;
    target.tvHintLuasTanahKeadaanBangunan = null;
    target.etLuasTanahKeadaanBangunan = null;
    target.tvHintLebarJalan = null;
    target.etLebarjalan = null;
    target.spJalanAkses = null;
    target.spBentukTanah = null;
    target.spBentukTanahBangunan = null;
    target.btnKonstruksiBangunan = null;
    target.expKonstruksiBangunan = null;
    target.tvHintPondasi = null;
    target.spPondasi = null;
    target.tvHintLantai = null;
    target.spLantai = null;
    target.tvHintDinding = null;
    target.spDinding = null;
    target.tvHintPlafon = null;
    target.spPlafon = null;
    target.tvHintKusen = null;
    target.spKusen = null;
    target.tvHintAtap = null;
    target.spAtap = null;
    target.tvHintPintu = null;
    target.spPintu = null;
    target.tvHintJendela = null;
    target.spJendela = null;
    target.btnTataRuang = null;
    target.expTataRuang = null;
    target.tvHintLantai1 = null;
    target.etLantai1 = null;
    target.tvHintLantai2 = null;
    target.etLantai2 = null;
    target.tvHintLantai3 = null;
    target.etLantai3 = null;
    target.btnPenilaian = null;
    target.expPenilaian = null;
    target.tvHintStatusPenilaian = null;
    target.etStatusPenilaian = null;
    target.spTanggalPenilaian = null;
    target.spBulanPenilaian = null;
    target.spTahunPenilaian = null;
    target.tvHintNamaPenilai = null;
    target.etNamaPenilai = null;
    target.tvHintJabatan = null;
    target.etJabatan = null;
    target.tvHintNilaiPasar1 = null;
    target.etNilaiPasar1 = null;
    target.tvHintNilaiPasar2 = null;
    target.etNilaiPasar2 = null;
    target.tvHintNilaiPasar3 = null;
    target.etNilaiPasar3 = null;
    target.tvHintNilaiPasar = null;
    target.etNilaiPasar = null;
    target.tvHintProsentasiLikuidasi = null;
    target.etProsentasiLikuidasi = null;
    target.tvHintNilaiLikuidasi = null;
    target.etNilaiLikuidasi = null;
    target.etExum = null;
    target.mandatoryHintViews = null;
    target.expandableLinearLayouts = null;
    target.toggleButtonList = null;

    view2131690033.setOnClickListener(null);
    view2131690033 = null;
    view2131689974.setOnClickListener(null);
    view2131689974 = null;
    view2131689983.setOnClickListener(null);
    view2131689983 = null;
    view2131690003.setOnClickListener(null);
    view2131690003 = null;
    view2131690051.setOnClickListener(null);
    view2131690051 = null;
    view2131690067.setOnClickListener(null);
    view2131690067 = null;
    view2131690082.setOnClickListener(null);
    view2131690082 = null;
    view2131690124.setOnClickListener(null);
    view2131690124 = null;
    view2131690101.setOnClickListener(null);
    view2131690101 = null;

    this.target = null;
  }
}
