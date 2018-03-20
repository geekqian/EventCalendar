package com.ingdan.eventcalendar.api;

import com.ingdan.base.common.base.BaseApiService;
import com.ingdan.base.common.api.HttpResultFunc;
import com.ingdan.base.common.api.SchedulersTransformer;
import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.eventcalendar.model.WeatherBean;

import java.util.Map;

import io.reactivex.Observer;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: 项目定义的api服务, 用于进行网络请求.
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class ApiService extends BaseApiService<ResponseAPI>{

    private ApiService() {
        super();
    }

    @Override
    public Class<ResponseAPI> setApiClass() {
        return ResponseAPI.class;
    }


    @Override
    public String setApiRootUrl() {
        return URLS.ROOTURL;
    }

    //单例
    private static class SingletonHolder {
        private static final ApiService INSTANCE = new ApiService();
    }

    //单例
    public static ApiService getApiService() {
        return SingletonHolder.INSTANCE;
    }

    public void getWeather(Observer<WeatherBean> observer, Map<String, String> map) {
        mApiInterface.getWeather(map)
                .compose(SchedulersTransformer.io_main())
                .map(new HttpResultFunc<>())
                .subscribe(observer);
    }
}
