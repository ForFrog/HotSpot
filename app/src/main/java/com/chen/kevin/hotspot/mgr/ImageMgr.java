package com.chen.kevin.hotspot.mgr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chen.kevin.hotspot.R;

public class ImageMgr {
    private ImageMgr() {
    }

    public static ImageMgr getInstance() {
        return ImageMgrHolder.INSTANCE;
    }

    public void load(Context context, String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            Glide.with(context)
                    .load(R.mipmap.ic_launcher_round)
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(url)
                    .into(imageView);
        }

    }

    public void loadRoundImg(Context context, String url, ImageView imageView) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();

        if (TextUtils.isEmpty(url)) {
            Glide.with(context)
                    .load(R.mipmap.ic_launcher_round)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(imageView);
        }

    }

    public void getBitmap(Context context, String url, SimpleTarget<Drawable> target) {
        Glide.with(context)
                .load(url)
                .into(target);
    }

    private static final class ImageMgrHolder {
        private static final ImageMgr INSTANCE = new ImageMgr();
    }
}
