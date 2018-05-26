package com.test.xy.demo.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.test.xy.demo.R;

import butterknife.ButterKnife;

public class ItemLinearlayout extends LinearLayout {
    public ItemLinearlayout(Context context) {
        super(context);
        initView(context);
    }

    public ItemLinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ItemLinearlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.item_linearlayouit, this);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_linearlayouit, null);
        ButterKnife.bind(this,view);
    }
}
