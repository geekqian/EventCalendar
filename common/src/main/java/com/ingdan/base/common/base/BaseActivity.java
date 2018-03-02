package com.ingdan.base.common.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author david
 *         描述：所有Activity基类
 *         更新者：
 *         创建时间：2018/03/02
 *         更新时间：
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if (initArgs(getIntent().getExtras())) {
            initWidget();
            initWindow();
            initData();
        } else {
            finish();
        }
    }

    /**
     * 获取布局ID
     *
     * @return ID
     */
    protected abstract int getContentLayoutID();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化组件
     */
    protected void initWidget() {
        int ID = getContentLayoutID();
        setContentView(ID);
        mUnbinder = ButterKnife.bind(this);
    }

    /**
     * 初始化bundle
     *
     * @param bundle
     * @return
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 初始化窗体
     */
    protected void initWindow() {

    }

    /**
     * 点击顶部返回键
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    /**
     * 返回键监听
     */
    @Override
    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    if (((BaseFragment) fragment).onBackpressed()) {
                        return;
                    }
                }
            }
        }

        super.onBackPressed();
        finish();
    }
}
