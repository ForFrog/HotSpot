package com.chen.kevin.hotspot.project;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;
import com.chen.kevin.hotspot.bean.Project;
import com.chen.kevin.hotspot.project.adapter.ProjectAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProjectFragment extends BaseFragment<ProjectPresenter> implements IProjectContract.View {

    private ImageView homesearch;
    private TabLayout mTabLayout;
    private ViewPager mViewpager;


    public static ProjectFragment newInstance() {
        Bundle args = new Bundle();
        ProjectFragment fragment = new ProjectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView(View view) {
        homesearch = (ImageView) view.findViewById(R.id.homesearch);
        mTabLayout = (TabLayout) view.findViewById(R.id.mTabLayout);
        mViewpager = (ViewPager) view.findViewById(R.id.mViewpager);

        mPresenter = new ProjectPresenter(this);
        mPresenter.getProjectDate();
    }

    @Override
    public void setProjectDate(List<Project> projects) {
        List<Integer> ids = new ArrayList<>();
        List<String> names = new ArrayList<>();
        if (projects.size()> 0) {
            for (Project project: projects){
                ids.add(project.getId());
                names.add(project.getName());
            }
        }

        ProjectAdapter adapter = new ProjectAdapter(getChildFragmentManager(), names,ids);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(1);
        mViewpager.setCurrentItem(0, false);
        mTabLayout.setupWithViewPager(mViewpager, true);
    }
}
