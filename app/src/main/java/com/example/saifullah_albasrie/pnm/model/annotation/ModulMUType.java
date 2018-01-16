package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 4/5/17.
 */


@IntDef({
        ModulMUType.MODUL_HOME,
        ModulMUType.MODUL_MU_PROSPEK,
        ModulMUType.MODUL_MU_DETAIL_PROSPEK,
        ModulMUType.MODUL_MU_PENGAJUAN,
        ModulMUType.MODUL_MU_BANDING,
        ModulMUType.MODUL_MU_HISTORICAL
})
@Retention(RetentionPolicy.SOURCE)
public @interface ModulMUType {
    int MODUL_HOME = -1;
    int MODUL_MU_PROSPEK = 0;
    int MODUL_MU_DETAIL_PROSPEK = 1;
    int MODUL_MU_PENGAJUAN = 2;
    int MODUL_MU_BANDING = 3;
    int MODUL_MU_HISTORICAL = 4;
}