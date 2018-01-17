package com.example.saifullah_albasrie.pnm.rest;

/**
 * Created by saifullahalbasrie on 3/23/17.
 */

public class ApiConstant {
    //public static final String BASE_URL_SSO = "http://182.23.52.249/WebService/SSO_Mobile/";
    public static final String BASE_URL_SSO = "http://103.76.17.197/WebService/SSO_Mobile/";
    public static final String BASE_URL = "http://azha.ddns.net:8080/restapi/";
    public static final String BASE_URL_MASTERDATA = "http://182.23.52.249/PNM/api/v1/master/lov_global/";
    public static final String BASE_URL_POST = "http://182.23.52.249/PNM/api/v1/";
//    public static final String BASE_URL = "http://27.50.31.76:9696/restapi/";

    public static final String USER_AUTH_SSO = "event";
    public static final String PASSWORD_AUTH_SSO = "event";

    public static final String USER_AUTH = "username";
    public static final String PASSWORD_AUTH = "password";

    //public static final String LOGIN_SSO = "http://182.23.52.249/WebService/SSO_Mobile/login.php";
    public static final String LOGIN_SSO = BASE_URL_SSO + "login.php";
    //public static final String LOGIN_API = "http://azha.ddns.net:8080/restapi/login";
    public static final String LOGIN_API = BASE_URL + "login";
    public static final String LOGOUT = "logout";
    public static final String FIREBASE_ID = "firebase";

    public static final int PAGE_LIMIT_SIZE = 10;

    public static String CHECK_DEBITUR_BY_NAME = "http://182.23.52.252:3333/DATA/GetByNamaNasabah";
    public static String CHECK_DEBITUR_BY_NOMOR_REKEKING = "http://182.23.52.252:3333/DATA/GetByNoRekening";
    public static String CHECK_DEBITUR_BY_IBU_KANDUNG = "http://182.23.52.252:3333/DATA/GetByNamaIbuKandung";
    public static String CHECK_DEBITUR_BY_TANGGAL_LAHIR = "http://182.23.52.252:3333/DATA/GetByTanggalLahir";
    //public static String GET_LIST_COLLECTION = "http://182.23.52.252:3333/DATA/GetList";
    public static String GET_LIST_COLLECTION = "http://182.23.52.252:3333/Collection/GetByKodeUnit";
    //public static final String GET_HISTORY_PEMBIAYAAN = "http://182.23.52.249/PNM/api/v1/mms/get_riwayat_angsuran/{no_rek}";
    public static final String GET_HISTORY_PEMBIAYAAN = "http://182.23.52.249/PNM/api/v1/mms/get_rekening_debitur/{nasabah_id}";

    public static final String GET_COLLECTION_DETAIL = "collection";
    public static final String SAVE_COLLECTION_DETAIL = "collection/insert";

    public static final String JENIS_PROSPEK = "jenisProspek";
    public static final String JENIS_USAHA = "jenisUsaha";

    public static final String KODE_USAHA = "kodeusaha";
    public static final String BIDANG_USAHA = "kodebidangusaha";
    public static final String HUB_DENGAN_PNM = "hubunganPNM";
    public static final String HUB_DENGAN_BANK = "hubunganBANK";

    public static final String MASTER_PRODUK = "masterProduk";
    public static final String MASTER_PROGRAM = "masterProgram";
    public static final String MASTER_JENIS_AGUNAN = "jenisAgunan";

    public static final String MASTER_PROVINSI = "wilayah/provinsi";
    public static final String MASTER_KABUPATEN = "wilayah/kab_kota";
    public static final String MASTER_KECAMATAN = "wilayah/kecamatan";
    public static final String MASTER_KELURAHAN = "wilayah/kelurahan";

    public static final String MASTER_GELAR = "gelar";
    public static final String MASTER_PENDIDIKAN_TERAKHIR = "pendidikanTerakhir";
    public static final String MASTER_JENIS_DOKUMEN = "jenisDokumen";
    public static final String MASTER_JENIS_HARTA = "hartabenda";
    public static final String MASTER_JENIS_PEKERJAAN = "pekerjaan";
    public static final String MASTER_JENIS_PRODUK_USAHA = "jenisProdukUsaha";
    public static final String MASTER_PENGELOLAAN_KEUANGAN = "pengelolaanKeuangan";

