package com.ingdan.base.common.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ingdan.base.common.base.BaseFragment;
import com.ingdan.base.common.base.presenter.IPresenter;
import com.ingdan.base.common.widget.dialog.LoadingDialog;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by david
 * 描述：所有Activity基类
 * 更新者：
 * 创建时间：2018/03/02
 * 更新时间：
 */
public abstract class BaseActivity<Data> extends AppCompatActivity implements IView<Data> {

    /**
     * 描述：ButterKnife 绑定对象，可用于解绑
     */
    protected Unbinder mUnbinder;
    protected IPresenter<Data> mPresenter;
    private LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initArgs(getIntent().getExtras())) {
            //初始化窗体
            initWindow();
            //初始化组件
            initWidget();
            //初始化数据
            initData();
        } else {
            //关闭界面
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
        loadingDialog = new LoadingDialog(this);
    }

    /**
     * 显示加载dialog
     */
    @Override
    public void showLoading() {
        loadingDialog.show();
    }
    /**
     * 隐藏加载dialog
     */
    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }


    @Override
    public void notifycationDataSetChange(Data data) {
        //TODO:通知数据更新方法空实现具体子类自己实现
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
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
