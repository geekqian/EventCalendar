package com.ingdan.eventcalendar.api;


import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.base.common.model.BaseBean;
import com.ingdan.eventcalendar.model.bean.WeatherBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * retrofit接口地址
 */
public interface ResponseAPI {

    // 获取天气
    @GET(URLS.GET_WEATHER_URL)
    Observable<BaseBean<WeatherBean>> getWeather(@QueryMap Map<String, String> parameter);

}