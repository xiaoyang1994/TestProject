package com.test.xy.demo.ui.activity;

import android.view.View;
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
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_tab)
    TextView tvTab;
    @BindView(R.id.tv_bottom)
    TextView tvBottom;

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


    @OnClick({R.id.tv_test, R.id.tv_tab, R.id.tv_bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                ARouter.getInstance().build("/my/test").navigation();
                break;
            case R.id.tv_tab:
                ARouter.getInstance().build("/tab/page").navigation();
                break;
            case R.id.tv_bottom:
                ARouter.getInstance().build("/bottom/page").navigation();
                break;
        }
    }

}
