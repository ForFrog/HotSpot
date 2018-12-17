package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.net.HttpMgr;
import com.chen.kevin.hotspot.net.HttpObserver;

import io.reactivex.disposables.Disposable;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public class MoviePresenter implements IMovieContract.Presenter {
    private IMovieContract.View view;
    private HttpObserver<InTheatersMovieBean> observer;
    private Disposable disposable;

    public MoviePresenter(IMovieContract.View view) {
        this.view = view;
    }


    @Override
    public void loadData() {
        //                view.showLoadDialog();
//                view.showToast("网络异常");
//                view.dismissLoadDialog();
        observer = new HttpObserver<InTheatersMovieBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                disposable = d;
                //                view.showLoadDialog();
            }

            @Override
            public void onNext(InTheatersMovieBean data) {
                Log.d("net re", "onNext: " + data.toString());
                view.showData(data);
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
        };
        HttpMgr.getInstance()
                .getInTheatersMovie("广州", 0, 10, observer);
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

        disposable.dispose();
        Log.d("max", "onDestroy: ");
    }
}
