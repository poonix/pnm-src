package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by aldhiramdan on 3/22/17.
 */

@IntDef({SurveyItemType.SURVEY,
        SurveyItemType.PROFILE_AND_KARAKTER,
        SurveyItemType.KAPASITAS_USAHA,
        SurveyItemType.JENIS_USAHA,
        SurveyItemType.KEUANGAN,
        SurveyItemType.KEBUTUHAN_MODAL_KERJA,
        SurveyItemType.KELUARGA,
        SurveyItemType.JAMINAN,
        SurveyItemType.DOKUMEN_LAINNYA,
        SurveyItemType.BTN_CHECK_SID,
        SurveyItemType.BTN_KIRIM_PENGAJUAN})
public @interface SurveyItemType {
    int SURVEY = 0;
    int PROFILE_AND_KARAKTER = 1;
    int KAPASITAS_USAHA = 2;
    int JENIS_USAHA = 3;
    int KEUANGAN = 4;
    int KEBUTUHAN_MODAL_KERJA = 5;
    int KELUARGA = 6;
    int JAMINAN = 7;
    int DOKUMEN_LAINNYA = 8;
    int BTN_CHECK_SID = 9;
    int BTN_KIRIM_PENGAJUAN = 10;

}
