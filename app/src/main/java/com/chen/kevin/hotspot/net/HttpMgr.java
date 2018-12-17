package com.chen.kevin.hotspot.net;

import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.bean.Project;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Path;

public class HttpMgr {

    private final ApiServer apiServer;

    //在访问HttpMethods时创建单例
    private static class HttpMgrHolder {
        private static final HttpMgr INSTANCE = new HttpMgr();
    }

    //获取单例
    public static HttpMgr getInstance() {
        return HttpMgrHolder.INSTANCE;
    }

    private HttpMgr() {
        apiServer = Http.getInstance().create(ApiServer.class);
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

}
