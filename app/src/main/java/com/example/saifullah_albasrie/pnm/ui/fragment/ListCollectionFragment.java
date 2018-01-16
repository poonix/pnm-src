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
import com.example.saifullah_albasrie.pnm.callback.CollectionListCallback;
import com.example.saifullah_albasrie.pnm.controller.CollectionListController;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterJatuhTempoType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterRequestType;
import com.example.saifullah_albasrie.pnm.model.annotation.FilterSortType;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.ui.activity.FilterActivity;
import com.example.saifullah_albasrie.pnm.ui.activity.FormCollectionActivity;
import com.example.saifullah_albasrie.pnm.ui.adapter.CollectionItemAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.factory.SearchViewFactory;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.ui.listener.RecyclerViewScrollListener;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ListCollectionFragment extends BaseFragment implements OnItemClickListener, CollectionListCallback, AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeContainer;

    @BindView(R.id.fab_add)
    FloatingActionButton fabAdd;

    @BindView(R.id.rv_prospek)
    RecyclerView rvProspek;

    @BindView(R.id.tv_message)
    TextView tvMessage;

    private List<PnmDebiturModel> listProspek;
    private List<PnmDebiturModel> listProspekTmp;
    private CollectionItemAdapter mAdapter;

    private CollectionListController controller;

    private SearchViewFactory mSearchViewFactory;

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
            listProspek.clear();
            listProspekTmp.clear();
            mAdapter.notifyDataSetChanged();
        }
        int page = listProspek!=null?listProspek.size():0;
        /*int page = 0;
        if (listProspek != null && listProspek.size() > 0) {
            page = listProspek.size() / 10;
        }*/
        page = page + 1;
        controller.getCollectionList(page);
    }

    private RecyclerViewScrollListener mRecyclerViewOnScrollListener = new RecyclerViewScrollListener() {
        @Override
        public void loadMore() {
            //loadData(false);
        }
    };

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        mSwipeContainer.setEnabled(verticalOffset == 0);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_with_filter, menu);
        mSearchViewFactory.setupSearchMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            //already handle in searchview widget
            /*Intent intentFilter = new Intent();
            intentFilter.setClass(getContext(), SearchActivity.class);
            startActivity(intentFilter);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
            return true;*/
        } else if (id == R.id.action_fitler) {
            FilterActivity.navigate(this, FilterRequestType.FILTER_COLLECTION);
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
        listProspek = new ArrayList<>();
        mAdapter = new CollectionItemAdapter(listProspek);
        listProspekTmp = new ArrayList<>();
        mSearchViewFactory = new SearchViewFactory();
        mSearchViewFactory.setOnSearchListener(mSearchViewListener);

        controller = new CollectionListController(this);
    }


    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        Intent intent = new Intent(getContext(), FormCollectionActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, FormMode.VIEW);
        intent.putExtra(Constant.BUNDLE_DATA, listProspek.get(position));
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FilterRequestType.FILTER_COLLECTION) {
            // Make sure the request was successful
            if (resultCode == getActivity().RESULT_OK) {
                //int status = data.getIntExtra(FilterActivity.KEY_STATUS, FilterStatusType.ALL);
                //int create = data.getIntExtra(FilterActivity.KEY_CREATE, FilterCreatedType.ALL);
                int jatuhTempo = data.getIntExtra(FilterActivity.KEY_JATUHTEMPO, FilterJatuhTempoType.ALL);
                int sortBy = data.getIntExtra(FilterActivity.KEY_SORT_BY, FilterSortType.JATUH_TEMPO);
                int sortOrder = data.getIntExtra(FilterActivity.KEY_SORT_TYPE, 0);
                doFilter(jatuhTempo, sortBy, sortOrder == 0);

                /*
                StringBuffer sb = new StringBuffer();
                sb.append("FILTER -> Jatuh Tempo : ");
                switch (jatuhTempo) {
                    case FilterJatuhTempoType.ALL:
                        sb.append("ALL");
                        break;
                    case FilterJatuhTempoType.H_7:
                        sb.append("H - 7");
                        break;
                    case FilterJatuhTempoType.H_3:
                        sb.append("H - 3");
                        break;
                    case FilterJatuhTempoType.H_1:
                        sb.append("H + 1");
                        break;

                }

                Toast.makeText(getContext(), sb.toString(), Toast.LENGTH_LONG).show();
                */
            }
        }
    }

    private void doFilter(int jatuhTempo, int sortBy, boolean ascending) {
        CollectionComparator comparator = new CollectionComparator();
        comparator.setSortBy(sortBy);
        comparator.setAscending(ascending);

        switch (jatuhTempo) {
            case FilterJatuhTempoType.ALL:
                listProspek.clear();
                listProspek.addAll(listProspekTmp);
                if (listProspek.size() > 0 && sortBy != FilterSortType.NO_SORT) {
                    Collections.sort(listProspek, comparator);
                }
                mAdapter.notifyDataSetChanged();
                break;
            default:
                List<PnmDebiturModel> filtered = new ArrayList<>();
                for (PnmDebiturModel item : listProspekTmp) {
                    int dayDif = DateUtil.getDayDiff(item.getTglJatuhTempo(), "dd/MM/yyyy");
                    if (jatuhTempo == FilterJatuhTempoType.H_1 && dayDif == 1) {
                        filtered.add(item);
                    } else if (jatuhTempo == FilterJatuhTempoType.H_3 && dayDif <= 0 && dayDif >= -3) {
                        filtered.add(item);
                    } else if (jatuhTempo == FilterJatuhTempoType.H_7 && dayDif <= 0 && dayDif >= -7) {
                        filtered.add(item);
                    }
                }
                listProspek.clear();
                listProspek.addAll(filtered);
                if (listProspek.size() > 0 && sortBy != FilterSortType.NO_SORT) {
                    Collections.sort(listProspek, comparator);
                }
                mAdapter.notifyDataSetChanged();
                break;
        }

        if (listProspek.size() == 0) {
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
        listProspek.clear();
        if(TextUtils.isEmpty(query)) {
            listProspek.addAll(listProspekTmp);
            tvMessage.setVisibility(View.GONE);
        } else {
            query = query.toLowerCase();
            boolean found = false;
            for (PnmDebiturModel item : listProspekTmp) {
                if (!TextUtils.isEmpty(item.getNamaDebitur()) && item.getNamaDebitur().toLowerCase().contains(query)) {
                    listProspek.add(item);
                    found = true;
                }

                /*if (!found && item.getBiodataModel() != null && item.getBiodataModel().size() > 0) {
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
                }*/


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
    public void onGetListCollectionSuccess(List<PnmDebiturModel> listItemModels) {
        DialogFactory.dismissProgress();
        if(!isVisible()) {
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
    }

    @Override
    public void onGetListCollectionFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if(!isVisible()) {
            return;
        }

        mRecyclerViewOnScrollListener.setIsLoading(false);
        mSwipeContainer.setRefreshing(false);
        DialogFactory.showAlert(getContext(), t.getMessage());

    }

    private class CollectionComparator implements Comparator<PnmDebiturModel> {

        private int sortBy = FilterSortType.JATUH_TEMPO;
        private boolean ascending = true;

        public void setSortBy(int sortBy) {
            this.sortBy = sortBy;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }

        @Override
        public int compare(PnmDebiturModel o1, PnmDebiturModel o2) {
            if (sortBy == FilterSortType.JATUH_TEMPO) {
                long timemilis1 = DateUtil.getTimemillis(o1.getTglJatuhTempo(), "dd/MM/yyyy");
                long timemilis2 = DateUtil.getTimemillis(o2.getTglJatuhTempo(), "dd/MM/yyyy");
                if (ascending) {
                    if (timemilis1 < timemilis2)
                        return -1;
                    else if (timemilis1 > timemilis2)
                        return 1;
                    else
                        return 0;
                } else {
                    if (timemilis1 < timemilis2)
                        return 1;
                    else if (timemilis1 > timemilis2)
                        return -1;
                    else
                        return 0;
                }
            }
            else if (sortBy == FilterSortType.AGING) {
                int jmlTunggakan1 = 0;
                int jmlTunggakan2 = 0;
                try{
                    jmlTunggakan1 = Integer.parseInt(o1.getJmlTunggakanHari());
                    jmlTunggakan2 = Integer.parseInt(o2.getJmlTunggakanHari());
                }catch (Exception e) {}
                if (ascending) {
                    if (jmlTunggakan1 < jmlTunggakan2)
                        return -1;
                    else if (jmlTunggakan1 > jmlTunggakan2)
                        return 1;
                    else
                        return 0;
                } else {
                    if (jmlTunggakan1 < jmlTunggakan2)
                        return 1;
                    else if (jmlTunggakan1 > jmlTunggakan2)
                        return -1;
                    else
                        return 0;
                }
            }
            else if (sortBy == FilterSortType.OS) {
                double jmlSaldo1 = 0;
                double jmlSaldo2 = 0;
                try{
                    jmlSaldo1 = Double.parseDouble(o1.getSaldoNominatif());
                    jmlSaldo2 = Double.parseDouble(o2.getSaldoNominatif());
                }catch (Exception e) {}
                if (ascending) {
                    if (jmlSaldo1 < jmlSaldo2)
                        return -1;
                    else if (jmlSaldo1 > jmlSaldo2)
                        return 1;
                    else
                        return 0;
                } else {
                    if (jmlSaldo1 < jmlSaldo2)
                        return 1;
                    else if (jmlSaldo1 > jmlSaldo2)
                        return -1;
                    else
                        return 0;
                }
            }
            return 0;
        }
    }
}
