package com.chen.kevin.hotspot.base;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }


    public abstract void onBindView(T data);
}
