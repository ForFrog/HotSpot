package com.chen.kevin.hotspot.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;
import com.chen.kevin.hotspot.R;


/**
 * author: fangxiaogang
 * date: 2018/9/13
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    @Nullable
    protected T mPresenter;


    protected abstract int getLayoutId();

    protected abstract void initView(View view);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(getLayoutId(), container, false);
        initView(mRootView);
        return mRootView;
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
