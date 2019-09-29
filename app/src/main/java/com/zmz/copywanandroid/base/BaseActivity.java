package com.zmz.copywanandroid.base;

import android.os.Bundle;

import com.zmz.copywanandroid.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Anthor: Zhuangmingzhu
 * Date: 2019/9/27 下午4:00
 * Describe:Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        ButterKnife.bind(this);
        setUpView();
    }

    public abstract int getViewId();

    public void setUpView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
