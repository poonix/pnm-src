package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAplikasiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface GeneralProspekCallback {

    void onGetGeneralProspekSuccess(List<ProspekBiodataModel> biodataModels, List<ProspekReferensiModel> refferenceModels, List<ProspekJadwalModel> jadwalModels);

    void onGetGeneralProspekFailed(Throwable t);

    void onSaveProspekSuccess(String message);

    void onSaveProspekFailed(Throwable t);

    void onAutoSaveProspekSuccess(String idDebitur, String idTransaksiDebitur);

    void onAutoSaveProspekFailed(Throwable t);

    void onSendApprovalSuccess(String statusMsg);

    void onSendApprovalFailed(Throwable throwable);
}
