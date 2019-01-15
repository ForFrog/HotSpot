package com.chen.kevin.hotspot.base;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
