package com.test.xy.demo.modle.eventbus;

import org.greenrobot.eventbus.EventBus;

public class EventbusUtils {

    public static void register(Object subsciber){
        EventBus.getDefault().register(subsciber);
    }
    public static void unregister(Object subsciber){
        EventBus.getDefault().unregister(subsciber);
    }
    public static void sendEvent(Event event){
        EventBus.getDefault().post(event);
    }
    public static void sendStickyEvent(Event event){
        EventBus.getDefault().postSticky(event);
    }
}
