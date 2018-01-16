package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.rest.response.KapasitasUsahaResponse;

/**
 * Created by aldhiramdan on 4/20/17.
 */

public interface SurveyKapasitasUsahaCallback {

    void onGetKapasitasUsahaSuccess(KapasitasUsahaResponse kapasitasUsahaResponse);

    void onGetKapsitasUsahaFailure(Throwable t);

    void onSaveKapasitasUsahaSuccess(String message);

    void onSaveKapasitasUsahaFailure(Throwable t);

}
