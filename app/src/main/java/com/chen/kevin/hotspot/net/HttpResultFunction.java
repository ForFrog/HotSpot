package com.chen.kevin.hotspot.net;

import com.chen.kevin.hotspot.bean.Bean;

import io.reactivex.functions.Function;

public class HttpResultFunction<T> implements Function<Bean<T>, T> {

    @Override
    public T apply(Bean<T> bean) throws Exception {
        if (bean.isError()) {
            throw new Exception(bean.getErrorMsg());
        }
        return bean.getData();
    }
}
