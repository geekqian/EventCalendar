package com.ingdan.base.common.config;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public interface BaseConfig {

    // log 开关
    boolean LOG_SWITCH = true;
    // 默认的log tag
    String LOG_TAG = "MyApp";
    // 自定义请求头
    String HEADER_KEY = "";
    String HEADER = "";

    String LOCATION = "Location";

    // 百度定位AK
    String BAIDU_AK = "sBVBNIEiokZN53qN9HjlexnXflzUGjBD";

    // 百度定位安全码
    String MCODE = "1D:08:D4:04:BD:B4:96:C1:48:B7:2D:82:7A:63:39:E6:DE:81:39:2A;com.ingdan.eventcalendar";

}
