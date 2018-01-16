package com.example.saifullah_albasrie.pnm.model.annotation;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saifullah_albasrie on 3/22/17.
 */


@StringDef({
        DocumentType.PRIBADI,
        DocumentType.PEMBIAYAAN,
        DocumentType.KELUARGA,
        DocumentType.AGUNAN,
        DocumentType.PINJAMAN
})
@Retention(RetentionPolicy.SOURCE)
public @interface DocumentType {
    String PRIBADI = "dokumen_pribadi";
    String PEMBIAYAAN = "dokumen_pembiayaan";
    String KELUARGA = "dokumen_keluarga";
    String AGUNAN = "dokumen_agunan";
    String PINJAMAN = "dokumen_pinjaman";

}