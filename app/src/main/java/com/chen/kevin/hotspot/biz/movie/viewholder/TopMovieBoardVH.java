package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.content.Intent;
import android.view.View;

import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.TopMovieListActivity;

public class TopMovieBoardVH extends BaseViewHolder<MovieDetailBean.DirectorsBean> {


    public TopMovieBoardVH(final View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), TopMovieListActivity.class);
                itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onBindView(MovieDetailBean.DirectorsBean data) {

    }


}
