package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 4/5/17.
 */


@IntDef({
        ModulType.MODUL_HOME,
        ModulType.MODUL_PROSPEK,
        ModulType.MODUL_PROSPEK_DETAIL,
        ModulType.MODUL_SURVEY,
        ModulType.MODUL_COLLECTION,
        ModulType.MODUL_FEEDBACK,
        ModulType.MODUL_HISTORICAL
})
@Retention(RetentionPolicy.SOURCE)
public @interface ModulType {
    int MODUL_HOME = -1;
    int MODUL_PROSPEK = 0;
    int MODUL_PROSPEK_DETAIL = 1;
    int MODUL_SURVEY = 2;
    int MODUL_COLLECTION = 3;
    int MODUL_FEEDBACK = 4;
    int MODUL_HISTORICAL = 5;

}