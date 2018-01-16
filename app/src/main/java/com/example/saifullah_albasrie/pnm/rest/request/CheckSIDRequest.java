package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/24/17.
 */

public class CheckSIDRequest {
    @SerializedName("biodata")
    @Expose
    public List<BiodataModel> biodata;

    public CheckSIDRequest(BiodataModel biodataModel) {
        biodata = new ArrayList<>();
        biodata.add(biodataModel);
    }
}
