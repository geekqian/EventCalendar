package com.ingdan.eventcalendar.presenter;

import com.ingdan.base.common.base.presenter.BasePresenter;
import com.ingdan.base.common.base.view.IView;
import com.ingdan.eventcalendar.model.bean.weather.WeatherBean;
import com.ingdan.eventcalendar.model.model.weather.WeatherModel;

import java.util.HashMap;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: 主类Presenter
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class MainPresenter extends BasePresenter<WeatherBean> {


    public MainPresenter(IView IView) {
        super(IView);
        IModel = new WeatherModel(this);
    }

    @Override
    public void requestData(String param) {
        super.requestData(param);
        HashMap<String, String> map = new HashMap<>();
        map.put("city", param);
        //向model层请求View层需要的数据
        IModel.request(map);
    }

    @Override
    public void responseData(WeatherBean weatherBean) {
        super.responseData(weatherBean);
        //通知View更新
        IView.notifycationDataSetChange(weatherBean);
    }
}
