package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/27/17.
 */

public class BandingListResponse extends BaseResponse {

    @SerializedName("banding")
    @Expose
    private List<FeedbackItemModel> feedbackItemModels;

    public List<FeedbackItemModel> getFeedbackItemModels() {
        return feedbackItemModels;
    }

    public void setFeedbackItemModels(List<FeedbackItemModel> feedbackItemModels) {
        this.feedbackItemModels = feedbackItemModels;
    }
}
