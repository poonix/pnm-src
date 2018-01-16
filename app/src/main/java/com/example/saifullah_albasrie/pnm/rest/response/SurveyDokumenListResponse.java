package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.DokumenItemModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class SurveyDokumenListResponse extends BaseResponse {
    /*
    {
  "pribadi": {
    "jumlah_foto": 0
  },
  "pembiayaan": {
    "jumlah_foto": 0
  },
  "keluarga": {
    "jumlah_foto": 2
  },
  "agunan": {
    "jumlah_foto": 0
  },
  "pinjaman": {
    "jumlah_foto": 0
  },
  "response": "true",
  "status": "ada"
}
     */

    @SerializedName("pribadi")
    @Expose
    private DokumenItemModel dokumenPribadi;

    @SerializedName("keluarga")
    @Expose
    private DokumenItemModel dokumenKeluarga;

    @SerializedName("pembiayaan")
    @Expose
    private DokumenItemModel dokumenPembiayaan;

    @SerializedName("pinjaman")
    @Expose
    private DokumenItemModel dokumenPinjaman;

    @SerializedName("agunan")
    @Expose
    private DokumenItemModel dokumenAgunan;


    public DokumenItemModel getDokumenPribadi() {
        return dokumenPribadi;
    }

    public void setDokumenPribadi(DokumenItemModel dokumenPribadi) {
        this.dokumenPribadi = dokumenPribadi;
    }

    public DokumenItemModel getDokumenKeluarga() {
        return dokumenKeluarga;
    }

    public void setDokumenKeluarga(DokumenItemModel dokumenKeluarga) {
        this.dokumenKeluarga = dokumenKeluarga;
    }

    public DokumenItemModel getDokumenPembiayaan() {
        return dokumenPembiayaan;
    }

    public void setDokumenPembiayaan(DokumenItemModel dokumenPembiayaan) {
        this.dokumenPembiayaan = dokumenPembiayaan;
    }

    public DokumenItemModel getDokumenPinjaman() {
        return dokumenPinjaman;
    }

    public void setDokumenPinjaman(DokumenItemModel dokumenPinjaman) {
        this.dokumenPinjaman = dokumenPinjaman;
    }

    public DokumenItemModel getDokumenAgunan() {
        return dokumenAgunan;
    }

    public void setDokumenAgunan(DokumenItemModel dokumenAgunan) {
        this.dokumenAgunan = dokumenAgunan;
    }
}
