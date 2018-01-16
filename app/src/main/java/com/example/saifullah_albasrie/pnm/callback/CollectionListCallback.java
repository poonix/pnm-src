package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/26/17.
 */

public interface CollectionListCallback {

    void onGetListCollectionSuccess(List<PnmDebiturModel> listItemModels);

    void onGetListCollectionFailed(Throwable t);
}
