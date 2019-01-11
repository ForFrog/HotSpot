package com.chen.kevin.hotspot.base;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.IBaseView;


/**
 * author: fangxiaogang
 * date: 2018/9/13
 */

public abstract class BaseFragment extends Fragment implements IBaseView {

    private View mRootView;

    private boolean isPrepared;
    private boolean alreadLoad;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifecycleObserver observer = getObserver();
        if (observer != null) {
            getLifecycle().addObserver(observer);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView(mRootView);


        lazyLoad();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared=true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void lazyLoad() {
        if (getUserVisibleHint() && isPrepared && !alreadLoad) {
            onLazyLoad();
            alreadLoad = true;
        }

    }

    /**
     * 懒加载
     */
    protected void onLazyLoad() {
    }

    protected abstract int getLayoutId();

    protected abstract LifecycleObserver getObserver();

    protected abstract void initView(View view);

}
