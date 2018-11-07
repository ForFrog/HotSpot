package com.chen.kevin.hotspot;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {

    @GET("api/data/Android/{count}/{index}")
    Observable<Bean<List<ResultBean>>> getTopMovie(@Path("count") int count, @Path("index") int index);
}
