package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.SurveyProfilKarakterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/15/17.
 */

public class ProfilKarakterResponse extends BaseResponse {

    @SerializedName("ProfildanKarakter")
    @Expose
    public List<SurveyProfilKarakterModel> profilDanKarakter;

    public List<SurveyProfilKarakterModel> getProfilDanKarakter() {
        return profilDanKarakter;
    }

    public void setProfilDanKarakter(List<SurveyProfilKarakterModel> profilDanKarakter) {
        this.profilDanKarakter = profilDanKarakter;
    }
}
