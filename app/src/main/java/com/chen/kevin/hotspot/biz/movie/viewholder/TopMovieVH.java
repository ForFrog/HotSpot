package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.Top250MovieBean;
import com.chen.kevin.hotspot.biz.movie.MovieDetailActivity;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class TopMovieVH extends BaseViewHolder<Top250MovieBean.SubjectsBean> {
    private ImageView ivCover;
    private TextView tvTitle;

    public TopMovieVH(View itemView) {
        super(itemView);

        ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);


    }

    @Override
    public void onBindView(final Top250MovieBean.SubjectsBean data) {
        tvTitle.setText(data.getTitle());
        ImageMgr.getInstance().load(itemView.getContext(), data.getImages().getLarge(), ivCover);


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
