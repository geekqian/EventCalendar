package com.ingdan.base.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by david
 * 描述：所有Fragment基类
 * 更新者：
 * 创建时间：2018/03/02
 * 更新时间：
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 描述：根布局View
     */
    protected View mRoot;
    /**
     * 描述：ButterKnife 绑定对象，可用于解绑
     */
    protected Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //初始化窗体
        initWindow();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            //初始化跟布局，将XML转化成View
            View root = inflater.inflate(getRootViewID(), container);
            //赋值给成员的跟布局View
            this.mRoot = root;
            //初始化组件
            initWeight();
        } else if (mRoot.getParent() != null) {
            //移除父控件里的rootView
            ((ViewGroup) mRoot.getParent()).removeView(mRoot);
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化数据
        initData();
    }

    /**
     * 获取跟布局ID
     *
     * @return
     */
    protected abstract int getRootViewID();

    /**
     * 初始化窗体
     */
    protected void initWindow() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化组件
     */
    protected void initWeight() {
        mUnbinder = ButterKnife.bind(this, mRoot);
    }

    /**
     * 初始化bundle
     *
     * @param bundle bundle
     * @return
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 调用返回键
     *
     * @return true为消费，false为不消费
     */
    public boolean onBackpressed() {
        return false;
    }
}
