package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.listener.AppBarStateChangeListener;

public class TopMovieListActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "TopMovieListActivity";
    public String[] tabTitle = {"Top1-50", "Top51-100", "Top101-150", "Top151-200", "Top201-250",};
    private RelativeLayout rlBar;
    private TabLayout tlType;
    private ViewPager vpContent;
    private LinearLayout layoutBarLeft;
    private TextView tvBarTitle;

    private AppBarLayout layoutAppBar;
    private AppBarStateChangeListener appBarStateChangeListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movie_list);
        initView();
    }

    @Override
    protected LifecycleObserver getObserver() {

        return null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        layoutAppBar.removeOnOffsetChangedListener(appBarStateChangeListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        layoutAppBar.addOnOffsetChangedListener(appBarStateChangeListener);
    }

    private void initView() {
        rlBar = (RelativeLayout) findViewById(R.id.rl_bar);
        tvBarTitle = (TextView) findViewById(R.id.tv_bar_title);
        tvBarTitle.setText("Top250");
        layoutBarLeft = (LinearLayout) findViewById(R.id.layout_bar_left);
        layoutBarLeft.setOnClickListener(this);

        tlType = (TabLayout) findViewById(R.id.tl_type);
        vpContent = (ViewPager) findViewById(R.id.vp_content);
        initViewPager();

        tlType.setupWithViewPager(vpContent);

        layoutAppBar = (AppBarLayout) findViewById(R.id.layout_app_bar);
        appBarStateChangeListener = new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int i) {
                if (state == State.EXPANDED) {
                    //展开状态
                    rlBar.setBackgroundColor(getResources().getColor(R.color.grey));
                    tvBarTitle.setVisibility(View.INVISIBLE);
                } else if (state == State.COLLAPSED) {
                    //折叠状态

                } else {
                    //中间状态
                    rlBar.setBackgroundColor(getResources().getColor(R.color.white));
                    tvBarTitle.setVisibility(View.VISIBLE);
//                    int totalScrollRange = appBarLayout.getTotalScrollRange();
//                    Log.d(TAG, "totalScroll: " + totalScrollRange + "Scroll:" + Math.abs(i));
//                    rlBar.setBackgroundColor(Color.argb(Math.abs(i) / totalScrollRange * 255, 255, 255, 255));
//                    rlBar.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }
        };

    }

    private void initViewPager() {
        vpContent.setOffscreenPageLimit(4);

        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_1_50);
                        break;
                    case 1:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_51_100);
                        break;

                    case 2:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_101_150);
                        break;

                    case 3:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_151_200);
                        break;

                    case 4:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_201_250);
                        break;
                    default:
                        fragment = TopMovieListFragment.newInstance(TopMovieListFragment.TYPE_TOP_1_50);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_bar_left:
                finish();
                break;
        }
    }
}
