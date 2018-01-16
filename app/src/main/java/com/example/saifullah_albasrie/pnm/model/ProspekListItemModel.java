package com.example.saifullah_albasrie.pnm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekListItemModel implements Parcelable{

    /*
    "id_debitur": "DEBITUR-1490265675",
      "nama_panggilan": "Reza",
      "jenis_identitas": "KTP",
      "no_identitas": "527520010390005",
      "created_by": "1DCB599E947F9842B0C4EC6C61C1BCFF",
      "created_date": "2017-03-21 00:00:00.000",
      "modified_by": null,
      "modified_date": null,
      "is_active": 1,
      "visit": 3,
      "status_debitur": "1",
      "progress": "20        "
     */


    @SerializedName("id_debitur")
    @Expose
    private String idDebitur;

    @SerializedName("id_transaksi_debitur")
    @Expose
    private String idTransaksiDebitur;

    @SerializedName("nama_panggilan")
    @Expose
    private String namaPanggilan;

    @SerializedName("jenis_identitas")
    @Expose
    private String jenisIdentitas;

    @SerializedName("no_identitas")
    @Expose
    private String noIdentitas;

    @SerializedName("created_by")
    @Expose
    private String createdBy;

    @SerializedName("created_date")
    @Expose
    private String createdDate;

    @SerializedName("modified_by")
    @Expose
    private String modifiedBy;

    @SerializedName("modified_date")
    @Expose
    private String modifiedDate;

    @SerializedName("is_active")
    @Expose
    private int isActive;

    @SerializedName("visit")
    @Expose
    private int visit;

    @SerializedName("status_debitur")
    @Expose
    private int statusDebitur;

    @SerializedName("status_modul")
    @Expose
    private String statusModul;

    @SerializedName("status_name")
    @Expose
    private String statusName;

    @SerializedName("progress")
    @Expose
    private int progress;

    @SerializedName("id_nasabah")
    @Expose
    private String idNasabahPNM;

    @SerializedName("hasil_cek_idi")
    @Expose
    private int hasilCekIdi;

    private List<ProspekBiodataModel> biodataModel;
    private List<ProspekReferensiModel> refferenceModel;
    private List<ProspekJadwalModel> jadwalModel;
    private List<ProspekAlamatModel> alamatModel;
    private List<ProspekKeluargaModel> keluargaModel;
    private List<ProspekAplikasiModel> aplikasiModel;
    private List<ProspekRencanaAgunanModel> rencanaAgunanModel;
    private List<ProspekLainnyaModel> lainnyaModel;

    private List<ProspekKontakModel> kontakModel;


    public ProspekListItemModel() {

    }

    protected ProspekListItemModel(Parcel in) {
        idDebitur = in.readString();
        idTransaksiDebitur = in.readString();
        namaPanggilan = in.readString();
        jenisIdentitas = in.readString();
        noIdentitas = in.readString();
        createdBy = in.readString();
        createdDate = in.readString();
        modifiedBy = in.readString();
        modifiedDate = in.readString();
        isActive = in.readInt();
        visit = in.readInt();
        statusDebitur = in.readInt();
        statusModul = in.readString();
        statusName = in.readString();
        progress = in.readInt();
        biodataModel = in.createTypedArrayList(ProspekBiodataModel.CREATOR);
        refferenceModel = in.createTypedArrayList(ProspekReferensiModel.CREATOR);
        jadwalModel = in.createTypedArrayList(ProspekJadwalModel.CREATOR);
        alamatModel = in.createTypedArrayList(ProspekAlamatModel.CREATOR);
        keluargaModel = in.createTypedArrayList(ProspekKeluargaModel.CREATOR);
        aplikasiModel = in.createTypedArrayList(ProspekAplikasiModel.CREATOR);
        rencanaAgunanModel = in.createTypedArrayList(ProspekRencanaAgunanModel.CREATOR);
        lainnyaModel = in.createTypedArrayList(ProspekLainnyaModel.CREATOR);
        kontakModel = in.createTypedArrayList(ProspekKontakModel.CREATOR);

        idNasabahPNM = in.readString();
        hasilCekIdi = in.readInt();
    }

    public static final Creator<ProspekListItemModel> CREATOR = new Creator<ProspekListItemModel>() {
        @Override
        public ProspekListItemModel createFromParcel(Parcel in) {
            return new ProspekListItemModel(in);
        }

        @Override
        public ProspekListItemModel[] newArray(int size) {
            return new ProspekListItemModel[size];
        }
    };

    public String getIdDebitur() {
        return idDebitur;
    }

    public void setIdDebitur(String idDebitur) {
        this.idDebitur = idDebitur;
    }

    public String getIdTransaksiDebitur() {
        return idTransaksiDebitur;
    }

    public void setIdTransaksiDebitur(String idTransaksiDebitur) {
        this.idTransaksiDebitur = idTransaksiDebitur;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getJenisIdentitas() {
        return jenisIdentitas;
    }

    public void setJenisIdentitas(String jenisIdentitas) {
        this.jenisIdentitas = jenisIdentitas;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Object getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public int getStatusDebitur() {
        return statusDebitur;
    }

    public void setStatusDebitur(int statusDebitur) {
        this.statusDebitur = statusDebitur;
    }

    public String getStatusModul() {
        return statusModul;
    }

    public void setStatusModul(String statusModul) {
        this.statusModul = statusModul;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public List<ProspekBiodataModel> getBiodataModel() {
        return biodataModel;
    }

    public void setBiodataModel(List<ProspekBiodataModel> biodataModel) {
        this.biodataModel = biodataModel;
    }

    public List<ProspekReferensiModel> getRefferenceModel() {
        return refferenceModel;
    }

    public void setRefferenceModel(List<ProspekReferensiModel> refferenceModel) {
        this.refferenceModel = refferenceModel;
    }

    public List<ProspekJadwalModel> getJadwalModel() {
        return jadwalModel;
    }

    public void setJadwalModel(List<ProspekJadwalModel> jadwalModel) {
        this.jadwalModel = jadwalModel;
    }

    public List<ProspekAlamatModel> getAlamatModel() {
        return alamatModel;
    }

    public void setAlamatModel(List<ProspekAlamatModel> alamatModel) {
        this.alamatModel = alamatModel;
    }

    public List<ProspekKeluargaModel> getKeluargaModel() {
        return keluargaModel;
    }

    public void setKeluargaModel(List<ProspekKeluargaModel> keluargaModel) {
        this.keluargaModel = keluargaModel;
    }

    public List<ProspekAplikasiModel> getAplikasiModel() {
        return aplikasiModel;
    }

    public void setAplikasiModel(List<ProspekAplikasiModel> aplikasiModel) {
        this.aplikasiModel = aplikasiModel;
    }

    public List<ProspekRencanaAgunanModel> getRencanaAgunanModel() {
        return rencanaAgunanModel;
    }

    public void setRencanaAgunanModel(List<ProspekRencanaAgunanModel> rencanaAgunanModel) {
        this.rencanaAgunanModel = rencanaAgunanModel;
    }

    public List<ProspekLainnyaModel> getLainnyaModel() {
        return lainnyaModel;
    }

    public void setLainnyaModel(List<ProspekLainnyaModel> lainnyaModel) {
        this.lainnyaModel = lainnyaModel;
    }

    public List<ProspekKontakModel> getKontakModel() {
        return kontakModel;
    }

    public void setKontakModel(List<ProspekKontakModel> kontakModel) {
        this.kontakModel = kontakModel;
    }

    public String getIdNasabahPNM() {
        return idNasabahPNM;
    }

    public void setIdNasabahPNM(String idNasabahPNM) {
        this.idNasabahPNM = idNasabahPNM;
    }

    public int getHasilCekIdi() {
        return hasilCekIdi;
    }

    public void setHasilCekIdi(int hasilCekIdi) {
        this.hasilCekIdi = hasilCekIdi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idDebitur);
        dest.writeString(idTransaksiDebitur);
        dest.writeString(namaPanggilan);
        dest.writeString(jenisIdentitas);
        dest.writeString(noIdentitas);
        dest.writeString(createdBy);
        dest.writeString(createdDate);
        dest.writeString(modifiedBy);
        dest.writeString(modifiedDate);
        dest.writeInt(isActive);
        dest.writeInt(visit);
        dest.writeInt(statusDebitur);
        dest.writeString(statusModul);
        dest.writeString(statusName);
        dest.writeInt(progress);
        dest.writeTypedList(biodataModel);
        dest.writeTypedList(refferenceModel);
        dest.writeTypedList(jadwalModel);
        dest.writeTypedList(alamatModel);
        dest.writeTypedList(keluargaModel);
        dest.writeTypedList(aplikasiModel);
        dest.writeTypedList(rencanaAgunanModel);
        dest.writeTypedList(lainnyaModel);
        dest.writeTypedList(kontakModel);
        dest.writeString(idNasabahPNM);
        dest.writeInt(hasilCekIdi);
    }
}
