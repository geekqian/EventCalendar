package com.ingdan.eventcalendar.utils;

import android.util.Log;

import com.ingdan.eventcalendar.config.Config;


/**
 * @ClassName:LogUtils.java
 * @Des: Log帮助类.
 * @author:qianshen
 * @Date:2016-1-25下午4:04:48
 * 
 */
public class LogUtils {
	//状态为false不打印.
	private static boolean isOut = Config.LOG_SWITCH;

	/** 默认logcat的过滤关键词为"LOG"
	 * @param obj
	 */
	public static void print(Object obj) {
		if (isOut)
			Log.d(Config.LOG_TAG, obj == null ? "null" : obj.toString());
	}

	/** 自定义TAG
	 * @param tag
	 * @param msg
	 */
	public static void print(String tag , String msg) {
		if (isOut)
			Log.d(tag, msg+"");
	}

	/** 自己抛出异常
	 * @param msg
	 * @param t
	 */
	public static void print(String msg, Throwable t) {
		if (isOut)
			Log.d(Config.LOG_TAG, msg+"", t);
	}

}


