package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.TrailerVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 短评
 */
public class MovieDetailTrailerAdapter extends RecyclerView.Adapter<TrailerVH> {
    private List<MovieDetailBean.TrailersBean> data = new ArrayList<>();


    @NonNull
    @Override
    public TrailerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_detail_trailer, viewGroup, false);
        return new TrailerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerVH vh, int i) {
        vh.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.TrailersBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
