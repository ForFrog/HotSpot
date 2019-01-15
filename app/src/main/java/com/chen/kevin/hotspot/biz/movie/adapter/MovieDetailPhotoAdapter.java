package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.MovieDetailPhotoVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 短评
 */
public class MovieDetailPhotoAdapter extends RecyclerView.Adapter<MovieDetailPhotoVH> {
    private List<MovieDetailBean.PhotosBean> data = new ArrayList<>();


    @NonNull
    @Override
    public MovieDetailPhotoVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_detail_photo, viewGroup, false);
        return new MovieDetailPhotoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailPhotoVH vh, int i) {
        vh.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.PhotosBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
