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
 * @author david
 *         20180302
 * @deprecated 所有fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    protected View mRoot;
    protected Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initWindow();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int id = getRootViewID();
            View root = inflater.inflate(id, container);
            initWeight();
            this.mRoot = root;
        } else if (mRoot.getParent() != null) {
            ((ViewGroup) mRoot.getParent()).removeView(mRoot);
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
