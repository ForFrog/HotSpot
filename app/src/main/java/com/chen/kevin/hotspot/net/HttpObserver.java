package com.chen.kevin.hotspot.net;

import android.util.Log;

import com.google.gson.JsonSyntaxException;

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
        if (e instanceof JsonSyntaxException) {
            Log.e(TAG, "onError: 数据解析错误" + e.toString());
        } else {
            Log.e(TAG, "onSubscribe: show error");
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onSubscribe: dismiss loading");
    }
}
