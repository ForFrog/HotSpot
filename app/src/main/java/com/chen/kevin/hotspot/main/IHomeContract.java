package com.chen.kevin.hotspot.main;


import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;

import java.util.List;

public interface IHomeContract {

    interface View extends IBaseView {

        void setList();

        void showLoadDialog();

        void dismissLoadDialog();

        void showToast(String msg);
    }

    interface Presenter extends IBasePresenter {

        void getListData();

    }


}
