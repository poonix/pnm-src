package com.example.saifullah_albasrie.pnm.model.state;

import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class FormModeStateChanged {
    private int formMode;
    private boolean isResetView;

    public FormModeStateChanged(@FormMode int formMode) {
        this.formMode = formMode;
    }

    public FormModeStateChanged(@FormMode int formMode, boolean isResetView) {
        this.formMode = formMode;
        this.isResetView = isResetView;
    }

    public int getFormMode() {
        return formMode;
    }

    public boolean isResetView() {
        return isResetView;
    }
}
