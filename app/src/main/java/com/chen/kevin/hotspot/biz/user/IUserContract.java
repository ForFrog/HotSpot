package com.chen.kevin.hotspot.biz.user;

import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public interface IUserContract {

    interface UserInfoFragmentView extends IBaseView {

        void showData();

    }

    interface UserInfoFragmentPresenter extends IBasePresenter {

        void loadData();

    }


}
