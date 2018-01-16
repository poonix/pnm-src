package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterCreatedType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterJatuhTempoType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterRequestType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterSortType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterStatusType;
import com.example.saifullah_albasrie.pnm.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FilterActivity extends AppCompatActivity {

    private static final String BUNDLE_TYPE = "FILTER_TYPE";

    public static String KEY_STATUS = "KEY_STATUS_SURVEY";
    public static String KEY_CREATE = "KEY_CREATED_DATE";
    public static String KEY_JATUHTEMPO = "KEY_JATUH_TEMPO";
    public static String KEY_SORT_BY = "KEY_SORT_BY";
    public static String KEY_SORT_TYPE = "KEY_SORT_TYPE";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.layout_filter_status_survey)
    View vLayoutFilterByStatus;
    @BindView(R.id.layout_filter_by_date)
    View vLayoutFilterByDate;
    @BindView(R.id.layout_filter_jatuh_dempo)
    View vLayoutFilterByJatuhTempo;

    @BindViews({R.id.status_all, R.id.status_survey, R.id.status_revisi})
    List<TextView> viewStatus;

    @BindViews({R.id.created_in_any, R.id.created_in_today, R.id.created_in_7, R.id.created_in_30})
    List<TextView> viewCreated;

    @BindViews({R.id.jatuh_tempo_all, R.id.jatuh_tempo_h7, R.id.jatuh_tempo_h3, R.id.jatuh_tempo_h1})
    List<TextView> viewJatuhTempo;

    @BindViews({R.id.sort_default, R.id.sort_aging, R.id.sort_os})
    List<TextView> viewSortby;

    @BindView(R.id.rbAscending)
    RadioButton rbAscending;

    TextView currStatus, currCreated, currJatuhTempo, curSortBy;

    int resultStatus, resultCreate, resultJatuhTempo, resultSortBy, sortOrder;

    private Unbinder unbinder;

    /*
    public static void navigate(Activity activity, @FilterRequestType int requestType) {
        Intent intentFilter = new Intent(activity, FilterActivity.class);
        intentFilter.putExtra(BUNDLE_TYPE, requestType);
        activity.startActivityForResult(intentFilter, requestType);
        activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }*/

    public static void navigate(Fragment fragment, @FilterRequestType int requestType) {
        Intent intentFilter = new Intent(fragment.getContext(), FilterActivity.class);
        intentFilter.putExtra(BUNDLE_TYPE, requestType);
        fragment.startActivityForResult(intentFilter, requestType);
        fragment.getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_clear);
        getSupportActionBar().setTitle("");

        currStatus = viewStatus.get(0);
        currCreated = viewCreated.get(0);
        currJatuhTempo = viewJatuhTempo.get(0);
        curSortBy = viewSortby.get(0);
        resultSortBy = FilterSortType.JATUH_TEMPO;

        setupFilterType();
    }

    private void setupFilterType() {
        int filterType = 0;
        if (getIntent() != null) {
            filterType = getIntent().getIntExtra(BUNDLE_TYPE, 0);
        }

        switch (filterType) {
            case FilterRequestType.FILTER_PROSPEK :
                vLayoutFilterByStatus.setVisibility(View.GONE);
                vLayoutFilterByDate.setVisibility(View.VISIBLE);
                vLayoutFilterByJatuhTempo.setVisibility(View.GONE);
                break;
            case FilterRequestType.FILTER_SURVEY :
                vLayoutFilterByStatus.setVisibility(View.VISIBLE);
                vLayoutFilterByDate.setVisibility(View.GONE);
                vLayoutFilterByJatuhTempo.setVisibility(View.GONE);
                break;
            case FilterRequestType.FILTER_COLLECTION :
                vLayoutFilterByStatus.setVisibility(View.GONE);
                vLayoutFilterByDate.setVisibility(View.GONE);
                vLayoutFilterByJatuhTempo.setVisibility(View.VISIBLE);
                break;
            case FilterRequestType.FILTER_FEEDBACK :
                vLayoutFilterByStatus.setVisibility(View.GONE);
                vLayoutFilterByDate.setVisibility(View.VISIBLE);
                vLayoutFilterByJatuhTempo.setVisibility(View.GONE);
                break;
            default:
                vLayoutFilterByStatus.setVisibility(View.GONE);
                vLayoutFilterByDate.setVisibility(View.VISIBLE);
                vLayoutFilterByJatuhTempo.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_done) {
            Intent data = new Intent();
            data.putExtra(KEY_STATUS, resultStatus);
            data.putExtra(KEY_CREATE, resultCreate);
            data.putExtra(KEY_JATUHTEMPO, resultJatuhTempo);
            data.putExtra(KEY_SORT_BY, resultSortBy);
            sortOrder = rbAscending.isChecked() ? 0 : 1;
            data.putExtra(KEY_SORT_TYPE, sortOrder);
            setResult(RESULT_OK, data);
            onBackPressed();
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_out_down);
    }

    public void statusSelected(View view) {
        if (currStatus != null) {
            currStatus.setBackgroundResource(R.drawable.plan_filter);
        }
        view.setBackgroundResource(R.drawable.selected_filter);
        currStatus = (TextView) view;

        int id = view.getId();
        switch (id) {
            case R.id.status_all:
                resultStatus = FilterStatusType.ALL;
                break;
            case R.id.status_survey:
                resultStatus = FilterStatusType.SURVEY;
                break;
            case R.id.status_revisi:
                resultStatus = FilterStatusType.REVISI;
                break;
        }
    }

    public void createdSelected(View view) {
        if (currCreated != null) {
            currCreated.setBackgroundResource(R.drawable.plan_filter);
        }
        view.setBackgroundResource(R.drawable.selected_filter);
        currCreated = (TextView) view;

        int id = view.getId();
        switch (id) {
            case R.id.created_in_any:
                resultCreate = FilterCreatedType.ALL;
                break;
            case R.id.created_in_today:
                resultCreate = FilterCreatedType.TODAY;
                break;
            case R.id.created_in_7:
                resultCreate = FilterCreatedType.DAY_7;
                break;
            case R.id.created_in_30:
                resultCreate = FilterCreatedType.DAY_30;
                break;

        }
    }

    public void jatuhTempoSelected(View view) {
        if (currJatuhTempo != null) {
            currJatuhTempo.setBackgroundResource(R.drawable.plan_filter);
        }
        view.setBackgroundResource(R.drawable.selected_filter);
        currJatuhTempo = (TextView) view;

        int id = view.getId();
        switch (id) {
            case R.id.jatuh_tempo_all:
                resultJatuhTempo = FilterJatuhTempoType.ALL;
                break;
            case R.id.jatuh_tempo_h7:
                resultJatuhTempo = FilterJatuhTempoType.H_7;
                break;
            case R.id.jatuh_tempo_h3:
                resultJatuhTempo = FilterJatuhTempoType.H_3;
                break;
            case R.id.jatuh_tempo_h1:
                resultJatuhTempo = FilterJatuhTempoType.H_1;
                break;
        }
    }

    public void sortBySelected(View view) {
        if (curSortBy != null) {
            curSortBy.setBackgroundResource(R.drawable.plan_filter);
        }
        view.setBackgroundResource(R.drawable.selected_filter);
        curSortBy = (TextView) view;

        int id = view.getId();
        switch (id) {
            case R.id.sort_default:
                resultSortBy = FilterSortType.JATUH_TEMPO;
                break;
            case R.id.sort_aging:
                resultSortBy = FilterSortType.AGING;
                break;
            case R.id.sort_os:
                resultSortBy = FilterSortType.OS;
                break;

        }
    }

    /*
    public void showMore(View view){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widht = metrics.widthPixels - 40;
        int height = (metrics.heightPixels >> 2) +20 ;

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_more, null);

        TextView cancel =(TextView)layout.findViewById(R.id.status_canceled);
        TextView denied =(TextView)layout.findViewById(R.id.status_denied);

        if(resultStatus == FilterStatusType.DENIED){
            denied.setTextColor(ContextCompat.getColor(this,R.color.black_text));
            cancel.setTextColor(ContextCompat.getColor(this,R.color.grey_light_more));
        }else if(resultStatus == FilterStatusType.CANCELED){
            cancel.setTextColor(ContextCompat.getColor(this,R.color.black_text));
            denied.setTextColor(ContextCompat.getColor(this,R.color.grey_light_more));
        }

        overLayout.setVisibility(View.VISIBLE);

        // Creating the PopupWindow
        popup = new PopupWindow(this);
        popup.setContentView(layout);
        popup.setWidth(widht);
        popup.setHeight(height);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        popup.showAtLocation(statusLayout, Gravity.CENTER,0,3);
        popup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                overLayout.setVisibility(View.GONE);
            }
        });
    }*/
}
