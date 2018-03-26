package com.ingdan.base.common.base.presenter;

import com.ingdan.base.common.base.model.IModel;
import com.ingdan.base.common.base.view.IView;

/**
 * Created by david tyhealthlw
 * 描述：presenter抽象父类
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public abstract class BasePresenter<Data> implements IPresenter<Data> {

    protected IView<Data> IView;
    protected IModel<Data> IModel;

    public BasePresenter(IView<Data> IView) {
        this.IView = IView;
    }

    @Override
    public void requestData(String param) {
        //TODO：对请求数据传入单个参数方法进行空实现
    }

    @Override
    public void requestData(String... params) {
        //TODO：对请求数据传多个参数方法进行空实现
    }

    @Override
    public void responseData(Data data) {
        //TODO: 对相应数据方法进行空实现
    }

    @Override
    public void onDestory() {
        IModel.onDestory();
        IModel = null;
        IView = null;
    }
}
