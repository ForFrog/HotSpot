package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleOwner;
import androidx.annotation.NonNull;
import android.util.Log;

import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.net.HttpMgr;
import com.chen.kevin.hotspot.net.HttpObserver;

import io.reactivex.disposables.Disposable;

/**
 * author: fangxiaogang
 * date: 2018/9/19
 */

public class MovieComingSoonFragmentPresenter implements IMovieContract.MovieComingSoonFragmentPresenter {
    private IMovieContract.MovieComingSoonFragmentView view;
    private Disposable disposable;

    public MovieComingSoonFragmentPresenter(IMovieContract.MovieComingSoonFragmentView view) {
        this.view = view;
    }


    @Override
    public void loadData() {

        HttpMgr.getInstance()
                .getComingSoonMovie("广州", 0, 20, new HttpObserver<ComingSoonMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable = d;
                    }

                    @Override
                    public void onNext(ComingSoonMovieBean data) {
                        Log.d("net re", "onNext: " + data.toString());
                        view.showData(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        view.showToast("网络异常");
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();

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
