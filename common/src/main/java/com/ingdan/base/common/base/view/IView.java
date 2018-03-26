package com.ingdan.base.common.base.view;

/**
 * Created by david tyhealthlw
 * 描述：View层顶层接口
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public interface IView<Data> {
    /**
     * 通知数据更新
     *
     * @param data 数据泛型
     */
    void notifycationDataSetChange(Data data);

}
