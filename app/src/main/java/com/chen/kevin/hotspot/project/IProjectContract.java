package com.chen.kevin.hotspot.project;

import com.chen.kevin.hotspot.IBasePresenter;
import com.chen.kevin.hotspot.IBaseView;
import com.chen.kevin.hotspot.bean.Project;

import java.util.List;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public interface IProjectContract {

    interface View extends IBaseView {

        void setProjectDate(List<Project> projects);

    }

    interface Presenter extends IBasePresenter {

        void getProjectDate();

    }


    interface ArticleFragmentView extends IBaseView {

        void setArticleDate();

    }

    interface ArticleFragmentPresenter extends IBasePresenter {

        void getArticleItem(int id);

        void refresh(int id);

        void loadMore();

    }

}
