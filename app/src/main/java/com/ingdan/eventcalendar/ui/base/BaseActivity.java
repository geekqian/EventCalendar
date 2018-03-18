package com.ingdan.eventcalendar.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Activity的Base类
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected View mContentView;
    private Unbinder mBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 初始化上个页面带过来的数据
        initData();
        // 2. 调用setContentView加载布局
        mContentView = convertView();
        if (mContentView == null) {
            throw new ClassCastException("setLayout 只能是View 或者布局ID");
        }
        setContentView(mContentView);
        // 3.做一些通用的操作，用注解绑定View
        mBinder = ButterKnife.bind(this);
        // 4. 绑定头部
        initTitle();
        // 5.做一些View初化操作
        initView(savedInstanceState);
        // 6.网络的一些处理
        initNet();
    }

    /**
     * 对View进行处理
     */
    private View convertView() {
        View contentView = null;
        if (getLayout() instanceof Integer) {
            Integer layoutId = (Integer) getLayout();
            contentView = getLayoutInflater().inflate(layoutId, null, false);
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

    @Override
    protected void onDestroy() {
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
        mContentView = null;
        super.onDestroy();
    }

    /**
     * 2. 初始化头
     */
    protected void initTitle() {
    }

    /**
     * 1.获取上个页面传递过来的数据
     */
    protected void initData() {
    }


    /**
     * 3. 初始化View
     */
    protected abstract void initView(Bundle savedInstanceState);


    /**
     * 4.初始化网络
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
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 获取当前的Activity
     */
    protected Activity getAppActivity() {
        return this;
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
