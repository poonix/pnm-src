package com.example.saifullah_albasrie.pnm.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public abstract class BaseFormActivity extends BaseActivity {

    protected int formMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setupMode();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (AppPreference.getInstance().getUserType() == UserType.ANALIS) {
            if (formMode == FormMode.VIEW) {
                getMenuInflater().inflate(R.menu.menu_edit, menu);
            } else if (formMode == FormMode.NEW || formMode == FormMode.EDIT) {
                getMenuInflater().inflate(R.menu.menu_save, menu);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_edit) {
            changeToEditMode();
            return true;
        } else if (id == R.id.action_save) {
            saveData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (formMode == FormMode.EDIT) {
            changeToViewMode();
            setupView();
        } else {
            super.onBackPressed();
        }
    }

    public void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                changeToViewMode();
                break;
            case FormMode.EDIT:
                changeToEditMode();
                break;
            case FormMode.READ_ONLY:
                changeToReadOnlyMode();
                break;
            default:
                changeToNewMode();
                break;
        }
    }

    public void changeToViewMode() {
        formMode = FormMode.VIEW;
        setEnableItems(false);
        invalidateOptionsMenu();

        //send event bus
        //MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    public void changeToEditMode() {
        formMode = FormMode.EDIT;
        setEnableItems(true);
        invalidateOptionsMenu();

        //send event bus
        //MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    public void changeToNewMode() {
        formMode = FormMode.NEW;
        setEnableItems(true);
        invalidateOptionsMenu();
    }

    public void changeToReadOnlyMode() {
        formMode = FormMode.READ_ONLY;
        setEnableItems(false);
        invalidateOptionsMenu();

        //send event bus
        //MyApplication.getEventBus().post(new FormModeStateChanged(formMode));
    }

    protected abstract void initData();

    protected abstract void loadData();

    protected abstract void setEnableItems(boolean enable);

    protected abstract void saveData();

    protected abstract void setupView();

}
