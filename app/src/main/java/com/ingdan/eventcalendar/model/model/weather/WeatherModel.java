package com.ingdan.eventcalendar.model.model.weather;

import com.ingdan.base.common.api.HttpObserver;
import com.ingdan.base.common.base.model.BaseModel;
import com.ingdan.base.common.base.presenter.IPresenter;
import com.ingdan.eventcalendar.api.ApiService;
import com.ingdan.eventcalendar.model.bean.weather.WeatherBean;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by david tyhealthlw
 * 描述：天气数据模型
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public class WeatherModel extends BaseModel<WeatherBean> {

    public static final String W_QING = "晴";
    public static final String W_YIN = "阴";
    public static final String W_XIAOYU = "小雨";
    public static final String W_XIAOXUE = "小雪";
    public static final String W_DAXUE = "大雪";
    public static final String W_DAYU = "大雨";
    public static final String W_ZHONGYU = "中雨";
    public static final String W_ZHONGXUE = "中雪";
    public static final String W_WU = "雾";
    public static final String W_DUOYUN = "多云";
    public static final String W_LEIZHENYU = "雷阵雨";

    public WeatherModel(IPresenter<WeatherBean> presenter) {
        super(presenter);
    }

    @Override
    public void request(Map params) {
        //获取天气数据
        ApiService.getApiService().getWeather(new HttpObserver<WeatherBean>() {
            @Override
            public void onSuccess(WeatherBean weatherBean) {
                //相应数据
                mPresenter.responseData(weatherBean);
            }

            @Override
            public void onFinished() {

            }

            @Override
            public void getDisposable(Disposable disposable) {

            }
        }, params);
    }

}
