package com.chen.kevin.hotspot.mgr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

public class ImageMgr {
    private ImageMgr() {
    }

    public static ImageMgr getInstance() {
        return ImageMgrHolder.INSTANCE;
    }

    public void load(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
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
