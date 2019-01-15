package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.base.EmptyFragment;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.adapter.CastsAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.DirectorAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.MovieDetailPhotoAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.MovieDetailTrailerAdapter;
import com.chen.kevin.hotspot.biz.movie.adapter.PopularCommentAdapter;
import com.chen.kevin.hotspot.mgr.ImageMgr;
import com.chen.kevin.hotspot.util.StringUtils;
import com.chen.kevin.hotspot.widget.decoration.SpaceItemDecoration;

import java.util.List;

public class MovieDetailActivity extends BaseActivity implements IMovieContract.MovieDetailActivityView, View.OnClickListener {
    public static final String EXTRA_STRING_ID = "extra_string_id";
    private static final String TAG = "MovieDetailActivity";
    public String[] tabTitle = {"影评", "话题", "讨论"};
    private RelativeLayout rlBar;
    private LinearLayout layoutBarLeft;


    private TextView tvBarTitle;

    private NestedScrollView svScroll;


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
    private TextView tvExpand;

    private TextView tvCastAll;


    private TextView tvTag;
    private TextView tvPubDate;
    private TextView tvDurations;
    private TextView tvRatingsCount;

    private RecyclerView rvPhotos;

    private RecyclerView rvTrailer;
    private RecyclerView rvComment;

    private TabLayout tabBottomSheet;
    private ViewPager vpContent;


    private String id;
    private MovieDetailActivityPresenter presenter;
    private CastsAdapter castsAdapter;
    private DirectorAdapter directorAdapter;
    private PopularCommentAdapter popularCommentAdapter;
    private MovieDetailPhotoAdapter movieDetailPhotoAdapter;
    private MovieDetailTrailerAdapter movieDetailTrailerAdapter;

    private PopularReviewsFragment popularReviewsFragment;
    private List<MovieDetailBean.CastsBean> casts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        id = getIntent().getStringExtra(EXTRA_STRING_ID);
        presenter.loadData(id);

        initView();

