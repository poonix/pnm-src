package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface ListProspekCallback {

    void onGetListProspekSuccess(List<ProspekListItemModel> listItemModels);

    void onGetListProspekFailed(Throwable t);
}
