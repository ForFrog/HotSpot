package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.Top250MovieBean;
import com.chen.kevin.hotspot.biz.movie.adapter.TopMovieAdapter;

public class TopMovieListFragment extends BaseFragment implements IMovieContract.TopMovieListFragmentView {
    public static final String EXTRA_INT_TYPE = "extra_int_type";
    public static final int TYPE_TOP_1_50 = 0;
    public static final int TYPE_TOP_51_100 = 1;
    public static final int TYPE_TOP_101_150 = 2;
    public static final int TYPE_TOP_151_200 = 3;
    public static final int TYPE_TOP_201_250 = 4;

    private RecyclerView rvContent;
    private TopMovieListFragmentPresenter presenter;
    private int type;
    private TopMovieAdapter adapter;

    public static TopMovieListFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_INT_TYPE, type);
        TopMovieListFragment fragment = new TopMovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_movie_list;
    }

    @Override
    protected LifecycleObserver getObserver() {
        presenter = new TopMovieListFragmentPresenter(this);
        return presenter;
    }

    @Override
    protected void initView(View view) {

        rvContent = (RecyclerView) view.findViewById(R.id.rv_content);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvContent.setLayoutManager(layoutManager);
        adapter = new TopMovieAdapter();
        rvContent.setAdapter(adapter);


        Bundle arg = getArguments();
        if (arg != null) {
            type = arg.getInt(EXTRA_INT_TYPE);

        }
    }

    @Override
    protected void onLazyLoad() {
        super.onLazyLoad();
        presenter.loadData(type);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showData(Top250MovieBean bean) {
        adapter.setData(bean.getSubjects());
    }
}
