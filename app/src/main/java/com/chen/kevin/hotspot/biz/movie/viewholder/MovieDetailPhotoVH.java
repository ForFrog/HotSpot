package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class MovieDetailPhotoVH extends BaseViewHolder<MovieDetailBean.PhotosBean> {

    private ImageView ivImg;

    public MovieDetailPhotoVH(View itemView) {
        super(itemView);


        ivImg = (ImageView) itemView.findViewById(R.id.iv_img);


    }

    @Override
    public void onBindView(MovieDetailBean.PhotosBean data) {

        ImageMgr.getInstance().load(itemView.getContext(), data.getImage(), ivImg);
    }

}
