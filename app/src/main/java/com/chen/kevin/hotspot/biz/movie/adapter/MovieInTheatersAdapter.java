package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.MovieInTheatersVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 热映
 */
public class MovieInTheatersAdapter extends RecyclerView.Adapter<MovieInTheatersVH> {
    private List<InTheatersMovieBean.SubjectsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public MovieInTheatersVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_in_theaters, viewGroup, false);
        return new MovieInTheatersVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieInTheatersVH movieInTheatersVH, int i) {
        movieInTheatersVH.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<InTheatersMovieBean.SubjectsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
