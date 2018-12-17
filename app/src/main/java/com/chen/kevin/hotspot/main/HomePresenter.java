package com.chen.kevin.hotspot.main;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

public class HomePresenter implements IHomeContract.Presenter {

    private IHomeContract.View view;

    public HomePresenter(IHomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getListData() {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }
}
