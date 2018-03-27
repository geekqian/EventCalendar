package com.ingdan.base.common.base.model;

import io.reactivex.disposables.Disposable;

/**
 * Created by david tyhealthlw
 * 描述：回调方法
 * 更新者：
 * 创建时间：2018/3/27
 * 更新时间：
 */

public interface DataCallback<Data> {

    /**
     * 数据请求成功回调
     *
     * @param data 泛型数据
     */
    void onSuccess(Data data);

    /**
     * 数据请求完成回调
     */
    void onFinished();

    /**
     * TODO :未知方法,请GeekQian补充一下
     *
     * @param disposable TODO :未知参数,请GeekQian补充一下
     */
    void getDisposable(Disposable disposable);

}
