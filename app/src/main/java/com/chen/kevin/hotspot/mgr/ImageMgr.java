package com.chen.kevin.hotspot.mgr;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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

    private static final class ImageMgrHolder {
        private static final ImageMgr INSTANCE = new ImageMgr();
    }
}
