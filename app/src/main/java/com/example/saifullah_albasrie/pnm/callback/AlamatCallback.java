package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.example.saifullah_albasrie.pnm.model.master.KelurahanModel;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/6/17.
 */

public interface AlamatCallback {

    void onGetKabupatenSuccess(List<KabupatenModel> list);

    void onGetKabupatenFailed(Throwable t);

    void onGetKecamatanSuccess(List<KecamatanModel> list);

    void onGetKecamatanFailed(Throwable t);

    void onGetKelurahanSuccess(List<KelurahanModel> list);

    void onGetKelurahanFailed(Throwable t);

}
