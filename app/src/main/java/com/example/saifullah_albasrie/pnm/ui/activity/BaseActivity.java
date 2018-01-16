package com.example.saifullah_albasrie.pnm.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.squareup.otto.Bus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */


/*
*
* 
* tetetetetet et e te te tet e
* fsdfsd
* */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    protected final Bus bus = MyApplication.getEventBus();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setDefaultToolbar();
        unbinder = ButterKnife.bind(this);
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        unbinder.unbind();
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    private void setDefaultToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void setupToolbar(Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }

    protected void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.stay,R.anim.slide_out_down);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
