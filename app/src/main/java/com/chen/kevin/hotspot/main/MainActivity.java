package com.chen.kevin.hotspot.main;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.chen.kevin.hotspot.R;
import com.chen.kevin.hotspot.bean.ResultBean;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IHomeContract.View {

    private static final String TAG = "MainActivity";
    private HomePresenter homePresenter;
    private TextView tv;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            Window window = getWindow();
            View decorView = window.getDecorView();
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(option);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            attributes.flags |= flagTranslucentStatus;
            window.setAttributes(attributes);
        }

        homePresenter = new HomePresenter(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        progressDialog = new ProgressDialog(this);

        homePresenter.getListData();
    }


    @Override
    public void setList(List<ResultBean> data) {
        tv.setText(data.toString());
    }

    @Override
    public void showLoadDialog() {
        progressDialog.show();
    }

    @Override
    public void dismissLoadDialog() {
        progressDialog.dismiss();

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
