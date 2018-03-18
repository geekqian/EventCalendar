package com.ingdan.eventcalendar.api;


import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.eventcalendar.model.BaseBean;
import com.ingdan.eventcalendar.model.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * retrofit接口地址
 */
public interface ResponseAPI {

    // 获取天气
    @GET(URLS.GET_WEATHER_URL)
    Observable<BaseBean<WeatherBean>> getWeather(@Query("city") String city);
}