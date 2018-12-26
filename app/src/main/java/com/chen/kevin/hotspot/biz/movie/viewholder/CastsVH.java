package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class CastsVH extends BaseViewHolder<MovieDetailBean.CastsBean> {

    private ImageView ivAvatar;
    private TextView tvName;

    public CastsVH(View itemView) {
        super(itemView);


        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);

    }

    @Override
    public void onBindView(MovieDetailBean.CastsBean data) {
        ImageMgr.getInstance().load(itemView.getContext(), data.getAvatars().getLarge(), ivAvatar);
        tvName.setText(data.getName());
    }

}
