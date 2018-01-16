package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.AlamatCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyJaminanCallback;
import com.example.saifullah_albasrie.pnm.controller.AlamatController;
import com.example.saifullah_albasrie.pnm.controller.SurveyJaminanController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJaminanModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisAgunanModel;
import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.example.saifullah_albasrie.pnm.model.master.KelurahanModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BuktiKepemilikanAgunanModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JenisBuktiKepemilikanModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aldhiramdan on 4/3/17.
 */

public class FormSurveyJaminanActivity extends BaseFormActivity implements SurveyJaminanCallback{

    private static final String BUNDLE_ID_JAMINAN = "ID_JAMINAN";
    private final String LOG_TAG = FormSurveyJaminanActivity.class.getSimpleName();

    private ProspekListItemModel mDataModel;
    private int idJaminan;
    private SurveyJaminanModel jaminanModel;

    private SurveyJaminanController controller;

    private UserModel userModel;

    //main form jaminan
    //@BindView(R.id.tv_hint_nama_angunan)
    //TextView tvHintNamaAngunan;
    //@BindView(R.id.et_nama_angunan)
    //EditText etNamaAngunan;
    @BindView(R.id.tv_hint_no_lpj)
    TextView tvHintNoLpj;
    @BindView(R.id.et_no_lpj)
    EditText etNomorLpj;
    @BindView(R.id.tv_hint_jenis_angunan)
    TextView tvHitJenisAngunan;
    @BindView(R.id.spinner_jenis_angunan)
    Spinner spJenisAngunan;
    @BindView(R.id.tv_hint_status_kepemilikan)
    TextView tvHintStatusKepemilikan;
    @BindView(R.id.spinner_status_kepemilikan)
    Spinner spStatusKepemilikan;
    @BindView(R.id.tv_hint_hubungan_pemohon)
    TextView tvHintHubunganPemohon;
    @BindView(R.id.spinner_hubungan_pemohon)
    Spinner spHubunganPemohon;

    //data pemilik jaminan
    @BindView(R.id.btn_data_pemilik)
    ToggleButton btnDataPemilik;
    @BindView(R.id.expandable_data_pemilik)
    ExpandableLinearLayout expDataPemilik;
    @BindView(R.id.tv_hint_nama_pemilik)
    TextView tvHintDataPemilik;
    @BindView(R.id.et_nama_pemilik)
    EditText etNamaPemilik;
    @BindView(R.id.tv_hint_jenis_bukti_kepemilikan_angunan)
    TextView tvHintJenisBuktiKepemilikanAngunan;
    @BindView(R.id.spinner_jenis_bukti_kepemilikan_angunan)
    Spinner spJenisBuktiKepemilikanAngunan;
    @BindView(R.id.tv_hint_bukti_kepemilikan_angunan)
    TextView tvHintBuktiKepemilikanAngunan;
    @BindView(R.id.spinner_bukti_kepemilikan_angunan)
    Spinner spBuktiKepemilikanAngunan;
    @BindView(R.id.tv_hint_no_kepemilikan_angunan)
    TextView tvHintNoKepemilikanAngunan;
    @BindView(R.id.et_no_kepemilikan_angunan)
    EditText etNoKepemilikanAngunan;
    @BindView(R.id.tv_hint_lokasi_surat_tanah)
    TextView tvHintLokasiDikeluarkanSuratTanah;
    @BindView(R.id.et_lokasi_surat_tanah)
    EditText etLokasiDikeluarkanSuratTanah;
    @BindView(R.id.tv_hint_no_imb)
    TextView tvHintNomorImb;
    @BindView(R.id.et_no_imb)
    EditText etNomorIMB;
    @BindView(R.id.spinner_tgl)
    Spinner spTanggalPemilikAngunan;
    @BindView(R.id.spinner_bulan)
    Spinner spBulanPemilikAngunan;
    @BindView(R.id.spinner_tahun)
    Spinner spTahunPemilikAngunan;
    @BindView(R.id.tv_hint_nama_imb)
    TextView tvHintNamaIMB;
    @BindView(R.id.et_nama_imb)
    EditText etNamaIMB;
    @BindView(R.id.tv_hint_peruntukan_imb)
    TextView tvHintPeruntukanIMB;
    @BindView(R.id.et_peruntukan_imb)
    EditText etPeruntukanIMB;

    // ajb
    @BindView(R.id.btn_ajb)
    ToggleButton btnAJB;
    @BindView(R.id.expandable_ajb)
    ExpandableLinearLayout expAJB;
    @BindView(R.id.tv_hint_no_ajb)
    TextView tvHintNomorAJB;
    @BindView(R.id.et_no_ajb)
    EditText etNomorAJB;
    @BindView(R.id.spinner_tgl_ajb)
    Spinner spTanggalAJB;
    @BindView(R.id.spinner_bulan_ajb)
    Spinner spBulanAJB;
    @BindView(R.id.spinner_tahun_ajb)
    Spinner spTahunAJB;
    @BindView(R.id.tv_hint_keluaran_ajb)
    TextView tvHintKeluaranAJB;
    @BindView(R.id.et_keluaran_ajb)
    EditText etKeluaranAJB;

    // alamat angunan
    @BindView(R.id.btn_alamat_angunan)
    ToggleButton btnAlamatAngunan;
    @BindView(R.id.expandable_alamat_angunan)
    ExpandableLinearLayout expAlamatAngunan;
    @BindView(R.id.tv_hint_alamat_angunan)
    TextView tvHintAlamatAngunan;
    @BindView(R.id.et_alamat_angunan)
    EditText etAlamatAngunan;
    @BindView(R.id.tv_hint_rt)
    TextView tvHintRt;
    @BindView(R.id.et_rt)
    EditText etRT;
    @BindView(R.id.tv_hint_rw)
    TextView tHintRw;
    @BindView(R.id.et_rw)
    EditText etRW;
    @BindView(R.id.tv_hint_provinsi_alamat_angunan)
    TextView tvHintProvinsiAlamatAngunan;
    @BindView(R.id.spinner_provinsi_alamat_angunan)
    Spinner spProvinsiAlamatAngunan;
    @BindView(R.id.tv_hint_kota_alamat_angunan)
    TextView tvHintKotaAlamatAngunan;
    @BindView(R.id.spinner_kota_alamat_angunan)
    Spinner spKotaAlamatAngunan;
    @BindView(R.id.tv_hint_kelurahan_alamat_angunan)
    TextView tvHintKelurahanAlamatAngunan;
    @BindView(R.id.spinner_kelurahan_alamat_angunan)
    Spinner spKelurahanAlamatAngunan;
    @BindView(R.id.tv_hint_kecamatan_alamat_angunan)
    TextView tvHintKecamatanAlamatAngunan;
    @BindView(R.id.spinner_kecamatan_alamat_angunan)
    Spinner spKecamatanAlamatAngunan;
    @BindView(R.id.tv_hint_kdoe_pos)
    TextView tvHintKodePos;
    @BindView(R.id.et_kode_pos)
    EditText etKodePos;
    @BindView(R.id.tv_hint_peruntukan_lokasi)
    TextView tvHintPeruntukanLokasi;
    @BindView(R.id.spinner_peruntukan_lokasi)
    Spinner spPeruntukanLokasi;
    @BindView(R.id.tv_hint_jalan)
    TextView tvHintJalanYangDilalui;
    @BindView(R.id.spinner_jalan)
    Spinner spJalanYangDilalui;

    // bentuk tanah
    @BindView(R.id.btn_bentuk_tanah)
    ToggleButton btnBentukTanah;
    @BindView(R.id.expandable_bentuk_tanah)
    ExpandableLinearLayout expBentukTanah;
    @BindView(R.id.tv_hint_luas_tanah)
    TextView tvHintLuasTanah;
    @BindView(R.id.et_luas_tanah)
    EditText etLuasTanah;
    @BindView(R.id.tv_hint_kondisi_tanah)
    TextView tvHintKondisiTanah;
    @BindView(R.id.spinner_kondisi_tanah)
    Spinner spKondisiTanah;
    @BindView(R.id.tv_hint_penggunaan_tanah)
    TextView tvHintPenggunaanTanah;
    @BindView(R.id.spinner_penggunaan_tanah)
    Spinner spPenggunaanTanah;
    @BindView(R.id.tv_hint_bahaya_banjir)
    TextView tvHintBahayaBanjir;
    //@BindView(R.id.et_bahaya_banjir)
    //EditText etBahayaBanjir;
    @BindView(R.id.spinner_banjir)
    Spinner spBanjir;

