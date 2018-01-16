package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyListJaminanCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyListJaminanController;
import com.example.saifullah_albasrie.pnm.model.MenuModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyListJaminanModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.MenuType;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.adapter.MenuAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by aldhiramdan on 3/21/17.
 */

public class FormSurveyListJaminanActivity extends BaseActivity implements OnItemClickListener, SurveyListJaminanCallback {

    private static final int REQUEST_CODE = 101;
    private final int ADD_BUTTON_ID = 999;

    @BindView(R.id.rv_jaminan)
    RecyclerView rvJaminan;

    private MenuAdapter mAdapter;
    private List<MenuModel> subItem;

    private int formMode = 0;
    private ProspekListItemModel mDataModel;
    private SurveyListJaminanController mController;

    //private SurveyChecklistController controller;

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyListJaminanActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInstance();
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_list_jaminan;
    }


    private void initInstance() {
        mController = new SurveyListJaminanController(this);
        subItem = new ArrayList<>();
        mAdapter = new MenuAdapter(subItem);
        mAdapter.setOnItemClickListener(this);
        setupRecylcerView();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupData();
    }

    private void setupData() {
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
            if (mDataModel != null) {
                loadData();
            }
        }

    }

    private void setupRecylcerView() {
        rvJaminan.setHasFixedSize(true);
        rvJaminan.setItemAnimator(new DefaultItemAnimator());
        rvJaminan.setAdapter(mAdapter);
        rvJaminan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        MenuModel menuModel = subItem.get(position);
        int type = menuModel.getId();
        switch (type) {
            case ADD_BUTTON_ID:
                FormSurveyJaminanActivity.navigate(this, FormMode.NEW, mDataModel, 0, REQUEST_CODE);
                break;
            default:
                FormSurveyJaminanActivity.navigate(this, formMode, mDataModel, menuModel.getId(), REQUEST_CODE);
                break;
        }
    }

    private void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            mController.getJaminanList(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    private void setupItems(List<SurveyListJaminanModel> jaminanModel) {
        subItem.clear();
        if (jaminanModel != null) {
            for (int i = 0; i < jaminanModel.size(); i++) {
                SurveyListJaminanModel item = jaminanModel.get(i);
                MenuModel model = new MenuModel(item.getId(), MenuType.JAMINAN_MENU, item.getJenisAgunan());
                subItem.add(model);
            }
        }

        if (AppPreference.getInstance().getUserType() == UserType.ANALIS && formMode != FormMode.READ_ONLY) {
            MenuModel model = new MenuModel(ADD_BUTTON_ID, MenuType.BUTTON_ADD, "Tambah Jenis Agunan");
            subItem.add(model);
        }

        mAdapter.notifyDataSetChanged();
    }

    public void addItem() {
        int count = subItem.size();
        MenuModel model = new MenuModel(count, MenuType.BUTTON_MENU, "Agunan " + count);
        model.setBackground(getResources().getDrawable(R.drawable.button_green_selector));
        if (count > 0) {
            subItem.add(count - 1, model);
        } else {
            subItem.add(model);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onDataChanged(DataStateChanged event) {
        if (event != null && event.isRefresh()) {
            loadData();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            addItem();
        }
    }

    @Override
    public void onGetSurveyListJaminanSuccess(List<SurveyListJaminanModel> listJaminanModel) {
        DialogFactory.dismissProgress();
        setupItems(listJaminanModel);
    }

    @Override
    public void onGetSurveyListJaminanFailure(Throwable t) {
        DialogFactory.dismissProgress();
        setupItems(null);
    }
}
