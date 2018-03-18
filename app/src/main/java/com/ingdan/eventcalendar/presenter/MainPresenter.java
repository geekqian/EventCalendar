package com.ingdan.eventcalendar.presenter;

import com.ingdan.eventcalendar.MainActivity;
import com.ingdan.eventcalendar.api.DialogSubscriber;
import com.ingdan.eventcalendar.model.WeatherBean;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class MainPresenter extends BasePresenter{

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
        Observable observable = mApi.getWeather(city)
                .map(new HttpResultFunc<WeatherBean>());
        toSubscribe(observable, new DialogSubscriber<WeatherBean>(mActivity) {

            @Override
            public void onNext(WeatherBean weatherBean) {
                mActivity.showWeather(weatherBean);
            }
        });
    }
}