    @BindView(R.id.tv_hint_batas_utara)
    TextView tvHintBatasUtara;
    @BindView(R.id.spinner_batas_utara)
    Spinner spBatasUtara;
    @BindView(R.id.tv_hint_batas_selatan)
    TextView tvHintBatasSelatan;
    @BindView(R.id.spinner_batas_selatan)
    Spinner spBatasSelatan;
    @BindView(R.id.tv_hint_batas_timur)
    TextView tvHintBatasTimur;
    @BindView(R.id.spinner_batas_timur)
    Spinner spBatasTimur;
    @BindView(R.id.tv_hint_batas_barat)
    TextView tvHintBatasBarat;
    @BindView(R.id.spinner_batas_barat)
    Spinner spBatasBarat;
    @BindView(R.id.tv_hint_status_tanah)
    TextView tvHintStatusTanah;
    @BindView(R.id.spinner_status_tanah)
    Spinner spStatusTanah;
    @BindView(R.id.tv_hint_dasar_penghunian)
    TextView tvHintDasarPenghunian;
    @BindView(R.id.et_dasar_penghunian)
    EditText etDasarPenghunian;
    @BindView(R.id.tv_hint_biaya_sewa)
    TextView tvHintBiayaSewa;
    @BindView(R.id.et_biaya_sewa)
    EditText etBiayaSewa;
    @BindView(R.id.tv_hint_penghuni_angunan)
    TextView tvHintPenghuniAngunan;
    @BindView(R.id.spinner_penghuni_angunan)
    Spinner spPenghuniAngunan;
    @BindView(R.id.tv_hint_jangka_waktu_sewa)
    TextView tvHintJangkaWaktuSewa;
    @BindView(R.id.spinner_jangka_waktu_sewa)
    Spinner spJangkaWaktuSewa;

    // fasilitas
    @BindView(R.id.btn_fasilitas)
    ToggleButton btnFasilitas;
    @BindView(R.id.expandable_fasilitas)
    ExpandableLinearLayout expFasilitas;
    @BindView(R.id.tv_hint_kapasitas_listrik)
    TextView tvHintKapastitasListrik;
    @BindView(R.id.et_kapasitas_listrik)
    EditText etKapasitasListrik;
    @BindView(R.id.tv_hint_saluran_telepon)
    TextView tvHintSaluranTelepon;
    @BindView(R.id.spinner_saluran_telepon)
    Spinner spSaluranTelepon;
    @BindView(R.id.tv_hint_telepon_1)
    TextView tvHintTelepon1;
    @BindView(R.id.et_telepon_1)
    EditText etTelepon1;
    @BindView(R.id.tv_hint_saluran_air)
    TextView tvHintSaluranAir;
    @BindView(R.id.spinner_saluran_air)
    Spinner spSaluranAir;
    @BindView(R.id.tv_hint_angkutan_umum)
    TextView tvHintAngkutanUmum;
    //@BindView(R.id.et_angkutan_umum)
    //EditText etAngkutanUmum;
    @BindView(R.id.spinner_angkutan_umum)
    Spinner spAngkutanUmum;
    @BindView(R.id.tv_hint_sedia_sekolah)
    TextView tvHintTersediaSekolah;
    @BindView(R.id.spinner_sedia_sekolah)
    Spinner spTersediaSekolah;
    @BindView(R.id.tv_hint_sedia_rumah_sakit)
    TextView tvHintTersediaRumahSakit;
    @BindView(R.id.spinner_sedia_rumah_sakit)
    Spinner spTersediaRumahSakit;

    // keadaan bangunan
    @BindView(R.id.btn_keadaan_bangunan)
    ToggleButton btnKeadaanBangunan;
    @BindView(R.id.expandable_keadaan_bangunan)
    ExpandableLinearLayout expKeadaanBangunan;
    @BindView(R.id.tv_hint_tahun_bangunan)
    TextView tvHintTahunDidirikanBangunan;
    @BindView(R.id.spinner_tahun_bangunan)
    Spinner spTahunDidirikanBangunan;
    @BindView(R.id.tv_hint_tahun_renovasi)
    TextView tvHintTahunRenovasi;
    @BindView(R.id.spinner_tahun_renovasi)
    Spinner spTahunRenovasi;
    @BindView(R.id.tv_hint_luas_bangunan)
    TextView tvHintLuasBangunan;
    @BindView(R.id.et_luas_bangunan)
    EditText etLuasBangunan;
    @BindView(R.id.tv_hint_luas_tanah_keadaan_bangunan)
    TextView tvHintLuasTanahKeadaanBangunan;
    @BindView(R.id.et_luas_tanah_keadaan_bangunan)
    EditText etLuasTanahKeadaanBangunan;
    @BindView(R.id.tv_hint_lebar_jalan)
    TextView tvHintLebarJalan;
    @BindView(R.id.et_lebar_jalan)
    EditText etLebarjalan;
    @BindView(R.id.spinner_jalan_akses)
    Spinner spJalanAkses;
    @BindView(R.id.spinner_bentuk_tanah)
    Spinner spBentukTanah;
    @BindView(R.id.spinner_bentuk_tanah_bangunan)
    Spinner spBentukTanahBangunan;

    // konstruksi bangunan
    @BindView(R.id.btn_konstruksi_bangunan)
    ToggleButton btnKonstruksiBangunan;
    @BindView(R.id.expandable_konstruksi_bangunan)
    ExpandableLinearLayout expKonstruksiBangunan;
    @BindView(R.id.tv_hint_pondasi)
    TextView tvHintPondasi;
    @BindView(R.id.spinner_pondasi)
    Spinner spPondasi;
    @BindView(R.id.tv_hint_lantai)
    TextView tvHintLantai;
    @BindView(R.id.spinner_lantai)
    Spinner spLantai;
    @BindView(R.id.tv_hint_dinding)
    TextView tvHintDinding;
    @BindView(R.id.spinner_dinding)
    Spinner spDinding;
    @BindView(R.id.tv_hint_plafon)
    TextView tvHintPlafon;
    @BindView(R.id.spinner_plafon)
    Spinner spPlafon;
    @BindView(R.id.tv_hint_kusen)
    TextView tvHintKusen;
    @BindView(R.id.spinner_kusen)
    Spinner spKusen;
    @BindView(R.id.tv_hint_atap)
    TextView tvHintAtap;
    @BindView(R.id.spinner_atap)
    Spinner spAtap;
    @BindView(R.id.tv_hint_pintu)
    TextView tvHintPintu;
    @BindView(R.id.spinner_pintu)
    Spinner spPintu;
    @BindView(R.id.tv_hint_jendela)
    TextView tvHintJendela;
    @BindView(R.id.spinner_jendela)
    Spinner spJendela;

    // tata ruang
    @BindView(R.id.btn_tata_ruang)
    ToggleButton btnTataRuang;
    @BindView(R.id.expandable_tata_ruang)
    ExpandableLinearLayout expTataRuang;
    @BindView(R.id.tv_hint_lantai_1)
    TextView tvHintLantai1;
    @BindView(R.id.et_lantai_1)
    EditText etLantai1;
    @BindView(R.id.tv_hint_lantai_2)
    TextView tvHintLantai2;
    @BindView(R.id.et_lantai_2)
    EditText etLantai2;
    @BindView(R.id.tv_hint_lantai_3)
    TextView tvHintLantai3;
    @BindView(R.id.et_lantai_3)
    EditText etLantai3;

