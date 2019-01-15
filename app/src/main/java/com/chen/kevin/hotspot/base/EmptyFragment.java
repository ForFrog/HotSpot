package com.chen.kevin.hotspot.base;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.view.View;

import com.chen.kevin.hotspot.R;

public class EmptyFragment extends BaseFragment {


    public static EmptyFragment newInstance() {
        Bundle args = new Bundle();
        EmptyFragment fragment = new EmptyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_empty;
    }

    @Override
    protected LifecycleObserver getObserver() {

        return null;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    public void showToast(String msg) {

    }

}
