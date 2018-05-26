package com.test.xy.demo.ui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseActivity;
import com.test.xy.demo.utils.AudioRecoderUtils;
import com.test.xy.demo.utils.ToastUtils;

import butterknife.BindView;

public class TestActivity extends BaseActivity {


    @BindView(R.id.bt)
    Button bt;
    private AudioRecoderUtils audioRecoderUtils;

    @Override
    protected int createView() {
        return R.layout.activity_test;
    }

    @Override
    protected void initData() {
        audioRecoderUtils = new AudioRecoderUtils();
        //录音回调
        audioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {

            //录音中....db为声音分贝，time为录音时长
            @Override
            public void onUpdate(double db, long time) {
                //根据分贝值来设置录音时话筒图标的上下波动，下面有讲解

            }

            //录音结束，filePath为保存路径
            @Override
            public void onStop(String filePath) {
                ToastUtils.showToast("录音保存在：" + filePath);
            }
        });

        //Button的touch监听
        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        bt.setText("松开保存");
                        audioRecoderUtils.startRecord();


                        break;

                    case MotionEvent.ACTION_UP:

                        audioRecoderUtils.stopRecord();        //结束录音（保存录音文件）
//                        mAudioRecoderUtils.cancelRecord();    //取消录音（不保存录音文件）

                        bt.setText("按住说话");

                        break;
                }
                return true;
            }
        });
    }

}
