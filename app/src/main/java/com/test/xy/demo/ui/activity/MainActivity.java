package com.test.xy.demo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.test.xy.demo.R;
import com.test.xy.demo.global.BaseApplication;
import com.test.xy.demo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    protected long backtime;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        Toast.makeText(this,"test", Toast.LENGTH_LONG).show();
        ARouter.getInstance().build("/my/test").navigation();
    }
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis()-backtime>2000) {
            backtime = System.currentTimeMillis();
            ToastUtils.showToast("再按一下退出应用程序");
            return ;
        }else {
            BaseApplication.clearAllActivity();
        }
    }
}
