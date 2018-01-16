package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.ListSurveyCallback;
import com.example.saifullah_albasrie.pnm.controller.ListSurveyController;
import com.example.saifullah_albasrie.pnm.model.ProspekBiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterRequestType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterStatusType;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.StatusType;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.ui.activity.FilterActivity;
import com.example.saifullah_albasrie.pnm.ui.activity.SurveyItemActivity;
import com.example.saifullah_albasrie.pnm.ui.adapter.ProspekItemAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.factory.SearchViewFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.ui.listener.RecyclerViewScrollListener;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ListSurveyFragment extends BaseFragment implements OnItemClickListener, ListSurveyCallback, AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeContainer;

    @BindView(R.id.rv_prospek)
    RecyclerView rvProspek;
    @BindView(R.id.fab_add)
    FloatingActionButton fabAdd;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    private List<ProspekListItemModel> listProspek;
    private List<ProspekListItemModel> listProspekTmp;
    private ProspekItemAdapter mAdapter;

    private SearchViewFactory mSearchViewFactory;

    private ListSurveyController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initData();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        loadData(true);
    }

    @Override
    public void onDestroy() {
        if (controller != null) {
            controller.cancel();
        }
        super.onDestroy();
    }

    private void loadData(boolean clearData) {
        if (mSwipeContainer != null) {
            mSwipeContainer.setRefreshing(true);
        } else {
            DialogFactory.showProgress(getContext());
        }

        if (clearData) {
            isFilterMode = false;
            listProspek.clear();
            listProspekTmp.clear();
            mAdapter.notifyDataSetChanged();
        }
        //int page = listProspek != null ? listProspek.size() : 0;
        int page = 0;
        if (listProspek != null && listProspek.size() > 0) {
            page = listProspek.size() / ApiConstant.PAGE_LIMIT_SIZE;
        }
        controller.getSurveyList(page);
    }

    private RecyclerViewScrollListener mRecyclerViewOnScrollListener = new RecyclerViewScrollListener() {
        @Override
        public void loadMore() {
            if (!isFilterMode) {
                loadData(false);
            }
        }
    };

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        mSwipeContainer.setEnabled(verticalOffset == 0);
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_with_filter, menu);
        mSearchViewFactory.setupSearchMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            //already handle in searchview widget
        } else if (id == R.id.action_fitler) {
            FilterActivity.navigate(this, FilterRequestType.FILTER_SURVEY);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvProspek.setHasFixedSize(true);
        rvProspek.setItemAnimator(new DefaultItemAnimator());
        rvProspek.setAdapter(mAdapter);
        rvProspek.setLayoutManager(mLayoutManager);
        rvProspek.addOnScrollListener(mRecyclerViewOnScrollListener);
        mRecyclerViewOnScrollListener.setLayoutManager(mLayoutManager);

        mAdapter.setOnItemClickListener(this);
        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(true);
            }
        });


        fabAdd.setVisibility(View.GONE);
    }

    private void initData() {
        listProspek = new ArrayList<>();
        mAdapter = new ProspekItemAdapter(listProspek);
        listProspekTmp = new ArrayList<>();
        mSearchViewFactory = new SearchViewFactory();
        mSearchViewFactory.setOnSearchListener(mSearchViewListener);

        controller = new ListSurveyController(this);
    }


    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        Intent intent = new Intent(getContext(), SurveyItemActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
        intent.putExtra(Constant.BUNDLE_DATA, listProspek.get(position));
        startActivity(intent);
    }

    @Subscribe
    public void onDataChanged(DataStateChanged event) {
        if (event != null && event.isRefresh()) {
            loadData(true);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FilterRequestType.FILTER_SURVEY && resultCode == getActivity().RESULT_OK) {
            // Make sure the request was successful
            int status = data.getIntExtra(FilterActivity.KEY_STATUS, FilterStatusType.ALL);
            //int create = data.getIntExtra(FilterActivity.KEY_CREATE, FilterCreatedType.ALL);

            //StringBuffer sb = new StringBuffer();
            //sb.append("Survey Status : ");
            switch (status) {
                case FilterStatusType.ALL:
                    //sb.append("ALL");
                    doFilter(-1);
                    break;
                case FilterStatusType.SURVEY:
                    //sb.append("Survey");
                    doFilter(StatusType.SURVEY);
                    break;
                case FilterStatusType.REVISI:
                    //sb.append("Revisi");
                    doFilter(StatusType.SURVEY_REVISI);
                    break;
            }

            //Toast.makeText(getContext(), sb.toString(), Toast.LENGTH_LONG).show();

        }
    }

    private boolean isFilterMode = false;
    private void doFilter(int debiturType) {
        if (debiturType == -1) {
            isFilterMode = false;
            listProspek.clear();
            listProspek.addAll(listProspekTmp);
            mAdapter.notifyDataSetChanged();
        } else {
            isFilterMode = true;
            List<ProspekListItemModel> filtered = new ArrayList<>();
            for (ProspekListItemModel item : listProspekTmp) {
                if (debiturType == item.getStatusDebitur()) {
                    filtered.add(item);
                }
            }
            listProspek.clear();
            listProspek.addAll(filtered);
            mAdapter.notifyDataSetChanged();

            if (listProspek.size() == 0) {
                tvMessage.setText(getString(R.string.data_not_found));
                tvMessage.setVisibility(View.VISIBLE);
            } else {
                tvMessage.setVisibility(View.GONE);
            }
        }
    }

    private SearchViewFactory.OnSearchListener mSearchViewListener = new SearchViewFactory.OnSearchListener() {
        @Override
        public void onSearchStarted(String query) {
            doSearch(query);
        }

        @Override
        public void onSearchStopped() {
            tvMessage.setVisibility(View.GONE);
        }
    };

    public void doSearch(String query) {
        listProspek.clear();
        if (TextUtils.isEmpty(query)) {
            listProspek.addAll(listProspekTmp);
            tvMessage.setVisibility(View.GONE);
        } else {
            query = query.toLowerCase();
            boolean found = false;
            for (ProspekListItemModel item : listProspekTmp) {
                if (!TextUtils.isEmpty(item.getNamaPanggilan()) && item.getNamaPanggilan().toLowerCase().contains(query)) {
                    listProspek.add(item);
                    found = true;
                }

                if (!found && item.getBiodataModel() != null && item.getBiodataModel().size() > 0) {
                    ProspekBiodataModel biodataModel = item.getBiodataModel().get(0);
                    if (biodataModel != null) {
                        if (!TextUtils.isEmpty(biodataModel.getNamaPanggilan()) && biodataModel.getNamaPanggilan().toLowerCase().contains(query)) {
                            listProspek.add(item);
                            found = true;
                        } else if (!TextUtils.isEmpty(biodataModel.getNamaLengkap()) && biodataModel.getNamaLengkap().toLowerCase().contains(query)) {
                            listProspek.add(item);
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                tvMessage.setText(getString(R.string.search_not_found));
                tvMessage.setVisibility(View.VISIBLE);
            } else {
                tvMessage.setVisibility(View.GONE);
            }
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetListSurveySuccess(List<ProspekListItemModel> listItemModels) {
        DialogFactory.dismissProgress();
        if (!isVisible()) {
            return;
        }

        if (listItemModels != null && listItemModels.size() > 0) {
            listProspek.addAll(listItemModels);
            listProspekTmp.addAll(listProspek);
        }
        mRecyclerViewOnScrollListener.setIsLoading(false);
        mSwipeContainer.setRefreshing(false);
        mAdapter.notifyDataSetChanged();

        if (listProspek.size() == 0) {
            tvMessage.setText(getString(R.string.data_not_found));
            tvMessage.setVisibility(View.VISIBLE);
        } else {
            tvMessage.setVisibility(View.GONE);
        }

        if (listItemModels != null && listItemModels.size() > 0) {
            //auto load more data
            //loadData(false);
        }
    }

    @Override
    public void onGetListSurveyFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isVisible()) {
            return;
        }

        mRecyclerViewOnScrollListener.setIsLoading(false);
        mSwipeContainer.setRefreshing(false);
        DialogFactory.showAlert(getContext(), t.getMessage());
    }
}
