package com.test.xy.demo.global;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Stack;

public class BaseApplication extends Application {
    private static BaseApplication mContext;
    private static ActivityLifeManager activityLifeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        baseConfig();
    }

    /**
     * 获取application实例
     *
     * @return
     */
    public static BaseApplication getmContext() {
        return mContext;
    }

    /**
     * 基本配置
     */
    private void baseConfig() {
        if (isApkDebug()) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        //activity的生命周期管理
        activityLifeManager = new ActivityLifeManager();
        mContext.registerActivityLifecycleCallbacks(activityLifeManager);
    }

    /**
     * 获取当前activity
     *
     * @return
     */
    public static Activity getCurrentActivity() {
        return activityLifeManager.getActivities().lastElement();
    }

    /**
     * 获取所有的activity
     *
     * @return
     */
    public static Stack<Activity> getAllActivity() {
        return activityLifeManager.getActivities();
    }

    /**
     * 关闭所有的activity
     */
    public static void clearAllActivity() {
        for (Activity activity : getAllActivity()) {
            activity.finish();
        }
    }

    /**
     * 根据指定的类名找到activity
     * @param cls
     * @return
     */
    public static Activity findActivity(Class<?> cls) {
        Activity targetActivity = null;
        if (getAllActivity().empty()) {
            return targetActivity;
        }
        for (Activity activity : getAllActivity()) {
            if (activity.getClass().equals(cls)) {
                targetActivity = activity;
                break;
            }
        }
        return targetActivity;
    }

    /**
     * 是否是debug模式
     *
     * @return
     */
    public static boolean isApkDebug() {
        try {
            return (mContext.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
