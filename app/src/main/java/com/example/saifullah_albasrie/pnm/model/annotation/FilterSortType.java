package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by suherman on 3/18/17.
 */


@IntDef({FilterSortType.NO_SORT, FilterSortType.JATUH_TEMPO, FilterSortType.AGING, FilterSortType.OS})
public @interface FilterSortType {
    int NO_SORT = 0;
    int JATUH_TEMPO = 1;
    int AGING = 2;
    int OS = 3;
}
