package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.PopularCommentVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 短评
 */
public class PopularCommentAdapter extends RecyclerView.Adapter<PopularCommentVH> {
    private List<MovieDetailBean.PopularCommentsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public PopularCommentVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular_comment, viewGroup, false);
        return new PopularCommentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCommentVH popularCommentVH, int i) {
        popularCommentVH.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.PopularCommentsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
