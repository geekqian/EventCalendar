package com.ingdan.eventcalendar.api;

import com.ingdan.eventcalendar.config.MyApplication;
import com.ingdan.eventcalendar.utils.CenterToast;
import com.ingdan.eventcalendar.utils.NetUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by geekqian on 2018/3/19.
 * 描述:
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public abstract class HttpObserver<R> implements Observer<R> {
    private Disposable mDisposable;

    /**
     * 建立链接的时候调用并生成Disposable对象
     * @param d 链接状态对象
     */
    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        getDisposable(d);
    }


    /**
     * 请求结果回调回来的时候调用,会调用多次
     * @param r 返回的结果,没网络时提示
     */
    @Override
    public void onNext(R r) {
        if (!NetUtils.isNetworkAvailable(MyApplication.getContext())) {
            if (mDisposable!=null && !mDisposable.isDisposed()){
                mDisposable.dispose();
            }
            CenterToast.show("请检查网络连接后重试!");
        }
        onSuccess(r);
    }

    public abstract void onSuccess(R r);

    /**
     * 出现异常的时候会走这里,我们统一放在 onFinished();处理
     */
    @Override
    public void onError(Throwable e) {
        onFinished();
        if (e instanceof HttpException || e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof TimeoutException){
            onNetworkException(e);
        }else {
            onUnknownException(e);
        }
    }

    /**
     * 不管成功与失败,这里都会走一次,所以加onFinished();方法
     */
    @Override
    public void onComplete() {
        onFinished();
    }

    /**
     * 请求结束之后的回调,无论成功还是失败,此处一般无逻辑代码,经常用来写ProgressBar的dismiss
     */
    public abstract void onFinished();

    /**
     * 向子类暴露 Disposable
     */
    public abstract void getDisposable(Disposable disposable);

    private void onNetworkException(Throwable e) {
        e.printStackTrace();
        CenterToast.show("获取数据失败，请检查网络状态");
    }

    private void onUnknownException(Throwable e) {
        e.printStackTrace();
    }
}
