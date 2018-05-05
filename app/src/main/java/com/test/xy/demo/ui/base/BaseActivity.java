package com.test.xy.demo.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.test.xy.demo.R;
import com.test.xy.demo.modle.eventbus.Event;
import com.test.xy.demo.modle.eventbus.EventbusUtils;
import com.test.xy.demo.utils.NetWorkUtils;
import com.test.xy.demo.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected long clicktime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.base_activity);
        ButterKnife.bind(this);
        //判断网络
        if (!NetWorkUtils.isNetWorked()) {
            ToastUtils.showToast("无网络链接，请在有网络情况下使用");
        }
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //是否启用eventBus传值
        if (isRigsterEventbus()) {
            EventbusUtils.register(this);
        }
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //使左上角图标显示
        actionBar.setDisplayShowHomeEnabled(true);
        //使左上角图标加一个返回键显示
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 取消左上角图标的左边的文字。
        actionBar.setDisplayShowTitleEnabled(false);
        //是否显示toolbar
        if (isShowToolbar()) {
            toolbar.setVisibility(View.VISIBLE);
        }else {
            toolbar.setVisibility(View.GONE);
        }
    }

    protected boolean isShowToolbar() {
        return false;
    }

    /**
     * 是否注册eventbus传值、默认为false
     *
     * @return
     */
    protected boolean isRigsterEventbus() {
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
}
