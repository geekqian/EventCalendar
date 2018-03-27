package com.ingdan.base.common.base.presenter;

/**
 * Created by david tyhealthlw
 * 描述：presenter顶层接口
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public interface IPresenter<Data> {

    /**
     * 请求数据,传入单个参数，通常View层调用，向model层发起request
     */
    void requestData(String param);

    /**
     * 请求多个数据，通常View层调用，向model层发起request
     */
    void requestData(String... params);

    /**
     * 相应数据，此处可以通知View进行数据刷新
     *
     * @param data 泛型数据
     */
    void responseData(Data data);


    /**
     * 销毁方法，防止内存泄漏
     */
    void onDestory();
}
