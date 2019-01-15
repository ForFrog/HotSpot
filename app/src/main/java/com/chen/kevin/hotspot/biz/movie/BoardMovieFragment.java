package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.biz.movie.adapter.TopMovieBoardAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.YearMovieBoardAdapter;

/**
 * 电影榜单
 */
public class BoardMovieFragment extends BaseFragment {
    private RecyclerView rvTopMovie;
    private RecyclerView rvYearMovie;


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
        rvTopMovie = (RecyclerView) view.findViewById(R.id.rv_top_movie);
        initTopMovie();

        rvYearMovie = (RecyclerView) view.findViewById(R.id.rv_year_movie);
        initYearMovie();

    }

    private void initTopMovie() {
        TopMovieBoardAdapter adapter = new TopMovieBoardAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvTopMovie.setLayoutManager(layoutManager);
        rvTopMovie.setAdapter(adapter);
    }


    private void initYearMovie() {
        YearMovieBoardAdapter adapter = new YearMovieBoardAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvYearMovie.setLayoutManager(layoutManager);
        rvYearMovie.setAdapter(adapter);
    }

    @Override
    public void showToast(String msg) {

    }
}
