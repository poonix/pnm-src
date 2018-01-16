package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/22/17.
 */


@IntDef({
        FormMode.NEW,
        FormMode.VIEW,
        FormMode.EDIT,
        FormMode.READ_ONLY
})
@Retention(RetentionPolicy.SOURCE)
public @interface FormMode {
    int NEW = 0;
    int VIEW = 1;
    int EDIT = 2;
    int READ_ONLY = 3;
}