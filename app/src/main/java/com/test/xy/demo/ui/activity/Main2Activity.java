package com.test.xy.demo.ui.activity;

import android.content.Intent;
import android.media.MediaRecorder;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.xy.demo.R;
import com.test.xy.demo.ui.base.BaseActivity;
import com.test.xy.demo.ui.view.ItemLinearlayout;
import com.test.xy.demo.ui.view.RecordPlayer;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/my/test")
public class Main2Activity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;


    private String[] strings;

    // 录音类
    private MediaRecorder mediaRecorder;
    // 以文件的形式保存
    private File recordFile;

    private RecordPlayer player;

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
        strings = new String[]{"a", "b", "c", "d", "e"};
        initLinearLayout();
        player = new RecordPlayer(Main2Activity.this);
        recordFile = new File("/mnt/sdcard", "kk.amr");
    }

    private void initLinearLayout() {
        for (int i = 0; i < strings.length; i++) {
            ItemLinearlayout itemLinearlayout = new ItemLinearlayout(this);

        }
    }

    @OnClick({R.id.tv, R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                startActivity(new Intent(this, TestActivity.class));
                break;
            case R.id.tv1:
                startRecording();
                break;
            case R.id.tv2:
                stopRecording();
                break;
            case R.id.tv3:
                playRecording();
                break;
            case R.id.tv4:
                pauseplayer();
                break;
            case R.id.tv5:
                stopplayer();
                break;
        }
    }

    private void startRecording() {
        mediaRecorder = new MediaRecorder();
        // 判断，若当前文件已存在，则删除
        if (recordFile.exists()) {
            recordFile.delete();
        }
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mediaRecorder.setOutputFile(recordFile.getAbsolutePath());

        try {
            // 准备好开始录音
            mediaRecorder.prepare();

            mediaRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void stopRecording() {
        if (recordFile != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
    }

    private void playRecording() {
        player.playRecordFile(recordFile);
    }


    private void pauseplayer() {
        player.pausePalyer();
    }

    private void stopplayer() {
        // TODO Auto-generated method stub
        player.stopPalyer();
    }
}
