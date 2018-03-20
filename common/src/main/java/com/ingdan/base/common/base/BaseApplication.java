package com.ingdan.base.common.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.ingdan.base.common.utils.SPUtils;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class BaseApplication extends Application {

    public static Context getContext() {
        return mContext;
    }

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SPUtils.init(this);
    }
}
