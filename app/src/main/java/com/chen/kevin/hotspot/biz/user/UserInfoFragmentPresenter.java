package com.chen.kevin.hotspot.biz.user;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

public class UserInfoFragmentPresenter implements IUserContract.UserInfoFragmentPresenter {
    private IUserContract.UserInfoFragmentView view;

    public UserInfoFragmentPresenter(IUserContract.UserInfoFragmentView view) {
        this.view = view;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }
}
