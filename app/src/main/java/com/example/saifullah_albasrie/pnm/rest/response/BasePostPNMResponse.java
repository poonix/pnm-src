package com.example.saifullah_albasrie.pnm.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by indri on 1/24/18.
 */

public class BasePostPNMResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("desc")
    @Expose
    private String desc;

    public String getResponse() {
        return status;
    }

    public void setResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return desc;
    }

    public void setStatus(String desc) {
        this.desc = desc;
    }


    public boolean isSuccessResponse() {
        return getResponse()!= null && getResponse().equalsIgnoreCase("success");
    }
}
