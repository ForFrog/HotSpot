package com.chen.kevin.hotspot.main;

public class HomePresenter implements IHomeContract.Presenter {

    private IHomeContract.View view;

    public HomePresenter(IHomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getListData() {

    }
}
