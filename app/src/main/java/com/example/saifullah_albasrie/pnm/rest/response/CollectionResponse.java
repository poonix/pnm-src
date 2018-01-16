package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.model.CollectionModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/19/17.
 */

public class CollectionResponse extends BaseResponse {
    @SerializedName("collection")
    @Expose
    private List<CollectionModel> collectionModels;

    public List<CollectionModel> getCollectionModels() {
        return collectionModels;
    }

    public void setCollectionModels(List<CollectionModel> collectionModels) {
        this.collectionModels = collectionModels;
    }
}