    // penilaian
    @BindView(R.id.btn_penilaian)
    ToggleButton btnPenilaian;
    @BindView(R.id.expandable_penilaian)
    ExpandableLinearLayout expPenilaian;
    @BindView(R.id.tv_hint_status_penilaian)
    TextView tvHintStatusPenilaian;
    @BindView(R.id.et_status_penilaian)
    EditText etStatusPenilaian;
    @BindView(R.id.spinner_tgl_penilaian)
    Spinner spTanggalPenilaian;
    @BindView(R.id.spinner_bulan_penilain)
    Spinner spBulanPenilaian;
    @BindView(R.id.spinner_tahun_penilaian)
    Spinner spTahunPenilaian;
    @BindView(R.id.tv_hint_nama_penilai)
    TextView tvHintNamaPenilai;
    @BindView(R.id.et_nama_penilai)
    EditText etNamaPenilai;
    @BindView(R.id.tv_hint_jabatan)
    TextView tvHintJabatan;
    @BindView(R.id.et_jabatan)
    EditText etJabatan;
    @BindView(R.id.tv_hint_nilai_pasar_1)
    TextView tvHintNilaiPasar1;
    @BindView(R.id.et_nilai_pasar_1)
    EditText etNilaiPasar1;
    @BindView(R.id.tv_hint_nilai_pasar_2)
    TextView tvHintNilaiPasar2;
    @BindView(R.id.et_nilai_pasar_2)
    EditText etNilaiPasar2;
    @BindView(R.id.tv_hint_nilai_pasar_3)
    TextView tvHintNilaiPasar3;
    @BindView(R.id.et_nilai_pasar_3)
    EditText etNilaiPasar3;
    @BindView(R.id.tv_hint_nilai_pasar)
    TextView tvHintNilaiPasar;
    @BindView(R.id.et_nilai_pasar)
    EditText etNilaiPasar;
    @BindView(R.id.tv_hint_prosentasi_likuidasi)
    TextView tvHintProsentasiLikuidasi;
    @BindView(R.id.et_prosentasi_likuidasi)
    EditText etProsentasiLikuidasi;
    @BindView(R.id.tv_hint_nilai_likuidasi)
    TextView tvHintNilaiLikuidasi;
    @BindView(R.id.et_nilai_likuidasi)
    EditText etNilaiLikuidasi;

    @BindView(R.id.et_exum)
    EditText etExum;

    @BindViews({
            //main form jaminan
            //R.id.tv_hint_nama_angunan,
            R.id.tv_hint_no_lpj,
            R.id.tv_hint_jenis_angunan,
            R.id.tv_hint_status_kepemilikan,
            R.id.tv_hint_hubungan_pemohon,

            //data pemilik jaminan
            R.id.tv_hint_nama_pemilik,
            R.id.tv_hint_jenis_bukti_kepemilikan_angunan,
            R.id.tv_hint_bukti_kepemilikan_angunan,
            R.id.tv_hint_no_kepemilikan_angunan,
            R.id.tv_hint_lokasi_surat_tanah,
            R.id.tv_hint_no_imb,
            R.id.tv_hint_nama_imb,
            R.id.tv_hint_peruntukan_imb,

            //AJB
            R.id.tv_hint_no_ajb,
            R.id.tv_hint_keluaran_ajb,

            //alamat angunan
            R.id.tv_hint_alamat_angunan,
            R.id.tv_hint_rt,
            R.id.tv_hint_rw,
            R.id.tv_hint_provinsi_alamat_angunan,
            R.id.tv_hint_kota_alamat_angunan,
            R.id.tv_hint_kelurahan_alamat_angunan,
            R.id.tv_hint_kecamatan_alamat_angunan,
            R.id.tv_hint_kdoe_pos,
            R.id.tv_hint_peruntukan_lokasi,
            R.id.tv_hint_jalan,

            //bentuk tanah
            R.id.tv_hint_luas_tanah,
            R.id.tv_hint_kondisi_tanah,
            R.id.tv_hint_penggunaan_tanah,
            R.id.tv_hint_bahaya_banjir,
            R.id.tv_hint_batas_utara,
            R.id.tv_hint_batas_selatan,
            R.id.tv_hint_batas_timur,
            R.id.tv_hint_batas_barat,
            R.id.tv_hint_status_tanah,
            R.id.tv_hint_dasar_penghunian,
            R.id.tv_hint_biaya_sewa,
            R.id.tv_hint_penghuni_angunan,
            R.id.tv_hint_jangka_waktu_sewa,

            //fasiitas
            R.id.tv_hint_kapasitas_listrik,
            R.id.tv_hint_saluran_telepon,
            R.id.tv_hint_telepon_1,
            R.id.tv_hint_saluran_air,
            R.id.tv_hint_angkutan_umum,
            R.id.tv_hint_sedia_sekolah,
            R.id.tv_hint_sedia_rumah_sakit,

            //keadaan bangunan
            R.id.tv_hint_tahun_bangunan,
            R.id.tv_hint_tahun_renovasi,
            R.id.tv_hint_luas_bangunan,
            R.id.tv_hint_luas_tanah_keadaan_bangunan,
            R.id.tv_hint_lebar_jalan,

            //konstruksi bangunan
            R.id.tv_hint_pondasi,
            R.id.tv_hint_lantai,
            R.id.tv_hint_dinding,
            R.id.tv_hint_plafon,
            R.id.tv_hint_kusen,
            R.id.tv_hint_atap,
            R.id.tv_hint_pintu,
            R.id.tv_hint_jendela,

            //tata ruang
            R.id.tv_hint_lantai_1,
            R.id.tv_hint_lantai_2,
            R.id.tv_hint_lantai_3,

            //penilaian
            R.id.tv_hint_status_penilaian,
            R.id.tv_hint_nama_penilai,
            R.id.tv_hint_jabatan,
            R.id.tv_hint_nilai_pasar_1,
            R.id.tv_hint_nilai_pasar_2,
            R.id.tv_hint_nilai_pasar_3,
            R.id.tv_hint_nilai_pasar,
            R.id.tv_hint_prosentasi_likuidasi,
            R.id.tv_hint_nilai_likuidasi
    })
    List<TextView> mandatoryHintViews;


    @BindViews({
            R.id.expandable_data_pemilik,
            R.id.expandable_ajb,
            R.id.expandable_alamat_angunan,
            R.id.expandable_bentuk_tanah,
            R.id.expandable_fasilitas,
            R.id.expandable_keadaan_bangunan,
            R.id.expandable_konstruksi_bangunan,
            R.id.expandable_tata_ruang,
            R.id.expandable_penilaian
    })
    List<ExpandableLinearLayout> expandableLinearLayouts;

    @BindViews({
            R.id.btn_data_pemilik,
            R.id.btn_ajb,
            R.id.btn_alamat_angunan,
            R.id.btn_bentuk_tanah,
            R.id.btn_fasilitas,
            R.id.btn_keadaan_bangunan,
            R.id.btn_konstruksi_bangunan,
            R.id.btn_tata_ruang,
            R.id.btn_penilaian
    })
    List<ToggleButton> toggleButtonList;

