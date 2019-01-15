package com.chen.kevin.hotspot.biz.movie;

import androidx.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.biz.SearchActivity;

public class MovieListFragment extends BaseFragment implements View.OnClickListener {
    public String[] tabTitle = {"正在热映", "即将上映"};
    private TabLayout tlType;
    private ViewPager vpContent;
    private LinearLayout llSearch;


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

        llSearch = (LinearLayout) view.findViewById(R.id.ll_search);
        llSearch.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_search:
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
