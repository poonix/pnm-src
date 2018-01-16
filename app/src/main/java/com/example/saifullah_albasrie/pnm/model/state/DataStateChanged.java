package com.example.saifullah_albasrie.pnm.model.state;

import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class DataStateChanged {
    private boolean isRefresh;
    private int type;

    public DataStateChanged(boolean isRefresh) {
        this.isRefresh = isRefresh;
    }

    public DataStateChanged(boolean isRefresh, int type) {
        this.isRefresh = isRefresh;
        this.type = type;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public int getType() {
        return type;
    }
}
