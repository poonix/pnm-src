package com.example.saifullah_albasrie.pnm.rest;

import com.example.saifullah_albasrie.pnm.model.master_new.BaseResponseNew;
import com.example.saifullah_albasrie.pnm.model.production_model.AgunanProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.AktifitasRekBankModel;
import com.example.saifullah_albasrie.pnm.model.production_model.AlamatProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DataUsahaModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteAktifitasRekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteAssetModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteKunjunganUsahaAOMModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteNilaiAgunanModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteNoteSurveyModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeletePinjamanLainnyaModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteRABModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteRencanaAgunanModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteSumberReputasiModel;
import com.example.saifullah_albasrie.pnm.model.production_model.DeleteUsahaModel;
import com.example.saifullah_albasrie.pnm.model.production_model.InsertProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.KeluargaProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.KontakProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.KunjunganAomModel;
import com.example.saifullah_albasrie.pnm.model.production_model.KunjunganUsahaModel;
import com.example.saifullah_albasrie.pnm.model.production_model.NilaiAgunanModel;
import com.example.saifullah_albasrie.pnm.model.production_model.PembiayaanProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.PinjamanLainModel;
import com.example.saifullah_albasrie.pnm.model.production_model.RABModel;
import com.example.saifullah_albasrie.pnm.model.production_model.SumberReputasiModel;
import com.example.saifullah_albasrie.pnm.model.production_model.SurveyAssetModel;
import com.example.saifullah_albasrie.pnm.model.production_model.UpdateProspekModel;
import com.example.saifullah_albasrie.pnm.model.production_model.UploadDokumenModel;
import com.example.saifullah_albasrie.pnm.model.production_model.UsahaProspekModel;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalBandingRequest;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalPengajuanRequest;
import com.example.saifullah_albasrie.pnm.rest.request.ApprovalProspekRequest;
import com.example.saifullah_albasrie.pnm.rest.request.CheckSIDRequest;
import com.example.saifullah_albasrie.pnm.rest.request.CollectionRequest;
import com.example.saifullah_albasrie.pnm.rest.request.FirebaseIDRequest;
import com.example.saifullah_albasrie.pnm.rest.request.KapasitasUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.request.KebutuhanModalKerjaRequest;
import com.example.saifullah_albasrie.pnm.rest.request.ProfilKarakterRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyDetailRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyJaminanRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyJenisUsahaRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeluargaRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyKeuanganRequest;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyPengajuanRequest;
import com.example.saifullah_albasrie.pnm.rest.response.AutoSaveResponse;
import com.example.saifullah_albasrie.pnm.rest.response.BandingListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CheckDebiturResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionResponse;
import com.example.saifullah_albasrie.pnm.rest.response.FeedbackListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekDetailResponse;
import com.example.saifullah_albasrie.pnm.rest.response.GeneralProspekResponse;
import com.example.saifullah_albasrie.pnm.rest.response.HistoricalListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.HistoryAngsuranListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.HubDgnBankResponse;
import com.example.saifullah_albasrie.pnm.rest.response.HubDgnPNMResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisDokumenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisHartaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisPekerjaanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisProdukUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisProspekResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KapasitasUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KebutuhanModalKerjaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KodeBidangUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KodeUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.LoginResponse;
import com.example.saifullah_albasrie.pnm.rest.response.LoginSSOResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterGelarResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterJenisAgunanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKabupatenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKecamatanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterKelurahanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterPendidikanTerakhirResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProdukResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProgramResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProvinsiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.PengelolaanKeuanganResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProfilKarakterResponse;
import com.example.saifullah_albasrie.pnm.rest.response.ProspekListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyChecklistResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenUploadResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJaminanListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJaminanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyJenisUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeluargaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyKeuanganResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyListResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterAtapResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterBatasWilayahResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterBentukTanahResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterBuktiKepemilikanAgunanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterDindingResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterJalanDilaluiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterJendelaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterJenisBuktiKepemilikanAgunanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterKondisiPermukaanTanahResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterKusenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterLantaiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPengelolaanUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPenggunaanTanahResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPeruntukanLokasiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPintuResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPlafonResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterPondasiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterSaluranAirResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterSaluranTeleponResponse;
import com.example.saifullah_albasrie.pnm.rest.response.jaminan.MasterStatusTanahResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by saifullahalbasrie on 3/23/17.
 */

public interface RestService {


    @GET //(ApiConstant.LOGIN_SSO)
    Call<LoginSSOResponse> loginSSO(
            @Url String url,
            @Query("user") String user,
            @Query("pass") String password,
            @Query("app_code") String appCode
    );

    @GET //(ApiConstant.LOGIN_API)
    Call<LoginResponse> loginAPI(
            @Url String url,
            @Query("idsdm") String idSDM
    );

    @GET(ApiConstant.LOGOUT)
    Call<BaseResponse> logout(
            @Query("id_user") String idSDM
    );

