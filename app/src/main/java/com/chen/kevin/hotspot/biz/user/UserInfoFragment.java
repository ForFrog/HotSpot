package com.chen.kevin.hotspot.biz.user;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

public class UserInfoFragment extends BaseFragment implements IUserContract.UserInfoFragmentView {


    private UserInfoFragmentPresenter presenter;

    public static UserInfoFragment newInstance() {
        Bundle args = new Bundle();
        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_info;
    }

    @Override
    protected LifecycleObserver getObserver() {
        presenter = new UserInfoFragmentPresenter(this);
        return presenter;
    }

    @Override
    protected void initView(View view) {


        presenter.loadData();


    }



    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showData() {

    }
}
