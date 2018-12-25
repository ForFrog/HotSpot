package com.chen.kevin.hotspot.biz.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class MovieDetailActivity extends BaseActivity implements IMovieContract.MovieDetailActivityView {
    public static final String EXTRA_STRING_ID = "extra_string_id";
    private static final String TAG = "MovieDetailActivity";

    private TextView tvTitle;
    private ImageView ivCover;

    private String id;
    private MovieDetailActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        id = getIntent().getStringExtra(EXTRA_STRING_ID);

        presenter = new MovieDetailActivityPresenter(this);
        presenter.loadData(id);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivCover = (ImageView) findViewById(R.id.iv_cover);

    }

    @Override
    public void showData(MovieDetailBean bean) {
        Log.d(TAG, "showData: " + bean);
        tvTitle.setText(bean.getTitle());
        String largeCover = bean.getImages().getLarge();
        if (!TextUtils.isEmpty(largeCover)) {
            ImageMgr.getInstance().load(this, largeCover, ivCover);
        }
    }
}
