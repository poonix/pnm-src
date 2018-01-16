package com.example.saifullah_albasrie.pnm.model.state;

import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

/**
 * Created by saifullahalbasrie on 9/28/17.
 */

public class CheckIDIStateChanged {
    private ProspekListItemModel dataModel;
    private ProspekBiodataModel biodataModel;
    private int isChekStatus;

    public CheckIDIStateChanged(ProspekListItemModel dataModel, ProspekBiodataModel biodataModel) {
        this.dataModel = dataModel;
        this.biodataModel = biodataModel;
    }

    public ProspekListItemModel getDataModel() {
        return dataModel;
    }

    public ProspekBiodataModel getBiodataModel() {
        return biodataModel;
    }

    public CheckIDIStateChanged(int isChekStatus) {
        this.isChekStatus = isChekStatus;
    }

    public int getIsChekStatus() {
        return isChekStatus;
    }
}
