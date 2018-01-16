package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAplikasiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKeluargaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekKontakModel;
import com.example.saifullah_albasrie.pnm.model.ProspekLainnyaModel;
import com.example.saifullah_albasrie.pnm.model.ProspekReferensiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekRencanaAgunanModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface GeneralProspekDetailCallback {

    void onGetGeneralProspekDetailSuccess(List<ProspekBiodataModel> biodataModels,
                                          List<ProspekKontakModel> kontakModels,
                                          List<ProspekReferensiModel> refferenceModels,
                                          List<ProspekJadwalModel> jadwalModels,
                                          List<ProspekAlamatModel> alamatModels,
                                          List<ProspekKeluargaModel> keluargaModels,
                                          List<ProspekAplikasiModel> aplikasiModels,
                                          List<ProspekRencanaAgunanModel> rencanaAgunanModels,
                                          List<ProspekLainnyaModel> lainnyaModels
    );

    void onGetGeneralProspekDetailFailed(Throwable t);

    void onSaveProspekDetailSuccess(String message);

    void onSaveProspekDetailFailed(Throwable t);

    void onSendApprovalSuccess(String message);

    void onSendApprovalFailed(Throwable t);
}
