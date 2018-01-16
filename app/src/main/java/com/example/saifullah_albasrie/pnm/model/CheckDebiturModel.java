package com.example.saifullah_albasrie.pnm.model;

import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class CheckDebiturModel {

    @SerializedName("NASABAH_ID")
    @Expose
    private String idNasabah;
    @SerializedName("NO_REKENING")
    @Expose
    private String noRekening;
    @SerializedName("NAMA_NASABAH")
    @Expose
    private String namaNasabah;
    @SerializedName("NAMA_IBU_KANDUNG")
    @Expose
    private String namaIbuKandung;
    @SerializedName("ALAMAT")
    @Expose
    private String alamat;
    @SerializedName("KOTA")
    @Expose
    private String kota;
    @SerializedName("NO_ID")
    @Expose
    private String noId;
    @SerializedName("TGL_REALISASI")
    @Expose
    private String tglRealisasi;
    @SerializedName("TANGGAL")
    @Expose
    private String tanggal;
    @SerializedName("BULAN")
    @Expose
    private String bulan;
    @SerializedName("TAHUN")
    @Expose
    private String tahun;
    @SerializedName("TELPON")
    @Expose
    private String telpon;
    @SerializedName("TANGGAL_LAHIR")
    @Expose
    private String tanggalLahir;
    @SerializedName("TEMPAT_LAHIR")
    @Expose
    private String tempatLahir;
    @SerializedName("KOTA_ID")
    @Expose
    private String idKota;
    @SerializedName("TIPE_KREDIT")
    @Expose
    private String tipeKredit;
    @SerializedName("PRODUK")
    @Expose
    private String produk;
    @SerializedName("PROGRAM")
    @Expose
    private String program;
    @SerializedName("NO_REK_SEBELUMNYA")
    @Expose
    private String noRekSebelumnya;
    @SerializedName("TGL_JATUH_TEMPO")
    @Expose
    private String tglJatuhTempo;
    @SerializedName("JML_PINJAMAN")
    @Expose
    private String jmlPinjaman;
    @SerializedName("TENOR")
    @Expose
    private String tenor;
    @SerializedName("NO_PK_BARU")
    @Expose
    private String noPkBaru;
    @SerializedName("NO_PK_LAMA")
    @Expose
    private String noPkLama;
    @SerializedName("SALDO_NOMINATIF")
    @Expose
    private String saldoNominatif;
    @SerializedName("ANGSURAN_TOTAL")
    @Expose
    private String angsuranTotal;
    @SerializedName("FT_POKOK")
    @Expose
    private String ftPokok;
    @SerializedName("FT_BUNGA")
    @Expose
    private String ftBungan;
    @SerializedName("KOLEKTIBILITAS")
    @Expose
    private String kolektibilitas;
    @SerializedName("TGL_ANGSURAN")
    @Expose
    private String tglAngsuran;
    @SerializedName("NILAI_LIKUIDASI")
    @Expose
    private String nilaiLikuidasi;
    @SerializedName("KODE_UNIT")
    @Expose
    private String kodeUnit;
    @SerializedName("NAMA_UNIT")
    @Expose
    private String namaUnit;
    @SerializedName("KODE_CABANG")
    @Expose
    private String kodeCabang;
    @SerializedName("NAMA_CABANG")
    @Expose
    private String namaCabang;
    @SerializedName("BWMP")
    @Expose
    private String bwmp;
    @SerializedName("JENIS_USAHA")
    @Expose
    private String jenisUsaha;
    @SerializedName("SEKTOR_EKONOMI")
    @Expose
    private String sektorEkonomi;
/*
"Nama_Alias": "RUDI",
        "Jenis_Kelamin": "L",
        "Nama_Identitas": "",
        "NPWP": "",
        "gelar": "",
        "Status": "",
        "kelurahan": "Cengkareng Timur",
        "kecamatan": "Cengkareng",
        "kode_pos": "11730",
        "kota_id": "0393",
        "telpon": "13477012",
        "jenis_kelamin": "L",
        "pekerjaan": "",
        "kode_area": "0812",
        "pekerjaan_id": "014",
        "tempatlahir": "JAKARTA",
        "tgllahir": "1975-10-30 00:00:00.000",
        "gelar_id": "0100",
        "jenis_id": "2",
        "no_id": "3203083010750001",
        "no_kk": null,
        "npwp": "36.059.465.9.048.000",
        "KETERANGAN": "",
        "NASABAH_GROUP1": "1  ",
        "NASABAH_GROUP2": "1  ",
        "NASABAH_GROUP3": "   ",
        "AKUM_JASA_PINJ": ".00",
        "INDEX_SHU_PINJ": ".00",
        "SHU_PINJ": ".00",
        "AKUM_SIMP": ".00",
        "INDEX_SHU_SIMP": ".00",
        "SHU_SIMP": ".00",
        "IBU_KANDUNG": "HASANAH",
        "KET_GELAR": "",
        "NO_DIN": "",
        "kode_golongan_debitur": "907",
        "Tempat_Kerja": "",
        "Kode_Bidang_Usaha": "6390D",
        "Kode_Negara": "ID ",
        "Kode_Hubungan_Debitur": "9900",
        "NO_AKTE_AKHIR": "",
        "TGL_AKTE_AKHIR": "1900-01-01 00:00:00.000",
        "NO_REK_SHU": "",
        "ANGGOTA": 0,
        "PATH_FOTO": "",
        "PATH_TTANGAN": "",
        "tglid": "2018-10-30 00:00:00.000",
        "Black_List": 0,
        "TUJUAN_PEMBUKAAN_KYC": "",
        "SUMBER_DANA_KYC": "",
        "PENGGUNAAN_DANA_KYC": "",
        "KET_PEKERJAAN": "0",
        "NO_NIP": "",
        "TGL_BUKA": "2014-12-20 00:00:00.000",
        "PENDAPATAN_KYC": ".00",
        "ALAMAT_DOMISILI": "KLASTER KENCANA DESA DRAMAGA KEC DRAMAGA KAB BOGOR",
        "NO_HP": "081213477012",
        "TANGGAL_ULANGTAHUN": 0,
        "BULAN_ULANGTAHUN": 0,
        "NAMA_KUASA": "",
        "ALAMAT_KUASA": "",
        "STATUS_APPROVAL": 1,
        "USER_APPROVAL": 100293,
        "CAB": "BGR",
        "OUTLET": "AC ",
        "STATUS_PROSES": "CHECK-APPROVED",
        "EMAIL": "",
        "nama_nasabah_sid": "RUDI SUHENDAR",
        "STATUS_SMS_BROADCAST": null,
        "pipeline_id": "",
        "Created_By": 100293,
        "Created_Date": "2014-12-20 00:00:00.000",
        "Updated_By": 100293,
        "Updated_Date": "2014-12-20 00:00:00.000",
        "keterangan_proses_approval": null,
        "is_migrate": 1,
        "images_ktp_link": null,
        "unit_nasabah_id": "AC.000490",
        "STATUS_KREDIT_APPROVAL": null,
        "noMPPM": null,
        "noSP3U": null,
        "komite_pemutus": null,
        "berkas_manual_komite": null,
        "initiator_id": null,
        "GelarLain": null,
        "PekerjaanLain": null,
        "user_approval_name": null,
        "user_approval_date": "2014-12-20 00:00:00.000",
        "telepon_kode_wilayah": null,
        "id": 81008,
        "is_nasabah": null,
        "id_marketing_nasabah": null,
        "status_payment_center": null,
        "tgl_mulai_payment_center": null,
        "jenis_alamat": null,
        "agama": null,
        "suku": null
}*/

    @SerializedName("Nama_Alias")
    @Expose
    private String namaAlias;
    @SerializedName("Jenis_Kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("Nama_Identitas")
    @Expose
    private String namaIdentitas;
    @SerializedName("NPWP")
    @Expose
    private String nPWP;
    @SerializedName("gelar")
    @Expose
    private String gelar;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("kelurahan")
    @Expose
    private String kelurahan;
    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;
    @SerializedName("kode_pos")
    @Expose
    private String kodePos;
    @SerializedName("kota_id")
    @Expose
    private String kotaId;
    @SerializedName("telpon")
    @Expose
    private String telponLain;
    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;
    @SerializedName("kode_area")
    @Expose
    private String kodeArea;
    @SerializedName("pekerjaan_id")
    @Expose
    private String pekerjaanId;
    @SerializedName("tempatlahir")
    @Expose
    private String tempatlahir;
    @SerializedName("tgllahir")
    @Expose
    private String tgllahir;
    @SerializedName("gelar_id")
    @Expose
    private String gelarId;
    @SerializedName("jenis_id")
    @Expose
    private String jenisId;
    @SerializedName("no_id")
    @Expose
    private String noIdLain;
    @SerializedName("no_kk")
    @Expose
    private String noKk;
    @SerializedName("npwp")
    @Expose
    private String npwp;
    @SerializedName("KETERANGAN")
    @Expose
    private String keterangan;
    @SerializedName("NASABAH_GROUP1")
    @Expose
    private String nasabahgroup1;
    @SerializedName("NASABAH_GROUP2")
    @Expose
    private String nasabahgroup2;
    @SerializedName("NASABAH_GROUP3")
    @Expose
    private String nasabahgroup3;
    @SerializedName("AKUM_JASA_PINJ")
    @Expose
    private String akumjasapinj;
    @SerializedName("INDEX_SHU_PINJ")
    @Expose
    private String indexshupinj;
    @SerializedName("SHU_PINJ")
    @Expose
    private String shupinj;
    @SerializedName("AKUM_SIMP")
    @Expose
    private String akumsimp;
    @SerializedName("INDEX_SHU_SIMP")
    @Expose
    private String indexshusimp;
    @SerializedName("SHU_SIMP")
    @Expose
    private String shusimp;
    @SerializedName("IBU_KANDUNG")
    @Expose
    private String ibukandung;
    @SerializedName("KET_GELAR")
    @Expose
    private String ketgelar;
    @SerializedName("NO_DIN")
    @Expose
    private String nodin;
    @SerializedName("kode_golongan_debitur")
    @Expose
    private String kodeGolonganDebitur;
    @SerializedName("Tempat_Kerja")
    @Expose
    private String tempatKerja;
    @SerializedName("Kode_Bidang_Usaha")
    @Expose
    private String kodeBidangUsaha;
    @SerializedName("Kode_Negara")
    @Expose
    private String kodeNegara;
    @SerializedName("Kode_Hubungan_Debitur")
    @Expose
    private String kodeHubunganDebitur;
    @SerializedName("NO_AKTE_AKHIR")
    @Expose
    private String noakteakhir;
    @SerializedName("TGL_AKTE_AKHIR")
    @Expose
    private String tglakteakhir;
    @SerializedName("NO_REK_SHU")
    @Expose
    private String norekshu;
    @SerializedName("ANGGOTA")
    @Expose
    private int anggota;
    @SerializedName("PATH_FOTO")
    @Expose
    private String pathfoto;
    @SerializedName("PATH_TTANGAN")
    @Expose
    private String pathttangan;
    @SerializedName("tglid")
    @Expose
    private String tglid;
    @SerializedName("Black_List")
    @Expose
    private int blackList;
    @SerializedName("TUJUAN_PEMBUKAAN_KYC")
    @Expose
    private String tujuanpembukaankyc;
    @SerializedName("SUMBER_DANA_KYC")
    @Expose
    private String sumberdanakyc;
    @SerializedName("PENGGUNAAN_DANA_KYC")
    @Expose
    private String penggunaandanakyc;
    @SerializedName("KET_PEKERJAAN")
    @Expose
    private String ketpekerjaan;
    @SerializedName("NO_NIP")
    @Expose
    private String nonip;
    @SerializedName("TGL_BUKA")
    @Expose
    private String tglbuka;
    @SerializedName("PENDAPATAN_KYC")
    @Expose
    private String pendapatankyc;
    @SerializedName("ALAMAT_DOMISILI")
    @Expose
    private String alamatdomisili;
    @SerializedName("NO_HP")
    @Expose
    private String nohp;
    @SerializedName("TANGGAL_ULANGTAHUN")
    @Expose
    private int tanggalulangtahun;
    @SerializedName("BULAN_ULANGTAHUN")
    @Expose
    private int bulanulangtahun;
    @SerializedName("NAMA_KUASA")
    @Expose
    private String namakuasa;
    @SerializedName("ALAMAT_KUASA")
    @Expose
    private String alamatkuasa;
    @SerializedName("STATUS_APPROVAL")
    @Expose
    private int statusapproval;
    @SerializedName("USER_APPROVAL")
    @Expose
    private int userapproval;
    @SerializedName("CAB")
    @Expose
    private String cab;
    @SerializedName("OUTLET")
    @Expose
    private String outlet;
    @SerializedName("STATUS_PROSES")
    @Expose
    private String statusproses;
    @SerializedName("EMAIL")
    @Expose
    private String email;
    @SerializedName("nama_nasabah_sid")
    @Expose
    private String namaNasabahSid;
    @SerializedName("STATUS_SMS_BROADCAST")
    @Expose
    private String statussmsbroadcast;
    @SerializedName("pipeline_id")
    @Expose
    private String pipelineId;
    @SerializedName("Created_By")
    @Expose
    private int createdBy;
    @SerializedName("Created_Date")
    @Expose
    private String createdDate;
    @SerializedName("Updated_By")
    @Expose
    private int updatedBy;
    @SerializedName("Updated_Date")
    @Expose
    private String updatedDate;
    @SerializedName("keterangan_proses_approval")
    @Expose
    private String keteranganProsesApproval;
    @SerializedName("is_migrate")
    @Expose
    private int isMigrate;
    @SerializedName("images_ktp_link")
    @Expose
    private String imagesKtpLink;
    @SerializedName("unit_nasabah_id")
    @Expose
    private String unitNasabahId;
    @SerializedName("STATUS_KREDIT_APPROVAL")
    @Expose
    private String statuskreditapproval;
    @SerializedName("noMPPM")
    @Expose
    private String noMPPM;
    @SerializedName("noSP3U")
    @Expose
    private String noSP3U;
    @SerializedName("komite_pemutus")
    @Expose
    private String komitePemutus;
    @SerializedName("berkas_manual_komite")
    @Expose
    private String berkasManualKomite;
    @SerializedName("initiator_id")
    @Expose
    private String initiatorId;
    @SerializedName("GelarLain")
    @Expose
    private String gelarLain;
    @SerializedName("PekerjaanLain")
    @Expose
    private String pekerjaanLain;
    @SerializedName("user_approval_name")
    @Expose
    private String userApprovalName;
    @SerializedName("user_approval_date")
    @Expose
    private String userApprovalDate;
    @SerializedName("telepon_kode_wilayah")
    @Expose
    private String teleponKodeWilayah;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("is_nasabah")
    @Expose
    private String isNasabah;
    @SerializedName("id_marketing_nasabah")
    @Expose
    private String idMarketingNasabah;
    @SerializedName("status_payment_center")
    @Expose
    private String statusPaymentCenter;
    @SerializedName("tgl_mulai_payment_center")
    @Expose
    private String tglMulaiPaymentCenter;
    @SerializedName("jenis_alamat")
    @Expose
    private String jenisAlamat;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("suku")
    @Expose
    private String suku;


    public String getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(String idNasabah) {
        this.idNasabah = idNasabah;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getNamaIbuKandung() {
        return namaIbuKandung;
    }

    public void setNamaIbuKandung(String namaIbuKandung) {
        this.namaIbuKandung = namaIbuKandung;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public String getTglRealisasi() {
        return tglRealisasi;
    }

    public void setTglRealisasi(String tglRealisasi) {
        this.tglRealisasi = tglRealisasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }

    public String getTipeKredit() {
        return tipeKredit;
    }

    public void setTipeKredit(String tipeKredit) {
        this.tipeKredit = tipeKredit;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getNoRekSebelumnya() {
        return noRekSebelumnya;
    }

    public void setNoRekSebelumnya(String noRekSebelumnya) {
        this.noRekSebelumnya = noRekSebelumnya;
    }

    public String getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(String tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public String getJmlPinjaman() {
        return jmlPinjaman;
    }

    public void setJmlPinjaman(String jmlPinjaman) {
        this.jmlPinjaman = jmlPinjaman;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public String getNoPkBaru() {
        return noPkBaru;
    }

    public void setNoPkBaru(String noPkBaru) {
        this.noPkBaru = noPkBaru;
    }

    public String getNoPkLama() {
        return noPkLama;
    }

    public void setNoPkLama(String noPkLama) {
        this.noPkLama = noPkLama;
    }

    public String getSaldoNominatif() {
        return saldoNominatif;
    }

    public void setSaldoNominatif(String saldoNominatif) {
        this.saldoNominatif = saldoNominatif;
    }

    public String getAngsuranTotal() {
        return angsuranTotal;
    }

    public void setAngsuranTotal(String angsuranTotal) {
        this.angsuranTotal = angsuranTotal;
    }

    public String getFtPokok() {
        return ftPokok;
    }

    public void setFtPokok(String ftPokok) {
        this.ftPokok = ftPokok;
    }

    public String getFtBungan() {
        return ftBungan;
    }

    public void setFtBungan(String ftBungan) {
        this.ftBungan = ftBungan;
    }

    public String getKolektibilitas() {
        return kolektibilitas;
    }

    public void setKolektibilitas(String kolektibilitas) {
        this.kolektibilitas = kolektibilitas;
    }

    public String getTglAngsuran() {
        return tglAngsuran;
    }

    public void setTglAngsuran(String tglAngsuran) {
        this.tglAngsuran = tglAngsuran;
    }

    public String getNilaiLikuidasi() {
        return nilaiLikuidasi;
    }

    public void setNilaiLikuidasi(String nilaiLikuidasi) {
        this.nilaiLikuidasi = nilaiLikuidasi;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
    }

    public String getNamaUnit() {
        return namaUnit;
    }

    public void setNamaUnit(String namaUnit) {
        this.namaUnit = namaUnit;
    }

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getNamaCabang() {
        return namaCabang;
    }

    public void setNamaCabang(String namaCabang) {
        this.namaCabang = namaCabang;
    }

    public String getBwmp() {
        return bwmp;
    }

    public void setBwmp(String bwmp) {
        this.bwmp = bwmp;
    }

    public String getJenisUsaha() {
        return jenisUsaha;
    }

    public void setJenisUsaha(String jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
    }

    public String getSektorEkonomi() {
        return sektorEkonomi;
    }

    public void setSektorEkonomi(String sektorEkonomi) {
        this.sektorEkonomi = sektorEkonomi;
    }

    public String getNamaAlias() {
        return namaAlias;
    }

    public void setNamaAlias(String namaAlias) {
        this.namaAlias = namaAlias;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaIdentitas() {
        return namaIdentitas;
    }

    public void setNamaIdentitas(String namaIdentitas) {
        this.namaIdentitas = namaIdentitas;
    }

    public String getnPWP() {
        return nPWP;
    }

    public void setnPWP(String nPWP) {
        this.nPWP = nPWP;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getKotaId() {
        return kotaId;
    }

    public void setKotaId(String kotaId) {
        this.kotaId = kotaId;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKodeArea() {
        return kodeArea;
    }

    public void setKodeArea(String kodeArea) {
        this.kodeArea = kodeArea;
    }

    public String getPekerjaanId() {
        return pekerjaanId;
    }

    public void setPekerjaanId(String pekerjaanId) {
        this.pekerjaanId = pekerjaanId;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getGelarId() {
        return gelarId;
    }

    public void setGelarId(String gelarId) {
        this.gelarId = gelarId;
    }

    public String getJenisId() {
        return jenisId;
    }

    public void setJenisId(String jenisId) {
        this.jenisId = jenisId;
    }

    public String getNoIdentitas() {
        return noIdLain;
    }

    public void setNoIdentitas(String noId) {
        this.noIdLain = noId;
    }

    public String getTelponLain() {
        return telponLain;
    }

    public void setTelponLain(String telponLain) {
        this.telponLain = telponLain;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNasabahgroup1() {
        return nasabahgroup1;
    }

    public void setNasabahgroup1(String nasabahgroup1) {
        this.nasabahgroup1 = nasabahgroup1;
    }

    public String getNasabahgroup2() {
        return nasabahgroup2;
    }

    public void setNasabahgroup2(String nasabahgroup2) {
        this.nasabahgroup2 = nasabahgroup2;
    }

    public String getNasabahgroup3() {
        return nasabahgroup3;
    }

    public void setNasabahgroup3(String nasabahgroup3) {
        this.nasabahgroup3 = nasabahgroup3;
    }

    public String getAkumjasapinj() {
        return akumjasapinj;
    }

    public void setAkumjasapinj(String akumjasapinj) {
        this.akumjasapinj = akumjasapinj;
    }

    public String getIndexshupinj() {
        return indexshupinj;
    }

    public void setIndexshupinj(String indexshupinj) {
        this.indexshupinj = indexshupinj;
    }

    public String getShupinj() {
        return shupinj;
    }

    public void setShupinj(String shupinj) {
        this.shupinj = shupinj;
    }

    public String getAkumsimp() {
        return akumsimp;
    }

    public void setAkumsimp(String akumsimp) {
        this.akumsimp = akumsimp;
    }

    public String getIndexshusimp() {
        return indexshusimp;
    }

    public void setIndexshusimp(String indexshusimp) {
        this.indexshusimp = indexshusimp;
    }

    public String getShusimp() {
        return shusimp;
    }

    public void setShusimp(String shusimp) {
        this.shusimp = shusimp;
    }

    public String getIbukandung() {
        return ibukandung;
    }

    public void setIbukandung(String ibukandung) {
        this.ibukandung = ibukandung;
    }

    public String getKetgelar() {
        return ketgelar;
    }

    public void setKetgelar(String ketgelar) {
        this.ketgelar = ketgelar;
    }

    public String getNodin() {
        return nodin;
    }

    public void setNodin(String nodin) {
        this.nodin = nodin;
    }

    public String getKodeGolonganDebitur() {
        return kodeGolonganDebitur;
    }

    public void setKodeGolonganDebitur(String kodeGolonganDebitur) {
        this.kodeGolonganDebitur = kodeGolonganDebitur;
    }

    public String getTempatKerja() {
        return tempatKerja;
    }

    public void setTempatKerja(String tempatKerja) {
        this.tempatKerja = tempatKerja;
    }

    public String getKodeBidangUsaha() {
        return kodeBidangUsaha;
    }

    public void setKodeBidangUsaha(String kodeBidangUsaha) {
        this.kodeBidangUsaha = kodeBidangUsaha;
    }

    public String getKodeNegara() {
        return kodeNegara;
    }

    public void setKodeNegara(String kodeNegara) {
        this.kodeNegara = kodeNegara;
    }

    public String getKodeHubunganDebitur() {
        return kodeHubunganDebitur;
    }

    public void setKodeHubunganDebitur(String kodeHubunganDebitur) {
        this.kodeHubunganDebitur = kodeHubunganDebitur;
    }

    public String getNoakteakhir() {
        return noakteakhir;
    }

    public void setNoakteakhir(String noakteakhir) {
        this.noakteakhir = noakteakhir;
    }

    public String getTglakteakhir() {
        return tglakteakhir;
    }

    public void setTglakteakhir(String tglakteakhir) {
        this.tglakteakhir = tglakteakhir;
    }

    public String getNorekshu() {
        return norekshu;
    }

    public void setNorekshu(String norekshu) {
        this.norekshu = norekshu;
    }

    public int getAnggota() {
        return anggota;
    }

    public void setAnggota(int anggota) {
        this.anggota = anggota;
    }

    public String getPathfoto() {
        return pathfoto;
    }

    public void setPathfoto(String pathfoto) {
        this.pathfoto = pathfoto;
    }

    public String getPathttangan() {
        return pathttangan;
    }

    public void setPathttangan(String pathttangan) {
        this.pathttangan = pathttangan;
    }

    public String getTglid() {
        return tglid;
    }

    public void setTglid(String tglid) {
        this.tglid = tglid;
    }

    public int getBlackList() {
        return blackList;
    }

    public void setBlackList(int blackList) {
        this.blackList = blackList;
    }

    public String getTujuanpembukaankyc() {
        return tujuanpembukaankyc;
    }

    public void setTujuanpembukaankyc(String tujuanpembukaankyc) {
        this.tujuanpembukaankyc = tujuanpembukaankyc;
    }

    public String getSumberdanakyc() {
        return sumberdanakyc;
    }

    public void setSumberdanakyc(String sumberdanakyc) {
        this.sumberdanakyc = sumberdanakyc;
    }

    public String getPenggunaandanakyc() {
        return penggunaandanakyc;
    }

    public void setPenggunaandanakyc(String penggunaandanakyc) {
        this.penggunaandanakyc = penggunaandanakyc;
    }

    public String getKetpekerjaan() {
        return ketpekerjaan;
    }

    public void setKetpekerjaan(String ketpekerjaan) {
        this.ketpekerjaan = ketpekerjaan;
    }

    public String getNonip() {
        return nonip;
    }

    public void setNonip(String nonip) {
        this.nonip = nonip;
    }

    public String getTglbuka() {
        return tglbuka;
    }

    public void setTglbuka(String tglbuka) {
        this.tglbuka = tglbuka;
    }

    public String getPendapatankyc() {
        return pendapatankyc;
    }

    public void setPendapatankyc(String pendapatankyc) {
        this.pendapatankyc = pendapatankyc;
    }

    public String getAlamatdomisili() {
        return alamatdomisili;
    }

    public void setAlamatdomisili(String alamatdomisili) {
        this.alamatdomisili = alamatdomisili;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public int getTanggalulangtahun() {
        return tanggalulangtahun;
    }

    public void setTanggalulangtahun(int tanggalulangtahun) {
        this.tanggalulangtahun = tanggalulangtahun;
    }

    public int getBulanulangtahun() {
        return bulanulangtahun;
    }

    public void setBulanulangtahun(int bulanulangtahun) {
        this.bulanulangtahun = bulanulangtahun;
    }

    public String getNamakuasa() {
        return namakuasa;
    }

    public void setNamakuasa(String namakuasa) {
        this.namakuasa = namakuasa;
    }

    public String getAlamatkuasa() {
        return alamatkuasa;
    }

    public void setAlamatkuasa(String alamatkuasa) {
        this.alamatkuasa = alamatkuasa;
    }

    public int getStatusapproval() {
        return statusapproval;
    }

    public void setStatusapproval(int statusapproval) {
        this.statusapproval = statusapproval;
    }

    public int getUserapproval() {
        return userapproval;
    }

    public void setUserapproval(int userapproval) {
        this.userapproval = userapproval;
    }

    public String getCab() {
        return cab;
    }

    public void setCab(String cab) {
        this.cab = cab;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getStatusproses() {
        return statusproses;
    }

    public void setStatusproses(String statusproses) {
        this.statusproses = statusproses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaNasabahSid() {
        return namaNasabahSid;
    }

    public void setNamaNasabahSid(String namaNasabahSid) {
        this.namaNasabahSid = namaNasabahSid;
    }

    public String getStatussmsbroadcast() {
        return statussmsbroadcast;
    }

    public void setStatussmsbroadcast(String statussmsbroadcast) {
        this.statussmsbroadcast = statussmsbroadcast;
    }

    public String getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getKeteranganProsesApproval() {
        return keteranganProsesApproval;
    }

    public void setKeteranganProsesApproval(String keteranganProsesApproval) {
        this.keteranganProsesApproval = keteranganProsesApproval;
    }

    public int getIsMigrate() {
        return isMigrate;
    }

    public void setIsMigrate(int isMigrate) {
        this.isMigrate = isMigrate;
    }

    public String getImagesKtpLink() {
        return imagesKtpLink;
    }

    public void setImagesKtpLink(String imagesKtpLink) {
        this.imagesKtpLink = imagesKtpLink;
    }

    public String getUnitNasabahId() {
        return unitNasabahId;
    }

    public void setUnitNasabahId(String unitNasabahId) {
        this.unitNasabahId = unitNasabahId;
    }

    public String getStatuskreditapproval() {
        return statuskreditapproval;
    }

    public void setStatuskreditapproval(String statuskreditapproval) {
        this.statuskreditapproval = statuskreditapproval;
    }

    public String getNoMPPM() {
        return noMPPM;
    }

    public void setNoMPPM(String noMPPM) {
        this.noMPPM = noMPPM;
    }

    public String getNoSP3U() {
        return noSP3U;
    }

    public void setNoSP3U(String noSP3U) {
        this.noSP3U = noSP3U;
    }

    public String getKomitePemutus() {
        return komitePemutus;
    }

    public void setKomitePemutus(String komitePemutus) {
        this.komitePemutus = komitePemutus;
    }

    public String getBerkasManualKomite() {
        return berkasManualKomite;
    }

    public void setBerkasManualKomite(String berkasManualKomite) {
        this.berkasManualKomite = berkasManualKomite;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getGelarLain() {
        return gelarLain;
    }

    public void setGelarLain(String gelarLain) {
        this.gelarLain = gelarLain;
    }

    public String getPekerjaanLain() {
        return pekerjaanLain;
    }

    public void setPekerjaanLain(String pekerjaanLain) {
        this.pekerjaanLain = pekerjaanLain;
    }

    public String getUserApprovalName() {
        return userApprovalName;
    }

    public void setUserApprovalName(String userApprovalName) {
        this.userApprovalName = userApprovalName;
    }

    public String getUserApprovalDate() {
        return userApprovalDate;
    }

    public void setUserApprovalDate(String userApprovalDate) {
        this.userApprovalDate = userApprovalDate;
    }

    public String getTeleponKodeWilayah() {
        return teleponKodeWilayah;
    }

    public void setTeleponKodeWilayah(String teleponKodeWilayah) {
        this.teleponKodeWilayah = teleponKodeWilayah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsNasabah() {
        return isNasabah;
    }

    public void setIsNasabah(String isNasabah) {
        this.isNasabah = isNasabah;
    }

    public String getIdMarketingNasabah() {
        return idMarketingNasabah;
    }

    public void setIdMarketingNasabah(String idMarketingNasabah) {
        this.idMarketingNasabah = idMarketingNasabah;
    }

    public String getStatusPaymentCenter() {
        return statusPaymentCenter;
    }

    public void setStatusPaymentCenter(String statusPaymentCenter) {
        this.statusPaymentCenter = statusPaymentCenter;
    }

    public String getTglMulaiPaymentCenter() {
        return tglMulaiPaymentCenter;
    }

    public void setTglMulaiPaymentCenter(String tglMulaiPaymentCenter) {
        this.tglMulaiPaymentCenter = tglMulaiPaymentCenter;
    }

    public String getJenisAlamat() {
        return jenisAlamat;
    }

    public void setJenisAlamat(String jenisAlamat) {
        this.jenisAlamat = jenisAlamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getSuku() {
        return suku;
    }

    public void setSuku(String suku) {
        this.suku = suku;
    }

    public ProspekBiodataModel parseToModel() {
        ProspekBiodataModel mBiodataModel = new ProspekBiodataModel();
        mBiodataModel.setIdNasabahPNM(getIdNasabah());
        mBiodataModel.setNamaPanggilan(getNamaNasabah());
        mBiodataModel.setNamaLengkap(getNamaNasabah());
        mBiodataModel.setNomorTelp(getTelpon());
        mBiodataModel.setTempatLahir(getTempatLahir());
        mBiodataModel.setTanggalLahir(DateUtil.convertDateString(getTanggalLahir(), "yyyy-MM-dd", "yyyy-MM-dd"));

        if (getJenisKelamin() != null && getJenisKelamin().equals("L")) {
            mBiodataModel.setJenisKelamin("Laki-laki");
        } else if (getJenisKelamin() != null && getJenisKelamin().equals("P")) {
            mBiodataModel.setJenisKelamin("Perempuan");
        }

        if (getJenisId() != null && getJenisId().equals("1")) {
            mBiodataModel.setJenisIdentitas("KTP");
        } else if (getJenisId() != null && getJenisId().equals("2")) {
            mBiodataModel.setJenisIdentitas("SIM");
        }

        mBiodataModel.setNoIdentitas(getNoIdentitas());
        String masaBerlaku = DateUtil.convertDateString(getTglid(), "yyyy-MM-dd", "yyyy-MM-dd");
        if (masaBerlaku != null && masaBerlaku.equals("1900-01-01")) {
            mBiodataModel.setIsSeumurHidup(1);
        } else {
            mBiodataModel.setIsSeumurHidup(0);
            mBiodataModel.setMasaBerlaku(masaBerlaku);
        }
        mBiodataModel.setNamaIbuKandung(getNamaIbuKandung());
        int idJenisAlamat = 0;
        try {
            idJenisAlamat = Integer.parseInt(getJenisAlamat());
        }catch (Exception e){}
        mBiodataModel.setIdJenisAlamat(idJenisAlamat);
        mBiodataModel.setAlamat(getAlamat());
        mBiodataModel.setKodeUnit(getKodeUnit());
        mBiodataModel.setKodeCabang(getKodeCabang());
        mBiodataModel.setNamaJenisUsaha(getJenisUsaha());
        //mBiodataModel.setNamaJenisUsaha(getSektorEkonomi());

        return mBiodataModel;
    }
}
