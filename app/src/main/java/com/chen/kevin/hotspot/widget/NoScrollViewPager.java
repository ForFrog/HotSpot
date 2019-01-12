package com.chen.kevin.hotspot.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {
    private boolean isScroll;

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {
        //false 去除滚动效果
        super.setCurrentItem(item, false);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !isScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return !isScroll && super.onTouchEvent(ev);
    }

    public void setScroll(boolean scroll) {
        this.isScroll = scroll;
    }
}
