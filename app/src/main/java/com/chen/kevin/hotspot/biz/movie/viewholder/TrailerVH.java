package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class TrailerVH extends BaseViewHolder<MovieDetailBean.TrailersBean> implements View.OnClickListener {

    private ImageView ivTrailerImg;
    private TextView tvTrailerTitle;

    private VideoView vvVideo;
    private MovieDetailBean.TrailersBean data;

    public TrailerVH(View itemView) {
        super(itemView);

        ivTrailerImg = (ImageView) itemView.findViewById(R.id.iv_trailer_img);
        tvTrailerTitle = (TextView) itemView.findViewById(R.id.tv_trailer_title);
        vvVideo = (VideoView) itemView.findViewById(R.id.vv_video);
    }

    @Override
    public void onBindView(MovieDetailBean.TrailersBean data) {
        this.data = data;
        ImageMgr.getInstance().load(itemView.getContext(), data.getMedium(), ivTrailerImg);
        tvTrailerTitle.setText(data.getTitle());

        ivTrailerImg.setOnClickListener(this);
        vvVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_trailer_img:
                if (data != null) {
                    vvVideo.setVideoPath(data.getResource_url());
                    vvVideo.setVisibility(View.VISIBLE);
                    ivTrailerImg.setVisibility(View.INVISIBLE);
                    vvVideo.start();

                }

                break;
            case R.id.vv_video:

                if (!vvVideo.isPlaying()) {
                    vvVideo.start();
                } else {
                    vvVideo.pause();
                }
                break;
        }

    }
}
