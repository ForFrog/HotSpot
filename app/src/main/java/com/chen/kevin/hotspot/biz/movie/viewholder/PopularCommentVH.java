package com.chen.kevin.hotspot.biz.movie.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseViewHolder;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.user.UserPageActivity;
import com.chen.kevin.hotspot.mgr.ImageMgr;

public class PopularCommentVH extends BaseViewHolder<MovieDetailBean.PopularCommentsBean> implements View.OnClickListener {

    private TextView tvName;
    private TextView tvComment;
    private ImageView ivAvatar;
    private TextView tvTime;
    private TextView tvUseful;

    private MovieDetailBean.PopularCommentsBean data;


    public PopularCommentVH(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        tvUseful = (TextView) itemView.findViewById(R.id.tv_useful);

        ivAvatar.setOnClickListener(this);
    }

    @Override
    public void onBindView(MovieDetailBean.PopularCommentsBean data) {
        this.data = data;

        tvName.setText(data.getAuthor().getName());
        tvComment.setText(data.getContent());
        ImageMgr.getInstance().load(itemView.getContext(), data.getAuthor().getAvatar(), ivAvatar);
        tvTime.setText(data.getCreated_at());
        tvUseful.setText(String.valueOf(data.getUseful_count()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_avatar:
                if (data != null) {
                    Intent intent = new Intent(itemView.getContext(), UserPageActivity.class);
                    intent.putExtra(UserPageActivity.EXTRA_STRING_ID, data.getAuthor().getId());
                    intent.putExtra(UserPageActivity.EXTRA_STRING_NAME, data.getAuthor().getName());
                    intent.putExtra(UserPageActivity.EXTRA_STRING_AVATAR, data.getAuthor().getAvatar());
                    intent.putExtra(UserPageActivity.EXTRA_STRING_SIGNATURE, data.getAuthor().getSignature());
                    itemView.getContext().startActivity(intent);
                }

                break;
        }
    }
}
