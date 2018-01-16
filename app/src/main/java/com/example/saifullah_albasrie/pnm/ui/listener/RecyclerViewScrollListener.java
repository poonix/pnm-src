package com.example.saifullah_albasrie.pnm.ui.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by saifullahalbasrie on 4/11/17.
 */

public abstract class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager mLinearLayoutManager;

    private boolean isLoading = false;
    //private int PAGE_SIZE = 20;

    public void setLayoutManager(LinearLayoutManager manager) {
        mLinearLayoutManager = manager;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = -1;
        int totalItemCount = -1;
        int firstVisibleItemPosition = -1;

        if (mLinearLayoutManager != null) {
            visibleItemCount = mLinearLayoutManager.getChildCount();
            totalItemCount = mLinearLayoutManager.getItemCount();
            firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
        }

        if (!isLoading && dy > 0) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    //&& totalItemCount >= PAGE_SIZE
                    && firstVisibleItemPosition >= 0 ) {
                isLoading = true;
                loadMore();
            }
        }
    }

    public abstract void loadMore();

}