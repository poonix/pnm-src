package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */


@IntDef({StatusType.BARU,
        StatusType.PROSPEK,
        StatusType.PROSPEK_MENUNGGU,
        StatusType.PROSPEK_REVISI,
        StatusType.PROSPEK_DITOLAK,
        StatusType.SURVEY,
        StatusType.SURVEY_MENUNGGU,
        StatusType.SURVEY_REVISI,
        StatusType.SURVEY_DITOLAK,
        StatusType.SURVEY_DITERIMA
})
@Retention(RetentionPolicy.SOURCE)
public @interface StatusType {
    int BARU = 1;
    int PROSPEK = 2;
    int PROSPEK_MENUNGGU = 3;
    int PROSPEK_REVISI = 4;
    int PROSPEK_DITOLAK = 5;
    int SURVEY = 6;
    int SURVEY_MENUNGGU = 7;
    int SURVEY_REVISI = 8;
    int SURVEY_DITOLAK = 9;
    int SURVEY_DITERIMA = 10;
}

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
 */