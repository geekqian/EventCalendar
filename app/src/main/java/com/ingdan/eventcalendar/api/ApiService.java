package com.ingdan.eventcalendar.api;

import com.ingdan.eventcalendar.config.Config;
import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.eventcalendar.model.WeatherBean;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class ApiService {

    private ResponseAPI mApiInterface;

    private ApiService() {
        //HTTP log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //RequestInterceptor
        RequestInterceptor requestInterceptor = new RequestInterceptor();

        //ResponseInterceptor
        ResponseInterceptor responseInterceptor = new ResponseInterceptor();

        //OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(requestInterceptor)
                .addInterceptor(responseInterceptor);
        //      通过你当前的控制debug的全局常量控制是否打log
        if (Config.LOG_SWITCH) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
        OkHttpClient mOkHttpClient = builder.build();

        //Retrofit
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URLS.ROOTURL)
                .build();

        mApiInterface = mRetrofit.create(ResponseAPI.class);
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
