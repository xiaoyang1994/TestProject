package com.test.xy.demo.global;

import android.content.Intent;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.test.xy.demo.R;
import com.test.xy.demo.ui.activity.MainActivity;
import com.test.xy.demo.ui.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected int createView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        ImmersionBar.with(this)
                .reset()
                .fullScreen(true)
                .init();
        iv.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 2000);
    }


}
