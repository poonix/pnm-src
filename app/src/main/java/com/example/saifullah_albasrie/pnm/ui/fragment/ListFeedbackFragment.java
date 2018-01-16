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
import com.example.saifullah_albasrie.pnm.callback.FeedbackListCallback;
import com.example.saifullah_albasrie.pnm.controller.FeedbackListController;
import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterCreatedType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterRequestType;
import com.example.saifullah_albasrie.pnm.rest.ApiConstant;
import com.example.saifullah_albasrie.pnm.ui.activity.FeedbackDetailActivity;
import com.example.saifullah_albasrie.pnm.ui.activity.FilterActivity;
import com.example.saifullah_albasrie.pnm.ui.adapter.FeedbackItemAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.factory.SearchViewFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.ui.listener.RecyclerViewScrollListener;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ListFeedbackFragment extends BaseFragment implements OnItemClickListener, FeedbackListCallback, AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeContainer;

    @BindView(R.id.rv_prospek)
    RecyclerView rvProspek;
    @BindView(R.id.fab_add)
    FloatingActionButton fabAdd;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    private List<FeedbackItemModel> listFeedback;
    private List<FeedbackItemModel> listFeedbackCopy;
    private FeedbackItemAdapter mAdapter;

    private SearchViewFactory mSearchViewFactory;

    private FeedbackListController controller;

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
        if(controller!=null) {
            controller.cancel();
        }
        super.onDestroy();
    }

    private void loadData(boolean clearData) {
        if(mSwipeContainer != null) {
            mSwipeContainer.setRefreshing(true);
        } else {
            DialogFactory.showProgress(getContext());
        }

        if (clearData) {
            isFilterMode = false;
            listFeedback.clear();
            listFeedbackCopy.clear();
            mAdapter.notifyDataSetChanged();
        }
        //int page = listFeedback !=null? listFeedback.size():0;
        int page = 0;
        if (listFeedback != null && listFeedback.size() > 0) {
            page = listFeedback.size() / ApiConstant.PAGE_LIMIT_SIZE;
        }
        controller.getFeedbackList(page);

        /*//DUMMY
        listFeedback.clear();
        listFeedback.add(new FeedbackItemModel());
        listFeedback.add(new FeedbackItemModel());
        listFeedback.add(new FeedbackItemModel());
        listFeedbackCopy.clear();
        listFeedbackCopy.addAll(listFeedback);
        DialogFactory.dismissProgress();
        mSwipeContainer.setRefreshing(false);
        */
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
        inflater.inflate(R.menu.fragment_without_filter, menu);
        mSearchViewFactory.setupSearchMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            //already handle in searchview widget
        } else if (id == R.id.action_fitler) {
            FilterActivity.navigate(this, FilterRequestType.FILTER_OTHERS);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        LinearLayoutManager  mLayoutManager = new LinearLayoutManager(getContext());
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
        controller = new FeedbackListController(this);
        listFeedback = new ArrayList<>();
        mAdapter = new FeedbackItemAdapter(listFeedback);
        listFeedbackCopy = new ArrayList<>();
        mSearchViewFactory = new SearchViewFactory();
        mSearchViewFactory.setOnSearchListener(mSearchViewListener);
    }


    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        FeedbackDetailActivity.navigate(getActivity(), listFeedback.get(position));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FilterRequestType.FILTER_OTHERS) {
            // Make sure the request was successful
            if (resultCode == getActivity().RESULT_OK) {
                //int status = data.getIntExtra(FilterActivity.KEY_STATUS, FilterStatusType.ALL);
                int create = data.getIntExtra(FilterActivity.KEY_CREATE, FilterCreatedType.ALL);
                doFilter(create);

                /*
                StringBuffer sb = new StringBuffer();
                sb.append("CREATED IN LAST : ");
                switch (create) {
                    case FilterCreatedType.ALL:
                        sb.append("ALL");
                        break;
                    case FilterCreatedType.TODAY:
                        sb.append("TODAY");
                        break;
                    case FilterCreatedType.DAY_7:
                        sb.append("7 DAYS");
                        break;
                    case FilterCreatedType.DAY_30:
                        sb.append("30 DAYS");
                        break;
                }

                Toast.makeText(getContext(), sb.toString(), Toast.LENGTH_LONG).show();
                */
            }
        }
    }

    private boolean isFilterMode = false;

    private void doFilter(int createdDateType) {
        switch (createdDateType) {
            case FilterCreatedType.ALL:
                isFilterMode = false;
                listFeedback.clear();
                listFeedback.addAll(listFeedbackCopy);
                mAdapter.notifyDataSetChanged();
                break;
            default:
                isFilterMode = true;
                List<FeedbackItemModel> filtered = new ArrayList<>();
                for (FeedbackItemModel item : listFeedbackCopy) {
                    int dayDif = DateUtil.getDayDiff(item.getCreatedDate());
                    if (!TextUtils.isEmpty(item.getModifiedDate())) {
                        dayDif = DateUtil.getDayDiff(item.getModifiedDate());
                    }
                    if (createdDateType == FilterCreatedType.TODAY && dayDif == 0) {
                        filtered.add(item);
                    } else if (createdDateType == FilterCreatedType.DAY_7 && dayDif >= 0 && dayDif <= 7) {
                        filtered.add(item);
                    } else if (createdDateType == FilterCreatedType.DAY_30 && dayDif >= 0 && dayDif <= 30) {
                        filtered.add(item);
                    }
                }
                listFeedback.clear();
                listFeedback.addAll(filtered);
                mAdapter.notifyDataSetChanged();
                break;
        }

        if (listFeedback.size() == 0) {
            tvMessage.setText(getString(R.string.data_not_found));
            tvMessage.setVisibility(View.VISIBLE);
        } else {
            tvMessage.setVisibility(View.GONE);
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
        listFeedback.clear();
        if(TextUtils.isEmpty(query)) {
            listFeedback.addAll(listFeedbackCopy);
            tvMessage.setVisibility(View.GONE);
        } else {
            query = query.toLowerCase();
            boolean found = false;
            for (FeedbackItemModel item : listFeedbackCopy) {
                if (!TextUtils.isEmpty(item.getNamaPanggilan()) && item.getNamaPanggilan().toLowerCase().contains(query)) {
                    listFeedback.add(item);
                    found = true;
                }
            }
            if (!found) {
                tvMessage.setText(getString(R.string.feedback_not_found));
                tvMessage.setVisibility(View.VISIBLE);
            } else {
                tvMessage.setVisibility(View.GONE);
            }
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetListFeedbackSuccess(List<FeedbackItemModel> listItemModels) {
        DialogFactory.dismissProgress();
        if(!isVisible()) {
            return;
        }

        if (listItemModels != null && listItemModels.size() > 0) {
            listFeedback.addAll(listItemModels);
            listFeedbackCopy.addAll(listFeedback);
        }

        mRecyclerViewOnScrollListener.setIsLoading(false);
        mSwipeContainer.setRefreshing(false);
        mAdapter.notifyDataSetChanged();

        if (listFeedback.size() == 0) {
            tvMessage.setText(getString(R.string.data_not_found));
            tvMessage.setVisibility(View.VISIBLE);
        } else {
            tvMessage.setVisibility(View.GONE);
        }
    }

    @Override
    public void onGetListFeedbackFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if(!isVisible()) {
            return;
        }

        mRecyclerViewOnScrollListener.setIsLoading(false);
        mSwipeContainer.setRefreshing(false);
        DialogFactory.showAlert(getContext(), t.getMessage());
    }
}