    @POST(ApiConstant.FIREBASE_ID)
    Call<BaseResponse> sendFcmId(
            @Body FirebaseIDRequest body
    );

    @GET
    Call<CheckDebiturResponse> checkDebitur(
            @Url String url,
            @Query("id") String keyword
    );


    @GET
    Call<CheckDebiturResponse> checkIDI(
            @Url String url,
            @Query("nama") String nama,
            @Query("ibu") String ibu,
            @Query("tgl_lahir") String tgl_lahir,
            @Query("tempat_lahir") String tempat_lahir,
            @Query("jenis_kelamin") String jenis_kelamin,
            @Query("jenis_identitas") String jenis_identitas,
            @Query("no_identitas") String no_identitas
    );

    // === Api Data Master === //

    /*edit 17 Januari 2018 by Yudhi */
    @GET(ApiConstant.JENIS_IDENTITAS)
    Call<List<BaseResponseNew>> getJenisIdentitas(
    );

    @GET(ApiConstant.JENIS_KELAMIN)
    Call<List<BaseResponseNew>> getJenisKelamin(
    );

    @GET(ApiConstant.JENIS_USAHA_NEW)
    Call<List<BaseResponseNew>> getJenisUsahaNew(
    );

    @GET(ApiConstant.JENIS_REFERENSI)
    Call<List<BaseResponseNew>> getJenisReferensi(
    );

    @GET(ApiConstant.STATUS_PERKAWINAN)
    Call<List<BaseResponseNew>> getStatusPerkawinan(
    );

    @GET(ApiConstant.KEWARGANEGARAAN)
    Call<List<BaseResponseNew>> getKewaganegaraan(
    );

    @GET(ApiConstant.AGAMA)
    Call<List<BaseResponseNew>> getAgama(
    );

    @GET(ApiConstant.PEKERJAAN)
    Call<List<BaseResponseNew>> getPekerjaan(
    );

    @GET(ApiConstant.JENIS_ALAMAT)
    Call<List<BaseResponseNew>> getJenisAlamat(
    );

    @GET(ApiConstant.HUBUNGAN_KELUARGA)
    Call<List<BaseResponseNew>> getHubunganKeluarga(
    );

    @GET(ApiConstant.TUJUAN_PEMBIAYAAN)
    Call<List<BaseResponseNew>> getTujuanPembiayaan(
    );

    @GET(ApiConstant.JENIS_AGUNAN)
    Call<List<BaseResponseNew>> getJenisAgunan(
    );

    @GET(ApiConstant.JENIS_KONTAK)
    Call<List<BaseResponseNew>> getJenisKontak(
    );

    @GET(ApiConstant.STATUS_TEMPAT)
    Call<List<BaseResponseNew>> getStatusTempat(
    );


    @GET(ApiConstant.PENDIDIKAN)
    Call<List<BaseResponseNew>> getPendidikan(
    );


    @GET(ApiConstant.PRODUK)
    Call<List<BaseResponseNew>> getProduk(
    );


    @GET(ApiConstant.JENIS_DOKUMEN)
    Call<List<BaseResponseNew>> getJenisDokumen(
    );


    @GET(ApiConstant.JENIS_PEMBIAYAAN)
    Call<List<BaseResponseNew>> getJenisPembiayaan(
    );


    @GET(ApiConstant.LOKASI)
    Call<List<BaseResponseNew>> getLokasi(
    );


    @GET(ApiConstant.HUBUNGAN_PEMOHON)
    Call<List<BaseResponseNew>> getHubPemohon(
    );


    @GET(ApiConstant.KERJASAMA_PEMOHON)
    Call<List<BaseResponseNew>> getKerjasamaPemohon(
    );


    @GET(ApiConstant.TRACK_RECORD)
    Call<List<BaseResponseNew>> getTrackRecord(
    );


    @GET(ApiConstant.MENGENAL_ULAMM)
    Call<List<BaseResponseNew>> getMengenalUlamm(
    );


    @GET(ApiConstant.REPUTASI)
    Call<List<BaseResponseNew>> getReputasi(
    );

    @GET(ApiConstant.HARTA)
    Call<List<BaseResponseNew>> getHarta(
    );

    @GET(ApiConstant.PENGELOLAAN_KEUANGAN)
    Call<List<BaseResponseNew>> getPengelolaanKeuangan(
    );

    @GET(ApiConstant.BENTUK_USAHA)
    Call<List<BaseResponseNew>> getBentukUsaha(
    );

    @GET(ApiConstant.JENIS_BADAN_USAHA)
    Call<List<BaseResponseNew>> getJenisBadanUsaha(
    );

    @GET(ApiConstant.KEGIATAN_USAHA)
    Call<List<BaseResponseNew>> getKegiatanUsaha(
    );

    @GET(ApiConstant.AKSES_KENDARAAN)
    Call<List<BaseResponseNew>> getAksesKendaraan(
    );

    @GET(ApiConstant.PRODUK_DITAWARKAN)
    Call<List<BaseResponseNew>> getProdDitawarkan(
    );

