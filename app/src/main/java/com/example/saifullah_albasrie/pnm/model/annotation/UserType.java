package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/26/17.
 */


@IntDef({
        UserType.ANALIS,
        UserType.MANAGER_UNIT})
@Retention(RetentionPolicy.SOURCE)
public @interface UserType {
    int ANALIS = 1;
    int MANAGER_UNIT = 2;
}