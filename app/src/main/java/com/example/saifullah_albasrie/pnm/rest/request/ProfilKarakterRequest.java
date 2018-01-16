package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class ProfilKarakterRequest {

    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    @SerializedName("ProfildanKarakter")
    @Expose
    public List<SurveyProfilKarakterModel> profilDanKarakter;

    public ProfilKarakterRequest(SurveyProfilKarakterModel profileKarakterModel) {
        setupRequest(profileKarakterModel);
    }

    private void setupRequest(SurveyProfilKarakterModel profileModel) {
        if(profileModel!=null && AppPreference.getInstance().getUserLoggedIn() != null) {
            BiodataModel biodataModel = new BiodataModel();
            biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
            biodataModel.setIdDebitur(profileModel.getIdDebitur());
            biodataModel.setIdTransaksiDebitur(profileModel.getIdTransaksiDebitur());
            biodata = new ArrayList<>();
            biodata.add(biodataModel);

            profilDanKarakter = new ArrayList<>();
            profilDanKarakter.add(profileModel);
        }
    }

    /*
    class BiodataModel {
        @SerializedName("id_sdm")
        @Expose
        public String idSdm;
        @SerializedName("id_debitur")
        @Expose
        public String idDebitur;
        @SerializedName("id_transaksi_debitur")
        @Expose
        public String idTransaksiDebitur;

        public String getIdSdm() {
            return idSdm;
        }

        public void setIdSdm(String idSdm) {
            this.idSdm = idSdm;
        }

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
    }*/
}
