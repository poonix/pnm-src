package com.example.saifullah_albasrie.pnm.rest.request;

import com.example.saifullah_albasrie.pnm.model.ApprovalProspekModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/8/17.
 */

public class ApprovalPengajuanRequest {

    @SerializedName("approval_survey")
    @Expose
    private List<ApprovalProspekModel> approvalProspekModelList;

    public List<ApprovalProspekModel> getApprovalProspekModelList() {
        return approvalProspekModelList;
    }

    public void setApprovalProspekModelList(List<ApprovalProspekModel> approvalProspekModelList) {
        this.approvalProspekModelList = approvalProspekModelList;
    }
}