    // master jaminan
    public static final String MASTER_ATAP = "konstruksiBangunan/atap";
    public static final String MASTER_DINDING = "konstruksiBangunan/dinding";
    public static final String MASTER_JENDELA = "konstruksiBangunan/jendela";
    public static final String MASTER_KUSEN = "konstruksiBangunan/kusen";
    public static final String MASTER_LANTAI = "konstruksiBangunan/lantai";
    public static final String MASTER_PINTU = "konstruksiBangunan/pintu";
    public static final String MASTER_PLAFON = "konstruksiBangunan/plafon";
    public static final String MASTER_PONDASI = "konstruksiBangunan/pondasi";

    public static final String MASTER_BATAS_WILAYAH = "keadaanTanah/batasWilayah";
    public static final String MASTER_BENTUK_TANAH = "keadaanTanah/bentuktanah";
    public static final String MASTER_KONDISI_PERMUKAAN_TANAH = "keadaanTanah/kondisiPermukaanTanah";
    public static final String MASTER_PENGGUNAAN_TANAH = "keadaanTanah/penggunaanTanah";
    public static final String MASTER_STATUS_TANAH = "keadaanTanah/statusTanah";

    public static final String MASTER_JENIS_BUKTI_KEPEMILIKAN_ANGUNAN = "jenisBukti";
    public static final String MASTER_BUKTI_KEPEMILIKAN_ANGUNAN = "buktikepemilikanagunan";
    public static final String MASTER_PENGELOLAAN_USAHA = "pengelolaanUsaha";
    public static final String MASTER_JALAN_DILALUI = "jalandilalui";
    public static final String MASTER_PERUNTUKAN_LOKASI = "peruntukanlokasi";
    public static final String MASTER_SALURAN_AIR = "saluranair";
    public static final String MASTER_SALURAN_TELEPON = "salurantelepon";
    //end master jaminan


    public static final String GET_LIST_PROSPEK = "prospek/getprospekpagination"; //getProspek";
    public static final String GET_GENERAL_PROSPEK = "prospek/getGeneralProspek";
    public static final String SAVE_PROSPEK = "prospek/newJson";
    public static final String EDIT_PROSPEK = "prospek/editJson";
    public static final String AUTOSAVE_PROSPEK = "prospek/autosaved";

    public static final String GET_LIST_PROSPEK_DETAIL = "detilprospek";
    public static final String GET_GENERAL_PROSPEK_DETAIL = "detilprospek/detilDebitur";
    public static final String EDIT_PROSPEK_DETAIL = "detilprospek/editJson";

    public static final String GET_LIST_SURVEY = "survey";
    public static final String GET_SURVEY_CHECKLIST = "survey/survey_listForm";
    public static final String GET_SURVEY_DETAIL = "survey/survey";
    public static final String SAVE_SURVEY_DETAIL = "survey/survey";
    public static final String GET_SURVEY_PROFILKARAKTER = "profildankarakter";
    public static final String SAVE_SURVEY_PROFILKARAKTER = "profildankarakter/profilKarakter";
    public static final String GET_SURVEY_KAPASITAS_USAHA = "survey/kapasitas_usaha";
    public static final String SAVE_SURVEY_KAPASITAS_USAHA = "survey/kapasitas_usaha";
    public static final String GET_SURVEY_JENIS_USAHA = "survey/jenis_usaha";
    public static final String SAVE_SURVEY_JENIS_USAHA = "survey/jenis_usaha";
    public static final String GET_SURVEY_KEUANGAN = "survey/keuangan";
    public static final String SAVE_SURVEY_KEUANGAN = "survey/keuangan";
    public static final String GET_SURVEY_KMK = "survey/kebutuhanModalKerja";
    public static final String SAVE_SURVEY_KMK = "survey/kebutuhanModalKerja";
    public static final String GET_SURVEY_KELUARGA = "survey/keluarga";
    public static final String SAVE_SURVEY_KELUARGA = "survey/keluarga";
    public static final String GET_SURVEY_LIST_JAMINAN = "survey/jaminan";
    public static final String GET_SURVEY_JAMINAN = "survey/getjaminan";
    public static final String SAVE_SURVEY_JAMINAN = "survey/jaminan";

