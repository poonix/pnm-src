package com.example.saifullah_albasrie.pnm.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.LogoutCallback;
import com.example.saifullah_albasrie.pnm.controller.LogoutController;
import com.example.saifullah_albasrie.pnm.firebase.AppFirebaseIDService;
import com.example.saifullah_albasrie.pnm.firebase.AppFirebaseMessageService;
import com.example.saifullah_albasrie.pnm.firebase.AppNotificationManager;
import com.example.saifullah_albasrie.pnm.model.MenuModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.UserModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.ModulMUType;
import com.example.saifullah_albasrie.pnm.model.annotation.ModulType;
import com.example.saifullah_albasrie.pnm.model.annotation.MenuType;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.ui.adapter.MenuAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListBandingFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListCollectionFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListDetailProspekFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListFeedbackFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListHistoricalFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListProspekFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.MainFragment;
import com.example.saifullah_albasrie.pnm.ui.fragment.ListSurveyFragment;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements LogoutCallback, OnItemClickListener {
        //implements NavigationView.OnNavigationItemSelectedListener {

    private Unbinder unbinder;
    private LogoutController logoutController;

    private MenuAdapter mAdapter;
    private List<MenuModel> menuList;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;

    /*
    @BindView(R.id.tvProspek)
    TextView tvProspek;
    @BindView(R.id.tvProspekDetail)
    TextView tvDetailProspek;
    @BindView(R.id.tvSurvey)
    TextView tvSurvey;
    @BindView(R.id.tvCollection)
    TextView tvCollection;
    */

    @BindView(R.id.tvLogout)
    TextView tvLogout;
    @BindView(R.id.ivLogout)
    ImageView ivLogout;

    @OnClick({
            //R.id.tvProspek,
            //R.id.tvProspekDetail,
            //R.id.tvSurvey,
            //R.id.tvCollection,
            R.id.ivLogout
    })
    public void setOnClick(View v) {
        switch (v.getId()) {
            /*
            case R.id.tvProspek:
                setupFragment(0);
                break;
            case R.id.tvProspekDetail:
                setupFragment(1);
                break;
            case R.id.tvSurvey:
                setupFragment(2);
                break;
            case R.id.tvCollection:
                setupFragment(3);
                break;
            */
            case R.id.ivLogout:
                DialogFactory.showConfirmation(this, null, "Keluar aplikasi?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doLogout();
                    }
                });

                break;
        }
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CommonUtil.shouldLogin()) {
            showLogin();
            return;
        }
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        logoutController = new LogoutController(this);
        initView();
        loadMenu();
        setupFragment(ModulType.MODUL_HOME);

    }

    @Override
    protected void onResume() {
        super.onResume();
        CommonUtil.updateLastActive();
        CommonUtil.checkInternet(this);
        CommonUtil.checkGPSEnable(this);
        AppFirebaseIDService.resendFcmId();
    }

    private void showLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String tag = bundle.getString(AppNotificationManager.EXTRA_TAG);
            if (tag!=null && tag.equals(AppFirebaseMessageService.TYPE_FORCE_LOGOUT)) {
                AppPreference.getInstance().clearData();
                showLogin();
                return;
            }
        }

        if (CommonUtil.shouldLogin()) {
            showLogin();
            return;
        }


        if (bundle != null && AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            String tag = bundle.getString(AppNotificationManager.EXTRA_TAG);
            ProspekListItemModel dataModel = bundle.getParcelable(AppNotificationManager.EXTRA_DATA);
            if (dataModel != null) {
                if (tag!=null && tag.equals(AppFirebaseMessageService.TYPE_PROSPEK)) {
                    showProspek(dataModel);
                } else if (tag!=null && tag.equals(AppFirebaseMessageService.TYPE_SURVEY)) {
                    showPengajuan(dataModel);
                }
            } else {
                if (tag!=null && tag.equals(AppFirebaseMessageService.TYPE_PROSPEK)) {
                    setupFragmentMU(ModulMUType.MODUL_MU_PROSPEK);
                } else if (tag!=null && tag.equals(AppFirebaseMessageService.TYPE_SURVEY)) {
                    setupFragmentMU(ModulMUType.MODUL_MU_PENGAJUAN);
                }

            }
        }

    }

    private void showProspek(ProspekListItemModel model) {
        Intent intent = new Intent(this, FormProspekDetailActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
        intent.putExtra(Constant.BUNDLE_DATA, model);
        startActivity(intent);
    }

    private void showPengajuan(ProspekListItemModel model) {
        Intent intent = new Intent(this, SurveyItemActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
        intent.putExtra(Constant.BUNDLE_DATA, model);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    private void initView() {
        setupToolbar();
        setupNavigationDrawer();
        setupMenu();

        UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
        if( userModel != null) {
            tvLogout.setText(userModel.getFullname());
        }
    }

    private void setupMenu() {
        menuList = new ArrayList<>();
        mAdapter = new MenuAdapter(menuList);
        mAdapter.setOnItemClickListener(this);

        rvMenu.setHasFixedSize(true);
        rvMenu.setItemAnimator(new DefaultItemAnimator());
        rvMenu.setAdapter(mAdapter);
        rvMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void loadMenu() {
        UserModel userModel = AppPreference.getInstance().getUserLoggedIn();
        if( userModel != null && userModel.getIdUserGroup() == UserType.MANAGER_UNIT) {
            //menuList.add(new MenuModel(ModulMUType.MODUL_MU_PROSPEK, MenuType.MAIN_MENU, getString(R.string.prospek), getResources().getDrawable(R.drawable.mn_prospek_selector)));
            //menuList.add(new MenuModel(ModulMUType.MODUL_MU_DETAIL_PROSPEK, MenuType.MAIN_MENU, getString(R.string.prospek_detail), getResources().getDrawable(R.drawable.mn_prospek_selector)));
            menuList.add(new MenuModel(ModulMUType.MODUL_MU_DETAIL_PROSPEK, MenuType.MAIN_MENU, getString(R.string.prospek), getResources().getDrawable(R.drawable.mn_prospek_selector)));
            menuList.add(new MenuModel(ModulMUType.MODUL_MU_PENGAJUAN, MenuType.MAIN_MENU, getString(R.string.pengajuan), getResources().getDrawable(R.drawable.mn_pengajuan_selector)));
            menuList.add(new MenuModel(ModulMUType.MODUL_MU_BANDING, MenuType.MAIN_MENU, getString(R.string.banding), getResources().getDrawable(R.drawable.mn_banding_selector)));
            menuList.add(new MenuModel(ModulMUType.MODUL_MU_HISTORICAL, MenuType.MAIN_MENU, getString(R.string.historical), getResources().getDrawable(R.drawable.mn_historical_selector)));
        } else {
            menuList.add(new MenuModel(ModulType.MODUL_PROSPEK, MenuType.MAIN_MENU, getString(R.string.prospek), getResources().getDrawable(R.drawable.mn_prospek_selector)));
            menuList.add(new MenuModel(ModulType.MODUL_PROSPEK_DETAIL, MenuType.MAIN_MENU, getString(R.string.prospek_detail), getResources().getDrawable(R.drawable.mn_detail_prospek_selector)));
            menuList.add(new MenuModel(ModulType.MODUL_SURVEY, MenuType.MAIN_MENU, getString(R.string.survey), getResources().getDrawable(R.drawable.mn_survey_selector)));
            menuList.add(new MenuModel(ModulType.MODUL_COLLECTION, MenuType.MAIN_MENU, getString(R.string.collection), getResources().getDrawable(R.drawable.mn_collection_selector)));
            menuList.add(new MenuModel(ModulType.MODUL_FEEDBACK, MenuType.MAIN_MENU, getString(R.string.feedback), getResources().getDrawable(R.drawable.mn_feedback_selector)));
            menuList.add(new MenuModel(ModulType.MODUL_HISTORICAL, MenuType.MAIN_MENU, getString(R.string.historical), getResources().getDrawable(R.drawable.mn_historical_selector)));
        }
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupNavigationDrawer() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentType >= 0) {
                setupFragment(ModulType.MODUL_HOME);
                return;
            }
            super.onBackPressed();
        }
    }

    private int fragmentType = -1;
    private Fragment currentFragment;

    private void setupFragment(@ModulType int type) {
        if( AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            setupFragmentMU(type);
            return;
        }

        CommonUtil.updateLastActive();
        fragmentType = type;
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (type) {
            case ModulType.MODUL_PROSPEK:
                fragmentClass = ListProspekFragment.class;
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.prospek_perorangan));
                break;
            case ModulType.MODUL_PROSPEK_DETAIL:
                fragmentClass = ListDetailProspekFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.prospek_detail));
                }
                break;
            case ModulType.MODUL_SURVEY:
                fragmentClass = ListSurveyFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.survey));
                }
                break;
            case ModulType.MODUL_COLLECTION:
                fragmentClass = ListCollectionFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.collection));
                }
                break;
            case ModulType.MODUL_FEEDBACK:
                fragmentClass = ListFeedbackFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.feedback));
                }
                break;
            case ModulType.MODUL_HISTORICAL:
                fragmentClass = ListHistoricalFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.historical));
                }
                break;
            default:
                fragmentClass = MainFragment.class;
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.dashboard));
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            currentFragment = fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }

    }

    private void setupFragmentMU(@ModulMUType int type) {
        CommonUtil.updateLastActive();
        fragmentType = type;
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (type) {
            case ModulMUType.MODUL_MU_PROSPEK:
                fragmentClass = ListProspekFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.prospek_approval));
                }
                break;
            case ModulMUType.MODUL_MU_DETAIL_PROSPEK:
                fragmentClass = ListDetailProspekFragment.class;
                if (getSupportActionBar() != null) {
                    //getSupportActionBar().setTitle(getString(R.string.detail_prospek_approval));
                    getSupportActionBar().setTitle(getString(R.string.prospek_approval));
                }
                break;
            case ModulMUType.MODUL_MU_PENGAJUAN:
                fragmentClass = ListSurveyFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.pengajuan));
                }
                break;
            case ModulMUType.MODUL_MU_BANDING:
                fragmentClass = ListBandingFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.banding));
                }
                break;
            case ModulMUType.MODUL_MU_HISTORICAL:
                fragmentClass = ListHistoricalFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.historical));
                }
                break;
            default:
                fragmentClass = MainFragment.class;
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.dashboard));
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            currentFragment = fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //should we move action menu (Search and Filter) in MainActivity ?
        //getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //should we move action menu (Search and Filter) in MainActivity ?
        /*if (id == R.id.action_search) {

            return true;
        } else if (id == R.id.action_fitler) {

            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    private void doLogout() {
        DialogFactory.showProgress(this);
        logoutController.logout();
    }

    @Override
    public void onLogoutSuccess() {
        DialogFactory.dismissProgress();
        clearAndLogout();
    }

    @Override
    public void onLogoutFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage(), new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                clearAndLogout();
            }
        });
    }

    private void clearAndLogout() {
        AppPreference.getInstance().clearData();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        MenuModel menuModel = menuList.get(position);
        if( AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
            //User Manager Unit
            setupFragmentMU(menuModel.getId());
        } else {
            //User AOM (Default)
            setupFragment(menuModel.getId());
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prospek) {
            setupFragment(0);
        } else if (id == R.id.nav_calon_debitur) {
            setupFragment(1);
        } else if (id == R.id.nav_jadwal) {

        } else if (id == R.id.nav_daftar) {

        } else if (id == R.id.nav_history) {

        } else {
            setupFragment(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


}
