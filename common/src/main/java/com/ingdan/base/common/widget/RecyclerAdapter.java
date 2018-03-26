package com.ingdan.base.common.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingdan.base.common.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by geekDavid
 * 描述：adapter封装，简化代码，减少冗余，提高复用性
 * 更新者：
 * 创建时间：2018/3/26
 * 更新时间：
 */

public abstract class RecyclerAdapter<Data> extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
        implements AdapterCallback<Data>, View.OnClickListener {

    private List<Data> mList;
    private AdapterListener<Data> linsener;

    public RecyclerAdapter() {
        this(null);
    }

    public RecyclerAdapter(AdapterListener<Data> linsener) {
        this(new ArrayList<>(), linsener);
    }

    public RecyclerAdapter(List<Data> mList, AdapterListener<Data> linsener) {
        this.mList = mList;
        this.linsener = linsener;
    }

    public void setLinsener(AdapterListener<Data> linsener) {
        this.linsener = linsener;
    }

    /**
     * 添加一条数据并刷新该条
     *
     * @param data 泛型数据
     */
    public void add(Data data) {
        if (data != null) {
            mList.add(data);
            notifyItemInserted(mList.size() - 1);
        }
    }

    /**
     * 添加一堆数据到几个并刷新这些数据
     *
     * @param dataList 泛型数据可变参数
     */
    @SafeVarargs
    public final void add(Data... dataList) {
        if (dataList != null && dataList.length > 0) {
            int startPosition = mList.size();
            Collections.addAll(mList, dataList);
            notifyItemRangeInserted(startPosition, mList.size());
        }
    }

    /**
     * 添加数据集合
     *
     * @param datas 数据集合
     */
    public void add(Collection<Data> datas) {
        if (datas != null && datas.size() > 0) {
            int startPosition = mList.size();
            mList.addAll(datas);
            notifyItemRangeChanged(startPosition, mList.size());
        }
    }

    /**
     * 替换集合数据
     *
     * @param datas 数据集合
     */
    public void replace(Collection<Data> datas) {
        clear();
        if (datas != null && datas.size() > 0) {
            mList.addAll(datas);
            notifyDataSetChanged();
        }
    }

    /**
     * 替换集合数据
     *
     * @param data 数据
     * @param pos  指针
     */
    public void replace(Data data, int pos) {
        if (data != null) {
            mList.remove(pos);
            mList.add(pos, data);
            notifyItemChanged(pos);
        }
    }

    /**
     * 新数据替换老数据，例如单选
     *
     * @param newData 新数据
     * @param newpos  新数据位置
     * @param oldData 老数据
     * @param oldPos  老数据位置
     */
    public void replace(Data newData, int newpos, Data oldData, int oldPos) {
        if (newData != null) {
            mList.remove(newpos);
            mList.add(newpos, newData);
            notifyItemChanged(newpos);
        }
        if (oldData != null) {
            mList.remove(oldPos);
            mList.add(oldPos, oldData);
            notifyItemChanged(oldPos);
        }
    }

    @Override
    public void update(Data data, ViewHolder<Data> holder) {
        int pos = holder.getAdapterPosition();
        if (data != null) {
            mList.remove(pos);
            mList.add(pos, data);
            notifyItemChanged(pos);
        }
    }

    /**
     * 清除集合数据
     */
    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, mList.get(position));
    }

    /**
     * 获取布局样式
     *
     * @param position item指针
     * @param data     泛型数据类型
     * @return 布局类型
     */
    protected abstract int getItemViewType(int position, Data data);

    /**
     * 构建ViewHolder由子类实现
     *
     * @param itemView item跟布局
     * @param viewType 布局id
     * @return 相应的ViewHolder
     */
    protected abstract ViewHolder<Data> onCreateViewHolder(View itemView, int viewType);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //获取布局打气筒
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //将布局打入itemView
        View itemView = inflater.inflate(viewType, parent, false);
        //根据子类的方法得到ViewHolder
        ViewHolder holder = onCreateViewHolder(itemView, viewType);
        //进行双向绑定
        itemView.setTag(R.id.recycler_holder_tag, holder);
        //设置点击事件
        itemView.setOnClickListener(this);
        //设置更新回调接口
        holder.callback = this;
        //返回holder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mList != null && mList.size() > 0) {
            Data data = mList.get(position);
            //noinspection unchecked
            holder.bind(data, position);
        }
    }

    @Override
    public int getItemCount() {
        return (mList != null && mList.size() > 0) ? mList.size() : 0;
    }

    @Override
    public void onClick(View v) {
        ViewHolder holder = (ViewHolder) v.getTag(R.id.recycler_holder_tag);
        if (holder != null && linsener != null) {
            linsener.onItemClick(holder, mList.get(holder.getAdapterPosition()));
        }
    }

    /**
     * 我们的自定义监听器
     *
     * @param <Data> 范型
     */
    public interface AdapterListener<Data> {
        // 当Cell点击的时候触发
        void onItemClick(RecyclerAdapter.ViewHolder holder, Data data);

        // 当Cell长按时触发
        void onItemLongClick(RecyclerAdapter.ViewHolder holder, Data data);
    }

    /**
     * 实现自定义监听器
     *
     * @param <Data> 范型
     */
    public static class AdapterListenerImpl<Data> implements AdapterListener<Data> {
        // 当Cell点击的时候触发
        @Override
        public void onItemClick(ViewHolder holder, Data data) {

        }

        // 当Cell长按时触发
        @Override
        public void onItemLongClick(ViewHolder holder, Data data) {

        }
    }


    public abstract static class ViewHolder<Data> extends RecyclerView.ViewHolder {

        private AdapterCallback<Data> callback;
        protected Data mData;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        /**
         * 对数据进行绑定
         *
         * @param data 数据泛型
         */
        void bind(Data data, int position) {
            this.mData = data;
            onBind(data, position);
        }

        /**
         * 绑定回调有子类实现
         *
         * @param data 数据泛型
         */
        protected abstract void onBind(Data data, int position);

        /**
         * 刷新数据
         *
         * @param data 数据泛型
         */
        public void updateData(Data data) {
            if (this.callback != null) {
                this.callback.update(data, this);
            }
        }


    }
}
