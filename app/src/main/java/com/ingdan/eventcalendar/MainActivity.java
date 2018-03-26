package com.ingdan.eventcalendar;

import android.widget.TextView;

import com.ingdan.base.common.base.BaseActivity;
import com.ingdan.base.common.utils.LocationUtils;
import com.ingdan.eventcalendar.model.bean.WeatherBean;
import com.ingdan.eventcalendar.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<WeatherBean> {


    @BindView(R.id.tv_weather)
    TextView mTvWeather;
    private MainPresenter mPresenter;
    private String mCity;

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new MainPresenter(this);
        getLocation();
    }

    /**
     * 获取当前地区
     */
    public void getLocation() {
        mCity = "深圳";
        LocationUtils.getLocation();
    }

    @OnClick(R.id.bt_getData)
    public void getWeather() {
        //请求天气数据
        mPresenter.requestData(mCity);
    }

    @Override
    public void notifycationDataSetChange(WeatherBean weatherBean) {
        // 城市
        String city = weatherBean.getCity();
        // 温度
        String wendu = weatherBean.getWendu();
        // 感冒温馨提示
        String ganmao = weatherBean.getGanmao();
        // 昨天的数据
        WeatherBean.YesterdayBean yesterday = weatherBean.getYesterday();
        // 未来4日预报，集合里有5个，首个数据是当天的天气
        List<WeatherBean.ForecastBean> forecast = weatherBean.getForecast();
        // 空气质量指数
        String aqi = weatherBean.getAqi();
        mTvWeather.setText(city + " 当前温度：" + wendu + "° \r\n 温馨提示：" + ganmao);
    }


}
