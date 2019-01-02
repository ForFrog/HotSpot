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

public class MovieInTheatersFragmentPresenter implements IMovieContract.MovieInTheatersFragmentPresenter {
    private IMovieContract.MovieInTheatersFragmentView view;
    private Disposable disposable;

    public MovieInTheatersFragmentPresenter(IMovieContract.MovieInTheatersFragmentView view) {
        this.view = view;
    }


    @Override
    public void loadData() {
        //                view.showLoadDialog();
        //                view.showToast("网络异常");
        //                view.dismissLoadDialog();

        HttpMgr.getInstance()
                .getInTheatersMovie("广州", 0, 20, new HttpObserver<InTheatersMovieBean>() {
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
                });
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d("max", "onDestroy: ");
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
