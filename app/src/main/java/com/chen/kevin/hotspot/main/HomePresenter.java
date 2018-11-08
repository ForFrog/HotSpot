package com.chen.kevin.hotspot.main;

import com.chen.kevin.hotspot.net.Http;
import com.chen.kevin.hotspot.net.HttpObserver;
import com.chen.kevin.hotspot.bean.ResultBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class HomePresenter implements IHomeContract.Presenter {

    private IHomeContract.View view;

    public HomePresenter(IHomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getListData() {
        Http.getInstance().getTopMovie(10, 1, new HttpObserver<List<ResultBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                view.showLoadDialog();
            }

            @Override
            public void onNext(List<ResultBean> list) {
                view.showToast("请求成功");
                view.setList(list);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                view.showToast("网络异常");
            }

            @Override
            public void onComplete() {
                super.onComplete();
                view.dismissLoadDialog();
            }
        });
    }
}
