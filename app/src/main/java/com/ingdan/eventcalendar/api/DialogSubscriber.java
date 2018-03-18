package com.ingdan.eventcalendar.api;

import android.app.Activity;

import com.ingdan.eventcalendar.R;
import com.ingdan.eventcalendar.ui.view.LoadingDialog;
import com.ingdan.eventcalendar.utils.CenterToast;
import com.ingdan.eventcalendar.utils.LogUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * 弹出Dialog的网络封装。
 */

public abstract class DialogSubscriber<T> extends CommentSubscriber<T> {

    private LoadingDialog mLoadingDialog;
    private String text;

    @Override
    public void onStart() {
        mLoadingDialog.show(text);
    }

    public DialogSubscriber(Activity activity, String text) {
        super(activity);
        this.text = text;
        mLoadingDialog = new LoadingDialog(activity);
    }

    public DialogSubscriber(Activity activity) {
        this(activity, "");
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

    @Override
    public void onAfter() {
        if (mLoadingDialog!=null){
            mLoadingDialog.dismiss();
            mLoadingDialog=null;
        }
        super.onAfter();
    }
}