        initBottomSheet();

    }


    @Override
    protected LifecycleObserver getObserver() {
        presenter = new MovieDetailActivityPresenter(this);
        return presenter;
    }

    private void initView() {
        rlBar = (RelativeLayout) findViewById(R.id.rl_bar);

        layoutBarLeft = (LinearLayout) findViewById(R.id.layout_bar_left);
        layoutBarLeft.setOnClickListener(this);
        tvBarTitle = (TextView) findViewById(R.id.tv_bar_title);
        tvBarTitle.setText("电影详情");

        final int height = rlBar.getLayoutParams().height;
        svScroll = (NestedScrollView) findViewById(R.id.sv_scroll);
        svScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            // 将透明度声明成局部变量用于判断
            int alpha = 0;
            float scale = 0;

            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY <= height) {
                    scale = (float) scrollY / height;
                    alpha = (int) (255 * scale * 0.3);
                    // 随着滑动距离改变透明度
                    // Log.e("al=","="+alpha);
                    rlBar.setBackgroundColor(Color.argb(alpha, 33, 33, 33));
                } else {
                    // 防止频繁重复设置相同的值影响性能
                    if (alpha < 255) {
                        alpha = (int) (255 * 0.3);
                        rlBar.setBackgroundColor(Color.argb(alpha, 33, 33, 33));
                    }
                }
            }
        });
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


        tvExpand = (TextView) findViewById(R.id.tv_expand);
        tvExpand.setOnClickListener(this);

        rvComment = (RecyclerView) findViewById(R.id.rv_comment);
        rvComment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        popularCommentAdapter = new PopularCommentAdapter();
        rvComment.setAdapter(popularCommentAdapter);


        rvPhotos = (RecyclerView) findViewById(R.id.rv_photos);
        rvPhotos.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false));
        movieDetailPhotoAdapter = new MovieDetailPhotoAdapter();
        rvPhotos.setAdapter(movieDetailPhotoAdapter);

        tvTag = (TextView) findViewById(R.id.tv_tag);
        tvPubDate = (TextView) findViewById(R.id.tv_pub_date);
        tvDurations = (TextView) findViewById(R.id.tv_durations);
        tvRatingsCount = (TextView) findViewById(R.id.tv_ratings_count);


        rvTrailer = (RecyclerView) findViewById(R.id.rv_trailer);
        rvTrailer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        movieDetailTrailerAdapter = new MovieDetailTrailerAdapter();
        rvTrailer.setAdapter(movieDetailTrailerAdapter);


        tvCastAll = (TextView) findViewById(R.id.tv_cast_all);
        tvCastAll.setOnClickListener(this);
    }


    private void initBottomSheet() {
        tabBottomSheet = (TabLayout) findViewById(R.id.tab_bottom_sheet);
        vpContent = (ViewPager) findViewById(R.id.vp_content);
        initViewPager();

        tabBottomSheet.setupWithViewPager(vpContent);
    }

    private void initViewPager() {
        vpContent.setOffscreenPageLimit(2);
        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        popularReviewsFragment = PopularReviewsFragment.newInstance();
                        fragment = popularReviewsFragment;
                        break;
                    case 1:
                        fragment = EmptyFragment.newInstance();
                        break;

                    case 2:
                        fragment = EmptyFragment.newInstance();
                        break;

                    default:
                        fragment = EmptyFragment.newInstance();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return tabTitle.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitle[position];
            }

        });
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
        if (tvSummary.getLineCount() > 3) {
            tvSummary.setMaxLines(3);
            tvSummary.setEllipsize(TextUtils.TruncateAt.END);
        }

        //评分
        if (bean.getRating().getAverage() == 0) {
            tvAverage.setText("暂无评分");
        } else {
            tvAverage.setText(String.valueOf(bean.getRating().getAverage()));
        }

        tvStars.setText(String.valueOf(bean.getRating().getStars()));
        tvReviewsCount.setText(String.valueOf(bean.getReviews_count()));


        tvWishCount.setText(StringUtils.formatNumber(bean.getWish_count()));
        tvCollectCount.setText(StringUtils.formatNumber(bean.getCollect_count()));

        String largeCover = bean.getImages().getLarge();
        ImageMgr.getInstance().load(this, largeCover, ivCover);


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


        StringBuilder sbCountry = StringUtils.formatStringList(bean.getCountries());
        tvCountries.setText(sbCountry.toString());


        StringBuilder sbGenre = StringUtils.formatStringList(bean.getGenres());
        tvGenres.setText(sbGenre.toString());


        StringBuilder sbTag = StringUtils.formatStringList(bean.getTags());
        tvTag.setText(sbTag);

        tvRatingsCount.setText(String.valueOf(bean.getRatings_count()));

        StringBuilder sbDuration = StringUtils.formatStringList(bean.getDurations());
        tvDurations.setText(sbDuration);

        StringBuilder sbPubDate = StringUtils.formatStringList(bean.getPubdates());
        tvPubDate.setText(sbPubDate);

        casts = bean.getCasts();
        castsAdapter.setData(casts);
        directorAdapter.setData(bean.getDirectors());

        popularCommentAdapter.setData(bean.getPopular_comments());

        movieDetailPhotoAdapter.setData(bean.getPhotos());

        movieDetailTrailerAdapter.setData(bean.getTrailers());

        if (popularReviewsFragment != null) {
            popularReviewsFragment.intData(bean.getPopular_reviews());
        }

    }


    @Override
    public void showToast(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_bar_left:
                finish();
                break;
            case R.id.tv_cast_all:
                showCastList();
                break;
            case R.id.tv_expand:
                if (tvSummary.getMaxLines() == 3) {
                    tvSummary.setMaxLines(Integer.MAX_VALUE);
                    tvExpand.setText("收起");
                } else {
                    tvSummary.setMaxLines(3);
                    tvSummary.setEllipsize(TextUtils.TruncateAt.END);
                    tvExpand.setText("全文");
                }
                break;
        }
    }

    private void showCastList() {
        CastListFragment castListFragment = CastListFragment.newInstance();
        if (casts != null) {
            castListFragment.setData(casts);
        }
        castListFragment.show(getSupportFragmentManager(), CastListFragment.class.getSimpleName());

    }
}
