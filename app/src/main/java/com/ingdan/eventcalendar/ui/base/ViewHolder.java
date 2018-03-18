package com.ingdan.eventcalendar.ui.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/18.
 */

public abstract class ViewHolder {
    private View mRootView;
    protected Activity mActivity;
    private Unbinder mBinder;
    private ViewGroup mParent;

    public ViewHolder(Activity activity, ViewGroup parent) {
        this.mActivity = activity;
        this.mParent=parent;
        mRootView = convertView();
        mBinder = ButterKnife.bind(this,mRootView);
        initView(mRootView);
    }

    protected abstract void initView(View view);

    protected <T extends View> T findViewById(int id){
        return mRootView.findViewById(id);
    }

    public ViewHolder(Activity activity) {
        this(activity,null);
    }
    /**
     * 对View进行处理
     */
    private View convertView() {
        View contentView = null;
        if (getLayout() instanceof Integer) {
            Integer layoutId = (Integer) getLayout();
            contentView = mActivity.getLayoutInflater().inflate(layoutId, mParent, false);
        }
        if (getLayout() instanceof View) {
            contentView = (View) getLayout();
        }
        return contentView;
    }

    /**
     * 页面的布局ID 或者View
     */
    protected abstract Object getLayout();

    /**
     * 解除
     */
    public void unbind() {
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
        mActivity = null;
        mRootView = null;

    }

    public View getRootView() {
        return mRootView;
    }
}
