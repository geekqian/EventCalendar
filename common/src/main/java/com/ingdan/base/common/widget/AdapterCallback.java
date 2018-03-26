package com.ingdan.base.common.widget;

/**
 * Created by geekDavid
 * 描述：adapter更新数据的回调接口
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */
public interface AdapterCallback<Data> {
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}
