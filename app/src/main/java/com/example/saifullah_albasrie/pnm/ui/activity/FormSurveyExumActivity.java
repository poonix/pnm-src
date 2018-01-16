package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.saifullah_albasrie.pnm.R;

/**
 * Created by aldhiramdan on 3/26/17.
 */

public class FormSurveyExumActivity extends BaseActivity {

    public static void navigate(Activity activity) {
        Intent intent = new Intent(activity, FormSurveyExumActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_exum;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_edit) {
            Toast.makeText(getBaseContext(), "Action Edit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
