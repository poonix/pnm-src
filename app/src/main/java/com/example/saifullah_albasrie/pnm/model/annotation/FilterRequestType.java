package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

/**
 * Created by saifullahalbasrie on 4/28/17.
 */


@IntDef({
        FilterRequestType.FILTER_PROSPEK,
        FilterRequestType.FILTER_SURVEY,
        FilterRequestType.FILTER_COLLECTION,
        FilterRequestType.FILTER_FEEDBACK,
        FilterRequestType.FILTER_OTHERS
})
public @interface FilterRequestType {
    int FILTER_PROSPEK = 100;
    int FILTER_SURVEY = 101;
    int FILTER_COLLECTION = 102;
    int FILTER_FEEDBACK = 103;
    int FILTER_OTHERS= 104;
}
