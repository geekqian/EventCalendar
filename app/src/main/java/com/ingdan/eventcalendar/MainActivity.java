package com.ingdan.eventcalendar;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ingdan.base.common.base.view.BaseActivity;
import com.ingdan.base.common.utils.LocationUtils;
import com.ingdan.eventcalendar.model.bean.weather.WeatherBean;
import com.ingdan.eventcalendar.model.model.weather.WeatherModel;
import com.ingdan.eventcalendar.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity<WeatherBean> {


    @BindView(R.id.tv_weather_time)
    TextView tvWeatherTime;
    @BindView(R.id.topWeatherLayout)
    RelativeLayout topWeatherLayout;
    @BindView(R.id.tv_weather_weather)
    TextView tvWeatherWeather;
    @BindView(R.id.tv_weather_city)
    TextView tvWeatherCity;
    @BindView(R.id.tv_weather_temp)
    TextView tvWeatherTemp;
    @BindView(R.id.tv_weather_date)
    TextView tvWeatherDate;
    @BindView(R.id.image_weather)
    ImageView imageWeather;
    private MainPresenter mPresenter;
    private String mCity;

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        loading();
        mPresenter = new MainPresenter(this);
        getLocation();
        mPresenter.requestData(mCity);
    }

    /**
     * 获取当前地区
     */
    public void getLocation() {
        mCity = "深圳";
        LocationUtils.getLocation();
    }

    @Override
    public void notifycationDataSetChange(WeatherBean weatherBean) {
        unLoading();
        // 城市
        String city = weatherBean.getCity();
        // 温度
        String wendu = weatherBean.getWendu();
        // 感冒温馨提示
        String ganmao = weatherBean.getGanmao();
        //日期
        String date = weatherBean.getYesterday().getDate();
        //日期
        String type = weatherBean.getYesterday().getType();
        // 昨天的数据
        WeatherBean.YesterdayBean yesterday = weatherBean.getYesterday();
        // 未来4日预报，集合里有5个，首个数据是当天的天气
        List<WeatherBean.ForecastBean> forecast = weatherBean.getForecast();
        // 空气质量指数
        String aqi = weatherBean.getAqi();

        tvWeatherTime.setText(date);
        tvWeatherWeather.setText(type);
        tvWeatherCity.setText(city);
        tvWeatherTemp.setText(String.format(getString(R.string.weather_temp), wendu));

        switch (type) {
            case WeatherModel.W_QING:
                imageWeather.setImageResource(R.drawable.ic_white_qing);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue));
                break;
            case WeatherModel.W_DUOYUN:
                imageWeather.setImageResource(R.drawable.ic_white_duoyun);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue));
                break;
            case WeatherModel.W_YIN:
                imageWeather.setImageResource(R.drawable.ic_white_yin);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_gray));
                break;
            case WeatherModel.W_XIAOYU:
                imageWeather.setImageResource(R.drawable.ic_white_xiaoyu);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_gray));
                break;
            case WeatherModel.W_DAYU:
                imageWeather.setImageResource(R.drawable.ic_white_dayu);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_gray));
                break;
            case WeatherModel.W_ZHONGYU:
                imageWeather.setImageResource(R.drawable.ic_white_zhongyu);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_gray));
                break;
            case WeatherModel.W_LEIZHENYU:
                imageWeather.setImageResource(R.drawable.ic_white_leizhenyu);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_gray));
                break;
            case WeatherModel.W_XIAOXUE:
                imageWeather.setImageResource(R.drawable.ic_white_xiaoxue);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue_green));
                break;
            case WeatherModel.W_DAXUE:
                imageWeather.setImageResource(R.drawable.ic_black_daxue);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue_green));
                break;
            case WeatherModel.W_ZHONGXUE:
                imageWeather.setImageResource(R.drawable.ic_white_zhongxue);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue_green));
                break;
            case WeatherModel.W_WU:
                imageWeather.setImageResource(R.drawable.ic_white_wu);
                topWeatherLayout.setBackground(getResources().getDrawable(R.drawable.shape_gradual_blue_green));
                break;

        }
    }


}
