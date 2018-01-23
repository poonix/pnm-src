package com.example.saifullah_albasrie.pnm.data;

import android.text.TextUtils;

import com.example.saifullah_albasrie.pnm.model.master.GelarModel;
import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganBankModel;
import com.example.saifullah_albasrie.pnm.model.master.HubunganDenganPNMModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisAgunanModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisDokumenModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisPekerjaanModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisProdukUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisProspekModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeBidangUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.KodeUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.PendidikanTerakhirModel;
import com.example.saifullah_albasrie.pnm.model.master.PengelolaanKeuanganModel;
import com.example.saifullah_albasrie.pnm.model.master.ProdukModel;
import com.example.saifullah_albasrie.pnm.model.master.ProgramModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.example.saifullah_albasrie.pnm.model.master.StatusDebiturModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.AtapModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BatasWilayahModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BentukTanahModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.BuktiKepemilikanAgunanModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.DindingModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JalanDilaluiModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JendelaModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.JenisBuktiKepemilikanModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.KondisiPermukaanTanahModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.KusenModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.LantaiModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PengelolaanUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PenggunaanTanahModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PeruntukanLokasiModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PintuModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PlafonModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.PondasiModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.SaluranAirModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.SaluranTeleponModel;
import com.example.saifullah_albasrie.pnm.model.master.masterJaminan.StatusTanahModel;
import com.example.saifullah_albasrie.pnm.model.master_new.BaseResponseNew;
import com.example.saifullah_albasrie.pnm.model.production_model.AgunanProspekModel;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class DataManager {

    private static final Object LOCK = new Object();
    private static DataManager sInstance;
    private static final AppPreference preference = AppPreference.getInstance();

    private List<JenisProspekModel> jenisProspekModelList;
    private List<JenisUsahaModel> jenisUsahaModelList;
    private List<StatusDebiturModel> statusDebiturModelList;

    private List<KodeBidangUsahaModel> kodeBidangUsahaModelList;
    private List<KodeUsahaModel> kodeUsahaModelList;
    private List<HubunganDenganPNMModel> hubunganDenganPNMModelList;
    private List<HubunganDenganBankModel> hubunganDenganBankModelList;
    private List<ProvinsiModel> provinsiModelList;

    private List<ProdukModel> produkModelList;
    private List<ProgramModel> programModelList;
    private List<JenisAgunanModel> jenisAgunanModelList;

    private List<JenisDokumenModel> jenisDokumenModelList;
    private List<JenisHartaModel> jenisHartaModelList;
    private List<GelarModel> gelarModelList;
    private List<PendidikanTerakhirModel> pendidikanTerakhirModelList;
    private List<JenisPekerjaanModel> jenisPekerjaanModelList;
    private List<JenisProdukUsahaModel> jenisProdukUsahaModelList;
    private List<PengelolaanKeuanganModel> pengelolaanKeuanganModelList;

    private List<AtapModel> atapModelList;
    private List<DindingModel> dindingModelList;
    private List<JendelaModel> jendelaModelList;
    private List<KusenModel> kusenModelList;
    private List<LantaiModel> lantaiModelList;
    private List<PintuModel> pintuModelList;
    private List<PlafonModel> plafonModelList;
    private List<PondasiModel> pondasiModelList;

    private List<BatasWilayahModel> batasWilayahModelList;
    private List<BentukTanahModel> bentukTanahModelList;
    private List<KondisiPermukaanTanahModel> kondisiPermukaanTanahModelList;
    private List<PenggunaanTanahModel> penggunaanTanahModelList;
    private List<StatusTanahModel> statusTanahModelList;

    private List<JenisBuktiKepemilikanModel> jenisBuktiKepemilikanAngunanModelList;
    private List<BuktiKepemilikanAgunanModel> buktiKepemilikanAngunanModelList;
    private List<PengelolaanUsahaModel> pengelolaanUsahaModelList;
    private List<JalanDilaluiModel> jalanDilaluiModelList;
    private List<PeruntukanLokasiModel> peruntukanLokasiModelList;
    private List<SaluranAirModel> saluranAirModelList;
    private List<SaluranTeleponModel> saluranTeleponModelList;

    private List<BaseResponseNew> MasterUsahaNewList;
    private List<BaseResponseNew> MasterIdentitasNewList;
    private List<BaseResponseNew> MasterJenisRefensiNewList;
    /*----------------------------------------Start Andityo Added 23 Jan 2018-----------------------------------------------------------*/
    private List<BaseResponseNew> MasterStatusPerkawinanNewList;
    private List<BaseResponseNew> MasterKewarganegaraanNewList;
    private List<BaseResponseNew> MasterAgamaNewList;
    private List<BaseResponseNew> MasterPekerjaanNewList;
    private List<BaseResponseNew> MasterJenisAlamatNewList;
    private List<BaseResponseNew> MasterHubunganKeluargaNewList;
    private List<BaseResponseNew> MasterTujuanPembiayaanNewList;
    private List<BaseResponseNew> MasterJenisAgunanNewList;
    private List<BaseResponseNew> MasterJenisKontakNewList;
    private List<BaseResponseNew> MasterStatusTempatNewList;
    private List<BaseResponseNew> MasterPendidikanNewList;
    private List<BaseResponseNew> MasterProdukNewList;
    private List<BaseResponseNew> MasterJenisDokumenNewList;
    private List<BaseResponseNew> MasterLokasiNewList;
    private List<BaseResponseNew> MasterHubunganPemohonNewList;
    private List<BaseResponseNew> MasterKerjasamaPemohonNewList;
    private List<BaseResponseNew> MasterTrackRecordNewList;
    private List<BaseResponseNew> MasterMengenalUlaamNewList;
    private List<BaseResponseNew> MasterReputasiNewList;
    private List<BaseResponseNew> MasterHartaNewList;
    private List<BaseResponseNew> MasterPengelolaanKeuanganNewList;
    private List<BaseResponseNew> MasterBentukUsahaNewList;
    private List<BaseResponseNew> MasterJenisBadanUsahaNewList;
    private List<BaseResponseNew> MasterKegiatanUsahaNewList;
    private List<BaseResponseNew> MasterAksesKendaraanNewList;
    private List<BaseResponseNew> MasterProdukYangDitawarkanNewList;
    private List<BaseResponseNew> MasterJumlahPemasokNewList;
    private List<BaseResponseNew> MasterPersainganUsahaNewList;
    private List<BaseResponseNew> MasterKondisiSektorUsahaNewList;
    private List<BaseResponseNew> MasterLokasiUsahaNewList;
    private List<BaseResponseNew> MasterPeriodeNewList;
    private List<BaseResponseNew> MasterPembayaranNewList;
    private List<BaseResponseNew> MasterProgramNewList;
    private List<BaseResponseNew> MasterBankNewList;
    private List<BaseResponseNew> MasterKolektibilitasNewList;
    private List<BaseResponseNew> MasterJenisAssetNewList;
    private List<BaseResponseNew> MasterPenilaianNewList;
    private List<BaseResponseNew> MasterKepemilikanNewList;
    private List<BaseResponseNew> MasterBuktiKepemilikanAgunanNewList;
    private List<BaseResponseNew> MasterPeruntukanLokasiNewList;
    private List<BaseResponseNew> MasterJalanDilaluiNewList;
    private List<BaseResponseNew> MasterBentukTanahNewList;
    private List<BaseResponseNew> MasterKondisiPermukaanNewList;
    private List<BaseResponseNew> MasterPenggunaanTanahNewList;
    private List<BaseResponseNew> MasterBatasNewList;
    private List<BaseResponseNew> MasterAirNewList;
    private List<BaseResponseNew> MasterJenisIdentitasNewList;
    private List<BaseResponseNew> MasterJenisKelaminNewList;
    private List<BaseResponseNew> MasterJenisProspekNewList;
    private List<BaseResponseNew> MasterJenisUsahaNewList;
    private List<BaseResponseNew> MasterKodeUsahaNewList;
    private List<BaseResponseNew> MasterKodeBidangUsahaNewList;
    private List<BaseResponseNew> MasterHubunganDenganBankaNewList;
    private List<BaseResponseNew> MasterHubunganPnmNewList;
    /*----------------------------------------END Andityo Added 23 Jan 2018-----------------------------------------------------------*/
    private List<BaseResponseNew> MasterDataNewList;

    public static DataManager getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new DataManager();
            }
        }
        return sInstance;
    }

    public DataManager() {

    }

    public List<JenisProspekModel> getJenisProspekModelList() {
        if (jenisProspekModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_PROSPEK);
            if (!TextUtils.isEmpty(sJson)) {
                jenisProspekModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisProspekModel>>() {
                }.getType());
            }
        }
        return jenisProspekModelList;
    }

    public void setJenisProspekModelList(List<JenisProspekModel> jenisProspekModelList) {
        if (jenisProspekModelList == null) {
            jenisProspekModelList = new ArrayList<>();
        }
        JenisProspekModel modelFirst = new JenisProspekModel();
        modelFirst.setJenisProspek("Pilih");
        if (!jenisProspekModelList.contains(modelFirst)) {
            jenisProspekModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisProspekModelList);
        preference.set(AppPreference.MASTER_JENIS_PROSPEK, sJson);
        this.jenisProspekModelList = jenisProspekModelList;
    }

    public List<JenisUsahaModel> getJenisUsahaModelList() {
        if (jenisUsahaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_USAHA);
            if (!TextUtils.isEmpty(sJson)) {
                jenisUsahaModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisUsahaModel>>() {
                }.getType());
            }
        }
        return jenisUsahaModelList;
    }

    public void setJenisUsahaModelList(List<JenisUsahaModel> jenisUsahaModelList) {
        if (jenisUsahaModelList == null) {
            jenisUsahaModelList = new ArrayList<>();
        }
        JenisUsahaModel modelFirst = new JenisUsahaModel();
        modelFirst.setNamaJenisUsaha("Pilih");
        if (!jenisUsahaModelList.contains(modelFirst)) {
            jenisUsahaModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisUsahaModelList);
        preference.set(AppPreference.MASTER_JENIS_USAHA, sJson);
        this.jenisUsahaModelList = jenisUsahaModelList;
    }

    public List<StatusDebiturModel> getStatusDebiturModelList() {
        return statusDebiturModelList;
    }

    public void setStatusDebiturModelList(List<StatusDebiturModel> statusDebiturModelList) {
        this.statusDebiturModelList = statusDebiturModelList;
    }

    public List<KodeBidangUsahaModel> getKodeBidangUsahaModelList() {
        if (kodeBidangUsahaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_KODE_BIDANG_USAHA);
            if (!TextUtils.isEmpty(sJson)) {
                kodeBidangUsahaModelList = new Gson().fromJson(sJson, new TypeToken<List<KodeBidangUsahaModel>>() {
                }.getType());
            }
        }
        return kodeBidangUsahaModelList;
    }

    public void setKodeBidangUsahaModelList(List<KodeBidangUsahaModel> kodeBidangUsahaModelList) {
        if (kodeBidangUsahaModelList == null) {
            kodeBidangUsahaModelList = new ArrayList<>();
        }
        KodeBidangUsahaModel modelFirst = new KodeBidangUsahaModel();
        modelFirst.setDeskripsi("Pilih");
        if (!kodeBidangUsahaModelList.contains(modelFirst)) {
            kodeBidangUsahaModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(kodeBidangUsahaModelList);
        preference.set(AppPreference.MASTER_KODE_BIDANG_USAHA, sJson);
        this.kodeBidangUsahaModelList = kodeBidangUsahaModelList;
    }

    public List<KodeUsahaModel> getKodeUsahaModelList() {
        if (kodeUsahaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_KODE_USAHA);
            if (!TextUtils.isEmpty(sJson)) {
                kodeUsahaModelList = new Gson().fromJson(sJson, new TypeToken<List<KodeUsahaModel>>() {
                }.getType());
            }
        }
        return kodeUsahaModelList;
    }

    public void setKodeUsahaModelList(List<KodeUsahaModel> kodeUsahaModelList) {
        if (kodeUsahaModelList == null) {
            kodeUsahaModelList = new ArrayList<>();
        }
        KodeUsahaModel modelFirst = new KodeUsahaModel();
        modelFirst.setDeskripsi("Pilih");
        if (!kodeUsahaModelList.contains(modelFirst)) {
            kodeUsahaModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(kodeUsahaModelList);
        preference.set(AppPreference.MASTER_KODE_USAHA, sJson);
        this.kodeUsahaModelList = kodeUsahaModelList;
    }

    public List<HubunganDenganPNMModel> getHubunganDenganPNMModelList() {
        if (hubunganDenganPNMModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_HUB_PNM);
            if (!TextUtils.isEmpty(sJson)) {
                hubunganDenganPNMModelList = new Gson().fromJson(sJson, new TypeToken<List<HubunganDenganPNMModel>>() {
                }.getType());
            }
        }
        return hubunganDenganPNMModelList;
    }

    public void setHubunganDenganPNMModelList(List<HubunganDenganPNMModel> hubunganDenganPNMModelList) {
        if (hubunganDenganPNMModelList == null) {
            hubunganDenganPNMModelList = new ArrayList<>();
        }
        HubunganDenganPNMModel modelFirst = new HubunganDenganPNMModel();
        modelFirst.setDeskripsi("Pilih");
        if (!hubunganDenganPNMModelList.contains(modelFirst)) {
            hubunganDenganPNMModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(hubunganDenganPNMModelList);
        preference.set(AppPreference.MASTER_HUB_PNM, sJson);
        this.hubunganDenganPNMModelList = hubunganDenganPNMModelList;
    }

    public List<HubunganDenganBankModel> getHubunganDenganBankModelList() {
        if (hubunganDenganBankModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_HUB_BANK);
            if (!TextUtils.isEmpty(sJson)) {
                hubunganDenganBankModelList = new Gson().fromJson(sJson, new TypeToken<List<HubunganDenganBankModel>>() {
                }.getType());
            }
        }
        return hubunganDenganBankModelList;
    }

    public void setHubunganDenganBankModelList(List<HubunganDenganBankModel> hubunganDenganBankModelList) {
        if (hubunganDenganBankModelList == null) {
            hubunganDenganBankModelList = new ArrayList<>();
        }
        HubunganDenganBankModel modelFirst = new HubunganDenganBankModel();
        modelFirst.setDeskripsi("Pilih");
        if (!hubunganDenganBankModelList.contains(modelFirst)) {
            hubunganDenganBankModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(hubunganDenganBankModelList);
        preference.set(AppPreference.MASTER_HUB_BANK, sJson);
        this.hubunganDenganBankModelList = hubunganDenganBankModelList;
    }

    public List<ProvinsiModel> getProvinsiModelList() {
        if (provinsiModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PROVINSI);
            if (!TextUtils.isEmpty(sJson)) {
                provinsiModelList = new Gson().fromJson(sJson, new TypeToken<List<ProvinsiModel>>() {
                }.getType());
            }
        }
        return provinsiModelList;
    }

    public void setProvinsiModelList(List<ProvinsiModel> provinsiModelList) {
        if (provinsiModelList == null) {
            provinsiModelList = new ArrayList<>();
        }
        ProvinsiModel modelFirst = new ProvinsiModel();
        modelFirst.setNamaProvinsi("Pilih");
        if (!provinsiModelList.contains(modelFirst)) {
            provinsiModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(provinsiModelList);
        preference.set(AppPreference.MASTER_PROVINSI, sJson);
        this.provinsiModelList = provinsiModelList;
    }

    public List<ProdukModel> getProdukModelList() {
        if (produkModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PRODUK);
            if (!TextUtils.isEmpty(sJson)) {
                produkModelList = new Gson().fromJson(sJson, new TypeToken<List<ProdukModel>>() {
                }.getType());
            }
        }
        return produkModelList;
    }

    public void setProdukModelList(List<ProdukModel> produkModelList) {
        ProdukModel modelFirst = new ProdukModel();
        modelFirst.setNamaProduk("Pilih");
        if (!produkModelList.contains(modelFirst)) {
            produkModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(produkModelList);
        preference.set(AppPreference.MASTER_PRODUK, sJson);
        this.produkModelList = produkModelList;
    }

    public List<ProgramModel> getProgramModelList() {
        if (programModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PROGRAM);
            if (!TextUtils.isEmpty(sJson)) {
                programModelList = new Gson().fromJson(sJson, new TypeToken<List<ProgramModel>>() {
                }.getType());
            }
        }
        return programModelList;
    }

    public void setProgramModelList(List<ProgramModel> programModelList) {
        if (programModelList == null) {
            programModelList = new ArrayList<>();
        }
        ProgramModel modelFirst = new ProgramModel();
        modelFirst.setNamaProgram("Pilih");
        if (!programModelList.contains(modelFirst)) {
            programModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(programModelList);
        preference.set(AppPreference.MASTER_PROGRAM, sJson);
        this.programModelList = programModelList;
    }

    public List<JenisAgunanModel> getJenisAgunanModelList() {
        if (jenisAgunanModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_AGUNAN);
            if (!TextUtils.isEmpty(sJson)) {
                jenisAgunanModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisAgunanModel>>() {
                }.getType());
            }
        }
        return jenisAgunanModelList;
    }

    public void setJenisAgunanModelList(List<JenisAgunanModel> jenisAgunanModelList) {
        JenisAgunanModel modelFirst = new JenisAgunanModel();
        modelFirst.setJenisAgunan("Pilih");
        if (!jenisAgunanModelList.contains(modelFirst)) {
            jenisAgunanModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisAgunanModelList);
        preference.set(AppPreference.MASTER_JENIS_AGUNAN, sJson);
        this.jenisAgunanModelList = jenisAgunanModelList;
    }

    public List<JenisDokumenModel> getJenisDokumenModelList() {
        if (jenisDokumenModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_DOKUMEN);
            if (!TextUtils.isEmpty(sJson)) {
                jenisDokumenModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisDokumenModel>>() {
                }.getType());
            }
        }
        return jenisDokumenModelList;
    }

    public void setJenisDokumenModelList(List<JenisDokumenModel> jenisDokumenModelList) {
        JenisDokumenModel modelFirst = new JenisDokumenModel();
        modelFirst.setJenisDokumen("Pilih");
        if (!jenisDokumenModelList.contains(modelFirst)) {
            jenisDokumenModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisDokumenModelList);
        preference.set(AppPreference.MASTER_JENIS_DOKUMEN, sJson);
        this.jenisDokumenModelList = jenisDokumenModelList;
    }

    public List<JenisHartaModel> getJenisHartaModelList() {
        if (jenisHartaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_HARTA);
            if (!TextUtils.isEmpty(sJson)) {
                jenisHartaModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisHartaModel>>() {
                }.getType());
            }
        }
        return jenisHartaModelList;
    }

    public void setJenisHartaModelList(List<JenisHartaModel> jenisHartaModelList) {
        /*JenisHartaModel modelFirst = new JenisHartaModel();
        modelFirst.setNamaHartaBenda("Pilih");
        if(!jenisHartaModelList.contains(modelFirst)) {
            jenisHartaModelList.add(0, modelFirst);
        }*/

        String sJson = new Gson().toJson(jenisHartaModelList);
        preference.set(AppPreference.MASTER_JENIS_HARTA, sJson);
        this.jenisHartaModelList = jenisHartaModelList;
    }

    public List<GelarModel> getGelarModelList() {
        if (gelarModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_GELAR);
            if (!TextUtils.isEmpty(sJson)) {
                gelarModelList = new Gson().fromJson(sJson, new TypeToken<List<GelarModel>>() {
                }.getType());
            }
        }
        return gelarModelList;
    }

    public void setGelarModelList(List<GelarModel> gelarModelList) {
        GelarModel modelFirst = new GelarModel();
        modelFirst.setGelar("Pilih");
        if (!gelarModelList.contains(modelFirst)) {
            gelarModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(gelarModelList);
        preference.set(AppPreference.MASTER_GELAR, sJson);
        this.gelarModelList = gelarModelList;
    }

    public List<PendidikanTerakhirModel> getPendidikanTerakhirModelList() {
        if (pendidikanTerakhirModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PENDIDIKAN_TERAKHIR);
            if (!TextUtils.isEmpty(sJson)) {
                pendidikanTerakhirModelList = new Gson().fromJson(sJson, new TypeToken<List<PendidikanTerakhirModel>>() {
                }.getType());
            }
        }
        return pendidikanTerakhirModelList;
    }

    public void setPendidikanTerakhirModelList(List<PendidikanTerakhirModel> pendidikanTerakhirModelList) {
        PendidikanTerakhirModel modelFirst = new PendidikanTerakhirModel();
        modelFirst.setPendidikan("Pilih");
        if (!pendidikanTerakhirModelList.contains(modelFirst)) {
            pendidikanTerakhirModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(pendidikanTerakhirModelList);
        preference.set(AppPreference.MASTER_PENDIDIKAN_TERAKHIR, sJson);
        this.pendidikanTerakhirModelList = pendidikanTerakhirModelList;
    }

    public List<JenisPekerjaanModel> getJenisPekerjaanModelList() {
        if (jenisPekerjaanModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_PEKERJAAN);
            if (!TextUtils.isEmpty(sJson)) {
                jenisPekerjaanModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisPekerjaanModel>>() {
                }.getType());
            }
        }
        return jenisPekerjaanModelList;
    }

    public void setJenisPekerjaanModelList(List<JenisPekerjaanModel> jenisPekerjaanModelList) {
        JenisPekerjaanModel modelFirst = new JenisPekerjaanModel();
        modelFirst.setNamaPekerjaan("Pilih");
        if (!jenisPekerjaanModelList.contains(modelFirst)) {
            jenisPekerjaanModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisPekerjaanModelList);
        preference.set(AppPreference.MASTER_JENIS_PEKERJAAN, sJson);
        this.jenisPekerjaanModelList = jenisPekerjaanModelList;
    }

    public List<JenisProdukUsahaModel> getJenisProdukUsahaModelList() {
        if (jenisProdukUsahaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_PRODUK_USAHA);
            if (!TextUtils.isEmpty(sJson)) {
                jenisProdukUsahaModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisProdukUsahaModel>>() {
                }.getType());
            }
        }
        return jenisProdukUsahaModelList;
    }

    public void setJenisProdukUsahaModelList(List<JenisProdukUsahaModel> jenisProdukUsahaModelList) {
        JenisProdukUsahaModel modelFirst = new JenisProdukUsahaModel();
        modelFirst.setNamaProdukUsaha("Pilih");
        if (!jenisProdukUsahaModelList.contains(modelFirst)) {
            jenisProdukUsahaModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(jenisProdukUsahaModelList);
        preference.set(AppPreference.MASTER_JENIS_PRODUK_USAHA, sJson);
        this.jenisProdukUsahaModelList = jenisProdukUsahaModelList;
    }

    public List<PengelolaanKeuanganModel> getPengelolaanKeuanganModelList() {
        if (pengelolaanKeuanganModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PENGELOLAAN_KEUANGAN);
            if (!TextUtils.isEmpty(sJson)) {
                pengelolaanKeuanganModelList = new Gson().fromJson(sJson, new TypeToken<List<PengelolaanKeuanganModel>>() {
                }.getType());
            }
        }
        return pengelolaanKeuanganModelList;
    }

    public void setPengelolaanKeuanganModelList(List<PengelolaanKeuanganModel> pengelolaanKeuanganModelList) {
        PengelolaanKeuanganModel modelFirst = new PengelolaanKeuanganModel();
        modelFirst.setDetail("Pilih");
        if (!pengelolaanKeuanganModelList.contains(modelFirst)) {
            pengelolaanKeuanganModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(pengelolaanKeuanganModelList);
        preference.set(AppPreference.MASTER_PENGELOLAAN_KEUANGAN, sJson);
        this.pengelolaanKeuanganModelList = pengelolaanKeuanganModelList;
    }


    //MASTER JAMINAN
    public List<AtapModel> getAtapModelList() {
        if (atapModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_ATAP);
            if (!TextUtils.isEmpty(sJson)) {
                atapModelList = new Gson().fromJson(sJson, new TypeToken<List<AtapModel>>() {
                }.getType());
            }
        }
        return atapModelList;
    }

    public void setAtapModelList(List<AtapModel> atapModelList) {
        AtapModel modelFirst = new AtapModel();
        modelFirst.setAtap("Pilih");
        if (!atapModelList.contains(modelFirst)) {
            atapModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(atapModelList);
        preference.set(AppPreference.MASTER_ATAP, sJson);
        this.atapModelList = atapModelList;
    }

    public List<DindingModel> getDindingModelList() {
        if (dindingModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_DINDING);
            if (!TextUtils.isEmpty(sJson)) {
                dindingModelList = new Gson().fromJson(sJson, new TypeToken<List<DindingModel>>() {
                }.getType());
            }
        }
        return dindingModelList;
    }

    public void setDindingModelList(List<DindingModel> dindingModelList) {
        DindingModel modelFirst = new DindingModel();
        modelFirst.setDinding("Pilih");
        if (!dindingModelList.contains(modelFirst)) {
            dindingModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(dindingModelList);
        preference.set(AppPreference.MASTER_DINDING, sJson);
        this.dindingModelList = dindingModelList;
    }

    public List<JendelaModel> getJendelaModelList() {
        if (jendelaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENDELA);
            if (!TextUtils.isEmpty(sJson)) {
                jendelaModelList = new Gson().fromJson(sJson, new TypeToken<List<JendelaModel>>() {
                }.getType());
            }
        }
        return jendelaModelList;
    }

    public void setJendelaModelList(List<JendelaModel> jendelaModelList) {
        JendelaModel modelFirst = new JendelaModel();
        modelFirst.setJendela("Pilih");
        if (!jendelaModelList.contains(modelFirst)) {
            jendelaModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(jendelaModelList);
        preference.set(AppPreference.MASTER_JENDELA, sJson);
        this.jendelaModelList = jendelaModelList;
    }

    public List<KusenModel> getKusenModelList() {
        if (kusenModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_KUSEN);
            if (!TextUtils.isEmpty(sJson)) {
                kusenModelList = new Gson().fromJson(sJson, new TypeToken<List<KusenModel>>() {
                }.getType());
            }
        }
        return kusenModelList;
    }

    public void setKusenModelList(List<KusenModel> kusenModelList) {
        KusenModel modelFirst = new KusenModel();
        modelFirst.setKusen("Pilih");
        if (!kusenModelList.contains(modelFirst)) {
            kusenModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(kusenModelList);
        preference.set(AppPreference.MASTER_KUSEN, sJson);
        this.kusenModelList = kusenModelList;
    }

    public List<LantaiModel> getLantaiModelList() {
        if (lantaiModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_LANTAI);
            if (!TextUtils.isEmpty(sJson)) {
                lantaiModelList = new Gson().fromJson(sJson, new TypeToken<List<LantaiModel>>() {
                }.getType());
            }
        }
        return lantaiModelList;
    }

    public void setLantaiModelList(List<LantaiModel> lantaiModelList) {
        LantaiModel modelFirst = new LantaiModel();
        modelFirst.setLantai("Pilih");
        if (!lantaiModelList.contains(modelFirst)) {
            lantaiModelList.add(0, modelFirst);
        }

        String sJson = new Gson().toJson(lantaiModelList);
        preference.set(AppPreference.MASTER_LANTAI, sJson);
        this.lantaiModelList = lantaiModelList;
    }

    public List<PintuModel> getPintuModelList() {
        if (pintuModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PINTU);
            if (!TextUtils.isEmpty(sJson)) {
                pintuModelList = new Gson().fromJson(sJson, new TypeToken<List<PintuModel>>() {
                }.getType());
            }
        }
        return pintuModelList;
    }

    public void setPintuModelList(List<PintuModel> pintuModelList) {
        PintuModel modelFirst = new PintuModel();
        modelFirst.setPintu("Pilih");
        if (!pintuModelList.contains(modelFirst)) {
            pintuModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(pintuModelList);
        preference.set(AppPreference.MASTER_PINTU, sJson);
        this.pintuModelList = pintuModelList;
    }

    public List<PlafonModel> getPlafonModelList() {
        if (plafonModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PLAFON);
            if (!TextUtils.isEmpty(sJson)) {
                plafonModelList = new Gson().fromJson(sJson, new TypeToken<List<PlafonModel>>() {
                }.getType());
            }
        }
        return plafonModelList;
    }

    public void setPlafonModelList(List<PlafonModel> plafonModelList) {
        PlafonModel modelFirst = new PlafonModel();
        modelFirst.setPlafon("Pilih");
        if (!plafonModelList.contains(modelFirst)) {
            plafonModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(plafonModelList);
        preference.set(AppPreference.MASTER_PLAFON, sJson);
        this.plafonModelList = plafonModelList;
    }

    public List<PondasiModel> getPondasiModelList() {
        if (pondasiModelList == null) {
            String sJon = preference.getString(AppPreference.MASTER_PONDASI);
            if (!TextUtils.isEmpty(sJon)) {
                pondasiModelList = new Gson().fromJson(sJon, new TypeToken<List<PondasiModel>>() {
                }.getType());
            }
        }
        return pondasiModelList;
    }

    public void setPondasiModelList(List<PondasiModel> pondasiModelList) {
        PondasiModel modelFirst = new PondasiModel();
        modelFirst.setPondasi("Pilih");
        if (!pondasiModelList.contains(modelFirst)) {
            pondasiModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(pondasiModelList);
        preference.set(AppPreference.MASTER_PONDASI, sJson);
        this.pondasiModelList = pondasiModelList;
    }

    public List<BatasWilayahModel> getBatasWilayahModelList() {
        if (batasWilayahModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_BATAS_WILAYAH);
            if (!TextUtils.isEmpty(sJson)) {
                batasWilayahModelList = new Gson().fromJson(sJson, new TypeToken<List<BatasWilayahModel>>() {
                }.getType());
            }
        }
        return batasWilayahModelList;
    }

    public void setBatasWilayahModelList(List<BatasWilayahModel> batasWilayahModelList) {
        BatasWilayahModel modelFirst = new BatasWilayahModel();
        modelFirst.setBatasWilayah("Pilih");
        if (!batasWilayahModelList.contains(modelFirst)) {
            batasWilayahModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(batasWilayahModelList);
        preference.set(AppPreference.MASTER_BATAS_WILAYAH, sJson);
        this.batasWilayahModelList = batasWilayahModelList;
    }

    public List<BentukTanahModel> getBentukTanahModelList() {
        if (bentukTanahModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_BENTUK_TANAH);
            if (!TextUtils.isEmpty(sJson)) {
                bentukTanahModelList = new Gson().fromJson(sJson, new TypeToken<List<BentukTanahModel>>() {
                }.getType());
            }
        }
        return bentukTanahModelList;
    }

    public void setBentukTanahModelList(List<BentukTanahModel> bentukTanahModelList) {
        BentukTanahModel modelFirst = new BentukTanahModel();
        modelFirst.setBentukTanah("Pilih");
        if (!bentukTanahModelList.contains(modelFirst)) {
            bentukTanahModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(bentukTanahModelList);
        preference.set(AppPreference.MASTER_BENTUK_TANAH, sJson);
        this.bentukTanahModelList = bentukTanahModelList;
    }

    public List<KondisiPermukaanTanahModel> getKondisiPermukaanTanahModelList() {
        if (kondisiPermukaanTanahModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_KONDISI_PERMUKAAN_TANAH);
            if (!TextUtils.isEmpty(sJson)) {
                kondisiPermukaanTanahModelList = new Gson().fromJson(sJson, new TypeToken<List<KondisiPermukaanTanahModel>>() {
                }.getType());
            }
        }
        return kondisiPermukaanTanahModelList;
    }

    public void setKondisiPermukaanTanahModelList(List<KondisiPermukaanTanahModel> kondisiPermukaanTanahModelList) {
        KondisiPermukaanTanahModel modelFirst = new KondisiPermukaanTanahModel();
        modelFirst.setKondisiTanah("Pilih");
        if (!kondisiPermukaanTanahModelList.contains(modelFirst)) {
            kondisiPermukaanTanahModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(kondisiPermukaanTanahModelList);
        preference.set(AppPreference.MASTER_KONDISI_PERMUKAAN_TANAH, sJson);
        this.kondisiPermukaanTanahModelList = kondisiPermukaanTanahModelList;
    }

    public List<PenggunaanTanahModel> getPenggunaanTanahModelList() {
        if (penggunaanTanahModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PENGGUNAAN_TANAH);
            if (!TextUtils.isEmpty(sJson)) {
                penggunaanTanahModelList = new Gson().fromJson(sJson, new TypeToken<List<PenggunaanTanahModel>>() {
                }.getType());
            }
        }
        return penggunaanTanahModelList;
    }

    public void setPenggunaanTanahModelList(List<PenggunaanTanahModel> penggunaanTanahModelList) {
        PenggunaanTanahModel modelFirst = new PenggunaanTanahModel();
        modelFirst.setPenggunaanTanah("Pilih");
        if (!penggunaanTanahModelList.contains(modelFirst)) {
            penggunaanTanahModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(penggunaanTanahModelList);
        preference.set(AppPreference.MASTER_PENGGUNAAN_TANAH, sJson);
        this.penggunaanTanahModelList = penggunaanTanahModelList;
    }

    public List<StatusTanahModel> getStatusTanahModelList() {
        if (statusTanahModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_STATUS_TANAH);
            if (!TextUtils.isEmpty(sJson)) {
                statusTanahModelList = new Gson().fromJson(sJson, new TypeToken<List<StatusTanahModel>>() {
                }.getType());
            }
        }
        return statusTanahModelList;
    }

    public void setStatusTanahModelList(List<StatusTanahModel> statusTanahModelList) {
        StatusTanahModel modelFirst = new StatusTanahModel();
        modelFirst.setStatusTanah("Pilih");
        if (!statusTanahModelList.contains(modelFirst)) {
            statusTanahModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(statusTanahModelList);
        preference.set(AppPreference.MASTER_STATUS_TANAH, sJson);
        this.statusTanahModelList = statusTanahModelList;
    }

    public List<JenisBuktiKepemilikanModel> getJenisBuktiKepemilikanAgunanModelList() {
        if (jenisBuktiKepemilikanAngunanModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JENIS_BUKTI_KEPEMILIKAN_AGUNAN);
            if (!TextUtils.isEmpty(sJson)) {
                jenisBuktiKepemilikanAngunanModelList = new Gson().fromJson(sJson, new TypeToken<List<JenisBuktiKepemilikanModel>>() {
                }.getType());
            }
        }
        return jenisBuktiKepemilikanAngunanModelList;
    }

    public void setJenisBuktiKepemilikanAgunanModelList(List<JenisBuktiKepemilikanModel> jenisBuktiKepemilikanAngunanModelList) {
        JenisBuktiKepemilikanModel modelFirst = new JenisBuktiKepemilikanModel();
        modelFirst.setJenisBukti("Pilih");
        if (!jenisBuktiKepemilikanAngunanModelList.contains(modelFirst)) {
            jenisBuktiKepemilikanAngunanModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(jenisBuktiKepemilikanAngunanModelList);
        preference.set(AppPreference.MASTER_JENIS_BUKTI_KEPEMILIKAN_AGUNAN, sJson);
        this.jenisBuktiKepemilikanAngunanModelList = jenisBuktiKepemilikanAngunanModelList;
    }

    /*
    public List<BuktiKepemilikanAgunanModel> getBuktiKepemilikanAgunanModelList() {
        if (buktiKepemilikanAngunanModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_BUKTI_KEPEMILIKAN_AGUNAN);
            if (!TextUtils.isEmpty(sJson)) {
                buktiKepemilikanAngunanModelList = new Gson().fromJson(sJson, new TypeToken<List<BuktiKepemilikanAgunanModel>>() {
                }.getType());
            }
        }
        return buktiKepemilikanAngunanModelList;
    }

    public void setBuktiKepemilikanAgunanModelList(List<BuktiKepemilikanAgunanModel> buktiKepemilikanAngunanModelList) {
        BuktiKepemilikanAgunanModel modelFirst = new BuktiKepemilikanAgunanModel();
        modelFirst.setJenisKepemilikan("Pilih");
        if (!buktiKepemilikanAngunanModelList.contains(modelFirst)) {
            buktiKepemilikanAngunanModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(buktiKepemilikanAngunanModelList);
        preference.set(AppPreference.MASTER_BUKTI_KEPEMILIKAN_AGUNAN, sJson);
        this.buktiKepemilikanAngunanModelList = buktiKepemilikanAngunanModelList;
    }
    */

    public List<BuktiKepemilikanAgunanModel> getBuktiKepemilikanAgunanModelList(int idJenisBukti) {
        List<BuktiKepemilikanAgunanModel> buktiKepemilikanAngunanModelList = new ArrayList<>();
//        BuktiKepemilikanAgunanModel modelFirst = new BuktiKepemilikanAgunanModel();
//        modelFirst.setJenisKepemilikan("Pilih");
//        buktiKepemilikanAngunanModelList.add(modelFirst);

        String sJson = preference.getString(AppPreference.MASTER_BUKTI_KEPEMILIKAN_AGUNAN + "_" + String.valueOf(idJenisBukti));
        if (!TextUtils.isEmpty(sJson)) {
            buktiKepemilikanAngunanModelList = new Gson().fromJson(sJson, new TypeToken<List<BuktiKepemilikanAgunanModel>>() {
            }.getType());
        }

        return buktiKepemilikanAngunanModelList;
    }

    public void setBuktiKepemilikanAgunanModelList(int idJenisBukti, List<BuktiKepemilikanAgunanModel> buktiKepemilikanAngunanModelList) {
        BuktiKepemilikanAgunanModel modelFirst = new BuktiKepemilikanAgunanModel();
        modelFirst.setJenisKepemilikan("Pilih");
        if (!buktiKepemilikanAngunanModelList.contains(modelFirst)) {
            buktiKepemilikanAngunanModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(buktiKepemilikanAngunanModelList);
        preference.set(AppPreference.MASTER_BUKTI_KEPEMILIKAN_AGUNAN + "_" + String.valueOf(idJenisBukti), sJson);
    }

    public List<PengelolaanUsahaModel> getPengelolaanUsahaModelList() {
        if (pengelolaanUsahaModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PENGELOLAAN_USAHA);
            if (!TextUtils.isEmpty(sJson)) {
                pengelolaanUsahaModelList = new Gson().fromJson(sJson, new TypeToken<List<PengelolaanUsahaModel>>() {
                }.getType());
            }
        }
        return pengelolaanUsahaModelList;
    }

    public void setPengelolaanUsahaModelList(List<PengelolaanUsahaModel> pengelolaanUsahaModelList) {
        PengelolaanUsahaModel modelFirst = new PengelolaanUsahaModel();
        modelFirst.setJenisPengelolaan("Pilih");
        if (!pengelolaanUsahaModelList.contains(modelFirst)) {
            pengelolaanUsahaModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(pengelolaanUsahaModelList);
        preference.set(AppPreference.MASTER_PENGELOLAAN_USAHA, sJson);

        this.pengelolaanUsahaModelList = pengelolaanUsahaModelList;
    }

    public List<JalanDilaluiModel> getJalanDilaluiModelList() {
        if (jalanDilaluiModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_JALAN_DILALUI);
            if (!TextUtils.isEmpty(sJson)) {
                jalanDilaluiModelList = new Gson().fromJson(sJson, new TypeToken<List<JalanDilaluiModel>>() {
                }.getType());
            }
        }
        return jalanDilaluiModelList;
    }

    public void setJalanDilaluiModelList(List<JalanDilaluiModel> jalanDilaluiModelList) {
        JalanDilaluiModel modelFirst = new JalanDilaluiModel();
        modelFirst.setJalanDilalui("Pilih");
        if (!jalanDilaluiModelList.contains(modelFirst)) {
            jalanDilaluiModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(jalanDilaluiModelList);
        preference.set(AppPreference.MASTER_JALAN_DILALUI, sJson);
        this.jalanDilaluiModelList = jalanDilaluiModelList;
    }

    public List<PeruntukanLokasiModel> getPeruntukanLokasiModelList() {
        if (peruntukanLokasiModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_PERUNTUKAN_LOKASI);
            if (!TextUtils.isEmpty(sJson)) {
                peruntukanLokasiModelList = new Gson().fromJson(sJson, new TypeToken<List<PeruntukanLokasiModel>>() {
                }.getType());
            }
        }
        return peruntukanLokasiModelList;
    }

    public void setPeruntukanLokasiModelList(List<PeruntukanLokasiModel> peruntukanLokasiModelList) {
        PeruntukanLokasiModel modelFirst = new PeruntukanLokasiModel();
        modelFirst.setPeruntukanLokasi("Pilih");
        if (!peruntukanLokasiModelList.contains(modelFirst)) {
            peruntukanLokasiModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(peruntukanLokasiModelList);
        preference.set(AppPreference.MASTER_PERUNTUKAN_LOKASI, sJson);
        this.peruntukanLokasiModelList = peruntukanLokasiModelList;
    }

    public List<SaluranAirModel> getSaluranAirModelList() {
        if (saluranAirModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_SALURAN_AIR);
            if (!TextUtils.isEmpty(sJson)) {
                saluranAirModelList = new Gson().fromJson(sJson, new TypeToken<List<SaluranAirModel>>() {
                }.getType());
            }
        }
        return saluranAirModelList;
    }

    public void setSaluranAirModelList(List<SaluranAirModel> saluranAirModelList) {
        SaluranAirModel modelFirst = new SaluranAirModel();
        modelFirst.setSaluranAir("Pilih");
        if (!saluranAirModelList.contains(modelFirst)) {
            saluranAirModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(saluranAirModelList);
        preference.set(AppPreference.MASTER_SALURAN_AIR, sJson);
        this.saluranAirModelList = saluranAirModelList;
    }

    public List<SaluranTeleponModel> getSaluranTeleponModelList() {
        if (saluranTeleponModelList == null) {
            String sJson = preference.getString(AppPreference.MASTER_SALURAN_TELEPON);
            if (!TextUtils.isEmpty(sJson)) {
                saluranTeleponModelList = new Gson().fromJson(sJson, new TypeToken<List<SaluranTeleponModel>>() {
                }.getType());
            }
        }
        return saluranTeleponModelList;
    }

    public void setSaluranTeleponModelList(List<SaluranTeleponModel> saluranTeleponModelList) {
        SaluranTeleponModel modelFirst = new SaluranTeleponModel();
        modelFirst.setSaluranTelepon("Pilih");
        if (!saluranTeleponModelList.contains(modelFirst)) {
            saluranTeleponModelList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(saluranTeleponModelList);
        preference.set(AppPreference.MASTER_SALURAN_TELEPON, sJson);
        this.saluranTeleponModelList = saluranTeleponModelList;
    }

    /*----------------------------------------------------------Andityo Master Data New List------------------------------------------------------------------------------*/
    public List<BaseResponseNew> getMasterDataNew() {
        if (MasterDataNewList == null) {
            String sJson = preference.getString("BaseResponseNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterDataNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterDataNewList;
    }

    public void setMasterDataNewList(List<BaseResponseNew> MasterDataNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterDataNewList.contains(modelFirst)) {
            MasterDataNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterDataNewList);
        preference.set("BaseResponseNew", sJson);
        this.MasterDataNewList = MasterDataNewList;
    }

    public List<BaseResponseNew> getMasterUsahaNew() {
        if (MasterUsahaNewList == null) {
            String sJson = preference.getString("MasterUsahaBaru");
            if (!TextUtils.isEmpty(sJson)) {
                MasterUsahaNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterUsahaNewList;
    }

    public void setMasterUsahaNew(List<BaseResponseNew> MasterUsahaNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterUsahaNewList.contains(modelFirst)) {
            MasterUsahaNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterUsahaNewList);
        preference.set("MasterUsahaBaru", sJson);
        this.MasterUsahaNewList = MasterUsahaNewList;
    }


    public List<BaseResponseNew> getMasterJenisRefensiNew() {
        if (MasterJenisRefensiNewList == null) {
            String sJson = preference.getString("MasterJenisReferensiNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterJenisRefensiNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterJenisRefensiNewList;
    }

    public void setMasterJenisRefensiNew(List<BaseResponseNew> MasterJenisReferensiNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterJenisReferensiNewList.contains(modelFirst)) {
            MasterJenisReferensiNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterJenisReferensiNewList);
        preference.set("MasterJenisReferensiNew", sJson);
        this.MasterJenisRefensiNewList = MasterJenisReferensiNewList;
    }
 /*----------------------------------------------------------Start Andityo 23 Jan 2018------------------------------------------------------------------------------*/

    public List<BaseResponseNew> getMasterStatusPerkawinanNew() {
        if (MasterStatusPerkawinanNewList == null) {
            String sJson = preference.getString("MasterStatusPerkawinanNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterStatusPerkawinanNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterStatusPerkawinanNewList;
    }

    public void setMasterStatusPerkawinanNew(List<BaseResponseNew> MasterStatusPerkawinanNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterStatusPerkawinanNewList.contains(modelFirst)) {
            MasterStatusPerkawinanNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterStatusPerkawinanNewList);
        preference.set("MasterStatusPerkawinanNew", sJson);
        this.MasterStatusPerkawinanNewList = MasterStatusPerkawinanNewList;
    }

    /*--------*/
    public List<BaseResponseNew> getMasterKewarganegaraanNew() {
        if (MasterKewarganegaraanNewList == null) {
            String sJson = preference.getString("MasterKewarganegaraanNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterKewarganegaraanNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterKewarganegaraanNewList;
    }

    public void setMasterKewarganegaraanNew(List<BaseResponseNew> MasterKewarganegaraanNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterKewarganegaraanNewList.contains(modelFirst)) {
            MasterKewarganegaraanNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterKewarganegaraanNewList);
        preference.set("MasterKewarganegaraanNew", sJson);
        this.MasterKewarganegaraanNewList = MasterKewarganegaraanNewList;
    }

    /*--------*/
    public List<BaseResponseNew> getMasterAgamaNew() {
        if (MasterAgamaNewList == null) {
            String sJson = preference.getString("MasterAgamaNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterAgamaNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterAgamaNewList;
    }

    public void setMasterAgamaNew(List<BaseResponseNew> MasterAgamaNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterAgamaNewList.contains(modelFirst)) {
            MasterAgamaNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterAgamaNewList);
        preference.set("MasterKewarganegaraanNew", sJson);
        this.MasterAgamaNewList = MasterAgamaNewList;
    }

    /*--------*/
    public List<BaseResponseNew> getMasterPekerjaanNew() {
        if (MasterPekerjaanNewList == null) {
            String sJson = preference.getString("MasterPekerjaanNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterPekerjaanNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterPekerjaanNewList;
    }

    public void setMasterPekerjaanNew(List<BaseResponseNew> MasterPekerjaanNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterPekerjaanNewList.contains(modelFirst)) {
            MasterPekerjaanNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterPekerjaanNewList);
        preference.set("MasterPekerjaanNew", sJson);
        this.MasterPekerjaanNewList = MasterPekerjaanNewList;
    }


    /*--------*/
    public List<BaseResponseNew> getMasterJenisAlamatNew() {
        if (MasterJenisAlamatNewList == null) {
            String sJson = preference.getString("MasterJenisAlamatNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterJenisAlamatNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterJenisAlamatNewList;
    }

    public void setMasterJenisAlamatNew(List<BaseResponseNew> MasterJenisAlamatNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterJenisAlamatNewList.contains(modelFirst)) {
            MasterJenisAlamatNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterJenisAlamatNewList);
        preference.set("MasterJenisAlamatNew", sJson);
        this.MasterJenisAlamatNewList = MasterJenisAlamatNewList;
    }

    /*--------*/
    public List<BaseResponseNew> getMasterHubunganKeluargaNew() {
        if (MasterHubunganKeluargaNewList == null) {
            String sJson = preference.getString("MasterHubunganKeluargaNew");
            if (!TextUtils.isEmpty(sJson)) {
                MasterHubunganKeluargaNewList = new Gson().fromJson(sJson, new TypeToken<List<BaseResponseNew>>() {
                }.getType());
            }
        }
        return MasterHubunganKeluargaNewList;
    }

    public void setMasterHubunganKeluargaNew(List<BaseResponseNew> MasterHubunganKeluargaNewList) {
        BaseResponseNew modelFirst = new BaseResponseNew();
        modelFirst.setDeskripsi("Pilih");
        if (!MasterHubunganKeluargaNewList.contains(modelFirst)) {
            MasterHubunganKeluargaNewList.add(0, modelFirst);
        }
        String sJson = new Gson().toJson(MasterHubunganKeluargaNewList);
        preference.set("MasterHubunganKeluargaNew", sJson);
        this.MasterHubunganKeluargaNewList = MasterHubunganKeluargaNewList;
    }



}



