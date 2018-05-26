package com.test.xy.demo.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseActivity;
import com.test.xy.demo.ui.fragment.MeFragment;
import com.test.xy.demo.ui.fragment.ToolFragment;
import com.test.xy.demo.ui.fragment.YlFragment;

import butterknife.BindView;
@Route(path = "/bottom/page")
public class BottomActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;
    private Fragment currentFragment;
    private MeFragment meFragment;
    private YlFragment ylFragment;
    private ToolFragment toolFragment;


    @Override
    protected int createView() {
        return R.layout.activity_bottom;
    }

    @Override
    protected void initData() {
        setTvTitle("底部导航栏");
        setRadioGroup();
        meFragment = new MeFragment();
        ylFragment = new YlFragment();
        toolFragment = new ToolFragment();
        currentFragment = meFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_content,meFragment).commit();
    }

    private void setRadioGroup() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        selectFragment(meFragment);
                        break;
                    case R.id.radioButton2:
                        selectFragment(ylFragment);
                        break;
                    case R.id.radioButton3:
                        selectFragment(toolFragment);
                        break;
                }
            }
        });
    }

    private void selectFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (targetFragment.isAdded()) {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment)
                    .commit();
        }else {
            transaction.hide(currentFragment)
                    .add(R.id.fl_content,targetFragment)
                    .commit();
        }
        currentFragment = targetFragment;
    }
}
