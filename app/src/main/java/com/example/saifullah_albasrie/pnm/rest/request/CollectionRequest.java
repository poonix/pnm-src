package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.CollectionModel;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class CollectionRequest extends BaseResponse {
    @SerializedName("collection")
    @Expose
    private List<CollectionModel> collectionModels;

    public CollectionRequest(CollectionModel model) {
        collectionModels = new ArrayList<>();
        collectionModels.add(model);
    }

}
