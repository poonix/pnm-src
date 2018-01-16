package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by suherman on 3/18/17.
 */


@IntDef({FilterCreatedType.ALL, FilterCreatedType.TODAY, FilterCreatedType.DAY_7, FilterCreatedType.DAY_30})
public @interface FilterCreatedType {
    int ALL = 0;
    int TODAY = 1;
    int DAY_7 = 2;
    int DAY_30 = 3;
}