    public static final String GET_SURVEY_DOKUMEN_CHECKLIST = "upload/count_image";
    public static final String GET_SURVEY_DOKUMEN = "upload/show_file";
    public static final String UPLOAD_SURVEY_DOKUMEN = "upload/store_image";
    public static final String DELETE_SURVEY_DOKUMEN = "upload/delete_photo";

    public static final String SEND_CHECK_SID = "survey/cekSID";
    public static final String SEND_CHECK_SID_KELUARGA = "survey/cekSIDkeluarga";
    public static final String SEND_PENGAJUAN_SURVEY = "survey/kirim_pengajuan";

    //public static final String CHECK_IDI = "CheckIDI";
    public static final String CHECK_IDI = "http://27.50.31.76:9696/restapi/CheckIDI";

    public static final String GET_LIST_HISTORICAL = "historical";
    public static final String GET_LIST_FEEDBACK = "feedback";


    public static final String GET_LIST_PROSPEK_DETAIL_MU = "prospek_mu/getProspek";
    public static final String GET_GENERAL_PROSPEK_DETAIL_MU = "detilprospek/detilDebitur";//"prospek_mu/detilDebitur";
    public static final String APPROVAL_PROSPEK_DETAIL_MU = "prospek_mu/approval";

    public static final String GET_LIST_PENGAJUAN_MU = "survey_mu/getSurvey";
    public static final String APPROVAL_PENGAJUAN_MU = "survey_mu/approval";

    public static final String GET_LIST_HISTORICAL_MU = "historical_mu";
    public static final String GET_LIST_BANDING = "banding";
    public static final String APPROVAL_BANDING = "banding/approval";

    public static final String JENIS_IDENTITAS = "MS_JENIS_IDENTITAS_ID";
    public static final String JENIS_KELAMIN = "MS_JENIS_KELAMIN_ID";
    public static final String JENIS_USAHA_NEW = "MS_JENIS_USAHA_ID";
    public static final String JENIS_REFERENSI = "MS_JENIS_REFERENSI_ID";
    public static final String STATUS_PERKAWINAN = "MS_STATUS_PERKAWINAN_ID";
    public static final String KEWARGANEGARAAN = "MS_KEWARGANEGARAAN_ID";
    public static final String AGAMA = "MS_AGAMA_ID";
    public static final String PEKERJAAN = "MS_PEKERJAAN_ID";
    public static final String JENIS_ALAMAT = "MS_JENIS_ALAMAT_ID";
    public static final String HUBUNGAN_KELUARGA = "MS_HUBUNGAN_KELUARGA_ID";
    public static final String TUJUAN_PEMBIAYAAN = "MS_TUJUAN_PEMBIAYAAN_ID";
    public static final String JENIS_AGUNAN = "MS_JENIS_AGUNAN_ID";

    public static final String JENIS_KONTAK = "MS_JENIS_KONTAK_ID";
    public static final String STATUS_TEMPAT = "MS_STATUS_TEMPAT_ID";
    public static final String PENDIDIKAN = "MS_PENDIDIKAN_ID";
    public static final String PRODUK = "MS_PRODUK_ID";
    public static final String JENIS_DOKUMEN = "MS_JENIS_DOKUMEN_ID";
    public static final String JENIS_PEMBIAYAAN = "MS_JENIS_PEMBIAYAAN_ID";
    public static final String LOKASI = "MS_LOKASI_ID";
    public static final String HUBUNGAN_PEMOHON = "MS_HUBUNGAN_PEMOHON_ID";
    public static final String KERJASAMA_PEMOHON = "MS_KERJASAMA_PEMOHON_ID";
    public static final String TRACK_RECORD = "MS_TRACK_RECORD_ID";
    public static final String MENGENAL_ULAMM = "MS_MENGENAL_ULAMM_ID";
    public static final String REPUTASI = "MS_REPUTASI_ID";
    public static final String HARTA = "MS_HARTA_ID";
    public static final String PENGELOLAAN_KEUANGAN = "MS_PENGELOLAAN_KEUANGAN_ID";
    public static final String BENTUK_USAHA = "MS_BENTUK_USAHA_ID";
    public static final String JENIS_BADAN_USAHA = "MS_JENIS_BADAN_USAHA_ID";
    public static final String KEGIATAN_USAHA = "MS_KEGIATAN_USAHA_ID";
    public static final String AKSES_KENDARAAN = "MS_AKSES_KENDARAAN_ID";
    public static final String PRODUK_DITAWARKAN = "MS_PRODUK_DITAWARKAN_ID";
    public static final String JML_PEMASOK = "MS_JML_PEMASOK_ID";

