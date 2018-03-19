package com.ingdan.eventcalendar.api;


import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.eventcalendar.model.BaseBean;
import com.ingdan.eventcalendar.model.BookBean;
import com.ingdan.eventcalendar.model.WeatherBean;

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

    @GET("https://api.douban.com/v2/book/1220562")
    Observable<BookBean> doubanApi();

}