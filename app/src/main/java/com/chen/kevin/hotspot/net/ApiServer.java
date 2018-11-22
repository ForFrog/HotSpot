package com.chen.kevin.hotspot.net;


import com.chen.kevin.hotspot.bean.Bean;
import com.chen.kevin.hotspot.bean.Project;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {

//    @GET("api/data/Android/{count}/{index}")
//    Observable<Bean<List<ResultBean>>> getTopMovie(@Path("count") int count, @Path("index") int index);

    //项目
    //http://www.wanandroid.com/project/tree/json
    @GET("/project/tree/json")
    Observable<Bean<List<Project>>> getProject();
}
