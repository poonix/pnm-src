package com.example.saifullah_albasrie.pnm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyJaminanModel {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nomor_lpj")
    @Expose
    private String nomorLpj;
    @SerializedName("id_jenis_agunan")
    @Expose
    private int idJenisAgunan;
    @SerializedName("status_kepemilikan")
    @Expose
    private String statusKepemilikan;
    @SerializedName("hubungan_dengan_pemohon")
    @Expose
    private String hubunganDenganPemohon;
    @SerializedName("nama_pemilik")
    @Expose
    private String namaPemilik;
    @SerializedName("id_jenis_bukti")
    @Expose
    private String idJenisBuktiKepemilikan;
    @SerializedName("jenis_bukti_kepemilikan")
    @Expose
    private String jenisBuktiKepemilikan;
    @SerializedName("bukti_kepemilikan")
    @Expose
    private String buktiKepemilikan;
    @SerializedName("nomor_surat")
    @Expose
    private String nomorSurat;
    @SerializedName("lokasi_dikeluarkan_surat")
    @Expose
    private String lokasiDikeluarkanSurat;
    @SerializedName("nomor_imb")
    @Expose
    private String nomorImb;
    @SerializedName("tanggal_terbit_imb")
    @Expose
    private String tanggalTerbitImb;
    @SerializedName("nama_imb")
    @Expose
    private String namaImb;
    @SerializedName("peruntukan_imb")
    @Expose
    private String peruntukanImb;
    @SerializedName("nomor_ajb")
    @Expose
    private String nomorAjb;
    @SerializedName("tanggal_terbit_ajb")
    @Expose
    private String tanggalTerbitAjb;
    @SerializedName("penerbit_ajb")
    @Expose
    private String penerbitAjb;
    @SerializedName("alamat_agunan")
    @Expose
    private String alamatAgunan;
    @SerializedName("RT")
    @Expose
    private String rT;
    @SerializedName("RW")
    @Expose
    private String rW;
    @SerializedName("id_provinsi")
    @Expose
    private int idProvinsi;
    @SerializedName("id_kabKota")
    @Expose
    private int idKabKota;
    @SerializedName("id_kecamatan")
    @Expose
    private int idKecamatan;
    @SerializedName("id_kelurahan")
    @Expose
    private int idKelurahan;
    @SerializedName("kodepos")
    @Expose
    private String kodepos;
    @SerializedName("peruntukan_lokasi")
    @Expose
    private String peruntukanLokasi;
    @SerializedName("jalan_dilalui")
    @Expose
    private String jalanDilalui;
    @SerializedName("bentuk_tanah")
    @Expose
    private String bentukTanah;
    @SerializedName("luas_tanah")
    @Expose
    private String luasTanah;
    @SerializedName("luas_tanah_keadaan_bangunan")
    @Expose
    private String luasTanahKondisiBangunan;
    @SerializedName("kondisi_permukaan")
    @Expose
    private String kondisiPermukaan;
    @SerializedName("penggunaan_tanah")
    @Expose
    private String penggunaanTanah;
    @SerializedName("is_banjir")
    @Expose
    private int isBanjir;
    @SerializedName("batas_utara")
    @Expose
    private String batasUtara;
    @SerializedName("batas_selatan")
    @Expose
    private String batasSelatan;
    @SerializedName("batas_barat")
    @Expose
    private String batasBarat;
    @SerializedName("batas_timur")
    @Expose
    private String batasTimur;
    @SerializedName("status_tanah")
    @Expose
    private String statusTanah;
    @SerializedName("penghuni_agunan")
    @Expose
    private String penghuniAgunan;
    @SerializedName("dasar_penghunian")
    @Expose
    private String dasarPenghunian;
    @SerializedName("jangka_waktu_sewa")
    @Expose
    private String jangkaWaktuSewa;
    @SerializedName("biaya_sewa")
    @Expose
    private String biayaSewa;
    @SerializedName("kapasitas_listrik")
    @Expose
    private String kapasitasListrik;
    @SerializedName("saluran_telepon")
    @Expose
    private String saluranTelepon;
    @SerializedName("saluran_air")
    @Expose
    private String saluranAir;
    @SerializedName("is_angkutan_umum")
    @Expose
    private int isAngkutanUmum;
    @SerializedName("is_sekolah")
    @Expose
    private int isSekolah;
    @SerializedName("is_rumah_sakit")
    @Expose
    private int isRumahSakit;
    @SerializedName("tahun_bangunan")
    @Expose
    private String tahunBangunan;
    @SerializedName("tahun_renovasi")
    @Expose
    private String tahunRenovasi;
    @SerializedName("lb_lantai1")
    @Expose
    private String lbLantai1;
    @SerializedName("is_jalan_akses")
    @Expose
    private int isJalanAkses;
    @SerializedName("lebar_jalan")
    @Expose
    private String lebarJalan;
    @SerializedName("pondasi")
    @Expose
    private String pondasi;
    @SerializedName("lantai")
    @Expose
    private String lantai;
    @SerializedName("dinding")
    @Expose
    private String dinding;
    @SerializedName("plafon")
    @Expose
    private String plafon;
    @SerializedName("kusen")
    @Expose
    private String kusen;
    @SerializedName("atap")
    @Expose
    private String atap;
    @SerializedName("pintu")
    @Expose
    private String pintu;
    @SerializedName("jendela")
    @Expose
    private String jendela;
    @SerializedName("lantai1")
    @Expose
    private String lantai1;
    @SerializedName("lantai2")
    @Expose
    private String lantai2;
    @SerializedName("lantai3")
    @Expose
    private String lantai3;

    @SerializedName("status_penilaian")
    @Expose
    private String statusPenilaian;
    @SerializedName("tanggal_penilaian")
    @Expose
    private String tanggalPenilaian;
    @SerializedName("nama_penilai")
    @Expose
    private String namaPenilai;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("nilai_pasar1")
    @Expose
    private String nilaiPasar1;
    @SerializedName("nilai_pasar2")
    @Expose
    private String nilaiPasar2;
    @SerializedName("nilai_pasar3")
    @Expose
    private String nilaiPasar3;
    @SerializedName("nilai_pasar")
    @Expose
    private String nilaiPasar;
    @SerializedName("prosentase_likuidasi")
    @Expose
    private String prosentaseLikuidasi;
    @SerializedName("nilai_likuidasi")
    @Expose
    private String nilaiLikuidasi;
    @SerializedName("executive_summary")
    @Expose
    private String executiveSummary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomorLpj() {
        return nomorLpj;
    }

    public void setNomorLpj(String nomorLpj) {
        this.nomorLpj = nomorLpj;
    }

    public int getIdJenisAgunan() {
        return idJenisAgunan;
    }

    public void setIdJenisAgunan(int idJenisAgunan) {
        this.idJenisAgunan = idJenisAgunan;
    }

    public String getStatusKepemilikan() {
        return statusKepemilikan;
    }

    public void setStatusKepemilikan(String statusKepemilikan) {
        this.statusKepemilikan = statusKepemilikan;
    }

    public String getHubunganDenganPemohon() {
        return hubunganDenganPemohon;
    }

    public void setHubunganDenganPemohon(String hubunganDenganPemohon) {
        this.hubunganDenganPemohon = hubunganDenganPemohon;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getIdJenisBuktiKepemilikan() {
        return idJenisBuktiKepemilikan;
    }

    public void setIdJenisBuktiKepemilikan(String idJenisBuktiKepemilikan) {
        this.idJenisBuktiKepemilikan = idJenisBuktiKepemilikan;
    }

    public String getJenisBuktiKepemilikan() {
        return jenisBuktiKepemilikan;
    }

    public void setJenisBuktiKepemilikan(String jenisBuktiKepemilikan) {
        this.jenisBuktiKepemilikan = jenisBuktiKepemilikan;
    }

    public String getBuktiKepemilikan() {
        return buktiKepemilikan;
    }

    public void setBuktiKepemilikan(String buktiKepemilikan) {
        this.buktiKepemilikan = buktiKepemilikan;
    }

    public String getNomorSurat() {
        return nomorSurat;
    }

    public void setNomorSurat(String nomorSurat) {
        this.nomorSurat = nomorSurat;
    }

    public String getLokasiDikeluarkanSurat() {
        return lokasiDikeluarkanSurat;
    }

    public void setLokasiDikeluarkanSurat(String lokasiDikeluarkanSurat) {
        this.lokasiDikeluarkanSurat = lokasiDikeluarkanSurat;
    }

    public String getNomorImb() {
        return nomorImb;
    }

    public void setNomorImb(String nomorImb) {
        this.nomorImb = nomorImb;
    }

    public String getTanggalTerbitImb() {
        return tanggalTerbitImb;
    }

    public void setTanggalTerbitImb(String tanggalTerbitImb) {
        this.tanggalTerbitImb = tanggalTerbitImb;
    }

    public String getNamaImb() {
        return namaImb;
    }

    public void setNamaImb(String namaImb) {
        this.namaImb = namaImb;
    }

    public String getPeruntukanImb() {
        return peruntukanImb;
    }

    public void setPeruntukanImb(String peruntukanImb) {
        this.peruntukanImb = peruntukanImb;
    }

    public String getNomorAjb() {
        return nomorAjb;
    }

    public void setNomorAjb(String nomorAjb) {
        this.nomorAjb = nomorAjb;
    }

    public String getTanggalTerbitAjb() {
        return tanggalTerbitAjb;
    }

    public void setTanggalTerbitAjb(String tanggalTerbitAjb) {
        this.tanggalTerbitAjb = tanggalTerbitAjb;
    }

    public String getPenerbitAjb() {
        return penerbitAjb;
    }

    public void setPenerbitAjb(String penerbitAjb) {
        this.penerbitAjb = penerbitAjb;
    }

    public String getAlamatAgunan() {
        return alamatAgunan;
    }

    public void setAlamatAgunan(String alamatAgunan) {
        this.alamatAgunan = alamatAgunan;
    }

    public String getrT() {
        return rT;
    }

    public void setrT(String rT) {
        this.rT = rT;
    }

    public String getrW() {
        return rW;
    }

    public void setrW(String rW) {
        this.rW = rW;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public int getIdKabKota() {
        return idKabKota;
    }

    public void setIdKabKota(int idKabKota) {
        this.idKabKota = idKabKota;
    }

    public int getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(int idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public String getPeruntukanLokasi() {
        return peruntukanLokasi;
    }

    public void setPeruntukanLokasi(String peruntukanLokasi) {
        this.peruntukanLokasi = peruntukanLokasi;
    }

    public String getJalanDilalui() {
        return jalanDilalui;
    }

    public void setJalanDilalui(String jalanDilalui) {
        this.jalanDilalui = jalanDilalui;
    }

    public String getBentukTanah() {
        return bentukTanah;
    }

    public void setBentukTanah(String bentukTanah) {
        this.bentukTanah = bentukTanah;
    }

    public String getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(String luasTanah) {
        this.luasTanah = luasTanah;
    }

    public String getLuasTanahKondisiBangunan() {
        return luasTanahKondisiBangunan;
    }

    public void setLuasTanahKondisiBangunan(String luasTanahKondisiBangunan) {
        this.luasTanahKondisiBangunan = luasTanahKondisiBangunan;
    }

    public String getKondisiPermukaan() {
        return kondisiPermukaan;
    }

    public void setKondisiPermukaan(String kondisiPermukaan) {
        this.kondisiPermukaan = kondisiPermukaan;
    }

    public String getPenggunaanTanah() {
        return penggunaanTanah;
    }

    public void setPenggunaanTanah(String penggunaanTanah) {
        this.penggunaanTanah = penggunaanTanah;
    }

    public int getIsBanjir() {
        return isBanjir;
    }

    public void setIsBanjir(int isBanjir) {
        this.isBanjir = isBanjir;
    }

    public String getBatasUtara() {
        return batasUtara;
    }

    public void setBatasUtara(String batasUtara) {
        this.batasUtara = batasUtara;
    }

    public String getBatasSelatan() {
        return batasSelatan;
    }

    public void setBatasSelatan(String batasSelatan) {
        this.batasSelatan = batasSelatan;
    }

    public String getBatasBarat() {
        return batasBarat;
    }

    public void setBatasBarat(String batasBarat) {
        this.batasBarat = batasBarat;
    }

    public String getBatasTimur() {
        return batasTimur;
    }

    public void setBatasTimur(String batasTimur) {
        this.batasTimur = batasTimur;
    }

    public String getStatusTanah() {
        return statusTanah;
    }

    public void setStatusTanah(String statusTanah) {
        this.statusTanah = statusTanah;
    }

    public String getPenghuniAgunan() {
        return penghuniAgunan;
    }

    public void setPenghuniAgunan(String penghuniAgunan) {
        this.penghuniAgunan = penghuniAgunan;
    }

    public String getDasarPenghunian() {
        return dasarPenghunian;
    }

    public void setDasarPenghunian(String dasarPenghunian) {
        this.dasarPenghunian = dasarPenghunian;
    }

    public String getJangkaWaktuSewa() {
        return jangkaWaktuSewa;
    }

    public void setJangkaWaktuSewa(String jangkaWaktuSewa) {
        this.jangkaWaktuSewa = jangkaWaktuSewa;
    }

    public String getBiayaSewa() {
        return biayaSewa;
    }

    public void setBiayaSewa(String biayaSewa) {
        this.biayaSewa = biayaSewa;
    }

    public String getKapasitasListrik() {
        return kapasitasListrik;
    }

    public void setKapasitasListrik(String kapasitasListrik) {
        this.kapasitasListrik = kapasitasListrik;
    }

    public String getSaluranTelepon() {
        return saluranTelepon;
    }

    public void setSaluranTelepon(String saluranTelepon) {
        this.saluranTelepon = saluranTelepon;
    }

    public String getSaluranAir() {
        return saluranAir;
    }

    public void setSaluranAir(String saluranAir) {
        this.saluranAir = saluranAir;
    }

    public int getIsAngkutanUmum() {
        return isAngkutanUmum;
    }

    public void setIsAngkutanUmum(int isAngkutanUmum) {
        this.isAngkutanUmum = isAngkutanUmum;
    }

    public int getIsSekolah() {
        return isSekolah;
    }

    public void setIsSekolah(int isSekolah) {
        this.isSekolah = isSekolah;
    }

    public int getIsRumahSakit() {
        return isRumahSakit;
    }

    public void setIsRumahSakit(int isRumahSakit) {
        this.isRumahSakit = isRumahSakit;
    }

    public String getTahunBangunan() {
        return tahunBangunan;
    }

    public void setTahunBangunan(String tahunBangunan) {
        this.tahunBangunan = tahunBangunan;
    }

    public String getTahunRenovasi() {
        return tahunRenovasi;
    }

    public void setTahunRenovasi(String tahunRenovasi) {
        this.tahunRenovasi = tahunRenovasi;
    }

    public String getLbLantai1() {
        return lbLantai1;
    }

    public void setLbLantai1(String lbLantai1) {
        this.lbLantai1 = lbLantai1;
    }

    public int getIsJalanAkses() {
        return isJalanAkses;
    }

    public void setIsJalanAkses(int isJalanAkses) {
        this.isJalanAkses = isJalanAkses;
    }

    public String getLebarJalan() {
        return lebarJalan;
    }

    public void setLebarJalan(String lebarJalan) {
        this.lebarJalan = lebarJalan;
    }

    public String getPondasi() {
        return pondasi;
    }

    public void setPondasi(String pondasi) {
        this.pondasi = pondasi;
    }

    public String getLantai() {
        return lantai;
    }

    public void setLantai(String lantai) {
        this.lantai = lantai;
    }

    public String getDinding() {
        return dinding;
    }

    public void setDinding(String dinding) {
        this.dinding = dinding;
    }

    public String getPlafon() {
        return plafon;
    }

    public void setPlafon(String plafon) {
        this.plafon = plafon;
    }

    public String getKusen() {
        return kusen;
    }

    public void setKusen(String kusen) {
        this.kusen = kusen;
    }

    public String getAtap() {
        return atap;
    }

    public void setAtap(String atap) {
        this.atap = atap;
    }

    public String getPintu() {
        return pintu;
    }

    public void setPintu(String pintu) {
        this.pintu = pintu;
    }

    public String getJendela() {
        return jendela;
    }

    public void setJendela(String jendela) {
        this.jendela = jendela;
    }

    public String getLantai1() {
        return lantai1;
    }

    public void setLantai1(String lantai1) {
        this.lantai1 = lantai1;
    }

    public String getLantai2() {
        return lantai2;
    }

    public void setLantai2(String lantai2) {
        this.lantai2 = lantai2;
    }

    public String getLantai3() {
        return lantai3;
    }

    public void setLantai3(String lantai3) {
        this.lantai3 = lantai3;
    }

    public String getStatusPenilaian() {
        return statusPenilaian;
    }

    public void setStatusPenilaian(String statusPenilaian) {
        this.statusPenilaian = statusPenilaian;
    }

    public String getTanggalPenilaian() {
        return tanggalPenilaian;
    }

    public void setTanggalPenilaian(String tanggalPenilaian) {
        this.tanggalPenilaian = tanggalPenilaian;
    }

    public String getNamaPenilai() {
        return namaPenilai;
    }

    public void setNamaPenilai(String namaPenilai) {
        this.namaPenilai = namaPenilai;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNilaiPasar1() {
        return nilaiPasar1;
    }

    public void setNilaiPasar1(String nilaiPasar1) {
        this.nilaiPasar1 = nilaiPasar1;
    }

    public String getNilaiPasar2() {
        return nilaiPasar2;
    }

    public void setNilaiPasar2(String nilaiPasar2) {
        this.nilaiPasar2 = nilaiPasar2;
    }

    public String getNilaiPasar3() {
        return nilaiPasar3;
    }

    public void setNilaiPasar3(String nilaiPasar3) {
        this.nilaiPasar3 = nilaiPasar3;
    }

    public String getNilaiPasar() {
        return nilaiPasar;
    }

    public void setNilaiPasar(String nilaiPasar) {
        this.nilaiPasar = nilaiPasar;
    }

    public String getProsentaseLikuidasi() {
        return prosentaseLikuidasi;
    }

    public void setProsentaseLikuidasi(String prosentaseLikuidasi) {
        this.prosentaseLikuidasi = prosentaseLikuidasi;
    }

    public String getNilaiLikuidasi() {
        return nilaiLikuidasi;
    }

    public void setNilaiLikuidasi(String nilaiLikuidasi) {
        this.nilaiLikuidasi = nilaiLikuidasi;
    }

    public String getExecutiveSummary() {
        return executiveSummary;
    }

    public void setExecutiveSummary(String executiveSummary) {
        this.executiveSummary = executiveSummary;
    }
}
