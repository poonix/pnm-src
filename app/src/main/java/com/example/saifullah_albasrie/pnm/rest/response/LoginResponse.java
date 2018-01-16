package com.example.saifullah_albasrie.pnm.rest.response;

import com.example.saifullah_albasrie.pnm.model.master.ApiUrlModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class LoginResponse extends BaseResponse {

    @SerializedName("login")
    @Expose
    private List<UserModel> userModel;

    @SerializedName("urlapi")
    @Expose
    private List<ApiUrlModel> urlapi = null;

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }

    public UserModel getUserLoggedin() {
        try{
            return getUserModel().get(0);
        }catch (Exception e) {
            return null;
        }
    }

    public List<ApiUrlModel> getUrlapi() {
        return urlapi;
    }

    public void setUrlapi(List<ApiUrlModel> urlapi) {
        this.urlapi = urlapi;
    }
}
