package com.chen.kevin.hotspot.biz.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.MovieDetailBean;
import com.chen.kevin.hotspot.biz.movie.adapter.CastsAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CastListFragment extends BottomSheetDialogFragment {

    private RecyclerView rvContent;
    private CastsAdapter adapter;
    private List<MovieDetailBean.CastsBean> casts;

    public static CastListFragment newInstance() {
        Bundle args = new Bundle();
        CastListFragment fragment = new CastListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 自定义布局
        View view = inflater.inflate(R.layout.fragment_cast, container, false);

        rvContent = (RecyclerView) view.findViewById(R.id.rv_content);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvContent.setLayoutManager(layoutManager);
        adapter = new CastsAdapter();
        rvContent.setAdapter(adapter);

        if (casts != null) {
            adapter.setData(casts);
        }
    }

    public void setData(List<MovieDetailBean.CastsBean> casts) {
        this.casts = casts;
    }

    //    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // 解决dialog黑屏问题
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        }
//        return dialog;
//    }


}
