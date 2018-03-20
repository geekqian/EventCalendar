package com.ingdan.base.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * SharedPreferences工具类
 */
public class SPUtils {
    /**
     * 配置信息
     */
    private static final String CONFIG = "CONFIG";

    private static SharedPreferences sp;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
    }

    public static void clear() {
        checkInit();
        sp.edit().clear().commit();
    }

    /**
     * 检查有没有初始化
     */
    private static void checkInit() {
        if (mContext == null) {
            throw new RuntimeException("请先调用 init方法初始化");
        }
    }

    /**
     * @param key      键
     * @param defValue 默认值
     * @return
     */
    public static boolean getBoolean(String key,
                                     boolean defValue) {
        checkInit();
        return sp.getBoolean(key, defValue);
    }


    /**
     * 根据key存储一个Boolaen类型的值
     *
     * @param key
     * @param value
     */
    public static void putBoolean(String key, boolean value) {
        checkInit();
        sp.edit().putBoolean(key, value).commit();
    }


    /**
     * 根据key存储一个String类型的值
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        checkInit();
        sp.edit().putString(key, value).commit();
    }

    /**
     * 根据key获取一个String类型的值
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key, String defValue) {
        checkInit();
        return sp.getString(key, defValue);
    }


    /**
     * 缓存对象
     */
    public static void putObject(String key, Object obj) {
        if (obj == null) {
            return;
        }
        putString(key, new Gson().toJson(obj).toString());
    }

//    /**
//     * 获取IM信息
//     */
//    public static <T> T getObject(String key, Class<T> clazz) {
//        try {
//            String json = getString(key, "");
//            if (StringUtils.isEmpty(json)) {
//                return null;
//            }
//            Gson gson = new Gson();
//            return gson.fromJson(json, clazz);
//        } catch (JsonSyntaxException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
