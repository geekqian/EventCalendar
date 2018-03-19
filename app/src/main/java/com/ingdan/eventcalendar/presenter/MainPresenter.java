package com.ingdan.eventcalendar.presenter;

import com.ingdan.eventcalendar.MainActivity;
import com.ingdan.eventcalendar.api.ApiService;
import com.ingdan.eventcalendar.api.HttpObserver;
import com.ingdan.eventcalendar.model.WeatherBean;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class MainPresenter{

    private MainActivity mActivity;

    public MainPresenter(MainActivity activity) {
        mActivity = activity;
    }

    /**
     * 获取天气数据
     * @param city 传入城市
     */
    public void getWeather(String city){
        HashMap<String, String> map = new HashMap<>();
        map.put("city", city);

        ApiService.getApiService().getWeather(new HttpObserver<WeatherBean>() {
            @Override
            public void onSuccess(WeatherBean weatherBean) {
                mActivity.showWeather(weatherBean);
            }

            @Override
            public void onFinished() {

            }

            @Override
            public void getDisposable(Disposable disposable) {

            }
        }, map);
    }
}
