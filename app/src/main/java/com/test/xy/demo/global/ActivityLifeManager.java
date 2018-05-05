package com.test.xy.demo.global;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.Stack;

/**
 * activity生命周期的管理
 */
public class ActivityLifeManager implements Application.ActivityLifecycleCallbacks {

    private Stack<Activity> activities;

    public ActivityLifeManager() {
        activities = new Stack<>();
    }

    public Stack<Activity> getActivities() {
        return activities;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activities.push(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activities.remove(activity);
    }
}
