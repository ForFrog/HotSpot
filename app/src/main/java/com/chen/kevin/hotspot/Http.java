package com.chen.kevin.hotspot;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {

    public static final String BASE_URL = "http://gank.io/";
    private static final int DEFAULT_TIMEOUT = 5;
    private ApiServer apiServer;
    private Retrofit retrofit;

    //构造方法私有
    private Http() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiServer = retrofit.create(ApiServer.class);
    }

    //在访问HttpMethods时创建单例
    private static class HttpHolder {
        private static final Http INSTANCE = new Http();
    }

    //获取单例
    public static Http getInstance() {
        return HttpHolder.INSTANCE;
    }

    public void getTopMovie(Observer<Bean<List<ResultBean>>> subscriber, int count, int index){
        apiServer.getTopMovie(count, index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
