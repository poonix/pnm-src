package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by saifullahalbasrie on 4/28/17.
 */


@IntDef({
        FilterJatuhTempoType.ALL,
        FilterJatuhTempoType.H_7,
        FilterJatuhTempoType.H_3,
        FilterJatuhTempoType.H_1
})
public @interface FilterJatuhTempoType {
    int ALL = 0;
    int H_7 = 1;
    int H_3 = 2;
    int H_1 = 3;
}
