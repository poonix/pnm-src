package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.RiwayatAngsuran;

import java.util.List;

/**
 * Created by saifullahalbasrie on 4/11/17.
 */

public interface CheckRiwayatAngsuranCallback {

    void onCheckRiwayatAngsuranSuccess(List<RiwayatAngsuran> data);

    void onCheckRiwayatAngsuranFailed(Throwable t);

}
