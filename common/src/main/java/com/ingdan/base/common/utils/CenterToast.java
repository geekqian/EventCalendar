package com.ingdan.base.common.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.ingdan.base.common.base.BaseApplication;


/**
 * Created by geekqian on 2017/11/16.
 * 描述: 展示在页面中心的Toast
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class CenterToast {

    public static void show(String str){
        Toast toast = Toast.makeText(BaseApplication.getContext(), str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void show(int resStr){
        Toast toast = Toast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getString(resStr), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