    public static final String PERSAINGAN_USAHA = "MS_PERSAINGAN_USAHA_ID";
    public static final String KONDISI_SEKTOR_USAHA = "MS_KONDISI_SEKTOR_USAHA_ID";
    public static final String LOKASI_USAHA = "MS_LOKASI_USAHA_ID";
    public static final String PERIODE = "MS_PERIODE_ID";
    public static final String PEMBAYARAN = "MS_PEMBAYARAN_ID";
    public static final String PROGRAM = "MS_PROGRAM_ID";
    public static final String BANK = "MS_BANK_ID";
    public static final String KOLEKTIBILITAS = "MS_KOLEKTIBILITAS_ID";
    public static final String JENIS_ASSET = "MS_JENIS_ASSET_ID";
    public static final String PENILAIAN = "MS_PENILAIAN_ID";
    public static final String KEPEMILIKAN = "MS_KEPEMILIKAN_ID";
    public static final String BUKTI_KEPEMILIKAN_AGUNAN = "MS_BUKTI_KEPEMILIKAN_AGUNAN_ID";
    public static final String PERUNTUKAN_LOKASI = "MS_PERUNTUKAN_LOKASI_ID";
    public static final String JALAN_DILALUI = "MS_JALAN_DILALUI_ID";
    public static final String BENTUK_TANAH = "MS_BENTUK_TANAH_ID";
    public static final String KONDISI_PERMUKAAN = "MS_KONDISI_PERMUKAAN_ID";
    public static final String PENGGUNAAN_TANAH = "MS_PENGGUNAAN_TANAH_ID";
    public static final String BATAS = "MS_BATAS_ID";
    public static final String AIR = "MS_AIR_ID";
    public static final String PONDASI = "MS_PONDASI_ID";

    public static final String LANTAI = "MS_LANTAI_ID";
    public static final String DINDING = "MS_DINDING_ID";
    public static final String PLAFON = "MS_PLAFON_ID";
    public static final String KUSEN = "MS_KUSEN_ID";
    public static final String ATAP = "MS_ATAP_ID";
    public static final String PINTU = "MS_PINTU_ID";
    public static final String JENDELA = "MS_JENDELA_ID";
    public static final String JENIS_CATATAN = "MS_JENIS_CATATAN_ID";
    public static final String TUJUAN_PENGIRIMAN = "MS_TUJUAN_PENGIRIMAN_ID";
    public static final String KEPERLUAN_PINJAM = "MS_KEPERLUAN_PINJAM_ID";
    public static final String BISNIS = "MS_BISNIS_ID";
    public static final String JABATAN = "MS_JABATAN_ID";
    public static final String STATUS_PINJAM_AGUNAN = "MS_STATUS_PINJAM_AGUNAN_ID";
    public static final String STATUS_PELEPASAN_AGUNAN = "MS_STATUS_PELEPASAN_AGUNAN_ID";
    public static final String PEMINJAM_AGUNAN = "MS_PEMINJAM_AGUNAN_ID";
    public static final String REKENING_TUJUAN_JENIS = "MS_REKENING_TUJUAN_JENIS_ID";
    public static final String SUMBER_DANA = "MS_SUMBER_DANA_ID";
    public static final String PROFESI_NOTARIS = "MS_PROFESI_NOTARIS_ID";
    public static final String JENIS_GAMBARAN_UMUM_REVIEW = "MS_JENIS_GAMBARAN_UMUM_REVIEW";
    public static final String KONDISI_TEMPAT_USAHA = "MS_KONDISI_TEMPAT_USAHA_ID";
    public static final String KETERSEDIAAN_BAHAN_BAKU = "MS_KETERSEDIAAN_BAHAN_BAKU_ID";
    public static final String GOLONGAN_PENJAMIN = "MS_GOLONGAN_PENJAMINAN_ID";
    public static final String STATUS_ASURANSI_AGUNAN = "MS_STATUS_ASURANSI_AGUNAN_ID";
    public static final String GOLONGAN_KREDIT = "MS_GOLONGAN_KREDIT_ID";
    public static final String NAMA_PENGADILAN_NEGERI = "MS_NAMA_PENGADILAN_NEGERI_ID";
    public static final String JENIS_PRODUK = "MS_JENIS_PRODUK_ID";
    public static final String JENIS_SUMBER_DANA = "MS_JENIS_SUMBER_DANA_ID";
    public static final String JENIS_DCA_ID = "MS_JENIS_DCA_ID";
    public static final String POLA_PENCAIRAN = "MS_POLA_PENCAIRAN_ID";
    public static final String NILAI_PENCAIRAN = "MS_NILAI_PENCAIRAN_ID";

