package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.CollectionModel;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.rest.response.CollectionResponse;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/26/17.
 */

public interface CollectionDetailCallback {

    void onGetCollectionDetailSuccess(CollectionModel model);

    void onGetCollectionDetailFailed(Throwable t);

    void onSaveCollectionSuccess(String message) ;

    void onSaveCollectionFailed(Throwable t);
}
