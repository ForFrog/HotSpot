package com.chen.kevin.hotspot.biz.movie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.Top250MovieBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.TopMovieVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 年度电影榜单
 */
public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieVH> {
    private List<Top250MovieBean.SubjectsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public TopMovieVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_top_movie, viewGroup, false);
        return new TopMovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieVH viewHolder, int i) {
        viewHolder.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Top250MovieBean.SubjectsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
