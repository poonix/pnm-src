package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by suherman on 3/18/17.
 */


@IntDef({FilterStatusType.ALL, FilterStatusType.SURVEY, FilterStatusType.REVISI})
public @interface FilterStatusType {
    int ALL = 0;
    int SURVEY = 1;
    int REVISI = 2;

}
