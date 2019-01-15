package com.chen.kevin.hotspot.net;

import androidx.annotation.NonNull;

import com.chen.kevin.hotspot.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicParamsInterceptor implements Interceptor {
    private static final String KEY_API = "0b2bdeda43b5688921839c8ecb20399b";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        //添加公共参数
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter("apikey", KEY_API)
                .addQueryParameter("version", BuildConfig.VERSION_NAME)
                .build();

        request = request.newBuilder().url(url).build();

//        //打印请求信息
//        String requestMessage = request.method() + ' ' + request.url();
//
//        RequestBody requestBody = request.body();
//        if (requestBody != null) {
//            Buffer buffer = new Buffer();
//            requestBody.writeTo(buffer);
//            requestMessage += buffer.readString(Charset.forName("UTF-8"));
//        }
//        Log.w("request", requestMessage);

        return chain.proceed(request);

    }
}
