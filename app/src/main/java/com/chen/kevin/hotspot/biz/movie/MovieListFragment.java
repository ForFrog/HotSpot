package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

public class MovieListFragment extends BaseFragment {

    private TabLayout tlType;
    private ViewPager vpContent;


    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
    }

    @Override
    protected void initView(View view) {
        tlType = (TabLayout) view.findViewById(R.id.tl_type);
        tlType.addTab(tlType.newTab().setText("Tab 1"));
        tlType.addTab(tlType.newTab().setText("Tab 2"));


        vpContent = (ViewPager) view.findViewById(R.id.vp_content);

        tlType.setupWithViewPager(vpContent);
    }

    @Override
    public void showToast(String msg) {

    }
}
