package com.chen.kevin.hotspot.base;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifecycleObserver observer = getObserver();
        if (observer != null) {
            getLifecycle().addObserver(observer);
        }
    }

    protected abstract LifecycleObserver getObserver();
}
