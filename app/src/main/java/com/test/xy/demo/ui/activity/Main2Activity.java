package com.test.xy.demo.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.xy.demo.ui.base.BaseActivity;

@Route(path = "/my/test")
public class Main2Activity extends BaseActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }*/

    @Override
    protected boolean isShowToolbar() {
        return true;
    }
}
