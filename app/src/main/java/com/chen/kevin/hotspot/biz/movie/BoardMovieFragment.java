package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

/**
 * 电影榜单
 */
public class BoardMovieFragment extends BaseFragment {


    public static BoardMovieFragment newInstance() {
        Bundle args = new Bundle();
        BoardMovieFragment fragment = new BoardMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_board_movie;
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
