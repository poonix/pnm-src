package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/27/17.
 */

public interface FeedbackListCallback {

    void onGetListFeedbackSuccess(List<FeedbackItemModel> listItemModels);

    void onGetListFeedbackFailed(Throwable t);
}
