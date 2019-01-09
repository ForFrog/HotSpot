package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class TrailerVH extends BaseViewHolder<MovieDetailBean.TrailersBean> {

    private ImageView ivTrailerImg;
    private TextView tvTrailerTitle;



    public TrailerVH(View itemView) {
        super(itemView);

        ivTrailerImg = (ImageView) itemView.findViewById(R.id.iv_trailer_img);
        tvTrailerTitle = (TextView) itemView.findViewById(R.id.tv_trailer_title);


    }

    @Override
    public void onBindView(MovieDetailBean.TrailersBean data) {
        ImageMgr.getInstance().load(itemView.getContext(),data.getMedium(),ivTrailerImg);

        tvTrailerTitle.setText(data.getTitle());
    }

}
