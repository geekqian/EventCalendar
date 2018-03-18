package com.ingdan.eventcalendar.config;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by geekqian on 2018/3/18.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class MyApplication extends Application {

    public static Context getContext() {
        return mContext;
    }

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