    public static final String MATA_UANG = "MS_MATA_UANG_ID";
    public static final String LOKASI_PRODUK = "MS_LOKASI_PRODUK_ID";
    public static final String REG_PRO = "MS_REG_PRO_ID";
    public static final String JENIS_SUKU_BUNGA = "MS_JENIS_SUKU_BUNGA_ID";
    public static final String JENIS_PEMBAYARAN_PRODUK = "MS_JENIS_PEMBAYARAN_PRODUK_ID";
    public static final String JENIS_PERHITUNGAN_BUNGA = "MS_JENIS_PERHITUNGAN_BUNGA_ID";
    public static final String JADWAL_PERHITUNGAN_BUNGA = "MS_JADWAL_PERHITUNGAN_BUNGA_ID";
    public static final String JENIS_PEMOTONGAN_BUNGA = "MS_JENIS_PEMOTONGAN_BUNGA_ID";
    public static final String STRUKTUR_HARI_DALAM_SATU_TAHUN = "MS_STRUKTUR_KREDIT_HARI_DALAM_SATU_TAHUN_ID";
    public static final String STRUKTUR_HARI_DALAM_SATU_BULAN = "MS_STRUKTUR_KREDIT_HARI_DALAM_SATU_BULAN_ID";
    public static final String STRUKTUR_KREDIT_HARI_LIBUR = "MS_STRUKTUR_KREDIT_HARI_LIBUR_ID";
    public static final String STRUKTUR_KREDIT_HARI_BIAYA = "MS_STRUKTUR_KREDIT_NILAI_BIAYA_ID";
    public static final String KATEGORI_PEMBIAYAAN = "MS_KATEGORI_PEMBIAYAAN_ID";

    public static final String POST_PROSPEK = "prospek/insert_wizard";
    public static final String UPDATE_PROSPEK = "prospek/update_individu";
    public static final String KONTAK_PROSPEK = "prospek/set_individu_kontak";
    public static final String ALAMAT_PROSPEK = "prospek/set_individu_alamat";
    public static final String KELUARGA_PROSPEK = "prospek/set_individu_keluarga";
    public static final String PEMBIAYAAN_PROSPEK = "prospek/set_individu_pembiayaan";
    public static final String AGUNAN_PROSPEK = "prospek/set_individu_agunan";
    public static final String UPLOAD_DOKUMEN = "prospek/set_individu_dokumen";
    public static final String USAHA_PROSPEK = "prospek/set_individu_usaha";
    public static final String KUNJUNGAN_AOM = "prospek/set_individu_kunjungan";
    public static final String NILAI_AGUNAN = "survey/set_nilai_agunan";










}
