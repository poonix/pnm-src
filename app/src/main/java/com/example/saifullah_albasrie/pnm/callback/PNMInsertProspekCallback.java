package com.example.saifullah_albasrie.pnm.callback;

/**
 * Created by indri on 1/24/18.
 */

public interface PNMInsertProspekCallback {
    void onSaveProspekSuccess(String message);

    void onSaveProspekFailed(Throwable t);
}
