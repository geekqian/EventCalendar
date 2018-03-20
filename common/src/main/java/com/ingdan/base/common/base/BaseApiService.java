package com.ingdan.base.common.base;

import com.ingdan.base.common.api.RequestInterceptor;
import com.ingdan.base.common.api.ResponseInterceptor;
import com.ingdan.base.common.config.BaseConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: api 服务的基类
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public abstract class BaseApiService<T> {

    protected T mApiInterface;

    public BaseApiService() {
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
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(requestInterceptor)
                .addInterceptor(responseInterceptor);
        //      通过你当前的控制debug的全局常量控制是否打log
        if (BaseConfig.LOG_SWITCH) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
        OkHttpClient mOkHttpClient = builder.build();

        //Retrofit
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(setApiRootUrl())
                .build();

        mApiInterface = mRetrofit.create(setApiClass());
    }

    /** 提供给子类设置接口类
     * @return 接口类 如 ApiInterface.class
     */
    public abstract Class<T> setApiClass();

    /** 提供给子类设置接口根地址
     * @return 接口根地址, 一般为 服务器ip地址 或 域名
     */
    public abstract String setApiRootUrl();

}
