package com.ingdan.base.common.api;


import com.ingdan.base.common.model.BaseBean;
import com.ingdan.base.common.utils.CenterToast;

import io.reactivex.functions.Function;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: 模型基类
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class HttpResultFunc<T> implements Function<BaseBean<T>, T> {
    @Override
    public T apply(BaseBean<T> tBaseBean) throws Exception {
        if (!tBaseBean.status.equals("1000")) {
            if (tBaseBean.message != null) {
                CenterToast.show(tBaseBean.message);
            }
        }
        return tBaseBean.data;
    }
}