    @GET(ApiConstant.JML_PEMASOK)
    Call<List<BaseResponseNew>> getJmlPemasok(
    );

    @GET(ApiConstant.PERSAINGAN_USAHA)
    Call<List<BaseResponseNew>> getPersainganUsaha(
    );

    @GET(ApiConstant.KONDISI_SEKTOR_USAHA)
    Call<List<BaseResponseNew>> getKondSekUsaha(
    );

    @GET(ApiConstant.LOKASI_USAHA)
    Call<List<BaseResponseNew>> getLokasiUsaha(
    );

    @GET(ApiConstant.PERIODE)
    Call<List<BaseResponseNew>> getPeriode(
    );

    @GET(ApiConstant.PEMBAYARAN)
    Call<List<BaseResponseNew>> getpembayaran(
    );

    @GET(ApiConstant.PROGRAM)
    Call<List<BaseResponseNew>> getProgram(
    );

    @GET(ApiConstant.BANK)
    Call<List<BaseResponseNew>> getBank(
    );

    @GET(ApiConstant.KOLEKTIBILITAS)
    Call<List<BaseResponseNew>> getKolektibilitas(
    );

    @GET(ApiConstant.JENIS_ASSET)
    Call<List<BaseResponseNew>> getJenisAsset(
    );

    @GET(ApiConstant.PENILAIAN)
    Call<List<BaseResponseNew>> getPenilaian(
    );

    @GET(ApiConstant.KEPEMILIKAN)
    Call<List<BaseResponseNew>> getKepemilikan(
    );

    @GET(ApiConstant.BUKTI_KEPEMILIKAN_AGUNAN)
    Call<List<BaseResponseNew>> getBuktiKepAgunan(
    );

    @GET(ApiConstant.PERUNTUKAN_LOKASI)
    Call<List<BaseResponseNew>> getPeruntukanLokasi(
    );

    @GET(ApiConstant.JALAN_DILALUI)
    Call<List<BaseResponseNew>> getJalanDilalui(
    );

    @GET(ApiConstant.BENTUK_TANAH)
    Call<List<BaseResponseNew>> getBentukTanah(
    );

    @GET(ApiConstant.KONDISI_PERMUKAAN)
    Call<List<BaseResponseNew>> getKondisiPermukaan(
    );

    @GET(ApiConstant.PENGGUNAAN_TANAH)
    Call<List<BaseResponseNew>> getPenggunaanTanah(
    );

    @GET(ApiConstant.BATAS)
    Call<List<BaseResponseNew>> getBatas(
    );

    @GET(ApiConstant.AIR)
    Call<List<BaseResponseNew>> getAir(
    );

    @GET(ApiConstant.PONDASI)
    Call<List<BaseResponseNew>> getPondasi(
    );

    @GET(ApiConstant.LANTAI)
    Call<List<BaseResponseNew>> getLantai(
    );

    @GET(ApiConstant.DINDING)
    Call<List<BaseResponseNew>> getDinding(
    );

    @GET(ApiConstant.PLAFON)
    Call<List<BaseResponseNew>> getPlafon(
    );

    @GET(ApiConstant.KUSEN)
    Call<List<BaseResponseNew>> getKusen(
    );

    @GET(ApiConstant.ATAP)
    Call<List<BaseResponseNew>> getAtap(
    );

    @GET(ApiConstant.PINTU)
    Call<List<BaseResponseNew>> getPintu(
    );

    @GET(ApiConstant.JENDELA)
    Call<List<BaseResponseNew>> getJendela(
    );

    @GET(ApiConstant.JENIS_CATATAN)
    Call<List<BaseResponseNew>> getJenisCatatan(
    );

    @GET(ApiConstant.TUJUAN_PENGIRIMAN)
    Call<List<BaseResponseNew>> getTujuanPengiriman(
    );

    @GET(ApiConstant.KEPERLUAN_PINJAM)
    Call<List<BaseResponseNew>> getKeperluanPinjam(
    );

    @GET(ApiConstant.BISNIS)
    Call<List<BaseResponseNew>> getBisnis(
    );

    @GET(ApiConstant.JABATAN)
    Call<List<BaseResponseNew>> getJabatan(
    );


    @GET(ApiConstant.STATUS_PINJAM_AGUNAN)
    Call<List<BaseResponseNew>> getStatusPinjamAgunan(
    );


    @GET(ApiConstant.STATUS_PELEPASAN_AGUNAN)
    Call<List<BaseResponseNew>> getStatusPelepasanAgunan(
    );


    @GET(ApiConstant.PEMINJAM_AGUNAN)
    Call<List<BaseResponseNew>> getPeminjamAgunan(
    );


    @GET(ApiConstant.REKENING_TUJUAN_JENIS)
    Call<List<BaseResponseNew>> getRekeningTujuanBisnis(
    );


    @GET(ApiConstant.SUMBER_DANA)
    Call<List<BaseResponseNew>> getSumberDana(
    );


