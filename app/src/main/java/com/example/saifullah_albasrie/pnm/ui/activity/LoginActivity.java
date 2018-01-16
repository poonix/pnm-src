package com.example.saifullah_albasrie.pnm.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.LoginCallback;
import com.example.saifullah_albasrie.pnm.controller.LoginController;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;

public class LoginActivity extends AppCompatActivity implements LoginCallback{

    private LoginController loginController;

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    //private View mProgressView;
    private TextView mErrorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mErrorView = (TextView) findViewById(R.id.tv_error);
        //mProgressView = findViewById(R.id.login_progress);

        //mEmailView.setText("FARahmani0205");
        //mPasswordView.setText("admin123");
        //mEmailView.setText("Agus0816");
        //mPasswordView.setText("pnm12345");

        //1. AOM - sherdiana1010 – pnm12345
        //mEmailView.setText("sherdiana1010");
        //mPasswordView.setText("pnm12345");
        //2. KKU - rahyu0817 – pnm12345
        //mEmailView.setText("rahyu0817");
        //mPasswordView.setText("pnm12345");

        loginController = new LoginController(this);

        CommonUtil.checkInternet(this);

        CommonUtil.checkGPSEnable(this);
    }

    private void attemptLogin() {
        if (loginController != null) {
            loginController.cancel();
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);
        mErrorView.setVisibility(View.INVISIBLE);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            processLogin(email, password);
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if ( show) {
            DialogFactory.showProgress(this);
        } else {
            DialogFactory.dismissProgress();
        }

        /*
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            //mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
        */
    }

    private void processLogin(String email, String password) {
        /*
        if(email.equals("admin") && password.equals("admin")) {
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
            return;
        }
        */

        showProgress(true);
        loginController.doLoginSSO(email, password);
    }

    @Override
    public void onLoginSSOSuccess(UserSSOModel userModel) {
        loginController.doLogin(userModel.getIdsdm());
    }

    @Override
    public void onLoginSSOFailed(Throwable t) {
        showProgress(false);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(t.getMessage());
    }

    @Override
    public void onLoginInternalSuccess(UserModel userModel) {
        /*showProgress(false);
        goToMainPage();
        finish();*/
        //wait for data inittialitation
    }

    @Override
    public void onLoginInternalFailed(Throwable t) {
        showProgress(false);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(t.getMessage());
    }

    @Override
    public void onLoginProcessCompleted() {
        showProgress(false);
        goToMainPage();
        finish();
    }

    @Override
    public void onLoginProcessNotCompleted(Throwable t) {
        showProgress(false);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(t.getMessage());
    }

    private void goToMainPage() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

}

