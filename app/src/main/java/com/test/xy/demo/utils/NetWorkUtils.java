package com.test.xy.demo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.test.xy.demo.global.BaseApplication;

public class NetWorkUtils {
    /**
     * 判断是否有网络连接
     * @return
     */
    public static boolean isNetWorked() {

        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager serviceManager = (ConnectivityManager) BaseApplication.getmContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (serviceManager == null) {
            return false;
        }

        // 获取NetworkInfo对象
        NetworkInfo[] allNetworkInfo = serviceManager.getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            return false;
        }

        for (int i = 0; i < allNetworkInfo.length; i++) {
            System.out.println(i+"==状态=="+allNetworkInfo[i].getState());
            System.out.println(i+"==类型=="+allNetworkInfo[i].getTypeName());
            if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }
}
