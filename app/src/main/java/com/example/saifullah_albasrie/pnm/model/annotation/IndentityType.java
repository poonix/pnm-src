package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */


@IntDef({IndentityType.KTP, IndentityType.SIM, IndentityType.OTHERS})
@Retention(RetentionPolicy.SOURCE)
public @interface IndentityType {
    int KTP = 0;
    int SIM = 1;
    int OTHERS = 2;
}