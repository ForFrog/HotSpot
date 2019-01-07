package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.biz.movie.MovieDetailActivity;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class MovieComingSoonVH extends BaseViewHolder<ComingSoonMovieBean.SubjectsBean> {
    private TextView tv;
    private ImageView ivImg;


    public MovieComingSoonVH(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
        ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
    }

    @Override
    public void onBindView(final ComingSoonMovieBean.SubjectsBean data) {
        tv.setText(data.getTitle());
        ImageMgr.getInstance().load(itemView.getContext(), data.getImages().getLarge(), ivImg);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_STRING_ID, data.getId());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
