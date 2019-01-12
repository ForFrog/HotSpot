package com.chen.kevin.hotspot.main;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.biz.movie.BoardFragment;
import com.chen.kevin.hotspot.biz.movie.MovieListFragment;
import com.chen.kevin.hotspot.biz.user.UserInfoFragment;
import com.chen.kevin.hotspot.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements IHomeContract.View {

    private static final String TAG = "MainActivity";

    private BottomBarLayout layoutBottom;

    private UserInfoFragment userInfoFragment;
    private BoardFragment boardFragment;
    private MovieListFragment movieListFragment;

    private NoScrollViewPager vpContent;

    private HomePresenter homePresenter;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initFragment();

        vpContent = (NoScrollViewPager) findViewById(R.id.vp_content);
        vpContent.setOffscreenPageLimit(fragmentList.size() - 1);
        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });


        layoutBottom = (BottomBarLayout) findViewById(R.id.layout_bottom);
        layoutBottom.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int before, int current) {
                vpContent.setCurrentItem(current);
            }
        });


        homePresenter.getListData();
    }

    @Override
    protected LifecycleObserver getObserver() {
        homePresenter = new HomePresenter(this);
        return homePresenter;
    }

    private void initFragment() {
        movieListFragment = MovieListFragment.newInstance();
        boardFragment = BoardFragment.newInstance();
        userInfoFragment = UserInfoFragment.newInstance();
        fragmentList = new ArrayList<>();
        fragmentList.add(movieListFragment);
        fragmentList.add(boardFragment);
        fragmentList.add(userInfoFragment);
    }

    @Override
    public void setList() {

    }

    @Override
    public void showLoadDialog() {

    }

    @Override
    public void dismissLoadDialog() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
