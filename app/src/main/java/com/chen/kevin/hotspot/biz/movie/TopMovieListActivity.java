package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;

public class TopMovieListActivity extends BaseActivity implements View.OnClickListener {
    public String[] tabTitle = {"Top1-50", "Top51-100", "Top101-150", "Top151-200", "Top201-250",};

    private TabLayout tlType;
    private ViewPager vpContent;
    private LinearLayout layoutBarLeft;
    private TextView tvBarTitle;


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

    private void initView() {
        tvBarTitle = (TextView) findViewById(R.id.tv_bar_title);
        tvBarTitle.setText("Top250");
        layoutBarLeft = (LinearLayout) findViewById(R.id.layout_bar_left);
        layoutBarLeft.setOnClickListener(this);

        tlType = (TabLayout) findViewById(R.id.tl_type);
        vpContent = (ViewPager) findViewById(R.id.vp_content);

        initViewPager();

        tlType.setupWithViewPager(vpContent);
    }

    private void initViewPager() {
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
