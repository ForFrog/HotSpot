package com.chen.kevin.hotspot.project;

import com.chen.kevin.hotspot.bean.Project;
import com.chen.kevin.hotspot.bean.ResultBean;
import com.chen.kevin.hotspot.net.Http;
import com.chen.kevin.hotspot.net.HttpObserver;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public class ProjectPresenter implements IProjectContract.Presenter {
    private IProjectContract.View view;

    public ProjectPresenter(IProjectContract.View view) {
        this.view = view;
    }

    @Override
    public void getProjectDate() {
        Http.getInstance().getProjectData(new HttpObserver<List<Project>>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
//                view.showLoadDialog();
            }

            @Override
            public void onNext(List<Project> list) {
                view.setProjectDate(list);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
//                view.showToast("网络异常");
            }

            @Override
            public void onComplete() {
                super.onComplete();
//                view.dismissLoadDialog();
            }
        });

    }


}
