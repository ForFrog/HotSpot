package com.chen.kevin.hotspot.main;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.biz.movie.BoardFragment;
import com.chen.kevin.hotspot.biz.movie.MovieListFragment;
import com.chen.kevin.hotspot.biz.user.UserInfoFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements IHomeContract.View {

    private static final String TAG = "MainActivity";
    private HomePresenter homePresenter;
    private BottomBarLayout layoutBottom;
    private List<Fragment> fragmentList;
    private FragmentManager fm;
    private UserInfoFragment userInfoFragment;
    private BoardFragment boardFragment;
//    private MovieInTheatersFragment movieInTheatersFragment;
    private MovieListFragment movieListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        movieInTheatersFragment = MovieInTheatersFragment.newInstance();
        movieListFragment = MovieListFragment.newInstance();
        boardFragment = BoardFragment.newInstance();
        userInfoFragment = UserInfoFragment.newInstance();

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layout_fragment, movieListFragment);
        ft.commit();

        fragmentList = new ArrayList<>();
        fragmentList.add(movieListFragment);
        fragmentList.add(boardFragment);
        fragmentList.add(movieListFragment);
        fragmentList.add(userInfoFragment);

        layoutBottom = (BottomBarLayout) findViewById(R.id.layout_bottom);
        layoutBottom.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int before, int current) {
                Log.d(TAG, "onItemSelected: before:" + before + "  current:" + current);
                fm.beginTransaction().replace(R.id.layout_fragment, fragmentList.get(current)).commit();
            }
        });


        homePresenter = new HomePresenter(this);
        homePresenter.getListData();
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
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