    @GET(ApiConstant.PROFESI_NOTARIS)
    Call<List<BaseResponseNew>> getProfesiNotaris(
    );


    @GET(ApiConstant.JENIS_GAMBARAN_UMUM_REVIEW)
    Call<List<BaseResponseNew>> getJenisGambaranUmumReview(
    );


    @GET(ApiConstant.KONDISI_TEMPAT_USAHA)
    Call<List<BaseResponseNew>> getKondisiTempatUsaha(
    );


    @GET(ApiConstant.KETERSEDIAAN_BAHAN_BAKU)
    Call<List<BaseResponseNew>> getKetersediaanBahanBaku(
    );


    @GET(ApiConstant.GOLONGAN_PENJAMIN)
    Call<List<BaseResponseNew>> getGolonganPenjamin(
    );


    @GET(ApiConstant.STATUS_ASURANSI_AGUNAN)
    Call<List<BaseResponseNew>> getStatusAsuransiAgunan(
    );


    @GET(ApiConstant.GOLONGAN_KREDIT)
    Call<List<BaseResponseNew>> getGolonganKredit(
    );


    @GET(ApiConstant.NAMA_PENGADILAN_NEGERI)
    Call<List<BaseResponseNew>> getNamaPengadilanNegeri(
    );


    @GET(ApiConstant.JENIS_PRODUK)
    Call<List<BaseResponseNew>> getJenisProduk(
    );


    @GET(ApiConstant.JENIS_SUMBER_DANA)
    Call<List<BaseResponseNew>> getJenisSumberDana(
    );


    @GET(ApiConstant.JENIS_DCA_ID)
    Call<List<BaseResponseNew>> getJenisDCAID(
    );


    @GET(ApiConstant.POLA_PENCAIRAN)
    Call<List<BaseResponseNew>> getPolaPencairan(
    );


    @GET(ApiConstant.NILAI_PENCAIRAN)
    Call<List<BaseResponseNew>> getNilaiPencairan(
    );


    @GET(ApiConstant.MATA_UANG)
    Call<List<BaseResponseNew>> getMataUang(
    );

    @GET(ApiConstant.LOKASI_PRODUK)
    Call<List<BaseResponseNew>> getLokasiProduk(
    );

    @GET(ApiConstant.REG_PRO)
    Call<List<BaseResponseNew>> getRegPro(
    );

    @GET(ApiConstant.JENIS_SUKU_BUNGA)
    Call<List<BaseResponseNew>> getJenisSukuBunga(
    );

    @GET(ApiConstant.JENIS_PEMBAYARAN_PRODUK)
    Call<List<BaseResponseNew>> getJenisPembayaranProduk(
    );

    @GET(ApiConstant.JENIS_PERHITUNGAN_BUNGA)
    Call<List<BaseResponseNew>> getJenisPerhitunganBunga(
    );

    @GET(ApiConstant.JADWAL_PERHITUNGAN_BUNGA)
    Call<List<BaseResponseNew>> getJadwalPerhitunganBunga(
    );

    @GET(ApiConstant.JENIS_PEMOTONGAN_BUNGA)
    Call<List<BaseResponseNew>> getJenisPemotonganBunga(
    );

    @GET(ApiConstant.STRUKTUR_HARI_DALAM_SATU_TAHUN)
    Call<List<BaseResponseNew>> getStrukturHariDalamSatuTahun(
    );

    @GET(ApiConstant.STRUKTUR_HARI_DALAM_SATU_BULAN)
    Call<List<BaseResponseNew>> getStrukurHariDalamSatuBulan(
    );

    @GET(ApiConstant.STRUKTUR_KREDIT_HARI_LIBUR)
    Call<List<BaseResponseNew>> getStrukturKreditHariLibur(
    );

    @GET(ApiConstant.STRUKTUR_KREDIT_HARI_BIAYA)
    Call<List<BaseResponseNew>> getStrukturKreditHariBiaya(
    );

    @GET(ApiConstant.KATEGORI_PEMBIAYAAN)
    Call<List<BaseResponseNew>> getKategoriPembiayaan(
    );

    /*edited 17 Januari 2018 by Yudhi*/

    @GET(ApiConstant.JENIS_PROSPEK)
    Call<JenisProspekResponse> getJenisProspek(
    );

    @GET(ApiConstant.JENIS_USAHA)
    Call<JenisUsahaResponse> getJenisUsaha(
    );

    @GET(ApiConstant.BIDANG_USAHA)
    Call<KodeBidangUsahaResponse> getKodeBidangUsaha(
    );

    @GET(ApiConstant.KODE_USAHA)
    Call<KodeUsahaResponse> getKodeUsaha(
    );

    @GET(ApiConstant.HUB_DENGAN_BANK)
    Call<HubDgnBankResponse> getHubunganBank(
    );

    @GET(ApiConstant.HUB_DENGAN_PNM)
    Call<HubDgnPNMResponse> getHubunganPNM(
    );

    @GET(ApiConstant.MASTER_PRODUK)
    Call<MasterProdukResponse> getMasterProduk(
    );

