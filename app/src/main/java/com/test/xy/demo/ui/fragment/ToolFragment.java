package com.test.xy.demo.ui.fragment;

import android.widget.TextView;

import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseFragment;

import butterknife.BindView;

public class ToolFragment extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void initData() {
    }

    @Override
    protected int setView() {
        return R.layout.tool_fragment;
    }



}
