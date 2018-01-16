package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface ProspekItemCallback {

    void onSaveProspekSuccess(ProspekListItemModel itemModel);

    void onSaveProspekFailed(Throwable t);
}
