package com.test.xy.demo.ui.activity;

import android.content.Intent;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/my/test")
public class Main2Activity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected boolean isShowToolbar() {
        return true;
    }


    @Override
    protected int createView() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initData() {
        setTvTitle("版本");
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        startActivity(new Intent(this,TestActivity.class));
    }
}
