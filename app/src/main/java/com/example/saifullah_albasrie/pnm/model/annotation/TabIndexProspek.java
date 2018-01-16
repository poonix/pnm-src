package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@IntDef({
        TabIndexProspek.BIODATA,
        TabIndexProspek.REFERENSI,
        TabIndexProspek.JADWAL,
        //TabIndexProspek.CHECK_SID,
        TabIndexProspek.HISTORY_PEMBIAYAAN
})
@Retention(RetentionPolicy.SOURCE)
public @interface TabIndexProspek {
    int BIODATA = 0;
    int REFERENSI = 1;
    int JADWAL = 2;
    //int CHECK_SID = 3;
    int HISTORY_PEMBIAYAAN = 3;

}