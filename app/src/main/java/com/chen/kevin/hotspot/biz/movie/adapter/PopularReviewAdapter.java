package com.chen.kevin.hotspot.biz.movie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.PopularReviewVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 短评
 */
public class PopularReviewAdapter extends RecyclerView.Adapter<PopularReviewVH> {
    private List<MovieDetailBean.PopularReviewsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public PopularReviewVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular_review, viewGroup, false);
        return new PopularReviewVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularReviewVH vh, int i) {
        vh.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.PopularReviewsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
