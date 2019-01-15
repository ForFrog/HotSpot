package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.biz.movie.adapter.MovieInTheatersAdapter;

public class MovieInTheatersFragment extends BaseFragment implements IMovieContract.MovieInTheatersFragmentView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout layoutRefresh;


    private RecyclerView rvList;
    private MovieInTheatersAdapter adapter;
    private MovieInTheatersFragmentPresenter mPresenter;

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
    protected LifecycleObserver getObserver() {
        mPresenter = new MovieInTheatersFragmentPresenter(this);
        return mPresenter;
    }

    @Override
    protected void initView(View view) {


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

    @Override
    public void showToast(String msg) {

    }
}