    @GET(ApiConstant.MASTER_PROGRAM)
    Call<MasterProgramResponse> getMasterProgram(
    );

    @GET(ApiConstant.MASTER_JENIS_AGUNAN)
    Call<MasterJenisAgunanResponse> getMasterJenisAgunan(
    );

    @GET(ApiConstant.MASTER_PROVINSI)
    Call<MasterProvinsiResponse> getMasterProvinsi(
    );

    @GET(ApiConstant.MASTER_KABUPATEN)
    Call<MasterKabupatenResponse> getMasterKabupaten(
            @Query("id_provinsi") int idProvinsi
    );

    @GET(ApiConstant.MASTER_KECAMATAN)
    Call<MasterKecamatanResponse> getMasterKecamatan(
            @Query("id_provinsi") int idProvinsi,
            @Query("id_kabupaten_kota") int idKabupaten
    );

    @GET(ApiConstant.MASTER_KELURAHAN)
    Call<MasterKelurahanResponse> getMasterKelurahan(
            @Query("id_provinsi") int idProvinsi,
            @Query("id_kabupaten_kota") int idKabupaten,
            @Query("id_kecamatan") int idKecamatan
    );

    @GET(ApiConstant.MASTER_JENIS_DOKUMEN)
    Call<JenisDokumenResponse> getMasterJenisDokumen(
    );

    @GET(ApiConstant.MASTER_JENIS_HARTA)
    Call<JenisHartaResponse> getMasterJenisHarta(
    );

    @GET(ApiConstant.MASTER_GELAR)
    Call<MasterGelarResponse> getMasterGelar();

    @GET(ApiConstant.MASTER_PENDIDIKAN_TERAKHIR)
    Call<MasterPendidikanTerakhirResponse> getMasterPendidikanTerakhir();

    @GET(ApiConstant.MASTER_JENIS_PEKERJAAN)
    Call<JenisPekerjaanResponse> getMasterJenisPekerjaan(
    );

    @GET(ApiConstant.MASTER_JENIS_PRODUK_USAHA)
    Call<JenisProdukUsahaResponse> getMasterJenisProdukUsaha(
    );

    @GET(ApiConstant.MASTER_PENGELOLAAN_KEUANGAN)
    Call<PengelolaanKeuanganResponse> getMasterPengelolaanKeuangan(
    );

    @GET(ApiConstant.MASTER_ATAP)
    Call<MasterAtapResponse> getMasterAtap();

    @GET(ApiConstant.MASTER_DINDING)
    Call<MasterDindingResponse> getMasterDinding();

    @GET(ApiConstant.MASTER_JENDELA)
    Call<MasterJendelaResponse> getMasterJendela();

    @GET(ApiConstant.MASTER_KUSEN)
    Call<MasterKusenResponse> getMasterKusen();

    @GET(ApiConstant.MASTER_LANTAI)
    Call<MasterLantaiResponse> getMasterLantai();

    @GET(ApiConstant.MASTER_PINTU)
    Call<MasterPintuResponse> getMasterPintu();

    @GET(ApiConstant.MASTER_PLAFON)
    Call<MasterPlafonResponse> getMasterPlafon();

    @GET(ApiConstant.MASTER_PONDASI)
    Call<MasterPondasiResponse> getMasterPondasiResponse();

    @GET(ApiConstant.MASTER_BATAS_WILAYAH)
    Call<MasterBatasWilayahResponse> getMasterBatasWilayah();

    @GET(ApiConstant.MASTER_BENTUK_TANAH)
    Call<MasterBentukTanahResponse> getMasterBentukTanah();

    @GET(ApiConstant.MASTER_KONDISI_PERMUKAAN_TANAH)
    Call<MasterKondisiPermukaanTanahResponse> getMasterKondisiPermukaanTanah();

    @GET(ApiConstant.MASTER_PENGGUNAAN_TANAH)
    Call<MasterPenggunaanTanahResponse> getPenggunaanTanahResponse();

    @GET(ApiConstant.MASTER_STATUS_TANAH)
    Call<MasterStatusTanahResponse> getStatusTanahResponse();

    @GET(ApiConstant.MASTER_JENIS_BUKTI_KEPEMILIKAN_ANGUNAN)
    Call<MasterJenisBuktiKepemilikanAgunanResponse> getMasterJenisBuktiKepemilikanAngunanResponse();

    @GET(ApiConstant.MASTER_BUKTI_KEPEMILIKAN_ANGUNAN)
    Call<MasterBuktiKepemilikanAgunanResponse> getMasterBuktiKepemilikanAngunanResponse(
            @Query("id_jenis_bukti") int idJenis
    );

    @GET(ApiConstant.MASTER_PENGELOLAAN_USAHA)
    Call<MasterPengelolaanUsahaResponse> getMasterPengelolaanUsaha();

    @GET(ApiConstant.MASTER_JALAN_DILALUI)
    Call<MasterJalanDilaluiResponse> getMasterJalanDilalui();

