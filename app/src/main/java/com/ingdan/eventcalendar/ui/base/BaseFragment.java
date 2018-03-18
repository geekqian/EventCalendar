package com.ingdan.eventcalendar.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



/**
 * Fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    protected View mContentView, mRootView;
    protected Activity mActivity;
    private boolean mIsInit, mIsVisible;


    // onAttach-->onCreate-->onCreateView-->onViewCreated
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
        mIsInit = false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 初始化上个页面带过来的数据
        initData();
        initTitle();
    }

    @Override
    public void onDestroy() {
        mContentView = null;
        mRootView = null;
        mActivity = null;
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = convertView(inflater, container);
        }
        if (mRootView == null) {
            throw new ClassCastException("setLayout 只能是View 或者布局ID");
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!mIsInit) {
            // 2. 调用setContentView加载布局
            // ViewUtils.bund(view, this);
            // 3.初始化View什么的
            initView(savedInstanceState);
            // 4.调用 网络
            initNet();
        }
        mIsInit = true;
        loadData();
    }

    private void loadData() {
        if (mIsInit && mIsVisible) {
            mIsInit = false;
            mIsVisible = false;
            // 4.如果没访问过网络去加载数据，就初始化网络
            lazyNet();
        }
    }

    /**
     * 如果要懒加载
     */
    protected void lazyNet() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mIsVisible = true;
            loadData();
        } else {
            mIsVisible = false;
        }
    }

    /**
     * 对View进行处理
     */
    private View convertView(LayoutInflater inflater, ViewGroup container) {
        FrameLayout layout = new FrameLayout(mActivity);
        if (getLayout() instanceof Integer) {
            Integer layoutId = (Integer) getLayout();
            mContentView = inflater.inflate(layoutId, layout, false);
        }
        if (getLayout() instanceof View) {
            mContentView = (View) getLayout();
        }
        layout.addView(mContentView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return layout;
    }


    /**
     * 获取上个页面传递过来的数据
     */
    protected void initData() {
    }

    /**
     * 2. 初始化头
     */
    protected void initTitle() {
    }

    /**
     * 页面的布局ID
     */
    protected abstract Object getLayout();

    /**
     * 初始化View
     */
    protected abstract void initView(Bundle savedInstanceState);


    /**
     * 初始化网络
     */
    protected void initNet() {

    }


    /**
     * 打开Activity
     */
    protected void startActivity(Class<?> clazz) {
        startActivity(clazz, null);
    }

    /**
     * 打开Activity
     */
    protected void startActivity(Class<?> clazz, Bundle bundle) {
        if (mActivity == null) {
            return;
        }
        Intent intent = new Intent(mActivity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected Activity getAppActivity() {
        return mActivity;
    }

    protected <T extends View> T viewById(int id) {
        return (T) mRootView.findViewById(id);
    }


    public View findViewById(int id) {
        return mRootView.findViewById(id);
    }

    /**
     * 权限的处理
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
