package com.chen.kevin.hotspot.net;

import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.bean.Project;
import com.chen.kevin.hotspot.bean.Top250MovieBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HttpMgr {

    private final ApiServer apiServer;

    private HttpMgr() {
        apiServer = Http.getInstance().create(ApiServer.class);
    }

    //获取单例
    public static HttpMgr getInstance() {
        return HttpMgrHolder.INSTANCE;
    }

    private void toSubscribe(Observer subscriber, Observable observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getProjectData(Observer<List<Project>> subscriber) {
        Observable observable = apiServer.getProject()
                .map(new HttpResultFunction<List<Project>>());

        toSubscribe(subscriber, observable);
    }

    public void getInTheatersMovie(String city, int start, int count, Observer<InTheatersMovieBean> subscriber) {
        Observable<InTheatersMovieBean> inTheatersMovie = apiServer.getInTheatersMovie(city, start, count);

        toSubscribe(subscriber, inTheatersMovie);
    }

    public void getComingSoonMovie(String city, int start, int count, Observer<ComingSoonMovieBean> subscriber) {
        Observable<ComingSoonMovieBean> comingSoonMovie = apiServer.getComingSoonMovie(city, start, count);

        toSubscribe(subscriber, comingSoonMovie);
    }

    public void getTop250Movie(int start, int count, Observer<Top250MovieBean> subscriber) {
        Observable<Top250MovieBean> inTheatersMovie = apiServer.getTopMovie(start, count);

        toSubscribe(subscriber, inTheatersMovie);
    }

    public void getMovieDetail(String id, Observer<MovieDetailBean> subscriber) {
        Observable<MovieDetailBean> movieDetail = apiServer.getMovieDetail(id);

        toSubscribe(subscriber, movieDetail);
    }

    //在访问HttpMethods时创建单例
    private static class HttpMgrHolder {
        private static final HttpMgr INSTANCE = new HttpMgr();
    }

}
