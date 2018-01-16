package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAplikasiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKontakModel;
import com.example.saifullah_albasrie.pnm.model.ProspekLainnyaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekRencanaAgunanModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class GeneralProspekDetailResponse extends BaseResponse{

    @SerializedName("biodata")
    @Expose
    private List<ProspekBiodataModel> biodata = null;

    @SerializedName("referensi")
    @Expose
    private List<ProspekReferensiModel> referensi = null;

    @SerializedName("jadwal")
    @Expose
    private List<ProspekJadwalModel> jadwal = null;

    @SerializedName("alamat")
    @Expose
    private List<ProspekAlamatModel> alamatModelList = null;

    @SerializedName("keluarga")
    @Expose
    private List<ProspekKeluargaModel> keluargaModelList = null;

    @SerializedName("lainnya")
    @Expose
    private List<ProspekLainnyaModel> lainnyaModelList = null;

    @SerializedName("rencana_agunan")
    @Expose
    private List<ProspekRencanaAgunanModel> rencanaAgunanModelList = null;

    @SerializedName("aplikasi")
    @Expose
    private List<ProspekAplikasiModel> aplikasiModelList = null;

    @SerializedName("kontak")
    @Expose
    private List<ProspekKontakModel> kontakModelList = null;


    public List<ProspekBiodataModel> getBiodata() {
        return biodata;
    }

    public void setBiodata(List<ProspekBiodataModel> biodata) {
        this.biodata = biodata;
    }

    public List<ProspekReferensiModel> getReferensi() {
        return referensi;
    }

    public void setReferensi(List<ProspekReferensiModel> referensi) {
        this.referensi = referensi;
    }

    public List<ProspekJadwalModel> getJadwal() {
        return jadwal;
    }

    public void setJadwal(List<ProspekJadwalModel> jadwal) {
        this.jadwal = jadwal;
    }

    public List<ProspekAlamatModel> getAlamatModelList() {
        return alamatModelList;
    }

    public void setAlamatModelList(List<ProspekAlamatModel> alamatModelList) {
        this.alamatModelList = alamatModelList;
    }

    public List<ProspekKeluargaModel> getKeluargaModelList() {
        return keluargaModelList;
    }

    public void setKeluargaModelList(List<ProspekKeluargaModel> keluargaModelList) {
        this.keluargaModelList = keluargaModelList;
    }

    public List<ProspekLainnyaModel> getLainnyaModelList() {
        return lainnyaModelList;
    }

    public void setLainnyaModelList(List<ProspekLainnyaModel> lainnyaModelList) {
        this.lainnyaModelList = lainnyaModelList;
    }

    public List<ProspekRencanaAgunanModel> getRencanaAgunanModelList() {
        return rencanaAgunanModelList;
    }

    public void setRencanaAgunanModelList(List<ProspekRencanaAgunanModel> rencanaAgunanModelList) {
        this.rencanaAgunanModelList = rencanaAgunanModelList;
    }

    public List<ProspekAplikasiModel> getAplikasiModelList() {
        return aplikasiModelList;
    }

    public void setAplikasiModelList(List<ProspekAplikasiModel> aplikasiModelList) {
        this.aplikasiModelList = aplikasiModelList;
    }

    public List<ProspekKontakModel> getKontakModelList() {
        return kontakModelList;
    }

    public void setKontakModelList(List<ProspekKontakModel> kontakModelList) {
        this.kontakModelList = kontakModelList;
    }
}
