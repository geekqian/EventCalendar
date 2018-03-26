package com.ingdan.base.common.base.model;

import java.util.Map;

/**
 * Created by david tyhealthlw
 * 描述：model顶层接口
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public interface IModel<Data> {
    /**
     * 请求数据
     *
     * @param params 参数集合
     */
    void request(Map<String, String> params);

    /**
     * 销毁方法，防止内存泄漏
     */
    void onDestory();
}
