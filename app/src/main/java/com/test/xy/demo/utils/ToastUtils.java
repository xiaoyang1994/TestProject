package com.test.xy.demo.utils;

import android.widget.Toast;

import com.test.xy.demo.global.BaseApplication;


public class ToastUtils {

    private static Toast toast;

    public static void showToast(String msg) {
        if (msg == null) {
            return;
        }
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getmContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
