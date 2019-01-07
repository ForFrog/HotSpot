package com.chen.kevin.hotspot.biz.movie;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

public class MovieListFragment extends BaseFragment {
    public String[] tabTitle = {"正在热映", "即将上映"};
    private TabLayout tlType;
    private ViewPager vpContent;


    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
    }

    @Override
    protected void initView(View view) {
        tlType = (TabLayout) view.findViewById(R.id.tl_type);
//        tlType.addTab(tlType.newTab().setText(tabTitle[0]));
//        tlType.addTab(tlType.newTab().setText(tabTitle[1]));

        vpContent = (ViewPager) view.findViewById(R.id.vp_content);
        initViewPager();

        tlType.setupWithViewPager(vpContent);
    }

    private void initViewPager() {
        vpContent.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = MovieInTheatersFragment.newInstance();
                        break;
                    case 1:
                        fragment = MovieComingSoonFragment.newInstance();
                        break;
                    default:
                        fragment = MovieInTheatersFragment.newInstance();
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
    public void showToast(String msg) {

    }
}
