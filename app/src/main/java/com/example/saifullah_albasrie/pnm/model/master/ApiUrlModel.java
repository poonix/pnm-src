package com.example.saifullah_albasrie.pnm.model.master;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class ApiUrlModel implements Parcelable{

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("url_type")
    @Expose
    private String urlType;

    @SerializedName("url")
    @Expose
    private String url;

    protected ApiUrlModel(Parcel in) {
        id = in.readInt();
        urlType = in.readString();
        url = in.readString();
    }

    public static final Creator<ApiUrlModel> CREATOR = new Creator<ApiUrlModel>() {
        @Override
        public ApiUrlModel createFromParcel(Parcel in) {
            return new ApiUrlModel(in);
        }

        @Override
        public ApiUrlModel[] newArray(int size) {
            return new ApiUrlModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(urlType);
        dest.writeString(url);
    }
}
