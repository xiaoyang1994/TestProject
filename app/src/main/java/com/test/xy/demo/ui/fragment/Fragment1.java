package com.test.xy.demo.ui.fragment;

import android.widget.TextView;

import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseFragment;

import butterknife.BindView;

public class Fragment1 extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;
    private int mPosition = -1;

    @Override
    protected void initData() {
        switch (mPosition) {
            case 1:
                tv.setText("fragment1");
                break;
            case 2:
                tv.setText("fragment2");
                break;
            case 3:
                tv.setText("fragment3");
                break;
            case 4:
                tv.setText("fragment4");
                break;
            case 5:
                tv.setText("fragment5");
                break;
            case 6:
                tv.setText("fragment6");
                break;
        }
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    @Override
    protected int setView() {
        return R.layout.fragment1;
    }

}