    @GET(ApiConstant.MASTER_PERUNTUKAN_LOKASI)
    Call<MasterPeruntukanLokasiResponse> getMasterPeruntukanLokasi();

    @GET(ApiConstant.MASTER_SALURAN_AIR)
    Call<MasterSaluranAirResponse> getMasterSaluranAir();

    @GET(ApiConstant.MASTER_SALURAN_TELEPON)
    Call<MasterSaluranTeleponResponse> getMasterSaluranTelepon();

    //=== END Api Data Master ===//


    // === Api Prospek === //
    @GET(ApiConstant.GET_LIST_PROSPEK)
    Call<ProspekListResponse> getListProspek(
            @Query("id_user") String userId,
            @Query("paging") int page
    );

    /*@GET (ApiConstant.GET_HISTORY_PEMBIAYAAN)
    Call<List<RiwayatAngsuran>> getListRiwayatAngsuran(
            @Path("nasabah_id") String idDebiturPnm
    );*/

    @GET (ApiConstant.GET_HISTORY_PEMBIAYAAN)
    Call<HistoryAngsuranListResponse> getListRiwayatAngsuran(
            @Path("nasabah_id") String idDebiturPnm
    );

    @GET(ApiConstant.GET_GENERAL_PROSPEK)
    Call<GeneralProspekResponse> getGeneralProspek(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_PROSPEK)
    Call<BaseResponse> saveProspek(
            @Body GeneralProspekResponse body
    );

    @POST(ApiConstant.EDIT_PROSPEK)
    Call<BaseResponse> editProspek(
            @Body GeneralProspekResponse body
    );

    @POST(ApiConstant.AUTOSAVE_PROSPEK)
    Call<AutoSaveResponse> autosaveProspek(
            @Body GeneralProspekResponse body
    );

    // === Api Prospek Detail === //
    @GET(ApiConstant.GET_LIST_PROSPEK_DETAIL)
    Call<ProspekListResponse> getListProspekDetail(
            @Query("id_user") String userId,
            @Query("paging") int page
    );

    @GET(ApiConstant.GET_GENERAL_PROSPEK_DETAIL)
    Call<GeneralProspekDetailResponse> getGeneralProspekDetail(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.EDIT_PROSPEK_DETAIL)
    Call<BaseResponse> saveProspekDetail(
            @Body GeneralProspekDetailResponse body
    );

    //Survey
    @GET(ApiConstant.GET_LIST_SURVEY)
    Call<SurveyListResponse> getListSurvey(
            @Query("id_user") String userId,
            @Query("paging") int page
    );