    @OnClick({
            R.id.btn_data_pemilik,
            R.id.btn_ajb,
            R.id.btn_alamat_angunan,
            R.id.btn_bentuk_tanah,
            R.id.btn_fasilitas,
            R.id.btn_keadaan_bangunan,
            R.id.btn_konstruksi_bangunan,
            R.id.btn_tata_ruang,
            R.id.btn_penilaian
    })
    void onClickToggle(View v) {
        switch (v.getId()) {
            case R.id.btn_data_pemilik:
                //expandDataPemilik.toggle();
                openAndCollapseOthers(R.id.expandable_data_pemilik, v.getId());
                break;
            case R.id.btn_ajb:
                //expandAjb.toggle();
                openAndCollapseOthers(R.id.expandable_ajb, v.getId());
                break;
            case R.id.btn_alamat_angunan:
                //expandAlamatAngunan.toggle();
                openAndCollapseOthers(R.id.expandable_alamat_angunan, v.getId());
                break;
            case R.id.btn_bentuk_tanah:
                //expandBentukTanah.toggle();
                openAndCollapseOthers(R.id.expandable_bentuk_tanah, v.getId());
                break;
            case R.id.btn_fasilitas:
                //expandFasilitas.toggle();
                openAndCollapseOthers(R.id.expandable_fasilitas, v.getId());
                break;
            case R.id.btn_keadaan_bangunan:
                //expandKEadaanBangunan.toggle();
                openAndCollapseOthers(R.id.expandable_keadaan_bangunan, v.getId());
                break;
            case R.id.btn_konstruksi_bangunan:
                //expandKonstruksiBangunan.toggle();
                openAndCollapseOthers(R.id.expandable_konstruksi_bangunan, v.getId());
                break;
            case R.id.btn_tata_ruang:
                //expandTataRuang.toggle();
                openAndCollapseOthers(R.id.expandable_tata_ruang, v.getId());
                break;
            case R.id.btn_penilaian:
                //expandPenilaian.toggle();
                openAndCollapseOthers(R.id.expandable_penilaian, v.getId());
        }
    }

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel, int idJaminan, int requestCode) {
        Intent intent = new Intent(activity, FormSurveyJaminanActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        intent.putExtra(BUNDLE_ID_JAMINAN, idJaminan);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_jaminan;
    }

    @Override
    protected void initData() {
        userModel = AppPreference.getInstance().getUserLoggedIn();
        controller = new SurveyJaminanController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
            idJaminan = getIntent().getIntExtra(BUNDLE_ID_JAMINAN, 0);
        }

        WidgetUtil.setDataMasterAdapter(spJenisAngunan, DataManager.getInstance().getJenisAgunanModelList());
        //WidgetUtil.setDataMasterAdapter(spStatusKepemilikan, DataManager.getInstance().getStatusKepemilikanModelList());
        //WidgetUtil.setDataMasterAdapter(spHubunganPemohon, DataManager.getInstance().getHubunganPemohonModelList());

        if (spStatusKepemilikan.getSelectedItemPosition() == 0) {
            if (mDataModel.getBiodataModel() != null && mDataModel.getBiodataModel().size() > 0) {
                etNamaPemilik.setText(mDataModel.getBiodataModel().get(0).getNamaLengkap());
            } else {
                etNamaPemilik.setText(mDataModel.getNamaPanggilan());
            }
        }
        spStatusKepemilikan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) { //Milik Sendiri
                    spHubunganPemohon.setSelection(0);
                    spHubunganPemohon.setEnabled(false);
                    if (mDataModel != null) {
                        if (mDataModel.getBiodataModel() != null && mDataModel.getBiodataModel().size() > 0) {
                            etNamaPemilik.setText(mDataModel.getBiodataModel().get(0).getNamaLengkap());
                        } else {
                            etNamaPemilik.setText(mDataModel.getNamaPanggilan());
                        }
                    }
                } else {
                    if (formMode != FormMode.VIEW) {
                        spHubunganPemohon.setEnabled(true);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (DataManager.getInstance().getJenisBuktiKepemilikanAgunanModelList() != null) {
            WidgetUtil.setDataMasterAdapter(spJenisBuktiKepemilikanAngunan, DataManager.getInstance().getJenisBuktiKepemilikanAgunanModelList());
        }
        spJenisBuktiKepemilikanAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    JenisBuktiKepemilikanModel jenisBuktiKepemilikanModel = (JenisBuktiKepemilikanModel) spJenisBuktiKepemilikanAngunan.getItemAtPosition(position);
                    if (jenisBuktiKepemilikanModel != null) {
                        List<BuktiKepemilikanAgunanModel> buktiKepemilikanAgunanModels = DataManager.getInstance().getBuktiKepemilikanAgunanModelList(jenisBuktiKepemilikanModel.getId());
                        if (buktiKepemilikanAgunanModels != null && buktiKepemilikanAgunanModels.size() > 0) {
                            WidgetUtil.setDataMasterAdapter(spBuktiKepemilikanAngunan, buktiKepemilikanAgunanModels);
                            if (jaminanModel != null) {
                                spBuktiKepemilikanAngunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBuktiKepemilikanAngunan, jaminanModel.getBuktiKepemilikan()));
                            }
                        } else {
                            WidgetUtil.setDefaultEmptyAdapter(spBuktiKepemilikanAngunan);
                            DialogFactory.showProgress(FormSurveyJaminanActivity.this);
                            controller.getBuktiKepemilikanAgunan(jenisBuktiKepemilikanModel.getId());
                        }
                    }

                } else {
                    WidgetUtil.setDefaultEmptyAdapter(spBuktiKepemilikanAngunan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //data pemilik angunan
        spTanggalPemilikAngunan.setAdapter(WidgetUtil.createAdapterTanggal(this));
        spBulanPemilikAngunan.setAdapter(WidgetUtil.createAdapterBulan(this));
        spTahunPemilikAngunan.setAdapter(WidgetUtil.createAdapterTahun(this));
        //AJB
        spTanggalAJB.setAdapter(WidgetUtil.createAdapterTanggal(this));
        spBulanAJB.setAdapter(WidgetUtil.createAdapterBulan(this));
        spTahunAJB.setAdapter(WidgetUtil.createAdapterTahun(this));
        //penilaian
        spTanggalPenilaian.setAdapter(WidgetUtil.createAdapterTanggal(this));
        spBulanPenilaian.setAdapter(WidgetUtil.createAdapterBulan(this));
        spTahunPenilaian.setAdapter(WidgetUtil.createAdapterTahun(this));
        //keadaan bangunan
        spTahunDidirikanBangunan.setAdapter(WidgetUtil.createAdapterTahunFromNow(this));
        spTahunRenovasi.setAdapter(WidgetUtil.createAdapterTahunFromNow(this));

        spPenghuniAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spJangkaWaktuSewa.setSelection(0);
                    spJangkaWaktuSewa.setEnabled(false);
                } else {
                    spJangkaWaktuSewa.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        WidgetUtil.setDataMasterAdapter(spBuktiKepemilikanAngunan, DataManager.getInstance().getBuktiKepemilikanAgunanModelList(0));
        WidgetUtil.setDataMasterAdapter(spPeruntukanLokasi, DataManager.getInstance().getPeruntukanLokasiModelList());
        WidgetUtil.setDataMasterAdapter(spJalanYangDilalui, DataManager.getInstance().getJalanDilaluiModelList());
        WidgetUtil.setDataMasterAdapter(spBatasUtara, DataManager.getInstance().getBatasWilayahModelList());
        WidgetUtil.setDataMasterAdapter(spBatasTimur, DataManager.getInstance().getBatasWilayahModelList());
        WidgetUtil.setDataMasterAdapter(spBatasBarat, DataManager.getInstance().getBatasWilayahModelList());
        WidgetUtil.setDataMasterAdapter(spBatasSelatan, DataManager.getInstance().getBatasWilayahModelList());

        WidgetUtil.setDataMasterAdapter(spStatusTanah, DataManager.getInstance().getStatusTanahModelList());
        WidgetUtil.setDataMasterAdapter(spKondisiTanah, DataManager.getInstance().getKondisiPermukaanTanahModelList());
        WidgetUtil.setDataMasterAdapter(spPenggunaanTanah, DataManager.getInstance().getPenggunaanTanahModelList());
        WidgetUtil.setDataMasterAdapter(spBentukTanah, DataManager.getInstance().getBentukTanahModelList());
        WidgetUtil.setDataMasterAdapter(spBentukTanahBangunan, DataManager.getInstance().getBentukTanahModelList());

        WidgetUtil.setDataMasterAdapter(spSaluranAir, DataManager.getInstance().getSaluranAirModelList());
        WidgetUtil.setDataMasterAdapter(spSaluranTelepon, DataManager.getInstance().getSaluranTeleponModelList());

        WidgetUtil.setDataMasterAdapter(spPondasi, DataManager.getInstance().getPondasiModelList());
        WidgetUtil.setDataMasterAdapter(spLantai, DataManager.getInstance().getLantaiModelList());
        WidgetUtil.setDataMasterAdapter(spDinding, DataManager.getInstance().getDindingModelList());
        WidgetUtil.setDataMasterAdapter(spPlafon, DataManager.getInstance().getPlafonModelList());
        WidgetUtil.setDataMasterAdapter(spKusen, DataManager.getInstance().getKusenModelList());
        WidgetUtil.setDataMasterAdapter(spAtap, DataManager.getInstance().getAtapModelList());
        WidgetUtil.setDataMasterAdapter(spPintu, DataManager.getInstance().getPintuModelList());
        WidgetUtil.setDataMasterAdapter(spJendela, DataManager.getInstance().getJendelaModelList());

        WidgetUtil.setTextWatcherCurrency(etBiayaSewa);
        WidgetUtil.setTextWatcherCurrency(etNilaiPasar);
        WidgetUtil.setTextWatcherCurrency(etNilaiPasar1);
        WidgetUtil.setTextWatcherCurrency(etNilaiPasar2);
        WidgetUtil.setTextWatcherCurrency(etNilaiPasar3);
        WidgetUtil.setTextWatcherCurrency(etProsentasiLikuidasi);
        WidgetUtil.setTextWatcherCurrency(etNilaiLikuidasi);

        if(userModel!=null){
            if (TextUtils.isEmpty(etNamaPenilai.getText()))
                etNamaPenilai.setText(userModel.getFullname());

            if (TextUtils.isEmpty(etJabatan.getText()))
                etJabatan.setText(userModel.getPosisi());
        }

        spBuktiKepemilikanAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spBuktiKepemilikanAngunan.getSelectedItem() instanceof BuktiKepemilikanAgunanModel) {
                    BuktiKepemilikanAgunanModel model = (BuktiKepemilikanAgunanModel) spBuktiKepemilikanAngunan.getSelectedItem();
                    if (model != null && !TextUtils.isEmpty(model.getProsentaseLikuidasi())) {
                        etProsentasiLikuidasi.setText(model.getProsentaseLikuidasi());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etNilaiPasar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateLikuidasi();
            }
        });


        etProsentasiLikuidasi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateLikuidasi();
            }
        });

        initAlamat();
    }

    private void calculateLikuidasi() {
        try {
            double value = Double.parseDouble(WidgetUtil.getNumberFromField(etNilaiPasar));
            int percent = Integer.parseInt(WidgetUtil.getNumberFromField(etProsentasiLikuidasi));
            double total = (value * percent) / 100;
            etNilaiLikuidasi.setText(WidgetUtil.convertToLocalCurrency(total));
        }catch (Exception e) {}
    }

    @Override
    protected void onDestroy() {
        if (alamatController != null) {
            alamatController.cancelAll();
        }
        if (controller != null) {
            controller.cancel();
        }
        super.onDestroy();
    }

    private AlamatController alamatController;
    private void initAlamat() {
        alamatController = new AlamatController();
        WidgetUtil.setDataMasterAdapter(spProvinsiAlamatAngunan, DataManager.getInstance().getProvinsiModelList());

        spProvinsiAlamatAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsiAlamatAngunan.getSelectedItem() != null && spProvinsiAlamatAngunan.getSelectedItem() instanceof ProvinsiModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsiAlamatAngunan.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0) {
                        WidgetUtil.setDefaultEmptyAdapter(spKotaAlamatAngunan);
                        WidgetUtil.setDefaultEmptyAdapter(spKecamatanAlamatAngunan);
                        WidgetUtil.setDefaultEmptyAdapter(spKelurahanAlamatAngunan);
                        alamatController.getKabupaten(provinsiModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spKotaAlamatAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsiAlamatAngunan.getSelectedItem() instanceof  ProvinsiModel
                        && spKotaAlamatAngunan.getSelectedItem() instanceof KabupatenModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsiAlamatAngunan.getSelectedItem();
                    KabupatenModel kabupatenModel = (KabupatenModel) spKotaAlamatAngunan.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0
                            && kabupatenModel != null && kabupatenModel.getId() > 0) {

                        WidgetUtil.setDefaultEmptyAdapter(spKecamatanAlamatAngunan);
                        WidgetUtil.setDefaultEmptyAdapter(spKelurahanAlamatAngunan);
                        alamatController.getKecamatan(provinsiModel.getId(), kabupatenModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spKecamatanAlamatAngunan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsiAlamatAngunan.getSelectedItem() instanceof  ProvinsiModel
                        && spKotaAlamatAngunan.getSelectedItem() instanceof KabupatenModel
                        && spKecamatanAlamatAngunan.getSelectedItem() instanceof KecamatanModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsiAlamatAngunan.getSelectedItem();
                    KabupatenModel kabupatenModel = (KabupatenModel) spKotaAlamatAngunan.getSelectedItem();
                    KecamatanModel kecamatanModel = (KecamatanModel) spKecamatanAlamatAngunan.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0
                            && kabupatenModel != null && kabupatenModel.getId() > 0
                            && kecamatanModel != null && kecamatanModel.getId() > 0
                            ) {
                        alamatController.getKelurahan(provinsiModel.getId(), kabupatenModel.getId(), kecamatanModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlamatCallback alamatCallback = new AlamatCallback() {
            @Override
            public void onGetKabupatenSuccess(List<KabupatenModel> list) {
                /*if (!isVisible()) {
                    return;
                }*/

                if (list == null) {
                    list = new ArrayList<>();
                }
                KabupatenModel modelFirst = new KabupatenModel();
                modelFirst.setNamaKabupaten("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KabupatenModel> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKotaAlamatAngunan.setAdapter(adapter);

                if (jaminanModel != null && jaminanModel.getIdKabKota() > 0) {
                    WidgetUtil.setSpinnerSelectionById(spKotaAlamatAngunan, jaminanModel.getIdKabKota());
                }
            }

            @Override
            public void onGetKabupatenFailed(Throwable t) {

            }

            @Override
            public void onGetKecamatanSuccess(List<KecamatanModel> list) {
                /*if (!isVisible()) {
                    return;
                }*/

                if (list == null) {
                    list = new ArrayList<>();
                }
                KecamatanModel modelFirst = new KecamatanModel();
                modelFirst.setNamaKecamatan("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KecamatanModel> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKecamatanAlamatAngunan.setAdapter(adapter);

                if(jaminanModel != null && jaminanModel.getIdKecamatan() > 0) {
                    WidgetUtil.setSpinnerSelectionById(spKecamatanAlamatAngunan, jaminanModel.getIdKecamatan());
                }
            }

            @Override
            public void onGetKecamatanFailed(Throwable t) {

            }

            @Override
            public void onGetKelurahanSuccess(List<KelurahanModel> list) {
                /*if (!isVisible()) {
                    return;
                }*/

                if (list == null) {
                    list = new ArrayList<>();
                }
                KelurahanModel modelFirst = new KelurahanModel();
                modelFirst.setNamaKelurahan("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KelurahanModel> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKelurahanAlamatAngunan.setAdapter(adapter);

                if(jaminanModel != null && jaminanModel.getIdKelurahan() > 0) {
                    WidgetUtil.setSpinnerSelectionById(spKelurahanAlamatAngunan, jaminanModel.getIdKelurahan());
                }
            }

            @Override
            public void onGetKelurahanFailed(Throwable t) {

            }
        };
        alamatController.setCallback(alamatCallback);
    }

    @Override
    protected void loadData() {
        if (idJaminan > 0) {
            DialogFactory.showProgress(this);
            controller.getSurveyJaminan(idJaminan);
        }
    }

    @Override
    protected void setEnableItems(boolean enable) {
        //etNamaAngunan.setEnabled(enable);
        etNomorLpj.setEnabled(enable);
        spJenisAngunan.setEnabled(enable);
        spStatusKepemilikan.setEnabled(enable);
        spHubunganPemohon.setEnabled(enable);
        if (spStatusKepemilikan.getSelectedItemPosition() == 0) { //Milik Sendiri
            spHubunganPemohon.setSelection(0);
            spHubunganPemohon.setEnabled(false);
        } else {
            spHubunganPemohon.setEnabled(enable);
        }

        //data pemilik angunan
        etNamaPemilik.setEnabled(enable);
        spJenisBuktiKepemilikanAngunan.setEnabled(enable);
        spBuktiKepemilikanAngunan.setEnabled(enable);
        etNoKepemilikanAngunan.setEnabled(enable);
        etLokasiDikeluarkanSuratTanah.setEnabled(enable);
        etNomorIMB.setEnabled(enable);
        spTanggalPemilikAngunan.setEnabled(enable);
        spBulanPemilikAngunan.setEnabled(enable);
        spTahunPemilikAngunan.setEnabled(enable);
        etNamaIMB.setEnabled(enable);
        etPeruntukanIMB.setEnabled(enable);

        //ajb
        etNomorAJB.setEnabled(enable);
        spTanggalAJB.setEnabled(enable);
        spBulanAJB.setEnabled(enable);
        spTahunAJB.setEnabled(enable);
        etKeluaranAJB.setEnabled(enable);

        //alamat angunan
        etAlamatAngunan.setEnabled(enable);
        etRT.setEnabled(enable);
        etRW.setEnabled(enable);
        spProvinsiAlamatAngunan.setEnabled(enable);
        spKotaAlamatAngunan.setEnabled(enable);
        spKelurahanAlamatAngunan.setEnabled(enable);
        spKecamatanAlamatAngunan.setEnabled(enable);
        etKodePos.setEnabled(enable);
        spPeruntukanLokasi.setEnabled(enable);
        spJalanYangDilalui.setEnabled(enable);

        //bentuk tanah
        etLuasTanah.setEnabled(enable);
        spKondisiTanah.setEnabled(enable);
        spPenggunaanTanah.setEnabled(enable);
        //etBahayaBanjir.setEnabled(enable);
        spBanjir.setEnabled(enable);
        spBatasUtara.setEnabled(enable);
        spBatasSelatan.setEnabled(enable);
        spBatasTimur.setEnabled(enable);
        spBatasBarat.setEnabled(enable);
        spStatusTanah.setEnabled(enable);
        etDasarPenghunian.setEnabled(enable);
        etBiayaSewa.setEnabled(enable);
        spPenghuniAngunan.setEnabled(enable);
        spJangkaWaktuSewa.setEnabled(enable);

        //fasilitas
        etKapasitasListrik.setEnabled(enable);
        spSaluranTelepon.setEnabled(enable);
        etTelepon1.setEnabled(enable);
        spSaluranAir.setEnabled(enable);
        spAngkutanUmum.setEnabled(enable);
        spTersediaSekolah.setEnabled(enable);
        spTersediaRumahSakit.setEnabled(enable);

        //keadaan bangunan
        spTahunDidirikanBangunan.setEnabled(enable);
        spTahunRenovasi.setEnabled(enable);
        etLuasBangunan.setEnabled(enable);
        etLuasTanahKeadaanBangunan.setEnabled(enable);
        etLebarjalan.setEnabled(enable);
        spJalanAkses.setEnabled(enable);
        spBentukTanah.setEnabled(enable);
        spBentukTanahBangunan.setEnabled(enable);

        //konstruksi bangunan
        spPondasi.setEnabled(enable);
        spLantai.setEnabled(enable);
        spDinding.setEnabled(enable);
        spPlafon.setEnabled(enable);
        spKusen.setEnabled(enable);
        spAtap.setEnabled(enable);
        spPintu.setEnabled(enable);
        spJendela.setEnabled(enable);

        //tata ruang
        etLantai1.setEnabled(enable);
        etLantai2.setEnabled(enable);
        etLantai3.setEnabled(enable);

        //penilaian
        etStatusPenilaian.setEnabled(enable);
        spTanggalPenilaian.setEnabled(enable);
        spBulanPenilaian.setEnabled(enable);
        spTahunPenilaian.setEnabled(enable);
        etNamaPenilai.setEnabled(enable);
        etJabatan.setEnabled(enable);
        etNilaiPasar1.setEnabled(enable);
        etNilaiPasar2.setEnabled(enable);
        etNilaiPasar3.setEnabled(enable);
        etNilaiPasar.setEnabled(enable);
        etProsentasiLikuidasi.setEnabled(enable);
        etNilaiLikuidasi.setEnabled(false);//always disable

        etExum.setEnabled(enable);
    }

    @Override
    public void setupView() {
        if (jaminanModel != null) {
            etNomorLpj.setText(jaminanModel.getNomorLpj());
            WidgetUtil.setSpinnerSelectionById(spJenisAngunan, jaminanModel.getIdJenisAgunan());
            spStatusKepemilikan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spStatusKepemilikan, jaminanModel.getStatusKepemilikan()));
            spHubunganPemohon.setSelection(WidgetUtil.getSpinnerIndexByLabel(spHubunganPemohon, jaminanModel.getHubunganDenganPemohon()));

            //data pemilik angunan
            etNamaPemilik.setText(jaminanModel.getNamaPemilik());
            //spJenisBuktiKepemilikanAngunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBuktiKepemilikanAngunan, jaminanModel.getJenisBuktiKepemilikan()));
            WidgetUtil.setSpinnerSelectionById(spJenisBuktiKepemilikanAngunan, jaminanModel.getIdJenisBuktiKepemilikan());
            spBuktiKepemilikanAngunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBuktiKepemilikanAngunan, jaminanModel.getBuktiKepemilikan()));
            etNoKepemilikanAngunan.setText(jaminanModel.getNomorSurat());
            etLokasiDikeluarkanSuratTanah.setText(jaminanModel.getLokasiDikeluarkanSurat());
            etNomorIMB.setText(jaminanModel.getNomorImb());

            String tgl = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "dd");
            String bln = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "MM");
            String tahun = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "yyyy");
            int posTgl = WidgetUtil.getSpinnerIndexByLabel(spTanggalPemilikAngunan, tgl);
            spTanggalPemilikAngunan.setSelection(posTgl);
            int posBulan = WidgetUtil.getSpinnerIndexByLabel(spBulanPemilikAngunan, bln);
            spBulanPemilikAngunan.setSelection(posBulan);
            int posTahun = WidgetUtil.getSpinnerIndexByLabel(spTahunPemilikAngunan, tahun);
            spTahunPemilikAngunan.setSelection(posTahun);

            etNamaIMB.setText(jaminanModel.getNamaImb());
            etPeruntukanIMB.setText(jaminanModel.getPeruntukanImb());

            //ajb
            etNomorAJB.setText(jaminanModel.getNomorAjb());
            String tglAjb = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "dd");
            String blnAjb = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "MM");
            String tahunAjb = DateUtil.convertDateString(jaminanModel.getTanggalTerbitImb(), "yyyy-MM-dd", "yyyy");
            int posTglAjb = WidgetUtil.getSpinnerIndexByLabel(spTanggalPemilikAngunan, tglAjb);
            spTanggalAJB.setSelection(posTglAjb);
            int posBulanAjb = WidgetUtil.getSpinnerIndexByLabel(spBulanPemilikAngunan, blnAjb);
            spBulanAJB.setSelection(posBulanAjb);
            int posTahunAjb = WidgetUtil.getSpinnerIndexByLabel(spTahunPemilikAngunan, tahunAjb);
            spTahunAJB.setSelection(posTahunAjb);
            etKeluaranAJB.setText(jaminanModel.getPenerbitAjb());

            //alamat angunan
            etAlamatAngunan.setText(jaminanModel.getAlamatAgunan());
            etRT.setText(jaminanModel.getrT());
            etRW.setText(jaminanModel.getrW());

            WidgetUtil.setSpinnerSelectionById(spProvinsiAlamatAngunan, jaminanModel.getIdProvinsi());
            WidgetUtil.setSpinnerSelectionById(spKotaAlamatAngunan, jaminanModel.getIdKabKota());
            WidgetUtil.setSpinnerSelectionById(spKecamatanAlamatAngunan, jaminanModel.getIdKecamatan());
            WidgetUtil.setSpinnerSelectionById(spKelurahanAlamatAngunan, jaminanModel.getIdKelurahan());

            etKodePos.setText(jaminanModel.getKodepos());
            spPeruntukanLokasi.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPeruntukanLokasi, jaminanModel.getPeruntukanLokasi()));
            spJalanYangDilalui.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJalanYangDilalui, jaminanModel.getJalanDilalui()));

            //bentuk tanah
            etLuasTanah.setText(jaminanModel.getLuasTanah());
            spKondisiTanah.setSelection(WidgetUtil.getSpinnerIndexByLabel(spKondisiTanah, jaminanModel.getKondisiPermukaan()));
            spPenggunaanTanah.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPenggunaanTanah, jaminanModel.getPenggunaanTanah()));
            spBanjir.setSelection(jaminanModel.getIsBanjir());
            spBatasUtara.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBatasUtara, jaminanModel.getBatasUtara()));
            spBatasTimur.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBatasTimur, jaminanModel.getBatasTimur()));
            spBatasBarat.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBatasBarat, jaminanModel.getBatasBarat()));
            spBatasSelatan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBatasSelatan, jaminanModel.getBatasSelatan()));
            spStatusTanah.setSelection(WidgetUtil.getSpinnerIndexByLabel(spStatusTanah, jaminanModel.getStatusTanah()));
            etDasarPenghunian.setText(jaminanModel.getDasarPenghunian());
            etBiayaSewa.setText(jaminanModel.getBiayaSewa());
            spPenghuniAngunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPenghuniAngunan, jaminanModel.getPenghuniAgunan()));
            spJangkaWaktuSewa.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJangkaWaktuSewa, jaminanModel.getJangkaWaktuSewa()));

            //fasilitas
            etKapasitasListrik.setText(jaminanModel.getKapasitasListrik());
            spSaluranTelepon.setSelection(WidgetUtil.getSpinnerIndexByLabel(spSaluranTelepon, jaminanModel.getSaluranTelepon()));
            spSaluranAir.setSelection(WidgetUtil.getSpinnerIndexByLabel(spSaluranAir, jaminanModel.getSaluranAir()));
            spAngkutanUmum.setSelection(jaminanModel.getIsAngkutanUmum());
            spTersediaSekolah.setSelection(jaminanModel.getIsSekolah());
            spTersediaRumahSakit.setSelection(jaminanModel.getIsRumahSakit());

            //keadaan bangunan
            spTahunDidirikanBangunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spTahunDidirikanBangunan, jaminanModel.getTahunBangunan()));
            spTahunRenovasi.setSelection(WidgetUtil.getSpinnerIndexByLabel(spTahunRenovasi, jaminanModel.getTahunRenovasi()));
            etLuasBangunan.setText(jaminanModel.getLbLantai1());
            etLuasTanahKeadaanBangunan.setText(jaminanModel.getLuasTanahKondisiBangunan());
            etLebarjalan.setText(jaminanModel.getLebarJalan());
            spJalanAkses.setSelection(jaminanModel.getIsJalanAkses());
            spBentukTanah.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBentukTanah, jaminanModel.getBentukTanah()));
            //spBentukTanahBangunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBentukTanahBangunan, jaminanModel.getBentukTanah()));

            //konstruksi bangunan
            spPondasi.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPondasi, jaminanModel.getPondasi()));
            spLantai.setSelection(WidgetUtil.getSpinnerIndexByLabel(spLantai, jaminanModel.getLantai()));
            spDinding.setSelection(WidgetUtil.getSpinnerIndexByLabel(spDinding, jaminanModel.getDinding()));
            spPlafon.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPlafon, jaminanModel.getPlafon()));
            spKusen.setSelection(WidgetUtil.getSpinnerIndexByLabel(spKusen, jaminanModel.getKusen()));
            spAtap.setSelection(WidgetUtil.getSpinnerIndexByLabel(spAtap, jaminanModel.getAtap()));
            spPintu.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPintu, jaminanModel.getPintu()));
            spJendela.setSelection(WidgetUtil.getSpinnerIndexByLabel(spJendela, jaminanModel.getJendela()));

            //tata ruang
            etLantai1.setText(jaminanModel.getLantai1());
            etLantai2.setText(jaminanModel.getLantai2());
            etLantai3.setText(jaminanModel.getLantai3());


            //penilaian
            etStatusPenilaian.setText(jaminanModel.getStatusPenilaian());
            String tglPenilaian = DateUtil.convertDateString(jaminanModel.getTanggalPenilaian(), "yyyy-MM-dd", "dd");
            String blnPenilaian = DateUtil.convertDateString(jaminanModel.getTanggalPenilaian(), "yyyy-MM-dd", "MM");
            String tahunPenilaian = DateUtil.convertDateString(jaminanModel.getTanggalPenilaian(), "yyyy-MM-dd", "yyyy");
            int posTglPenilaian = WidgetUtil.getSpinnerIndexByLabel(spTanggalPenilaian, tglPenilaian);
            spTanggalPenilaian.setSelection(posTglPenilaian);
            int posBulanPenilaian = WidgetUtil.getSpinnerIndexByLabel(spBulanPenilaian, blnPenilaian);
            spBulanPenilaian.setSelection(posBulanPenilaian);
            int posTahunPenilaian = WidgetUtil.getSpinnerIndexByLabel(spTahunPenilaian, tahunPenilaian);
            spTahunPenilaian.setSelection(posTahunPenilaian);
            etNamaPenilai.setText(jaminanModel.getNamaPenilai());
            etJabatan.setText(jaminanModel.getJabatan());
            etNilaiPasar.setText(jaminanModel.getNilaiPasar());
            etNilaiPasar1.setText(jaminanModel.getNilaiPasar1());
            etNilaiPasar2.setText(jaminanModel.getNilaiPasar2());
            etNilaiPasar3.setText(jaminanModel.getNilaiPasar3());
            etProsentasiLikuidasi.setText(jaminanModel.getProsentaseLikuidasi());
            etNilaiLikuidasi.setText(jaminanModel.getNilaiLikuidasi());

            etExum.setText(jaminanModel.getExecutiveSummary());

        }


        if(userModel!=null){
            if (TextUtils.isEmpty(etNamaPenilai.getText()))
                etNamaPenilai.setText(userModel.getFullname());

            if (TextUtils.isEmpty(etJabatan.getText()))
                etJabatan.setText(userModel.getPosisi());
        }
    }

    @Override
    protected void saveData() {
        if (!WidgetUtil.validateField(spJenisAngunan, getString(R.string.field_err_msg, "Jenis Agunan"))) {
            return;
        }

        if (!WidgetUtil.validateField(etAlamatAngunan, getString(R.string.field_err_msg, "Alamat Agunan"))) {
            return;
        }

        SurveyJaminanModel newModel = new SurveyJaminanModel();
        newModel.setId(idJaminan);
        JenisAgunanModel agunanModel = (JenisAgunanModel) spJenisAngunan.getSelectedItem();
        if (agunanModel != null && agunanModel.getId() > 0) {
            newModel.setIdJenisAgunan(agunanModel.getId());
        }

        newModel.setNomorLpj(etNomorLpj.getText().toString());
        newModel.setStatusKepemilikan(spStatusKepemilikan.getSelectedItem().toString());
        newModel.setHubunganDenganPemohon(spHubunganPemohon.getSelectedItem().toString());

        //data pemilik angunan
        newModel.setNamaPemilik(etNamaPemilik.getText().toString());

        JenisBuktiKepemilikanModel jenisBuktiKepemilikanModel = (JenisBuktiKepemilikanModel) spJenisBuktiKepemilikanAngunan.getSelectedItem();
        if(jenisBuktiKepemilikanModel != null) {
            newModel.setIdJenisBuktiKepemilikan(String.valueOf(jenisBuktiKepemilikanModel.getId()));
            newModel.setJenisBuktiKepemilikan(jenisBuktiKepemilikanModel.getJenisBukti());
        }
        newModel.setBuktiKepemilikan(spBuktiKepemilikanAngunan.getSelectedItem().toString());
        newModel.setNomorSurat(etNoKepemilikanAngunan.getText().toString());
        newModel.setLokasiDikeluarkanSurat(etLokasiDikeluarkanSuratTanah.getText().toString());
        newModel.setNomorImb(etNomorIMB.getText().toString());
        if(spTanggalPemilikAngunan.getSelectedItemPosition() > 0 && spBulanPemilikAngunan.getSelectedItemPosition() > 0 && spTahunPemilikAngunan.getSelectedItemPosition() > 0) {
            String tgl = spTanggalPemilikAngunan.getSelectedItem() != null ? spTanggalPemilikAngunan.getSelectedItem().toString() : "";
            String bln = spBulanPemilikAngunan.getSelectedItem() != null ? spBulanPemilikAngunan.getSelectedItem().toString() : "";
            String thn = spTahunPemilikAngunan.getSelectedItem() != null ? spTahunPemilikAngunan.getSelectedItem().toString() : "";
            newModel.setTanggalTerbitImb(thn + "-" + bln + "-" + tgl);
        }

        newModel.setNamaImb(etNamaIMB.getText().toString());
        newModel.setPeruntukanImb(etPeruntukanIMB.getText().toString());


        //ajb
        newModel.setNomorAjb(etNomorAJB.getText().toString());
        if(spTanggalAJB.getSelectedItemPosition() > 0 && spBulanAJB.getSelectedItemPosition() > 0 && spTahunAJB.getSelectedItemPosition() > 0) {
            String tgl = spTanggalAJB.getSelectedItem() != null ? spTanggalAJB.getSelectedItem().toString() : "";
            String bln = spBulanAJB.getSelectedItem() != null ? spBulanAJB.getSelectedItem().toString() : "";
            String thn = spTahunAJB.getSelectedItem() != null ? spTahunAJB.getSelectedItem().toString() : "";
            newModel.setTanggalTerbitAjb(thn + "-" + bln + "-" + tgl);
        }
        newModel.setPenerbitAjb(etKeluaranAJB.getText().toString());

        //alamat angunan
        newModel.setAlamatAgunan(etAlamatAngunan.getText().toString());
        newModel.setrT(etRT.getText().toString());
        newModel.setrW(etRW.getText().toString());


        /*if(!WidgetUtil.validateField(spProvinsiAlamatAngunan, getString(R.string.field_err_msg, "Provinsi"))) {
            return;
        }

        if(!WidgetUtil.validateField(spKotaAlamatAngunan, getString(R.string.field_err_msg, "Kota/Kabupaten"))) {
            return;
        }
        if(!WidgetUtil.validateField(spKecamatanAlamatAngunan, getString(R.string.field_err_msg, "Kecamatan"))) {
            return;
        }
        if(!WidgetUtil.validateField(spKelurahanAlamatAngunan, getString(R.string.field_err_msg, "Kelurahan"))) {
            return;
        }*/

        ProvinsiModel provinsiModel = null;
        if (spProvinsiAlamatAngunan.getSelectedItemPosition() > 0)
        provinsiModel = (ProvinsiModel) spProvinsiAlamatAngunan.getSelectedItem();
        KabupatenModel kabupatenModel = null;
        if (spKotaAlamatAngunan.getSelectedItemPosition() > 0)
        kabupatenModel = (KabupatenModel) spKotaAlamatAngunan.getSelectedItem();
        KecamatanModel kecamatanModel = null;
        if (spKecamatanAlamatAngunan.getSelectedItemPosition() > 0)
        kecamatanModel = (KecamatanModel) spKecamatanAlamatAngunan.getSelectedItem();
        KelurahanModel kelurahanModel = null;
        if (spKelurahanAlamatAngunan.getSelectedItemPosition() > 0)
        kelurahanModel = (KelurahanModel) spKelurahanAlamatAngunan.getSelectedItem();

        if (provinsiModel != null)
        newModel.setIdProvinsi(provinsiModel.getId());
        if (kabupatenModel != null)
        newModel.setIdKabKota(kabupatenModel.getId());
        if (kecamatanModel != null)
        newModel.setIdKecamatan(kecamatanModel.getId());
        if(kelurahanModel != null)
        newModel.setIdKelurahan(kelurahanModel.getId());

        newModel.setKodepos(etKodePos.getText().toString());
        newModel.setPeruntukanLokasi(spPeruntukanLokasi.getSelectedItem().toString());
        newModel.setJalanDilalui(spJalanYangDilalui.getSelectedItem().toString());


        //bentuk tanah
        newModel.setLuasTanah(etLuasTanah.getText().toString());
        newModel.setKondisiPermukaan(spKondisiTanah.getSelectedItem().toString());
        newModel.setPenggunaanTanah(spPenggunaanTanah.getSelectedItem().toString());
        newModel.setIsBanjir(spBanjir.getSelectedItemPosition());
        newModel.setBatasUtara(spBatasUtara.getSelectedItem().toString());
        newModel.setBatasSelatan(spBatasSelatan.getSelectedItem().toString());
        newModel.setBatasTimur(spBatasTimur.getSelectedItem().toString());
        newModel.setBatasBarat(spBatasBarat.getSelectedItem().toString());
        newModel.setStatusTanah(spStatusTanah.getSelectedItem().toString());
        newModel.setDasarPenghunian(etDasarPenghunian.getText().toString());
        String sBiayaSewa = WidgetUtil.getNumberFromField(etBiayaSewa);
        if (TextUtils.isEmpty(sBiayaSewa))
            sBiayaSewa = "0";
        newModel.setBiayaSewa(sBiayaSewa);
        newModel.setPenghuniAgunan(spPenghuniAngunan.getSelectedItem().toString());
        newModel.setJangkaWaktuSewa(spJangkaWaktuSewa.getSelectedItem().toString());

        //fasilitas
        newModel.setKapasitasListrik(etKapasitasListrik.getText().toString());
        newModel.setSaluranTelepon(spSaluranTelepon.getSelectedItem().toString());
        newModel.setSaluranAir(spSaluranAir.getSelectedItem().toString());
        newModel.setIsAngkutanUmum(spAngkutanUmum.getSelectedItemPosition());
        newModel.setIsSekolah(spTersediaSekolah.getSelectedItemPosition());
        newModel.setIsRumahSakit(spTersediaRumahSakit.getSelectedItemPosition());

        //keadaan bangunan
        if (spTahunDidirikanBangunan.getSelectedItemPosition() > 0) {
            newModel.setTahunBangunan(spTahunDidirikanBangunan.getSelectedItem().toString());
        }
        if (spTahunRenovasi.getSelectedItemPosition() > 0) {
            newModel.setTahunRenovasi(spTahunRenovasi.getSelectedItem().toString());
        }
        newModel.setLbLantai1(etLuasBangunan.getText().toString());
        newModel.setLuasTanahKondisiBangunan(etLuasTanahKeadaanBangunan.getText().toString());
        newModel.setLebarJalan(etLebarjalan.getText().toString());
        newModel.setIsJalanAkses(spJalanAkses.getSelectedItemPosition());
        newModel.setBentukTanah(spBentukTanah.getSelectedItem().toString());
        //newModel.setBentukTanahBangunan(spBentukTanahBangunan.getSelectedItem().toString());

        //konstruksi bangunan
        newModel.setPondasi(spPondasi.getSelectedItem().toString());
        newModel.setLantai(spLantai.getSelectedItem().toString());
        newModel.setDinding(spDinding.getSelectedItem().toString());
        newModel.setPlafon(spPlafon.getSelectedItem().toString());
        newModel.setKusen(spKusen.getSelectedItem().toString());
        newModel.setAtap(spAtap.getSelectedItem().toString());
        newModel.setPintu(spPintu.getSelectedItem().toString());
        newModel.setJendela(spJendela.getSelectedItem().toString());

        //tata ruang
        newModel.setLantai1(etLantai1.getText().toString());
        newModel.setLantai2(etLantai2.getText().toString());
        newModel.setLantai3(etLantai3.getText().toString());

        //penilaian
        newModel.setStatusPenilaian(etStatusPenilaian.getText().toString());
        if(spTanggalPenilaian.getSelectedItemPosition() > 0 && spBulanPenilaian.getSelectedItemPosition() > 0 && spTahunPenilaian.getSelectedItemPosition() > 0) {
            String tgl = spTanggalPenilaian.getSelectedItem() != null ? spTanggalPenilaian.getSelectedItem().toString() : "";
            String bln = spBulanPenilaian.getSelectedItem() != null ? spBulanPenilaian.getSelectedItem().toString() : "";
            String thn = spTahunPenilaian.getSelectedItem() != null ? spTahunPenilaian.getSelectedItem().toString() : "";
            newModel.setTanggalPenilaian(thn + "-" + bln + "-" + tgl);
        }

        newModel.setNamaPenilai(etNamaPenilai.getText().toString());
        newModel.setJabatan(etJabatan.getText().toString());
        newModel.setNilaiPasar1(WidgetUtil.getNumberFromField(etNilaiPasar1));
        newModel.setNilaiPasar2(WidgetUtil.getNumberFromField(etNilaiPasar2));
        newModel.setNilaiPasar3(WidgetUtil.getNumberFromField(etNilaiPasar3));
        newModel.setNilaiPasar(WidgetUtil.getNumberFromField(etNilaiPasar));
        newModel.setProsentaseLikuidasi(WidgetUtil.getNumberFromField(etProsentasiLikuidasi));
        newModel.setNilaiLikuidasi(WidgetUtil.getNumberFromField(etNilaiLikuidasi));

        newModel.setExecutiveSummary(etExum.getText().toString());


        jaminanModel = newModel;
        DialogFactory.showProgress(this);
        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
        controller.saveSurveyJaminan(biodataModel, jaminanModel);
    }

    private void openAndCollapseOthers(@IdRes int layoutId, @IdRes int buttonId) {
        for (ExpandableLinearLayout layout : expandableLinearLayouts) {
            if (layout.getId() == layoutId) {
                layout.toggle();
            } else if (layout.isExpanded()) {
                layout.collapse();
            }
        }

        ButterKnife.apply(toggleButtonList, setToggleOff, buttonId);
    }

    private ButterKnife.Setter<ToggleButton, Integer> setToggleOff = new ButterKnife.Setter<ToggleButton, Integer>() {
        @Override
        public void set(ToggleButton view, Integer value, int index) {
            if (view.getId() != value) {
                view.setChecked(false);
            }
        }
    };

    @Override
    public void onGetSurveyJaminanSuccess(SurveyJaminanModel model) {
        this.jaminanModel = model;
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyJaminanFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveSurveyJaminanSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //setResult(RESULT_OK);
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });
    }

    @Override
    public void onSaveSurveyJaminanFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }


    @Override
    public void onGetBuktiKepemilikanSuccess(List<BuktiKepemilikanAgunanModel> list) {
        if (spBuktiKepemilikanAngunan.getSelectedItemPosition() > 0 && spBuktiKepemilikanAngunan.getSelectedItem() instanceof BuktiKepemilikanAgunanModel) {
            BuktiKepemilikanAgunanModel model = (BuktiKepemilikanAgunanModel) spBuktiKepemilikanAngunan.getSelectedItem();
            if (model != null) {
                DataManager.getInstance().setBuktiKepemilikanAgunanModelList(model.getId(), list);
            }
        }

        WidgetUtil.setDataMasterAdapter(spBuktiKepemilikanAngunan, list);
        if (jaminanModel != null) {
            spBuktiKepemilikanAngunan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spBuktiKepemilikanAngunan, jaminanModel.getBuktiKepemilikan()));
        }
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetBuktiKepemilikanFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
