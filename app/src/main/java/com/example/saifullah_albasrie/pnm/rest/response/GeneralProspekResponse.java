package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class GeneralProspekResponse extends BaseResponse{

    @SerializedName("biodata")
    @Expose
    private List<ProspekBiodataModel> biodata = null;

    @SerializedName("referensi")
    @Expose
    private List<ProspekReferensiModel> referensi = null;

    @SerializedName("jadwal")
    @Expose
    private List<ProspekJadwalModel> jadwal = null;


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
}
