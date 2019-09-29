package com.zmz.copywanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.zmz.copywanandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Anthor: Zhuangmingzhu
 * Date: 2019/9/26 下午5:59
 * Describe:闪屏页面
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash)
    LinearLayout splash;

    private Handler handler=new Handler();

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            toHomePage();
        }
    };

    private void toHomePage(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public int getViewId() {
        return R.layout.activity_splash_layout;
    }


    @Override
    public void setUpView() {
        handler.postDelayed(runnable,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable,null);
    }
}


