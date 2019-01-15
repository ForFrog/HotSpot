package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

/**
 * 榜单
 */
public class BoardFragment extends BaseFragment {

    public String[] tabTitle = {"电影", "读书"};


    private TabLayout tlType;
    private ViewPager vpContent;
    private FragmentPagerAdapter adapter;

    public static BoardFragment newInstance() {
        Bundle args = new Bundle();
        BoardFragment fragment = new BoardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_board;
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
    }

    @Override
    protected void initView(View view) {
        tlType = (TabLayout) view.findViewById(R.id.tl_type);
//        tlType.addTab(tlType.newTab().setText("电影"));
//        tlType.addTab(tlType.newTab().setText("读书"));
        vpContent = (ViewPager) view.findViewById(R.id.vp_content);
        initViewPager();

        tlType.setupWithViewPager(vpContent);
    }

    private void initViewPager() {
        adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = BoardMovieFragment.newInstance();
                        break;
                    case 1:
                        fragment = BoardBookFragment.newInstance();
                        break;
                    default:
                        fragment = BoardMovieFragment.newInstance();
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
        };
        vpContent.setAdapter(adapter);
    }

    @Override
    public void showToast(String msg) {

    }


}
