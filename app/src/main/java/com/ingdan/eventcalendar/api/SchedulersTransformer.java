package com.ingdan.eventcalendar.api;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: 线程调度器
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class SchedulersTransformer {
    public static <T>ObservableTransformer<T,T> io_main(){
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }
}
