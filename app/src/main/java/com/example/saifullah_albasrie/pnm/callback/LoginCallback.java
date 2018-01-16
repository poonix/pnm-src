package com.example.saifullah_albasrie.pnm.callback;

import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;

/**
 * Created by saifullahalbasrie on 3/28/17.
 */

public interface LoginCallback {

    void onLoginSSOSuccess(UserSSOModel userModel);

    void onLoginSSOFailed(Throwable t);

    void onLoginInternalSuccess(UserModel userModel);

    void onLoginInternalFailed(Throwable t);

    void onLoginProcessCompleted();

    void onLoginProcessNotCompleted(Throwable t);
}
