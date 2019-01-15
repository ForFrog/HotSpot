package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleOwner;
import androidx.annotation.NonNull;
import android.util.Log;

import com.chen.kevin.hotspot.bean.Top250MovieBean;
import com.chen.kevin.hotspot.net.HttpMgr;
import com.chen.kevin.hotspot.net.HttpObserver;

import io.reactivex.disposables.Disposable;

public class TopMovieListFragmentPresenter implements IMovieContract.TopMovieListFragmentPresenter {

    private IMovieContract.TopMovieListFragmentView view;
    private Disposable disposable;

    public TopMovieListFragmentPresenter(IMovieContract.TopMovieListFragmentView view) {
        this.view = view;
    }


    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d("max", "onDestroy: ");
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void loadData(int type) {
        int start;
        switch (type) {
            case TopMovieListFragment.TYPE_TOP_1_50:
                start = 0;
                break;

            case TopMovieListFragment.TYPE_TOP_51_100:
                start = 50;
                break;
            case TopMovieListFragment.TYPE_TOP_101_150:
                start = 100;
                break;

            case TopMovieListFragment.TYPE_TOP_151_200:
                start = 150;
                break;

            case TopMovieListFragment.TYPE_TOP_201_250:
                start = 200;
                break;
            default:
                start = 0;
                break;

        }


        HttpMgr.getInstance()
                .getTop250Movie(start, 50, new HttpObserver<Top250MovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable = d;
                        //                view.showLoadDialog();
                    }

                    @Override
                    public void onNext(Top250MovieBean data) {
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
}
