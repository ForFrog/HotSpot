package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class PopularReviewVH extends BaseViewHolder<MovieDetailBean.PopularReviewsBean> {

    private TextView tvName;
    private TextView tvComment;
    private ImageView ivAverage;
    private TextView tvTitle;


    public PopularReviewVH(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvComment = (TextView) itemView.findViewById(R.id.tv_comment);

        ivAverage = (ImageView) itemView.findViewById(R.id.iv_average);

        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);


    }

    @Override
    public void onBindView(MovieDetailBean.PopularReviewsBean data) {
        tvName.setText(data.getAuthor().getName());
        tvComment.setText(data.getSummary());
        tvTitle.setText(data.getTitle());
        ImageMgr.getInstance().load(itemView.getContext(), data.getAuthor().getAvatar(), ivAverage);
    }

}
