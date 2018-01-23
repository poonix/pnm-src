package com.example.saifullah_albasrie.pnm.controller;

import android.text.TextUtils;
import android.util.Log;

//import com.crashlytics.android.Crashlytics;
import com.example.saifullah_albasrie.pnm.callback.LoginCallback;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.firebase.AppFirebaseIDService;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.master.ApiUrlModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JenisBuktiKepemilikanModel;
import com.example.saifullah_albasrie.pnm.model.master_new.BaseResponseNew;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.HubDgnBankResponse;
import com.example.saifullah_albasrie.pnm.rest.response.HubDgnPNMResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisDokumenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisHartaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisPekerjaanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisProdukUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisProspekResponse;
import com.example.saifullah_albasrie.pnm.rest.response.JenisUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KodeBidangUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.KodeUsahaResponse;
import com.example.saifullah_albasrie.pnm.rest.response.LoginResponse;
import com.example.saifullah_albasrie.pnm.rest.response.LoginSSOResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterGelarResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterJenisAgunanResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterPendidikanTerakhirResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProdukResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProgramResponse;
import com.example.saifullah_albasrie.pnm.rest.response.MasterProvinsiResponse;
import com.example.saifullah_albasrie.pnm.rest.response.PengelolaanKeuanganResponse;
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
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public class LoginController {

    private final String LOG_TAG = LoginController.class.getSimpleName();

    private AppPreference appPreference = AppPreference.getInstance();
    private DataManager dataManager = DataManager.getInstance();

    private LoginCallback loginCallback;

    private RestService serviceSSO = RestHelper.getInstanceSSO().getRestService();
    private RestService service = RestHelper.getInstance().getRestService();
    private RestService servicenoauth = RestHelper.getInstanceNoAuth().getRestService();

    private Call<LoginSSOResponse> callLoginSSO;
    private Call<LoginResponse> callLogin;

    //private Call<JenisProspekResponse> callJenisProspek;
    //private Call<JenisUsahaResponse> callJenisUsaha;


    public LoginController(LoginCallback callback) {
        this.loginCallback = callback;
    }

    public void doLoginSSO(String username, String password) {
        callLoginSSO = serviceSSO.loginSSO(ApiConstant.LOGIN_SSO, username, password, "AOM");
        callLoginSSO.enqueue(new Callback<LoginSSOResponse>() {
            @Override
            public void onResponse(Call<LoginSSOResponse> call, Response<LoginSSOResponse> response) {
                Log.d(LOG_TAG, "doLoginSSO.onResponse " + (response != null ? response.body():""));

                if (loginCallback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = (response.body().getLogin() != null && response.body().getLogin().size() > 0 && response.body().getLogin().get(0) != null) ? response.body().getLogin().get(0).getMessage() : "";
                        if (response.body().isSuccessResponse() && response.body().getUserLoggedin() != null) {
                            appPreference.setUserSSOLoggedIn(response.body().getUserLoggedin());
                            loginCallback.onLoginSSOSuccess(response.body().getUserLoggedin());
                        } else {
                            Throwable tt = new Throwable("Login SSO Failed!\n" + errMsg);
                            loginCallback.onLoginSSOFailed(tt);
                          //  Crashlytics.logException(tt);
                        }
                    } else {
                        Throwable tt = new Throwable("Login SSO Failed!");
                        loginCallback.onLoginSSOFailed(tt);
                      //  Crashlytics.logException(tt);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginSSOResponse> call, Throwable t) {
                Log.d(LOG_TAG, "doLoginSSO.onFailure " + (t != null ? t.getMessage() : ""));
                if (loginCallback != null) {
                    //loginCallback.onLoginSSOFailed(new Throwable("Login SSO Failed!\n" + (t != null ? t.getMessage() : "")));
                    Throwable tt = new Throwable("Login SSO Failed!\n" + (t != null ? t.getMessage() : ""));
                    loginCallback.onLoginSSOFailed(tt);
                   // Crashlytics.logException(tt);
                }
            }
        });
    }

    public void doLogin(String idSdm) {
        callLogin = service.loginAPI(ApiConstant.LOGIN_API, idSdm);
        callLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(LOG_TAG, "doLogin.onResponse " + (response != null ? response.body() : ""));
                if (loginCallback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse() && response.body().getUserLoggedin() != null) {
                            setupApiHost(response.body().getUrlapi());
                            UserModel userModel = response.body().getUserLoggedin();
                            appPreference.setUserLoggedIn(userModel);
                            loginCallback.onLoginInternalSuccess(userModel);
                            CommonUtil.updateLastActive();
                            if (!TextUtils.isEmpty(userModel.getFcmId())
                                    && !TextUtils.isEmpty(appPreference.getFcmId())
                                    && !userModel.getFcmId().equals(appPreference.getFcmId())) {
                                appPreference.setFcmNeedToResend(true);
                            }
                            AppFirebaseIDService.resendFcmId();
                            getMasterData();
                        } else {
                            //loginCallback.onLoginInternalFailed(new Throwable(errMsg));
                            Throwable tt = new Throwable(errMsg);
                            loginCallback.onLoginInternalFailed(tt);
                           // Crashlytics.logException(tt);
                        }
                    } else {
                        String msg = "";
                        try {
                            LoginResponse errResponse = new Gson().fromJson(response.errorBody().string(), LoginResponse.class);
                            msg = errResponse.getStatus();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //loginCallback.onLoginInternalFailed(new Throwable("Login Failed\n" + msg));
                        Throwable tt = new Throwable("Login Failed\n" + msg);
                        loginCallback.onLoginInternalFailed(tt);
                     //   Crashlytics.logException(tt);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d(LOG_TAG, "doLogin.onFailure " + (t != null ? t.getMessage() : ""));
                if (loginCallback != null) {
                    //loginCallback.onLoginInternalFailed(new Throwable("Login Failed\n" + (t != null ? t.getMessage() : "")));
                    Throwable tt = new Throwable("Login Failed\n" + (t != null ? t.getMessage() : ""));
                    loginCallback.onLoginInternalFailed(tt);
                  //  Crashlytics.logException(tt);
                }
            }
        });
    }

    private void setupApiHost(List<ApiUrlModel> apiUrlModels) {
        if (apiUrlModels != null) {
            for (ApiUrlModel model : apiUrlModels) {
                if (!TextUtils.isEmpty(model.getUrl())) {
                    if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_host_pnm")) {
                        RestHelper.setHostSSO(model.getUrl());
                        serviceSSO = RestHelper.getInstanceSSO().getRestService();
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_host")) {
                        RestHelper.setHostInternal(model.getUrl());
                        service = RestHelper.getInstance().getRestService();
                    }else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("pnm")) {
                        RestHelper.setCustomNoAuth(model.getUrl());
                        servicenoauth = RestHelper.getInstanceNoAuth().getRestService();
                    }else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_debitur_by_name")) {
                        appPreference.set(AppPreference.API_CHECK_DEBITUR_BY_NAME, model.getUrl());
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_debitur_by_ibu_kandung")) {
                        appPreference.set(AppPreference.API_CHECK_DEBITUR_BY_IBU_KANDUNG, model.getUrl());
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_debitur_by_tanggal_lahir")) {
                        appPreference.set(AppPreference.API_CHECK_DEBITUR_BY_TANGGAL_LAHIR, model.getUrl());
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_debitur_by_nomor_rekening")) {
                        appPreference.set(AppPreference.API_CHECK_DEBITUR_BY_NOMOR_REKEKING, model.getUrl());
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_collection_list")) {
                        appPreference.set(AppPreference.API_GET_LIST_COLLECTION, model.getUrl());
                    } else if (model.getUrlType() != null && model.getUrlType().equalsIgnoreCase("api_collection_detail")) {
                        appPreference.set(AppPreference.API_GET_COLLECTION_DETAIL, model.getUrl());
                    }

                }
            }
        }

        //TEST
        //RestHelper.setHostSSO("http://googl.c");
        //RestHelper.setHostInternal("http://intern.c");
        //serviceSSO = RestHelper.getInstanceSSO().getRestService();
        //service = RestHelper.getInstance().getRestService();
    }

    private static final Object LOCK = new Object();
    private List<Call> queue = new ArrayList<>();

    public void getMasterData() {
        synchronized (LOCK) {
            queue.clear();
        }
        getJenisReferensi();
        getStatusPerkawinan();
        getKewarganegaraan();
        getAgama();
        getPekerjaan();
        getJenisAlamat();
        getHubunganKeluarga();
        getTujuanPembiayaan();
        getJenisAgunan();
        getJenisKontak();
        getStatusTempat();
        getPendidikan();
        getProduk();
        getJenisDokumen();
        getJenisPembiayaan();
        getLokasi();
        getHubunganPemohon();
        getKerjasamaPemohon();
        getTrackRecord();
        getMengenalUlaam();
        getReputasi();
        getHarta();
        getPengelolaanKeuangan();
        getBentukUsaha();
        getJenisBadanUsaha();
        getKegiatanUsaha();
        getAksesKendaraan();
        getProdukDitawarkan();
        getJumlahPemasok();
        getPersainganUsaha();
        getKondisiSektorUsaha();
        getLokasiUsaha();
        getPeriode();
        getPembayaran();
        getProgram();
        getBank();
        getKolektibilitas();
        getJenisAsset();
        getPenilaian();
        getKepemilikan();
        getBuktiKepemilikanAgunan();
        getPeruntukanLokasi();
        getJalanDilalui();
        getBentukTanah();
        getKondisiPermukaan();
        getPenggunaanTanah();
        getBatas();
        getAir();
        getJenisIdentitas();
        getJenisKelamin();
        getJenisProspek();
        getJenisUsaha();
        getKodeUsaha();
        getKodeBidangUsaha();
        getHubunganBank();
        getHubunganPNM();
        getProvinsi();
        getProduk();
        getProgram();
        getJenisAgunan();
        getJenisDokumen();
        getJenisHarta();
        getGelar();
        getPendidikanTerakhir();
        getJenisPekerjaan();
        getJenisProdukUsaha();
        getAtap();
        getDinding();
        getJendela();
        getKusen();
        getLantai();
        getPintu();
        getPlafon();
        getPondasi();
        getBatasWilayah();
        getKondisiPermukaanTanah();
        getJenisCatatan();
        getTujuanPengiriman();
        getKeperluanPinjam();
        getBisnis();
        getJabatan();
        getStatusPinjamAgunan();
        getStatusPelepasanAgunan();
        getPeminjamAgunan();
        getRekeningTujuanSejenis();
        getSumberDana();
        getProfesiNotaris();
        getJenisGambaranUmumReview();
        getKondisiTempatUsaha();
        getKetersediaanBahanBaku();
        getGolonganPenjamin();
        getStatusAsuransiAgunan();
        getGolonganKredit();
        getNamaPengadilanNegeri();
        getJenisProduk();
        getJenisSumberDana();
        getJenisDcaID();
        getPolaPencairan();
        getNilaiPencairan();
        getMataUang();
        getLokasiProduk();
        getRegPro();
        getJenisSukuBunga();
        getJenisPembayaranProduk();
        getJenisPerhitunganBunga();
        getJadwalPerhitunganBunga();
        getJenisPemotonganBunga();
        getStrukturHariDalamSatuTahun();
        getStrukturHariDalamSatuBulan();
        getStrukturKreditHariBiaya();
        getStrukturKreditHariLibur();
        getKategoriPembiayaan();
        getStatusTanah();
        getJenisBuktiKepemilikanAgunan();
        //getBuktiKepemilikanAgunan();
        getPengelolaanUsaha();
        getSaluranAir();
        getSaluranTelepon();
    }

    public void getJenisProspek() {
        final Call<JenisProspekResponse> prospekResponseCall = service.getJenisProspek();
        synchronized (LOCK) {
            queue.add(prospekResponseCall);
        }

        prospekResponseCall.enqueue(new Callback<JenisProspekResponse>() {
            @Override
            public void onResponse(Call<JenisProspekResponse> call, Response<JenisProspekResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setJenisProspekModelList(response.body().getList());
                    onDataMasterCompleted(prospekResponseCall, true);
                } else {
                    onDataMasterCompleted(prospekResponseCall, false);
                }
            }

            @Override
            public void onFailure(Call<JenisProspekResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisProspek.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(prospekResponseCall, false);
            }
        });
    }

    /*
    *START -  18 Januari 2018 by Yudhi
    * */
    private void getJenisUsaha() {
        final Call<List<BaseResponseNew>> jenisUsahaResponseCall = servicenoauth.getJenisUsahaNew();
        synchronized (LOCK) {
            queue.add(jenisUsahaResponseCall);
        }

        jenisUsahaResponseCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterUsahaNew(response.body());
                    onDataMasterCompleted(jenisUsahaResponseCall, true);
                } else {
                    onDataMasterCompleted(jenisUsahaResponseCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisUsahaResponseCall, false);
            }
        });

    }

    private void getJenisIdentitas() {
        final Call<List<BaseResponseNew>> jenisIdentitasCall = servicenoauth.getJenisIdentitas();
        synchronized (LOCK) {
            queue.add(jenisIdentitasCall);
        }

        jenisIdentitasCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisIdentitasCall, true);
                } else {
                    onDataMasterCompleted(jenisIdentitasCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisIdentitas.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisIdentitasCall, false);
            }
        });
    }

    private void getJenisKelamin() {
        final Call<List<BaseResponseNew>> jenisKelaminCall = servicenoauth.getJenisKelamin();
        synchronized (LOCK) {
            queue.add(jenisKelaminCall);
        }

        jenisKelaminCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisKelaminCall, true);
                } else {
                    onDataMasterCompleted(jenisKelaminCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisKelamin.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisKelaminCall, false);
            }
        });
    }

    private void getJenisReferensi() {
        final Call<List<BaseResponseNew>> jenisReferensiCall = servicenoauth.getJenisReferensi();
        synchronized (LOCK) {
            queue.add(jenisReferensiCall);
        }

        jenisReferensiCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisReferensiCall, true);
                } else {
                    onDataMasterCompleted(jenisReferensiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisReferensi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisReferensiCall, false);
            }
        });
    }

    private void getStatusPerkawinan() {
        final Call<List<BaseResponseNew>> statusPerkawinanCall = servicenoauth.getStatusPerkawinan();
        synchronized (LOCK) {
            queue.add(statusPerkawinanCall);
        }

        statusPerkawinanCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(statusPerkawinanCall, true);
                } else {
                    onDataMasterCompleted(statusPerkawinanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStatusPerkawinan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(statusPerkawinanCall, false);
            }
        });
    }

    private void getKewarganegaraan() {
        final Call<List<BaseResponseNew>> kewarganegaraanCall = servicenoauth.getKewaganegaraan();
        synchronized (LOCK) {
            queue.add(kewarganegaraanCall);
        }

        kewarganegaraanCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kewarganegaraanCall, true);
                } else {
                    onDataMasterCompleted(kewarganegaraanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKewarganegaraan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kewarganegaraanCall, false);
            }
        });
    }

    private void getAgama() {
        final Call<List<BaseResponseNew>> agamaCall = servicenoauth.getAgama();
        synchronized (LOCK) {
            queue.add(agamaCall);
        }

        agamaCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(agamaCall, true);
                } else {
                    onDataMasterCompleted(agamaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getAgama.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(agamaCall, false);
            }
        });
    }

    private void getPekerjaan() {
        final Call<List<BaseResponseNew>> pekerjaanCall = servicenoauth.getPekerjaan();
        synchronized (LOCK) {
            queue.add(pekerjaanCall);
        }

        pekerjaanCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pekerjaanCall, true);
                } else {
                    onDataMasterCompleted(pekerjaanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPekerjaan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pekerjaanCall, false);
            }
        });
    }

    private void getJenisAlamat() {
        final Call<List<BaseResponseNew>> jenisAlamatCall = servicenoauth.getJenisAlamat();
        synchronized (LOCK) {
            queue.add(jenisAlamatCall);
        }

        jenisAlamatCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisAlamatCall, true);
                } else {
                    onDataMasterCompleted(jenisAlamatCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisAlamat.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisAlamatCall, false);
            }
        });
    }

    private void getHubunganKeluarga() {
        final Call<List<BaseResponseNew>> hubunganKeluargaCall = servicenoauth.getHubunganKeluarga();
        synchronized (LOCK) {
            queue.add(hubunganKeluargaCall);
        }

        hubunganKeluargaCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(hubunganKeluargaCall, true);
                } else {
                    onDataMasterCompleted(hubunganKeluargaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "hubunganKeluarga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(hubunganKeluargaCall, false);
            }
        });
    }

    private void getTujuanPembiayaan() {
        final Call<List<BaseResponseNew>> tujuanPembiayaanCall = servicenoauth.getTujuanPembiayaan();
        synchronized (LOCK) {
            queue.add(tujuanPembiayaanCall);
        }

        tujuanPembiayaanCall.enqueue(new Callback<List<BaseResponseNew>>() {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(tujuanPembiayaanCall, true);
                } else {
                    onDataMasterCompleted(tujuanPembiayaanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "hubunganKeluarga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(tujuanPembiayaanCall, false);
            }
        });
    }


    private void getJenisAgunan() {
        final Call<List<BaseResponseNew>> jenisAgunanCall = servicenoauth.getJenisAgunan();
        synchronized (LOCK) {
            queue.add(jenisAgunanCall);
        }
        jenisAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisAgunanCall, true);
                } else {
                    onDataMasterCompleted(jenisAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "jenisAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisAgunanCall, false);
            }
        });
    }

    private void getJenisKontak() {
        final Call<List<BaseResponseNew>> jenisKontakCall = servicenoauth.getJenisKontak();
        synchronized (LOCK) {
            queue.add(jenisKontakCall);
        }
        jenisKontakCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisKontakCall, true);
                } else {
                    onDataMasterCompleted(jenisKontakCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "jenisKontak.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisKontakCall, false);
            }
        });
    }

    private void getStatusTempat() {
        final Call<List<BaseResponseNew>> statusTempatCall = servicenoauth.getStatusTempat();
        synchronized (LOCK) {
            queue.add(statusTempatCall);
        }
        statusTempatCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(statusTempatCall, true);
                } else {
                    onDataMasterCompleted(statusTempatCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "statusTempat.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(statusTempatCall, false);
            }
        });
    }

    private void getPendidikan() {
        final Call<List<BaseResponseNew>> pendidikanCall = servicenoauth.getPendidikan();
        synchronized (LOCK) {
            queue.add(pendidikanCall);
        }
        pendidikanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pendidikanCall, true);
                } else {
                    onDataMasterCompleted(pendidikanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "statusTempat.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pendidikanCall, false);
            }
        });
    }

    private void getProduk() {
        final Call<List<BaseResponseNew>> produkCall = servicenoauth.getProduk();
        synchronized (LOCK) {
            queue.add(produkCall);
        }
        produkCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(produkCall, true);
                } else {
                    onDataMasterCompleted(produkCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getProduk.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(produkCall, false);
            }
        });

    }

    private void getJenisDokumen() {
        final Call<List<BaseResponseNew>> jenisDokumenCall = servicenoauth.getJenisDokumen();
        synchronized (LOCK) {
            queue.add(jenisDokumenCall);
        }
        jenisDokumenCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisDokumenCall, true);
                } else {
                    onDataMasterCompleted(jenisDokumenCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisDokumen.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisDokumenCall, false);
            }
        });
    }

    private void getJenisPembiayaan() {
        final Call<List<BaseResponseNew>> jenisPembiayaanCall = servicenoauth.getJenisPembiayaan();
        synchronized (LOCK) {
            queue.add(jenisPembiayaanCall);
        }
        jenisPembiayaanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisPembiayaanCall, true);
                } else {
                    onDataMasterCompleted(jenisPembiayaanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisPembiayaan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisPembiayaanCall, false);
            }
        });
    }

    private void getLokasi() {
        final Call<List<BaseResponseNew>> lokasiCall = servicenoauth.getLokasi();
        synchronized (LOCK) {
            queue.add(lokasiCall);
        }
        lokasiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(lokasiCall, true);
                } else {
                    onDataMasterCompleted(lokasiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getLokasi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(lokasiCall, false);
            }
        });
    }

    private void getHubunganPemohon() {
        final Call<List<BaseResponseNew>> hubunganPemohonCall = servicenoauth.getHubPemohon();
        synchronized (LOCK) {
            queue.add(hubunganPemohonCall);
        }
        hubunganPemohonCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(hubunganPemohonCall, true);
                } else {
                    onDataMasterCompleted(hubunganPemohonCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getHubunganPemohon.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(hubunganPemohonCall, false);
            }
        });
    }

    private void getKerjasamaPemohon() {
        final Call<List<BaseResponseNew>> kerjasamaPemohonCall = servicenoauth.getKerjasamaPemohon();
        synchronized (LOCK) {
            queue.add(kerjasamaPemohonCall);
        }
        kerjasamaPemohonCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kerjasamaPemohonCall, true);
                } else {
                    onDataMasterCompleted(kerjasamaPemohonCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKerjasamaPemohon.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kerjasamaPemohonCall, false);
            }
        });
    }

    private void getTrackRecord() {
        final Call<List<BaseResponseNew>> trackRecordCall = servicenoauth.getTrackRecord();
        synchronized (LOCK) {
            queue.add(trackRecordCall);
        }
        trackRecordCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(trackRecordCall, true);
                } else {
                    onDataMasterCompleted(trackRecordCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKerjasamaPemohon.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(trackRecordCall, false);
            }
        });
    }

    private void getMengenalUlaam() {
        final Call<List<BaseResponseNew>> mengenalUlaamCall = servicenoauth.getMengenalUlamm();
        synchronized (LOCK) {
            queue.add(mengenalUlaamCall);
        }
        mengenalUlaamCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(mengenalUlaamCall, true);
                } else {
                    onDataMasterCompleted(mengenalUlaamCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getMengenalUlaam.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(mengenalUlaamCall, false);
            }
        });
    }

    private void getReputasi() {
        final Call<List<BaseResponseNew>> reputasiCall = servicenoauth.getReputasi();
        synchronized (LOCK) {
            queue.add(reputasiCall);
        }
        reputasiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(reputasiCall, true);
                } else {
                    onDataMasterCompleted(reputasiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getReputasi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(reputasiCall, false);
            }
        });
    }

    private void getHarta() {
        final Call<List<BaseResponseNew>> hartaCall = servicenoauth.getHarta();
        synchronized (LOCK) {
            queue.add(hartaCall);
        }
        hartaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(hartaCall, true);
                } else {
                    onDataMasterCompleted(hartaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getReputasi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(hartaCall, false);
            }
        });
    }

    private void getPengelolaanKeuangan() {
        final Call<List<BaseResponseNew>> pengelolaanKeuanganCall = servicenoauth.getPengelolaanKeuangan();
        synchronized (LOCK) {
            queue.add(pengelolaanKeuanganCall);
        }
        pengelolaanKeuanganCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pengelolaanKeuanganCall, true);
                } else {
                    onDataMasterCompleted(pengelolaanKeuanganCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPengelolaanKeuangan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pengelolaanKeuanganCall, false);
            }
        });
    }

    private void getBentukUsaha() {
        final Call<List<BaseResponseNew>> bentukUsahaCall = servicenoauth.getBentukUsaha();
        synchronized (LOCK) {
            queue.add(bentukUsahaCall);
        }
        bentukUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(bentukUsahaCall, true);
                } else {
                    onDataMasterCompleted(bentukUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBentukUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(bentukUsahaCall, false);
            }
        });
    }

    private void getJenisBadanUsaha() {
        final Call<List<BaseResponseNew>> jenisBadanUsahaCall = servicenoauth.getJenisBadanUsaha();
        synchronized (LOCK) {
            queue.add(jenisBadanUsahaCall);
        }
        jenisBadanUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisBadanUsahaCall, true);
                } else {
                    onDataMasterCompleted(jenisBadanUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisBadanUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisBadanUsahaCall, false);
            }
        });
    }

    private void getKegiatanUsaha() {
        final Call<List<BaseResponseNew>> kegiatanUsahaCall = servicenoauth.getKegiatanUsaha();
        synchronized (LOCK) {
            queue.add(kegiatanUsahaCall);
        }
        kegiatanUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kegiatanUsahaCall, true);
                } else {
                    onDataMasterCompleted(kegiatanUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKegiatanUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kegiatanUsahaCall, false);
            }
        });
    }

    private void getAksesKendaraan() {
        final Call<List<BaseResponseNew>> AksesKendaraanCall = servicenoauth.getAksesKendaraan();
        synchronized (LOCK) {
            queue.add(AksesKendaraanCall);
        }
        AksesKendaraanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(AksesKendaraanCall, true);
                } else {
                    onDataMasterCompleted(AksesKendaraanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getAksesKendaraan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(AksesKendaraanCall, false);
            }
        });
    }

    private void getProdukDitawarkan() {
        final Call<List<BaseResponseNew>> produkDitawarkanCall = servicenoauth.getProdDitawarkan();
        synchronized (LOCK) {
            queue.add(produkDitawarkanCall);
        }
        produkDitawarkanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(produkDitawarkanCall, true);
                } else {
                    onDataMasterCompleted(produkDitawarkanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getProdukDitawarkan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(produkDitawarkanCall, false);
            }
        });
    }

    private void getJumlahPemasok() {
        final Call<List<BaseResponseNew>> jumlahPemasokCall = servicenoauth.getJmlPemasok();
        synchronized (LOCK) {
            queue.add(jumlahPemasokCall);
        }
        jumlahPemasokCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jumlahPemasokCall, true);
                } else {
                    onDataMasterCompleted(jumlahPemasokCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJumlahPemasok.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jumlahPemasokCall, false);
            }
        });
    }

    private void getPersainganUsaha() {
        final Call<List<BaseResponseNew>> persainganUsahaCall = servicenoauth.getPersainganUsaha();
        synchronized (LOCK) {
            queue.add(persainganUsahaCall);
        }
        persainganUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(persainganUsahaCall, true);
                } else {
                    onDataMasterCompleted(persainganUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPersainganUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(persainganUsahaCall, false);
            }
        });
    }

    private void getKondisiSektorUsaha() {
        final Call<List<BaseResponseNew>> kondisiSektorUsahaCall = servicenoauth.getKondSekUsaha();
        synchronized (LOCK) {
            queue.add(kondisiSektorUsahaCall);
        }
        kondisiSektorUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kondisiSektorUsahaCall, true);
                } else {
                    onDataMasterCompleted(kondisiSektorUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPersainganUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kondisiSektorUsahaCall, false);
            }
        });
    }

    private void getLokasiUsaha() {
        final Call<List<BaseResponseNew>> lokasiUsahaCall = servicenoauth.getLokasiUsaha();
        synchronized (LOCK) {
            queue.add(lokasiUsahaCall);
        }
        lokasiUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(lokasiUsahaCall, true);
                } else {
                    onDataMasterCompleted(lokasiUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getLokasiUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(lokasiUsahaCall, false);
            }
        });
    }

    private void getPeriode() {
        final Call<List<BaseResponseNew>> periodeCall = servicenoauth.getPeriode();
        synchronized (LOCK) {
            queue.add(periodeCall);
        }
        periodeCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(periodeCall, true);
                } else {
                    onDataMasterCompleted(periodeCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPeriode.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(periodeCall, false);
            }
        });
    }

    private void getPembayaran() {
        final Call<List<BaseResponseNew>> pembayaranCall = servicenoauth.getpembayaran();
        synchronized (LOCK) {
            queue.add(pembayaranCall);
        }
        pembayaranCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pembayaranCall, true);
                } else {
                    onDataMasterCompleted(pembayaranCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPembayaran.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pembayaranCall, false);
            }
        });
    }

    private void getProgram() {
        final Call<List<BaseResponseNew>> programCall = servicenoauth.getProgram();
        synchronized (LOCK) {
            queue.add(programCall);
        }
        programCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(programCall, true);
                } else {
                    onDataMasterCompleted(programCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getProgram.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(programCall, false);
            }
        });
    }

    private void getBank() {
        final Call<List<BaseResponseNew>> bankCall = servicenoauth.getBank();
        synchronized (LOCK) {
            queue.add(bankCall);
        }
        bankCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(bankCall, true);
                } else {
                    onDataMasterCompleted(bankCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBank.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(bankCall, false);
            }
        });
    }

    private void getKolektibilitas() {
        final Call<List<BaseResponseNew>> kolektibilitasCall = servicenoauth.getKolektibilitas();
        synchronized (LOCK) {
            queue.add(kolektibilitasCall);
        }
        kolektibilitasCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kolektibilitasCall, true);
                } else {
                    onDataMasterCompleted(kolektibilitasCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKolektibilitas.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kolektibilitasCall, false);
            }
        });
    }

    private void getJenisAsset() {
        final Call<List<BaseResponseNew>> jenisAsetCall = servicenoauth.getJenisAsset();
        synchronized (LOCK) {
            queue.add(jenisAsetCall);
        }
        jenisAsetCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisAsetCall, true);
                } else {
                    onDataMasterCompleted(jenisAsetCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisAsset.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisAsetCall, false);
            }
        });
    }

    private void getPenilaian() {
        final Call<List<BaseResponseNew>> penilaianCall = servicenoauth.getPenilaian();
        synchronized (LOCK) {
            queue.add(penilaianCall);
        }
        penilaianCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(penilaianCall, true);
                } else {
                    onDataMasterCompleted(penilaianCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPenilaian.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(penilaianCall, false);
            }
        });
    }

    private void getKepemilikan() {
        final Call<List<BaseResponseNew>> kepemilikanCall = servicenoauth.getKepemilikan();
        synchronized (LOCK) {
            queue.add(kepemilikanCall);
        }
        kepemilikanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kepemilikanCall, true);
                } else {
                    onDataMasterCompleted(kepemilikanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKepemilikan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kepemilikanCall, false);
            }
        });
    }

    private void getBuktiKepemilikanAgunan() {
        final Call<List<BaseResponseNew>> buktiKepemilikanAgunanCall = servicenoauth.getBuktiKepAgunan();
        synchronized (LOCK) {
            queue.add(buktiKepemilikanAgunanCall);
        }
        buktiKepemilikanAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(buktiKepemilikanAgunanCall, true);
                } else {
                    onDataMasterCompleted(buktiKepemilikanAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBuktiKepemilikanAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(buktiKepemilikanAgunanCall, false);
            }
        });
    }

    private void getPeruntukanLokasi() {
        final Call<List<BaseResponseNew>> peruntukanLokasiCall = servicenoauth.getPeruntukanLokasi();
        synchronized (LOCK) {
            queue.add(peruntukanLokasiCall);
        }
        peruntukanLokasiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(peruntukanLokasiCall, true);
                } else {
                    onDataMasterCompleted(peruntukanLokasiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPeruntukanLokasi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(peruntukanLokasiCall, false);
            }
        });
    }

    private void getJalanDilalui() {
        final Call<List<BaseResponseNew>> jalanDilaluiCall = servicenoauth.getJalanDilalui();
        synchronized (LOCK) {
            queue.add(jalanDilaluiCall);
        }
        jalanDilaluiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jalanDilaluiCall, true);
                } else {
                    onDataMasterCompleted(jalanDilaluiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJalanDilalui.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jalanDilaluiCall, false);
            }
        });
    }

    private void getBentukTanah() {
        final Call<List<BaseResponseNew>> bentukTanahCall = servicenoauth.getBentukTanah();
        synchronized (LOCK) {
            queue.add(bentukTanahCall);
        }
        bentukTanahCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(bentukTanahCall, true);
                } else {
                    onDataMasterCompleted(bentukTanahCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBentukTanah.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(bentukTanahCall, false);
            }
        });
    }

    private void getKondisiPermukaan() {
        final Call<List<BaseResponseNew>> kondisiPermukaanCall = servicenoauth.getKondisiPermukaan();
        synchronized (LOCK) {
            queue.add(kondisiPermukaanCall);
        }
        kondisiPermukaanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kondisiPermukaanCall, true);
                } else {
                    onDataMasterCompleted(kondisiPermukaanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKondisiPermukaan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kondisiPermukaanCall, false);
            }
        });
    }

    private void getPenggunaanTanah() {
        final Call<List<BaseResponseNew>> penggunaanTanahCall = servicenoauth.getPenggunaanTanah();
        synchronized (LOCK) {
            queue.add(penggunaanTanahCall);
        }
        penggunaanTanahCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(penggunaanTanahCall, true);
                } else {
                    onDataMasterCompleted(penggunaanTanahCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPenggunaanTanah.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(penggunaanTanahCall, false);
            }
        });
    }

    private void getBatas() {
        final Call<List<BaseResponseNew>> batasCall = servicenoauth.getBatas();
        synchronized (LOCK) {
            queue.add(batasCall);
        }
        batasCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(batasCall, true);
                } else {
                    onDataMasterCompleted(batasCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBatas.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(batasCall, false);
            }
        });
    }

    private void getAir() {
        final Call<List<BaseResponseNew>> airCall = servicenoauth.getAir();
        synchronized (LOCK) {
            queue.add(airCall);
        }
        airCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(airCall, true);
                } else {
                    onDataMasterCompleted(airCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getAir.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(airCall, false);
            }
        });
    }

    private void getPondasi() {
        final Call<List<BaseResponseNew>> pondasiCall = servicenoauth.getPondasi();
        synchronized (LOCK) {
            queue.add(pondasiCall);
        }
        pondasiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pondasiCall, true);
                } else {
                    onDataMasterCompleted(pondasiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPondasi.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pondasiCall, false);
            }
        });
    }

    private void getLantai() {
        final Call<List<BaseResponseNew>> lantaiCall = servicenoauth.getLantai();
        synchronized (LOCK) {
            queue.add(lantaiCall);
        }
        lantaiCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(lantaiCall, true);
                } else {
                    onDataMasterCompleted(lantaiCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getLantai.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(lantaiCall, false);
            }
        });
    }

    private void getDinding() {
        final Call<List<BaseResponseNew>> dindingCall = servicenoauth.getDinding();
        synchronized (LOCK) {
            queue.add(dindingCall);
        }
        dindingCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(dindingCall, true);
                } else {
                    onDataMasterCompleted(dindingCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getDinding.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(dindingCall, false);
            }
        });
    }

    private void getJendela() {
        final Call<List<BaseResponseNew>> jendelaCall = servicenoauth.getJendela();
        synchronized (LOCK) {
            queue.add(jendelaCall);
        }
        jendelaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jendelaCall, true);
                } else {
                    onDataMasterCompleted(jendelaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJendela.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jendelaCall, false);
            }
        });
    }

    private void getPlafon() {
        final Call<List<BaseResponseNew>> plafonCall = servicenoauth.getPlafon();
        synchronized (LOCK) {
            queue.add(plafonCall);
        }
        plafonCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(plafonCall, true);
                } else {
                    onDataMasterCompleted(plafonCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPlafon.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(plafonCall, false);
            }
        });
    }

    private void getKusen() {
        final Call<List<BaseResponseNew>> kusenCall = servicenoauth.getKusen();
        synchronized (LOCK) {
            queue.add(kusenCall);
        }
        kusenCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kusenCall, true);
                } else {
                    onDataMasterCompleted(kusenCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKusen.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kusenCall, false);
            }
        });
    }

    private void getAtap() {
        final Call<List<BaseResponseNew>> atapCall = servicenoauth.getAtap();
        synchronized (LOCK) {
            queue.add(atapCall);
        }
        atapCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(atapCall, true);
                } else {
                    onDataMasterCompleted(atapCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKusen.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(atapCall, false);
            }
        });
    }

    private void getPintu() {
        final Call<List<BaseResponseNew>> pintuCall = servicenoauth.getPintu();
        synchronized (LOCK) {
            queue.add(pintuCall);
        }
        pintuCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(pintuCall, true);
                } else {
                    onDataMasterCompleted(pintuCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPintu.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(pintuCall, false);
            }
        });
    }

    private void getJenisCatatan() {
        final Call<List<BaseResponseNew>> jenisCatatanCall = servicenoauth.getJenisCatatan();
        synchronized (LOCK) {
            queue.add(jenisCatatanCall);
        }
        jenisCatatanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisCatatanCall, true);
                } else {
                    onDataMasterCompleted(jenisCatatanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisCatatan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisCatatanCall, false);
            }
        });
    }

    private void getTujuanPengiriman() {
        final Call<List<BaseResponseNew>> tujuanPengirimanCall = servicenoauth.getTujuanPengiriman();
        synchronized (LOCK) {
            queue.add(tujuanPengirimanCall);
        }
        tujuanPengirimanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(tujuanPengirimanCall, true);
                } else {
                    onDataMasterCompleted(tujuanPengirimanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getTujuanPengiriman.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(tujuanPengirimanCall, false);
            }
        });
    }

    private void getKeperluanPinjam() {
        final Call<List<BaseResponseNew>> KeperluanPinjamCall = servicenoauth.getKeperluanPinjam();
        synchronized (LOCK) {
            queue.add(KeperluanPinjamCall);
        }
        KeperluanPinjamCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(KeperluanPinjamCall, true);
                } else {
                    onDataMasterCompleted(KeperluanPinjamCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKeperluanPinjam.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(KeperluanPinjamCall, false);
            }
        });
    }

    private void getBisnis() {
        final Call<List<BaseResponseNew>> bisnisCall = servicenoauth.getBisnis();
        synchronized (LOCK) {
            queue.add(bisnisCall);
        }
        bisnisCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(bisnisCall, true);
                } else {
                    onDataMasterCompleted(bisnisCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getBisnis.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(bisnisCall, false);
            }
        });
    }

    private void getJabatan() {
        final Call<List<BaseResponseNew>> jabatanCall = servicenoauth.getJabatan();
        synchronized (LOCK) {
            queue.add(jabatanCall);
        }
        jabatanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jabatanCall, true);
                } else {
                    onDataMasterCompleted(jabatanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJabatan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jabatanCall, false);
            }
        });
    }

    private void getStatusPinjamAgunan() {
        final Call<List<BaseResponseNew>> statusPinjamAgunanCall = servicenoauth.getStatusPinjamAgunan();
        synchronized (LOCK) {
            queue.add(statusPinjamAgunanCall);
        }
        statusPinjamAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(statusPinjamAgunanCall, true);
                } else {
                    onDataMasterCompleted(statusPinjamAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStatusPinjamAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(statusPinjamAgunanCall, false);
            }
        });
    }

    private void getStatusPelepasanAgunan() {
        final Call<List<BaseResponseNew>> statusPelepasanAgunanCall = servicenoauth.getStatusPelepasanAgunan();
        synchronized (LOCK) {
            queue.add(statusPelepasanAgunanCall);
        }
        statusPelepasanAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(statusPelepasanAgunanCall, true);
                } else {
                    onDataMasterCompleted(statusPelepasanAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStatusPelepasanAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(statusPelepasanAgunanCall, false);
            }
        });
    }

    private void getPeminjamAgunan() {
        final Call<List<BaseResponseNew>> peminjamAgunanCall = servicenoauth.getPeminjamAgunan();
        synchronized (LOCK) {
            queue.add(peminjamAgunanCall);
        }
        peminjamAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(peminjamAgunanCall, true);
                } else {
                    onDataMasterCompleted(peminjamAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPeminjamAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(peminjamAgunanCall, false);
            }
        });
    }

    private void getRekeningTujuanSejenis() {
        final Call<List<BaseResponseNew>> tujuanSejenisCall = servicenoauth.getRekeningTujuanBisnis();
        synchronized (LOCK) {
            queue.add(tujuanSejenisCall);
        }
        tujuanSejenisCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(tujuanSejenisCall, true);
                } else {
                    onDataMasterCompleted(tujuanSejenisCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getRekeningTujuanSejenis.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(tujuanSejenisCall, false);
            }
        });
    }

    private void getSumberDana() {
        final Call<List<BaseResponseNew>> sumberDanaCall = servicenoauth.getSumberDana();
        synchronized (LOCK) {
            queue.add(sumberDanaCall);
        }
        sumberDanaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(sumberDanaCall, true);
                } else {
                    onDataMasterCompleted(sumberDanaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getSumberDana.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(sumberDanaCall, false);
            }
        });
    }

    private void getProfesiNotaris() {
        final Call<List<BaseResponseNew>> profesiNotarisCall = servicenoauth.getProfesiNotaris();
        synchronized (LOCK) {
            queue.add(profesiNotarisCall);
        }
        profesiNotarisCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(profesiNotarisCall, true);
                } else {
                    onDataMasterCompleted(profesiNotarisCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getProfesiNotaris.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(profesiNotarisCall, false);
            }
        });
    }

    private void getJenisGambaranUmumReview() {
        final Call<List<BaseResponseNew>> jenisGambaranUmumReview = servicenoauth.getJenisGambaranUmumReview();
        synchronized (LOCK) {
            queue.add(jenisGambaranUmumReview);
        }
        jenisGambaranUmumReview.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisGambaranUmumReview, true);
                } else {
                    onDataMasterCompleted(jenisGambaranUmumReview, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisGambaranUmumReview.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisGambaranUmumReview, false);
            }
        });
    }

    private void getKondisiTempatUsaha() {
        final Call<List<BaseResponseNew>> kondisiTempatUsahaCall = servicenoauth.getKondisiTempatUsaha();
        synchronized (LOCK) {
            queue.add(kondisiTempatUsahaCall);
        }
        kondisiTempatUsahaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kondisiTempatUsahaCall, true);
                } else {
                    onDataMasterCompleted(kondisiTempatUsahaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKondisiTempatUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kondisiTempatUsahaCall, false);
            }
        });
    }

    private void getKetersediaanBahanBaku() {
        final Call<List<BaseResponseNew>> ketersediaanBahanBakuCall = servicenoauth.getKetersediaanBahanBaku();
        synchronized (LOCK) {
            queue.add(ketersediaanBahanBakuCall);
        }
        ketersediaanBahanBakuCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(ketersediaanBahanBakuCall, true);
                } else {
                    onDataMasterCompleted(ketersediaanBahanBakuCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKetersediaanBahanBaku.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(ketersediaanBahanBakuCall, false);
            }
        });
    }

    private void getGolonganPenjamin() {
        final Call<List<BaseResponseNew>> golonganPenjaminCall = servicenoauth.getGolonganPenjamin();
        synchronized (LOCK) {
            queue.add(golonganPenjaminCall);
        }
        golonganPenjaminCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(golonganPenjaminCall, true);
                } else {
                    onDataMasterCompleted(golonganPenjaminCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getGolonganPenjamin.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(golonganPenjaminCall, false);
            }
        });
    }

    private void getStatusAsuransiAgunan() {
        final Call<List<BaseResponseNew>> statusAsuransiAgunanCall = servicenoauth.getStatusAsuransiAgunan();
        synchronized (LOCK) {
            queue.add(statusAsuransiAgunanCall);
        }
        statusAsuransiAgunanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(statusAsuransiAgunanCall, true);
                } else {
                    onDataMasterCompleted(statusAsuransiAgunanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStatusAsuransiAgunan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(statusAsuransiAgunanCall, false);
            }
        });
    }

    private void getGolonganKredit() {
        final Call<List<BaseResponseNew>> golonganKreditCall = servicenoauth.getGolonganKredit();
        synchronized (LOCK) {
            queue.add(golonganKreditCall);
        }
        golonganKreditCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(golonganKreditCall, true);
                } else {
                    onDataMasterCompleted(golonganKreditCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getGolonganKredit.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(golonganKreditCall, false);
            }
        });
    }

    private void getNamaPengadilanNegeri() {
        final Call<List<BaseResponseNew>> namaPengadilanNegeriCall = servicenoauth.getNamaPengadilanNegeri();
        synchronized (LOCK) {
            queue.add(namaPengadilanNegeriCall);
        }
        namaPengadilanNegeriCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(namaPengadilanNegeriCall, true);
                } else {
                    onDataMasterCompleted(namaPengadilanNegeriCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getNamaPengadilanNegeri.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(namaPengadilanNegeriCall, false);
            }
        });
    }

    private void getJenisProduk() {
        final Call<List<BaseResponseNew>> jenisProdukCall = servicenoauth.getJenisProduk();
        synchronized (LOCK) {
            queue.add(jenisProdukCall);
        }
        jenisProdukCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisProdukCall, true);
                } else {
                    onDataMasterCompleted(jenisProdukCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisProduk.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisProdukCall, false);
            }
        });
    }

    private void getJenisSumberDana() {
        final Call<List<BaseResponseNew>> jenisSumberDanaCall = servicenoauth.getJenisSumberDana();
        synchronized (LOCK) {
            queue.add(jenisSumberDanaCall);
        }
        jenisSumberDanaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisSumberDanaCall, true);
                } else {
                    onDataMasterCompleted(jenisSumberDanaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisSumberDana.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisSumberDanaCall, false);
            }
        });
    }

    private void getJenisDcaID() {
        final Call<List<BaseResponseNew>> jenisDCAid = servicenoauth.getJenisDCAID();
        synchronized (LOCK) {
            queue.add(jenisDCAid);
        }
        jenisDCAid.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisDCAid, true);
                } else {
                    onDataMasterCompleted(jenisDCAid, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisDcaID.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisDCAid, false);
            }
        });
    }

    private void getPolaPencairan() {
        final Call<List<BaseResponseNew>> polaPencairanCall = servicenoauth.getPolaPencairan();
        synchronized (LOCK) {
            queue.add(polaPencairanCall);
        }
        polaPencairanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(polaPencairanCall, true);
                } else {
                    onDataMasterCompleted(polaPencairanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getPolaPencairan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(polaPencairanCall, false);
            }
        });
    }

    private void getNilaiPencairan() {
        final Call<List<BaseResponseNew>> nilaiPencairanCall = servicenoauth.getNilaiPencairan();
        synchronized (LOCK) {
            queue.add(nilaiPencairanCall);
        }
        nilaiPencairanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(nilaiPencairanCall, true);
                } else {
                    onDataMasterCompleted(nilaiPencairanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getNilaiPencairan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(nilaiPencairanCall, false);
            }
        });
    }

    private void getMataUang() {
        final Call<List<BaseResponseNew>> mataUangCall = servicenoauth.getMataUang();
        synchronized (LOCK) {
            queue.add(mataUangCall);
        }
        mataUangCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(mataUangCall, true);
                } else {
                    onDataMasterCompleted(mataUangCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getMataUang.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(mataUangCall, false);
            }
        });
    }

    private void getLokasiProduk() {
        final Call<List<BaseResponseNew>> lokasiProdukCall = servicenoauth.getLokasiProduk();
        synchronized (LOCK) {
            queue.add(lokasiProdukCall);
        }
        lokasiProdukCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(lokasiProdukCall, true);
                } else {
                    onDataMasterCompleted(lokasiProdukCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getLokasiProduk.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(lokasiProdukCall, false);
            }
        });
    }

    private void getRegPro() {
        final Call<List<BaseResponseNew>> regProCall = servicenoauth.getRegPro();
        synchronized (LOCK) {
            queue.add(regProCall);
        }
        regProCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(regProCall, true);
                } else {
                    onDataMasterCompleted(regProCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getRegPro.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(regProCall, false);
            }
        });
    }

    private void getJenisSukuBunga() {
        final Call<List<BaseResponseNew>> jenisSukuBungaCall = servicenoauth.getJenisSukuBunga();
        synchronized (LOCK) {
            queue.add(jenisSukuBungaCall);
        }
        jenisSukuBungaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisSukuBungaCall, true);
                } else {
                    onDataMasterCompleted(jenisSukuBungaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisSukuBunga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisSukuBungaCall, false);
            }
        });
    }

    private void getJenisPembayaranProduk() {
        final Call<List<BaseResponseNew>> jenisPembayaranProduk = servicenoauth.getJenisPembayaranProduk();
        synchronized (LOCK) {
            queue.add(jenisPembayaranProduk);
        }
        jenisPembayaranProduk.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisPembayaranProduk, true);
                } else {
                    onDataMasterCompleted(jenisPembayaranProduk, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisPembayaranProduk.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisPembayaranProduk, false);
            }
        });
    }

    private void getJenisPerhitunganBunga() {
        final Call<List<BaseResponseNew>> jenisPerhitunganBunga = servicenoauth.getJenisPerhitunganBunga();
        synchronized (LOCK) {
            queue.add(jenisPerhitunganBunga);
        }
        jenisPerhitunganBunga.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisPerhitunganBunga, true);
                } else {
                    onDataMasterCompleted(jenisPerhitunganBunga, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisPerhitunganBunga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisPerhitunganBunga, false);
            }
        });
    }

    private void getJadwalPerhitunganBunga() {
        final Call<List<BaseResponseNew>> jadwalPerhitunganBungaCall = servicenoauth.getJadwalPerhitunganBunga();
        synchronized (LOCK) {
            queue.add(jadwalPerhitunganBungaCall);
        }
        jadwalPerhitunganBungaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jadwalPerhitunganBungaCall, true);
                } else {
                    onDataMasterCompleted(jadwalPerhitunganBungaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJadwalPerhitunganBunga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jadwalPerhitunganBungaCall, false);
            }
        });
    }

    private void getJenisPemotonganBunga() {
        final Call<List<BaseResponseNew>> jenisPemotonganBungaCall = servicenoauth.getJenisPemotonganBunga();
        synchronized (LOCK) {
            queue.add(jenisPemotonganBungaCall);
        }
        jenisPemotonganBungaCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(jenisPemotonganBungaCall, true);
                } else {
                    onDataMasterCompleted(jenisPemotonganBungaCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisPemotonganBunga.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(jenisPemotonganBungaCall, false);
            }
        });
    }

    private void getStrukturHariDalamSatuTahun() {
        final Call<List<BaseResponseNew>> STHDSTcall = servicenoauth.getStrukturHariDalamSatuTahun();
        synchronized (LOCK) {
            queue.add(STHDSTcall);
        }
        STHDSTcall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(STHDSTcall, true);
                } else {
                    onDataMasterCompleted(STHDSTcall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStrukturHariDalamSatuTahun.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(STHDSTcall, false);
            }
        });
    }

    private void getStrukturHariDalamSatuBulan() {
        final Call<List<BaseResponseNew>> STHDSBcall = servicenoauth.getStrukurHariDalamSatuBulan();
        synchronized (LOCK) {
            queue.add(STHDSBcall);
        }
        STHDSBcall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(STHDSBcall, true);
                } else {
                    onDataMasterCompleted(STHDSBcall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStrukturHariDalamSatuBulan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(STHDSBcall, false);
            }
        });
    }

    private void getStrukturKreditHariLibur() {
        final Call<List<BaseResponseNew>> SKHLcall = servicenoauth.getStrukturKreditHariLibur();
        synchronized (LOCK) {
            queue.add(SKHLcall);
        }
        SKHLcall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(SKHLcall, true);
                } else {
                    onDataMasterCompleted(SKHLcall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStrukturKreditHariLibur.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(SKHLcall, false);
            }
        });
    }

    private void getStrukturKreditHariBiaya() {
        final Call<List<BaseResponseNew>> SKHBcall = servicenoauth.getStrukturKreditHariBiaya();
        synchronized (LOCK) {
            queue.add(SKHBcall);
        }
        SKHBcall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(SKHBcall, true);
                } else {
                    onDataMasterCompleted(SKHBcall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getStrukturKreditHariBiaya.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(SKHBcall, false);
            }
        });
    }

    private void getKategoriPembiayaan() {
        final Call<List<BaseResponseNew>> kategoriPembiayaanCall = servicenoauth.getKategoriPembiayaan();
        synchronized (LOCK) {
            queue.add(kategoriPembiayaanCall);
        }
        kategoriPembiayaanCall.enqueue(new Callback<List<BaseResponseNew>> () {
            @Override
            public void onResponse(Call<List<BaseResponseNew>> call, Response<List<BaseResponseNew>> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setMasterDataNewList(response.body());
                    onDataMasterCompleted(kategoriPembiayaanCall, true);
                } else {
                    onDataMasterCompleted(kategoriPembiayaanCall, false);
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponseNew>> call, Throwable t) {
                Log.e(LOG_TAG, "getKategoriPembiayaan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(kategoriPembiayaanCall, false);
            }
        });
    }

    /*
    *END -  18 Januari 2018 by Yudhi
    * */
    private void getKodeUsaha() {
        final Call<KodeUsahaResponse> call = service.getKodeUsaha();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<KodeUsahaResponse>() {
            @Override
            public void onResponse(Call<KodeUsahaResponse> call, Response<KodeUsahaResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setKodeUsahaModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<KodeUsahaResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getKodeUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getKodeBidangUsaha() {
        final Call<KodeBidangUsahaResponse> call = service.getKodeBidangUsaha();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<KodeBidangUsahaResponse>() {
            @Override
            public void onResponse(Call<KodeBidangUsahaResponse> call, Response<KodeBidangUsahaResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setKodeBidangUsahaModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<KodeBidangUsahaResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getKodeBidangUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });

    }

    private void getHubunganBank() {
        final Call<HubDgnBankResponse> call = service.getHubunganBank();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<HubDgnBankResponse>() {
            @Override
            public void onResponse(Call<HubDgnBankResponse> call, Response<HubDgnBankResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setHubunganDenganBankModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<HubDgnBankResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getHubunganBank.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getHubunganPNM() {
        final Call<HubDgnPNMResponse> call = service.getHubunganPNM();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<HubDgnPNMResponse>() {
            @Override
            public void onResponse(Call<HubDgnPNMResponse> call, Response<HubDgnPNMResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setHubunganDenganPNMModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<HubDgnPNMResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getHubunganPNM.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });

    }

    private void getProvinsi() {
        final Call<MasterProvinsiResponse> call = service.getMasterProvinsi();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterProvinsiResponse>() {
            @Override
            public void onResponse(Call<MasterProvinsiResponse> call, Response<MasterProvinsiResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setProvinsiModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterProvinsiResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getHubunganPNM.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });

    }

    private void getJenisHarta() {
        final Call<JenisHartaResponse> call = service.getMasterJenisHarta();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<JenisHartaResponse>() {
            @Override
            public void onResponse(Call<JenisHartaResponse> call, Response<JenisHartaResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setJenisHartaModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<JenisHartaResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisHarta.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getGelar() {
        final Call<MasterGelarResponse> call = service.getMasterGelar();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterGelarResponse>() {
            @Override
            public void onResponse(Call<MasterGelarResponse> call, Response<MasterGelarResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setGelarModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterGelarResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getMasterGelar.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getPendidikanTerakhir() {
        final Call<MasterPendidikanTerakhirResponse> call = service.getMasterPendidikanTerakhir();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterPendidikanTerakhirResponse>() {
            @Override
            public void onResponse(Call<MasterPendidikanTerakhirResponse> call, Response<MasterPendidikanTerakhirResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setPendidikanTerakhirModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterPendidikanTerakhirResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getMasterPendidikanTerakhir.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getJenisPekerjaan() {
        final Call<JenisPekerjaanResponse> call = service.getMasterJenisPekerjaan();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<JenisPekerjaanResponse>() {
            @Override
            public void onResponse(Call<JenisPekerjaanResponse> call, Response<JenisPekerjaanResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setJenisPekerjaanModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<JenisPekerjaanResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisPekerjaan.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getJenisProdukUsaha() {
        final Call<JenisProdukUsahaResponse> call = service.getMasterJenisProdukUsaha();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<JenisProdukUsahaResponse>() {
            @Override
            public void onResponse(Call<JenisProdukUsahaResponse> call, Response<JenisProdukUsahaResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setJenisProdukUsahaModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<JenisProdukUsahaResponse> call, Throwable t) {
                Log.e(LOG_TAG, "getJenisProdukUsaha.onFailure " + t.getMessage());
                if (call.isCanceled())
                    return;

                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getBatasWilayah() {
        final Call<MasterBatasWilayahResponse> call = service.getMasterBatasWilayah();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterBatasWilayahResponse>() {
            @Override
            public void onResponse(Call<MasterBatasWilayahResponse> call, Response<MasterBatasWilayahResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setBatasWilayahModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterBatasWilayahResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getKondisiPermukaanTanah() {
        final Call<MasterKondisiPermukaanTanahResponse> call = service.getMasterKondisiPermukaanTanah();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterKondisiPermukaanTanahResponse>() {
            @Override
            public void onResponse(Call<MasterKondisiPermukaanTanahResponse> call, Response<MasterKondisiPermukaanTanahResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setKondisiPermukaanTanahModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterKondisiPermukaanTanahResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getStatusTanah() {
        final Call<MasterStatusTanahResponse> call = service.getStatusTanahResponse();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterStatusTanahResponse>() {
            @Override
            public void onResponse(Call<MasterStatusTanahResponse> call, Response<MasterStatusTanahResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setStatusTanahModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterStatusTanahResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getJenisBuktiKepemilikanAgunan() {
        final Call<MasterJenisBuktiKepemilikanAgunanResponse> call = service.getMasterJenisBuktiKepemilikanAngunanResponse();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterJenisBuktiKepemilikanAgunanResponse>() {
            @Override
            public void onResponse(Call<MasterJenisBuktiKepemilikanAgunanResponse> call, Response<MasterJenisBuktiKepemilikanAgunanResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    //dataManager.setJenisBuktiKepemilikanAgunanModelList(response.body().getList());
                    //onDataMasterCompleted(call, true);
                    List<JenisBuktiKepemilikanModel> list = response.body().getList();
                    for (JenisBuktiKepemilikanModel item : list) {
                        getBuktiKepemilikanAgunan(item.getId());
                    }
                    dataManager.setJenisBuktiKepemilikanAgunanModelList(list);
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterJenisBuktiKepemilikanAgunanResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getBuktiKepemilikanAgunan(final int idJenisBukti) {
        final Call<MasterBuktiKepemilikanAgunanResponse> call = service.getMasterBuktiKepemilikanAngunanResponse(idJenisBukti);
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterBuktiKepemilikanAgunanResponse>() {
            @Override
            public void onResponse(Call<MasterBuktiKepemilikanAgunanResponse> call, Response<MasterBuktiKepemilikanAgunanResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setBuktiKepemilikanAgunanModelList(idJenisBukti, response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterBuktiKepemilikanAgunanResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getPengelolaanUsaha() {
        final Call<MasterPengelolaanUsahaResponse> call = service.getMasterPengelolaanUsaha();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterPengelolaanUsahaResponse>() {
            @Override
            public void onResponse(Call<MasterPengelolaanUsahaResponse> call, Response<MasterPengelolaanUsahaResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setPengelolaanUsahaModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterPengelolaanUsahaResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getSaluranAir() {
        final Call<MasterSaluranAirResponse> call = service.getMasterSaluranAir();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterSaluranAirResponse>() {
            @Override
            public void onResponse(Call<MasterSaluranAirResponse> call, Response<MasterSaluranAirResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setSaluranAirModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterSaluranAirResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void getSaluranTelepon() {
        final Call<MasterSaluranTeleponResponse> call = service.getMasterSaluranTelepon();
        synchronized (LOCK) {
            queue.add(call);
        }
        call.enqueue(new Callback<MasterSaluranTeleponResponse>() {
            @Override
            public void onResponse(Call<MasterSaluranTeleponResponse> call, Response<MasterSaluranTeleponResponse> response) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    dataManager.setSaluranTeleponModelList(response.body().getList());
                    onDataMasterCompleted(call, true);
                } else {
                    onDataMasterCompleted(call, false);
                }
            }

            @Override
            public void onFailure(Call<MasterSaluranTeleponResponse> call, Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                onDataMasterCompleted(call, false);
            }
        });
    }

    private void onDataMasterCompleted(Call call, boolean success) {
        if (success) {
            synchronized (LOCK) {
                queue.remove(call);
                if (queue.size() == 0 && loginCallback != null) {
                    loginCallback.onLoginProcessCompleted();
                }
            }
        } else {
            synchronized (LOCK) {
                queue.remove(call);
                if (call.isCanceled()) {
                    return;
                }

                for (Call item : queue) {
                    item.cancel();
                }

                if (loginCallback != null) {
                    loginCallback.onLoginProcessNotCompleted(new Throwable("Loading data failed"));
                }
                appPreference.clearData();
            }
        }
    }

    public void cancel() {
        if (callLoginSSO != null)
            callLoginSSO.cancel();
        if (callLogin != null)
            callLogin.cancel();
    }
}
