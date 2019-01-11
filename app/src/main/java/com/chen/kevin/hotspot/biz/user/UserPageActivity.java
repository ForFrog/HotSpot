package com.chen.kevin.hotspot.biz.user;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.base.BaseActivity;
import com.chen.kevin.hotspot.mgr.ImageMgr;

/**
 * 个人主页
 */
public class UserPageActivity extends BaseActivity {
    public static final String EXTRA_STRING_ID = "extra_string_id";
    public static final String EXTRA_STRING_AVATAR = "extra_string_avatar";
    public static final String EXTRA_STRING_NAME = "extra_string_name";
    public static final String EXTRA_STRING_SIGNATURE = "extra_string_signature";

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvSignature;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        String id = getIntent().getStringExtra(EXTRA_STRING_ID);
        String avatar = getIntent().getStringExtra(EXTRA_STRING_AVATAR);
        String name = getIntent().getStringExtra(EXTRA_STRING_NAME);
        String signature = getIntent().getStringExtra(EXTRA_STRING_SIGNATURE);

        ivAvatar = (ImageView) findViewById(R.id.iv_avatar);
        ImageMgr.getInstance().load(this,avatar,ivAvatar);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(name);
        tvSignature = (TextView) findViewById(R.id.tv_signature);
        tvSignature.setText(signature);
    }

    @Override
    protected LifecycleObserver getObserver() {
        return null;
    }


}
