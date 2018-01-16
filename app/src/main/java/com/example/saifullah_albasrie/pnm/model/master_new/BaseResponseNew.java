package com.example.saifullah_albasrie.pnm.model.master_new;

import com.example.saifullah_albasrie.pnm.model.master.BaseMasterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by azhaclient-4 on 1/11/2018.
 */

 /*{
         "MS_PARA_GLOBAL_DETAIL_ID": 1,
         "MS_DESKRIPSI": "KTP"
         },*/

public class BaseResponseNew implements BaseMasterModel {

    @SerializedName("MS_PARA_GLOBAL_DETAIL_ID")
    @Expose
    private int MS_PARA_GLOBAL_DETAIL_ID;

    @SerializedName("MS_DESKRIPSI")
    @Expose
    private String Deskripsi;

    public int getId() {
        return MS_PARA_GLOBAL_DETAIL_ID;
    }

    public void setId(int id) {
        this.MS_PARA_GLOBAL_DETAIL_ID = id;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    @Override
    public String toString() {
        return getDeskripsi();
    }

    @Override
    public Object getIdentifier() {
        return getId();
    }

}
