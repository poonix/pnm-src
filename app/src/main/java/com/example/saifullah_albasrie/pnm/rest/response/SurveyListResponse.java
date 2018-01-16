package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class SurveyListResponse extends BaseResponse {

    @SerializedName(value = "survey", alternate = {"prospek"})
    @Expose
    private List<ProspekListItemModel> listItems;

    public List<ProspekListItemModel> getListItems() {
        return listItems;
    }

    public void setListItems(List<ProspekListItemModel> listItems) {
        this.listItems = listItems;
    }
}
