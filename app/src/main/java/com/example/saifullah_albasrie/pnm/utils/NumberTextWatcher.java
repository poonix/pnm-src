package com.example.saifullah_albasrie.pnm.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by saifullahalbasrie on 4/16/17.
 */

public class NumberTextWatcher implements TextWatcher {

    private String format = "###,###,###,###";
    private boolean mEditing;
    private int maxLength;
    private double maxValue;

    public NumberTextWatcher() {
        mEditing = false;
    }

    public NumberTextWatcher(String format) {
        this.format = format;
        mEditing = false;
    }

    public synchronized void afterTextChanged(Editable s) {
        if(!mEditing) {
            mEditing = true;

            try{
                //String digits = s.toString().replaceAll( "[^\\d]", "" );
                String digits = s.toString().replaceAll( ",", "" );
                if (maxLength > 0 && digits.length() > maxLength) {
                    digits.substring(0, maxLength);
                }
                DecimalFormat nf = new DecimalFormat(format);
                double val = Double.parseDouble(digits);
                if (maxValue > 0 && val > maxValue) {
                    val = maxValue;
                    //val = Double.parseDouble(prevText);
                }
                String formatted = nf.format(val);
                s.replace(0, s.length(), formatted);
            } catch (Exception nfe) {

            }

            mEditing = false;
        }
    }

    private String prevText = "";
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        prevText = s.toString();
        try {
            String digits = s.toString().replaceAll( ",", "" );
            prevText = digits;
        }catch (Exception e){}
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
        this.maxLength = new DecimalFormat("#").format(maxValue).length();
    }

}
