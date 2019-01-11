package com.chen.kevin.hotspot.biz.user;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

public class UserInfoFragment extends BaseFragment implements IUserContract.UserInfoFragmentView, View.OnClickListener {
    private TextView tvUserPage;

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
        tvUserPage = (TextView) view.findViewById(R.id.tv_user_page);
        tvUserPage.setOnClickListener(this);
        presenter.loadData();
    }


    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_user_page:
                Intent intent = new Intent(getActivity(), UserPageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
