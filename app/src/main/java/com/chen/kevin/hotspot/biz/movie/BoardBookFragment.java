package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

/**
 * 读书榜单
 */
public class BoardBookFragment extends BaseFragment {



    public static BoardBookFragment newInstance() {
        Bundle args = new Bundle();
        BoardBookFragment fragment = new BoardBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_board_book;
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
