package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@IntDef({TabIndexCollection.PENAGIHAN, TabIndexCollection.KOLEKTIBILITAS, TabIndexCollection.KETERANGAN})
@Retention(RetentionPolicy.SOURCE)
public @interface TabIndexCollection {
    int PENAGIHAN = 0;
    int KOLEKTIBILITAS = 1;
    int KETERANGAN = 2;
    int DETAIL = 3;

}