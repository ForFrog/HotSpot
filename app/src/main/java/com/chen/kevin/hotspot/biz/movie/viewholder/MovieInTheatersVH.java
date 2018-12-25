package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.biz.movie.MovieDetailActivity;

public class MovieInTheatersVH extends BaseViewHolder<InTheatersMovieBean.SubjectsBean> {
    private TextView tv;

    public MovieInTheatersVH(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }

    @Override
    public void onBindView(final InTheatersMovieBean.SubjectsBean data) {
        tv.setText(data.getTitle());
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
