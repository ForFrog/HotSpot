package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.adapter.PopularReviewAdapter;

import java.util.List;

public class PopularReviewsFragment extends BaseFragment {

    private RecyclerView rvContent;
    private PopularReviewAdapter adapter;

    public static PopularReviewsFragment newInstance() {
        Bundle args = new Bundle();
        PopularReviewsFragment fragment = new PopularReviewsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_movie_detail_popular_reviews;
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
    }

    @Override
    protected void initView(View view) {
        rvContent = (RecyclerView) view.findViewById(R.id.rv_content);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new PopularReviewAdapter();
        rvContent.setAdapter(adapter);
    }

    public void intData( List<MovieDetailBean.PopularReviewsBean> popularReviews) {
        adapter.setData(popularReviews);
    }

    @Override
    public void showToast(String msg) {

    }


}
