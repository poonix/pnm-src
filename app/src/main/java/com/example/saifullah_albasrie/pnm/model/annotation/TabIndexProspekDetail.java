package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@IntDef({
        TabIndexProspekDetail.BIODATA,
        TabIndexProspekDetail.REFERENSI,
        TabIndexProspekDetail.JADWAL,
        TabIndexProspekDetail.ALAMAT,
        TabIndexProspekDetail.KELUARGA,
        TabIndexProspekDetail.CHECK_SID,
        TabIndexProspekDetail.APLIKASI,
        TabIndexProspekDetail.RENCANA_AGUNAN,
        TabIndexProspekDetail.LAINNYA,
        TabIndexProspekDetail.HISTORY_PEMBIAYAAN
})
@Retention(RetentionPolicy.SOURCE)
public @interface TabIndexProspekDetail {
    int BIODATA = 0;
    int REFERENSI = 1;
    int JADWAL = 2;
    int ALAMAT = 3;
    int KELUARGA = 4;
    int CHECK_SID = 5;
    int APLIKASI = 6;
    int RENCANA_AGUNAN = 7;
    int LAINNYA = 8;
    int HISTORY_PEMBIAYAAN = 9;
}