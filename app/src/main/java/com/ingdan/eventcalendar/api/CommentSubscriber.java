package com.ingdan.eventcalendar.api;

import android.app.Activity;

import com.ingdan.eventcalendar.R;
import com.ingdan.eventcalendar.utils.CenterToast;
import com.ingdan.eventcalendar.utils.LogUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Subscriber状态监听
 *
 * @param <T>
 */
public abstract class CommentSubscriber<T> extends Subscriber<T> {
    protected Activity activity;
    public CommentSubscriber(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void onCompleted() {
        onAfter();
    }

    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof SocketTimeoutException || e instanceof ConnectException
                    || e instanceof UnknownHostException || e instanceof HttpException) {
                CenterToast.show(activity.getString(R.string.net_error));
                LogUtils.print(e.getMessage());
            } else {
                LogUtils.print(e.toString());
                String message = e.getMessage();
                CenterToast.show(message);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            onAfter();
        }
    }


    public void onAfter() {

    }


}