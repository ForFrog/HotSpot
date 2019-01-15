package com.chen.kevin.hotspot.biz.movie.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.viewholder.CastsVH;

import java.util.ArrayList;
import java.util.List;

/**
 * 演员
 */
public class CastsAdapter extends RecyclerView.Adapter<CastsVH> {
    private List<MovieDetailBean.CastsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public CastsVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_casts, viewGroup, false);
        return new CastsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastsVH castsVH, int i) {
        castsVH.onBindView(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MovieDetailBean.CastsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
