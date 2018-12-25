package com.chen.kevin.hotspot.main;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.biz.movie.MovieInTheatersFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            Window window = getWindow();
            View decorView = window.getDecorView();
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(option);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            attributes.flags |= flagTranslucentStatus;
            window.setAttributes(attributes);
        }

        setContentView(R.layout.activity_main);
        fragmentList = new ArrayList<>();
        MovieInTheatersFragment fragment = MovieInTheatersFragment.newInstance();
        userInfoFragment = UserInfoFragment.newInstance();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layout_fragment, fragment);
        ft.commit();

        fragmentList.add(fragment);
        fragmentList.add(fragment);
        fragmentList.add(fragment);
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
