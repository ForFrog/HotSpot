package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;

public class PopularCommentVH extends BaseViewHolder<MovieDetailBean.PopularCommentsBean> {

    private TextView tvName;
    private TextView tvComment;

    public PopularCommentVH(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvComment = (TextView) itemView.findViewById(R.id.tv_comment);

    }

    @Override
    public void onBindView(MovieDetailBean.PopularCommentsBean data) {
        tvName.setText(data.getAuthor().getName());
        tvComment.setText(data.getContent());
    }

}
