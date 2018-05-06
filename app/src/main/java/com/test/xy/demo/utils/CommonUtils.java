package com.test.xy.demo.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.test.xy.demo.global.BaseApplication;

public class CommonUtils {
    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion() {
        try {
            PackageManager manager = BaseApplication.getmContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(BaseApplication.getmContext().getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
