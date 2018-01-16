package com.example.saifullah_albasrie.pnm.model.master;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 4/2/17.
 */

public class StatusDebiturModel implements BaseMasterModel{

    /*
    "master_status": [
    {
      "id": 1,
      "modul": "prospek",
      "status": "BARU"
    },
    {
      "id": 2,
      "modul": "detail_prospek",
      "status": "PROSPEK"
    },
    {
      "id": 3,
      "modul": "detail_prospek",
      "status": "PROSPEK-MENUNGGU"
    },
    {
      "id": 4,
      "modul": "detail_prospek",
      "status": "PROSPEK-REVISI"
    },
    {
      "id": 5,
      "modul": "detail_prospek",
      "status": "PROSPEK-DITOLAK"
    },
    {
      "id": 6,
      "modul": "survey",
      "status": "SURVEY"
    },
    {
      "id": 7,
      "modul": "survey",
      "status": "SURVEY-MENUNGGU"
    },
    {
      "id": 8,
      "modul": "survey",
      "status": "SURVEY-REVISI"
    },
    {
      "id": 9,
      "modul": "survey",
      "status": "SURVEY-DITOLAK"
    },
    {
      "id": 10,
      "modul": "survey",
      "status": "SURVEY-DITERIMA"
    }
  ],
     */

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("modul")
    @Expose
    private String modul;

    @SerializedName("status")
    @Expose
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }
}
