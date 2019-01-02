package com.chen.kevin.hotspot.biz.movie;

import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.bean.Top250MovieBean;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public interface IMovieContract {

    interface MovieInTheatersFragmentView extends IBaseView {
        void showData(InTheatersMovieBean bean);

    }

    interface MovieInTheatersFragmentPresenter extends IBasePresenter {
        void loadData();
    }


    interface MovieDetailActivityView extends IBaseView {
        void showData(MovieDetailBean bean);

    }

    interface MovieDetailActivityPresenter extends IBasePresenter {
        void loadData(String id);
    }

    interface TopMovieListFragmentView extends IBaseView {
        void showData(Top250MovieBean bean);

    }

    interface TopMovieListFragmentPresenter extends IBasePresenter {
        void loadData(int type);
    }


}
