package com.chen.kevin.hotspot.net;


import com.chen.kevin.hotspot.bean.Bean;
import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.bean.Project;
import com.chen.kevin.hotspot.bean.Top250MovieBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {

    //项目
    //http://www.wanandroid.com/project/tree/json
    @GET("/project/tree/json")
    Observable<Bean<List<Project>>> getProject();

    //获取正在热映的电影
    //https://api.douban.com/v2/movie/in_theaters?city=广州&start=0&count=10
    @GET("/v2/movie/in_theaters")
    Observable<InTheatersMovieBean> getInTheatersMovie(@Query("city") String city, @Query("start") int start, @Query("count") int count);

    //获取即将上映的电影
    //https://api.douban.com/v2/movie/coming_soon?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=
    @GET("/v2/movie/coming_soon")
    Observable<ComingSoonMovieBean> getComingSoonMovie(@Query("city") String city, @Query("start") int start, @Query("count") int count);

    //获取top250
    //https://api.douban.com/v2/movie/top250?start=0&count=10
    @GET("/v2/movie/top250")
    Observable<Top250MovieBean> getTopMovie(@Query("start") int start, @Query("count") int count);


    //获取电影详情
    //https://api.douban.com/v2/movie/subject/26942674
    @GET("/v2/movie/subject/{id}")
    Observable<MovieDetailBean> getMovieDetail(@Path("id") String id);

    //根据名字搜索电影
    //https://api.douban.com/v2/movie/search?q=神秘巨星&start=0&count=10
    @GET("/v2/movie/search")
    Observable<InTheatersMovieBean> searchMovieByName(@Query("q") String name, @Query("start") int Query, @Query("count") int count);

    //根据类型搜索电影
    //https://api.douban.com/v2/movie/search?tag=喜剧&start=0&count=10
    @GET("/v2/movie/search")
    Observable<InTheatersMovieBean> searchMovieByType(@Query("tag") String tag, @Query("start") int Query, @Query("count") int count);
}
