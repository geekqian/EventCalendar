package com.ingdan.eventcalendar.presenter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ingdan.eventcalendar.api.ResponseAPI;
import com.ingdan.eventcalendar.api.ResponseConvertFactory;
import com.ingdan.eventcalendar.config.Config;
import com.ingdan.eventcalendar.config.MyApplication;
import com.ingdan.eventcalendar.config.URLS;
import com.ingdan.eventcalendar.model.BaseBean;
import com.ingdan.eventcalendar.utils.NetUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by geekqian on 2017/11/8.
 * 描述: Presenter基类
 * 更新者:
 * 更新时间:
 * 更新描述:
 */
public abstract class BasePresenter {

    public ResponseAPI mApi;
    protected Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public BasePresenter() {
        // 设置请求头
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLS.ROOTURL)
                // 自己定义的Gson解析
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(genericClient())
                .build();
        mApi = retrofit.create(ResponseAPI.class);
    }

    /**
     * @return
     */
    public OkHttpClient genericClient() {
        File httpCacheDirectory = new File(MyApplication.getContext().getCacheDir(), "responses");
        if (!httpCacheDirectory.exists()) {
            httpCacheDirectory.mkdirs();
        }
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        request = request.newBuilder().addHeader(Config.HEADER_KEY, Config.HEADER).build();

                        if (!NetUtils.isNetworkAvailable(MyApplication.getContext())) {
                            request = request.newBuilder()
                                    .cacheControl(CacheControl.FORCE_CACHE)                     //走缓存
                                    .addHeader("Content-type", "application/json; charset=UTF-8")
                                    .build();
                        }

                        Response response = chain.proceed(request);
                        if (NetUtils.isNetworkAvailable(MyApplication.getContext())) {
                            int maxAge = 60 * 60; // 从缓存读取１分钟
                            response.newBuilder()
                                    .removeHeader("Pragma")
                                    .addHeader("Content-type", "application/json; charset=UTF-8")
                                    .header("Cache-Control", "public, max-age=" + maxAge)
                                    .build();
                        } else {
                            int maxStale = 60 * 60 * 24 * 28; // 缓存４个星期
                            response.newBuilder()
                                    .removeHeader("Pragma")
                                    .addHeader("Content-type", "application/json; charset=UTF-8")
                                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                    .build();
                        }
                        return response;
                    }

                })
                .cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024))
                .build();
        return httpClient;
    }


    /**
     * 统一处理Http的resultCode,将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber   Data部分的数据类型
     */
    public class HttpResultFunc<T> implements Func1<BaseBean<T>, T> {
        @Override
        public T call(BaseBean<T> httpResult) {
            if (httpResult == null) {
                throw new RuntimeException("请求接口出错");
            } else if (!"200".equals(httpResult.code)) {
                throw new RuntimeException(httpResult.message);
            }
            return httpResult.data;
        }
    }

    /**
     * 不判断状态码,将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <BaseBean> Subscriber   Data部分的数据类型
     */
    public class MyFunc<BaseBean> implements Func1<BaseBean, BaseBean> {
        @Override
        public BaseBean call(BaseBean httpResult) {
            if (httpResult == null) {
                throw new RuntimeException("请求接口出错");
            }
            return httpResult;
        }
    }

    /**
     * 线程调度
     */
    protected <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}