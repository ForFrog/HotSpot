package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.net.HttpMgr;
import com.chen.kevin.hotspot.net.HttpObserver;

import io.reactivex.disposables.Disposable;

public class MovieDetailActivityPresenter implements IMovieContract.MovieDetailActivityPresenter {

    private IMovieContract.MovieDetailActivityView view;

    private Disposable disposable;

    public MovieDetailActivityPresenter(IMovieContract.MovieDetailActivityView view) {
        this.view = view;
    }

    @Override
    public void loadData(String id) {
        HttpMgr.getInstance().
                getMovieDetail(id, new HttpObserver<MovieDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(MovieDetailBean bean) {
                        view.showData(bean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
