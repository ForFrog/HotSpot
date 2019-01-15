package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.ComingSoonMovieBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.MovieComingSoonVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 热映
 */
public class MovieComingSoonAdapter extends RecyclerView.Adapter<MovieComingSoonVH> {
    private List<ComingSoonMovieBean.SubjectsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public MovieComingSoonVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_in_theaters, viewGroup, false);
        return new MovieComingSoonVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieComingSoonVH movieComingSoonVH, int i) {
        movieComingSoonVH.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<ComingSoonMovieBean.SubjectsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
