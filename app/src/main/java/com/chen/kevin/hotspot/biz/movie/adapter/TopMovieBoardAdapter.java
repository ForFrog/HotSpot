package com.chen.kevin.hotspot.biz.movie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.TopMovieBoardVH;

import java.util.List;

/**
 * top电影榜单
 */
public class TopMovieBoardAdapter extends RecyclerView.Adapter<TopMovieBoardVH> {
//    private List<MovieDetailBean.DirectorsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public TopMovieBoardVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_top_movie_board, viewGroup, false);
        return new TopMovieBoardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieBoardVH viewHolder, int i) {
//        viewHolder.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public void setData(List<MovieDetailBean.DirectorsBean> data) {
//        this.data = data;
//        notifyDataSetChanged();
    }

}
