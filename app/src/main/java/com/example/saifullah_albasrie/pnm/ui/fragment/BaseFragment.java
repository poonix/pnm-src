package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.squareup.otto.Bus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by saifullah_albasrie on 2/21/17.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private Unbinder unbinder;
    protected final Bus bus = MyApplication.getEventBus();
    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentView(), container, false);
        unbinder = ButterKnife.bind(this, view);
        bus.register(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        bus.unregister(this);
        super.onDestroyView();
    }

    public abstract int getFragmentView();

}
