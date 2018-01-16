package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/27/17.
 */

public interface BandingDetailCallback {

    void onSendApprovalSuccess(String message);

    void onSendApprovalFailed(Throwable t);
}
