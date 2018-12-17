package com.chen.kevin.hotspot.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;


/**
 * author: fangxiaogang
 * date: 2018/9/13
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    @Nullable
    protected T mPresenter;
    private View mRootView;


    protected abstract int getLayoutId();

    protected abstract LifecycleObserver getObserver();

    protected abstract void initView(View view);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lifecycle lifecycle = getLifecycle();
        lifecycle.addObserver(getObserver());
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(mRootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
    }

    /**
     * 贴上view
     */
    private void attachView() {
    }

    /**
     * 分离view
     */
    private void detachView() {

    }
}
