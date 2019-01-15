package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.DirectorVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 导演
 */
public class DirectorAdapter extends RecyclerView.Adapter<DirectorVH> {
    private List<MovieDetailBean.DirectorsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public DirectorVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_casts, viewGroup, false);
        return new DirectorVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorVH directorVH, int i) {
        directorVH.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.DirectorsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
