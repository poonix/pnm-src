package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface LogoutCallback {

    void onLogoutSuccess();

    void onLogoutFailed(Throwable t);

}
