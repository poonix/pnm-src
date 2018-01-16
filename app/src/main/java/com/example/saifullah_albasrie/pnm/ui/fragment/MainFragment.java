package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.UserSSOModel;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import butterknife.BindView;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class MainFragment extends BaseFragment {

    private UserSSOModel userSSOModel;
    private UserModel userModel;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_jabatan)
    TextView tvJabatan;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_last_login)
    TextView tvLastLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userSSOModel = AppPreference.getInstance().getUserSSOLoggedIn();
        userModel = AppPreference.getInstance().getUserLoggedIn();
        setupData();
    }

    private void setupData() {
        if (userSSOModel != null) {
            tvName.setText(userSSOModel.getNama());
            tvJabatan.setText(userSSOModel.getPosisiNama());
            tvArea.setText(userSSOModel.getLokasiKerja() + " " + userSSOModel.getUnit());
            tvLastLogin.setText("Last log In : " + DateUtil.convertDateString(userModel.getLastLogin(), "yyyy-MM-dd", "dd/MM/yyyy"));
        }
    }

    @Override
    public int getFragmentView() {
        return R.layout.content_main;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
    }
}
