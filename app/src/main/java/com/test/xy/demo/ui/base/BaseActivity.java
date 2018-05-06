package com.test.xy.demo.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.test.xy.demo.R;
import com.test.xy.demo.modle.eventbus.Event;
import com.test.xy.demo.modle.eventbus.EventbusUtils;
import com.test.xy.demo.utils.NetWorkUtils;
import com.test.xy.demo.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected long clicktime;
    TextView tvTitle;
    Toolbar toolbar;
    FrameLayout flContent;
    private ImmersionBar immersionBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        tvTitle = findViewById(R.id.tv_title);
        toolbar = findViewById(R.id.toolbar);
        flContent = findViewById(R.id.fl_content);
        baseConfig();
    }

    private void baseConfig() {
        //判断网络
        if (!NetWorkUtils.isNetWorked()) {
            ToastUtils.showToast("无网络链接，请在有网络情况下使用");
        }
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化沉浸式状态栏
        immersionBar = ImmersionBar.with(this);
        immersionBar
                .fitsSystemWindows(true)
                .statusBarColor(R.color.ThirdColor)
                .init();
        //是否启用eventBus传值
        if (isRegisterEventbus()) {
            EventbusUtils.register(this);
        }
        //初始化toolbar
        initToolbar();
        //是否显示toolbar
        if (isShowToolbar()) {
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
        }
        //给FrameLayout添加子view
        View view = View.inflate(this, createView(), null);
        flContent.addView(view);
        ButterKnife.bind(this,flContent);
        //初始化数据
        initData();

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //使左上角图标显示
        actionBar.setDisplayShowHomeEnabled(true);
        //使左上角图标加一个返回键显示
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 取消左上角图标的左边的文字。
        actionBar.setDisplayShowTitleEnabled(false);
        //设置返回键的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //eventBus取消订阅
        if (isRegisterEventbus()) {
            EventbusUtils.unregister(this);
        }
        if (immersionBar != null) {
            immersionBar.destroy();
        }
    }

    protected boolean isShowToolbar() {
        return false;
    }

    /**
     * 是否注册eventbus传值、默认为false
     * @return
     */
    protected boolean isRegisterEventbus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBusThing(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    /**
     * 接受分发的事件
     *
     * @param event
     */
    protected void receiveEvent(Event event) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void evetBusStickThing(Event event) {
        if (event != null) {
            receiveStickEvent(event);
        }
    }

    /**
     * 接受分发的黏性事件
     *
     * @param event
     */
    protected void receiveStickEvent(Event event) {

    }

    /**
     * 是否可以点击，防抖动
     *
     * @return
     */
    protected boolean isCanClick() {
        if (System.currentTimeMillis() - clicktime > 2000) {
            clicktime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    /**
     * 获取子view
     * @return
     */
    protected abstract int createView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 获取标题栏的标题
     */
    protected void setTvTitle(String title){
        tvTitle.setText(title);
    }
}
