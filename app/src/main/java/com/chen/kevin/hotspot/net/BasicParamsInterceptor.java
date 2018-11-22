package com.chen.kevin.hotspot.net;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class BasicParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();

        //封装一个公共参数，la，语言1中文2英文
        if (requestBody instanceof FormBody) {
            FormBody formBody = (FormBody) requestBody;
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
            for (int i = 0; i < formBody.size(); i++) {
                bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
            }

            bodyBuilder.addEncoded("version", "v2.0.0");


            formBody = bodyBuilder.build();

            request = request.newBuilder().post(formBody).build();
        }

        //打印请求信息
        String requestMessage = request.method() + ' ' + request.url();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            requestMessage += "?" + buffer.readString(Charset.forName("UTF-8"));
        }
        Log.w("request", requestMessage);

        return chain.proceed(request);

    }
}
