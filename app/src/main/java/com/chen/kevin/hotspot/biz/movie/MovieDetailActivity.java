package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.adapter.CastsAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.DirectorAdapter;
import com.chen.kevin.hotspot.mgr.ImageMgr;
import com.chen.kevin.hotspot.widget.decoration.SpaceItemDecoration;

import java.util.List;

public class MovieDetailActivity extends BaseActivity implements IMovieContract.MovieDetailActivityView {
    public static final String EXTRA_STRING_ID = "extra_string_id";
    private static final String TAG = "MovieDetailActivity";

    private LinearLayout llBg;
    private TextView tvTitle;
    private ImageView ivCover;

    private TextView tvOriginalTitle;
    private TextView tvSummary;
    private TextView tvAverage;
    private TextView tvStars;
    private TextView tvReviewsCount;
    private TextView tvWishCount;
    private TextView tvCollectCount;
    private TextView tvCountries;
    private TextView tvGenres;
    private RecyclerView rvCasts;
    private RecyclerView rvDirectors;


    private String id;
    private MovieDetailActivityPresenter presenter;
    private CastsAdapter castsAdapter;
    private DirectorAdapter directorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        id = getIntent().getStringExtra(EXTRA_STRING_ID);
        presenter.loadData(id);

        initView();


    }

    @Override
    protected LifecycleObserver getObserver() {
        presenter = new MovieDetailActivityPresenter(this);
        return presenter;
    }

    private void initView() {

        llBg = (LinearLayout) findViewById(R.id.ll_bg);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivCover = (ImageView) findViewById(R.id.iv_cover);
        tvOriginalTitle = (TextView) findViewById(R.id.tv_original_title);
        tvSummary = (TextView) findViewById(R.id.tv_summary);
        tvAverage = (TextView) findViewById(R.id.tv_average);
        tvStars = (TextView) findViewById(R.id.tv_stars);
        tvReviewsCount = (TextView) findViewById(R.id.tv_reviews_count);
        tvWishCount = (TextView) findViewById(R.id.tv_wish_count);
        tvCollectCount = (TextView) findViewById(R.id.tv_collect_count);

        tvCountries = (TextView) findViewById(R.id.tv_countries);
        tvGenres = (TextView) findViewById(R.id.tv_genres);

        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(48);

        rvCasts = (RecyclerView) findViewById(R.id.rv_casts);
        LinearLayoutManager castsLayoutManager = new LinearLayoutManager(this);
        castsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvCasts.setLayoutManager(castsLayoutManager);
        rvCasts.addItemDecoration(itemDecoration);
        castsAdapter = new CastsAdapter();
        rvCasts.setAdapter(castsAdapter);

        LinearLayoutManager directorsLayoutManager = new LinearLayoutManager(this);
        directorsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDirectors = (RecyclerView) findViewById(R.id.rv_directors);
        rvDirectors.setLayoutManager(directorsLayoutManager);
        rvDirectors.addItemDecoration(itemDecoration);
        directorAdapter = new DirectorAdapter();
        rvDirectors.setAdapter(directorAdapter);
    }

    @Override
    public void showData(MovieDetailBean bean) {
        Log.d(TAG, "showData: " + bean);
        tvTitle.setText(bean.getTitle());
        if (bean.getOriginal_title().equals(bean.getTitle())) {
            tvOriginalTitle.setText("(" + bean.getYear() + ")");
        } else {
            tvOriginalTitle.setText(bean.getOriginal_title() + "(" + bean.getYear() + ")");
        }
        tvSummary.setText(bean.getSummary());
        tvAverage.setText(String.valueOf(bean.getRating().getAverage()));
        tvStars.setText(String.valueOf(bean.getRating().getStars()));
        tvReviewsCount.setText(String.valueOf(bean.getReviews_count()));
        tvWishCount.setText(String.valueOf(bean.getWish_count()));
        tvCollectCount.setText(String.valueOf(bean.getCollect_count()));
        String largeCover = bean.getImages().getLarge();
        if (!TextUtils.isEmpty(largeCover)) {
            ImageMgr.getInstance().load(this, largeCover, ivCover);
        }

        ImageMgr.getInstance().getBitmap(this, largeCover, new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                BitmapDrawable bd = (BitmapDrawable) resource;
                Palette palette = Palette.from(bd.getBitmap()).generate();
//                Palette palette = new Palette.Builder(resource).generate();
                int color = palette.getMutedColor(getResources().getColor(R.color.grey));
                llBg.setBackgroundColor(color);
            }
        });

        List<String> countries = bean.getCountries();
        StringBuilder sbCountry = new StringBuilder();
        for (String country : countries) {
            sbCountry.append(country).append("/");
        }
        sbCountry.deleteCharAt(sbCountry.length() - 1);
        tvCountries.setText(sbCountry.toString());

        List<String> genres = bean.getGenres();
        StringBuilder sbGenre = new StringBuilder();
        for (String genre : genres) {
            sbGenre.append(genre).append("/");
        }
        sbGenre.deleteCharAt(sbGenre.length() - 1);
        tvGenres.setText(sbGenre.toString());

        castsAdapter.setData(bean.getCasts());
        directorAdapter.setData(bean.getDirectors());
    }

    @Override
    public void showToast(String msg) {

    }
}
