package com.test.xy.demo.ui.activity;

import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.test.xy.demo.R;
import com.test.xy.demo.global.BaseApplication;
import com.test.xy.demo.ui.base.BaseActivity;
import com.test.xy.demo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    protected long backtime;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected boolean isShowToolbar() {
        return true;
    }

    @Override
    protected int createView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        setTvTitle("主页");
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        ARouter.getInstance().build("/my/test").navigation();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - backtime > 2000) {
            backtime = System.currentTimeMillis();
            ToastUtils.showToast("再按一下退出应用程序");
            return;
        } else {
            BaseApplication.clearAllActivity();
        }
    }
}
