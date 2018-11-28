package com.chen.kevin.hotspot.biz.movie;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.biz.movie.adapter.MovieInTheatersAdapter;

public class MovieInTheatersFragment extends BaseFragment<MoviePresenter> implements IMovieContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout layoutRefresh;


    private RecyclerView rvList;
    private MovieInTheatersAdapter adapter;


    public static MovieInTheatersFragment newInstance() {
        Bundle args = new Bundle();
        MovieInTheatersFragment fragment = new MovieInTheatersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_in_theaters;
    }

    @Override
    protected void initView(View view) {
        mPresenter = new MoviePresenter(this);

        layoutRefresh = (SwipeRefreshLayout) view.findViewById(R.id.layout_refresh);
        layoutRefresh.setOnRefreshListener(this);


        rvList = (RecyclerView) view.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutManager);
        adapter = new MovieInTheatersAdapter();
        rvList.setAdapter(adapter);

        mPresenter.loadData();
        layoutRefresh.setRefreshing(true);

    }


    @Override
    public void showData(InTheatersMovieBean bean) {
        adapter.setData(bean.getSubjects());

        if (layoutRefresh.isRefreshing()) {
            layoutRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.loadData();
    }
}
