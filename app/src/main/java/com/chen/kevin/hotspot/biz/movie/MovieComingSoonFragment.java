package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.biz.movie.adapter.MovieComingSoonAdapter;

public class MovieComingSoonFragment extends BaseFragment implements IMovieContract.MovieComingSoonFragmentView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout layoutRefresh;


    private RecyclerView rvList;
    private MovieComingSoonAdapter adapter;
    private MovieComingSoonFragmentPresenter mPresenter;

    public static MovieComingSoonFragment newInstance() {
        Bundle args = new Bundle();
        MovieComingSoonFragment fragment = new MovieComingSoonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_in_theaters;
    }

    @Override
    protected LifecycleObserver getObserver() {
        mPresenter = new MovieComingSoonFragmentPresenter(this);
        return mPresenter;
    }

    @Override
    protected void initView(View view) {


        layoutRefresh = (SwipeRefreshLayout) view.findViewById(R.id.layout_refresh);
        layoutRefresh.setOnRefreshListener(this);


        rvList = (RecyclerView) view.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutManager);
        adapter = new MovieComingSoonAdapter();
        rvList.setAdapter(adapter);

        mPresenter.loadData();
        layoutRefresh.setRefreshing(true);

    }


    @Override
    public void onRefresh() {
        mPresenter.loadData();
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showData(ComingSoonMovieBean bean) {
        adapter.setData(bean.getSubjects());

        if (layoutRefresh.isRefreshing()) {
            layoutRefresh.setRefreshing(false);
        }
    }
}
