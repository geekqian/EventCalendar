package com.ingdan.base.common.base.model;

import com.ingdan.base.common.base.presenter.IPresenter;

import java.util.Map;

/**
 * Created by david tyhealthlw
 * 描述：
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public abstract class BaseModel<Data> implements IModel<Data> {

    protected IPresenter<Data> mPresenter;

    public BaseModel(IPresenter<Data> presenter) {
        mPresenter = presenter;
    }

    @Override
    public void request(Map<String, String> params, DataCallback<Data> callback) {
        //TODO:request方法空实现
    }

    @Override
    public void onDestory() {
        mPresenter = null;
    }
}
