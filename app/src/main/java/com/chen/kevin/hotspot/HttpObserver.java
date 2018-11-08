package com.chen.kevin.hotspot;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HttpObserver<T> implements Observer<T> {
    private static final String TAG = "HttpObserver";

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: show loading");
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onSubscribe: show error");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onSubscribe: dismiss loading");
    }
}