    @GET(ApiConstant.GET_SURVEY_CHECKLIST)
    Call<SurveyChecklistResponse> getSurveyChecklist(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @GET(ApiConstant.GET_SURVEY_DETAIL)
    Call<SurveyDetailResponse> getSurveyDetail(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_DETAIL)
    Call<BaseResponse> saveSurveyDetail(
            @Body SurveyDetailRequest body
    );

    @GET(ApiConstant.GET_SURVEY_PROFILKARAKTER)
    Call<ProfilKarakterResponse> getSurveyProfileKarakter(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_PROFILKARAKTER)
    Call<BaseResponse> saveProfilKarakter(
            @Body ProfilKarakterRequest body
    );

    @GET(ApiConstant.GET_SURVEY_KAPASITAS_USAHA)
    Call<KapasitasUsahaResponse> getSurveyKapasitasUsaha(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_KAPASITAS_USAHA)
    Call<BaseResponse> saveKapasitasUsaha(
            @Body KapasitasUsahaRequest body
    );

    @GET(ApiConstant.GET_SURVEY_JENIS_USAHA)
    Call<SurveyJenisUsahaResponse> getSurveyJenisUsaha(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_JENIS_USAHA)
    Call<BaseResponse> saveSurveyJenisUsaha(
            @Body SurveyJenisUsahaRequest body
    );

    @GET(ApiConstant.GET_SURVEY_KEUANGAN)
    Call<SurveyKeuanganResponse> getSurveyKeuangan(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_KEUANGAN)
    Call<BaseResponse> saveSurveyKeuangan(
            @Body SurveyKeuanganRequest body
    );

    @GET(ApiConstant.GET_SURVEY_KMK)
    Call<KebutuhanModalKerjaResponse> getSurveyKMK(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_KMK)
    Call<BaseResponse> saveSurveyKMK(
            @Body KebutuhanModalKerjaRequest body
    );

    @GET(ApiConstant.GET_SURVEY_KELUARGA)
    Call<SurveyKeluargaResponse> getSurveyKeluarga(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.SAVE_SURVEY_KELUARGA)
    Call<BaseResponse> saveSurveyKeluarga(
            @Body SurveyKeluargaRequest body
    );

    @GET(ApiConstant.GET_SURVEY_DOKUMEN_CHECKLIST)
    Call<SurveyDokumenListResponse> getSurveyDokumenChecklist(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @GET(ApiConstant.GET_SURVEY_LIST_JAMINAN)
    Call<SurveyJaminanListResponse> getSurveyJaminanList(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @GET(ApiConstant.GET_SURVEY_JAMINAN)
    Call<SurveyJaminanResponse> getSurveyJaminan(
            @Query("id") int idJaminan
    );

    @POST(ApiConstant.SAVE_SURVEY_JAMINAN)
    Call<BaseResponse> saveSurveyJaminan(
            @Body SurveyJaminanRequest body
    );

    @GET(ApiConstant.GET_SURVEY_DOKUMEN)
    Call<SurveyDokumenResponse> getSurveyDokumen(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur,
            @Query("jenis_dokumen") String jenisDokumen
    );

    @Multipart
    @POST(ApiConstant.UPLOAD_SURVEY_DOKUMEN)
    Call<SurveyDokumenUploadResponse> uploadDokumen(
            @Part MultipartBody.Part imageFile,
            @Part("id_sdm") RequestBody idSdm,
            @Part("id_debitur") RequestBody idDebitur,
            @Part("id_transaksi_debitur") RequestBody idTransaksiDebitur,
            @Part("id") RequestBody idDokumen,
            @Part("jenis_dokumen") RequestBody jenisDokumen,
            @Part("keterangan") RequestBody keterangan
    );

    @GET(ApiConstant.DELETE_SURVEY_DOKUMEN)
    Call<BaseResponse> deleteSurveyDokumen(
            @Query("id") int idDokumen,
            @Query("nama_file") String namaFile
    );

    @POST (ApiConstant.SEND_CHECK_SID)
    Call<BaseResponse> sendCheckSID(
            @Body CheckSIDRequest body
    );

    @POST (ApiConstant.SEND_CHECK_SID_KELUARGA)
    Call<BaseResponse> sendCheckSIDKeluarga(
            @Body CheckSIDRequest body
    );

    @POST (ApiConstant.SEND_PENGAJUAN_SURVEY)
    Call<BaseResponse> sendPengajuanSurvey(
            @Body SurveyPengajuanRequest body
    );

    @GET
    Call<CollectionListResponse> getCollectionList(
            @Url String url,
            @Query("id") String kodeUnit,
            @Query("page") int page
    );

    @GET (ApiConstant.GET_COLLECTION_DETAIL)
    Call<CollectionResponse> getCollectionDetail(
            @Query("id_debitur") String idDebitur
    );

    @POST (ApiConstant.SAVE_COLLECTION_DETAIL)
    Call<BaseResponse> saveCollectionDetail(
            @Body CollectionRequest body
    );

    @GET (ApiConstant.GET_LIST_HISTORICAL)
    Call<HistoricalListResponse> getListHistorical(
            @Query("idsdm") String idSdm,
            @Query("paging") int page
    );

    @GET(ApiConstant.GET_LIST_FEEDBACK)
    Call<FeedbackListResponse> getListFeedback(
            @Query("kode_cabang") String kodeCabang,
            @Query("kode_unit") String kodeUnit,
            @Query("paging") int page
    );

    //API for MU
    @GET(ApiConstant.GET_LIST_PROSPEK_DETAIL_MU)
    Call<ProspekListResponse> getListProspekDetailForMU(
            @Query("kode_cabang") String kodeCabang,
            @Query("kode_unit") String kodeUnit,
            @Query("paging") int page
    );

    @GET(ApiConstant.GET_GENERAL_PROSPEK_DETAIL_MU)
    Call<GeneralProspekDetailResponse> getGeneralProspekDetailForMU(
            @Query("id_debitur") String idDebitur,
            @Query("id_transaksi_debitur") String id_transaksi_debitur
    );

    @POST(ApiConstant.APPROVAL_PROSPEK_DETAIL_MU)
    Call<BaseResponse> sendApproval(
            @Body ApprovalProspekRequest body
    );

    @GET (ApiConstant.GET_LIST_PENGAJUAN_MU)
    Call<SurveyListResponse> getListPengajuan(
            @Query("kode_cabang") String kodeCabang,
            @Query("kode_unit") String kodeUnit,
            @Query("paging") int page
    );

    @POST (ApiConstant.APPROVAL_PENGAJUAN_MU)
    Call<BaseResponse> sendApprovalPengajuan(
            @Body ApprovalPengajuanRequest body
    );

    @GET(ApiConstant.GET_LIST_BANDING)
    Call<BandingListResponse> getListBanding(
            @Query("id_user") String idUser,
            @Query("paging") int page
    );

    @POST (ApiConstant.APPROVAL_BANDING)
    Call<BaseResponse> sendApprovalBanding(
            @Body ApprovalBandingRequest body
    );

    @GET (ApiConstant.GET_LIST_HISTORICAL_MU)
    Call<HistoricalListResponse> getListHistoricalForMU(
            @Query("kode_cabang") String kodeCabang,
            @Query("kode_unit") String kodeUnit,
            @Query("paging") int page
    );

    @POST(ApiConstant.POST_PROSPEK)
    Call<InsertProspekModel> PostProspek(
            @Body InsertProspekModel body
    );

    @POST(ApiConstant.UPDATE_PROSPEK)
    Call <UpdateProspekModel> UpdateProspek(
            @Body UpdateProspekModel body
    );

    @POST(ApiConstant.KONTAK_PROSPEK)
    Call <KontakProspekModel> KontakProspek(
            @Body KontakProspekModel body
    );

    @POST(ApiConstant.ALAMAT_PROSPEK)
    Call <AlamatProspekModel> AlamatProspek(
            @Body AlamatProspekModel body
    );

    @POST(ApiConstant.KELUARGA_PROSPEK)
    Call <KeluargaProspekModel> KeluargaProspek(
            @Body KeluargaProspekModel body
    );

    @POST(ApiConstant.PEMBIAYAAN_PROSPEK)
    Call <PembiayaanProspekModel> PembiayaanProspek(
            @Body PembiayaanProspekModel body
    );

    @POST(ApiConstant.AGUNAN_PROSPEK)
    Call <AgunanProspekModel> AgunanProspek(
            @Body AgunanProspekModel body
    );

    @POST(ApiConstant.UPLOAD_DOKUMEN)
    Call <UploadDokumenModel> UploadDokumen(
            @Body UploadDokumenModel body
    );

    @POST(ApiConstant.USAHA_PROSPEK)
    Call <UsahaProspekModel> UsahaProspek(
            @Body UsahaProspekModel body
    );

    @POST(ApiConstant.KUNJUNGAN_AOM)
    Call <KunjunganAomModel> KunjunganAOM(
            @Body KunjunganAomModel body
    );

    @POST(ApiConstant.SURVEY_ASSET)
    Call <SurveyAssetModel> SurveyAsset(
            @Body SurveyAssetModel body
    );

    @POST(ApiConstant.KUNJUNGAN_USAHA_AOM)
    Call <KunjunganUsahaModel> KunjunganUsaha(
            @Body KunjunganUsahaModel body
    );

    @POST(ApiConstant.NILAI_AGUNAN)
    Call <NilaiAgunanModel> NilaiAgunan(
            @Body NilaiAgunanModel body
    );

    @POST(ApiConstant.AKTIFITAS_REK)
    Call <AktifitasRekBankModel> AktifitasRek(
            @Body AktifitasRekBankModel body
    );

    @POST(ApiConstant.PINJAMAN_LAIN)
    Call <PinjamanLainModel> PinjamanLain(
            @Body PinjamanLainModel body
    );

    @POST(ApiConstant.RAB)
    Call <RABModel> RAB(
            @Body RABModel body
    );

    @POST(ApiConstant.SUMBER_REPUTASI)
    Call <SumberReputasiModel> SumberReputasi(
            @Body SumberReputasiModel body
    );

    @POST(ApiConstant.DATA_USAHA)
    Call <DataUsahaModel> DataUsaha(
            @Body DataUsahaModel body
    );

    @POST(ApiConstant.DATA_AGUNAN)
    Call <NilaiAgunanModel> DataAgunan(
            @Body NilaiAgunanModel body
    );

    @POST(ApiConstant.DELETE_AKTIFITAS)
    Call <DeleteAktifitasRekModel> DeleteAktifitasRek(
            @Body DeleteAktifitasRekModel body
    );

    @POST(ApiConstant.DELETE_ASSET)
    Call <DeleteAssetModel> DeleteAsset(
                    @Body DeleteAssetModel body
    );

    @POST(ApiConstant.DELETE_KUNJUNGAN_AOM)
    Call <DeleteKunjunganUsahaAOMModel> DeleteKunjungan(
            @Body DeleteKunjunganUsahaAOMModel body
    );

    @POST(ApiConstant.DELETE_NILAI_AGUNAN)
    Call <DeleteNilaiAgunanModel> DeleteNilaiAgunan(
            @Body DeleteNilaiAgunanModel body
    );

    @POST(ApiConstant.DELETE_RENCANA_AGUNAN)
    Call <DeleteRencanaAgunanModel> DeleteRencanaAgunan(
            @Body DeleteRencanaAgunanModel body
    );

    @POST(ApiConstant.DELETE_NOTE_SURVEY)
    Call <DeleteNoteSurveyModel> DeleteNoteSurvey(
            @Body DeleteNoteSurveyModel body
    );

    @POST(ApiConstant.DELETE_PINJAMAN_LAINNYA)
    Call <DeletePinjamanLainnyaModel> DeletePinjaman(
            @Body DeletePinjamanLainnyaModel body
    );

    @POST(ApiConstant.DELETE_RAB)
    Call <DeleteRABModel> DeleteRAB(
            @Body DeleteRABModel body
    );

    @POST(ApiConstant.DELETE_SUMBER_REPUTASI)
    Call <DeleteSumberReputasiModel> DeleteSumberReputasi(
            @Body DeleteSumberReputasiModel body
    );

    @POST(ApiConstant.DELETE_USAHA)
    Call <DeleteUsahaModel> DeleteUsaha(
            @Body DeleteUsahaModel body
    );




}
