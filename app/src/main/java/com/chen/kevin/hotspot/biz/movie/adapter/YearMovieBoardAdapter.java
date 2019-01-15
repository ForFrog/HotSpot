package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.YearMovieBoardVH;

import java.util.List;

/**
 * 年度电影榜单
 */
public class YearMovieBoardAdapter extends RecyclerView.Adapter<YearMovieBoardVH> {
//    private List<MovieDetailBean.DirectorsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public YearMovieBoardVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_year_movie_board, viewGroup, false);
        return new YearMovieBoardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YearMovieBoardVH viewHolder, int i) {
//        viewHolder.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public void setData(List<MovieDetailBean.DirectorsBean> data) {
//        this.data = data;
//        notifyDataSetChanged();
    }

}
