package com.chen.kevin.hotspot.biz.movie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.InTheatersMovieBean;

import java.util.ArrayList;
import java.util.List;

public class MovieInTheatersAdapter extends RecyclerView.Adapter<MovieInTheatersAdapter.MovieInTheatersVH> implements View.OnClickListener {
    private List<InTheatersMovieBean.SubjectsBean> data = new ArrayList<>();


    @NonNull
    @Override
    public MovieInTheatersAdapter.MovieInTheatersVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_in_theaters, viewGroup, false);

        return new MovieInTheatersVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieInTheatersVH movieInTheatersVH, int i) {
        movieInTheatersVH.tv.setText(data.get(i).getTitle());

        movieInTheatersVH.itemView.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<InTheatersMovieBean.SubjectsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "on click", Toast.LENGTH_SHORT).show();
    }


    class MovieInTheatersVH extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView tv;


        public MovieInTheatersVH(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
