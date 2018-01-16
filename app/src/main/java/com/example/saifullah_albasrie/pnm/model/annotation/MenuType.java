package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/22/17.
 */


@IntDef({
        MenuType.MAIN_MENU,
        MenuType.SUB_MENU,
        MenuType.SURVEY_MENU,
        MenuType.BUTTON_MENU
})
@Retention(RetentionPolicy.SOURCE)
public @interface MenuType {
    int MAIN_MENU = 0;
    int SUB_MENU = 1;
    int SURVEY_MENU = 2;
    int BUTTON_MENU = 3;
    int BUTTON_ADD = 4;
    int JAMINAN_MENU = 5;
}