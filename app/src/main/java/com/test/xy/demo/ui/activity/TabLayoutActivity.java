package com.test.xy.demo.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.xy.demo.R;
import com.test.xy.demo.ui.adpter.MyTabPagerAdapter;
import com.test.xy.demo.ui.base.BaseActivity;
import com.test.xy.demo.ui.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = "/tab/page")
public class TabLayoutActivity extends BaseActivity {

    @BindView(R.id.tvb)
    TabLayout tvb;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int createView() {
        return R.layout.activity_tab_layout;
    }

    @Override
    protected void initData() {
        setTvTitle("TabLayout");
        initBaseData();
    }

    private void initBaseData() {
        String[] stringArray = getResources().getStringArray(R.array.tab_data);
        for (int i = 1; i < 7; i++) {
            Fragment1 fragment = new Fragment1();
            fragment.setPosition(i);
            fragments.add(fragment);
        }
        MyTabPagerAdapter pagerAdaper = new MyTabPagerAdapter(getSupportFragmentManager(), fragments,stringArray);
        viewPager.setAdapter(pagerAdaper);
        tvb.setupWithViewPager(viewPager);
    }

}
