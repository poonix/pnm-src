package com.example.saifullah_albasrie.pnm.model.state;

import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;

/**
 * Created by saifullahalbasrie on 7/22/17.
 */

public class DataProspekModelStateChanged {
    private ProspekListItemModel dataModel;
    private int type;

    public DataProspekModelStateChanged(ProspekListItemModel dataModel) {
        this.dataModel = dataModel;
    }

    public DataProspekModelStateChanged(ProspekListItemModel dataModel, int type) {
        this.dataModel = dataModel;
        this.type = type;
    }

    public ProspekListItemModel getDataModel() {
        return dataModel;
    }

    public int getType() {
        return type;
    }
}
