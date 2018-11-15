package com.chen.kevin.hotspot.project.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.project.ArticleFragment;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<ArticleFragment> articleFragments = new ArrayList<>();

    public ProjectAdapter(FragmentManager fm, List<String> titles, List<Integer> ids) {
        super(fm);
        this.titles = titles;
        for (Integer id : ids) {
            articleFragments.add(ArticleFragment.newInstance(id));
        }
    }

    @Override
    public BaseFragment getItem(int position) {
        return articleFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
