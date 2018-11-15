package com.chen.kevin.hotspot.project;

import android.os.Bundle;
import android.view.View;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseFragment;

public class ArticleFragment extends BaseFragment<ArticlePresenter> implements IProjectContract.ArticleFragmentView {

    public static ArticleFragment newInstance(int id) {
        Bundle args = new Bundle();
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setArticleDate() {

    }
}
