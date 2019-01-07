package com.chen.kevin.hotspot.net;


import android.support.annotation.NonNull;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {

    private static final String BASE_URL = "https://api.douban.com/";
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    //构造方法私有
    private Http() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.w("Http log", text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Log.e("Http log", message);
                }
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicParamsInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    //获取单例
    public static Http getInstance() {
        return HttpHolder.INSTANCE;
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }


//    public void getTopMovie(int count, int index, Observer<List<ResultBean>> subscriber) {
//        Observable observable = apiServer.getTopMovie(count, index)
//                .map(new HttpResultFunction<List<ResultBean>>());
//        toSubscribe(subscriber, observable);
//    }

    //在访问HttpMethods时创建单例
    private static class HttpHolder {
        private static final Http INSTANCE = new Http();
    }

}
